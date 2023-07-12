package mtopsdk.network.impl;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.network.Call;
import mtopsdk.network.cookie.CookieManager;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultCallFactory implements Call.Factory {
    private static final String TAG = "mtopsdk.DefaultCallFactory";
    ExecutorService executorService;

    public DefaultCallFactory(Context context, ExecutorService executorService) {
        this.executorService = executorService;
        try {
            CookieManager.setup(context);
        } catch (Exception e) {
            TBSdkLog.e(TAG, "call CookieManager.setup error.", e);
        }
    }

    @Override // mtopsdk.network.Call.Factory
    public Call newCall(Request request) {
        return new DefaultCallImpl(request, this.executorService);
    }
}
