package org.zkoss.poc.gazer.ui;

import org.zkoss.poc.gazer.data.EventInfo;
import org.zkoss.poc.util.TimeFormatter;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

public class EventDataRenderer implements RowRenderer {

	@Override
	public void render(Row row, Object data, int index) throws Exception {
		EventInfo eventData = (EventInfo)data;
		new Label (eventData.getTargetCompName()).setParent(row);
		new Label (eventData.getEventName()).setParent(row);
		new Label (""+eventData.getEventProcTime()).setParent(row);
		new Label (eventData.getReqId()).setParent(row);
		new Label (""+TimeFormatter.timeConverter(eventData.getStartProcTime())).setParent(row);
	}
	

}
