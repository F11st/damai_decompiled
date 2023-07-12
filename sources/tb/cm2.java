package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class cm2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String[] a(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1850717637") ? (String[]) ipChange.ipc$dispatch("-1850717637", new Object[]{context, Integer.valueOf(i)}) : context.getResources().getStringArray(i);
    }

    public static String b(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1622473052") ? (String) ipChange.ipc$dispatch("1622473052", new Object[]{context, Integer.valueOf(i)}) : context.getResources().getString(i);
    }

    public static String c(Context context, int i, Object... objArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-947422381") ? (String) ipChange.ipc$dispatch("-947422381", new Object[]{context, Integer.valueOf(i), objArr}) : String.format(context.getResources().getString(i), objArr);
    }
}
