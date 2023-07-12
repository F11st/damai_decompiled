package com.alient.oneservice.provider.impl.appconfig;

import android.app.Activity;
import cn.damai.common.util.ToastUtil;
import com.alient.oneservice.appconfig.AppConfigProvider;
import tb.k3;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AppConfigProviderImpl implements AppConfigProvider {
    @Override // com.alient.oneservice.appconfig.AppConfigProvider
    public void showToast(Activity activity, String str, int i) {
        if (i == 1) {
            ToastUtil.f(str);
        } else {
            ToastUtil.i(str);
        }
    }

    @Override // com.alient.oneservice.appconfig.AppConfigProvider
    public Activity topActivity() {
        return k3.b().c();
    }
}
