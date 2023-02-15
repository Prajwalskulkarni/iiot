package com.beauto.iiotconnx.dto;



import java.io.Serializable;

public class OutputDto<T> implements Serializable {


	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "OutputDTO [responseData=" + responseData + "]";
	}

	private T responseData;

	/**
	 * @return the responseData
	 */
	public T getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}	
	
}
