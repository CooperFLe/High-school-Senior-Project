import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class GUI extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6411499808530678723L;


	public GUI(JFrame p)
	{
		super(p);
		addWindowListener(new OnClose());
		//setSize(350,105);
		setContentPane(new EmailLayout());
		setTitle("Time Sheet");
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);		
		//System.out.print(getSize());
	}
	
	public void verifyEmail(String email)
	{
		
	}
	 
	class EmailLayout extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8401792691722981275L;
		private JLabel label;
		private JTextField input;
		private JButton buttonOne;
		private JButton buttonTwo;
		public EmailLayout()
		{
			addWindowListener(new OnClose());
			setLayout(new MigLayout("fill, wrap 2"));
			label = new JLabel("Email: \n");
				add(label, "growx, span 2");
			input = new JTextField("example@example.com");
				add(input, "growx, span 2");
			buttonOne = new JButton();
				buttonOne.addActionListener(new ButtonOneAction());
				buttonOne.setText("Confirm");
				add(buttonOne,"growx");
			buttonTwo = new JButton();
			buttonTwo.addActionListener(new ButtonTwoAction());
			buttonTwo.setText("Cancel");
			add(buttonTwo,"growx");				
		}
		
		class ButtonOneAction implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				verifyEmail(input.getText());
			}			
		}
		
		class ButtonTwoAction implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
			
		}
	}
	
	public void closeParent()
	{
		
	}
	
	class OnClose implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent arg0) {
						
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			closeParent();			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
					
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
				
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
				
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			
		}
		
	}
}
