package org.learnhow.ws.server;

import org.learnhow.ws.schema.GetUserRequest;
import org.learnhow.ws.schema.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author yanh
 * @create 2019/11/26 18:19
 * @description Endpoint本质上是接收一个request，然后经过你的业务逻辑再返回一个response
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://learnhow.org/ws/schema";
    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userRepository.findUser(request.getName()));
        return response;
    }
}
