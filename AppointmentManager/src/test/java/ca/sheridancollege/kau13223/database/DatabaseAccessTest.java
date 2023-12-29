package ca.sheridancollege.kau13223.database;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.sheridancollege.kau13223.beans.Appointment;

@SpringBootTest
public class DatabaseAccessTest {

    @Autowired
    private DatabaseAccess da;

    @Test
    public void testInsertAppointmentAndGetList() {
    	//setup
    			int size = da.getAppointmentList().size();       
       

        // Create a new appointment
        Appointment appointment = new Appointment();
        appointment.setFirstName("manpreet");
        appointment.setEmail("mkpabal3737@gmail.com");
        

           //when
      		da.insertAppointment(appointment);
      		
      		//then (the actual test)
      		assertEquals(da.getAppointmentList().size(), ++size);

    }
}


