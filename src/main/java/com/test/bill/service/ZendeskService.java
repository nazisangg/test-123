package com.test.bill.service;

import com.test.bill.modle.SingleTicket;
import com.test.bill.modle.Ticket;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

@Service

public class ZendeskService {

    @Autowired
    private RestTemplate restTemplate;


    public SingleTicket getListOfTickets(){
        HttpHeaders httpHeaders = createHeaders();
        HttpEntity requestEntity = new HttpEntity(
                httpHeaders);

        String getCustomMCAUri = "https://rei.zendesk.com/api/v2/tickets/1";
        ResponseEntity<SingleTicket> responseEntity;
        try {
            responseEntity =
                    restTemplate
                            .exchange(getCustomMCAUri, HttpMethod.GET, requestEntity, SingleTicket.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        return responseEntity.getBody();
    }


    HttpHeaders createHeaders(){
        return new HttpHeaders() {{
            String auth = "zmnwrs@gmail.com" + ":" + "zmnwrs911017";

            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes());
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}
