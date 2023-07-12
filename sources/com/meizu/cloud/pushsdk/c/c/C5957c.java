package com.meizu.cloud.pushsdk.c.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.c */
/* loaded from: classes10.dex */
public final class C5957c {
    private final String[] a;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.c$a */
    /* loaded from: classes10.dex */
    public static final class C5958a {
        private final List<String> a = new ArrayList(20);

        private void c(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char charAt2 = str2.charAt(i2);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public C5958a a(String str, String str2) {
            c(str, str2);
            return b(str, str2);
        }

        public C5957c a() {
            return new C5957c(this);
        }

        C5958a b(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }
    }

    private C5957c(C5958a c5958a) {
        this.a = (String[]) c5958a.a.toArray(new String[c5958a.a.size()]);
    }

    private C5957c(String[] strArr) {
        this.a = strArr;
    }

    public static C5957c a(String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() == 0 || str.indexOf(0) != -1 || str2.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new C5957c(strArr2);
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public int a() {
        return this.a.length / 2;
    }

    public String a(int i) {
        return this.a[i * 2];
    }

    public String a(String str) {
        return a(this.a, str);
    }

    public String b(int i) {
        return this.a[(i * 2) + 1];
    }

    public Set<String> b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a = a();
        for (int i = 0; i < a; i++) {
            treeSet.add(a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public C5958a c() {
        C5958a c5958a = new C5958a();
        Collections.addAll(c5958a.a, this.a);
        return c5958a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a = a();
        for (int i = 0; i < a; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }
}
