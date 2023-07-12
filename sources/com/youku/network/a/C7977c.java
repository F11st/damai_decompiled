package com.youku.network.a;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.youku.d.C7898a;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.config.C8002a;
import com.youku.network.config.YKNetworkConfig;
import java.util.Map;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
/* renamed from: com.youku.network.a.c */
/* loaded from: classes3.dex */
public class C7977c<I extends MtopBuilder, O extends MtopResponse> extends AbstractC7975a<I, O> {
    private C8004d b(O o) {
        C8004d a = C8004d.a();
        a.a(o);
        a.b(o.getResponseCode());
        a.a(o.getHeaderFields());
        if (!C8002a.b(o.getRetCode())) {
            a.a(C8002a.a(o.getRetCode()));
        }
        if (o.getMtopStat() != null) {
            a.a(o.getMtopStat().getNetStat());
        }
        return a;
    }

    private MtopBuilder b(C7984c c7984c) {
        Mtop a = c7984c.D() == null ? C7898a.a() : c7984c.D();
        String w = !TextUtils.isEmpty(c7984c.w()) ? c7984c.w() : C7898a.b();
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(c7984c.o());
        mtopRequest.setVersion(c7984c.p());
        mtopRequest.setNeedEcode(c7984c.r());
        mtopRequest.setNeedSession(c7984c.s());
        if (!TextUtils.isEmpty(c7984c.q())) {
            mtopRequest.setData(c7984c.q());
        }
        if (c7984c.t() != null) {
            mtopRequest.dataParams = c7984c.t();
        }
        MtopBuilder build = YKNetworkConfig.c() ? MtopBusiness.build(a, mtopRequest, w) : a.build(mtopRequest, w);
        if (c7984c.F() != null) {
            build.headers(c7984c.F());
        }
        if (c7984c.G() != null) {
            for (Map.Entry<String, String> entry : c7984c.G().entrySet()) {
                build.addHttpQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        build.setConnectionTimeoutMilliSecond(c7984c.I());
        build.setSocketTimeoutMilliSecond(c7984c.J());
        build.reqMethod(c7984c.K());
        build.retryTime(c7984c.H());
        if (c7984c.u() != null) {
            build.protocol(c7984c.u());
        }
        if (!TextUtils.isEmpty(c7984c.v())) {
            build.setCustomDomain(c7984c.v());
        }
        if (!TextUtils.isEmpty(c7984c.x())) {
            build.addMteeUa(c7984c.x());
        }
        if (c7984c.y() != -1) {
            build.useWua(c7984c.y());
        }
        if (!TextUtils.isEmpty(c7984c.z()) && !TextUtils.isEmpty(c7984c.A())) {
            build.addOpenApiParams(c7984c.z(), c7984c.A());
        }
        if (c7984c.C()) {
            build.useCache();
        }
        if (c7984c.B()) {
            build.setCacheControlNoCache();
        }
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.network.a.InterfaceC7976b
    public /* bridge */ /* synthetic */ C8004d a(Object obj) {
        return a((C7977c<I, O>) ((MtopResponse) obj));
    }

    public C8004d a(O o) {
        return b((C7977c<I, O>) o);
    }

    public I a(C7984c c7984c) {
        return (I) b(c7984c);
    }
}
