package com.youku.gaiax.provider.module.util;

import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h23;
import tb.nb;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016R.\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/provider/module/util/PicXflushMonitorPoint;", "Ltb/nb;", "", "getPointName", "Ljava/util/HashMap;", "extraDataMap", "Ltb/wt2;", "fillExtraData", "value", h23.BIZ_SCENE_DIMEN, "Ljava/lang/String;", "getBizScene", "()Ljava/lang/String;", "setBizScene", "(Ljava/lang/String;)V", "", "extral", "Ljava/util/Map;", "getExtral", "()Ljava/util/Map;", "setExtral", "(Ljava/util/Map;)V", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PicXflushMonitorPoint extends nb {
    @Nullable
    private String bizScene;
    @Nullable
    private Map<String, String> extral;

    @Override // tb.nb
    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
        Map<String, String> map = this.extral;
        if (map != null && hashMap != null) {
            hashMap.putAll(map);
        }
        super.fillExtraData(hashMap);
        AppMonitor.Stat.setSampling(10000);
    }

    @Override // tb.nb
    @Nullable
    public String getBizScene() {
        return this.bizScene;
    }

    @Nullable
    public final Map<String, String> getExtral() {
        return this.extral;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public String getPointName() {
        return "failureMonitor";
    }

    @Override // tb.nb
    public void setBizScene(@Nullable String str) {
        if (str == null) {
            str = null;
        }
        if (str == null) {
            str = "pic-android";
        }
        this.bizScene = str;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        this.extral = map;
    }
}
