import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Visitor extends JFrame implements ActionListener{

	private Container cont;
	private JTextField txtname, txtage;
	private JPanel panel;
	private JLabel lblName, lblAge, beverageIcon, foodIcon, healthyIcon;
	private JCheckBox beverageCheckBox, foodCheckBox, healthycCheckBox;
	private JButton btnBack, btnNext;
	
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
		
		lblName = new JLabel("Name :");
		lblName.setBounds(21, 26, 49, 14);
		
		txtname = new JTextField();
		txtname.setBounds(80, 23, 240, 20);
		txtname.setColumns(10);
		
		lblAge = new JLabel("Age :");
		lblAge.setBounds(21, 58, 49, 14);
		
		txtage = new JTextField();
		txtage.setBounds(80, 58, 22, 20);
		
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
		btnBack.setBounds(51, 426, 89, 23);
		
		btnNext = new JButton("NEXT");
		btnNext.setBounds(193, 426, 89, 23);
		
		btnBack.addActionListener(this);
		btnNext.addActionListener(this);
		
		panel.add(beverageIcon);
		panel.add(beverageCheckBox);
		panel.add(foodIcon);
		panel.add(foodCheckBox);
		panel.add(healthyIcon);
		panel.add(healthycCheckBox);
		cont.add(panel);
		cont.add(lblName);
		cont.add(txtname);
		cont.add(lblAge);
		cont.add(txtage);
		cont.add(btnBack);
		cont.add(btnNext);
		
		setBounds(100, 100, 355, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnNext){
			String name = txtname.getText();
			String age = txtage.getText();
			if(name.equalsIgnoreCase("") || age.equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null,"Need to enter name and age", "Needed", JOptionPane.WARNING_MESSAGE);
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
					dispose();
					optional = optional.substring(0,(optional.length()-1));
					Customer nextFrame = new Customer("Visitor", name, age, optional,""+count);
					nextFrame.setVisible(true);	
				}else{
					JOptionPane.showMessageDialog(null, "Please Choose atleast 1","What you like to see ?",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}else if(e.getSource() == btnBack){
			dispose();
			WelcomePage frame1 = new WelcomePage();
			frame1.setVisible(true);
		}
	}
}
