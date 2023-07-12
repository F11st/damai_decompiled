package tb;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e13 {
    private Set<String> a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class b {
        private static final e13 a = new e13();
    }

    public static e13 b() {
        return b.a;
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
