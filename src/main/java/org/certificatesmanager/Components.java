package org.certificatesmanager;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

public class Components {
	
	protected Shell shlCertificatesmanager;

	private Menu menu;	
	private Table aliasTable;

	public Table getAliasTable() {
		return aliasTable;
	}

	public void setAliasTable(Table aliasTable) {
		this.aliasTable = aliasTable;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Components(Shell shlCertificatesmanager) {
		this.shlCertificatesmanager = shlCertificatesmanager;
	}


}
