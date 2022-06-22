import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.border.LineBorder;

public class Compete extends JFrame implements ActionListener {

	private Container cont;
	private JPanel contentpane;
	private TitledBorder border;
	private JLabel lblStoreName, lblStoreType, beverageIcon, foodIcon, healthyIcon, lblDeposit, lbldeposittotal;
	private JTextField txtStore;
	private JRadioButton beverageradbtn, foodradbtn, healthyradbtn;
	private ButtonGroup grp1;
	private JCheckBox chkbxSink, chkbxElectric, chkbxStove;
	private JButton btnBack, btnNext;
	private JCheckBox allCheckBoxs[] = new JCheckBox[3];
	private DecimalFormat format;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Compete frame = new Compete();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Compete() {
		super("Competing");
		cont = getContentPane();
		cont.setLayout(null);
		
		format = new DecimalFormat("##0.00");

		lblStoreName = new JLabel("Store Name :");
		lblStoreName.setSize(82, 20);
		lblStoreName.setLocation(22, 21);
		
		border = new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		contentpane = new JPanel();
		contentpane.setBorder(border);
		contentpane.setSize(198, 132);
		contentpane.setLocation(375, 24);
		contentpane.setLayout(null);
		
		lbldeposittotal = new JLabel("10.00 RM");
		lbldeposittotal.setBounds(430, 207, 67, 14);
		
		chkbxSink = new JCheckBox("Need Sink");
		chkbxSink.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chkbxSink.isSelected()) {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit += 20.0;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}else {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit -= 20.0;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}
			}
		});
		chkbxSink.setActionCommand("Need Sink");
		chkbxSink.setBounds(20, 35, 128, 17);
		
		chkbxElectric = new JCheckBox("Need Extra Electric");
		chkbxElectric.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chkbxElectric.isSelected()) {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit += 40;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}else {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit -= 40;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}
			}
		});
		chkbxElectric.setActionCommand("Need Extra Electric");
		chkbxElectric.setBounds(20, 64, 152, 17);
		
		chkbxStove = new JCheckBox("Need Stove");
		chkbxStove.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(chkbxStove.isSelected()) {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit += 50;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}else {
					double deposit = Double.parseDouble(lbldeposittotal.getText().replace(" RM", ""));
					deposit -= 50;
					lbldeposittotal.setText(format.format(deposit)+" RM");
				}
			}
		});
		chkbxStove.setActionCommand("Need Stove");
		chkbxStove.setBounds(20, 93, 128, 17);
		
		txtStore = new JTextField();
		txtStore.setBounds(103, 21, 233, 20);
		txtStore.setColumns(10);
		
		lblStoreType = new JLabel("Store Type :");
		lblStoreType.setBounds(22, 52, 82, 14);
		
		beverageIcon = new JLabel();
		beverageIcon.setSize(112, 92);
		beverageIcon.setLocation(103, 52);
		beverageIcon.setIcon(new ImageIcon("Image/beverage.png"));
		
		foodIcon = new JLabel();
		foodIcon.setSize(102,102);
		foodIcon.setLocation(103, 140);
		foodIcon.setIcon(new ImageIcon("Image/food.png"));
		
		healthyIcon = new JLabel();
		healthyIcon.setSize(120,64);
		healthyIcon.setLocation(103, 253);
		healthyIcon.setIcon(new ImageIcon("Image/vegetables.png"));
		
		beverageradbtn = new JRadioButton("Beverages");
		beverageradbtn.setBounds(229, 92, 92, 23);
		beverageradbtn.setActionCommand("Beverage");
		
		foodradbtn = new JRadioButton("Food");
		foodradbtn.setBounds(229, 182, 67, 23);
		foodradbtn.setActionCommand("Food");

		
		healthyradbtn = new JRadioButton("Healthy");
		healthyradbtn.setBounds(229, 277, 74, 23);
		healthyradbtn.setActionCommand("Healthy");
		
		grp1 = new ButtonGroup();
		grp1.add(beverageradbtn);
		grp1.add(foodradbtn);
		grp1.add(healthyradbtn);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(375, 277, 89, 23);
		btnBack.addActionListener(this);
		
		btnNext = new JButton("PAY");
		btnNext.setBounds(497, 277, 89, 23);
		btnNext.addActionListener(this);
		
		cont.add(lblStoreName);
		cont.add(txtStore);
		cont.add(lblStoreType);
		cont.add(beverageIcon);
		cont.add(beverageradbtn);
		cont.add(foodIcon);
		cont.add(foodradbtn);
		cont.add(healthyIcon);
		cont.add(healthyradbtn);
		cont.add(contentpane);
		cont.add(btnBack);
		cont.add(btnNext);
		contentpane.add(chkbxSink);
		contentpane.add(chkbxElectric);
		contentpane.add(chkbxStove);
		
		allCheckBoxs[0] = chkbxSink;
		allCheckBoxs[1] = chkbxElectric;
		allCheckBoxs[2] = chkbxStove;
		
		lblDeposit = new JLabel("Deposit : ");
		lblDeposit.setBounds(375, 207, 67, 14);
		getContentPane().add(lblDeposit);
		
		getContentPane().add(lbldeposittotal);

		setBounds(100, 100, 639, 368);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) throws NullPointerException{
		if(e.getSource() == btnBack){
			dispose();
			WelcomePage frame1 = new WelcomePage();
			frame1.setVisible(true);
		}else if(e.getSource() == btnNext){
			try {
				String Store = txtStore.getText();
				if(!Store.equalsIgnoreCase("")){
					String Store_type = grp1.getSelection().getActionCommand();
					String optional = "";
					for (int i = 0; i < allCheckBoxs.length; i++) {
						if(allCheckBoxs[i].isSelected()){
							optional += allCheckBoxs[i].getActionCommand()+",";
						}
					}
					if(optional != ""){
						optional = optional.substring(0,(optional.length()-1));
					}
					String price = lbldeposittotal.getText();
					dispose();
					Customer next = new Customer("Compete",Store,Store_type,optional,price);
					next.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Need Store name","No Store Name",JOptionPane.WARNING_MESSAGE);
				}
			} catch (NullPointerException nu) {
				JOptionPane.showMessageDialog(null,"Please choose Store type","No Store Type",JOptionPane.WARNING_MESSAGE);
			}
			}
	}
}
