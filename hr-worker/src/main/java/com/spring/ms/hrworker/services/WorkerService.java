package com.spring.ms.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ms.hrworker.entities.Worker;
import com.spring.ms.hrworker.exceptions.WorkerNotFoundException;
import com.spring.ms.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	public WorkerRepository workerRepo;
	
	public List<Worker> findAll(){
		return workerRepo.findAll();
	}
	
	public Worker findById(Long id) {
		Optional<Worker> worker = workerRepo.findById(id);
		return worker.orElseThrow(() -> new WorkerNotFoundException("Worker not found"));
	}
}
