package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import javax.annotation.Nullable;
import okhttp3.internal.C8753a;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* renamed from: okhttp3.l */
/* loaded from: classes2.dex */
public final class C8816l {
    private final String[] a;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.l$a */
    /* loaded from: classes2.dex */
    public static final class C8817a {
        final List<String> a = new ArrayList(20);

        public C8817a a(String str, String str2) {
            C8816l.a(str);
            C8816l.b(str2, str);
            return c(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C8817a b(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return c(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C8817a c(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public C8817a d(String str, String str2) {
            C8816l.a(str);
            return c(str, str2);
        }

        public C8816l e() {
            return new C8816l(this);
        }

        @Nullable
        public String f(String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.a.get(size))) {
                    return this.a.get(size + 1);
                }
            }
            return null;
        }

        public C8817a g(String str) {
            int i = 0;
            while (i < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public C8817a h(String str, String str2) {
            C8816l.a(str);
            C8816l.b(str2, str);
            g(str);
            c(str, str2);
            return this;
        }
    }

    C8816l(C8817a c8817a) {
        List<String> list = c8817a.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(C8753a.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty");
    }

    static void b(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(C8753a.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    @Nullable
    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static C8816l g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            for (int i = 0; i < strArr2.length; i++) {
                if (strArr2[i] != null) {
                    strArr2[i] = strArr2[i].trim();
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                String str = strArr2[i2];
                String str2 = strArr2[i2 + 1];
                a(str);
                b(str2, str);
            }
            return new C8816l(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    @Nullable
    public String c(String str) {
        return d(this.a, str);
    }

    public String e(int i) {
        return this.a[i * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C8816l) && Arrays.equals(((C8816l) obj).a, this.a);
    }

    public C8817a f() {
        C8817a c8817a = new C8817a();
        Collections.addAll(c8817a.a, this.a);
        return c8817a;
    }

    public int h() {
        return this.a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public Map<String, List<String>> i() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int h = h();
        for (int i = 0; i < h; i++) {
            String lowerCase = e(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(j(i));
        }
        return treeMap;
    }

    public String j(int i) {
        return this.a[(i * 2) + 1];
    }

    public List<String> k(String str) {
        int h = h();
        ArrayList arrayList = null;
        for (int i = 0; i < h; i++) {
            if (str.equalsIgnoreCase(e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(j(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h = h();
        for (int i = 0; i < h; i++) {
            sb.append(e(i));
            sb.append(": ");
            sb.append(j(i));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }

    private C8816l(String[] strArr) {
        this.a = strArr;
    }
}
