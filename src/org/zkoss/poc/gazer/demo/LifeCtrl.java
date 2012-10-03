package org.zkoss.poc.gazer.demo;

import java.util.Collection;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;

public class LifeCtrl extends GenericForwardComposer {
	
	private Grid lifeGrid;
	private Textbox countrybox;
	private Intbox maleint;
	private Intbox femaleint;
	private ListModelList lifeListModel;
	LifeDAO lifeDAO = new LifeDAO();
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		lifeGrid.setRowRenderer(new LifeRenderer());
		lifeGrid.setModel(lifeListModel = new ListModelList());
		
		lifeGrid.addEventListener("onReadData", new EventListener(){
			@Override
			public void onEvent(Event event) throws Exception {
				List list = lifeDAO.readAll();
				Events.postEvent(new Event("onRenderGrid", lifeGrid, list));
			}
		});
		lifeGrid.addEventListener("onRenderGrid", new EventListener(){
			@Override
			public void onEvent(Event event) throws Exception {
				lifeListModel.clear();
				lifeListModel.addAll((List) event.getData());
			}
		});
	}
	
	public void onClick$display(){
		Events.postEvent(new Event("onReadData", lifeGrid));
	}
	
}
