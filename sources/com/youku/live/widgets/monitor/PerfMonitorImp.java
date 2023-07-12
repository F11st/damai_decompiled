package com.youku.live.widgets.monitor;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.request.ImageStatistics;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.log.IRemoteLog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PerfMonitorImp implements ILog, IPerfMonitor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEVICE_SCORE_MIX_2S = 94;
    public static final int DEVICE_SCORE_VIVO_X20A = 86;
    public static final int DEVICE_SCORE_VIVO_Y67 = 68;
    private static volatile int sDeviceScore = Integer.MIN_VALUE;
    private static Queue<PerfMonitorImp> sQueue;
    private int deviceScore;
    private boolean disableTLogDebug;
    private boolean forceContainerThrowable;
    private boolean forceLogLevelToError;
    private String inst;
    private ILog localLog;
    private ILog logger;
    private Map<String, Long> mPointsBegin;
    private Map<String, String> mPointsData;
    private Map<String, Boolean> mPointsDisabled;
    private Map<String, Long> mPointsEnd;
    private ILog remoteLog;
    private boolean supportRemoteLogger;
    private String tag;
    private long timestampBegin;

    private PerfMonitorImp(String str, String str2) {
        this.timestampBegin = 0L;
        this.logger = null;
        boolean z = true;
        this.forceLogLevelToError = true;
        this.supportRemoteLogger = true;
        this.forceContainerThrowable = false;
        this.tag = str;
        this.inst = str2;
        this.timestampBegin = getTimestamp();
        this.logger = (ILog) Dsl.getService(ILog.class);
        this.deviceScore = getCurrentDeviceScore();
        this.disableTLogDebug = (OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("disableTLogDebug", true)) ? false : false;
        this.forceLogLevelToError = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean("live_performance_monitor", "forceLogLevelToError", this.forceLogLevelToError);
        this.supportRemoteLogger = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean("live_performance_monitor", "supportRemoteLogger", this.supportRemoteLogger);
        this.forceContainerThrowable = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getBoolean("live_performance_monitor", "forceContainerThrowable", this.forceContainerThrowable);
        perfConfig(IDynamicConfig.KEY_DEVICE_SCORE, "" + this.deviceScore);
        perfConfig("totalBeginTimestamp", "" + this.timestampBegin);
    }

    private void clearAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902086648")) {
            ipChange.ipc$dispatch("-902086648", new Object[]{this});
            return;
        }
        getPointsBegin().clear();
        getPointsEnd().clear();
        getPointsData().clear();
    }

    public static IPerfMonitor createInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587140804")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("1587140804", new Object[]{str, str2});
        }
        PerfMonitorImp poll = getQueue().poll();
        if (poll != null) {
            poll.initWith(str, str2);
            return poll;
        }
        return new PerfMonitorImp(str, str2);
    }

    public static int getCurrentDeviceScore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266642840")) {
            return ((Integer) ipChange.ipc$dispatch("-266642840", new Object[0])).intValue();
        }
        if (sDeviceScore == Integer.MIN_VALUE) {
            sDeviceScore = getDeviceScoreImpInYouku();
        }
        return sDeviceScore;
    }

    private static int getDeviceScoreImpInYouku() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231682991")) {
            return ((Integer) ipChange.ipc$dispatch("-1231682991", new Object[0])).intValue();
        }
        try {
            Context context = Dsl.getContext();
            if (context != null) {
                return context.getSharedPreferences("device_score", 0).getInt("device_score", -1);
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    private static String getInstHashCode(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "108538573")) {
            return (String) ipChange.ipc$dispatch("108538573", new Object[]{obj});
        }
        return obj.getClass().getSimpleName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(obj.hashCode());
    }

    private ILog getLocalLogger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324557825")) {
            return (ILog) ipChange.ipc$dispatch("324557825", new Object[]{this});
        }
        if (this.localLog == null) {
            synchronized (this) {
                if (this.localLog == null) {
                    this.localLog = (ILog) Dsl.getService(ILog.class);
                }
            }
        }
        return this.localLog;
    }

    private ILog getLogger() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-236777518") ? (ILog) ipChange.ipc$dispatch("-236777518", new Object[]{this}) : this;
    }

    private Map<String, Long> getPointsBegin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150557761")) {
            return (Map) ipChange.ipc$dispatch("1150557761", new Object[]{this});
        }
        if (this.mPointsBegin == null) {
            synchronized (this) {
                if (this.mPointsBegin == null) {
                    this.mPointsBegin = new ConcurrentHashMap();
                }
            }
        }
        return this.mPointsBegin;
    }

    private Map<String, String> getPointsData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376838240")) {
            return (Map) ipChange.ipc$dispatch("-376838240", new Object[]{this});
        }
        if (this.mPointsData == null) {
            synchronized (this) {
                if (this.mPointsData == null) {
                    this.mPointsData = new ConcurrentHashMap();
                }
            }
        }
        return this.mPointsData;
    }

    private Map<String, Boolean> getPointsDisabled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242707186")) {
            return (Map) ipChange.ipc$dispatch("-1242707186", new Object[]{this});
        }
        if (this.mPointsDisabled == null) {
            synchronized (this) {
                if (this.mPointsDisabled == null) {
                    this.mPointsDisabled = new ConcurrentHashMap();
                }
            }
        }
        return this.mPointsDisabled;
    }

    private Map<String, Long> getPointsEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924741711")) {
            return (Map) ipChange.ipc$dispatch("924741711", new Object[]{this});
        }
        if (this.mPointsEnd == null) {
            synchronized (this) {
                if (this.mPointsEnd == null) {
                    this.mPointsEnd = new ConcurrentHashMap();
                }
            }
        }
        return this.mPointsEnd;
    }

    private static Queue<PerfMonitorImp> getQueue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033252095")) {
            return (Queue) ipChange.ipc$dispatch("-2033252095", new Object[0]);
        }
        if (sQueue == null) {
            synchronized (PerfMonitorImp.class) {
                if (sQueue == null) {
                    sQueue = new ConcurrentLinkedQueue();
                }
            }
        }
        return sQueue;
    }

    private ILog getRemoteLogger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584942316")) {
            return (ILog) ipChange.ipc$dispatch("1584942316", new Object[]{this});
        }
        if (this.remoteLog == null) {
            synchronized (this) {
                if (this.remoteLog == null) {
                    this.remoteLog = (ILog) Dsl.getService(IRemoteLog.class);
                }
            }
        }
        return this.remoteLog;
    }

    private static long getTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "709890736") ? ((Long) ipChange.ipc$dispatch("709890736", new Object[0])).longValue() : System.currentTimeMillis();
    }

    private void initWith(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088034054")) {
            ipChange.ipc$dispatch("-2088034054", new Object[]{this, str, str2});
            return;
        }
        this.tag = str;
        this.inst = str2;
        this.timestampBegin = getTimestamp();
        perfConfig("totalBeginTimestamp", "" + this.timestampBegin);
    }

    private String mapToTable(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44665312")) {
            return (String) ipChange.ipc$dispatch("-44665312", new Object[]{this, map});
        }
        String str = StringUtils.LF;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getKey().endsWith("TotalTime")) {
                str = str + entry.getKey() + "\t" + entry.getValue() + StringUtils.LF;
            }
        }
        String str2 = str + StringUtils.LF;
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (entry2.getKey().endsWith("TotalTime")) {
                str2 = str2 + entry2.getKey() + "\t" + entry2.getValue() + StringUtils.LF;
            }
        }
        return str2 + StringUtils.LF;
    }

    private IPerfMonitor perfCommitSuccess(String str) throws JSONException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498956314")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("1498956314", new Object[]{this, str});
        }
        if (this.timestampBegin == 0) {
            return this;
        }
        Map<String, String> pointsData = getPointsData();
        IUserTracker iUserTracker = (IUserTracker) Dsl.getService(IUserTracker.class);
        if (iUserTracker != null) {
            iUserTracker.trackCustom("page_youkulive", 19999, "youkulive_start_process", "", "", pointsData);
        }
        return this;
    }

    private static void releaseInstance(PerfMonitorImp perfMonitorImp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000083376")) {
            ipChange.ipc$dispatch("-2000083376", new Object[]{perfMonitorImp});
        } else if (perfMonitorImp != null) {
            perfMonitorImp.clearAll();
            getQueue().add(perfMonitorImp);
        }
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor begin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766961526")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-1766961526", new Object[]{this});
        }
        this.timestampBegin = getTimestamp();
        return this;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113469236")) {
            ipChange.ipc$dispatch("113469236", new Object[]{this});
        } else {
            releaseInstance(this);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1974522307")) {
            ipChange.ipc$dispatch("-1974522307", new Object[]{this, str, str2});
            return;
        }
        Throwable th = this.forceContainerThrowable ? new Throwable() : null;
        if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
            return;
        }
        if (this.supportRemoteLogger) {
            getRemoteLogger().e(str, str2, th);
        }
        getLocalLogger().e(str, str2, th);
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public int getDeviceScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-435194647") ? ((Integer) ipChange.ipc$dispatch("-435194647", new Object[]{this})).intValue() : this.deviceScore;
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423169607")) {
            ipChange.ipc$dispatch("-423169607", new Object[]{this, str, str2});
            return;
        }
        Throwable th = this.forceContainerThrowable ? new Throwable() : null;
        if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
            return;
        }
        if (this.supportRemoteLogger) {
            getRemoteLogger().i(str, str2, th);
        }
        getLocalLogger().i(str, str2, th);
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfBegin(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990554309")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-990554309", new Object[]{this, Long.valueOf(j)});
        }
        this.timestampBegin = j;
        perfConfig("totalBeginTimestamp", "" + this.timestampBegin);
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfCommitFailure() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-580743255") ? (IPerfMonitor) ipChange.ipc$dispatch("-580743255", new Object[]{this}) : this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfConfig(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758894550")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-758894550", new Object[]{this, str, str2});
        }
        getPointsData().put(str, str2);
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfEnable(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1450859681")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-1450859681", new Object[]{this, str, Boolean.valueOf(z)});
        }
        if (z) {
            getPointsDisabled().remove(str);
        } else {
            getPointsDisabled().put(str, Boolean.FALSE);
        }
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfPointBegin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155650487")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-1155650487", new Object[]{this, str});
        }
        if (this.timestampBegin == 0 || getPointsDisabled().containsKey(str)) {
            return this;
        }
        getPointsBegin().put(str, Long.valueOf(getTimestamp()));
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfPointEnd(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970670047")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-970670047", new Object[]{this, str, str2});
        }
        if (this.timestampBegin == 0 || getPointsDisabled().containsKey(str)) {
            return this;
        }
        long timestamp = getTimestamp();
        Long l = getPointsBegin().get(str);
        if (l != null) {
            getPointsData().put(str, String.valueOf(timestamp - l.longValue()));
        }
        getPointsData().put("pointName", str);
        getPointsData().put("currentTimestmap", String.valueOf(timestamp));
        if (this.timestampBegin != 0) {
            Map<String, String> pointsData = getPointsData();
            pointsData.put(str + "TotalTime", String.valueOf(timestamp - this.timestampBegin));
            getPointsData().put(ImageStatistics.KEY_TOTAL_TIME, String.valueOf(timestamp - this.timestampBegin));
        }
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor point(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-733269289")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-733269289", new Object[]{this, str, str2});
        }
        if (!this.disableTLogDebug) {
            long timestamp = getTimestamp() - this.timestampBegin;
            ILog logger = getLogger();
            String str3 = this.tag;
            logger.i(str3, this.inst + "::" + str + "::" + timestamp + "::" + str2);
        }
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor pointError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862782013")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("1862782013", new Object[]{this, str, str2});
        }
        long timestamp = getTimestamp() - this.timestampBegin;
        ILog logger = getLogger();
        String str3 = this.tag;
        logger.e(str3, this.inst + "::" + str + "::" + timestamp + "::" + str2);
        return this;
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor pointWarn(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870178319")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-870178319", new Object[]{this, str, str2});
        }
        long timestamp = getTimestamp() - this.timestampBegin;
        ILog logger = getLogger();
        String str3 = this.tag;
        logger.w(str3, this.inst + "::" + str + "::" + timestamp + "::" + str2);
        return this;
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435886101")) {
            ipChange.ipc$dispatch("-1435886101", new Object[]{this, str, str2});
            return;
        }
        Throwable th = this.forceContainerThrowable ? new Throwable() : null;
        if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
            return;
        }
        if (this.supportRemoteLogger) {
            getRemoteLogger().w(str, str2, th);
        }
        getLocalLogger().w(str, str2, th);
    }

    public static IPerfMonitor createInstance(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30755798")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("30755798", new Object[]{str, obj});
        }
        PerfMonitorImp poll = getQueue().poll();
        if (poll != null) {
            poll.initWith(str, obj);
            return poll;
        }
        return new PerfMonitorImp(str, obj);
    }

    private void initWith(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906618636")) {
            ipChange.ipc$dispatch("906618636", new Object[]{this, str, obj});
        } else {
            initWith(str, getInstHashCode(obj));
        }
    }

    @Override // com.youku.live.widgets.monitor.IPerfMonitor
    public IPerfMonitor perfCommitSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731233264")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-731233264", new Object[]{this});
        }
        if (this.timestampBegin == 0) {
            return this;
        }
        Map<String, String> pointsData = getPointsData();
        IUserTracker iUserTracker = (IUserTracker) Dsl.getService(IUserTracker.class);
        if (iUserTracker != null) {
            iUserTracker.trackCustom("page_youkulive", 19999, "youkulive_start_process", "", "", pointsData);
        }
        return this;
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995374040")) {
            ipChange.ipc$dispatch("1995374040", new Object[]{this, str, str2, th});
        } else if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
        } else {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623556060")) {
            ipChange.ipc$dispatch("1623556060", new Object[]{this, str, str2, th});
        } else if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
        } else {
            if (this.supportRemoteLogger) {
                getRemoteLogger().i(str, str2, th);
            }
            getLocalLogger().i(str, str2, th);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825290518")) {
            ipChange.ipc$dispatch("-1825290518", new Object[]{this, str, str2, th});
        } else if (this.forceLogLevelToError) {
            if (this.supportRemoteLogger) {
                getRemoteLogger().e(str, str2, th);
            }
            getLocalLogger().e(str, str2, th);
        } else {
            if (this.supportRemoteLogger) {
                getRemoteLogger().w(str, str2, th);
            }
            getLocalLogger().w(str, str2, th);
        }
    }

    private PerfMonitorImp(String str, Object obj) {
        this(str, getInstHashCode(obj));
    }
}
