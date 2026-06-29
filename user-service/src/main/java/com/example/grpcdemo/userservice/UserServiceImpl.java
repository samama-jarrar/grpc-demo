package com.example.grpcdemo.userservice;

import com.example.grpc.UserRequest;
import com.example.grpc.UserResponse;
import com.example.grpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUser(UserRequest request,
                        StreamObserver<UserResponse> responseObserver) {

        UserResponse response = UserResponse.newBuilder()
                .setId(request.getId())
                .setName("User-" + request.getId())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}