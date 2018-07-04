package com.codingtest.theaterseating.service;

import java.util.List;

import com.codingtest.theaterseating.model.TheaterLayout;
import com.codingtest.theaterseating.model.TheaterRequest;


public interface TheaterSeatingService {
    
    TheaterLayout getTheaterLayout(String rawLayout);
    
    List<TheaterRequest> getTicketRequests(String ticketRequests);
    
    String processTicketRequests(TheaterLayout layout, List<TheaterRequest> requests);

}
