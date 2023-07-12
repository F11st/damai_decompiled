package com.youku.live.dsl.toast;

import android.content.Context;
import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IToastImp implements IToast {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.toast.IToast
    public void showCenterToast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918456567")) {
            ipChange.ipc$dispatch("918456567", new Object[]{this, context, str});
        } else {
            ToastUtil.i(str);
        }
    }

    @Override // com.youku.live.dsl.toast.IToast
    public void showToast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-683349620")) {
            ipChange.ipc$dispatch("-683349620", new Object[]{this, context, str});
        } else {
            ToastUtil.i(str);
        }
    }

    @Override // com.youku.live.dsl.toast.IToast
    public void showToast(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291027703")) {
            ipChange.ipc$dispatch("291027703", new Object[]{this, context, str, Integer.valueOf(i)});
        } else {
            ToastUtil.b(str, i);
        }
    }
}
