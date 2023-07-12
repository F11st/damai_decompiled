package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class rj0 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SHARE_PAGE = "share_new";

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    private static class a {
        private static final rj0 a = new rj0();
    }

    public static rj0 h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-279392133") ? (rj0) ipChange.ipc$dispatch("-279392133", new Object[0]) : a.a;
    }

    public a.b f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-567485794")) {
            return (a.b) ipChange.ipc$dispatch("-567485794", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("titlelabel", str2);
        }
        return new a.b().j(hashMap).i(str);
    }

    public a.b g(String str, String str2, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999942580")) {
            return (a.b) ipChange.ipc$dispatch("-999942580", new Object[]{this, str, str2, bool});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        return e(SHARE_PAGE, str, str2, hashMap, bool);
    }

    public a.b i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772609320")) {
            return (a.b) ipChange.ipc$dispatch("772609320", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", String.valueOf(z20.d()));
        return e(SHARE_PAGE, "top", "loginbutton", hashMap, Boolean.TRUE);
    }

    public a.b j(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085556386")) {
            return (a.b) ipChange.ipc$dispatch("2085556386", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        return e(SHARE_PAGE, "center", "style_item_" + i, hashMap, Boolean.FALSE);
    }

    public a.b k(int i, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852774211")) {
            return (a.b) ipChange.ipc$dispatch("-1852774211", new Object[]{this, Integer.valueOf(i), str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        hashMap.put("titlelabel", str);
        hashMap.put("style_type", str2);
        return e(SHARE_PAGE, "center", "share_item_" + i, hashMap, Boolean.valueOf(z));
    }

    public a.b l(int i, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781771847")) {
            return (a.b) ipChange.ipc$dispatch("1781771847", new Object[]{this, Integer.valueOf(i), str, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        hashMap.put("titlelabel", str);
        return e(SHARE_PAGE, "bottom", "share_item_" + i, hashMap, Boolean.valueOf(z));
    }
}
