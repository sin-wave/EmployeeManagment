package com.pratik.employee.exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private String errorCode;

    private String errorDetails;

//    public ErrorMessage() {
//    }
//
//    public ErrorMessage(String errorCode, String errorDetails) {
//        this.errorCode = errorCode;
//        this.errorDetails = errorDetails;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public String getErrorDetails() {
//        return errorDetails;
//    }
//
//    public void setErrorDetails(String errorDetails) {
//        this.errorDetails = errorDetails;
//    }
//
//    @Override
//    public String toString() {
//        return "ErrorMessage{" +
//                "errorCode='" + errorCode + '\'' +
//                ", errorDetails='" + errorDetails + '\'' +
//                '}';
//    }
}
