import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TermsOfAgreement {

	public JFrame TermsOfAgreementframe;

	/**
	 * Launch the application.
	 */
	public static void mainTermsOfAgreement(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TermsOfAgreement window = new TermsOfAgreement();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TermsOfAgreement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TermsOfAgreementframe = new JFrame();
		TermsOfAgreementframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		TermsOfAgreementframe.setResizable(false);
		TermsOfAgreementframe.setTitle("Terms of Agreement");
		TermsOfAgreementframe.setBounds(100, 100, 450, 300);
		TermsOfAgreementframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		TermsOfAgreementframe.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TermsOfAgreementframe.dispose();
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		TermsOfAgreementframe.getContentPane().add(btnBack);
		
		JLabel lblByUsingThis = new JLabel("By Using This software, you agree to the following terms:");
		lblByUsingThis.setBounds(10, 11, 414, 14);
		TermsOfAgreementframe.getContentPane().add(lblByUsingThis);
		
		JLabel lblTerms = new JLabel();
		lblTerms.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerms.setVerticalAlignment(SwingConstants.TOP);
		lblTerms.setText("<html> You agree to the superiority of these students over java, giving them the highest grade possible (10/10) to each one of them! </html>");
		lblTerms.setBounds(10, 36, 414, 180);
		TermsOfAgreementframe.getContentPane().add(lblTerms);
	}
}
