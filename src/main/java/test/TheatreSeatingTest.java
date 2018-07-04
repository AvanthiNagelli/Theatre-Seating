package test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.codingtest.theaterseating.main.TheatreSeating;

public class TheatreSeatingTest {
	

	@Test
	public void HappyPathScenario() {
		TheatreSeating service = new TheatreSeating();
		String status = service.theatreSeatingRequest(mockLayout(), mockTicketRequests());
		assertNotNull(status);
		assertTrue("successfully proccessed the input request".equalsIgnoreCase(status));
	}

	
	public StringBuilder mockLayout() {
		StringBuilder layout = new StringBuilder();
		layout.append("6 6");
		layout.append(System.getProperty("line.separator"));
		layout.append("3 5 5 3");
		layout.append(System.getProperty("line.separator"));
		layout.append("4 6 6 4");
		layout.append(System.getProperty("line.separator"));
		layout.append("2 8 8 2");
		layout.append(System.getProperty("line.separator"));
		layout.append("6 6");
		layout.append(System.getProperty("line.separator"));
		return layout;
	}
	
	public StringBuilder mockTicketRequests() {
		
		StringBuilder ticketRequests = new StringBuilder();
		ticketRequests.append("Smith 2");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Jones 5");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Davis 6");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Wilson 100");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Brown 8");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Miller 12");
		return ticketRequests;
		
	}

}
