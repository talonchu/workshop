package com.perficient.workshop.talon.core.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.Page;

public class PageResource extends WCMUse {

	private String pathURL;

	private Map<String, String> map = new HashMap<String, String>();

	@Override
	public void activate() throws Exception {
		this.pathURL = this.get("pathURL", String.class);

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
