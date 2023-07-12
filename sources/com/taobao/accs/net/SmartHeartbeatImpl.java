package com.taobao.accs.net;

import android.os.SystemClock;
import anet.channel.C0162c;
import anet.channel.Session;
import anet.channel.heartbeat.IHeartbeat;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.mass.MassClient;
import com.taobao.mass.ServiceKey;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SmartHeartbeatImpl implements IHeartbeat, Runnable {
    public static final int BACKGROUND_INTERVAL = 270000;
    public static final int FOREGROUND_INTERVAL = 45000;
    private static final String TAG = SmartHeartbeatImpl.class.getSimpleName();
    private Future future;
    private InAppConnection inAppConnection;
    private long interval;
    private Session session;
    private volatile int state;
    private long lastRescheduleTimeMill = 0;
    private boolean isForeSendState = false;

    public SmartHeartbeatImpl(InAppConnection inAppConnection, int i) {
        this.inAppConnection = inAppConnection;
        this.state = i;
    }

    private void setInterval() {
        if (this.state == 0) {
            this.interval = OrangeAdapter.getBackInterval(GlobalClientInfo.getContext());
        } else {
            this.interval = OrangeAdapter.getForeInterval(GlobalClientInfo.getContext());
        }
    }

    private synchronized void submit(long j) {
        try {
            String str = TAG;
            ALog.e(str, "submit ping current delay: " + (j / 1000) + "s", new Object[0]);
            Future future = this.future;
            if (future != null) {
                future.cancel(false);
                this.future = null;
            }
            this.future = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(this, j + 50, TimeUnit.MILLISECONDS);
            this.lastRescheduleTimeMill = SystemClock.elapsedRealtime();
        } catch (Exception e) {
            ALog.e(TAG, "Submit heartbeat task failed.", this.session.r, e);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        ALog.e(TAG, "reSchedule ", new Object[0]);
        if (OrangeAdapter.normalChangesEnabled() || this.interval == 0) {
            setInterval();
        }
        submit(this.interval);
        HeartbeatManager.getInstance(GlobalClientInfo.getContext()).set();
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.e(TAG, "ping ", new Object[0]);
        if (this.lastRescheduleTimeMill > 0 && this.interval == 45000) {
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_HB_DELAY, "", (int) ((SystemClock.elapsedRealtime() - this.lastRescheduleTimeMill) / 1000));
        }
        try {
            Session session = AccsSessionCenter.get(C0162c.m(this.inAppConnection.getAppkey()), this.inAppConnection.getHost(null), 0L);
            this.session = session;
            if (session != null) {
                session.t(true);
                InAppConnection.lastPingTimeMill = SystemClock.elapsedRealtime();
            }
        } catch (Exception e) {
            ALog.e(TAG, "get session null", e, new Object[0]);
        }
        String str = TAG;
        ALog.e(str, "logBackState", "state", Integer.valueOf(this.state), "sendBackState", Boolean.valueOf(this.inAppConnection.getSendBackState()));
        if (this.state == 0 && !this.inAppConnection.getSendBackState()) {
            this.inAppConnection.setSendBackState(true);
            InAppConnection inAppConnection = this.inAppConnection;
            inAppConnection.sendMessage(Message.buildBackground(inAppConnection.getHost(null)), true);
            if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                ALog.i(str, "send mass background state frame", new Object[0]);
                InAppConnection inAppConnection2 = this.inAppConnection;
                inAppConnection2.sendMessage(Message.buildMassMessage(inAppConnection2.getAppkey(), "back", ServiceKey.POWER_MSG, this.inAppConnection.getHost(null), this.inAppConnection.mConfigTag, GlobalClientInfo.getContext()), true);
            }
            ALog.i(str, "send background state frame", new Object[0]);
        }
        if (OrangeAdapter.isSendForeStateInHeartbeat() && this.state == 1 && !this.isForeSendState) {
            ALog.i(str, "resend fore state", new Object[0]);
            InAppConnection inAppConnection3 = this.inAppConnection;
            inAppConnection3.sendMessage(Message.buildForeground(inAppConnection3.getHost(null)), true);
            this.isForeSendState = true;
        }
        if (this.state == 0 && this.inAppConnection.getSendBackState()) {
            this.interval = OrangeAdapter.getBackInterval(GlobalClientInfo.getContext());
        }
        reSchedule();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(int i) {
        if (this.state != i) {
            String str = TAG;
            ALog.e(str, "reset state, last state: " + this.state + " current state: " + i, new Object[0]);
            this.state = i;
            this.isForeSendState = false;
            if (this.state == 1) {
                setInterval();
                reSchedule();
            }
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        HeartbeatManager.getInstance(GlobalClientInfo.getContext()).set();
        this.session = session;
        setInterval();
        ALog.i(TAG, "heartbeat start", session.r, Preloader.KEY_SESSION, session, Constants.Name.INTERVAL, Long.valueOf(this.interval));
        submit(this.interval);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Future future;
        String str = TAG;
        Session session = this.session;
        ALog.i(str, "heartbeat stop", session.r, Preloader.KEY_SESSION, session);
        if (this.session == null || (future = this.future) == null) {
            return;
        }
        future.cancel(true);
    }
}
