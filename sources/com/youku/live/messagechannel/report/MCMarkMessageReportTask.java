package com.youku.live.messagechannel.report;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.heartbeat.MCHeartbeat;
import com.youku.live.messagechannel.utils.AppFrontBackHelper;
import com.youku.live.messagechannel.utils.MCThreadFactory;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMarkMessageReportTask {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "com.youku.live.messagechannel.report.MCMarkMessageReportTask";
    private final long appId;
    private String appMonitorHeartBeatInterval;
    private final String channelId;
    private String closeAppMonitorHeartBeatReport;
    private long lastReportTime;
    private volatile boolean lastTimeLoopIsOnBackground;
    private ScheduledFuture markMessageReportFuture;
    private ScheduledThreadPoolExecutor mcMarkMessageReportExecutor;
    private volatile boolean paused = false;
    private int reportCount;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class ReportWork implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        ReportWork() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-13125025")) {
                ipChange.ipc$dispatch("-13125025", new Object[]{this});
            } else if (!"1".equals(MCMarkMessageReportTask.this.closeAppMonitorHeartBeatReport) && !MCMarkMessageReportTask.this.paused) {
                if (AppFrontBackHelper.getInstance().isOnBackground()) {
                    if (!MCMarkMessageReportTask.this.lastTimeLoopIsOnBackground) {
                        MCMarkMessageReportTask.this.lastTimeLoopIsOnBackground = true;
                    }
                    i = 0;
                    i2 = 1;
                } else {
                    if (MCMarkMessageReportTask.this.lastTimeLoopIsOnBackground) {
                        MCMarkMessageReportTask.this.lastTimeLoopIsOnBackground = false;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    i2 = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - MCMarkMessageReportTask.this.lastReportTime < (Integer.valueOf(MCMarkMessageReportTask.this.appMonitorHeartBeatInterval).intValue() - 2) * 1000) {
                    MyLog.w(MCMarkMessageReportTask.TAG, "Mark message report abort because of period less than ", Integer.valueOf(Integer.valueOf(MCMarkMessageReportTask.this.appMonitorHeartBeatInterval).intValue()));
                    return;
                }
                MCMarkMessageReportTask.this.lastReportTime = currentTimeMillis;
                MCMarkMessageReportWrap mCMarkMessageReportWrap = new MCMarkMessageReportWrap();
                mCMarkMessageReportWrap.appId = MCMarkMessageReportTask.this.appId;
                mCMarkMessageReportWrap.channelId = MCMarkMessageReportTask.this.channelId;
                mCMarkMessageReportWrap.onlineTime = MCHeartbeat.getDeviceOnlineTimeInChannel(MCMarkMessageReportTask.this.appId, MCMarkMessageReportTask.this.channelId);
                mCMarkMessageReportWrap.eventTime = ServerTimeEstimater.estimateServerTimestamp();
                mCMarkMessageReportWrap.eventSecond = Integer.valueOf(new SimpleDateFormat("ss").format(new Date(mCMarkMessageReportWrap.eventTime))).intValue();
                mCMarkMessageReportWrap.reportPeriod = MCMarkMessageReportTask.access$804(MCMarkMessageReportTask.this);
                mCMarkMessageReportWrap.reportInterval = Integer.valueOf(MCMarkMessageReportTask.this.appMonitorHeartBeatInterval).intValue();
                mCMarkMessageReportWrap.reportSysProbeMode = 1;
                mCMarkMessageReportWrap.onFrontFirstReport = i;
                mCMarkMessageReportWrap.onBackground = i2;
                MCMarkMessage currentSysProbe = MCMarkMessageManager.getInstance().getCurrentSysProbe(MCMarkMessageReportTask.this.appId, MCMarkMessageReportTask.this.channelId);
                if (currentSysProbe != null) {
                    mCMarkMessageReportWrap.probeMessage = currentSysProbe.convert2MCMarkMessageReportData();
                }
                mCMarkMessageReportWrap.markMessages = new ArrayList();
                List<MCMarkMessage> storedMarkMessages = MCMarkMessageManager.getInstance().getStoredMarkMessages(MCMarkMessageReportTask.this.appId, MCMarkMessageReportTask.this.channelId);
                if (storedMarkMessages != null && !storedMarkMessages.isEmpty()) {
                    for (int i3 = 0; i3 < storedMarkMessages.size(); i3++) {
                        MCMarkMessage mCMarkMessage = storedMarkMessages.get(i3);
                        if (mCMarkMessage != null) {
                            mCMarkMessageReportWrap.markMessages.add(mCMarkMessage.convert2MCMarkMessageReportData());
                        }
                    }
                }
                AppMonitor.Alarm.commitSuccess(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "arrivalReport", JSON.toJSONString(mCMarkMessageReportWrap));
            }
        }
    }

    public MCMarkMessageReportTask(long j, String str) {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closeAppMonitorHeartBeatReport;
        this.closeAppMonitorHeartBeatReport = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig orangeConfig2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.appMonitorHeartBeatInterval;
        this.appMonitorHeartBeatInterval = orangeConfig2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        this.reportCount = 0;
        this.lastReportTime = 0L;
        this.lastTimeLoopIsOnBackground = false;
        this.appId = j;
        this.channelId = str;
    }

    static /* synthetic */ int access$804(MCMarkMessageReportTask mCMarkMessageReportTask) {
        int i = mCMarkMessageReportTask.reportCount + 1;
        mCMarkMessageReportTask.reportCount = i;
        return i;
    }

    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1185987833") ? ((Boolean) ipChange.ipc$dispatch("-1185987833", new Object[]{this})).booleanValue() : this.paused;
    }

    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564646393")) {
            ipChange.ipc$dispatch("564646393", new Object[]{this});
        } else {
            this.paused = true;
        }
    }

    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971955502")) {
            ipChange.ipc$dispatch("1971955502", new Object[]{this});
        } else {
            this.paused = false;
        }
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "607751181")) {
            ipChange.ipc$dispatch("607751181", new Object[]{this});
            return;
        }
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new MCThreadFactory("markMessageReport"));
            this.mcMarkMessageReportExecutor = scheduledThreadPoolExecutor;
            this.markMessageReportFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(new ReportWork(), 0L, Integer.valueOf(this.appMonitorHeartBeatInterval).intValue(), TimeUnit.SECONDS);
        } catch (Exception e) {
            MyLog.e(TAG, "Mark message report task start fail.", e);
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075977031")) {
            ipChange.ipc$dispatch("-1075977031", new Object[]{this});
            return;
        }
        ScheduledFuture scheduledFuture = this.markMessageReportFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.markMessageReportFuture = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.mcMarkMessageReportExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        MCMarkMessageManager.getInstance().clearStoredMarkMessages(this.appId, this.channelId);
    }
}
