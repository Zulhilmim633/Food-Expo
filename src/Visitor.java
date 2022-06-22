import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Visitor extends JFrame implements ActionListener{

	private Container cont;
	private JPanel panel;
	private JLabel beverageIcon, foodIcon, healthyIcon;
	private JCheckBox beverageCheckBox, foodCheckBox, healthycCheckBox;
	private JButton btnBack, btnNext;
	private JLabel lblAdult;
	private JSpinner spinner_1;
	private JLabel lblChild;
	private JSpinner spinner;
	private JLabel lbltotal;
	private JLabel lblpricetotal;
	private DecimalFormat format;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Visitor frame = new Visitor();
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public Visitor() {
		super("Visitor");
		cont = getContentPane();
		cont.setLayout(null);
		format = new DecimalFormat("##0.00");
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "What you like to see ?  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 102, 299, 290);
		panel.setLayout(null);

		beverageIcon = new JLabel(new ImageIcon("Image/beverage.png"));
		beverageIcon.setSize(112, 92);
		beverageIcon.setLocation(10, 17);

		foodIcon = new JLabel();
		foodIcon.setSize(102,102);
		foodIcon.setLocation(10, 107);
		foodIcon.setIcon(new ImageIcon("Image/food.png"));
		
		healthyIcon = new JLabel();
		healthyIcon.setSize(120,64);
		healthyIcon.setLocation(10, 215);
		healthyIcon.setIcon(new ImageIcon("Image/vegetables.png"));
		
		beverageCheckBox = new JCheckBox("Beverages");
		beverageCheckBox.setBounds(136, 53, 99, 23);

		foodCheckBox = new JCheckBox("Food");
		foodCheckBox.setBounds(136, 146, 99, 23);
		
		healthycCheckBox = new JCheckBox("Healthy");
		healthycCheckBox.setBounds(136, 236, 99, 23);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomePage frame1 = new WelcomePage();
				frame1.setVisible(true);
			}
		});
		btnBack.setBounds(51, 426, 89, 23);
		
		btnNext = new JButton("PAY");
		btnNext.addActionListener(this);
		btnNext.setBounds(193, 426, 89, 23);
		
		
		
		panel.add(beverageIcon);
		panel.add(beverageCheckBox);
		panel.add(foodIcon);
		panel.add(foodCheckBox);
		panel.add(healthyIcon);
		panel.add(healthycCheckBox);
		cont.add(panel);
		cont.add(btnBack);
		cont.add(btnNext);
		
		lblAdult = new JLabel("Adult (RM 15) :");
		lblAdult.setBounds(21, 28, 91, 14);
		getContentPane().add(lblAdult);
		
		lblpricetotal = new JLabel("0 RM");
		lblpricetotal.setBounds(270, 41, 93, 14);
		
		spinner_1 = new JSpinner();
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int adult = (Integer) spinner_1.getValue();
				int child = (Integer) spinner.getValue();
				lblpricetotal.setText(format.format(((adult * 15)+(child * 10)))+" RM");
			}
		});
		spinner_1.setBounds(122, 28, 30, 20);
		getContentPane().add(spinner_1);
		
		lblChild = new JLabel("Child (RM 10) :");
		lblChild.setBounds(21, 53, 91, 14);
		getContentPane().add(lblChild);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int adult = (Integer) spinner_1.getValue();
				int child = (Integer) spinner.getValue();
				lblpricetotal.setText(format.format(((adult * 15)+(child * 10)))+" RM");
			}
		});
		spinner.setBounds(122, 53, 30, 20);
		getContentPane().add(spinner);
		
		lbltotal = new JLabel("Total to pay :");
		lbltotal.setBounds(175, 41, 85, 14);
		getContentPane().add(lbltotal);
		getContentPane().add(lblpricetotal);
		
		setBounds(100, 100, 355, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNext){
			int adult = (Integer) spinner_1.getValue();
			int child = (Integer) spinner.getValue();
			if(adult == 0 && child == 0){
				JOptionPane.showMessageDialog(null, "Please insert total person","No person",JOptionPane.ERROR_MESSAGE);
			}else{
				boolean atleast1 = false;
				String optional = "";
				int count = 0;
				if(beverageCheckBox.isSelected()){
					atleast1 = true;
					optional += "Beverage,";
					count++;
				}if(foodCheckBox.isSelected()){
					atleast1 = true;
					optional += "Food,";
					count++;
				}if(healthycCheckBox.isSelected()){
					atleast1 = true;
					optional += "Healthy,";
					count++;
				}
				
				if(atleast1){
					double price = (adult * 15)+(child * 10);
					dispose();
					optional = optional.substring(0,(optional.length()-1));
					Customer nextFrame = new Customer("Visitor", ""+adult, ""+child, optional,""+count,format.format(price)+" RM");
					nextFrame.setVisible(true);	
				}else{
					JOptionPane.showMessageDialog(null, "Please Choose atleast 1","What you like to see ?",JOptionPane.INFORMATION_MESSAGE);
				}

			}
			}
			
		}
	}
	