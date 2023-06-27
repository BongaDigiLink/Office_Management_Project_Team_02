package za.co.team02.utils;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.team02.dao.UserDAO;
import za.co.team02.model.SiteUser;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
    @Autowired
    private UserDAO user;
    private static String hashPassword(String password)
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

    private Boolean checkPasswords(String passwordToCompare, SiteUser user)
    {
        SiteUser user_ = this.user.findByEmail(user.getEmail());
        if(hashPassword(user.getPassword()).equals(user_.getPassword()))
        {
            //Password Matches
            return true;
        }

        //Password not correct or user doesnt exist.
        return false;
    }
}
