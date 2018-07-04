package com.codingtest.theaterseating.main;

import java.util.List;
import java.util.Scanner;

import com.codingtest.theaterseating.model.TheaterLayout;
import com.codingtest.theaterseating.model.TheaterRequest;
import com.codingtest.theaterseating.service.TheaterSeatingService;
import com.codingtest.theaterseating.service.TheaterSeatingServiceImpl;

public class TheatreSeating {
	
	public static void main(String[] args) {
		String line;
		boolean isLayoutFinished = false;
		StringBuilder layout = new StringBuilder();
		StringBuilder ticketRequests = new StringBuilder();
		System.out.println("Please enter Theater Layout and Ticket requests and then enter 'done'.\n");

		Scanner input = new Scanner(System.in);
		while ((line = input.nextLine()) != null && !line.equals("done")) {

			if (line.length() == 0) {
				isLayoutFinished = true;
				continue;
			}

			if (!isLayoutFinished) {
				layout.append(line + System.lineSeparator());
			} else {
				ticketRequests.append(line + System.lineSeparator());
			}
		}
		input.close();
		System.out.println("LAout :" +layout.toString());
		TheatreSeating handleRequests = new TheatreSeating();
		String status = handleRequests.theatreSeatingRequest(layout, ticketRequests);
		System.out.println(status);
		
	}
	
	public String theatreSeatingRequest(StringBuilder layout, StringBuilder ticketRequests) {

		String status = null;
		TheaterSeatingServiceImpl service = new TheaterSeatingServiceImpl();
		try {
			TheaterLayout theaterLayout = service.getTheaterLayout(layout.toString());
			List<TheaterRequest> requests = service.getTicketRequests(ticketRequests.toString());
			status = service.processTicketRequests(theaterLayout, requests);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
