package org.learnhow.ws.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ws.wsdl.GetUserRequest;
import ws.wsdl.GetUserResponse;

/**
 * @author yanh
 * @create 2019/11/28 14:00
 * @description
 */
public class UserClient extends WebServiceGatewaySupport {
    public static final String URI = "http://localhost:8080/ws";
    public static final String SOAPACTION = "http://learnhow.org/ws/schema/getUserRequest";

    public GetUserResponse getUser(String userName) {
        GetUserRequest request = new GetUserRequest();
        request.setName(userName);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(URI, request,
                new SoapActionCallback(SOAPACTION));

        return response;
    }
}
