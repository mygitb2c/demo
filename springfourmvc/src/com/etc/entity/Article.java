package com.etc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;


@Component("article")
public class Article {
	@JsonProperty("ARTICLEID")
	private int ARTICLEID;
	@JsonProperty("ARTICLETITLE")
	private String ARTICLETITLE;
	@JsonProperty("ARTICLEAUTHOR")
	private String ARTICLEAUTHOR;
	@JsonProperty("ARTICLECONTENT")
	private String ARTICLECONTENT;
	@JsonProperty("ARTICLEDATE")
	private String ARTICLEDATE;
	public int getARTICLEID() {
		return ARTICLEID;
	}
	public void setARTICLEID(int aRTICLEID) {

		ARTICLEID = aRTICLEID;
	}
	public String getARTICLETITLE() {
		return ARTICLETITLE;
	}
	public void setARTICLETITLE(String aRTICLETITLE) {
	
		ARTICLETITLE = aRTICLETITLE;
	}
	public String getARTICLEAUTHOR() {
		return ARTICLEAUTHOR;
	}
	public void setARTICLEAUTHOR(String aRTICLEAUTHOR) {
		
		ARTICLEAUTHOR = aRTICLEAUTHOR;
	}
	public String getARTICLECONTENT() {
		return ARTICLECONTENT;
	}
	public void setARTICLECONTENT(String aRTICLECONTENT) {
		
		ARTICLECONTENT = aRTICLECONTENT;
	}
	
	public Article() {
		// TODO Auto-generated constructor stub
	
	}
	public String getARTICLEDATE() {
		return ARTICLEDATE;
	}
	public void setARTICLEDATE(String aRTICLEDATE) {
		
		ARTICLEDATE = aRTICLEDATE;
	}
	
	public Article(int aRTICLEID, String aRTICLETITLE, String aRTICLEAUTHOR, String aRTICLECONTENT,
			String aRTICLEDATE) {
		
		ARTICLEID = aRTICLEID;
		ARTICLETITLE = aRTICLETITLE;
		ARTICLEAUTHOR = aRTICLEAUTHOR;
		ARTICLECONTENT = aRTICLECONTENT;
		ARTICLEDATE = aRTICLEDATE;
	}
	@Override
	public String toString() {
		return "Article [ARTICLEID=" + ARTICLEID + ", ARTICLETITLE=" + ARTICLETITLE + ", ARTICLEAUTHOR=" + ARTICLEAUTHOR
				+ ", ARTICLECONTENT=" + ARTICLECONTENT + ", ARTICLEDATE=" + ARTICLEDATE + "]";
	}
	
	
	
	
	
	

}
