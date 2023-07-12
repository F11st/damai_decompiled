package tb;

import com.taobao.weex.common.Constants;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jn1 {
    public static final String AND = "&&";
    public static final String AND_NOT = "!";
    public static final char ARRAY_END = ']';
    public static final String ARRAY_END_STR = "]";
    public static final char ARRAY_SEPRATOR = ',';
    public static final String ARRAY_SEPRATOR_STR = ",";
    public static final char ARRAY_START = '[';
    public static final String ARRAY_START_STR = "[";
    public static final char BLOCK_END = '}';
    public static final String BLOCK_END_STR = "}";
    public static final char BLOCK_START = '{';
    public static final String BLOCK_START_STR = "{";
    public static final char BRACKET_END = ')';
    public static final String BRACKET_END_STR = ")";
    public static final char BRACKET_START = '(';
    public static final String BRACKET_START_STR = "(";
    public static final char CONDITION_IF = '?';
    public static final char CONDITION_IF_MIDDLE = ':';
    public static final String CONDITION_IF_STRING = "?";
    public static final String DIV = "/";
    public static final char DOLLAR = '$';
    public static final String DOLLAR_STR = "$";
    public static final char DOT = '.';
    public static final String DOT_STR = ".";
    public static final String EQUAL = "===";
    public static final String EQUAL2 = "==";
    public static final String G = ">";
    public static final String GE = ">=";
    public static final Map<String, Object> KEYWORDS;
    public static final String L = "<";
    public static final String LE = "<=";
    public static final String MOD = "%";
    public static final String MUL = "*";
    public static final String NOT_EQUAL = "!==";
    public static final String NOT_EQUAL2 = "!=";
    public static final String OR = "||";
    public static final String PLUS = "+";
    public static final char QUOTE = '\"';
    public static final char SINGLE_QUOTE = '\'';
    public static final char SPACE = ' ';
    public static final String SPACE_STR = " ";
    public static final String SUB = "-";
    public static Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("}", 0);
        a.put(BRACKET_END_STR, 0);
        a.put(" ", 0);
        a.put(",", 0);
        a.put(ARRAY_END_STR, 0);
        a.put(OR, 1);
        a.put(AND, 1);
        a.put(EQUAL, 2);
        a.put(EQUAL2, 2);
        a.put(NOT_EQUAL, 2);
        a.put(NOT_EQUAL2, 2);
        a.put(G, 7);
        a.put(GE, 7);
        a.put(L, 7);
        a.put(LE, 8);
        a.put(PLUS, 9);
        a.put("-", 9);
        a.put(MUL, 10);
        a.put("/", 10);
        a.put("%", 10);
        a.put(AND_NOT, 11);
        a.put(".", 15);
        a.put(ARRAY_START_STR, 16);
        a.put(BRACKET_START_STR, 17);
        a.put(BLOCK_START_STR, 17);
        HashMap hashMap2 = new HashMap();
        KEYWORDS = hashMap2;
        hashMap2.put("null", null);
        hashMap2.put("true", Boolean.TRUE);
        hashMap2.put("false", Boolean.FALSE);
        hashMap2.put(Constants.Name.UNDEFINED, null);
    }

    public static Object a(zo2 zo2Var, zo2 zo2Var2, zo2 zo2Var3, Object obj) {
        if (zo2Var != null ? k(zo2Var.a(obj)) : false) {
            if (zo2Var2 != null) {
                return zo2Var2.a(obj);
            }
            return null;
        } else if (zo2Var3 != null) {
            return zo2Var3.a(obj);
        } else {
            return null;
        }
    }

    public static Object b(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        return Double.valueOf(e(zo2Var != null ? zo2Var.a(obj) : null) / e(zo2Var2 != null ? zo2Var2.a(obj) : null));
    }

    public static Object c(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        Object a2;
        Object a3;
        if (zo2Var == null || zo2Var2 == null || (a2 = zo2Var.a(obj)) == null) {
            return null;
        }
        if (zo2Var2.c() != 0) {
            Object a4 = zo2Var2.a(obj);
            if (a4 instanceof Double) {
                a4 = Integer.valueOf(((Double) a4).intValue());
            }
            a3 = d(a2, a4 == null ? "" : a4.toString().trim());
        } else {
            a3 = zo2Var2.a(a2);
        }
        return a3 != null ? a3 : o(a2, zo2Var2.b());
    }

    public static Object d(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof x7) {
            x7 x7Var = (x7) obj;
            for (int i = x7Var.i() - 1; i >= 0; i--) {
                Object b = x7Var.b(i);
                if (b instanceof Map) {
                    Map map = (Map) b;
                    if (map.containsKey(str)) {
                        return map.get(str);
                    }
                }
            }
        }
        if (obj instanceof Stack) {
            Stack stack = (Stack) obj;
            for (int size = stack.size() - 1; size >= 0; size--) {
                Object obj2 = stack.get(size);
                if (obj2 instanceof Map) {
                    Map map2 = (Map) obj2;
                    if (map2.containsKey(str)) {
                        return map2.get(str);
                    }
                }
            }
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof List) {
            try {
                return ((List) obj).get(Integer.parseInt(str));
            } catch (Exception unused) {
            }
        }
        if (obj.getClass().isArray()) {
            try {
                return Array.get(obj, Integer.parseInt(str));
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    public static double e(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static boolean f(String str) {
        char charAt = str.charAt(0);
        return charAt == '.' || charAt == '[';
    }

    public static boolean g(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean h(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        if (zo2Var == null && zo2Var2 == null) {
            return true;
        }
        Object a2 = zo2Var != null ? zo2Var.a(obj) : null;
        Object a3 = zo2Var2 != null ? zo2Var2.a(obj) : null;
        if (a2 == null) {
            if (a3 == null) {
                return true;
            }
            return (a3 instanceof CharSequence) && g(a3.toString());
        } else if (a3 == null) {
            return g(a2.toString());
        } else if (a2 instanceof Number) {
            return a3 instanceof Number ? ((Number) a2).doubleValue() == ((Number) a3).doubleValue() : ((Number) a2).doubleValue() == e(a3);
        } else if (a3 instanceof Number) {
            return e(a2) == ((Number) a3).doubleValue();
        } else if (!(a2 instanceof CharSequence) && !(a3 instanceof CharSequence)) {
            return a2.equals(a3);
        } else {
            return a2.toString().trim().equals(a3.toString().trim());
        }
    }

    public static boolean i(char c) {
        return c == ')' || c == ']' || c == ' ' || c == ',';
    }

    public static boolean j(String str) {
        return i(str.charAt(0));
    }

    public static boolean k(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue() != 0.0d;
        }
        String trim = obj.toString().trim();
        return ("false".equals(trim) || Constants.Name.UNDEFINED.equals(trim) || "null".equals(trim) || g(trim)) ? false : true;
    }

    public static Object l(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        return Double.valueOf(e(zo2Var != null ? zo2Var.a(obj) : null) % e(zo2Var2 != null ? zo2Var2.a(obj) : null));
    }

    public static Object m(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        return Double.valueOf(e(zo2Var != null ? zo2Var.a(obj) : null) * e(zo2Var2 != null ? zo2Var2.a(obj) : null));
    }

    public static Object n(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        Object a2 = zo2Var != null ? zo2Var.a(obj) : null;
        Object a3 = zo2Var2 != null ? zo2Var2.a(obj) : null;
        if ((a2 instanceof CharSequence) || (a3 instanceof CharSequence)) {
            if (a2 == null) {
                return a3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a2.toString());
            sb.append(a3 != null ? a3.toString() : "");
            return sb.toString();
        } else if ((a2 instanceof Number) || (a3 instanceof Number)) {
            return Double.valueOf(e(a2) + e(a3));
        } else {
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 == null) {
                return a3.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2.toString());
            sb2.append(a3 != null ? a3.toString() : "");
            return sb2.toString();
        }
    }

    public static Object o(Object obj, String str) {
        if ("length".equals(str)) {
            if (obj instanceof CharSequence) {
                return Integer.valueOf(((CharSequence) obj).length());
            }
            boolean z = obj instanceof Map;
            if (z) {
                return Integer.valueOf(((Map) obj).size());
            }
            if (z) {
                return Integer.valueOf(((Map) obj).size());
            }
            if (obj instanceof List) {
                return Integer.valueOf(((List) obj).size());
            }
            if (obj.getClass().isArray()) {
                return Integer.valueOf(Array.getLength(obj));
            }
            return null;
        }
        return null;
    }

    public static Object p(zo2 zo2Var, zo2 zo2Var2, Object obj) {
        return Double.valueOf(e(zo2Var != null ? zo2Var.a(obj) : null) - e(zo2Var2 != null ? zo2Var2.a(obj) : null));
    }

    public static double q(zo2 zo2Var, Object obj) {
        if (zo2Var == null) {
            return 0.0d;
        }
        return e(zo2Var.a(obj));
    }

    public static boolean r(zo2 zo2Var, Object obj) {
        if (zo2Var == null) {
            return false;
        }
        return k(zo2Var.a(obj));
    }
}
