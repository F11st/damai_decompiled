package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import org.jetbrains.annotations.Nullable;
import tb.sb0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ac0<BizResponse> extends DoloresKernel<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private MtopBusiness t;
    @Nullable
    private DoloresRequest<BizResponse> u;
    @Nullable
    private IRemoteDataTransformer<BizResponse> v;

    private final void M(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632422673")) {
            ipChange.ipc$dispatch("-1632422673", new Object[]{this, Integer.valueOf(i), str, str2, str3, str4, str5, str6});
            return;
        }
        try {
            C("commitMtopFailMsg:errorCode=" + str3 + ",errorMsg" + str4);
            if (i == 0) {
                zb0.e(str, str2, str3, str4, str5, str6);
            } else if (i == 1) {
                zb0.d(str, str2, str3, str4, str5, str6);
            }
        } catch (Exception e) {
            rq.b(DoloresKernel.Companion.a(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e9, code lost:
        if (((mtopsdk.mtop.domain.MtopRequest) r1).isNeedEcode() != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01b2, code lost:
        if (((com.alibaba.pictures.request.BaseRequest) r1).NEED_ECODE != false) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void O() {
        /*
            Method dump skipped, instructions count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ac0.O():void");
    }

    private final Mtop P() {
        String str;
        Double[] c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915558038")) {
            return (Mtop) ipChange.ipc$dispatch("1915558038", new Object[]{this});
        }
        y12 p = p();
        if (p == null || (str = p.d()) == null) {
            str = Mtop.Id.INNER;
        }
        sb0.a aVar = sb0.Companion;
        Mtop instance = Mtop.instance(str, aVar.g().i(), aVar.g().n());
        y12 p2 = p();
        if (p2 != null && (c = p2.c()) != null) {
            if (!(c.length >= 2)) {
                c = null;
            }
            if (c != null) {
                instance.setCoordinates(String.valueOf(c[0].doubleValue()), String.valueOf(c[1].doubleValue()));
            }
        }
        return instance;
    }

    private final MtopResponse Q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099905906")) {
            return (MtopResponse) ipChange.ipc$dispatch("-1099905906", new Object[]{this});
        }
        C("mtopRequest begin");
        MtopBusiness mtopBusiness = this.t;
        MtopResponse syncRequest = mtopBusiness != null ? mtopBusiness.syncRequest() : null;
        C("mtopRequest end");
        return syncRequest;
    }

    private final void R(dc0<BizResponse> dc0Var, BizResponseType bizResponseType, MtopResponse mtopResponse) {
        String desc;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2067613422")) {
            ipChange.ipc$dispatch("2067613422", new Object[]{this, dc0Var, bizResponseType, mtopResponse});
        } else if (dc0Var != null) {
            dc0Var.h(bizResponseType.getCode());
            IGlobalConfig a = sb0.Companion.a();
            if (a == null || (desc = a.getGlobalConfig(IGlobalConfig.Key.GENERAL_REQUEST_ERROR_MSG, "小二很忙，系统很累，稍后再试吧")) == null) {
                desc = bizResponseType.getDesc();
            }
            dc0Var.j(desc);
            if (mtopResponse == null) {
                dc0Var.i(bizResponseType.getLocalDes());
                return;
            }
            dc0Var.i(bizResponseType.getLocalDes() + "-[" + mtopResponse.getRetCode() + jn1.CONDITION_IF_MIDDLE + mtopResponse.getRetMsg() + jn1.ARRAY_END);
            dc0Var.m(mtopResponse.getRetCode());
            dc0Var.n(mtopResponse.getRetMsg());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03b2  */
    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.dc0<BizResponse> D(@org.jetbrains.annotations.NotNull com.alibaba.pictures.dolores.business.Result<BizResponse> r13) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ac0.D(com.alibaba.pictures.dolores.business.Result):tb.dc0");
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891206017")) {
            ipChange.ipc$dispatch("891206017", new Object[]{this});
            return;
        }
        super.E();
        this.t = null;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void H(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812174055")) {
            ipChange.ipc$dispatch("-812174055", new Object[]{this, doloresRequest});
        } else {
            this.u = doloresRequest;
        }
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964687732")) {
            ipChange.ipc$dispatch("-1964687732", new Object[]{this, iRemoteDataTransformer});
        } else {
            this.v = iRemoteDataTransformer;
        }
    }

    @Nullable
    public IRemoteDataTransformer<BizResponse> N() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072553208")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("1072553208", new Object[]{this});
        }
        if (this.v == null) {
            this.v = new hp2();
        }
        return this.v;
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114853636")) {
            return ((Boolean) ipChange.ipc$dispatch("-2114853636", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        MtopBusiness mtopBusiness = this.t;
        if (mtopBusiness != null) {
            mtopBusiness.cancelRequest();
        }
        return super.d(z);
    }

    @Override // com.alibaba.pictures.dolores.DoloresKernel
    @Nullable
    public DoloresRequest<BizResponse> m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1326615711") ? (DoloresRequest) ipChange.ipc$dispatch("1326615711", new Object[]{this}) : this.u;
    }
}
