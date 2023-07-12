package anet.channel.heartbeat;

import anet.channel.Session;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SelfKillHeartbeatImpl implements IHeartbeat, Runnable {
    private Session session = null;
    private volatile boolean isCancelled = false;
    private volatile long expectSelfKillTime = System.currentTimeMillis();

    @Override // anet.channel.heartbeat.IHeartbeat
    public void reSchedule() {
        this.expectSelfKillTime = System.currentTimeMillis() + 45000;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCancelled) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.expectSelfKillTime - 1000) {
            ThreadPoolExecutorFactory.j(this, this.expectSelfKillTime - currentTimeMillis, TimeUnit.MILLISECONDS);
        } else {
            this.session.c(false);
        }
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void start(Session session) {
        Objects.requireNonNull(session, "session is null");
        this.session = session;
        this.expectSelfKillTime = System.currentTimeMillis() + 45000;
        ThreadPoolExecutorFactory.j(this, 45000L, TimeUnit.MILLISECONDS);
    }

    @Override // anet.channel.heartbeat.IHeartbeat
    public void stop() {
        this.isCancelled = true;
    }
}
