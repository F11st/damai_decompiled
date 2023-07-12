package tb;

import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class o62 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.o62$a */
    /* loaded from: classes4.dex */
    public static class C9508a {
        private static final o62 a = new o62();
    }

    public static o62 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1610210391") ? (o62) ipChange.ipc$dispatch("-1610210391", new Object[0]) : C9508a.a;
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234030486")) {
            ipChange.ipc$dispatch("-234030486", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("havanaUserId", z20.i());
        C0529c.e().A(hashMap, "screenfloatclick", "screenfloat");
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953576424")) {
            ipChange.ipc$dispatch("-1953576424", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "before");
        hashMap.put("havanaUserId", z20.i());
        C0529c.e().A(hashMap, "feedback", vf1.FEED_BACK_LIST_PAGE);
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787282219")) {
            ipChange.ipc$dispatch("-787282219", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "after");
        hashMap.put("havanaUserId", z20.i());
        C0529c.e().A(hashMap, "feedback", vf1.FEED_BACK_LIST_PAGE);
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328035992")) {
            ipChange.ipc$dispatch("328035992", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ScreenShot", "true");
        hashMap.put("permission", "after");
        hashMap.put("havanaUserId", z20.i());
        C0529c.e().A(hashMap, "shotshare", "addscreenshare");
    }
}
