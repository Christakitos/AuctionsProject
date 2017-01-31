import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class About {

	public JFrame Aboutframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//About wAbout = new About();
					//wAbout.Aboutframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Aboutframe = new JFrame();
		Aboutframe.setTitle("About us");
		Aboutframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\AuctionsSetupFiles\\imgs\\Main image.jpg"));
		Aboutframe.setResizable(false);
		Aboutframe.setBounds(100, 100, 232, 213);
		Aboutframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Aboutframe.getContentPane().setLayout(null);
		
		JLabel lblThisSoftwareIs = new JLabel("<html>This software is developed from students from Piraeus University of Applied sciences for the laboratory subject \"Software Engineering\". \r\nThe students are:\r\n1) Stamatios Tsachtsiris 43875\r\n2)\r\n3)\r\n </html>");
		lblThisSoftwareIs.setBounds(10, 11, 196, 110);

		Aboutframe.getContentPane().add(lblThisSoftwareIs);
		
		JButton btnBack = new JButton("Close");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aboutframe.dispose();
			}
		});
		btnBack.setBounds(117, 140, 89, 23);
		Aboutframe.getContentPane().add(btnBack);
	}

}
