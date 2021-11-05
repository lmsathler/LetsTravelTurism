package api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import entity.FormPayment;
import entity.Payment;
import entity.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
	private String id;
	private Double value;
	private LocalDate datePayment;
	private StatusPayment statusPayment;
	private FormPayment formPayment;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public PaymentDTO(Payment p) {
		this.setId(p.getId());
		this.setValue(p.getValue());
		this.setDatePayment(p.getDatePayment());
		this.setStatusPayment(p.getStatusPayment());
		this.setFormPayment(p.getFormPayment());
		this.setCreatedAt(p.getCreatedAt());
		this.setModifiedAt(p.getModifiedAt());
	}
}
