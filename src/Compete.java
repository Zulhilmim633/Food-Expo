import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Compete extends JFrame implements ActionListener {

	private Container cont;
	private JPanel contentpane;
	private TitledBorder border;
	private JLabel lblStoreName, lblStoreType, beverageIcon, foodIcon, healthyIcon;
	private JTextField txtStore;
	private JRadioButton beverageradbtn, foodradbtn, healthyradbtn;
	private ButtonGroup grp1;
	private JCheckBox chkbxSink, chkbxElectric, chkbxStove;
	private JButton btnBack, btnNext;
	private JCheckBox allCheckBoxs[] = new JCheckBox[3];

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

		lblStoreName = new JLabel("Store Name :");
		lblStoreName.setSize(82, 20);
		lblStoreName.setLocation(22, 21);
		
		border = new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		contentpane = new JPanel();
		contentpane.setBorder(border);
		contentpane.setSize(198, 132);
		contentpane.setLocation(375, 24);
		contentpane.setLayout(null);
		
		chkbxSink = new JCheckBox("Need Sink");
		chkbxSink.setActionCommand("Need Sink");
		chkbxSink.setBounds(20, 35, 128, 17);
		
		chkbxElectric = new JCheckBox("Need Extra Electric");
		chkbxElectric.setActionCommand("Need Extra Electric");
		chkbxElectric.setBounds(20, 64, 152, 17);
		
		chkbxStove = new JCheckBox("Need Stove");
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
		
		btnNext = new JButton("NEXT");
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
					dispose();
					Customer next = new Customer("Compete",Store,Store_type,optional);
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
