package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PaymentBillet extends Payment{
	
	@JsonFormat(pattern="dd/HH/yyyy")
	private LocalDate dateLimit;
	
	@JsonFormat(pattern="dd/HH/yyyy")
	private LocalDate datePayment;
	
	public PaymentBillet() {
	}
	
	public PaymentBillet(String id, Double value, FormPayment formPayment, StatusPayment status, LocalDateTime createdAt, LocalDate dateLimit, LocalDate datePayment) {
		super(id, value, datePayment, status, formPayment, createdAt, createdAt);
		this.dateLimit = dateLimit;
		this.datePayment = datePayment;
	}

	public LocalDate getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(LocalDate dateLimit) {
		this.dateLimit = dateLimit;
	}

	public LocalDate getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(LocalDate datePayment) {
		this.datePayment = datePayment;
	}
	
	
}