package com.spring.ms.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ms.hrpayroll.entities.Payment;
import com.spring.ms.hrpayroll.entities.Worker;
import com.spring.ms.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient; 
	
	public Payment getPayment(long workerId, int days) {
			
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
