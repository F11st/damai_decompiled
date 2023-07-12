package tb;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rf0 {
    private final String a;
    private final long b;
    private Map<String, Object> c;

    public rf0(String str, Map<String, Object> map) {
        this(str, System.currentTimeMillis());
        this.c = map;
    }

    public String a() {
        return this.a;
    }

    public Map<String, Object> b() {
        return this.c;
    }

    public long c() {
        return this.b;
    }

    public String toString() {
        return "Event{name='" + this.a + "', timestamp=" + this.b + '}';
    }

    public rf0(String str, long j) {
        this.a = str;
        this.b = j;
    }
}
