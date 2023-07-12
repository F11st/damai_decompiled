package me.ele.altriax.launcher.real.time.data;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.monitor.procedure.IProcedure;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.altriax.launcher.biz.strategy.Discriminator;
import me.ele.altriax.launcher.common.AltriaXExecutor;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import me.ele.altriax.launcher.real.time.data.bean.ApmBean;
import me.ele.altriax.launcher.real.time.data.core.ICLRealTime;
import me.ele.altriax.launcher.real.time.data.core.IELHomeRealTime;
import me.ele.altriax.launcher.real.time.data.core.IELRealTime;
import me.ele.altriax.launcher.real.time.data.monitor.BaseMonitor;
import me.ele.altriax.launcher.real.time.data.monitor.ColdLaunchMonitor;
import me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkH5Monitor;
import me.ele.altriax.launcher.real.time.data.monitor.ExternalLinkHomeMonitor;
import me.ele.altriax.launcher.real.time.data.monitor.PolymerizationMonitor;
import me.ele.altriax.launcher.real.time.data.utils.Timing;
import me.ele.altriax.launcher.real.time.data.utils.Value;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXRealTime implements ICLRealTime, IELHomeRealTime, IELRealTime {
    private static final String TAG = "AltriaXRealTime";
    private Handler childThreadHandler;
    private ThreadPoolExecutor executor;
    private Gson gson;
    private IProcedure procedure;
    private ColdLaunchRealTime coldLaunchRealTime = ColdLaunchRealTime.getInstance();
    private ExternalLinkH5RealTime externalLinkH5RealTime = ExternalLinkH5RealTime.getInstance();
    private ExternalLinkHomeRealTime externalLinkHomeRealTime = ExternalLinkHomeRealTime.getInstance();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IoDHHolder {
        private static final AltriaXRealTime instance = new AltriaXRealTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchReport() {
        AltriaXExecutor.ALTRIAX_EXECUTOR.execute(new Runnable() { // from class: me.ele.altriax.launcher.real.time.data.AltriaXRealTime.2
            @Override // java.lang.Runnable
            public void run() {
                AltriaXRealTime.this.setMFront(LauncherRuntime.mFront);
                AltriaXRealTime.this.setMLaunch(LauncherRuntime.mLaunch);
                AltriaXRealTime.this.setMAHead(LauncherRuntime.mAHead);
                AltriaXRealTime.this.setMATail(LauncherRuntime.mATail);
                AltriaXRealTime.this.setMAC(LauncherRuntime.mAC);
                AltriaXRealTime.this.gson = new Gson();
                AltriaXRealTime altriaXRealTime = AltriaXRealTime.this;
                altriaXRealTime.setApmData(altriaXRealTime.procedure);
                if (Discriminator.isExternalLinkH5) {
                    AltriaXRealTime.this.setExternalLinkUrl(Discriminator.externalLinkUrl);
                    ExternalLinkH5Monitor externalLinkH5Monitor = ExternalLinkH5Monitor.getInstance();
                    externalLinkH5Monitor.setGson(AltriaXRealTime.this.gson);
                    externalLinkH5Monitor.addData(PolymerizationMonitor.DIMENSION_LAUNCH_STYLE, PolymerizationMonitor.LINK_H5);
                    externalLinkH5Monitor.report();
                    if (AltriaXRealTime.this.procedure != null) {
                        AltriaXRealTime.this.procedure.addBiz(BaseMonitor.BIZ_ID, externalLinkH5Monitor.getDataMap());
                    }
                    PolymerizationMonitor.getInstance().report(PolymerizationMonitor.LINK_H5);
                } else if (Discriminator.isExternalLinkHome) {
                    AltriaXRealTime.this.setExternalLinkUrl(Discriminator.externalLinkUrl);
                    ExternalLinkHomeMonitor externalLinkHomeMonitor = ExternalLinkHomeMonitor.getInstance();
                    externalLinkHomeMonitor.setGson(AltriaXRealTime.this.gson);
                    externalLinkHomeMonitor.addData(PolymerizationMonitor.DIMENSION_LAUNCH_STYLE, PolymerizationMonitor.LINK_HOME);
                    externalLinkHomeMonitor.report();
                    if (AltriaXRealTime.this.procedure != null) {
                        AltriaXRealTime.this.procedure.addBiz(BaseMonitor.BIZ_ID, externalLinkHomeMonitor.getDataMap());
                    }
                    PolymerizationMonitor.getInstance().report(PolymerizationMonitor.LINK_HOME);
                } else {
                    ColdLaunchMonitor coldLaunchMonitor = ColdLaunchMonitor.getInstance();
                    coldLaunchMonitor.setGson(AltriaXRealTime.this.gson);
                    coldLaunchMonitor.addData(PolymerizationMonitor.DIMENSION_LAUNCH_STYLE, PolymerizationMonitor.COLD);
                    coldLaunchMonitor.report();
                    if (AltriaXRealTime.this.procedure != null) {
                        AltriaXRealTime.this.procedure.addBiz(BaseMonitor.BIZ_ID, coldLaunchMonitor.getDataMap());
                    }
                    PolymerizationMonitor.getInstance().report(PolymerizationMonitor.COLD);
                }
            }
        });
    }

    public static AltriaXRealTime getInstance() {
        return IoDHHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApmData(@Nullable IProcedure iProcedure) {
        if (iProcedure == null) {
            return;
        }
        ApmBean create = new ApmBean.Builder(iProcedure).create();
        setFirstInstall(Value.stringTrue(create.firstInstall));
        setLaunchType(create.launchType);
        setFirstLaunch(Value.stringTrue(create.firstLaunch));
        setApmProperties(create.properties);
        setApmStats(create.stats);
        setApmEvents(create.events);
        setApmStages(create.stages);
    }

    public void setAd(boolean z) {
        ColdLaunchMonitor.getInstance().isAd = z;
        ExternalLinkH5Monitor.getInstance().isAd = z;
        ExternalLinkHomeMonitor.getInstance().isAd = z;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmEvents(@Nullable List<rf0> list) {
        this.coldLaunchRealTime.setApmEvents(list);
        this.externalLinkH5RealTime.setApmEvents(list);
        this.externalLinkHomeRealTime.setApmEvents(list);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmProperties(@Nullable Map<String, Object> map) {
        this.coldLaunchRealTime.setApmProperties(map);
        this.externalLinkH5RealTime.setApmProperties(map);
        this.externalLinkHomeRealTime.setApmProperties(map);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStages(@Nullable List<qf2> list) {
        this.coldLaunchRealTime.setApmStages(list);
        this.externalLinkH5RealTime.setApmStages(list);
        this.externalLinkHomeRealTime.setApmStages(list);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStart() {
        this.externalLinkH5RealTime.setApmStart();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setApmStats(@Nullable Map<String, Object> map) {
        this.coldLaunchRealTime.setApmStats(map);
        this.externalLinkH5RealTime.setApmStats(map);
        this.externalLinkHomeRealTime.setApmStats(map);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationAttachContext() {
        long current = Timing.current();
        this.coldLaunchRealTime.setApplicationAttach(current);
        this.externalLinkHomeRealTime.setApplicationAttach(current);
        this.externalLinkH5RealTime.setApplicationAttach(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationCreate() {
        this.coldLaunchRealTime.setApplicationCreate(Timing.current());
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setApplicationEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setApplicationEnd(current);
        this.externalLinkH5RealTime.setApplicationEnd(current);
        this.externalLinkHomeRealTime.setApplicationEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizEvent(@NonNull String str, @NonNull String str2) {
        this.coldLaunchRealTime.setBizEvent(str, str2);
        this.externalLinkH5RealTime.setBizEvent(str, str2);
        this.externalLinkHomeRealTime.setBizEvent(str, str2);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setBizTime(@NonNull String str, long j) {
        this.coldLaunchRealTime.setBizTime(str, j);
        this.externalLinkH5RealTime.setBizTime(str, j);
        this.externalLinkHomeRealTime.setBizTime(str, j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheCreateMistItemsEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setCacheCreateMistItemsEnd(current);
        this.externalLinkHomeRealTime.setCacheCreateMistItemsEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheCreateMistItemsStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setCacheCreateMistItemsStart(current);
        this.externalLinkHomeRealTime.setCacheCreateMistItemsStart(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheDay(double d) {
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheDuration(double d) {
        this.coldLaunchRealTime.setCacheDuration(d);
        this.externalLinkHomeRealTime.setCacheDuration(d);
        this.coldLaunchRealTime.setCacheMillisecond(d);
        this.externalLinkHomeRealTime.setCacheMillisecond(d);
        double d2 = d / 1000.0d;
        this.coldLaunchRealTime.setCacheSecond(d2);
        this.externalLinkHomeRealTime.setCacheSecond(d2);
        double d3 = d2 / 60.0d;
        this.coldLaunchRealTime.setCacheMinute(d3);
        this.externalLinkHomeRealTime.setCacheMinute(d3);
        double d4 = d3 / 60.0d;
        this.coldLaunchRealTime.setCacheHour(d4);
        this.externalLinkHomeRealTime.setCacheHour(d4);
        double d5 = d4 / 24.0d;
        this.coldLaunchRealTime.setCacheDay(d5);
        this.externalLinkHomeRealTime.setCacheDay(d5);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheHour(double d) {
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheLoadMistTemplatesEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setCacheLoadMistTemplatesEnd(current);
        this.externalLinkHomeRealTime.setCacheLoadMistTemplatesEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheLoadMistTemplatesStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setCacheLoadMistTemplatesStart(current);
        this.externalLinkHomeRealTime.setCacheLoadMistTemplatesStart(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheMillisecond(double d) {
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheMinute(double d) {
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setCacheSecond(double d) {
    }

    public void setChildThreadHandler(@NonNull Handler handler) {
        this.childThreadHandler = handler;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setDagEnd(current);
        this.externalLinkH5RealTime.setDagEnd(current);
        this.externalLinkHomeRealTime.setDagEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setDagStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setDagStart(current);
        this.externalLinkH5RealTime.setDagStart(current);
        this.externalLinkHomeRealTime.setDagStart(current);
    }

    public void setExecutor(@NonNull ThreadPoolExecutor threadPoolExecutor) {
        this.executor = threadPoolExecutor;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setExternalLinkUrl(@NonNull String str) {
        this.externalLinkHomeRealTime.setExternalLinkUrl(str);
        this.externalLinkH5RealTime.setExternalLinkUrl(str);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstInstall(boolean z) {
        this.coldLaunchRealTime.setFirstInstall(z);
        this.externalLinkH5RealTime.setFirstInstall(z);
        this.externalLinkHomeRealTime.setFirstInstall(z);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setFirstLaunch(boolean z) {
        this.coldLaunchRealTime.setFirstLaunch(z);
        this.externalLinkH5RealTime.setFirstLaunch(z);
        this.externalLinkHomeRealTime.setFirstLaunch(z);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setH5ActivityStart() {
        this.externalLinkH5RealTime.setH5ActivityStart();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime, me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setHomeStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setHomeStart(current);
        this.externalLinkH5RealTime.setHomeStart(current);
        this.externalLinkHomeRealTime.setHomeStart(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLaunchType(@Nullable String str) {
        this.coldLaunchRealTime.setLaunchType(str);
        this.externalLinkH5RealTime.setLaunchType(str);
        this.externalLinkHomeRealTime.setLaunchType(str);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLauncherResumeTime() {
        this.coldLaunchRealTime.setLauncherResumeTime();
        this.externalLinkHomeRealTime.setLauncherResumeTime();
        this.externalLinkH5RealTime.setLauncherResumeTime();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setLauncherStartTime() {
        this.coldLaunchRealTime.setLauncherStartTime();
        this.externalLinkHomeRealTime.setLauncherStartTime();
        this.externalLinkH5RealTime.setLauncherStartTime();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setLoadUrlStart(@NonNull String str) {
        this.externalLinkH5RealTime.setLoadUrlStart(str);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMAC(long j) {
        this.coldLaunchRealTime.setMAC(j);
        this.externalLinkH5RealTime.setMAC(j);
        this.externalLinkHomeRealTime.setMAC(j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMAHead(long j) {
        this.coldLaunchRealTime.setMAHead(j);
        this.externalLinkH5RealTime.setMAHead(j);
        this.externalLinkHomeRealTime.setMAHead(j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMATail(long j) {
        this.coldLaunchRealTime.setMATail(j);
        this.externalLinkH5RealTime.setMATail(j);
        this.externalLinkHomeRealTime.setMATail(j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMFront(long j) {
        this.coldLaunchRealTime.setMFront(j);
        this.externalLinkH5RealTime.setMFront(j);
        this.externalLinkHomeRealTime.setMFront(j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setMLaunch(long j) {
        this.coldLaunchRealTime.setMLaunch(j);
        this.externalLinkH5RealTime.setMLaunch(j);
        this.externalLinkHomeRealTime.setMLaunch(j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setPageFinished(@NonNull String str) {
        this.externalLinkH5RealTime.setPageFinished(str);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreAddressEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setPreAddressEnd(current);
        this.externalLinkHomeRealTime.setPreAddressEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreAddressStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setPreAddressStart(current);
        this.externalLinkHomeRealTime.setPreAddressStart(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreRequestEnd() {
        long current = Timing.current();
        this.coldLaunchRealTime.setPreRequestEnd(current);
        this.externalLinkHomeRealTime.setPreRequestEnd(current);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setPreRequestStart() {
        long current = Timing.current();
        this.coldLaunchRealTime.setPreRequestStart(current);
        this.externalLinkHomeRealTime.setPreRequestStart(current);
    }

    public void setProcedure(@NonNull IProcedure iProcedure) {
        this.procedure = iProcedure;
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j) {
        setRenderComplete(0L, j);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setSchemeRouteEndTime() {
        this.externalLinkHomeRealTime.setSchemeRouteEndTime();
        this.externalLinkH5RealTime.setSchemeRouteEndTime();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELUniversalRealTime
    public void setSchemeRouteStartTime() {
        this.externalLinkHomeRealTime.setSchemeRouteStartTime();
        this.externalLinkH5RealTime.setSchemeRouteStartTime();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELRealTime
    public void setT1End(@NonNull String str) {
        this.externalLinkH5RealTime.setT1End(str);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setUseCache(boolean z) {
        this.coldLaunchRealTime.setUseCache(z);
        this.externalLinkHomeRealTime.setUseCache(z);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setUsePresetData(boolean z) {
        this.coldLaunchRealTime.setUsePresetData(z);
        this.externalLinkHomeRealTime.setUsePresetData(z);
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IELHomeUniversalRealTime
    public void setWriteCacheSuccess() {
        this.coldLaunchRealTime.setWriteCacheSuccess();
        this.externalLinkHomeRealTime.setWriteCacheSuccess();
    }

    @Override // me.ele.altriax.launcher.real.time.data.core.IUniversalRealTime
    public void setRenderComplete(long j, long j2) {
        double d = j;
        this.coldLaunchRealTime.setLaunchDuration(d);
        this.externalLinkH5RealTime.setLaunchDuration(d);
        this.externalLinkHomeRealTime.setLaunchDuration(d);
        this.coldLaunchRealTime.setRenderComplete(j2);
        this.externalLinkH5RealTime.setRenderComplete(j2);
        this.externalLinkHomeRealTime.setRenderComplete(j2);
        Handler handler = this.childThreadHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: me.ele.altriax.launcher.real.time.data.AltriaXRealTime.1
                @Override // java.lang.Runnable
                public void run() {
                    AltriaXLaunchTime.v(AltriaXRealTime.TAG, "report delay 3333");
                    AltriaXRealTime.this.dispatchReport();
                }
            }, 3333L);
            return;
        }
        AltriaXLaunchTime.v(TAG, "report just do");
        dispatchReport();
    }
}
