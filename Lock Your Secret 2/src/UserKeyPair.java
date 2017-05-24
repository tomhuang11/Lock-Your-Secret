import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.io.FileNotFoundException;

import javax.crypto.BadPaddingException;
public class UserKeyPair
{
	private int exception;
	public int getException() {
		return exception;
	}
	public String getHexString(byte[] b)
	{
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < b.length; i++)
		{
			result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}
	
	public int SaveKeyPair(String path, String PBKName, String PVKName, KeyPair keyPair) throws IOException //save keypair
	{
		try
		{
			File PBKOldFile = new File(path + "/" + PBKName + ".pbkey");
			File PVKOldFile = new File(path + "/" + PVKName + ".pvkey");
			if(PBKOldFile.exists())
			{
				return 1;
			}
			if(PVKOldFile.exists())
			{
				return 2;
			}
			
			PublicKey PBK = keyPair.getPublic();
			PrivateKey PVK = keyPair.getPrivate();
		
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(PBK.getEncoded());
			FileOutputStream FOS = new FileOutputStream(path + "/" + PBKName + ".pbkey"); //save public key file
			FOS.write(x509EncodedKeySpec.getEncoded());
			FOS.close();
		
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(PVK.getEncoded());
			FOS = new FileOutputStream(path + "/" +PVKName +  ".pvkey"); //save private key file
			FOS.write(pkcs8EncodedKeySpec.getEncoded());
			FOS.close();
			return 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	public PublicKey LoadPublicKey(String path, String PBKName, String alogorithm) throws IOException, NoSuchAlgorithmException//load keypair
	{
		try
		{
			File filePublicKey = new File(path + "/" + PBKName); //load public key file
			FileInputStream FIS = new FileInputStream(filePublicKey);
			byte[] encodedPublicKey = new byte[(int)filePublicKey.length()];
			FIS.read(encodedPublicKey);
			FIS.close();
			
			KeyFactory keyFactory = KeyFactory.getInstance(alogorithm);
			X509EncodedKeySpec PBKSpec = new X509EncodedKeySpec(encodedPublicKey);
			PublicKey PBK = keyFactory.generatePublic(PBKSpec);
			this.exception = 0;
			return PBK;
		}
		catch(FileNotFoundException e)
		{
			this.exception = 1;
			return null;
		}
		catch(InvalidKeySpecException e)
		{
			this.exception = 2;
			return null;
		}
	}
	
	public PrivateKey LoadPrivateKey(String path, String PVKName, String alogorithm) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException //load keypair
	{
		try
		{
			File filePrivateKey = new File(path + "/" + PVKName); //load private key file
			FileInputStream FIS = new FileInputStream(filePrivateKey);
			byte[] encodedPrivateKey = new byte[(int)filePrivateKey.length()];
			FIS.read(encodedPrivateKey);
			FIS.close();
			
			KeyFactory keyFactory = KeyFactory.getInstance(alogorithm);
			PKCS8EncodedKeySpec PVKSpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
			PrivateKey PVK = keyFactory.generatePrivate(PVKSpec);
			this.exception = 0;
			return PVK;
		}
		catch(FileNotFoundException e)
		{
			this.exception = 1;
			return null;
		}
		catch(InvalidKeySpecException e)
		{
			this.exception = 2;
			return null;
		}
	}
}