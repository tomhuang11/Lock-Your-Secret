import java.awt.Dimension;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main
{
	public static void main(String[] args)
	{
		FProject fProject = new FProject();
		fProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fProject.setSize(600, 400);
		fProject.setLocationRelativeTo(null);
		fProject.setVisible(true);
	}
	
}
