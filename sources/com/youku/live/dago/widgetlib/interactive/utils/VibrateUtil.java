package com.youku.live.dago.widgetlib.interactive.utils;

import android.content.Context;
import android.os.Vibrator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VibrateUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Vibrator vibrator;

    public static void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757150040")) {
            ipChange.ipc$dispatch("1757150040", new Object[0]);
            return;
        }
        Vibrator vibrator2 = vibrator;
        if (vibrator2 != null) {
            vibrator2.cancel();
        }
    }

    public static void vComplicated(Context context, long[] jArr, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028943411")) {
            ipChange.ipc$dispatch("1028943411", new Object[]{context, jArr, Integer.valueOf(i)});
            return;
        }
        Vibrator vibrator2 = (Vibrator) context.getSystemService("vibrator");
        vibrator = vibrator2;
        vibrator2.vibrate(jArr, i);
    }

    public static void vSimple(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707255389")) {
            ipChange.ipc$dispatch("-1707255389", new Object[]{context, Integer.valueOf(i)});
            return;
        }
        Vibrator vibrator2 = (Vibrator) context.getSystemService("vibrator");
        vibrator = vibrator2;
        vibrator2.vibrate(i);
    }
}
