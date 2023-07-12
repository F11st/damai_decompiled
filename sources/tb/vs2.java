package tb;

import com.alibaba.appmonitor.pool.Reusable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes6.dex */
public class vs2 implements Reusable {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public Map<String, String> f;

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        Map<String, String> map = this.f;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        if (this.f == null) {
            this.f = new HashMap();
        }
    }
}
