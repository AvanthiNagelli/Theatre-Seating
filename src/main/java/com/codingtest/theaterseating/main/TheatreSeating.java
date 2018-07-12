package com.codingtest.theaterseating.main;

import java.util.ArrayList;
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
		System.out.println("Layout :" +layout.toString());
		TheatreSeating handleRequests = new TheatreSeating();
		String status = handleRequests.theatreSeatingRequest(layout, ticketRequests);
		System.out.println(status);
		
	}
	
	public String theatreSeatingRequest(StringBuilder layout, StringBuilder ticketRequests) {

		String status = null;
		TheaterSeatingServiceImpl service = new TheaterSeatingServiceImpl();
		TheaterLayout theaterLayout = new TheaterLayout();
		List<TheaterRequest> requests = new ArrayList<TheaterRequest>();
		try {
			if(layout.length() > 0 && ticketRequests.length() > 0) {
			theaterLayout = service.getTheaterLayout(layout.toString());
			requests = service.getTicketRequests(ticketRequests.toString());
			status = service.processTicketRequests(theaterLayout, requests);
			} else {
				status = "Invalid Request Received";
			}
			
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		} catch (IndexOutOfBoundsException ibe) {
			System.out.println(ibe.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
