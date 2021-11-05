package entity;

import java.time.LocalDate;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class PaymentCard extends Payment{
	
	private Integer numberCard;
	private LocalDate validateCard;
	private Integer cvvCard;
	
}