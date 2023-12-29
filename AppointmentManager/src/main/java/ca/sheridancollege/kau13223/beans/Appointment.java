package ca.sheridancollege.kau13223.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Appointment {
	
	private Long id;
	private String firstName;
	private String email;
	@DateTimeFormat
	private LocalDate appointmentDate;
	@DateTimeFormat
	private LocalTime appointmentTime;
	

}
