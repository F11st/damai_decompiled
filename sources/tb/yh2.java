package tb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class yh2 {
    public static String a(Map<String, String> map) {
        if (map != null) {
            boolean z = true;
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : map.keySet()) {
                String c = c(map.get(str));
                String c2 = c(str);
                if (c != null && c2 != null) {
                    if (z) {
                        stringBuffer.append(c2 + "=" + c);
                        z = false;
                    } else {
                        stringBuffer.append(",");
                        stringBuffer.append(c2 + "=" + c);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static String b(Map<String, String> map) {
        if (map != null) {
            boolean z = true;
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : map.keySet()) {
                String c = c(map.get(str));
                String c2 = c(str);
                if (c != null && c2 != null) {
                    if (z) {
                        try {
                            stringBuffer.append(URLEncoder.encode(c2, "UTF-8") + "=" + URLEncoder.encode(c, "UTF-8"));
                            z = false;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            stringBuffer.append(",");
                            stringBuffer.append(URLEncoder.encode(c2, "UTF-8") + "=" + URLEncoder.encode(c, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static String c(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Integer) {
                return "" + ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                return "" + ((Long) obj).longValue();
            } else if (obj instanceof Double) {
                return "" + ((Double) obj).doubleValue();
            } else if (obj instanceof Float) {
                return "" + ((Float) obj).floatValue();
            } else if (obj instanceof Short) {
                return "" + ((int) ((Short) obj).shortValue());
            } else if (obj instanceof Byte) {
                return "" + ((int) ((Byte) obj).byteValue());
            } else if (obj instanceof Boolean) {
                return ((Boolean) obj).toString();
            } else {
                if (obj instanceof Character) {
                    return ((Character) obj).toString();
                }
                return obj.toString();
            }
        }
        return "";
    }

    public static int d(String str) {
        if (str.length() > 0) {
            int i = 0;
            for (char c : str.toCharArray()) {
                i = (i * 31) + c;
            }
            return i;
        }
        return 0;
    }

    public static boolean e(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean g(String str) {
        return !e(str);
    }

    public static String h(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            stringBuffer.append(next.getKey().toString());
            stringBuffer.append("'");
            String str = "";
            stringBuffer.append(next.getValue() == null ? "" : next.getValue().toString());
            if (it.hasNext()) {
                str = "^";
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> i(String str) {
        HashMap hashMap = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "^");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "'");
            hashMap.put(stringTokenizer2.nextToken(), stringTokenizer2.hasMoreTokens() ? stringTokenizer2.nextToken() : null);
        }
        return hashMap;
    }
}
