package com.example.userservice;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                break;
            case 500:
                if(methodKey.contains("getTeam")){
                	return new Exception("사용자가 속한 팀이 없습니다.");
                }
                break;
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}

