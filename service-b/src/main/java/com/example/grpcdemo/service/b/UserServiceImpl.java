package com.example.grpcdemo.service.b;

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