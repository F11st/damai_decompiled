package com.youku.live.dago.widgetlib.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.toast.IToast;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ToastUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    private ToastUtil() {
    }

    public static void showCenter(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1117854486")) {
            ipChange.ipc$dispatch("-1117854486", new Object[]{context, str});
        } else if (context == null || TextUtils.isEmpty(str) || Dsl.getService(IToast.class) == null) {
        } else {
            ((IToast) Dsl.getService(IToast.class)).showCenterToast(context, str);
        }
    }

    public static void toast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234560951")) {
            ipChange.ipc$dispatch("-1234560951", new Object[]{context, str});
        } else if (context == null || TextUtils.isEmpty(str) || Dsl.getService(IToast.class) == null) {
        } else {
            ((IToast) Dsl.getService(IToast.class)).showToast(context, str);
        }
    }
}
