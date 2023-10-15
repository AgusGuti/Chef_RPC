package main.generated.com.moddenuncias.model;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import main.generated.com.moddenuncias.model.HelloRequest;
import main.generated.com.moddenuncias.model.HelloResponse;

@Endpoint
public class HelloService {

    @PayloadRoot(namespace = "http://example.com/", localPart = "HelloRequest")
    @ResponsePayload
    public HelloResponse sayHello(@RequestPayload HelloRequest request) {
        return new HelloResponse("Hola, " + request.getName() + "!");
    }
}

