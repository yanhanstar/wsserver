package org.learnhow.ws.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ws.wsdl.GetCountryRequest;
import ws.wsdl.GetCountryResponse;

/**
 * @author yanh
 * @create 2019/11/28 14:00
 * @description
 */
public class CountryClient extends WebServiceGatewaySupport {
    public static final String URI = "http://localhost:8080/ws";
    public static final String SOAPACTION = "http://learnhow.org/ws/schema/getCountryRequest";

    public GetCountryResponse getCountry(String countryName) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(URI, request,
                new SoapActionCallback(SOAPACTION));

        return response;
    }
}
