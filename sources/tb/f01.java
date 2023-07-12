package tb;

import com.efs.sdk.base.http.IHttpUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f01 {
    private IHttpUtil a;
    private List<com.efs.sdk.base.a.h.a.b<l01>> b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b {
        private static final f01 a = new f01();
    }

    private f01() {
        this.a = s33.d();
        this.b = new ArrayList(1);
    }

    public static f01 c() {
        return b.a;
    }

    public List<com.efs.sdk.base.a.h.a.b<l01>> a() {
        return new ArrayList(this.b);
    }

    public IHttpUtil b() {
        return this.a;
    }
}
