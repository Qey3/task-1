package task.regexpr;

public class CheckRegExpr {
    public static boolean checkEmail(String email) {
        return email.matches(".+[@].+[.].+");
    }

    public static boolean checkRoles(String roles) {
        return roles.split(",").length <= 3 && !roles.equals("");
    }

    public static boolean checkPhones(String phone) {
        if (phone.equals("")) return false;
        String phones[] = phone.split(",");
        if (phones.length > 3) return false;
        for (String buff : phones) {
            if (!buff.matches("375\\d{2}\\s\\d{7}")) return false;
        }
        return true;
    }
}
