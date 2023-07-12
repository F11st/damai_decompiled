package tb;

import android.util.Pair;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.ultron.expr.C6667c;
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
    /* renamed from: tb.wg0$b */
    /* loaded from: classes11.dex */
    public static class C9866b {
        public boolean a;
        public Object b;

        private C9866b() {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        OPS = hashSet;
        hashSet.add(DXRecyclerLayout.LOAD_MORE_EMPTY);
        hashSet.add(m80.NOT_PREFIX);
        hashSet.add("deleteifnull");
    }

    private static void a(Object obj, Object obj2, C9866b c9866b) {
        c9866b.b = d(obj, "${" + obj2 + "}");
        c9866b.a = b(obj, obj2) > 0;
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
                C9866b e = e((String) f.first, f.second, obj);
                a2 = e.b;
                if (e.a) {
                    return a2;
                }
            } else {
                a2 = C6667c.a(obj, group);
            }
            if (start == 0 && end == length) {
                return a2;
            }
            sb.replace(start, end, a2 == null ? "" : a2.toString());
        }
        return sb.toString();
    }

    private static C9866b e(String str, Object obj, Object obj2) {
        C9866b c9866b = new C9866b();
        if (DXRecyclerLayout.LOAD_MORE_EMPTY.equalsIgnoreCase(str)) {
            c9866b.b = Integer.valueOf(b(obj2, obj));
            return c9866b;
        } else if (m80.NOT_PREFIX.equalsIgnoreCase(str)) {
            c9866b.b = Integer.valueOf(c(obj2, obj));
            return c9866b;
        } else if ("deleteIfNull".equalsIgnoreCase(str)) {
            a(obj2, obj, c9866b);
            return c9866b;
        } else {
            c9866b.b = obj;
            return c9866b;
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
