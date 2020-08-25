package com.base.common;

import java.util.ArrayList;
import java.util.List;

public class ErrorId {
	public enum Severity
	{
		FATAL, ERROR,WARNING;
	}

	public enum HintType
	{
		TEXT,LINK;
	}

	private String errorCode;
	private String errorMessage;
	private Severity severity = Severity.ERROR;
	private HintType hintType = HintType.TEXT;

	public static ErrorId getNewError(ErrorId errorIdCode) {
		return new ErrorId(errorIdCode.getErrorCode(),errorIdCode.getErrorMessage());
	}

	private List<ErrorHint> hints =new ArrayList<ErrorId.ErrorHint>();

	public ErrorId()
	{}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getSeverity()
	{
		return severity.name();
	}

	public String getHintType() {
		return hintType.name();
	}

	public List<ErrorHint> getHints() {
		return hints;
	}

	public ErrorId setHints(List<ErrorHint> hints) {
		this.hints = hints;
		return this;
	}

	public ErrorId setHint(String key, String value) {
		this.hints.add(new ErrorHint(key, value));
		return this;
	}
	public ErrorId setHint(String key, String value,String hintType) {
		this.hints.add(new ErrorHint(key, value,hintType));
		return this;
	}
	public ErrorId setHint(String key, String value,String hintType,String hintName) {
		this.hints.add(new ErrorHint(key, value,hintType,hintName));
		return this;
	}


	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public ErrorId(String errorCode, String errorMessage, Severity severity) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;	
		this.severity = severity;
	}

	public ErrorId(String errorCode, String errorMessage, Severity severity , List<ErrorId.ErrorHint> hints) {
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;	
		this.severity     = severity;
		this.hints        = hints;
	}

	public ErrorId(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;	
	}

	public ErrorId(String errorCode, String errorMessage, List<ErrorId.ErrorHint> hints) {
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;	
		this.hints        = hints;
	}

	public static class ErrorHint{
		private String hintKey;
		private String hintValue;
		private String hintType = HintType.TEXT.name();
		private String hintName;

		public String getHintName() {
			return hintName;
		}
		public void setHintName(String hintName) {
			this.hintName = hintName;
		}
		public String getHintType() {
			return hintType;
		}
		public void setHintType(String hintType) {
			this.hintType = hintType;
		}
		public String getHintKey() {
			return hintKey;
		}
		public void setHintKey(String hintKey) {
			this.hintKey = hintKey;
		}
		public String getHintValue() {
			return hintValue;
		}
		public void setHintValue(String hintValue) {
			this.hintValue = hintValue;
		}	

		public ErrorHint(){

		}

		public ErrorHint(String hintKey, String hintValue){
			this.hintKey = hintKey;
			this.hintValue = hintValue;
		}
		public ErrorHint(String hintKey, String hintValue,String hintType){
			this.hintKey = hintKey;
			this.hintValue = hintValue;
			this.hintType = hintType;
		}
		public ErrorHint(String hintKey, String hintValue,String hintType,String hintName){
			this.hintKey = hintKey;
			this.hintValue = hintValue;
			this.hintType = hintType;
			this.hintName = hintName;
		}
	}
}
