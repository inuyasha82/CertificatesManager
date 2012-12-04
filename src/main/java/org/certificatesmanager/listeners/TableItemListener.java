package org.certificatesmanager.listeners;

import org.certificatesmanager.Components;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class TableItemListener implements Listener {
	
	private Components components;
	private Table curTable;

	public TableItemListener(Components components) {
		this.components = components;
		this.curTable = components.getAliasTable();
	}

	@Override
	public void handleEvent(Event arg0) {
		TableItem[] item = curTable.getSelection();
		int numColumn = curTable.getColumnCount();
		System.out.println(item.length);				
		for(int i=0; i<numColumn; i++){ 
			System.out.print(item[0].getText(i) + " ");
		}
		System.out.println();
	}

}
