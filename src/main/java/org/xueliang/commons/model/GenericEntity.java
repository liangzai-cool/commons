package org.xueliang.commons.model;

import java.io.Serializable;

import org.json.JSONObject;


public class GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected JSONObject toJSONObject() {
		return new JSONObject(this);
	}
	
	@Override
	public String toString() {
		return toJSONObject().toString();
	}
}
