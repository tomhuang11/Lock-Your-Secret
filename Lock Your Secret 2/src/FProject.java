import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class FProject extends JFrame
{
	AESMenu aESMenu;
	RSAMenu rSAMenu;
	
	public FProject()
	{
		getContentPane().setBackground(SystemColor.info);
		getContentPane().setFont(new Font("Bradley Hand ITC", Font.PLAIN, 12));
		getContentPane().setForeground(new Color(255, 240, 245));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("AES");
		btnNewButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
		btnNewButton.setToolTipText("");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setBounds(25, 186, 250, 150);
		
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					aESMenu = new AESMenu();
					
					aESMenu.doit();
				}
			}
		);
		
		JButton btnRsaCryptosystemdecryption = new JButton("RSA");
		btnRsaCryptosystemdecryption.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
		btnRsaCryptosystemdecryption.setForeground(Color.BLUE);
		btnRsaCryptosystemdecryption.setBackground(new Color(255, 222, 173));
		btnRsaCryptosystemdecryption.setBounds(309, 186, 250, 150);
		getContentPane().add(btnRsaCryptosystemdecryption);
		
		btnRsaCryptosystemdecryption.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					rSAMenu = new RSAMenu();
					rSAMenu.doit();
				}
			}
		);
		
		JLabel lblLockYourSecret = new JLabel("LOCK  YOUR  SECRET");
		lblLockYourSecret.setFont(new Font("Bradley Hand ITC", Font.BOLD, 46));
		lblLockYourSecret.setHorizontalAlignment(SwingConstants.CENTER);
		lblLockYourSecret.setBackground(Color.WHITE);
		lblLockYourSecret.setBounds(10, 10, 564, 166);
		getContentPane().add(lblLockYourSecret);
	}
	
	public void doit()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
