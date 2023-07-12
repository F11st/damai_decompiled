package tb;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuSaveInfo;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class rd2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static SkuSaveInfo a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691510408")) {
            return (SkuSaveInfo) ipChange.ipc$dispatch("-691510408", new Object[]{Long.valueOf(j)});
        }
        String B = z20.B("sku|" + j);
        if (TextUtils.isEmpty(B)) {
            return null;
        }
        try {
            return (SkuSaveInfo) JSON.parseObject(B, SkuSaveInfo.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199345295")) {
            return ((Boolean) ipChange.ipc$dispatch("-199345295", new Object[]{Long.valueOf(j)})).booleanValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("youku|");
        sb.append(j);
        return !TextUtils.isEmpty(z20.B(sb.toString()));
    }

    public static void c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732118412")) {
            ipChange.ipc$dispatch("732118412", new Object[]{Long.valueOf(j)});
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(mu0.a().getApplicationContext()).edit().remove("sku|" + j).commit();
    }

    public static void d(long j, SkuSaveInfo skuSaveInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710730439")) {
            ipChange.ipc$dispatch("710730439", new Object[]{Long.valueOf(j), skuSaveInfo});
        } else if (skuSaveInfo == null) {
        } else {
            z20.T("sku|" + j, JSON.toJSONString(skuSaveInfo));
        }
    }

    public static void e(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370895470")) {
            ipChange.ipc$dispatch("1370895470", new Object[]{Long.valueOf(j)});
            return;
        }
        z20.T("youku|" + j, "true");
    }
}
