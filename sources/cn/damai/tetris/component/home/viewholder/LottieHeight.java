package cn.damai.tetris.component.home.viewholder;

import android.app.Application;
import android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class LottieHeight implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int getHomeLottieViewHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791852711")) {
            return ((Integer) ipChange.ipc$dispatch("791852711", new Object[0])).intValue();
        }
        Application a = mu0.a();
        DisplayMetrics displayMetrics = a.getResources().getDisplayMetrics();
        return m62.a(a, (int) ((((int) (com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / displayMetrics.density)) / 392.0f) * 420.0f));
    }
}
