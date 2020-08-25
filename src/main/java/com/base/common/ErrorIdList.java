package com.base.common;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ErrorIdList {

private List<ErrorId> errorIds = new ArrayList<ErrorId>();
	


	public List<ErrorId> getErrorIds() {
		return this.errorIds;
	}

	public void setErrorList(List<ErrorId> errorList) {
		this.errorIds = errorList;
	}
	
	public void addError(ErrorId errorId){
		this.errorIds.add(errorId);
	}
	
	/**
	 * @param errorList
	 */
	public ErrorIdList(List<ErrorId> errorList) {
		this.errorIds = errorList;
	}
	
	public ErrorIdList(ErrorId errorId) {
		this.errorIds.add(errorId);
	}
	
	public ErrorIdList() {
	}
	
	public String convertToJsonString(){
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			
		}
		return null;
	}
}
