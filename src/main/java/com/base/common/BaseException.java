package com.base.common;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BaseException extends Exception {
		private ErrorIdList errorIdList = new ErrorIdList();
	
		private static final long serialVersionUID = 676852299677539062L;
		
		public BaseException(){
			super();
		}
		
		public BaseException(String message){
			super(message);
		}
		
		public BaseException(ErrorIdList errorIdList){
			super(errorIdList.convertToJsonString());
			this.errorIdList = errorIdList;		
		}
		
		public BaseException(ErrorId errorId){
			super(new ErrorIdList(errorId).convertToJsonString());
			errorIdList.addError(errorId);
		}
		
		public ErrorId getErrorId(String errorCode) {
			return errorIdList.getErrorIds().stream().filter(e -> e.getErrorCode().equals(errorCode)).findFirst().orElse(null);
			
		}
		
		@Override
		@JsonIgnore
		public StackTraceElement[] getStackTrace() {
			return super.getStackTrace();
		}
		
		public static BaseException getNew(ErrorId errorId) {
			return new BaseException(errorId);
		}
}
