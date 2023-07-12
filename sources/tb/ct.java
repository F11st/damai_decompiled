package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ct extends nb {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private Map<String, String> b;

    @Override // tb.nb
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1600277780")) {
            ipChange.ipc$dispatch("1600277780", new Object[]{this, hashMap});
            return;
        }
        Map<String, String> map = this.b;
        if (map != null && hashMap != null) {
            hashMap.putAll(map);
        }
        super.fillExtraData(hashMap);
        AppMonitor.Stat.setSampling(10000);
    }

    @Override // tb.nb
    @Nullable
    public String getBizScene() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1584422119") ? (String) ipChange.ipc$dispatch("-1584422119", new Object[]{this}) : this.a;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-738055023") ? (String) ipChange.ipc$dispatch("-738055023", new Object[]{this}) : "failureMonitor";
    }

    @Override // tb.nb
    public void setBizScene(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754773275")) {
            ipChange.ipc$dispatch("-1754773275", new Object[]{this, str});
            return;
        }
        if (str == null) {
            str = "damai-android";
        }
        this.a = str;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351203565")) {
            ipChange.ipc$dispatch("1351203565", new Object[]{this, map});
        } else {
            this.b = map;
        }
    }
}
