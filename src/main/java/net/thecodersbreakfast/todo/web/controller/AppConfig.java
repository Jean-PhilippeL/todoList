package net.thecodersbreakfast.todo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class AppConfig {

    /*
     * Factory bean that creates the com.mongodb.Mongo instance
     */
     public @Bean MongoFactoryBean mongo() {
          MongoFactoryBean mongo = new MongoFactoryBean();
          mongo.setHost("ds033477.mongolab.com");
          mongo.setPort(33477);
          return mongo;
     }
     
     
     private @Autowired Mongo mongo;
     
     public @Bean MongoOperations mongoOperations() {
    	 UserCredentials credentials = new UserCredentials("todouser", "todopwd");
		return new MongoTemplate(mongo, "tododb", credentials );
     }
     
     
     public  @Bean String test(){
    	 return "cool ca marche avec mehdi !";
     }
}
