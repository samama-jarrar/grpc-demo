package com.example.grpcdemo.service.a;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserGrpcClient {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub stub;

    public UserResponse getUser(Long id) {
        return stub.getUser(
                UserRequest.newBuilder().setId(id).build()
        );
    }
}