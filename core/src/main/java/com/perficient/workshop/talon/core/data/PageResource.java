package com.perficient.workshop.talon.core.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;

public class PageResource extends WCMUse {

	private String pathURL;

	private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

	@Override
	public void activate() throws Exception {
		this.pathURL = this.get("pathURL", String.class);

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"======"+this.pathURL);
		
		Page page = getResourceResolver().getResource(this.pathURL).adaptTo(Page.class);
		Iterator<Page> iterator = page.listChildren();
		while (iterator.hasNext()) {
			Page p = iterator.next();
			map.put(p.getName(), p.getPath());
		}
	}

	public Map<String, String> getChildrens() {
		return this.map;
	}
}
