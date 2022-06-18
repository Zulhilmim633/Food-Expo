import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Compete extends JFrame implements ActionListener {

	private Container cont;
	private JPanel contentpane;
	private TitledBorder border;
	private JLabel lblStoreName, lblNeedEclectric, lblNeedSink, lblStoreType, lblNeedStove;
	private JTextField txtStore;
	private JRadioButton beverageradbtn, foodradbtn;
	private ButtonGroup grp1;
	private JCheckBox chkbxSink, chkbxElectric, chkbxStove;
	private JButton btnBack, btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Compete frame = new Compete();
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
		contentpane.setSize(198, 122);
		contentpane.setLocation(55, 77);
		contentpane.setLayout(null);
		
		lblNeedSink = new JLabel("Need Sink :");
		lblNeedSink.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeedSink.setBounds(61, 35, 70, 14);
		
		chkbxSink = new JCheckBox("");
		chkbxSink.setBounds(152, 35, 40, 17);
		
		lblNeedEclectric = new JLabel("Need Extra Electric :");
		lblNeedEclectric.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeedEclectric.setBounds(10, 64, 121, 14);
		
		chkbxElectric = new JCheckBox("");
		chkbxElectric.setBounds(152, 64, 40, 17);
		
		lblNeedStove = new JLabel("Need Stove :");
		lblNeedStove.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeedStove.setBounds(20, 93, 111, 14);
		
		chkbxStove = new JCheckBox("");
		chkbxStove.setBounds(152, 93, 40, 17);
		
		txtStore = new JTextField();
		txtStore.setBounds(103, 21, 168, 20);
		txtStore.setColumns(10);
		
		lblStoreType = new JLabel("Store Type :");
		lblStoreType.setBounds(22, 52, 82, 14);
		
		beverageradbtn = new JRadioButton("Beverages");
		beverageradbtn.setBounds(103, 48, 92, 23);
		
		foodradbtn = new JRadioButton("Food");
		foodradbtn.setBounds(197, 48, 67, 23);
		
		grp1 = new ButtonGroup();
		grp1.add(beverageradbtn);
		grp1.add(foodradbtn);

		btnBack = new JButton("BACK");
		btnBack.setBounds(41, 218, 89, 23);
		btnBack.addActionListener(this);
		
		btnNext = new JButton("NEXT");
		btnNext.setBounds(163, 218, 89, 23);
		btnNext.addActionListener(this);
		
		cont.add(lblStoreName);
		cont.add(txtStore);
		cont.add(lblStoreType);
		cont.add(beverageradbtn);
		cont.add(foodradbtn);
		cont.add(contentpane);
		cont.add(btnBack);
		cont.add(btnNext);
		contentpane.add(lblNeedSink);
		contentpane.add(chkbxSink);
		contentpane.add(lblNeedEclectric);
		contentpane.add(chkbxElectric);
		contentpane.add(lblNeedStove);
		contentpane.add(chkbxStove);

		setBounds(100, 100, 303, 290);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnBack){
			dispose();
			WelcomePage frame1 = new WelcomePage();
			frame1.setVisible(true);
		}
	}
}
