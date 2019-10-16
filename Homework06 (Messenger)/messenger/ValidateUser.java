package messenger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {

    public static boolean checkUser(User user){
        boolean flag;
        Pattern patUser = Pattern.compile("^[a-zA-Z]+\\d*[^!^#^\\\\\\\\]{4,}");
        Matcher matUser = patUser.matcher(user.getLogin());
        if (matUser.find()){
            flag = true;
        } else
            flag = false;
        return flag;
    }

    public static boolean checkPassword(User password){
        boolean flag=true;
        return flag;
    }
}
