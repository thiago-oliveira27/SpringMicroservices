package com.spring.ms.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.spring.ms.hrpayroll.entities.Payment;
import com.spring.ms.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
//	@Autowired
//	private WorkerFeignClient workerFeignClient;
//
	public Payment getPayment(long workerId, int days) {
				
		//Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment("Bob", 175.0, days);
	}
}
