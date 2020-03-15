package com.example.finalnewsapp.model.NewsRespnse;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.finalnewsapp.model.SourceResponse.SourcesItem;
import com.google.gson.annotations.SerializedName;

@Entity
public class ArticlesItem{

	public String sourceId ;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId() {
		this.sourceId = source.getId();
	}

	@SerializedName("title")
	public String title;

	@Ignore
	@SerializedName("source")
	public SourcesItem source;

	@SerializedName("urlToImage")
	public String urlToImage;

	@SerializedName("description")
	public String description;

	@PrimaryKey
	@NonNull
	@SerializedName("publishedAt")
	public String publishedAt;

	@SerializedName("author")
	private String author;

	@SerializedName("url")
	private String url;

	@SerializedName("content")
	private String content;

	public void setPublishedAt(String publishedAt){
		this.publishedAt = publishedAt;
	}

	public String getPublishedAt(){
		return publishedAt;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setUrlToImage(String urlToImage){
		this.urlToImage = urlToImage;
	}

	public String getUrlToImage(){
		return urlToImage;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return
			"ArticlesItem{" +
			"publishedAt = '" + publishedAt + '\'' +
			",author = '" + author + '\'' + 
			",urlToImage = '" + urlToImage + '\'' + 
			",description = '" + description + '\'' + 
			//",source = '" + source + '\'' +
			",title = '" + title + '\'' +
			",url = '" + url + '\'' +
			",content = '" + content + '\'' + 
			"}";
		}
}