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
	
	@Test
	public void UnhappyPathtestingWithNullLayout() {
		TheatreSeating service = new TheatreSeating();
		String status = service.theatreSeatingRequest(mockNullLayout(), mockTicketRequests());
		assertNotNull(status);
		assertTrue("Invalid Request Received".equalsIgnoreCase(status));
	}
	
	@Test
	public void UnhappyPathtestingWithNullTicketRequests() {
		TheatreSeating service = new TheatreSeating();
		String status = service.theatreSeatingRequest(mockLayout(), mockNullTicketRequests());
		assertNotNull(status);
		assertTrue("Invalid Request Received".equalsIgnoreCase(status));
	}
	
	@Test
	public void UnhappyPathtestingWithEmptyRequest() {
		TheatreSeating service = new TheatreSeating();
		String status = service.theatreSeatingRequest(mockNullLayout(), mockNullTicketRequests());
		assertNotNull(status);
		assertTrue("Invalid Request Received".equalsIgnoreCase(status));
	}

	@Test
	public void UnhappyPathtestingTicktRequestsNFE() throws IndexOutOfBoundsException {
		TheatreSeating service = new TheatreSeating();
		StringBuilder ticketRequests = new StringBuilder();
		ticketRequests.append("Smith s2");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Jones 5");
		String status = service.theatreSeatingRequest(mockLayout(), ticketRequests);
		assertNull(status);
	}
	
	@Test
	public void UnhappyPathtestingTicketRequestsIBE() throws IndexOutOfBoundsException {
		TheatreSeating service = new TheatreSeating();
		StringBuilder ticketRequests = new StringBuilder();
		ticketRequests.append("Smith");
		ticketRequests.append(System.getProperty("line.separator"));
		ticketRequests.append("Jones 5");
		String status = service.theatreSeatingRequest(mockLayout(), ticketRequests);
		assertNull(status);
	}
	
	@Test
	public void UnhappyPathtestingLayoutNFE() throws IndexOutOfBoundsException {
		TheatreSeating service = new TheatreSeating();
		StringBuilder layout = new StringBuilder();
		layout.append("6a 6");
		layout.append(System.getProperty("line.separator"));
		layout.append("3 5 5 3");
		String status = service.theatreSeatingRequest(layout, mockTicketRequests());
		assertNull(status);
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
	
	public StringBuilder mockNullLayout() {
		StringBuilder layout = new StringBuilder();
		
		return layout;
	}
	
	public StringBuilder mockNullTicketRequests() {
		StringBuilder ticketRequests = new StringBuilder();
		
		return ticketRequests;
	}

}
