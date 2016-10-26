package com.perficient.workshop.talon.core.data;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import com.adobe.cq.sightly.WCMUse;

public class GetUrl extends WCMUse	 {
	Logger log = Logger.getLogger(GetUrl.class.getName());
	@Override
	public void activate() throws Exception {

	}

	public Map<String, String> getVanityPaths() {
		Map<String, String> map = new HashMap<String, String>();

		String[] strs = getProperties().get("definitions", new String[] {});

		for (String str : strs) {
			try {
				JSONObject obj = new JSONObject(str);
				map.put(obj.getString("term"), obj.getString("definition"));
			} catch (JSONException e) {
				log.log(Level.INFO, e.getMessage());
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public Map<String, String> getNavigate() {
		Map<String, String> map = new HashMap<String, String>();

		String[] strs = getProperties().get("url", new String[] {});

		for (String str : strs) {
			try {
				JSONObject obj = new JSONObject(str);
				map.put(obj.getString("term"), obj.getString("definition"));
			} catch (JSONException e) {
				log.log(Level.INFO, e.getMessage());
				e.printStackTrace();
			}
		}
		return map;
	}

}
