package com.alient.onearch.adapter.monitor;

import com.alibaba.mtl.appmonitor.AppMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.h23;
import tb.k50;
import tb.nb;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\b\u001a\u00020\u00072&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/alient/onearch/adapter/monitor/CMSPageMonitorPoint;", "Ltb/nb;", "", "getPointName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraDataMap", "Ltb/wt2;", "fillExtraData", h23.BIZ_SCENE_DIMEN, "Ljava/lang/String;", "getBizScene", "()Ljava/lang/String;", "setBizScene", "(Ljava/lang/String;)V", "", "extral", "Ljava/util/Map;", "getExtral", "()Ljava/util/Map;", "setExtral", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class CMSPageMonitorPoint extends nb {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private String bizScene = "onearch";
    @Nullable
    private Map<String, String> extral;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/monitor/CMSPageMonitorPoint$Companion;", "", "", "bizCode", h23.BIZ_MSG_DIMEN, "", h23.EXTRA_DATA_DIMEN, "", "expected", "Ltb/wt2;", "commitCMSPageMonitorFail", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void commitCMSPageMonitorFail$default(Companion companion, String str, String str2, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            companion.commitCMSPageMonitorFail(str, str2, map, z);
        }

        public final void commitCMSPageMonitorFail(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, boolean z) {
            b41.i(str, "bizCode");
            CMSPageMonitorPoint cMSPageMonitorPoint = new CMSPageMonitorPoint();
            cMSPageMonitorPoint.setBizCode(str);
            cMSPageMonitorPoint.setBizMsg(str2);
            cMSPageMonitorPoint.setResultExpected(z);
            if (map != null) {
                cMSPageMonitorPoint.setExtral(map);
            }
            cMSPageMonitorPoint.release();
        }
    }

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
        return "business";
    }

    @Override // tb.nb
    public void setBizScene(@Nullable String str) {
        this.bizScene = str;
    }

    public final void setExtral(@Nullable Map<String, String> map) {
        this.extral = map;
    }
}
