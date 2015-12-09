package graphiccalc;

import java.util.Arrays;

/**
 * Classe Parser pour le traitement d'une expression arithmétique
 * @author Thomas STOCKER - Anthony Den Drijver
 */
public class Parser {

    public static String str;
    public static int cur;
    public static char last_char;
    public static String fnc;
    public static char[] authorized_char = new char[]{'+', '-', '*', '/', '(', ')', '.', 'x', 'π', '^'};
    public static String[] authorized_func = new String[]{"sin", "cos", "tan", "log", "ln"};
    
    /**
    * Réinitialise les données du parser
    */
    public static void init() {
        str = "";
        fnc = "";
        last_char = '\u0000';
        cur = 0;
    }
    
    /**
    * Lit un caractère de str, et avance de une position dans la chaine en renvoyant vrai si ce caractère
    * match avec celui passé en paramètre
    * @param c : Le char à matcher
    * @return boolean : Le caractère lu était le caractère passé en paramètre
    */
    public static boolean read_char(char c) {
        if (cur < str.length() && (str.charAt(cur) == c)) {
            last_char = c;
            cur++;
            return true;
        }

        return false;
    }
    
    /**
     * Vérifie si l'expression contient l'une des fonctions arithmétique supportée,
     * et la traite le cas échéant
     * @return boolean : Une fonction à été matchée
     */
    public static boolean read_func() {
        String f;
        int arr_size = authorized_func.length;
        
        for (int i = 0; i < arr_size; i++) {
            f = authorized_func[i];
            int size = f.length();

            if ((cur + size) < str.length()) {
                String extract = str.substring(cur, cur + size);

                // ** La fonction lue fait partie des fonctions supportées
                if (f.equals(extract)) {
                    cur += size;
                    fnc = extract;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @return 
     */
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

    /**
     * 
     * @return 
     */
    public static EXPR read_e_m() {
        EXPR result;
        EXPR right;
        char op;
        result = read_e_e();

        if (result != null) {
            while (read_char('*') || read_char('/')) {
                op = last_char;
                right = read_e_e();

                if (right == null) {
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
    
    public static EXPR read_e_e() {
        EXPR result;
        EXPR right;
        char op;
        result = read_e_u();

        if (result != null) {
            while (read_char('^')) {
                op = last_char;
                right = read_e_u();

                if (right == null) {
                    show_error();
                    result = null;
                }

                result = new EXP(result, right);
            }
        }

        return result;
    }

    /**
     * 
     * @return 
     */
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

        } 
        else if (read_func()) {
            
            result = read_e_u();
            if (result != null) {
                
                switch (fnc) {
                    case "sin" :
                        result = new SIN(result);
                        break;
                    case "cos" :
                        result = new COS(result);
                        break;
                    case "tan" :
                        result = new TAN(result);
                        break;
                    case "log" :
                        result = new LOG(result);
                        break;
                    case "ln" :
                        result = new LN(result);
                        break;
                    default :
                        result = null;
                }
            } else {
                show_error();
            }
        }
        else {
            result = read_cst();
        }

        return result;
    }

    /**
     * 
     * @return EXPR : Objet CONST
     */
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
        }
        else if (read_char('x')) {
            // -- C'est une variable
            result = new VAR();
        }
        else if (read_char('π')) {
            result = new PI();
        }
        else {
            while (read_double()) {
                op = last_char;
                number_str += op;

            }
            if (number_str.compareTo("") != 0) {
                result = new CONST(Double.parseDouble(number_str));
            }
        }

        return result;
    }
    
    /**
     * 
     * @return 
     */
    public static boolean read_double() {        
        if (cur < str.length()) {
            char c = str.charAt(cur);
                       
            if (Character.isDigit(c) || c == '.') {
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
    
    /**
     * 
     * @param exp
     * @return 
     */
    public static boolean test_Expr(String exp) {
        char c = exp.charAt(exp.length() - 1);
        
        return Character.isDigit(c) || charInArray(c, authorized_char);
    }
    
    /**
     * 
     * @param c
     * @param arr
     * @return 
     */
    public static boolean charInArray(char c, char[] arr) {
        boolean test = false;
        
        if ((new String(arr).indexOf(c)) != -1) {
            test = true;
        }
        
        return test;
    }
    
    public static double calc_var(EXPR e, double x) {
        return e.eval(x);
    }

    /**
     * Affichage en cas d'erreur avec la position n'ayant pas été reconnue par le Parser
     */
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
