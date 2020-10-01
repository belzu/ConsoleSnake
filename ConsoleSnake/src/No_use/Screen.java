package No_use;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Screen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Screen dialog = new Screen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Screen() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 434, 228);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 224, 434, 37);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnA = new JButton("a");
			btnA.setBounds(10, 11, 89, 23);
			buttonPane.add(btnA);
			
			JButton btnS = new JButton("s");
			btnS.setBounds(111, 11, 89, 23);
			buttonPane.add(btnS);
			
			JButton btnNewButton = new JButton("w");
			btnNewButton.setBounds(236, 11, 89, 23);
			buttonPane.add(btnNewButton);
			
			JButton btnD = new JButton("d");
			btnD.setBounds(335, 11, 89, 23);
			buttonPane.add(btnD);
		}
	}
}
