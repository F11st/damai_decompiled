package me.ele.altriax.launcher.real.time.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import me.ele.altriax.launcher.real.time.data.core.ICLRealTime;
import me.ele.altriax.launcher.real.time.data.utils.Timing;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ColdLaunchRealTime implements ICLRealTime {
    private static ColdLaunchRealTime instance;
    private List<rf0> apmEvents;
    private Map<String, Object> apmProperties;
    private List<qf2> apmStages;
    private Map<String, Object> apmStats;
    private long cacheCreateMistItemsEnd;
    private long cacheCreateMistItemsStart;
    private long cacheLoadMistTemplatesEnd;
    private long cacheLoadMistTemplatesStart;
    private String launchType;
    private long preAddressEnd;
    private long preAddressStart;
    private long preRequestEnd;
    private long preRequestStart;
    private long applicationAttach = 0;
    private long applicationCreate = 0;
    private long apmStart = 0;
    private long dagStart = 0;
    private long mFront = 0;
    private long mLaunch = 0;
    private long mAHead = 0;
    private long mATail = 0;
    private long mAC = 0;
    private long dagEnd = 0;
    private long applicationEnd = 0;
    private long homeStart = 0;
    private ConcurrentHashMap<String, Long> bizTimeMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> bizEventMap = new ConcurrentHashMap<>();
    private long renderComplete = 0;
    private boolean useCache = false;
    private boolean usePresetData = false;
    private double launchDuration = 0.0d;
    private double cacheDay = 0.0d;
    private double cacheHour = 0.0d;
    private double cacheMinute = 0.0d;
    private double cacheSecond = 0.0d;
    private double cacheMillisecond = 0.0d;
    private double cacheDuration = 0.0d;
    private boolean writeCacheSuccess = false;
    private boolean firstInstall = false;
    private boolean firstLaunch = false;

    private ColdLaunchRealTime() {
    }

    public static ColdLaunchRealTime getInstance() {
        if (instance == null) {
            instance = new ColdLaunchRealTime();
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

    public long getApmStart() {
        return this.apmStart;
    }

    public Map<String, Object> getApmStats() {
        return this.apmStats;
    }

    public long getApplicationAttach() {
        return this.applicationAttach;
    }

    public long getApplicationCreate() {
        return this.applicationCreate;
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

    public long getCacheCreateMistItemsEnd() {
        return this.cacheCreateMistItemsEnd;
    }

    public long getCacheCreateMistItemsStart() {
        return this.cacheCreateMistItemsStart;
    }

    public double getCacheDay() {
        return this.cacheDay;
    }

    public double getCacheDuration() {
        return this.cacheDuration;
    }

    public double getCacheHour() {
        return this.cacheHour;
    }

    public long getCacheLoadMistTemplatesEnd() {
        return this.cacheLoadMistTemplatesEnd;
    }

    public long getCacheLoadMistTemplatesStart() {
        return this.cacheLoadMistTemplatesStart;
    }

    public double getCacheMillisecond() {
        return this.cacheMillisecond;
    }

    public double getCacheMinute() {
        return this.cacheMinute;
    }

    public double getCacheSecond() {
        return this.cacheSecond;
    }

    public long getDagEnd() {
        return this.dagEnd;
    }

    public long getDagStart() {
        return this.dagStart;
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

    public long getPreAddressEnd() {
        return this.preAddressEnd;
    }

    public long getPreAddressStart() {
        return this.preAddressStart;
    }

    public long getPreRequestEnd() {
        return this.preRequestEnd;
    }

    public long getPreRequestStart() {
        return this.preRequestStart;
    }

    public long getRenderComplete() {
        return this.renderComplete;
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

    public boolean isUseCache() {
        return this.useCache;
    }

    public boolean isUsePresetData() {
        return this.usePresetData;
    }

    public boolean isWriteCacheSuccess() {
        return this.writeCacheSuccess;
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

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationAttachContext() {
        this.applicationAttach = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationCreate() {
        this.applicationCreate = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationEnd() {
        this.dagEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizEvent(@NonNull String str, @NonNull String str2) {
        this.bizEventMap.put(str, str2);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizTime(@NonNull String str, long j) {
        this.bizTimeMap.put(str, Long.valueOf(j));
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheCreateMistItemsEnd() {
        this.cacheCreateMistItemsEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheCreateMistItemsStart() {
        this.cacheCreateMistItemsStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheDay(double d) {
        this.cacheDay = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheDuration(double d) {
        this.cacheDuration = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheHour(double d) {
        this.cacheHour = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheLoadMistTemplatesEnd() {
        this.cacheLoadMistTemplatesEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheLoadMistTemplatesStart() {
        this.cacheLoadMistTemplatesStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheMillisecond(double d) {
        this.cacheMillisecond = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheMinute(double d) {
        this.cacheMinute = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheSecond(double d) {
        this.cacheSecond = d;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagEnd() {
        this.dagEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagStart() {
        this.dagStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstInstall(boolean z) {
        this.firstInstall = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstLaunch(boolean z) {
        this.firstLaunch = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime, me.ele.altriax.launcher.real.time.data.core.IELRealTime
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

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreAddressEnd() {
        this.preAddressEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreAddressStart() {
        this.preAddressStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreRequestEnd() {
        this.preRequestEnd = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreRequestStart() {
        this.preRequestStart = Timing.current();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j) {
        this.renderComplete = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setUseCache(boolean z) {
        this.useCache = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setUsePresetData(boolean z) {
        this.usePresetData = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setWriteCacheSuccess() {
        this.writeCacheSuccess = true;
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

    public void setApmStart(long j) {
        this.apmStart = j;
    }

    public void setApplicationCreate(long j) {
        this.applicationCreate = j;
    }

    public void setApplicationEnd(long j) {
        this.applicationEnd = j;
    }

    public void setCacheCreateMistItemsEnd(long j) {
        this.cacheCreateMistItemsEnd = j;
    }

    public void setCacheCreateMistItemsStart(long j) {
        this.cacheCreateMistItemsStart = j;
    }

    public void setCacheLoadMistTemplatesEnd(long j) {
        this.cacheLoadMistTemplatesEnd = j;
    }

    public void setCacheLoadMistTemplatesStart(long j) {
        this.cacheLoadMistTemplatesStart = j;
    }

    public void setDagEnd(long j) {
        this.dagEnd = j;
    }

    public void setDagStart(long j) {
        this.dagStart = j;
    }

    public void setHomeStart(long j) {
        this.homeStart = j;
    }

    public void setPreAddressEnd(long j) {
        this.preAddressEnd = j;
    }

    public void setPreAddressStart(long j) {
        this.preAddressStart = j;
    }

    public void setPreRequestEnd(long j) {
        this.preRequestEnd = j;
    }

    public void setPreRequestStart(long j) {
        this.preRequestStart = j;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j, long j2) {
        this.launchDuration = j;
        this.renderComplete = j2;
    }

    public void setWriteCacheSuccess(boolean z) {
        this.writeCacheSuccess = z;
    }
}
