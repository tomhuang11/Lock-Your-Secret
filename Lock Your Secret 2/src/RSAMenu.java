import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RSAMenu extends JFrame
{
	FProject fproject;
	RSAKey rSAKey;
	
	public RSAMenu()
	{
		getContentPane().setBackground(SystemColor.info);
		getContentPane().setLayout(null);
		
		JButton btnGetRsaKey = new JButton("GET RSA KEY");
		btnGetRsaKey.setFont(new Font("Bradley Hand ITC", Font.BOLD, 23));
		btnGetRsaKey.setBounds(15, 15, 200, 100);
		getContentPane().add(btnGetRsaKey);
		
		btnGetRsaKey.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					rSAKey = new RSAKey();
					rSAKey.doit();
				}
			}
		);
		
		JButton btnEncryption = new JButton("ENCRYPT");
		btnEncryption.setFont(new Font("Bradley Hand ITC", Font.BOLD, 26));
		btnEncryption.setBounds(15, 130, 200, 100);
		getContentPane().add(btnEncryption);
		
		JButton btnDecryption = new JButton("DECRYPT");
		btnDecryption.setFont(new Font("Bradley Hand ITC", Font.BOLD, 26));
		btnDecryption.setBounds(15, 246, 200, 100);
		getContentPane().add(btnDecryption);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Bradley Hand ITC", Font.BOLD, 26));
		btnBack.setBounds(429, 276, 140, 70);
		getContentPane().add(btnBack);
		
		btnBack.addActionListener
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
		
		btnEncryption.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					RSAEncryption rSAEncryption = new RSAEncryption();
					rSAEncryption.doit();
				}
			}
		);
		
		btnDecryption.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					RSADecryption rSADecryption = new RSADecryption();
					rSADecryption.doit();
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
