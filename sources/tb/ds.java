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
public final class ds extends nb {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String a;
    @Nullable
    private Map<String, String> b;

    @Override // tb.nb
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402006423")) {
            ipChange.ipc$dispatch("402006423", new Object[]{this, hashMap});
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
        return AndroidInstantRuntime.support(ipChange, "955265308") ? (String) ipChange.ipc$dispatch("955265308", new Object[]{this}) : this.a;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "682843886") ? (String) ipChange.ipc$dispatch("682843886", new Object[]{this}) : "page_business";
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r5 == null) goto L11;
     */
    @Override // tb.nb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setBizScene(@org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ds.$ipChange
            java.lang.String r1 = "-333874366"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r5 == 0) goto L26
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r0 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            tb.b41.h(r5, r0)
            if (r5 != 0) goto L28
        L26:
            java.lang.String r5 = "damai-android"
        L28:
            r4.a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ds.setBizScene(java.lang.String):void");
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823116400")) {
            ipChange.ipc$dispatch("823116400", new Object[]{this, map});
        } else {
            this.b = map;
        }
    }
}
