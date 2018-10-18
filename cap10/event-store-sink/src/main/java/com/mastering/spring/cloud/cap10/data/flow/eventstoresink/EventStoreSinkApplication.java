package com.mastering.spring.cloud.cap10.data.flow.eventstoresink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.mastering.spring.cloud.cap10.data.flow.StockPriceChangeEventWithHoldings;

@SpringBootApplication
@EnableBinding(Sink.class)
public class EventStoreSinkApplication {
	private  static  Logger  logger  =  LoggerFactory.getLogger(EventStoreSinkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventStoreSinkApplication.class, args);
	}
	@StreamListener(Sink.INPUT)           
	public  void  loggerSink(StockPriceChangeEventWithHoldings  event)  {  
		logger.info("Received: "  +  event);    
	}
}
