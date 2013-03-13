package net.thecodersbreakfast.todo.web.controller;

import net.thecodersbreakfast.todo.model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

/**
 * @author Olivier Croisier
 */
@Controller
public class TodoController {

	private	@Autowired MongoOperations mongoOperations;
	

	@RequestMapping(value = "/todo", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Todo> list() {
		return mongoOperations.findAll(Todo.class);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Todo getById(@PathVariable String id) {
		return mongoOperations.findById(id, Todo.class);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(@RequestBody Todo todo) {
		mongoOperations.save(todo);		
	}

	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		mongoOperations.remove(mongoOperations.findById(id, Todo.class));
	}

	
	
}
