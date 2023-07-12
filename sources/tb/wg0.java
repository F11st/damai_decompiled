package tb;

import android.util.Pair;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wg0 {
    public static final Set<String> OPS;
    private static Pattern a = Pattern.compile("\\$\\{[a-zA-Z()\\. _\\-\\[\\]0-9]*(?!\\$\\{[a-zA-Z()\\. \\_\\-\\[\\]0-9]*\\})[a-zA-Z()\\. \\_\\-\\[\\]0-9]*\\}");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        public boolean a;
        public Object b;

        private b() {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        OPS = hashSet;
        hashSet.add(DXRecyclerLayout.LOAD_MORE_EMPTY);
        hashSet.add(m80.NOT_PREFIX);
        hashSet.add("deleteifnull");
    }

    private static void a(Object obj, Object obj2, b bVar) {
        bVar.b = d(obj, "${" + obj2 + "}");
        bVar.a = b(obj, obj2) > 0;
    }

    private static int b(Object obj, Object obj2) {
        if (obj2 instanceof String) {
            Object d = d(obj, "${" + obj2 + "}");
            if (d instanceof String) {
                String trim = ((String) d).trim();
                if ("true".equalsIgnoreCase(trim)) {
                    return 0;
                }
                return (!"false".equalsIgnoreCase(trim) && trim.length() > 0) ? 0 : 1;
            }
            return b(obj, d);
        } else if (obj2 == null) {
            return 1;
        } else {
            if (obj2 instanceof Number) {
                return ((Number) obj2).intValue() != 0 ? 0 : 1;
            } else if (obj2 instanceof Boolean) {
                return !((Boolean) obj2).booleanValue();
            } else {
                if (obj2 instanceof List) {
                    return ((List) obj2).isEmpty() ? 1 : 0;
                }
                if (obj2.getClass().isArray()) {
                    try {
                        return Array.getLength(obj2) > 0 ? 0 : 1;
                    } catch (Exception unused) {
                        return 0;
                    }
                } else if (obj2 instanceof Map) {
                    return ((Map) obj2).isEmpty() ? 1 : 0;
                } else {
                    return 0;
                }
            }
        }
    }

    private static int c(Object obj, Object obj2) {
        if (obj2 instanceof String) {
            String str = "${" + obj2 + "}";
            Object d = d(obj, str);
            if (d instanceof String) {
                String str2 = (String) d;
                if ("true".equalsIgnoreCase(str2)) {
                    return 0;
                }
                if ("false".equalsIgnoreCase(str2)) {
                    return 1;
                }
                try {
                    return Integer.parseInt(str2) == 0 ? 1 : 0;
                } catch (Exception unused) {
                    return str.length() > 0 ? 0 : 1;
                }
            }
            return c(obj, d);
        } else if (obj2 instanceof Number) {
            return ((Number) obj2).intValue() != 0 ? 0 : 1;
        } else if (obj2 instanceof Boolean) {
            return !((Boolean) obj2).booleanValue();
        } else {
            return 0;
        }
    }

    public static Object d(Object obj, String str) {
        Object a2;
        if (obj == null || str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        for (Matcher matcher = a.matcher(sb); matcher.find(); matcher = a.matcher(sb)) {
            int start = matcher.start();
            int end = matcher.end();
            int length = sb.length();
            String group = matcher.group();
            Pair<String, String> f = f(group);
            if (f != null) {
                b e = e((String) f.first, f.second, obj);
                a2 = e.b;
                if (e.a) {
                    return a2;
                }
            } else {
                a2 = com.taobao.android.ultron.expr.c.a(obj, group);
            }
            if (start == 0 && end == length) {
                return a2;
            }
            sb.replace(start, end, a2 == null ? "" : a2.toString());
        }
        return sb.toString();
    }

    private static b e(String str, Object obj, Object obj2) {
        b bVar = new b();
        if (DXRecyclerLayout.LOAD_MORE_EMPTY.equalsIgnoreCase(str)) {
            bVar.b = Integer.valueOf(b(obj2, obj));
            return bVar;
        } else if (m80.NOT_PREFIX.equalsIgnoreCase(str)) {
            bVar.b = Integer.valueOf(c(obj2, obj));
            return bVar;
        } else if ("deleteIfNull".equalsIgnoreCase(str)) {
            a(obj2, obj, bVar);
            return bVar;
        } else {
            bVar.b = obj;
            return bVar;
        }
    }

    private static Pair<String, String> f(String str) {
        String trim = str.substring(str.indexOf(jn1.BLOCK_START_STR) + 1, str.length() - 1).trim();
        String[] split = trim.split(" ");
        if (split.length <= 0) {
            return null;
        }
        String str2 = split[0];
        if (g(str2)) {
            return new Pair<>(str2, trim.substring(str2.length()));
        }
        return null;
    }

    private static boolean g(String str) {
        return OPS.contains(str.toLowerCase());
    }
}
