package invite_calculator;
import invite_calculator.InviteMethods;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


public class InviteObjects extends JFrame {
	InviteMethods order = new InviteMethods();
	double invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice, total = 0.0;
	
	


	private JPanel contentPane;
	private JTextField textInvites;
	private JTextField textResponse;
	private JTextField textMat;
	private JTextField textInfo;
	private JTextField textMehndi;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InviteObjects frame = new InviteObjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InviteObjects() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvites = new JLabel("Invitations");
		lblInvites.setBounds(39, 52, 75, 16);
		contentPane.add(lblInvites);
		
		JComboBox boxInvites = new JComboBox();
		boxInvites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//get item from dropdown
				String item = (String)boxInvites.getSelectedItem( );
			//convert item to integer
				int n = Integer.parseInt(item);
			//set invites to n
				order.setNumOfInvites(n);
				DecimalFormat df = new DecimalFormat("0.00");
			//calc total price and display in text field
				invitePrice = order.calcTotalInvites(n);
				textInvites.setText(n +" Invitations: $" + df.format(invitePrice));
				total += invitePrice;
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		boxInvites.setBounds(162, 48, 92, 27);
		boxInvites.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		contentPane.add(boxInvites);
		
		JLabel lblMat = new JLabel("Matting");
		lblMat.setBounds(39, 100, 75, 16);
		contentPane.add(lblMat);
		
		JComboBox boxMat = new JComboBox();
		boxMat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//get item from dropdown
				String item = (String)boxMat.getSelectedItem( );
			//convert item to integer
				int n = Integer.parseInt(item);
			//set invites to n
				order.setNumOfInvites(n);
				DecimalFormat df = new DecimalFormat("0.00");
			//calc total price and display in text field
				matPrice = order.calcMatting(n);
				textMat.setText(n +" Matting: $" + df.format(matPrice));
				total += matPrice;
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		
		
		boxMat.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxMat.setBounds(162, 96, 92, 27);
		contentPane.add(boxMat);
		
		textMat = new JTextField();
		textMat.setHorizontalAlignment(SwingConstants.CENTER);
		textMat.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textMat.setEditable(false);
		textMat.setColumns(10);
		textMat.setBounds(290, 96, 185, 27);
		contentPane.add(textMat);
		
		JLabel lblResponse = new JLabel("Response Cards");
		lblResponse.setBounds(39, 146, 100, 16);
		contentPane.add(lblResponse);
		
		JComboBox boxResponse = new JComboBox();
		boxResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//get item from dropdown
				String item = (String)boxResponse.getSelectedItem( );
			//convert item to integer
				int n = Integer.parseInt(item);
			//set invites to n
				order.setNumOfInvites(n);
				DecimalFormat df = new DecimalFormat("0.00");
			//calc total price and display in text field
				textResponse.setText(n +" Response Cards: $" + df.format(order.calcTotalMAndR(n) ));
				
			}
		});
		
		boxResponse.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxResponse.setBounds(162, 142, 92, 27);
		contentPane.add(boxResponse);
		
		textInvites = new JTextField();
		textInvites.setHorizontalAlignment(SwingConstants.CENTER);
		textInvites.setEditable(false);
		textInvites.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textInvites.setBounds(290, 48, 185, 27);
		contentPane.add(textInvites);
		textInvites.setColumns(10);
		
		textResponse = new JTextField();
		textResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textResponse.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textResponse.setEditable(false);
		textResponse.setColumns(10);
		textResponse.setBounds(290, 142, 185, 27);
		contentPane.add(textResponse);
		
		JLabel lblInfo = new JLabel("Information Cards");
		lblInfo.setBounds(39, 195, 122, 16);
		contentPane.add(lblInfo);
		
		JComboBox boxInfo = new JComboBox();
		boxInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//get item from dropdown
				String item = (String)boxInfo.getSelectedItem( );
			//convert item to integer
				int n = Integer.parseInt(item);
			//set invites to n
				order.setNumOfInvites(n);
				DecimalFormat df = new DecimalFormat("0.00");
			//calc total price and display in text field
				textInfo.setText(n +" Information Cards: $" + df.format(order.calcTotalInfo(n) ));
			}
		});
		boxInfo.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxInfo.setBounds(162, 191, 92, 27);
		contentPane.add(boxInfo);
		
		textInfo = new JTextField();
		textInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textInfo.setEditable(false);
		textInfo.setColumns(10);
		textInfo.setBounds(290, 191, 185, 27);
		contentPane.add(textInfo);
		
		JLabel lblMehndi = new JLabel("Mehndi Cards");
		lblMehndi.setBounds(39, 244, 122, 16);
		contentPane.add(lblMehndi);
		
		JComboBox boxMehndi = new JComboBox();
		boxMehndi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//get item from dropdown
				String item = (String)boxMehndi.getSelectedItem( );
			//convert item to integer
				int n = Integer.parseInt(item);
			//set invites to n
				order.setNumOfInvites(n);
				DecimalFormat df = new DecimalFormat("0.00");
			//calc total price and display in text field
				textMehndi.setText(n +" Mehndi Cards: $" + df.format(order.calcTotalMAndR(n) ));

			}
		});
		boxMehndi.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxMehndi.setBounds(162, 240, 92, 27);
		contentPane.add(boxMehndi);
		
		textMehndi = new JTextField();
		textMehndi.setHorizontalAlignment(SwingConstants.CENTER);
		textMehndi.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textMehndi.setEditable(false);
		textMehndi.setColumns(10);
		textMehndi.setBounds(290, 240, 185, 27);
		contentPane.add(textMehndi);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textTotal.setBounds(305, 379, 170, 26);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
		

	}
}
