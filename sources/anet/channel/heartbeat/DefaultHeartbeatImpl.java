package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import tb.hu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class DefaultHeartbeatImpl implements IHeartbeat, Runnable {
    private static final String TAG = "awcn.DefaultHeartbeatImpl";
    private Session session;
    private volatile long executeTime = 0;
    private volatile boolean isCancelled = false;
    private long interval = 0;

    private void submit(long j) {
        try {
            this.executeTime = System.currentTimeMillis() + j;
            ThreadPoolExecutorFactory.j(this, j + 50, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ALog.d(TAG, "Submit heartbeat task failed.", this.session.r, e, new Object[0]);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.executeTime = System.currentTimeMillis() + this.interval;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCancelled) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.executeTime - 1000) {
            submit(this.executeTime - currentTimeMillis);
        } else if (!hu0.i()) {
            if (ALog.g(1)) {
                Session session = this.session;
                ALog.c(TAG, "heartbeat", session.r, Preloader.KEY_SESSION, session);
            }
            this.session.t(true);
            submit(this.interval);
        } else {
            Session session2 = this.session;
            ALog.e(TAG, "close session in background", session2.r, Preloader.KEY_SESSION, session2);
            this.session.c(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        this.session = session;
        long heartbeat = session.f().getHeartbeat();
        this.interval = heartbeat;
        if (heartbeat <= 0) {
            this.interval = 45000L;
        }
        ALog.f(TAG, "heartbeat start", session.r, Preloader.KEY_SESSION, session, Constants.Name.INTERVAL, Long.valueOf(this.interval));
        submit(this.interval);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        Session session = this.session;
        if (session == null) {
            return;
        }
        ALog.f(TAG, "heartbeat stop", session.r, Preloader.KEY_SESSION, session);
        this.isCancelled = true;
    }
}
