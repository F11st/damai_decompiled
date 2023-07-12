package tb;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class o71 {
    private static o71 c = new o71();
    private C9513c a = new C9513c();
    private C9512b b = new C9512b();

    /* compiled from: Taobao */
    /* renamed from: tb.o71$b */
    /* loaded from: classes5.dex */
    private class C9512b implements Comparator<String> {
        private C9512b(o71 o71Var) {
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
    /* renamed from: tb.o71$c */
    /* loaded from: classes5.dex */
    private class C9513c implements Comparator<String> {
        private C9513c(o71 o71Var) {
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
