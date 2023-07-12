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
public final class i72 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final i72 INSTANCE = new i72();
    @NotNull
    public static final String PAGE_SCRIPT = "scriptkill_associate";
    @NotNull
    public static final String PAGE_SHOP = "scriptkill_store_associate";
    @Nullable
    private static Integer a;

    private i72() {
    }

    private final TrackInfo a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847898482")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1847898482", new Object[]{this});
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(ld.INSTANCE.a());
        trackInfo.setSpmb(INSTANCE.b());
        return trackInfo;
    }

    private final String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698590209")) {
            return (String) ipChange.ipc$dispatch("-1698590209", new Object[]{this});
        }
        Integer num = a;
        return (num != null && num.intValue() == 1) ? PAGE_SCRIPT : PAGE_SHOP;
    }

    public final void c(@Nullable View view, @Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721001162")) {
            ipChange.ipc$dispatch("721001162", new Object[]{this, view, str, str2});
            return;
        }
        TrackInfo a2 = a();
        a2.setSpmc("topic");
        a2.setSpmd("upload");
        HashMap<String, String> hashMap = new HashMap<>();
        Integer num = a;
        if (num != null && num.intValue() == 1) {
            hashMap.put("scriptId", str);
        } else {
            hashMap.put("storeld", str);
        }
        hashMap.put("keyword", str2);
        a2.setArgs(hashMap);
        UserTrackProviderProxy.click(view, a2, false);
    }

    public final void d(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112990148")) {
            ipChange.ipc$dispatch("2112990148", new Object[]{this, num});
        } else {
            a = num;
        }
    }
}
