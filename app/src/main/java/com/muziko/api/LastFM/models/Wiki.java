
package com.muziko.api.LastFM.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Wiki {

	@SerializedName("published")
	@Expose
	private String published;
	@SerializedName("summary")
	@Expose
	private String summary;
	@SerializedName("content")
	@Expose
	private String content;

	/**
	 * @return The published
	 */
	public String getPublished() {
		return published;
	}

	/**
	 * @param published The published
	 */
	public void setPublished(String published) {
		this.published = published;
	}

	/**
	 * @return The summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary The summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return The content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content The content
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
