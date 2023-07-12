package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class th1 {
    public String a;
    public String b;
    public boolean c;
    public String e;
    public long f;
    public String g;
    public boolean h;
    public String i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public int d = -1;
    private Map<String, String> n = new HashMap();
    private Map<String, String> o = null;

    public void a(String str, String str2) {
        this.n.put(str, str2);
    }

    public void b(String str, String str2) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(str, str2);
    }

    public Map<String, String> c() {
        return this.n;
    }

    public Map<String, String> d() {
        return this.o;
    }
}
