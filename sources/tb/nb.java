package tb;

import com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class nb extends BaseMonitorPoint {
    @Nullable
    private String bizCode;
    @Nullable
    private String bizMsg;
    @Nullable
    private String bizScene;
    @Nullable
    private HashMap<String, String> extraDataMap = new HashMap<>();
    private int failCount;
    @Nullable
    private String pageName;
    @Nullable
    private String pageSpm;
    private int successCount;
    private int successState;

    public void fillExtraData(@Nullable HashMap<String, String> hashMap) {
    }

    @Nullable
    public String getBizCode() {
        return this.bizCode;
    }

    @Nullable
    public String getBizMsg() {
        return this.bizMsg;
    }

    @Nullable
    public abstract String getBizScene();

    @Nullable
    public HashMap<String, String> getExtraDataMap() {
        return this.extraDataMap;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    @Nullable
    public String getPageName() {
        return this.pageName;
    }

    @Nullable
    public String getPageSpm() {
        return this.pageSpm;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    @NotNull
    public BaseMonitorPoint.MonitorType getPointType() {
        return BaseMonitorPoint.MonitorType.APP_MONITOR;
    }

    @NotNull
    public String getSignCode() {
        return '-' + this.successState + '-' + getPointName();
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final int getSuccessState() {
        return this.successState;
    }

    @Override // com.alibaba.yymidservice.appmonitor.base.BaseMonitorPoint
    public void release() {
        try {
            if (getExtraDataMap() != null) {
                HashMap<String, String> extraDataMap = getExtraDataMap();
                if (extraDataMap != null) {
                    extraDataMap.clear();
                }
                fillExtraData(getExtraDataMap());
            }
            h23.Companion.a().g(this);
        } catch (Exception unused) {
        }
    }

    public void setBizCode(@Nullable String str) {
        this.bizCode = str;
    }

    public void setBizMsg(@Nullable String str) {
        this.bizMsg = str;
    }

    public abstract void setBizScene(@Nullable String str);

    public void setExtraDataMap(@Nullable HashMap<String, String> hashMap) {
        this.extraDataMap = hashMap;
    }

    public final void setFailCount(int i) {
        this.failCount = i;
    }

    public void setPageName(@Nullable String str) {
        this.pageName = str;
    }

    public void setPageSpm(@Nullable String str) {
        this.pageSpm = str;
    }

    @NotNull
    public nb setResultExpected(boolean z) {
        if (z) {
            this.successState = 1;
            this.failCount = 0;
            this.successCount = 1;
        } else {
            this.successState = 0;
            this.failCount = 1;
            this.successCount = 0;
        }
        return this;
    }

    public final void setSuccessCount(int i) {
        this.successCount = i;
    }

    public final void setSuccessState(int i) {
        this.successState = i;
    }

    @NotNull
    public String toString() {
        HashMap<String, String> extraDataMap = getExtraDataMap();
        String e = extraDataMap != null ? yh0.INSTANCE.e(extraDataMap) : "";
        return getPointName() + '-' + getBizScene() + '-' + getBizCode() + '-' + getPageName() + '-' + e;
    }
}
