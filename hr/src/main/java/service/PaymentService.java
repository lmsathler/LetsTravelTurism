package service;

import java.time.LocalDateTime;
import java.util.List;

import entity.Payment;
import exception.NotFoundException;
import repository.PaymentRepository;

public class PaymentService {
	private PaymentRepository paymentRepository;
	
	public Payment create(Payment p) {
		var now = LocalDateTime.now();
		
		p.setCreatedAt(now);
		
		paymentRepository.save(p);
		
		return p;
	}
	
	public Payment update(String id, Payment p) {
		var existing = get(id);
		
		existing.setValue(p.getValue());
		existing.setDatePayment(p.getDatePayment());
		existing.setStatusPayment(p.getStatusPayment());
		existing.setFormPayment(p.getFormPayment());
		existing.setValue(p.getValue());
		
		existing.setModifiedAt(LocalDateTime.now());
		
		paymentRepository.save(existing);
		
		return existing;
	}
	
	public Payment get(String id) {
		var payment = paymentRepository.findById(id);
		
		if (payment.isEmpty()) {
			throw new NotFoundException("Pagamento " + id + " nao encontrado!");
		}
		
		return payment.get();
	}
	
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		paymentRepository.deleteById(id);
	}
}
