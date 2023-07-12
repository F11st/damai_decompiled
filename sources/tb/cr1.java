package tb;

import android.view.View;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class cr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final cr1 INSTANCE = new cr1();
    @Nullable
    private static String a;
    @Nullable
    private static String b;
    @Nullable
    private static String c;

    private cr1() {
    }

    private final TrackInfo a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337400199")) {
            return (TrackInfo) ipChange.ipc$dispatch("-337400199", new Object[]{this});
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(ld.INSTANCE.a());
        trackInfo.setSpmb("scriptkill_payresult");
        return trackInfo;
    }

    public final void b(@Nullable View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636238157")) {
            ipChange.ipc$dispatch("1636238157", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("otherperform");
        a2.setSpmd("item_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a2, true);
    }

    public final void c(@Nullable View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708425875")) {
            ipChange.ipc$dispatch("1708425875", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("otherperform");
        a2.setSpmd("item_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a2);
    }

    public final void d(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "830213451")) {
            ipChange.ipc$dispatch("830213451", new Object[]{this, view});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("tools");
        a2.setSpmd("showorderdetailbtn");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a2, true);
    }

    public final void e(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813963288")) {
            ipChange.ipc$dispatch("1813963288", new Object[]{this, view});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("tools");
        a2.setSpmd("showorderdetailbtn");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a2);
    }

    public final void f(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842225795")) {
            ipChange.ipc$dispatch("842225795", new Object[]{this, view});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("tools");
        a2.setSpmd("gotohomebtn");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a2, true);
    }

    public final void g(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559212035")) {
            ipChange.ipc$dispatch("559212035", new Object[]{this, view});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("tools");
        a2.setSpmd("gotohomebtn");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", a);
        hashMap.put("titlelable", b);
        hashMap.put("contentlabel", c);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a2);
    }

    public final void h(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455809443")) {
            ipChange.ipc$dispatch("-1455809443", new Object[]{this, str, str2, str3});
            return;
        }
        a = str;
        b = str2;
        c = str3;
    }
}
