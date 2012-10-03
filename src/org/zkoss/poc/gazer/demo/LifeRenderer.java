package org.zkoss.poc.gazer.demo;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

public class LifeRenderer implements RowRenderer {

	@Override
	public void render(Row row, Object data, int index) throws Exception {
		Life life = (Life)data;
		new Label (life.getCountry()).setParent(row);
		new Label (""+life.getFemaleLife()).setParent(row);
		new Label (""+life.getMaleLife()).setParent(row);
	}

}
