package ca.sheridancollege.kau13223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.kau13223.beans.Appointment;
import ca.sheridancollege.kau13223.database.DatabaseAccess;

@Controller
public class AppointmentController {

	@Autowired
	public DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("appointmentList", da.getAppointmentList());
		model.addAttribute("appointment", new Appointment());
		return "index";
	}

	@PostMapping("/insertAppointment")
	public String insertAppointment(Model model, @ModelAttribute Appointment appointment) {
		da.insertAppointment(appointment);
		model.addAttribute("appointmentList", da.getAppointmentList());
		model.addAttribute("appointment", new Appointment());

		return "index";
	}

	@GetMapping("/editAppointmentById/{id}")
	public String editAppointmentById(Model model, @PathVariable Long id) {
	
		Appointment appointment = da.getAppointmentListById(id).get(0);
		model.addAttribute("appointment", appointment);
		
		da.deleteAppointmentById(id);
		model.addAttribute("appointmentList", da.getAppointmentList());


	return "index";
	}


	@GetMapping("/deleteAppointmentById/{id}")
	public String deleteAppointmentById(Model model, @PathVariable Long id) {

		da.deleteAppointmentById(id);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointmentList());
		
		return "index";
	}

}
