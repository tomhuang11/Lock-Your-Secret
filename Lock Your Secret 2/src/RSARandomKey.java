import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class RSARandomKey extends JFrame
{
	private JTextField textField_1;
	private JTextField textField_2;
	private int exception;
	private String PBKName;
	private String PVKName;
	public RSARandomKey()
	{	
		JLabel lblNewLabel = new JLabel("\u96A8\u6A5F\u751F\u6210RSA\u9470\u5C0D");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\u516C\u9470\u540D\u7A31\uFF1A");
		panel_7.add(lblNewLabel_2);
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);
		
		textField_1 = new JTextField();
		panel_18.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("\u9810\u8A2D\u540D\u7A31\uFF1APBK");
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("\u516C\u9470\u5B58\u653E\u8DEF\u5F91\uFF1A");
		panel_2.add(lblNewLabel_4);
		
		final JLabel lblNewLabel_5 = new JLabel("");
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_22 = new JPanel();
		panel_2.add(panel_22);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u79C1\u9470\u540D\u7A31\uFF1A");
		panel_9.add(lblNewLabel_3);
		
		JPanel panel_21 = new JPanel();
		panel_9.add(panel_21);
		
		textField_2 = new JTextField();
		panel_21.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		
		JLabel lblNewLabel_8 = new JLabel("\u9810\u8A2D\u540D\u7A31\uFF1APVK");
		panel_10.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("\u79C1\u9470\u5B58\u653E\u8DEF\u5F91\uFF1A");
		panel_4.add(lblNewLabel_6);
		
		final JLabel lblNewLabel_7 = new JLabel("");
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_23 = new JPanel();
		panel_4.add(panel_23);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 3, 0, 10));
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_6.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_6.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_6.add(panel_15);
		
		JButton btnNewButton = new JButton("Back");
		panel_6.add(btnNewButton);
		
		JPanel panel_16 = new JPanel();
		panel_6.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_6.add(panel_17);
		
		JButton btnNewButton_1 = new JButton("Generate");
		panel_6.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						UserKeyPair userKey = new UserKeyPair();
						String keyPath = "Keys";
						KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
						SecureRandom random = new SecureRandom();
						KeyPair generatedKeyPair;
						keyGen.initialize(1024, random);
						generatedKeyPair = keyGen.generateKeyPair();
						
						PBKName = textField_1.getText();
						if(PBKName.equals(""))
						{
							PBKName = "PBK";
						}
						PVKName = textField_2.getText();
						if(PVKName.equals(""))
						{
							PVKName = "PVK";
						}
						exception = userKey.SaveKeyPair(keyPath, PBKName, PVKName, generatedKeyPair);
						if(exception == 0)
						{
							JOptionPane.showMessageDialog(null, "成功產生鑰對", "Encryption",JOptionPane.INFORMATION_MESSAGE);
							lblNewLabel_5.setText(keyPath + "/" + PBKName +".pbkey");
							lblNewLabel_7.setText(keyPath + "/" + PVKName +".pvkey");
						}
						else if(exception ==1)
						{
							JOptionPane.showMessageDialog(null, "公鑰檔案已存在", "WARNING",JOptionPane.WARNING_MESSAGE);
							lblNewLabel_5.setText("");
							lblNewLabel_7.setText("");
						}
						else if(exception ==2)
						{
							JOptionPane.showMessageDialog(null, "私鑰檔案已存在", "WARNING",JOptionPane.WARNING_MESSAGE);
							lblNewLabel_7.setText("");
							lblNewLabel_5.setText("");
						}
						else ;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
		
		btnNewButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					RSAKey rSAKey = new RSAKey();
					rSAKey.doit();
				}
			}
		);			
	}
	
	public void doit()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
