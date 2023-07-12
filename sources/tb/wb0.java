package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.C3604a;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.dolores.utils.ReqMethodEnum;
import com.alibaba.pictures.dolores.utils.ReqProtocolEnum;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class wb0<BizResponse> extends DoloresKernel<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DoloresRequest<BizResponse> t;
    @Nullable
    private IRemoteDataTransformer<BizResponse> u;
    private C3604a v;

    private final void M(int i, String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928544037")) {
            ipChange.ipc$dispatch("928544037", new Object[]{this, Integer.valueOf(i), str, str2, str3, str4, str5});
            return;
        }
        try {
            C("commitMtopFailMsg:errorCode=" + str3 + ",errorMsg" + str4);
            if (i == 0) {
                zb0.e(str, str2, str3, str4, str5, null);
            } else if (i == 1) {
                zb0.d(str, str2, str3, str4, str5, null);
            }
        } catch (Exception e) {
            rq.b(DoloresKernel.Companion.a(), e);
        }
    }

    private final p01 O() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624581519")) {
            return (p01) ipChange.ipc$dispatch("1624581519", new Object[]{this});
        }
        C("httpUrlRequest:begin");
        C3604a c3604a = this.v;
        p01 i = c3604a != null ? c3604a.i() : null;
        C("httpUrlRequest:end");
        return i;
    }

    private final void P() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493174471")) {
            ipChange.ipc$dispatch("493174471", new Object[]{this});
            return;
        }
        C("initNetBusiness");
        IRequestInterceptor q = q();
        if (q != null) {
            q.onRequestConfig(this, m());
        }
        if (m() instanceof na) {
            C3604a c3604a = new C3604a();
            DoloresRequest<BizResponse> m = m();
            Objects.requireNonNull(m, "null cannot be cast to non-null type com.alibaba.pictures.request.BaseHttpRequest<BizResponse>");
            c3604a.h((na) m);
            y12 p = p();
            if (p != null) {
                Boolean f = p.f();
                Boolean bool = Boolean.TRUE;
                if (!b41.d(f, bool) && !b41.d(w(), bool)) {
                    c3604a.e(ReqProtocolEnum.HTTP);
                } else {
                    c3604a.e(ReqProtocolEnum.HTTP_SECURE);
                }
                if (!b41.d(p.h(), bool) && !b41.d(v(), bool)) {
                    c3604a.g(ReqMethodEnum.POST);
                } else {
                    c3604a.g(ReqMethodEnum.GET);
                }
                Map<String, String> a = p.a();
                if (a != null) {
                    if (!(true ^ a.isEmpty())) {
                        a = null;
                    }
                    if (a != null) {
                        c3604a.c(a);
                    }
                }
                J(p.e());
            }
            wt2 wt2Var = wt2.INSTANCE;
            this.v = c3604a;
        }
    }

    private final void Q(dc0<BizResponse> dc0Var, BizResponseType bizResponseType, p01 p01Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25545592")) {
            ipChange.ipc$dispatch("-25545592", new Object[]{this, dc0Var, bizResponseType, p01Var});
        } else if (dc0Var != null) {
            dc0Var.h(bizResponseType.getCode());
            dc0Var.j(bizResponseType.getDesc());
            if (p01Var == null) {
                dc0Var.i(bizResponseType.getLocalDes());
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(bizResponseType.getLocalDes());
            sb.append("-[");
            Integer d = p01Var.d();
            if (d == null) {
                d = "";
            }
            sb.append(d);
            sb.append(jn1.CONDITION_IF_MIDDLE);
            String e = p01Var.e();
            if (e == null) {
                e = "";
            }
            sb.append(e);
            sb.append(jn1.ARRAY_END);
            dc0Var.i(sb.toString());
            Integer d2 = p01Var.d();
            dc0Var.m((d2 == null || (r6 = String.valueOf(d2.intValue())) == null) ? "" : "");
            String e2 = p01Var.e();
            dc0Var.n(e2 != null ? e2 : "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0346  */
    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.dc0<BizResponse> D(@org.jetbrains.annotations.NotNull com.alibaba.pictures.dolores.business.Result<BizResponse> r13) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.wb0.D(com.alibaba.pictures.dolores.business.Result):tb.dc0");
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19105473")) {
            ipChange.ipc$dispatch("19105473", new Object[]{this});
            return;
        }
        super.E();
        this.v = null;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void H(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-613564455")) {
            ipChange.ipc$dispatch("-613564455", new Object[]{this, doloresRequest});
            return;
        }
        if (doloresRequest instanceof na) {
            F(((na) doloresRequest).a);
            G(jn1.MUL);
        }
        this.t = doloresRequest;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514759860")) {
            ipChange.ipc$dispatch("-1514759860", new Object[]{this, iRemoteDataTransformer});
        } else {
            this.u = iRemoteDataTransformer;
        }
    }

    @Nullable
    public IRemoteDataTransformer<BizResponse> N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1406784968")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("-1406784968", new Object[]{this});
        }
        if (this.u == null) {
            this.u = new hp2();
        }
        return this.u;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308013116")) {
            return ((Boolean) ipChange.ipc$dispatch("1308013116", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        C3604a c3604a = this.v;
        if (c3604a != null) {
            c3604a.a();
        }
        return super.d(z);
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @Nullable
    public DoloresRequest<BizResponse> m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-52450849") ? (DoloresRequest) ipChange.ipc$dispatch("-52450849", new Object[]{this}) : this.t;
    }
}
