package com.alimm.xadsdk.base.expose;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.net.AdNetResponse;
import com.alimm.xadsdk.base.net.AdNetwork;
import com.alimm.xadsdk.base.net.INetAdapter;
import com.alimm.xadsdk.base.net.INetCallback;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.info.GlobalInfoManager;
import com.alimm.xadsdk.request.builder.IRequestConst;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DefaultExposer implements IExposer {
    private static final int DEFAULT_TIME_OUT = 10000;
    private static final String METHOD_GET = "GET";
    private static final int RESPONSE_CODE_SUCCEED = 200;
    private static final String TAG = "DefaultExposer";
    private INetAdapter mNetAdapter;

    public DefaultExposer(@NonNull INetAdapter iNetAdapter) {
        this.mNetAdapter = iNetAdapter;
    }

    @Override // com.alimm.xadsdk.base.expose.IExposer
    public void onExpose(final String str, String str2, final ExposeCallback exposeCallback) {
        AdNetwork.Builder autoRedirect = new AdNetwork.Builder().url(str2).method("GET").connectTimeout(10000).readTimeout(10000).retryTimes(0).autoRedirect(true);
        String userAgent = GlobalInfoManager.getInstance().getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            autoRedirect.header(IRequestConst.USER_AGENT, userAgent);
        }
        autoRedirect.header(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        autoRedirect.build().asyncCall(this.mNetAdapter, new INetCallback() { // from class: com.alimm.xadsdk.base.expose.DefaultExposer.1
            @Override // com.alimm.xadsdk.base.net.INetCallback
            public void onFailed(int i, String str3) {
                if (LogUtils.DEBUG) {
                    LogUtils.d(DefaultExposer.TAG, "onExpose: failed, errorCode = " + i);
                }
                ExposeCallback exposeCallback2 = exposeCallback;
                if (exposeCallback2 != null) {
                    exposeCallback2.onFail(i, str3);
                }
            }

            @Override // com.alimm.xadsdk.base.net.INetCallback
            public void onSuccess(AdNetResponse adNetResponse) {
                if (LogUtils.DEBUG) {
                    LogUtils.d(DefaultExposer.TAG, "onExpose: success, type = " + str);
                }
                ExposeCallback exposeCallback2 = exposeCallback;
                if (exposeCallback2 != null) {
                    exposeCallback2.onSucceed(200);
                }
            }
        });
    }
}
