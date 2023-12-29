package ca.sheridancollege.kau13223.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import ca.sheridancollege.kau13223.beans.Appointment;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AppointmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testLoadingIndex() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
	@Test
	public void testLoadingInsertAppointment() throws Exception {
		this.mockMvc.perform(post("/insertAppointment").flashAttr("appointment", new Appointment()))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
	@Test
    public void testEditingAppointmentById() throws Exception {
        Long id = 1L; // Replace with a valid appointment ID from your database
        this.mockMvc.perform(get("/editAppointmentById/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testDeletingAppointmentById() throws Exception {
        Long id = 1L; // Replace with a valid appointment ID from your database
        this.mockMvc.perform(get("/deleteAppointmentById/" + id))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
	
}
