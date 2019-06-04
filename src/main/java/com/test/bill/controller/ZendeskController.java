package com.test.bill.controller;



import com.test.bill.modle.SingleTicket;
import com.test.bill.modle.Ticket;
import com.test.bill.service.ZendeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZendeskController {

    @Autowired
    private ZendeskService zendeskService;

    @RequestMapping(value = "/ritashabi",
            method = RequestMethod.GET)
    public ResponseEntity<SingleTicket> serviceIPVPNFirewallCreate() {
        return new ResponseEntity<SingleTicket>(zendeskService.getListOfTickets(), HttpStatus.OK);
    }

}
