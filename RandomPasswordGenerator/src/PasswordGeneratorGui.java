import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PasswordGeneratorGui extends JFrame {
	
	private PasswordGenerator passwordGenerator;
	
	public PasswordGeneratorGui() {
		super("Password Generator");
		
		setSize(540, 570);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		passwordGenerator = new PasswordGenerator();
		
		addGuiComponents();
		
	}
	
	private void addGuiComponents() {
		
		JLabel titleLabel = new JLabel("Password Generator");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 10, 540, 39);
		add(titleLabel);
		
		JTextArea passwordOutput = new JTextArea();
		passwordOutput.setEditable(false);
		passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
		
		// add scrollability in case outpu becomes too big
		JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
		passwordOutputPane.setBounds(25, 97, 479, 70);
		passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(passwordOutputPane);
		
		JLabel passwordLengthLabel = new JLabel("Password Length: ");
		passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
		passwordLengthLabel.setBounds(25, 215, 272, 39);
		add(passwordLengthLabel);
		
		JTextArea passwordLengthInputArea = new JTextArea();
		passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
		passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		passwordLengthInputArea.setBounds(310, 215, 192, 39);
		add(passwordLengthInputArea);
		
		JToggleButton uppercaseToggle = new JToggleButton("Upercase");
		uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		uppercaseToggle.setForeground(new Color(255, 255, 255));
		uppercaseToggle.setBackground(new Color(87, 130, 247));
		uppercaseToggle.setFocusable(false);
		uppercaseToggle.setBounds(25, 302, 225, 56);
		add(uppercaseToggle);
		
		JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
		lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		lowercaseToggle.setForeground(new Color(255, 255, 255));
		lowercaseToggle.setBackground(new Color(87, 130, 247));
		lowercaseToggle.setFocusable(false);
		lowercaseToggle.setBounds(282, 302, 225, 56);
		add(lowercaseToggle);
		
		JToggleButton numbersToggle = new JToggleButton("Numbers");
		numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		numbersToggle.setForeground(new Color(255, 255, 255));
		numbersToggle.setBackground(new Color(87, 130, 247));
		numbersToggle.setFocusable(false);
		numbersToggle.setBounds(25, 373, 225, 56);
		add(numbersToggle);
		
		JToggleButton symbolToggle = new JToggleButton("Symbol");
		symbolToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		symbolToggle.setForeground(new Color(255, 255, 255));
		symbolToggle.setBackground(new Color(87, 130, 247));
		symbolToggle.setFocusable(false);
		symbolToggle.setBounds(282, 373, 225, 56);
		add(symbolToggle);
		
		JButton generateButton = new JButton("Generate");
		generateButton.setFocusable(false);
		generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		generateButton.setForeground(new Color(255, 255, 255));
		generateButton.setBackground(new Color(86, 198, 78));
		generateButton.setBounds(155, 477, 222, 41);
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passwordLengthInputArea.getText().length() <= 0 )return;
				boolean anyToggleSelected = lowercaseToggle.isSelected() ||
						uppercaseToggle.isSelected() ||
						numbersToggle.isSelected() ||
						symbolToggle.isSelected();
				
				int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
				if(anyToggleSelected) {
					String generatedPassword = passwordGenerator.generatePassword(passwordLength-1,
							lowercaseToggle.isSelected(),
							uppercaseToggle.isSelected(),
							numbersToggle.isSelected(),
							symbolToggle.isSelected());
					
					passwordOutput.setText(generatedPassword);
				}
			}
		});
		add(generateButton);
		
	}
	
}
