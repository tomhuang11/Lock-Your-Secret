import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;
import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import javax.swing.SwingConstants;
import java.awt.Color;

public class RSADecryption extends JFrame
{
	private String filePath;
	private String fileName;
	private String savePath = "Decrypted Files/RSA";
	private String keyPath = "Keys";
	private int x = -1;
	private String PVKName;
	private int exception;
	public RSADecryption()
	{
		final EncryptionForRSA encryption = new EncryptionForRSA();
		final Chooser chooser = new Chooser();
		JLabel lblNewLabel = new JLabel("RSA \u89E3\u5BC6");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 50, 10));
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		
		JLabel lblNewLabel_1 = new JLabel("\u8ACB\u9078\u64C7\u6A94\u6848\uFF1A");
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u700F\u89BD");
		panel_1.add(btnNewButton);
		
		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_1.add(panel_13);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u6A94\u6848\u8DEF\u5F91\uFF1A");
		panel_2.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_21 = new JPanel();
		panel_2.add(panel_21);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 3, 50, 10));
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16);
		
		JLabel lblNewLabel_2 = new JLabel("請選擇私鑰：");
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\u700F\u89BD");
		panel_3.add(btnNewButton_1);
		
		JPanel panel_17 = new JPanel();
		panel_3.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_3.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_3.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_3.add(panel_20);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("私鑰路徑：");
		panel_4.add(lblNewLabel_5);
		
		final JLabel lblNewLabel_6 = new JLabel("");
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_22 = new JPanel();
		panel_4.add(panel_22);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("注意：使用錯誤私鑰會導致不可回復性的檔案損毀！");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_7);
		
		JPanel panel_23 = new JPanel();
		panel_5.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_5.add(panel_24);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 3, 0, 10));
		
		JPanel panel_25 = new JPanel();
		panel_6.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_6.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_6.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_6.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_6.add(panel_29);
		
		JButton btnNewButton_2 = new JButton("Back");
		panel_6.add(btnNewButton_2);
		
		JPanel panel_30 = new JPanel();
		panel_6.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_6.add(panel_31);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u8986\u84CB\u5DF2\u5B58\u5728\u6A94\u6848");
		panel_31.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_3 = new JButton("Decryption");
		panel_6.add(btnNewButton_3);
		
		rdbtnNewRadioButton_1.addItemListener
		(
			new ItemListener()
			{
				public void itemStateChanged(ItemEvent event)
				{
					x = x * -1;
					encryption.setCoverOption(x);
				}
			}
		);
		
		btnNewButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					chooser.chooser("Encrypted Files/RSA");
					lblNewLabel_4.setText(chooser.getPath());
				}
			}
		);
		
		btnNewButton_1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					chooser.chooserKey();
					lblNewLabel_6.setText(chooser.getKeyPath());
				}
			}
		);
		
		btnNewButton_3.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						UserKeyPair userKey = new UserKeyPair();
						fileName = chooser.getName();
						filePath = chooser.getParent();
						PVKName = chooser.getKeyName();
						
						if(PVKName.indexOf(".pbkey") != -1);

						keyPath = chooser.getKeyParent();
						PrivateKey PVK = userKey.LoadPrivateKey(keyPath, PVKName, "RSA");
						exception = encryption.decryptFileByRSA(filePath, savePath, fileName, (RSAPrivateKey)PVK);
						if(exception == 0)
						{
							JOptionPane.showMessageDialog(null, "解密成功", "Encryption",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(exception ==1)
						{
							JOptionPane.showMessageDialog(null, "檔案已存在", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else if(exception ==2)
						{
							JOptionPane.showMessageDialog(null, "該檔案非加密檔，請重新選擇", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else if(exception ==3)
						{
							JOptionPane.showMessageDialog(null, "請選擇檔案", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else if(exception == 4)
						{
							JOptionPane.showMessageDialog(null, "鑰匙錯誤，請選擇私鑰", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
						else if(exception ==5)
						{
							JOptionPane.showMessageDialog(null, "鑰匙錯誤，檔案已損毀", "ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(NullPointerException e)
					{
						JOptionPane.showMessageDialog(null, "請選擇私鑰", "WARNING",JOptionPane.WARNING_MESSAGE);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		);
		
		btnNewButton_2.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					RSAMenu rSAMenu;
					rSAMenu = new RSAMenu();
					rSAMenu.doit();
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
