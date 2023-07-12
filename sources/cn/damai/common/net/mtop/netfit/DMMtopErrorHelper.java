package cn.damai.common.net.mtop.netfit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;
import tb.cw0;
import tb.mu0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMMtopErrorHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DMMtopErrorHelper dmMtopErrorHelper;
    private boolean isShowLoginUI;

    public static synchronized DMMtopErrorHelper instance() {
        synchronized (DMMtopErrorHelper.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "207739321")) {
                return (DMMtopErrorHelper) ipChange.ipc$dispatch("207739321", new Object[0]);
            }
            if (dmMtopErrorHelper == null) {
                dmMtopErrorHelper = new DMMtopErrorHelper();
            }
            return dmMtopErrorHelper;
        }
    }

    public void error(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254886420")) {
            ipChange.ipc$dispatch("254886420", new Object[]{this, mtopResponse});
        } else if (mtopResponse == null || mtopResponse.isNoNetwork() || mtopResponse.isNetworkError() || !mtopResponse.isSessionInvalid() || !this.isShowLoginUI) {
        } else {
            cw0.a().b(mu0.a().getApplicationContext());
            z20.r0("");
            z20.x0("");
            z20.k0("");
            ERROR.broadcastLogoutSuccess(mu0.a().getApplicationContext());
        }
    }

    public DMMtopErrorHelper setIsShowLoginUI(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633207824")) {
            return (DMMtopErrorHelper) ipChange.ipc$dispatch("-633207824", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isShowLoginUI = z;
        return this;
    }
}
