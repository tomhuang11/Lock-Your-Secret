import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RSAKey extends JFrame
{
	public RSAKey()
	{
		getContentPane().setLayout(null);
		
		JButton button = new JButton("BACK");
		button.setFont(new Font("Bradley Hand ITC", Font.BOLD, 26));
		button.setBounds(419, 256, 150, 90);
		getContentPane().add(button);
		
		button.addActionListener
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
		
		JButton btnNewButton = new JButton("Specific Key Pair");
		btnNewButton.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		btnNewButton.setBounds(20, 20, 260, 150);
		getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("random key pair");
		button_1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		button_1.setBounds(20, 191, 260, 150);
		getContentPane().add(button_1);
		
		btnNewButton.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					dispose();
					RSASpecificKey rSASpecificKey = new RSASpecificKey();
					rSASpecificKey.doit();
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
					RSARandomKey rSARandomKey = new RSARandomKey();
					rSARandomKey.doit();
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
