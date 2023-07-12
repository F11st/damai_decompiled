package com.youku.live.dago.liveplayback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class YoukuUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YoukuUtil";
    private static long previousToastShow = 0;
    private static String previousToastString = "";

    private YoukuUtil() {
    }

    public static void showCenterToast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653087248")) {
            ipChange.ipc$dispatch("653087248", new Object[]{context, str});
        } else if (context == null || str == null) {
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - previousToastShow > 2000 || !str.equalsIgnoreCase(previousToastString)) {
                ToastUtil.showToast(context, str, 0);
                previousToastString = str;
                previousToastShow = currentTimeMillis;
            }
        }
    }

    public static void showPlayerMiddleToast(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813596625")) {
            ipChange.ipc$dispatch("-813596625", new Object[]{context, str});
        }
    }

    public static void showTips(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458287111")) {
            ipChange.ipc$dispatch("-458287111", new Object[]{context, Integer.valueOf(i)});
        } else {
            showTips(context, context.getString(i));
        }
    }

    public static void showTipsForKanDan(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386151272")) {
            ipChange.ipc$dispatch("1386151272", new Object[]{context, str});
        } else if (context == null || str == null) {
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - previousToastShow > 2000 || !str.equalsIgnoreCase(previousToastString)) {
                View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dago_player_toast, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
                Toast toast = new Toast(context.getApplicationContext());
                toast.setDuration(0);
                toast.setGravity(17, 0, 0);
                toast.setView(inflate);
                ToastUtil.show(toast);
                previousToastString = str;
                previousToastShow = currentTimeMillis;
            }
        }
    }

    public static void showTips(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685920148")) {
            ipChange.ipc$dispatch("685920148", new Object[]{context, str});
        } else {
            showTips(context, str, 0);
        }
    }

    public static void showTips(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211282449")) {
            ipChange.ipc$dispatch("-211282449", new Object[]{context, str, Integer.valueOf(i)});
        } else if (context == null || str == null) {
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - previousToastShow > 2000 || !str.equalsIgnoreCase(previousToastString)) {
                ToastUtil.showToast(context, str, i);
                previousToastString = str;
                previousToastShow = currentTimeMillis;
            }
        }
    }
}
