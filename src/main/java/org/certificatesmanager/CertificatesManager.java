package org.certificatesmanager;

import org.certificatesmanager.listeners.MenuItemListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class CertificatesManager {

	protected Shell shlCertificatesmanager;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CertificatesManager window = new CertificatesManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCertificatesmanager.open();
		shlCertificatesmanager.layout();
		while (!shlCertificatesmanager.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {		
		shlCertificatesmanager = new Shell(Display.getDefault());
		shlCertificatesmanager.setSize(573, 300);
		shlCertificatesmanager.setText("CertificatesManager");
		
		Components components = new Components(shlCertificatesmanager);
		
		MenuItemListener menuListener = new MenuItemListener(shlCertificatesmanager, components);
		shlCertificatesmanager.setLayout(new FormLayout());
				
		Menu menu = new Menu(shlCertificatesmanager, SWT.BAR);		
		components.setMenu(menu);		
		shlCertificatesmanager.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("File");		
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmOpenCertificate = new MenuItem(menu_1, SWT.NONE);
		mntmOpenCertificate.setText("Open Certificate");
		mntmOpenCertificate.addSelectionListener(menuListener);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(menuListener);
		mntmExit.setText("Exit");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);		
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmAbout = new MenuItem(menu_2, SWT.NONE);
		mntmAbout.setText("About");
		
		Label lblAliasName = new Label(shlCertificatesmanager, SWT.NONE);
		FormData fd_lblAliasName = new FormData();
		fd_lblAliasName.top = new FormAttachment(0, 3);
		fd_lblAliasName.left = new FormAttachment(0, 3);
		lblAliasName.setLayoutData(fd_lblAliasName);
		lblAliasName.setText("Alias name: ");
		
		Label label = new Label(shlCertificatesmanager, SWT.NONE);
		FormData fd_label = new FormData();
		fd_label.top = new FormAttachment(0, 3);
		fd_label.left = new FormAttachment(0, 70);
		label.setLayoutData(fd_label);
		components.setAliasname(label);
		label.setText("___________");
		
		table = new Table(shlCertificatesmanager, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		components.setAliasTable(table);
		FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(lblAliasName, 216, SWT.BOTTOM);
		fd_table.top = new FormAttachment(lblAliasName, 33);
		fd_table.left = new FormAttachment(lblAliasName, 0, SWT.LEFT);
		table.setLayoutData(fd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnAlias = new TableColumn(table, SWT.NONE);
		tblclmnAlias.setWidth(100);
		tblclmnAlias.setText("Alias");
		
		TableColumn tblclmnStartDate = new TableColumn(table, SWT.NONE);
		tblclmnStartDate.setWidth(100);
		tblclmnStartDate.setText("Start Date");
		
		TableColumn tblclmnEndDate = new TableColumn(table, SWT.NONE);
		tblclmnEndDate.setWidth(100);
		tblclmnEndDate.setText("End Date");
		
		TableColumn tblclmnIssuer = new TableColumn(table, SWT.NONE);
		tblclmnIssuer.setWidth(100);
		tblclmnIssuer.setText("Issuer");
		
		TableColumn tblclmnAlgorithm = new TableColumn(table, SWT.NONE);
		tblclmnAlgorithm.setWidth(100);
		tblclmnAlgorithm.setText("Algorithm");
		mntmAbout.addSelectionListener(menuListener);
	}
}
