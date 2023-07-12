package cn.damai.launcher.splash.model.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.launcher.splash.api.SplashRequest;
import cn.damai.launcher.splash.api.SplashResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class TsAdMtopRequest extends TimeSensitiveRequest<SplashResponse> {
    private static transient /* synthetic */ IpChange $ipChange;

    public TsAdMtopRequest(int i) {
        super(i);
    }

    @Override // cn.damai.launcher.splash.model.request.TimeSensitiveRequest
    protected void callRequest(final OnBizListener<SplashResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243988399")) {
            ipChange.ipc$dispatch("-1243988399", new Object[]{this, onBizListener});
            return;
        }
        final SplashRequest splashRequest = new SplashRequest();
        if (AppConfig.g().equals(AppConfig.EnvMode.prepare) && z20.j()) {
            splashRequest.viewDate = z20.k();
        }
        splashRequest.request(new DMMtopRequestListener<SplashResponse>(SplashResponse.class) { // from class: cn.damai.launcher.splash.model.request.TsAdMtopRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1615002460")) {
                    ipChange2.ipc$dispatch("-1615002460", new Object[]{this, str, str2});
                } else {
                    onBizListener.onBizFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SplashResponse splashResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1815212809")) {
                    ipChange2.ipc$dispatch("-1815212809", new Object[]{this, splashResponse});
                    return;
                }
                if (splashResponse != null) {
                    splashResponse.setDiffCityId(splashRequest.cityid);
                }
                onBizListener.onBizSuccess(splashResponse);
            }
        });
    }
}
