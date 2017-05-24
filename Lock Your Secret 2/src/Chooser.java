import java.io.File;

import javax.swing.JFileChooser;

public class Chooser 
{
	private String path;
	private String name;
	private String parent;
	private String keyPath;
	private String keyName;
	private String keyParent;
	
	public String getParent()
	{
		return parent;
	}
	
	public String getPath() 
	{
		return path;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getKeyParent()
	{
		return keyParent;
	}
	
	public String getKeyPath() 
	{
		return keyPath;
	}
	
	public String getKeyName() 
	{
		return keyName;
	}
	
	public void chooser()
	{
		try
		{
			JFileChooser chooser = new JFileChooser();
			int ret = chooser.showOpenDialog(null);
			if(ret == JFileChooser.APPROVE_OPTION)
			{
				this.path = chooser.getSelectedFile().getAbsolutePath();
				this.name = chooser.getSelectedFile().getName();
				this.parent = chooser.getSelectedFile().getParent();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void chooser(String path)
	{
		try
		{
			JFileChooser chooser = new JFileChooser("." + File.separator + path);
			int ret = chooser.showOpenDialog(null);
			if(ret == JFileChooser.APPROVE_OPTION)
			{
				this.path = chooser.getSelectedFile().getAbsolutePath();
				this.name = chooser.getSelectedFile().getName();
				this.parent = chooser.getSelectedFile().getParent();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void chooserKey()
	{
		try
		{
			JFileChooser chooser = new JFileChooser("." + File.separator + "Keys");
			int ret = chooser.showOpenDialog(null);
			if(ret == JFileChooser.APPROVE_OPTION)
			{
				this.keyPath = chooser.getSelectedFile().getAbsolutePath();
				this.keyName = chooser.getSelectedFile().getName();
				this.keyParent = chooser.getSelectedFile().getParent();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
