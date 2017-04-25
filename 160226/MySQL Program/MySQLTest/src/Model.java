import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.layout.AC;
import net.miginfocom.swing.MigLayout;

public class Model extends MyFrame
	{
		private JDialog 		panel;
		private Login 			login;
		private static final long serialVersionUID = -1528559031172716327L;

		public Model(Data d)
		{
			buttonOne.setText("Settings");
			buttonTwo.setText("Button Two");
			buttonThree.setText("Button Three");
		}
		
		

		public void ButtonOneAction()
		{
		}

		public void ButtonTwoAction()
		{
			output.append("public void ButtonTwoAction()\n");
			output.append("{\n");
			output.append("}\n");
			output.append("\n");
		}

		public void ButtonThreeAction()
		{
			output.append("public void ButtonThreeAction()\n");
			output.append("{\n");
			output.append("}\n");
			output.append("\n");
		}

		public Login getLogin() {
			return login;
		}

		public void setLogin(Login login) {
			this.login = login;
		}



		public JDialog getPanel() {
			return panel;
		}



		public void setPanel(JDialog panel) {
			this.panel = panel;
		}
	}


	class MyFrame extends JFrame
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 244484697735934756L;
		JTextArea 	output;
		JButton   	buttonOne, buttonTwo, buttonThree;
		JTextField 	input;
		private Dimension 	screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		public MyFrame()
		{
			//setSize(600,350);
			setSize((int)screen.getWidth()/2,(int)screen.getHeight()/2);
			setLocationRelativeTo(null);
	  		setDefaultCloseOperation(3);
	  		AC col = new AC();
	  		col.size(""+(int)screen.getWidth()/2+"px");
	  		AC row = new AC();
	  		row.size(""+(int)screen.getHeight()/2+"px");
			setContentPane( new MyPanel(col, row) );
			setVisible(true);
		}

		class MyPanel extends JPanel
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = -2183330420207592925L;

			MyPanel(AC col, AC row)
			{
				super(new MigLayout("fillx,wrap 4"));
	   			setBackground(new Color(125,140,115));
	   			//setLayout(null);
				output = new JTextArea();
					output.setRows((int)(screen.getHeight()/15));
					//output.setColumns(80);
					//output.setSize((int)(screen.getWidth()*.75),(int)(screen.getHeight()*.75));
					output.setEditable(false);
					output.setFocusable(false);
					output.setFont( new java.awt.Font("DialogInput", 0, 12));
				JScrollPane scroll = new JScrollPane(output);
					scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				add(scroll, "grow,span 4");

				buttonOne = new JButton();
					buttonOne.setSize(new Dimension((int)(getSize().getWidth()/4),(int)(getSize().getHeight()*.3)));
					buttonOne.addActionListener( new ActionOneListener() );
				add(buttonOne, "grow");

				buttonTwo = new JButton();
					buttonTwo.setSize(new Dimension((int)(getSize().getWidth()/4),(int)(getSize().getHeight()*.3)));
					buttonTwo.addActionListener( new ActionTwoListener() );
				add(buttonTwo, "grow");

				buttonThree = new JButton();
					buttonThree.setSize(new Dimension((int)(getSize().getWidth()/4),(int)(getSize().getHeight()*.3)));
					buttonThree.addActionListener( new ActionThreeListener() );
				add(buttonThree, "grow");

				input = new JTextField("",10);
					input.setSize(new Dimension((int)(getSize().getWidth()/4),(int)(getSize().getHeight()*.3)));
					input.addActionListener( new InputFieldActionListener() );
				add(input, "grow");
			}
		}

		class ActionOneListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				ButtonOneAction();
		}}

		public void ButtonOneAction()
		{}

		class ActionTwoListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				ButtonTwoAction();
		}}

		public void ButtonTwoAction()
		{}

		class ActionThreeListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				ButtonThreeAction();
		}}

		public void ButtonThreeAction()
		{}

		class InputFieldActionListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				InputFieldAction();
		}}

		public void InputFieldAction()
		{}
		
		class RegisterAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterAction();				
		}}
		
		public void RegisterAction()
		{}
		
		class ConfirmAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfirmAction();				
		}}
		
		public void ConfirmAction(){}
	}