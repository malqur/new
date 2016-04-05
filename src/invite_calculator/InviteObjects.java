package invite_calculator;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InviteObjects extends JFrame {
	InviteMethods order = new InviteMethods();
	double invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice, total;
	String selectPaper, radioButton = "";

	private JPanel contentPane;
	private JTextField textInvites;
	private JTextField textResponse;
	private JTextField textMat;
	private JTextField textInfo;
	private JTextField textMehndi;
	private JTextField textTotal;
	private JTextField textDate;
	private JTextField textName1;
	private JTextField textName2;
	private JTextField textVenue;
	private JTextField textAddress;
	private JTextField textCityState;

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
		setBounds(100, 100, 650, 800);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setSize(800, 800);
		contentPane.setLayout(null);
		contentPane.setPreferredSize(new Dimension(800, 800));
	
		JScrollPane scroller = new JScrollPane(contentPane);
		scroller.setBounds(0, 0, 500, 500);
		
		this.getContentPane().add(scroller);
		
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JLabel lblInvites = new JLabel("Invitations");
		lblInvites.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblInvites.setBounds(36, 244, 75, 16);
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
				total = order.calcTotal(invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice);
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		
		boxInvites.setBounds(159, 239, 92, 27);
		boxInvites.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		contentPane.add(boxInvites);
		
		JLabel lblMat = new JLabel("Matting");
		lblMat.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblMat.setBounds(36, 272, 75, 16);
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
				total = order.calcTotal(invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice);
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		
		boxMat.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxMat.setBounds(159, 267, 92, 27);
		contentPane.add(boxMat);
		
		textMat = new JTextField();
		textMat.setHorizontalAlignment(SwingConstants.CENTER);
		textMat.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textMat.setEditable(false);
		textMat.setColumns(10);
		textMat.setBounds(285, 267, 170, 27);
		contentPane.add(textMat);
		
		JLabel lblResponse = new JLabel("Response Cards");
		lblResponse.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblResponse.setBounds(36, 300, 100, 16);
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
				responsePrice = order.calcTotalMAndR(n);
				textResponse.setText(n +" Response Cards: $" + df.format(responsePrice));
				total = order.calcTotal(invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice);
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		
		boxResponse.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxResponse.setBounds(159, 295, 92, 27);
		contentPane.add(boxResponse);
		
		textInvites = new JTextField();
		textInvites.setHorizontalAlignment(SwingConstants.CENTER);
		textInvites.setEditable(false);
		textInvites.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textInvites.setBounds(285, 239, 170, 27);
		contentPane.add(textInvites);
		textInvites.setColumns(10);
		
		textResponse = new JTextField();
		textResponse.setHorizontalAlignment(SwingConstants.CENTER);
		textResponse.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textResponse.setEditable(false);
		textResponse.setColumns(10);
		textResponse.setBounds(285, 295, 170, 27);
		contentPane.add(textResponse);
		
		JLabel lblInfo = new JLabel("Information Cards");
		lblInfo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblInfo.setBounds(36, 328, 122, 16);
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
				infoPrice = order.calcTotalInfo(n);
				textInfo.setText(n +" Information Cards: $" + df.format(infoPrice));
				total = order.calcTotal(invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice);
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		boxInfo.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxInfo.setBounds(159, 323, 92, 27);
		contentPane.add(boxInfo);
		
		textInfo = new JTextField();
		textInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textInfo.setEditable(false);
		textInfo.setColumns(10);
		textInfo.setBounds(285, 323, 170, 27);
		contentPane.add(textInfo);
		
		JLabel lblMehndi = new JLabel("Mehndi Cards");
		lblMehndi.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblMehndi.setBounds(36, 356, 122, 16);
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
				mehndiPrice = order.calcTotalMAndR(n);
				textMehndi.setText(n +" Mehndi Cards: $" + df.format(mehndiPrice));
				total = order.calcTotal(invitePrice, matPrice, responsePrice, infoPrice, mehndiPrice);
				textTotal.setText("TOTAL: $" + df.format(total));
			}
		});
		boxMehndi.setModel(new DefaultComboBoxModel(new String[] {"0", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100", "105", "110", "115", "120", "125", "130", "135", "140", "145", "150"}));
		boxMehndi.setBounds(159, 351, 92, 27);
		contentPane.add(boxMehndi);
		
		textMehndi = new JTextField();
		textMehndi.setHorizontalAlignment(SwingConstants.CENTER);
		textMehndi.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textMehndi.setEditable(false);
		textMehndi.setColumns(10);
		textMehndi.setBounds(285, 351, 170, 27);
		contentPane.add(textMehndi);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textTotal.setBounds(283, 395, 172, 26);
		contentPane.add(textTotal);
		textTotal.setColumns(10);
		
		JLabel lblRed = new JLabel("");
		lblRed.setBounds(253, 85, 75, 82);
		Image imgRed = new ImageIcon(this.getClass().getResource("/imgRed.jpg")).getImage();
		lblRed.setIcon(new ImageIcon(imgRed));
		contentPane.add(lblRed);
		
		JLabel lblBlue = new JLabel("");
		lblBlue.setBounds(146, 85, 75, 82);
		Image imgBlue = new ImageIcon(this.getClass().getResource("/imgBlue.jpg")).getImage();
		lblBlue.setIcon(new ImageIcon(imgBlue));
		contentPane.add(lblBlue);
		
		JLabel lblHenna = new JLabel("");
		lblHenna.setBounds(36, 85, 75, 82);
		Image imgHenna = new ImageIcon(this.getClass().getResource("/imgHenna.jpg")).getImage();
		lblHenna.setIcon(new ImageIcon(imgHenna));
		contentPane.add(lblHenna);
		
		JRadioButton hennaButton = new JRadioButton("");
		hennaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (hennaButton.isSelected() ) {
					 radioButton = "Henna design";
				 }
			}
		});
		hennaButton.setSelected(false);
		hennaButton.setBounds(56, 165, 28, 23);
		contentPane.add(hennaButton);
		
		JRadioButton blueButton = new JRadioButton("");
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (blueButton.isSelected() ) {
					 radioButton = "Blue design";
				 }
			}
		});
		blueButton.setSelected(false);
		blueButton.setBounds(169, 165, 28, 23);
		contentPane.add(blueButton);
		
		JRadioButton redButton = new JRadioButton("");
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (redButton.isSelected() ) {
					 radioButton = "Red Design";
				 }
			}
		});
		redButton.setSelected(false);
		redButton.setBounds(272, 165, 28, 23);
		contentPane.add(redButton);
		
		 ButtonGroup group = new ButtonGroup();
		    group.add(hennaButton);
		    group.add(blueButton);
		    group.add(redButton);
		    
		 JLabel lblNewLabel = new JLabel("Invitation Suite Pricing and Information");
		 lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		 lblNewLabel.setBounds(24, 24, 346, 27);
		 contentPane.add(lblNewLabel);
		    
		 JLabel lblPaper = new JLabel("Paper Choice");
		 lblPaper.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblPaper.setBounds(36, 202, 75, 16);
		 contentPane.add(lblPaper);
		    
		 JComboBox boxPaper = new JComboBox();
		 boxPaper.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		//get item from dropdown
				selectPaper = (String)boxPaper.getSelectedItem( );
		 	}
		 });
		 boxPaper.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		 boxPaper.setModel(new DefaultComboBoxModel(new String[] {"Select", "Pearl White Shimmer", "Champagne Cream Shimmer"}));
		 boxPaper.setBounds(159, 197, 169, 27);
		 contentPane.add(boxPaper);
		    
		 JLabel lblTotal = new JLabel("Total:");
		 lblTotal.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblTotal.setBounds(239, 400, 42, 16);
		 contentPane.add(lblTotal);
		    
		 JLabel lblDate = new JLabel("Wedding date:");
		 lblDate.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblDate.setBounds(328, 491, 100, 16);
		 contentPane.add(lblDate);
		    
		 JLabel lblName1 = new JLabel("Name 1 on invite:");
		 lblName1.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblName1.setBounds(24, 458, 122, 16);
		 contentPane.add(lblName1);
		    
		 textName1 = new JTextField();
		 textName1.setBounds(147, 453, 169, 26);
		 contentPane.add(textName1);
		 textName1.setColumns(10);
		    
		 textDate = new JTextField();
		 textDate.setBounds(451, 486, 169, 26);
		 contentPane.add(textDate);
		 textDate.setColumns(10);
		    
		 JLabel lblName2 = new JLabel("Name 2 on invite:");
		 lblName2.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblName2.setBounds(328, 458, 122, 16);
		 contentPane.add(lblName2);
		    
		 textName2 = new JTextField();
		 textName2.setBounds(451, 453, 169, 26);
		 contentPane.add(textName2);
		 textName2.setColumns(10);
		    
		 JLabel lblVenue = new JLabel("Name of venue:");
		 lblVenue.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblVenue.setBounds(24, 491, 122, 16);
		 contentPane.add(lblVenue);
		    
		 textVenue = new JTextField();
		 textVenue.setColumns(10);
		 textVenue.setBounds(147, 486, 169, 26);
		 contentPane.add(textVenue);
		    
		 JLabel lblAddress = new JLabel("Address of venue:");
		 lblAddress.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblAddress.setBounds(24, 524, 122, 16);
		 contentPane.add(lblAddress);
		    
		 textAddress = new JTextField();
		 textAddress.setColumns(10);
		 textAddress.setBounds(147, 519, 169, 26);
		 contentPane.add(textAddress);
		    
		 JLabel lblCityState = new JLabel("City/State:");
		 lblCityState.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblCityState.setBounds(328, 524, 82, 16);
		 contentPane.add(lblCityState);
		    
		 textCityState = new JTextField();
		 textCityState.setColumns(10);
		 textCityState.setBounds(451, 519, 170, 26);
		 contentPane.add(textCityState);
		    
		 JLabel lblAdditionalInfo = new JLabel("Additional info? :");
		 lblAdditionalInfo.setFont(new Font("Dialog", Font.PLAIN, 11));
		 lblAdditionalInfo.setBounds(24, 577, 227, 16);
		 contentPane.add(lblAdditionalInfo);
		    
		 JTextArea textAdditionalInfo = new JTextArea();
		 textAdditionalInfo.setBounds(146, 576, 426, 82);
		 contentPane.add(textAdditionalInfo);
		    
		 JButton btnSubmit = new JButton("Submit");
		 btnSubmit.addActionListener(new ActionListener() {
		    	
			public void actionPerformed(ActionEvent e) {

				try {
					WriteFile data = new WriteFile( "/Users/Qureshi/Documents/Orders/" + textName1.getText() + "_" + textName2.getText() + ".txt" , true );
		
				    data.writeToFile(radioButton);
				    data.writeToFile(selectPaper);
				    
				    Component[] components = contentPane.getComponents();
				    for (Component component : components) {
				        if (component instanceof JTextField || component instanceof JTextArea) {
				            JTextComponent specificObject = (JTextComponent) component;
				            data.writeToFile(specificObject.getText());
				        }
				    }
					
				}
				catch (IOException ee) {
				    System.out.println(ee.getMessage() );;
				}
				contentPane.removeAll();
				contentPane.updateUI();
				
				JPanel newPane = new JPanel();
				newPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				newPane.setLayout(null);
				setContentPane(contentPane);
				
				JLabel thankyou = new JLabel("Thank you for submitting your information!");
				thankyou.setFont(new Font("Dialog", Font.PLAIN, 17));
				thankyou.setBounds(45, 244, 400, 45);
				contentPane.add(thankyou);
		    }
				
		    });
		    btnSubmit.setBounds(24, 699, 117, 29);
		    contentPane.add(btnSubmit);
	}
}
