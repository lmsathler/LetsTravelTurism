package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.PaymentDTO;
import entity.Payment;
import lombok.AllArgsConstructor;
import service.PaymentService;

@RestController
@AllArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;

	@GetMapping("/payments/{id}")
	public PaymentDTO getByID(@PathVariable String id) {
		var payment = paymentService.get(id);

		return new PaymentDTO(payment);
	}

	@GetMapping("/payments")
	public List<PaymentDTO> getAll() {
		var payments = paymentService.getAll();

		var paymentDtos = new ArrayList<PaymentDTO>();

		for (var payment : payments) {
			paymentDtos.add(new PaymentDTO(payment));
		}

		return paymentDtos;
	}

	@PostMapping("/payments")
	public PaymentDTO create(@RequestBody PaymentDTO paymentDto) {
		var payment = new Payment(paymentDto);

		payment = paymentService.create(payment);

		return new PaymentDTO(payment);
	}

	@PutMapping("/payments/{id}")
	public PaymentDTO create(@PathVariable String id, @RequestBody PaymentDTO paymentDto) {
		var payment = new Payment(paymentDto);

		payment = paymentService.update(id, payment);
		return new PaymentDTO(payment);
	}

	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		paymentService.delete(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
