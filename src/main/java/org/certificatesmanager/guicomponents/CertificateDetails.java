package org.certificatesmanager.guicomponents;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class CertificateDetails {

	protected Shell shlCertificateDetails;
	private String[] keyData;

	
	public CertificateDetails(Shell shell, String[] data){
		System.out.println(data.toString());
		this.shlCertificateDetails = shell;
		this.keyData = data;
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();		
		shlCertificateDetails.open();
		shlCertificateDetails.layout();
		while (!shlCertificateDetails.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCertificateDetails = new Shell(Display.getDefault());
		shlCertificateDetails.setSize(450, 300);
		shlCertificateDetails.setText("Certificate Details");
		
		Label lblKeyName = new Label(shlCertificateDetails, SWT.NONE);
		lblKeyName.setBounds(24, 29, 65, 15);
		lblKeyName.setText("Key Name: ");
		
		Label label = new Label(shlCertificateDetails, SWT.WRAP);
		label.setBounds(264, 29, 159, 15);				
		
		Label lblCreator = new Label(shlCertificateDetails, SWT.NONE);
		lblCreator.setBounds(24, 69, 69, 15);
		lblCreator.setText("Creator");
		
		Label lblNewLabel = new Label(shlCertificateDetails, SWT.NONE);
		lblNewLabel.setBounds(264, 69, 159, 15);
		if(keyData!=null){
			label.setText(keyData[0]);
			lblNewLabel.setText(keyData[1]);
		}

	}
}
