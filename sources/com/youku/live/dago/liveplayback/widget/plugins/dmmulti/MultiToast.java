package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.ToastUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MultiToast {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void showToast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738145471")) {
            ipChange.ipc$dispatch("-738145471", new Object[]{context, str});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.C7935layout.dago_player_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.setView(inflate);
        ToastUtil.show(toast);
    }
}
