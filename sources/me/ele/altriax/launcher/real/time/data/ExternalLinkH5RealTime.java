package me.ele.altriax.launcher.real.time.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import me.ele.altriax.launcher.real.time.data.core.IELRealTime;
import me.ele.altriax.launcher.real.time.data.utils.Timing;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExternalLinkH5RealTime implements IELRealTime {
    private static ExternalLinkH5RealTime instance;
    private List<rf0> apmEvents;
    private Map<String, Object> apmProperties;
    private List<qf2> apmStages;
    private Map<String, Object> apmStats;
    private String externalLinkUrl;
    private String launchType;
    private long applicationAttach = 0;
    private double apmStart = 0.0d;
    private long dagStart = 0;
    private long mFront = 0;
    private long mLaunch = 0;
    private long mAHead = 0;
    private long mATail = 0;
    private long mAC = 0;
    private long dagEnd = 0;
    private long applicationEnd = 0;
    private long homeStart = 0;
    private long h5ActivityStart = 0;
    private long loadUrlStart = 0;
    private long t1End = 0;
    private long pageFinished = 0;
    private long renderComplete = 0;
    private double launchDuration = 0.0d;
    private boolean firstInstall = false;
    private boolean firstLaunch = false;
    private ConcurrentHashMap<String, Long> bizTimeMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> bizEventMap = new ConcurrentHashMap<>();

    private ExternalLinkH5RealTime() {
    }

    public static ExternalLinkH5RealTime getInstance() {
        if (instance == null) {
            instance = new ExternalLinkH5RealTime();
        }
        return instance;
    }

    public List<rf0> getApmEvents() {
        return this.apmEvents;
    }

    public Map<String, Object> getApmProperties() {
        return this.apmProperties;
    }

    public List<qf2> getApmStages() {
        return this.apmStages;
    }

    public double getApmStart() {
        return this.apmStart;
    }

    public Map<String, Object> getApmStats() {
        return this.apmStats;
    }

    public long getApplicationAttach() {
        return this.applicationAttach;
    }

    public long getApplicationEnd() {
        return this.applicationEnd;
    }

    public Map<String, String> getBizEventMap() {
        return this.bizEventMap;
    }

    public Map<String, Long> getBizTimeMap() {
        return this.bizTimeMap;
    }

    public long getDagEnd() {
        return this.dagEnd;
    }

    public long getDagStart() {
        return this.dagStart;
    }

    public String getExternalLinkUrl() {
        return this.externalLinkUrl;
    }

    public long getH5ActivityStart() {
        return this.h5ActivityStart;
    }

    public long getHomeStart() {
        return this.homeStart;
    }

    public double getLaunchDuration() {
        return this.launchDuration;
    }

    public String getLaunchType() {
        return this.launchType;
    }

    public long getLoadUrlStart() {
        return this.loadUrlStart;
    }

    public long getPageFinished() {
        return this.pageFinished;
    }

    public long getRenderComplete() {
        return this.renderComplete;
    }

    public long getT1End() {
        return this.t1End;
    }

    public long getmAC() {
        return this.mAC;
    }

    public long getmAHead() {
        return this.mAHead;
    }

    public long getmATail() {
        return this.mATail;
    }

    public long getmFront() {
        return this.mFront;
    }

    public long getmLaunch() {
        return this.mLaunch;
    }

    public boolean isFirstInstall() {
        return this.firstInstall;
    }

    public boolean isFirstLaunch() {
        return this.firstLaunch;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmEvents(@Nullable List<rf0> list) {
        this.apmEvents = list;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmProperties(@Nullable Map<String, Object> map) {
        this.apmProperties = map;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStages(@Nullable List<qf2> list) {
        this.apmStages = list;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStart() {
        this.apmStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStats(@Nullable Map<String, Object> map) {
        this.apmStats = map;
    }

    public void setApplicationAttach(long j) {
        this.applicationAttach = j;
    }

    public void setApplicationEnd(long j) {
        this.applicationEnd = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizEvent(@NonNull String str, @NonNull String str2) {
        this.bizEventMap.put(str, str2);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizTime(@NonNull String str, long j) {
        this.bizTimeMap.put(str, Long.valueOf(j));
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagEnd() {
        this.dagEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagStart() {
        this.dagStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setExternalLinkUrl(@NonNull String str) {
        this.externalLinkUrl = str;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstInstall(boolean z) {
        this.firstInstall = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstLaunch(boolean z) {
        this.firstLaunch = z;
    }

    public void setH5ActivityStart(long j) {
        this.h5ActivityStart = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setHomeStart() {
        this.homeStart = Timing.current();
    }

    public void setLaunchDuration(double d) {
        this.launchDuration = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLaunchType(@Nullable String str) {
        this.launchType = str;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLauncherResumeTime() {
        setBizTime(BizTime.LAUNCHER_RESUME_TIME, Timing.current());
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLauncherStartTime() {
        setBizTime(BizTime.LAUNCHER_START_TIME, Timing.current());
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setLoadUrlStart(@NonNull String str) {
        this.loadUrlStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMAC(long j) {
        this.mAC = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMAHead(long j) {
        this.mAHead = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMATail(long j) {
        this.mATail = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMFront(long j) {
        this.mFront = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMLaunch(long j) {
        this.mLaunch = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setPageFinished(@NonNull String str) {
        this.pageFinished = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j) {
        this.renderComplete = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setSchemeRouteEndTime() {
        setBizTime(BizTime.SCHEME_ROUTE_END_TIME, Timing.current());
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setSchemeRouteStartTime() {
        setBizTime(BizTime.SCHEME_ROUTE_START_TIME, Timing.current());
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setT1End(@NonNull String str) {
        this.t1End = Timing.current();
    }

    public void setmAC(long j) {
        this.mAC = j;
    }

    public void setmAHead(long j) {
        this.mAHead = j;
    }

    public void setmATail(long j) {
        this.mATail = j;
    }

    public void setmLaunch(long j) {
        this.mLaunch = j;
    }

    public void setApmStart(double d) {
        this.apmStart = d;
    }

    public void setDagEnd(long j) {
        this.dagEnd = j;
    }

    public void setDagStart(long j) {
        this.dagStart = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setH5ActivityStart() {
        this.h5ActivityStart = Timing.current();
    }

    public void setHomeStart(long j) {
        this.homeStart = j;
    }

    public void setLoadUrlStart(long j) {
        this.loadUrlStart = j;
    }

    public void setPageFinished(long j) {
        this.pageFinished = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j, long j2) {
        this.launchDuration = j;
        this.renderComplete = j2;
    }

    public void setT1End(long j) {
        this.t1End = j;
    }
}
