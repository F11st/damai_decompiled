package com.youku.live.messagechannel.session;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;
import com.youku.live.messagechannel.callback.IMCSessionEventCallback;
import com.youku.live.messagechannel.callback.MCConnectionEvent;
import com.youku.live.messagechannel.callback.MCSessionEvent;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.connection.IMCConnection;
import com.youku.live.messagechannel.connection.MCConnectionState;
import com.youku.live.messagechannel.heartbeat.MCHeartbeat;
import com.youku.live.messagechannel.report.MCMarkMessageReportTask;
import com.youku.live.messagechannel.utils.AppFrontBackHelper;
import com.youku.live.messagechannel.utils.MCThreadFactory;
import com.youku.live.messagechannel.utils.MCThreadPool;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCSession {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = getClass().getName();
    private final long appId;
    private final String channelId;
    private String closeHeartBeatSwitch;
    private List<IMCConnection> connections;
    private String connectionsLaunchTimeout;
    private Context context;
    private MCHeartbeat heartbeat;
    private MCMarkMessageReportTask mcMarkMessageReportTask;
    private ScheduledThreadPoolExecutor selfCheckExecutor;
    private ScheduledFuture selfCheckFuture;
    private IMCSessionEventCallback sessionEventCallback;
    private volatile SessionStatus sessionStatus;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class ConnectionLaunchTask implements Runnable {
        CountDownLatch countDownLatch;
        IMCConnection mcConnection;

        public ConnectionLaunchTask(IMCConnection iMCConnection, CountDownLatch countDownLatch) {
            this.mcConnection = iMCConnection;
            this.countDownLatch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mcConnection.launch(new IMCConnectionEventCallback() { // from class: com.youku.live.messagechannel.session.MCSession.ConnectionLaunchTask.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.messagechannel.callback.IMCConnectionEventCallback
                public void onEvent(MCConnectionEvent mCConnectionEvent, String str, Map<String, Object> map) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1384363574")) {
                        ipChange.ipc$dispatch("1384363574", new Object[]{this, mCConnectionEvent, str, map});
                        return;
                    }
                    MyLog.d(MCSession.this.TAG, "Connection launch, event:", mCConnectionEvent.name(), ", msg:", str, MCSession.this.appIdAndChannelString(), ", connectionFlag:", ConnectionLaunchTask.this.mcConnection.getConnectionFlag());
                    if (MCConnectionEvent.LAUNCH_SUCCESS.equals(mCConnectionEvent)) {
                        ConnectionLaunchTask.this.countDownLatch.countDown();
                    }
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class ConnectionShutdownTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        CountDownLatch countDownLatch;
        IMCConnection mcConnection;

        public ConnectionShutdownTask(IMCConnection iMCConnection, CountDownLatch countDownLatch) {
            this.mcConnection = iMCConnection;
            this.countDownLatch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1558173968")) {
                ipChange.ipc$dispatch("-1558173968", new Object[]{this});
            } else {
                this.mcConnection.shutdown(new IMCConnectionEventCallback() { // from class: com.youku.live.messagechannel.session.MCSession.ConnectionShutdownTask.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.messagechannel.callback.IMCConnectionEventCallback
                    public void onEvent(MCConnectionEvent mCConnectionEvent, String str, Map<String, Object> map) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1048659161")) {
                            ipChange2.ipc$dispatch("1048659161", new Object[]{this, mCConnectionEvent, str, map});
                            return;
                        }
                        MyLog.d(MCSession.this.TAG, "Connection shutdown, event:", mCConnectionEvent.name(), ", msg:", str, MCSession.this.appIdAndChannelString(), ", connectionFlag:", ConnectionShutdownTask.this.mcConnection.getConnectionFlag());
                        if (MCConnectionEvent.SHUTDOWN_SUCCESS.equals(mCConnectionEvent)) {
                            ConnectionShutdownTask.this.countDownLatch.countDown();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class SelfCheck implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        SelfCheck() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-247114713")) {
                ipChange.ipc$dispatch("-247114713", new Object[]{this});
                return;
            }
            MyLog.d(MCSession.this.TAG, "Session selfCheck start", MCSession.this.appIdAndChannelString());
            int i = 0;
            while (true) {
                if (i >= MCSession.this.connections.size()) {
                    z = false;
                    break;
                } else if (((IMCConnection) MCSession.this.connections.get(i)).isHealth()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            boolean isOnBackground = AppFrontBackHelper.getInstance().isOnBackground();
            if (z || !isOnBackground) {
                if (MCSession.this.heartbeat.isPaused()) {
                    MCSession.this.heartbeat.resume();
                    MyLog.w(MCSession.this.TAG, "Connections resume work or on foreground, resume heartbeat", MCSession.this.appIdAndChannelString(), ", connection work:", Boolean.valueOf(z), ", onBackground:", Boolean.valueOf(isOnBackground));
                }
                if (MCSession.this.mcMarkMessageReportTask.isPaused()) {
                    MCSession.this.mcMarkMessageReportTask.resume();
                    MyLog.w(MCSession.this.TAG, "Connections resume work or on foreground, resume mark msg report", MCSession.this.appIdAndChannelString(), ", connection work:", Boolean.valueOf(z), ", onBackground:", Boolean.valueOf(isOnBackground));
                    return;
                }
                return;
            }
            if (!MCSession.this.heartbeat.isPaused()) {
                MCSession.this.heartbeat.pause();
                MyLog.w(MCSession.this.TAG, "Connections stop work on background, pause heartbeat", MCSession.this.appIdAndChannelString());
            }
            if (MCSession.this.mcMarkMessageReportTask.isPaused()) {
                return;
            }
            MCSession.this.mcMarkMessageReportTask.pause();
            MyLog.w(MCSession.this.TAG, "Connections stop work on background, pause mark msg report", MCSession.this.appIdAndChannelString());
        }
    }

    public MCSession(Context context, long j, String str, List<IMCConnection> list, IMCSessionEventCallback iMCSessionEventCallback) {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closeHeartBeat;
        this.closeHeartBeatSwitch = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig orangeConfig2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.connectionsLaunchTimeout;
        this.connectionsLaunchTimeout = orangeConfig2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        this.context = context;
        this.appId = j;
        this.channelId = str;
        this.connections = list;
        this.sessionEventCallback = iMCSessionEventCallback;
        this.heartbeat = new MCHeartbeat(context, j, str);
        this.mcMarkMessageReportTask = new MCMarkMessageReportTask(j, str);
        setSessionStatus(SessionStatus.INIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String appIdAndChannelString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396532721")) {
            return (String) ipChange.ipc$dispatch("-396532721", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(", appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(", channelId:");
        stringBuffer.append(this.channelId);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compensateCloseSession(SessionStatus sessionStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864465035")) {
            ipChange.ipc$dispatch("864465035", new Object[]{this, sessionStatus});
        } else if (SessionStatus.CLOSING == sessionStatus) {
            MyLog.w(this.TAG, "Session compensate close", appIdAndChannelString());
            forceCloseSession();
        }
    }

    private void forceCloseSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139560641")) {
            ipChange.ipc$dispatch("2139560641", new Object[]{this});
            return;
        }
        MyLog.d(this.TAG, "Session begin to force close", appIdAndChannelString(), ", status is ", getSessionStatus());
        ScheduledFuture scheduledFuture = this.selfCheckFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.selfCheckFuture = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.selfCheckExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        this.mcMarkMessageReportTask.stop();
        if (this.heartbeat.isHeartbeating()) {
            this.heartbeat.stop(null);
        }
        MCThreadPool.sessionOperator.execute(new Runnable() { // from class: com.youku.live.messagechannel.session.MCSession.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-919977295")) {
                    ipChange2.ipc$dispatch("-919977295", new Object[]{this});
                    return;
                }
                int size = MCSession.this.connections.size();
                CountDownLatch countDownLatch = new CountDownLatch(size);
                for (int i = 0; i < size; i++) {
                    MCThreadPool.sessionOperator.execute(new ConnectionShutdownTask((IMCConnection) MCSession.this.connections.get(i), countDownLatch));
                }
                try {
                    countDownLatch.await(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    MyLog.e(MCSession.this.TAG, "Close session countDownLatch interruptedException.", e);
                }
                if (countDownLatch.getCount() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < size; i2++) {
                        IMCConnection iMCConnection = (IMCConnection) MCSession.this.connections.get(i2);
                        if (!MCConnectionState.CLOSED.equals(iMCConnection.getConnectionState())) {
                            arrayList.add(iMCConnection.getConnectionFlag().name());
                        }
                    }
                    if (arrayList.size() > 0) {
                        StringBuffer stringBuffer = new StringBuffer("Session close fail, because of connection close fail: ");
                        stringBuffer.append(TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList));
                        String stringBuffer2 = stringBuffer.toString();
                        MyLog.e(MCSession.this.TAG, stringBuffer2, MCSession.this.appIdAndChannelString());
                        if (MCSession.this.sessionEventCallback != null) {
                            MCSession.this.sessionEventCallback.onEvent(MCSessionEvent.CLOSE_FAIL, stringBuffer2);
                        }
                        MCSession.this.setSessionStatus(SessionStatus.CLOSED);
                        return;
                    }
                }
                String str = MCSession.this.TAG;
                MCSessionEvent mCSessionEvent = MCSessionEvent.CLOSE_SUCCESS;
                MyLog.d(str, mCSessionEvent.getMsg(), MCSession.this.appIdAndChannelString());
                if (MCSession.this.sessionEventCallback != null) {
                    MCSession.this.sessionEventCallback.onEvent(mCSessionEvent, mCSessionEvent.getMsg());
                }
                MCSession.this.setSessionStatus(SessionStatus.CLOSED);
            }
        });
    }

    public void closeSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957858270")) {
            ipChange.ipc$dispatch("-1957858270", new Object[]{this});
            return;
        }
        MyLog.d(this.TAG, "Session begin to close", appIdAndChannelString());
        SessionStatus sessionStatus = getSessionStatus();
        setSessionStatus(SessionStatus.CLOSING);
        if (SessionStatus.OPEN == sessionStatus) {
            forceCloseSession();
        } else {
            MyLog.w(this.TAG, "Session skip close because status is ", sessionStatus.name(), appIdAndChannelString());
        }
    }

    public SessionStatus getSessionStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1558997812") ? (SessionStatus) ipChange.ipc$dispatch("1558997812", new Object[]{this}) : this.sessionStatus;
    }

    public void openSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1053910718")) {
            ipChange.ipc$dispatch("1053910718", new Object[]{this});
            return;
        }
        MyLog.d(this.TAG, "Session begin to open", appIdAndChannelString());
        setSessionStatus(SessionStatus.OPENING);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new MCThreadFactory("session-self-check"));
        this.selfCheckExecutor = scheduledThreadPoolExecutor;
        this.selfCheckFuture = scheduledThreadPoolExecutor.scheduleWithFixedDelay(new SelfCheck(), 30L, 30L, TimeUnit.SECONDS);
        if ("0".equals(this.closeHeartBeatSwitch)) {
            this.heartbeat.start(null);
        } else {
            MyLog.w(this.TAG, "Session start heartbeat is ban", appIdAndChannelString());
        }
        this.mcMarkMessageReportTask.start();
        MCThreadPool.sessionOperator.execute(new Runnable() { // from class: com.youku.live.messagechannel.session.MCSession.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-723463790")) {
                    ipChange2.ipc$dispatch("-723463790", new Object[]{this});
                    return;
                }
                int size = MCSession.this.connections.size();
                CountDownLatch countDownLatch = new CountDownLatch(size);
                for (int i = 0; i < size; i++) {
                    MCThreadPool.sessionOperator.execute(new ConnectionLaunchTask((IMCConnection) MCSession.this.connections.get(i), countDownLatch));
                }
                int i2 = 3;
                try {
                    i2 = Integer.valueOf(MCSession.this.connectionsLaunchTimeout).intValue();
                } catch (Exception e) {
                    String str = MCSession.this.TAG;
                    MyLog.e(str, "Open session timeout format error, " + MCSession.this.connectionsLaunchTimeout, e);
                }
                try {
                    countDownLatch.await(i2, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    MyLog.e(MCSession.this.TAG, "Open session countDownLatch interruptedException.", e2);
                }
                SessionStatus sessionStatus = MCSession.this.getSessionStatus();
                if (countDownLatch.getCount() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        IMCConnection iMCConnection = (IMCConnection) MCSession.this.connections.get(i3);
                        if (!MCConnectionState.OPEN.equals(iMCConnection.getConnectionState())) {
                            arrayList.add(iMCConnection.getConnectionFlag().name());
                        }
                    }
                    if (arrayList.size() > 0) {
                        StringBuffer stringBuffer = new StringBuffer("Session open fail, because of connection not open success on time: ");
                        stringBuffer.append(TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList));
                        String stringBuffer2 = stringBuffer.toString();
                        MyLog.e(MCSession.this.TAG, stringBuffer2, MCSession.this.appIdAndChannelString());
                        if (MCSession.this.sessionEventCallback != null) {
                            MCSession.this.sessionEventCallback.onEvent(MCSessionEvent.OPEN_FAIL, stringBuffer2);
                        }
                        MCSession.this.setSessionStatus(SessionStatus.OPEN);
                        MCSession.this.compensateCloseSession(sessionStatus);
                        return;
                    }
                }
                String str2 = MCSession.this.TAG;
                MCSessionEvent mCSessionEvent = MCSessionEvent.OPEN_SUCCESS;
                MyLog.d(str2, mCSessionEvent.getMsg(), MCSession.this.appIdAndChannelString());
                if (MCSession.this.sessionEventCallback != null) {
                    MCSession.this.sessionEventCallback.onEvent(mCSessionEvent, mCSessionEvent.getMsg());
                }
                MCSession.this.setSessionStatus(SessionStatus.OPEN);
                MCSession.this.compensateCloseSession(sessionStatus);
            }
        });
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638387676")) {
            ipChange.ipc$dispatch("638387676", new Object[]{this, sessionStatus});
        } else if (this.sessionStatus != sessionStatus) {
            this.sessionStatus = sessionStatus;
            MyLog.i(this.TAG, "Session status change to ", this.sessionStatus.name(), appIdAndChannelString());
        }
    }
}
