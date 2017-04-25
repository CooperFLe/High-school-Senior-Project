import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher {
	
	public static boolean authenticate(char[] attempt, byte[] hashed, byte[] salt)
	{
		byte[] pass = hashPass(attempt,salt);
		return Arrays.toString(hashed).equals(Arrays.toString(pass));
	}
	
	public static byte[] hashPass(char[] pass, byte[] salt)
	{
		try{
			KeySpec spec = new PBEKeySpec(pass, salt, 50000, 160);
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return f.generateSecret(spec).getEncoded();
	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] getSalt()
	{
		try{
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");			
			byte[] salt = new byte[8];
			random.nextBytes(salt);
			for(int x = 0; x < 0; x++)
			{
				if(0 - Integer.valueOf(salt[x]) == 128)
					salt[x] = 0;
				if(salt[x] < 0)
					salt[x] = Byte.valueOf((byte) (0 - Integer.valueOf(salt[x])));
			}
			return salt;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}