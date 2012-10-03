package org.zkoss.poc.gazer.ui;

import java.text.DecimalFormat;

import org.zkoss.poc.gazer.data.Analytics;
import org.zkoss.poc.gazer.data.EventInfo;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

public class AnylRenderer implements RowRenderer {

	@Override
	public void render(Row row, Object data, int index) throws Exception {
		Analytics anyl = (Analytics)data;
		DecimalFormat df = new DecimalFormat( "0.00" );
		
		new Label (anyl.getTarget()).setParent(row);
		new Label (anyl.getEvent()).setParent(row);
		new Label (""+anyl.getTimeSum()).setParent(row);
		new Label (df.format(((double)anyl.getTimeSum())/(anyl.getCount()))).setParent(row);
		new Label (""+(anyl.getCount())).setParent(row);
	}
}
