package com.youku.live.livesdk.wkit.module;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.youku.live.livesdk.wkit.utils.YKLToastUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoToast extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;

    @JSMethod
    public void show(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583220834")) {
            ipChange.ipc$dispatch("1583220834", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null && this.mContext == null) {
            this.mContext = wXSDKInstance.getContext();
        }
        Context context = this.mContext;
        if (context != null) {
            YKLToastUtil.showToast(context.getApplicationContext(), str, 0);
        }
    }
}
