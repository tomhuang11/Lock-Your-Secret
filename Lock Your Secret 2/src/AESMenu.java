import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AESMenu extends JFrame
{
	FProject fproject;
	AESEncryption aESEncryption;
	AESDecryption aESDecryption;
	
	public AESMenu()
	{
		getContentPane().setLayout(null);
		
		JButton button = new JButton("ENCRYPT");
		button.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		button.setBounds(20, 20, 260, 150);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("DECRYPT");
		button_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 30));
		button_1.setBounds(20, 191, 260, 150);
		getContentPane().add(button_1);
		
		JButton button_3 = new JButton("BACK");
		button_3.setFont(new Font("Bradley Hand ITC", Font.BOLD, 26));
		button_3.setBounds(419, 256, 150, 90);
		getContentPane().add(button_3);
		
		button.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					aESEncryption = new AESEncryption();
					aESEncryption.doit();
				}
			}
		);
		
		button_3.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					fproject = new FProject();
					fproject.doit();
				}
			}
		);
		
		button_1.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					aESDecryption = new AESDecryption();
					aESDecryption.doit();
				}
			}
		);
	}
	
	public void doit()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
