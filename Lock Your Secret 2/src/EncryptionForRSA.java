import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class EncryptionForRSA
{	
	private int coverOption = -1;
	
	public void setCoverOption(int coverOption) 
	{
		this.coverOption = coverOption;
	}
	
	public int encryptFileByRSA (String filePath, String savePath, String fileName, RSAPublicKey PBK, int cryptType) throws IOException
	{	
		try
		{	
			File oldFile = new File(savePath + "/" + fileName + ".lysenc");
			if(oldFile.exists())
			{
				if(coverOption == 1)
				{
					oldFile.delete();
				}
			}
			
			if(!oldFile.exists())
			{
				File file = new File(filePath + "/" + fileName);
				FileInputStream FIS = new FileInputStream(file);
				byte[] data = new byte[FIS.available()];
				FIS.read(data);
				FIS.close();
				
				Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				cipher.init(Cipher.ENCRYPT_MODE, PBK);
				
				if(cryptType == 1)
				{
					FileOutputStream FOS = new FileOutputStream(filePath + "/" + fileName);
					FOS.write(this.blockCipher(data, cipher, Cipher.ENCRYPT_MODE));
					FOS.close();
					Path source = Paths.get(filePath + "/" + fileName);
					Path target = Paths.get(savePath + "/" + "RSA");
					Files.move(source, target.resolveSibling(fileName + ".lysenc"));
					return 0;
				}
				else if(cryptType == 2)
				{
					
					FileOutputStream FOS = new FileOutputStream(savePath + "/" + fileName + ".lysenc");
					FOS.write(this.blockCipher(data, cipher, Cipher.ENCRYPT_MODE));
					FOS.close();
					return 0;
				}
			}
			return 1;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			return 2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	public int decryptFileByRSA (String filePath, String savePath, String fileName, RSAPrivateKey PVK) throws IOException
	{		
		try
		{
			String[] name = fileName.split("\\.");
			
			if(name[name.length - 1].equals("lysenc"))
			{	
				for(int i = 1; i < name.length - 1; i++)
				{
					name[0] = name[0].concat("." + name[i]);
				}
				
				File oldFile = new File(savePath + "/" + name[0]);
				if(oldFile.exists())
				{
					if(coverOption == 1)
					{
						oldFile.delete();
					}
				}
				
				if(!oldFile.exists())
				{
					File file = new File(filePath + "/" + fileName);
					FileInputStream FIS = new FileInputStream(file);
					byte[] data = new byte[FIS.available()];
					FIS.read(data);
					FIS.close();
					
					Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
					cipher.init(Cipher.DECRYPT_MODE, PVK);
					
					FileOutputStream FOS = new FileOutputStream(filePath + "/" + fileName);
					FOS.write(this.blockCipher(data, cipher, Cipher.DECRYPT_MODE));
					FOS.close();
					
					Path source = Paths.get(filePath + "/" + fileName);
					Path target = Paths.get(savePath + "/" + "RSA");
					Files.move(source, target.resolveSibling(name[0]));
					return 0;
				}
				return 1;
			}
			else
			{
				return 2;
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return 3;
		}
		catch(InvalidKeyException e)
		{
			e.printStackTrace();
			return 4;
		}
		catch(BadPaddingException e)
		{
			e.printStackTrace();
			return 5;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	private byte[] blockCipher(byte[] bytes, Cipher cipher, int mode) throws IllegalBlockSizeException, BadPaddingException
	{
		byte[] scrambled = new byte[0];
		byte[] toReturn = new byte[0];
		int length = (mode == Cipher.ENCRYPT_MODE) ? 100 : 128;
		byte[] buffer = new byte[length];
		
		for(int i = 0; i < bytes.length; i++)
		{
			if((i > 0) && (i % length == 0))
			{
				scrambled = cipher.doFinal(buffer);
				toReturn = this.appendBytes(toReturn, scrambled);
				
				int newLength = length;
				
				if((i + length) > bytes.length)
				{
					newLength = bytes.length - i;
				}
				buffer = new byte[newLength];
			}
			buffer[i%length] = bytes[i];
		}
		scrambled = cipher.doFinal(buffer);
		toReturn = this.appendBytes(toReturn, scrambled);
		
		return toReturn;
	}
	
	private byte[] appendBytes(byte[] prefix, byte[] suffix)
	{
		byte[] toReturn = new byte[prefix.length + suffix.length];
		for(int i = 0; i < prefix.length; i++)
		{
			toReturn[i] = prefix[i];
		}
		for(int i = 0; i < suffix.length; i++)
		{
			toReturn[i + prefix.length] = suffix[i];
		}
		return toReturn;
	}
}