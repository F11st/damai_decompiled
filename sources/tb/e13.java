package tb;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e13 {
    private Set<String> a;

    /* compiled from: Taobao */
    /* renamed from: tb.e13$b */
    /* loaded from: classes11.dex */
    private static final class C9066b {
        private static final e13 a = new e13();
    }

    public static e13 b() {
        return C9066b.a;
    }

    public void a(String str) {
        this.a.add(str);
    }

    private e13() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add("s.click.taobao.com");
    }
}
