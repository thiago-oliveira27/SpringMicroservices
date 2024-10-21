package com.spring.ms.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ms.hrworker.entities.Worker;
import com.spring.ms.hrworker.services.WorkerService;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService workerService;
	
	@GetMapping(value="/configs")
	public ResponseEntity<Void> getServerConfigs(){
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workerList = workerService.findAll();
		return ResponseEntity.ok(workerList);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
	
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = workerService.findById(id);
		return ResponseEntity.ok(worker);
	}
}
