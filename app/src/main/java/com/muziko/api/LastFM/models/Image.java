
package com.muziko.api.LastFM.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Image {

	@SerializedName("#text")
	@Expose
	private String text;
	@SerializedName("size")
	@Expose
	private String size;

	/**
	 * @return The text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text The #text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return The size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size The size
	 */
	public void setSize(String size) {
		this.size = size;
	}

}
