package za.co.team02.utils;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.team02.model.SiteUser;
import za.co.team02.repository.AuthRepository;
import za.co.team02.repository.UserRepository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
    public Utils()
    {
    }

    /**
     * take plain text and hash to a 32 char string
     */
    public static String hashPassword(String password)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytePassword = digest.digest(
                    password.getBytes());

            BigInteger no = new BigInteger(1, bytePassword);
            String hashedPassword = no.toString(16);

            while (hashedPassword.length() < 32) {
                hashedPassword = "0" + hashedPassword;
            }
            return hashedPassword;

        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param passwordToCompare - input password
     * @param user - the user in db. take password and compare it to passwordToCompare
     * @return - true for match. false for incorrect password.
     */
    public static Boolean checkPasswords(String passwordToCompare, SiteUser user)
    {
        if(hashPassword(passwordToCompare).equals(user.getPassword()))
        {
            //Password Matches
            return true;
        }
        //Password not correct or user doesn't exist.
        return false;
    }
}
