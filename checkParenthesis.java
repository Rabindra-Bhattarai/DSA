public class checkParenthesis {
    boolean checkParenthesisis(String exp) {
        stacks stk = new Stacks(exp.length());
        String openbraces = "[{(";
        String closebraces = ")}]";
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stk.push(ch);
            } else {
                // closed bracket
                int indx = closedbraces.indexOf(ch);
                char openbracket = openbraces.charAt(indx);
                if (stk.isEmpty()) {
                    return false;
                }
                if (ch != stk.pop()) {
                    return false;
                }
            }
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }
}
