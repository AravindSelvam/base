package com.base.common;


public interface ErrorCodes {
	
	ErrorId INTERNAL_ERROR = new ErrorId("E0001", "Something went wrong. Please try again...");
	
	ErrorId INVALID_FILE_PROCESS_REQUEST = new ErrorId("E0002", "File process request should not be empty");
	
	ErrorId INVALID_PROCESS = new ErrorId("E0003", "Process name should not be empty");
	
	ErrorId INVALID_REFERENCE_ID = new ErrorId("E0004", "Reference Id should not be empty");
	
	ErrorId INVALID_PROCESS_STATUS = new ErrorId("E0005", "Process status should not be empty");
}

