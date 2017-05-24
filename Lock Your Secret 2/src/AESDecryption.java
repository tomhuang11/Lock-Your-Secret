import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;

public class AESDecryption extends JFrame
{
	String PVK = "lockyoursecretss";
	private String filePath;
	private String fileName;
	private String savePath = "Decrypted Files/AES";
	private int x = -1;
	private int exception;
	
	public AESDecryption()
	{
		final EncryptionForAES encryption = new EncryptionForAES();
		final Chooser chooser = new Chooser();
		
		JLabel lblEncryption = new JLabel("AES \u89E3\u5BC6");
		getContentPane().add(lblEncryption, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
		panel_16.setLayout(new GridLayout(3, 3, 50, 10));
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19);
		
		JLabel lblNewLabel_2 = new JLabel("\u8ACB\u9078\u64C7\u6A94\u6848\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_16.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u700F\u89BD");
		panel_16.add(btnNewButton);
		
		JPanel panel_20 = new JPanel();
		panel_16.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_16.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_16.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_16.add(panel_23);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel label = new JLabel("\u6A94\u6848\u8DEF\u5F91\uFF1A");
		panel_13.add(label);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		panel_13.add(lblNewLabel_1);
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 3, 0, 10));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JButton btnNewButton_2 = new JButton("Back");
		panel_4.add(btnNewButton_2);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u8986\u84CB\u5DF2\u5B58\u5728\u6A94\u6848");
		panel_11.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Decryption");
		panel_4.add(btnNewButton_1);
		
		rdbtnNewRadioButton_2.addItemListener
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
					chooser.chooser("Encrypted Files/AES");
					lblNewLabel_1.setText(chooser.getPath());
				}
			}
		);
		
		btnNewButton_1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					try
					{
						fileName = chooser.getName();
						filePath = chooser.getParent();
						exception = encryption.decryptFileByAES(filePath, savePath, fileName, PVK);
						if(exception == 0)
						{
							JOptionPane.showMessageDialog(null, "解密成功", "Encryption",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(exception ==1)
						{
							JOptionPane.showMessageDialog(null, "檔案已存在", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else if(exception == 2)
						{
							JOptionPane.showMessageDialog(null, "該檔案非加密檔，請重新選擇", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else if(exception ==3)
						{
							JOptionPane.showMessageDialog(null, "請選擇檔案", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
						else;
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
					AESMenu aESMenu;
					aESMenu = new AESMenu();
					aESMenu.doit();
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
