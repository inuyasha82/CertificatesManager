package org.certificatesmanager.listeners;

import org.certificatesmanager.Components;
import org.certificatesmanager.guicomponents.CertificateDetails;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class TableItemListener implements Listener {
	
	private Components components;
	private Table curTable;
	
	private Shell shell;

	public TableItemListener(Shell shell, Components components) {
		this.components = components;
		this.curTable = components.getAliasTable();
		this.shell = shell;
	}

	@Override
	public void handleEvent(Event arg0) {
		TableItem[] item = curTable.getSelection();
		int numColumn = curTable.getColumnCount();
		System.out.println(item.length);				
		String[] dataArray = new String[numColumn];
		for(int i=0; i<numColumn; i++){ 
			System.out.print(item[0].getText(i) + " ");			
		}
		dataArray[0] = item[0].getText(0);
		dataArray[1] = item[0].getText(3);
		dataArray[2] = item[0].getText(2);
		CertificateDetails detailsWindow = new CertificateDetails(shell, dataArray);
		detailsWindow.open();		
	}

}
