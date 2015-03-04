package se.mah.k3lara.skaneAPI.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField textField = new JTextField();
	private JTextField txtPosition;
	public JTextArea textArea = new JTextArea();
	private Parser p =  new Parser();
	JTextArea textArea_1 = new JTextArea();
	GUI minGUI = this;
	Thread T = new threadStationSearch(p, this);
	Thread T1 = new threadJourneySearch(p, this);

	private final JScrollPane scrollPane = new JScrollPane();


	 JTextField textFieldPosition = new JTextField();
	 JTextField textFieldDestination = new JTextField();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Sk\u00E5netrafiken");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPosition = new JTextField();
		txtPosition.setText("Position");
		txtPosition.setHorizontalAlignment(SwingConstants.CENTER);
		txtPosition.setBounds(227, 36, 146, 31);
		contentPane.add(txtPosition);
		txtPosition.setColumns(10);
		
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread T = new threadStationSearch(p, minGUI);
				T.start();
			}
		});
		btnSk.setBounds(258, 78, 89, 23);
		contentPane.add(btnSk);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(47, 112, 520, 70);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		
		textArea.setEditable(false);
		
		JLabel lblSkStation = new JLabel("S\u00F6k Station");
		lblSkStation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkStation.setBounds(258, 11, 180, 14);
		contentPane.add(lblSkStation);
		
		JLabel lblSkResa = new JLabel("S\u00F6k Resa");
		lblSkResa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkResa.setBounds(262, 218, 146, 14);
		contentPane.add(lblSkResa);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 243, 554, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		textFieldDestination.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDestination.setText("Position");
		textFieldDestination.setBounds(112, 6, 86, 20);
		panel.add(textFieldDestination);
		textFieldDestination.setColumns(10);
		
		JButton btnSkResa = new JButton("S\u00F6k Resa");
		btnSkResa.setBounds(228, 39, 97, 23);
		panel.add(btnSkResa);
		btnSkResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread T1 = new threadJourneySearch(p, minGUI);
				T1.start();
			}
		});
		textFieldPosition.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPosition.setText("Destination");
		textFieldPosition.setBounds(344, 6, 86, 20);
		panel.add(textFieldPosition);
		textFieldPosition.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 89, 514, 80);
		panel.add(scrollPane_2);
		scrollPane_2.setViewportView(textArea_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 89, 516, 82);
		panel.add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
}
