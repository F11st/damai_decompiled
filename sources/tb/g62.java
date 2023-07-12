package tb;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class g62 {
    private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    private boolean b = true;

    /* compiled from: Taobao */
    /* renamed from: tb.g62$a */
    /* loaded from: classes.dex */
    private static class C9157a {
        static g62 a = new g62();
    }

    public static g62 a() {
        return C9157a.a;
    }

    public String b(String str) {
        if (this.b) {
            String str2 = this.a.get(str);
            if (str2 == null) {
                this.a.put(str, "https");
                return "https";
            }
            return str2;
        }
        return null;
    }

    public void c(String str) {
        this.a.put(str, "http");
    }

    public void d(boolean z) {
        this.b = z;
    }
}
