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
public final class vn1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final vn1 INSTANCE = new vn1();

    private vn1() {
    }

    private final TrackInfo a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102766997")) {
            return (TrackInfo) ipChange.ipc$dispatch("2102766997", new Object[]{this});
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(ld.INSTANCE.a());
        trackInfo.setSpmb("scriptkill_confirm");
        return trackInfo;
    }

    public final void b(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412795348")) {
            ipChange.ipc$dispatch("1412795348", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("discount");
        a.setSpmd("discount_list");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, false);
    }

    public final void c(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439867896")) {
            ipChange.ipc$dispatch("439867896", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("discount");
        a.setSpmd("discount_list");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }

    public final void d(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002715470")) {
            ipChange.ipc$dispatch("1002715470", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("bottom");
        a.setSpmd("order_detail");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, false);
    }

    public final void e(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1795752946")) {
            ipChange.ipc$dispatch("1795752946", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("bottom");
        a.setSpmd("order_detail");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }

    public final void f(@Nullable View view, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025990681")) {
            ipChange.ipc$dispatch("-2025990681", new Object[]{this, view, str, str2, str3});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("pay");
        a.setSpmd("pay_type_" + str3);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, false);
    }

    public final void g(@Nullable View view, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785737419")) {
            ipChange.ipc$dispatch("785737419", new Object[]{this, view, str, str2, str3});
            return;
        }
        TrackInfo a = a();
        a.setSpmc("pay");
        a.setSpmd("pay_type_" + str3);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }

    public final void h(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388378239")) {
            ipChange.ipc$dispatch("388378239", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("bottom");
        a.setSpmd("submit");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a, false);
    }

    public final void i(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-261058461")) {
            ipChange.ipc$dispatch("-261058461", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo a = a();
        a.setSpmc("bottom");
        a.setSpmd("submit");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        a.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, a);
    }
}
