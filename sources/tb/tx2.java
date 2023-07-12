package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class tx2 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.tx2$a */
    /* loaded from: classes9.dex */
    private static class C9736a {
        private static final tx2 a = new tx2();
    }

    public static final tx2 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-402524231") ? (tx2) ipChange.ipc$dispatch("-402524231", new Object[0]) : C9736a.a;
    }

    private Map<String, String> h(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1651551577")) {
            return (Map) ipChange.ipc$dispatch("-1651551577", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", str2);
        hashMap.put("video_id", str3);
        return hashMap;
    }

    public C0525a.C0527b f(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "868801282")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("868801282", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", str3);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("video_id", str2);
        }
        return new C0525a.C0527b().j(hashMap).i("video");
    }

    public void i(String str, String str2, boolean z, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931453826")) {
            ipChange.ipc$dispatch("1931453826", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4, str5});
        } else {
            C0529c.e().x(e("video", str, str2, h(str3, str5, str4), Boolean.valueOf(z)));
        }
    }

    public void j(String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-955962364")) {
            ipChange.ipc$dispatch("-955962364", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4, str5, str6});
            return;
        }
        Map<String, String> h = h(str3, str5, str4);
        h.put("status", String.valueOf(str6));
        C0529c.e().x(e("video", str, str2, h, Boolean.valueOf(z)));
    }

    public void k(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659169789")) {
            ipChange.ipc$dispatch("-1659169789", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("usercode", str2);
        hashMap.put("video_id", str4);
        hashMap.put("video_title", str5);
        hashMap.put("duration", str6);
        C0529c.e().D("video", "page_video_playend", str3, "", hashMap, 12003);
    }
}
