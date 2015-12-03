/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiccalc;

/**
 *
 * @author Thomas STOCKER
 */
public class Parser {

    public static String str;
    public static int cur;
    public static char last_char;
    public static char[] authorized_char = new char[]{'+', '-', '*', '/','(',')'};

    public static boolean read_char(char c) {
        if (cur < str.length() && (str.charAt(cur) == c)) {
            last_char = c;
            cur++;
            return true;
        }

        return false;
    }

    public static EXPR read_e() {
        if (!test_Expr(str)) {
            cur = str.length() - 1;
            show_error();
        }
        
        EXPR result;
        EXPR right;
        char op;
        result = read_e_m();

        if (result != null) {
            while (read_char('+') || read_char('-')) {
                op = last_char;
                right = read_e_m();

                if (right == null) {
                    // -- Gérer l'erreur
                    show_error();
                    result = null;
                }

                if (op == '+') {
                    result = new ADD(result, right);
                } else {
                    result = new SUB(result, right);
                }
            }
        }

        return result;
    }

    public static EXPR read_e_m() {
        EXPR result;
        EXPR right;
        char op;
        result = read_e_u();

        if (result != null) {
            while (read_char('*') || read_char('/')) {
                op = last_char;
                right = read_e_m();

                if (right == null) {
                    // -- Gérer l'erreur
                    show_error();
                    result = null;
                }

                if (op == '*') {
                    result = new MUL(result, right);
                } else {
                    result = new DIV(result, right);
                }
            }
        }

        return result;
    }

    public static EXPR read_e_u() {
        EXPR result;
        char op;

        if (read_char('-') || read_char('+')) {
            op = last_char;
            result = read_e_u();

            if (result != null) {
                if (op == '-') {
                    result = new NEG(result);
                } else {
                    result = new POS(result);
                }
            } else {
                show_error();
            }

        } else {
            result = read_cst();
        }

        return result;
    }

    public static EXPR read_cst() {
        EXPR result = null;
        char op;
        String number_str = "";

        if (read_char('(')) {
            result = read_e();

            if (result == null) {
                show_error();
            } else {
                if (read_char(')')) {
                    return result;
                }
            }
        } else {
            while (read_int()) {
                op = last_char;
                number_str += op;

            }
            if (number_str.compareTo("") != 0) {
                result = new CONST(Integer.parseInt(number_str));
            }
        }

        return result;
    }

    public static boolean read_int() {

        if (cur < str.length()) {
            char c = str.charAt(cur);
                       
            if (Character.isDigit(c)) {
                last_char = str.charAt(cur);
                cur++;
                return true;
            } else {
                if (charInArray(c, authorized_char) && !(cur == str.length() - 1)) {
                    return false;
                }
                else {
                    if (c != ')')
                        show_error();
                }
            }
        }

        return false;
    }
    
    public static boolean test_Expr(String exp) {
        char c = exp.charAt(exp.length() - 1);
        
        if (Character.isDigit(c) || charInArray(c, authorized_char)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean charInArray(char c, char[] arr) {
        boolean test = false;
        
        if ((new String(arr).indexOf(c)) != -1) {
            test = true;
        }
        
        return test;
    }

    public static void show_error() {
        int i;
        System.err.println(str);
        for (i = 0; i < cur; i++) {
            System.err.print(" ");
        }
        System.err.println("^");
        System.exit(1);
    }

}
