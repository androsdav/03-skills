package com.adidyk;

import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Class ConsumerControllerClient.
 */
public class ConsumerControllerClient {

    /**
     * @param restTemplate - rest template.
     */
    private final RestTemplate restTemplate;

    /**
     * consumerControllerClient - constructor.
     * @param restTemplate - rest template.
     */
    public ConsumerControllerClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * getEmployee - get employee.
     * @throws RestClientException - rest client exception.
     */
    public void getEmployee() throws RestClientException {
        ResponseEntity<String> response = null;
        try{
            response = this.restTemplate.exchange("http://localhost:8081/employee", HttpMethod.GET, getHeaders(), String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        assert response != null;
        System.out.println(response.getBody());
    }

    /**
     * getHeaders - get headers.
     * @return - returns headers.
     */
    private static HttpEntity<?> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}