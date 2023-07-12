package tb;

import android.view.View;
import com.alibaba.pictures.bricks.gaiaxholder.UtParam;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class qo1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final qo1 INSTANCE = new qo1();

    private qo1() {
    }

    private final TrackInfo f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730331515")) {
            return (TrackInfo) ipChange.ipc$dispatch("-730331515", new Object[]{this});
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma("a2o4t");
        trackInfo.setSpmb(pp2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE);
        return trackInfo;
    }

    public final void a(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2072346095")) {
            ipChange.ipc$dispatch("2072346095", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("bottom");
        trackInfo.setSpmd("closeorder");
        UserTrackProviderProxy.click(view, trackInfo, false);
    }

    public final void b(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853729461")) {
            ipChange.ipc$dispatch("-1853729461", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("bottom");
        trackInfo.setSpmd("closeorder");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void c(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323506168")) {
            ipChange.ipc$dispatch("323506168", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo f = f();
        f.setSpmc("order_info");
        f.setSpmd("orderid_copy");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderid", str);
        f.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, f);
    }

    public final void d(@Nullable View view, @Nullable UtParam utParam) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326140592")) {
            ipChange.ipc$dispatch("326140592", new Object[]{this, view, utParam});
        } else if (view == null || utParam == null) {
        } else {
            UserTrackProviderProxy.expose(view, utParam);
        }
    }

    public final void e(@NotNull View view, @Nullable String str, @Nullable String str2, @Nullable String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1740397277")) {
            ipChange.ipc$dispatch("1740397277", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "view");
        TrackInfo f = f();
        f.setSpmc("question");
        f.setSpmd("item_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        hashMap.put("orderid", str2);
        hashMap.put("titlelabel", str3);
        f.setArgs(hashMap);
        UserTrackProviderProxy.expose(view, f);
    }

    public final void g(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278366723")) {
            ipChange.ipc$dispatch("1278366723", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("answers");
        trackInfo.setSpmd("showanswerbtn");
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    public final void h(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697286217")) {
            ipChange.ipc$dispatch("-697286217", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("answers");
        trackInfo.setSpmd("showanswerbtn");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void i(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369771265")) {
            ipChange.ipc$dispatch("-369771265", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("bottom");
        trackInfo.setSpmd("submitpay");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void j(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1763192469")) {
            ipChange.ipc$dispatch("1763192469", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("bottom");
        trackInfo.setSpmd("submitpay");
        UserTrackProviderProxy.click(view, trackInfo, false);
    }

    public final void k(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012172957")) {
            ipChange.ipc$dispatch("-1012172957", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("grouppurchasecoupons");
        trackInfo.setSpmd("refund");
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    public final void l(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1310427735")) {
            ipChange.ipc$dispatch("1310427735", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc("grouppurchasecoupons");
        trackInfo.setSpmd("refund");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void m(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028321329")) {
            ipChange.ipc$dispatch("-1028321329", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc(pp2.PROJECT_EVALUATE);
        trackInfo.setSpmd("viewevaluation");
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    public final void n(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809828203")) {
            ipChange.ipc$dispatch("809828203", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc(pp2.PROJECT_EVALUATE);
        trackInfo.setSpmd("viewevaluation");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void o(@NotNull View view, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049282991")) {
            ipChange.ipc$dispatch("2049282991", new Object[]{this, view, str});
            return;
        }
        b41.i(view, "view");
        TrackInfo f = f();
        f.setSpmc("order_info");
        f.setSpmd("orderid_copy");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("orderid", str);
        f.setArgs(hashMap);
        UserTrackProviderProxy.click(view, f, false);
    }

    public final void p(@NotNull View view, @Nullable String str, @Nullable String str2, @Nullable String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697037946")) {
            ipChange.ipc$dispatch("-1697037946", new Object[]{this, view, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "view");
        TrackInfo f = f();
        f.setSpmc("question");
        f.setSpmd("item_" + i);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("item_id", str);
        hashMap.put("orderid", str2);
        hashMap.put("titlelabel", str3);
        f.setArgs(hashMap);
        UserTrackProviderProxy.click(view, f, true);
    }

    public final void q(@Nullable UtParam utParam, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397696226")) {
            ipChange.ipc$dispatch("397696226", new Object[]{this, utParam, Boolean.valueOf(z)});
        } else if (utParam != null) {
            UserTrackProviderProxy.click(null, utParam, z);
        }
    }

    public final void r(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034278785")) {
            ipChange.ipc$dispatch("-2034278785", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc(pp2.PROJECT_EVALUATE);
        trackInfo.setSpmd("evaluatebtn");
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    public final void s(@NotNull View view, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310081861")) {
            ipChange.ipc$dispatch("-310081861", new Object[]{this, view, trackInfo});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmc(pp2.PROJECT_EVALUATE);
        trackInfo.setSpmd("evaluatebtn");
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    public final void t(@NotNull View view, @NotNull TrackInfo trackInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54003880")) {
            ipChange.ipc$dispatch("-54003880", new Object[]{this, view, trackInfo, Boolean.valueOf(z)});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmd("useatthestore");
        if (z) {
            trackInfo.setSpmc("bottom");
        } else {
            trackInfo.setSpmc("grouppurchasecoupons");
        }
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    public final void u(@NotNull View view, @NotNull TrackInfo trackInfo, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966304074")) {
            ipChange.ipc$dispatch("-1966304074", new Object[]{this, view, trackInfo, Boolean.valueOf(z)});
            return;
        }
        b41.i(view, "view");
        b41.i(trackInfo, "trackInfo");
        trackInfo.setSpmd("useatthestore");
        if (z) {
            trackInfo.setSpmc("bottom");
        } else {
            trackInfo.setSpmc("grouppurchasecoupons");
        }
        UserTrackProviderProxy.expose(view, trackInfo);
    }
}
