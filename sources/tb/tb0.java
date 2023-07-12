package tb;

import com.alibaba.pictures.dolores.cache.ICacheDataFilter;
import com.alibaba.pictures.dolores.cache.ICacheManager;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class tb0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String a = "DoloresCacheWrapper";

    @Nullable
    public static final af a(@Nullable bf bfVar) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1849256826")) {
            return (af) ipChange.ipc$dispatch("1849256826", new Object[]{bfVar});
        }
        if (bfVar != null) {
            String a2 = bfVar.a();
            if (!((a2 == null || a2.length() == 0) ? true : true)) {
                try {
                    String str = a;
                    rq.a(str, "get key:" + bfVar.a() + ",value:***");
                    ICacheManager h = sb0.Companion.g().h();
                    af obtain = h != null ? h.obtain(bfVar.a(), bfVar.c()) : null;
                    b(bfVar, obtain);
                    return obtain;
                } catch (Exception e) {
                    rq.b(a, e);
                }
            }
        }
        return null;
    }

    public static final void b(@Nullable bf bfVar, @Nullable af afVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466438620")) {
            ipChange.ipc$dispatch("-1466438620", new Object[]{bfVar, afVar});
        } else if (afVar == null) {
        } else {
            String d = afVar.d();
            long c = afVar.c();
            if (d == null) {
                afVar.e(0);
            }
            if (TimeSyncer.INSTANCE.g() - c < (bfVar != null ? bfVar.b() : 0L)) {
                afVar.e(1);
            } else {
                afVar.e(2);
            }
        }
    }

    public static final void c(@Nullable bf bfVar, @Nullable byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410491607")) {
            ipChange.ipc$dispatch("-1410491607", new Object[]{bfVar, bArr});
            return;
        }
        if ((bfVar != null ? bfVar.a() : null) == null || bArr == null) {
            return;
        }
        try {
            String a2 = bfVar.a();
            String str = new String(bArr, hi.UTF_8);
            ICacheDataFilter f = bfVar.f();
            if (f != null) {
                str = f.doFilter(a2, str);
            }
            String str2 = a;
            rq.a(str2, "save key:" + a2 + ",value-***");
            ICacheManager h = sb0.Companion.g().h();
            if (h != null) {
                h.save(a2, str, bfVar.c());
                return;
            }
            rq.c(str2, "cacheManager == null,you need set a CacheManager!");
            wt2 wt2Var = wt2.INSTANCE;
        } catch (Exception e) {
            rq.b(a, e);
        }
    }
}
