package com.example.userservice;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        switch(response.status()) {
            case 404:
                if(methodKey.contains("teams")) {
                    //return new UserNotEnrolledTeamException("사용자는 팀에 가입되어있지 않습니다.");
                }
        }

        return null;
    }
}