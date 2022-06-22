import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.StringTokenizer;

public class Customer extends JFrame implements ActionListener {

	private Container cont;
	private JTextArea txtArea;
	private JLabel lbl1;
	private JButton btnHome;

	/**
	 * Create the frame.
	 */
	public Customer(String... args) {
		super("Reciept");
		cont = getContentPane();
		cont.setLayout(null);
		
		lbl1 = new JLabel(args[0]);
		lbl1.setBounds(20, 11, 79, 14);
		cont.add(lbl1);

		String receipt = "";
		if(args[0].equalsIgnoreCase("compete")){
			String store_name = args[1];
			String store_type = args[2];
			String optional = args[3];
			String zone = null;
			if(store_type.equalsIgnoreCase("beverage")){
				zone = "A";
			}else if(store_type.equalsIgnoreCase("food")){
				zone = "B";
			}else if(store_type.equalsIgnoreCase("healthy")){
				zone = "c";
			}
			receipt += "               Welcome to Food Expo\n--------------------------------------------------------\nStore : "+store_name+"\nStore Type : "+store_type+"\nRequest : "+optional+"\nZone : "+zone+"\nTotal price : "+args[4]+"\n--------------------------------------------------------\n               Thank You For Coming";			
			
		}else if(args[0].equalsIgnoreCase("visitor")){
			int adult = Integer.parseInt(args[1]);
			int child = Integer.parseInt(args[2]);
			String optional = args[3];
			String zone = "";
			int total = Integer.parseInt(args[4]);
			StringTokenizer st = new StringTokenizer(optional,",");
			for (int i = 0; i < total; i++) {
				String next = st.nextToken();
				if(next != null){
					if(next.equalsIgnoreCase("beverage")){
						zone += "A ";
					}else if(next.equalsIgnoreCase("food")){
						zone += "B ";
					}else if(next.equalsIgnoreCase("healthy")){
						zone += "C ";
					}
				}
			}
			receipt += "               Welcome to Food Expo\n--------------------------------------------------------\nAdult : "+adult+"\nChild : "+child+"\nRequest : "+optional+"\nZone : "+zone+"\nTotal to pay : "+args[5]+"\n--------------------------------------------------------\n               Thank You For Coming";
		}
		
		txtArea = new JTextArea(receipt);
		txtArea.setWrapStyleWord(true);
		txtArea.setLineWrap(true);
		txtArea.setEditable(false);
		txtArea.setBounds(20, 36, 227, 198);
		
		btnHome = new JButton("BACK TO WELCOMEPAGE");
		btnHome.setBounds(30, 254, 207, 23);

		btnHome.addActionListener(this);

		cont.add(txtArea);
		cont.add(btnHome);
		
		JButton btnprint = new JButton("PRINT");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnprint.setBounds(90, 288, 89, 23);
		getContentPane().add(btnprint);
		
		setResizable(false);
		setBounds(100, 100, 282, 359);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome){
			dispose();
			WelcomePage frame1 = new WelcomePage();
			frame1.setVisible(true);
		}
	}
}
