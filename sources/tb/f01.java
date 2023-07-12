package tb;

import com.efs.sdk.base.a.h.a.InterfaceC4798b;
import com.efs.sdk.base.http.IHttpUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f01 {
    private IHttpUtil a;
    private List<InterfaceC4798b<l01>> b;

    /* compiled from: Taobao */
    /* renamed from: tb.f01$b */
    /* loaded from: classes10.dex */
    static class C9123b {
        private static final f01 a = new f01();
    }

    private f01() {
        this.a = s33.d();
        this.b = new ArrayList(1);
    }

    public static f01 c() {
        return C9123b.a;
    }

    public List<InterfaceC4798b<l01>> a() {
        return new ArrayList(this.b);
    }

    public IHttpUtil b() {
        return this.a;
    }
}
