package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class f23 extends nb {
    @Nullable
    private String a;
    @Nullable
    private Map<String, String> b;

    @Override // tb.nb
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
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
        return this.a;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        return "failureMonitor";
    }

    @Override // tb.nb
    public void setBizScene(@Nullable String str) {
        if (str == null) {
            str = AgooConstants.MESSAGE_POPUP;
        }
        this.a = str;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        this.b = map;
    }
}
