package com.example.finalnewsapp.model.SourceResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SourceResponse{

	@SerializedName("status")
	public String status;

	@SerializedName("articles")
	public String articles;

	@SerializedName("sources")
	private List<SourcesItem> sources;

	@SerializedName("message")
	private String message;

	public void setSources(List<SourcesItem> sources){
		this.sources = sources;
	}

	public List<SourcesItem> getSources(){
		return sources;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"SourceResponse{" + 
			"sources = '" + sources + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}