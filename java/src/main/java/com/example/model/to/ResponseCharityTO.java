package com.example.model.to;

import java.io.Serializable;
import java.util.List;

import com.example.model.CharityList;

public class ResponseCharityTO implements Serializable {

	private static final long serialVersionUID = 8848985723664294293L;

	private String code;
	private String msg;
	private List<CharityList> data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<CharityList> getData() {
		return data;
	}

	public void setData(List<CharityList> data) {
		this.data = data;
	}

}
