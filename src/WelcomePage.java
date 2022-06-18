import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {

	private Container cont;
    private JLabel label1, label2;
    private JRadioButton competeRadioBtn, visitorRadioBtn;
    private JButton nextBtn;
    private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        WelcomePage frame = new WelcomePage();
	}

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		super("Welcome");
        cont = getContentPane();
        getContentPane().setLayout(null);

        label1 = new JLabel("Welcome To Food Expo");
        label1.setFont(new Font("Tahoma", Font.BOLD, 18));
        label1.setBounds(57, 38, 211, 34);

        label2 = new JLabel("You're :");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setSize(69, 39);
        label2.setLocation(124, 83);
        
        competeRadioBtn = new JRadioButton("Compete");
        competeRadioBtn.setBounds(76, 129, 81, 23);
        competeRadioBtn.setActionCommand("compete");
        
        visitorRadioBtn = new JRadioButton("Visitor");
        visitorRadioBtn.setBounds(159, 129, 69, 23);
        visitorRadioBtn.setActionCommand("visitor");
        
        nextBtn = new JButton("NEXT");
        nextBtn.setBounds(104, 181, 89, 23);
        nextBtn.addActionListener(this);
        
        cont.add(label1);
        cont.add(label2);
        cont.add(competeRadioBtn);
        cont.add(visitorRadioBtn);
        cont.add(nextBtn);

        group = new ButtonGroup();
        group.add(competeRadioBtn);
        group.add(visitorRadioBtn);

		setBounds(100, 100, 450, 300);
        setSize(329,268);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == nextBtn){
            if(group.getSelection().getActionCommand().equalsIgnoreCase("compete")){
                Compete compete = new Compete();
                dispose();
            }else if(group.getSelection().getActionCommand().equalsIgnoreCase("visitor")){
                Visitor visitor = new Visitor();
                dispose();
            }
        }
    }
}
