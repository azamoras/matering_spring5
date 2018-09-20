package com.mastering.spring.cap8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mastering.spring.cap8.domain.User;



@RepositoryRestResource(collectionResourceRel= "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
	
    List<User>  findByName(String  name); 
    //List<User>  findByName(String  name,  Sort  sort);       
    //List<User>  findByName(String  name,  Pageable  pageable); 
    Long  countByName(String  name);        
    Long  deleteByName(String  name);       
    List<User>  removeByName(String  name);
    
    User  findFirstByName(String  name);  
    User  findTopByName(String  name);     
    List<User>  findTop3ByName(String  name); 
    List<User>  findFirst3ByName(String  name);
    
    @Query("select  u  from  User  u  where u.name =  ?1")    
    List<User>  findUsersByNameUsingQuery(String  name);
    
    @Query("select  u  from  User  u  where u.name =  :name")   
    List<User>  findUsersByNameUsingNamedParameters(@Param("name")  String  name);
    
    List<User>  findUsersWithNameUsingNamedQuery(String  name);//NamedQuery Entity User
    
    @Query(value  =  "SELECT  *  FROM  USERS  WHERE u.name =  ?1", nativeQuery  =  true)      
    List<User>  findUsersByNameNativeQuery(String  name);

}
