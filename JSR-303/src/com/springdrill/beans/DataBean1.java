package com.springdrill.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class DataBean1 {
	
	@AssertTrue //true가 아닌 값이 들어오면 오류
	private boolean data1;
	
	@AssertFalse
	private boolean data2;
	
	@Max(100)
	@Min(10)
	private String data3;
	
	
	public DataBean1() {
		this.data1 = true;
		this.data2 = false;
		this.data3 = "50";
	}

	public boolean isData1() {
		return data1;
	}

	public void setData1(boolean data1) {
		this.data1 = data1;
	}

	public boolean isData2() {
		return data2;
	}

	public void setData2(boolean data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}
	
	
	

	
}
