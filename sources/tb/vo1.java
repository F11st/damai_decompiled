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
public final class vo1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final vo1 INSTANCE = new vo1();

    private vo1() {
    }

    private final TrackInfo a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891496679")) {
            return (TrackInfo) ipChange.ipc$dispatch("-891496679", new Object[]{this});
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(ld.INSTANCE.a());
        trackInfo.setSpmb(pp2.ORDER_LIST_PAGE);
        return trackInfo;
    }

    public final void b(@Nullable View view, @Nullable String str, int i, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779161887")) {
            ipChange.ipc$dispatch("1779161887", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab_" + str2);
        a.setSpmd("comment_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, true);
    }

    public final void c(@Nullable View view, @Nullable String str, int i, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790023675")) {
            ipChange.ipc$dispatch("790023675", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab_" + str2);
        a.setSpmd("comment_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }

    public final void d(@Nullable View view, @Nullable String str, int i, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436890663")) {
            ipChange.ipc$dispatch("436890663", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab_" + str2);
        a.setSpmd("commentgo_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, true);
    }

    public final void e(@Nullable View view, @Nullable String str, int i, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002155779")) {
            ipChange.ipc$dispatch("2002155779", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab_" + str2);
        a.setSpmd("commentgo_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }

    public final void f(@Nullable View view, @Nullable String str, int i, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-270015237")) {
            ipChange.ipc$dispatch("-270015237", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab_" + str2);
        a.setSpmd("coupon_card_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderId", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, true);
    }

    public final void g(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927412414")) {
            ipChange.ipc$dispatch("927412414", new Object[]{this, str, str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab");
        a.setSpmd("scriptkillorder_" + str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("usercode", str2);
        a.setArgs(hashMap);
        a.setClickEventName("scriptkill_tab_scriptkillorder_" + str);
        UserTrackProviderProxy.click(a, false);
    }

    public final void h(@Nullable View view, @Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-17887918")) {
            ipChange.ipc$dispatch("-17887918", new Object[]{this, view, str, str2});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("scriptkill_tab");
        a.setSpmd("scriptkillorder_" + str);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("usercode", str2);
        a.setArgs(hashMap);
        a.setExposeEventName("page_showorder_scriptable_tab_scriptkillorder_" + str);
        UserTrackProviderProxy.expose(view, a);
    }
}
