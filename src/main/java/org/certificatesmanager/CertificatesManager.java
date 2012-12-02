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
import org.eclipse.swt.layout.FillLayout;

public class CertificatesManager {

	protected Shell shlCertificatesmanager;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			parseArgs(args);
			System.out.println("SWT Version: " + org.eclipse.swt.SWT.getVersion());
			CertificatesManager window = new CertificatesManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void parseArgs(String[] args) {
		if(args.length>0){
			if(args[0].equals("-v")) {
				System.out.println("Certificates Manager ver 1.0");
				System.exit(0);
			}
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
		shlCertificatesmanager.setLayout(new FillLayout(SWT.HORIZONTAL));
				
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
		
		table = new Table(shlCertificatesmanager, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		components.setAliasTable(table);
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
