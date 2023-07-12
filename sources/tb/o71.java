package tb;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class o71 {
    private static o71 c = new o71();
    private c a = new c();
    private b b = new b();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private class b implements Comparator<String> {
        private b(o71 o71Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private class c implements Comparator<String> {
        private c(o71 o71Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * (-1);
        }
    }

    private o71() {
    }

    public static o71 a() {
        return c;
    }

    public String[] b(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.b;
        } else {
            comparator = this.a;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
