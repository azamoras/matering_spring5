package com.mastering.spring.cloud.cap10.data.flow.stockintelligenceprocessor;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.mastering.spring.cloud.cap10.data.flow.StockPriceChangeEvent;
import com.mastering.spring.cloud.cap10.data.flow.StockPriceChangeEventWithHoldings;
import com.mastering.spring.cloud.cap10.data.flow.StockTicker;

@SpringBootApplication
@EnableBinding(Processor.class)
public class StockIntelligenceProcessorApplication {
	private  static  Logger  logger  =LoggerFactory.getLogger(StockIntelligenceProcessorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StockIntelligenceProcessorApplication.class, args);
	}

	private  static  Map<StockTicker,Integer> holdings=getHoldingsFromDatabase();
	private  static  Map<StockTicker,Integer>  getHoldingsFromDatabase(){
		final  Map<StockTicker,Integer>  holdings=new  HashMap<>();
		holdings.put(StockTicker.FACEBOOK, 10);
		holdings.put(StockTicker.GOOGLE, 0); 
		holdings.put(StockTicker.IBM, 15); 
		holdings.put(StockTicker.MICROSOFT, 30);
		holdings.put(StockTicker.TWITTER, 50);
		return  holdings;
	}
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public  Object  addOurInventory(StockPriceChangeEvent  event)  {
		logger.info("started processing  event  "  +  event);
		Integer  holding  =  holdings.get(StockTicker.valueOf(event.getStockTicker()));
		StockPriceChangeEventWithHoldings  eventWithHoldings  =  new  StockPriceChangeEventWithHoldings(event,  holding);
		logger.info("ended processing  eventWithHoldings  "+  eventWithHoldings); 
		return  eventWithHoldings; 
	}
}
