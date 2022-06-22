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
        frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public WelcomePage() {
		super("Welcome");
        cont = getContentPane();
        getContentPane().setLayout(null);

        label1 = new JLabel("Welcome To Food Expo 2022");
        label1.setFont(new Font("Tahoma", Font.BOLD, 18));
        label1.setBounds(31, 38, 295, 34);

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
        setResizable(false);
	}

    public void actionPerformed(ActionEvent e) throws NullPointerException{
        if(e.getSource() == nextBtn){
            try { // try catch some error if not choosing
                if(group.getSelection().getActionCommand().equalsIgnoreCase("compete")){
                	//open new frame
                    Compete compete = new Compete();
                    compete.setVisible(true);
                    //exit current frame
                    dispose();
                }else if(group.getSelection().getActionCommand().equalsIgnoreCase("visitor")){
                	//open new frame
                    Visitor visitor = new Visitor();
                    visitor.setVisible(true);
                    //exit current frame
                    dispose();
                }                
                
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null,"Need selection","Needed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
