package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.session.HttpSession;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.SessionConnStat;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.C9708t9;
import tb.ab2;
import tb.em;
import tb.g4;
import tb.hu0;
import tb.jg1;
import tb.lw2;
import tb.sf0;
import tb.x6;
import tb.xa2;
import tb.ya2;
import tb.ym;
import tb.zh2;
import tb.zm;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SessionRequest {
    private String a;
    private String b;
    private C0162c c;
    private C0165d d;
    private xa2 e;
    volatile Session f;
    private volatile Future g;
    private boolean l;
    volatile SessionComplexTask m;
    volatile Future n;
    volatile Session o;
    volatile boolean h = false;
    private HashMap<SessionGetCallback, SessionGetWaitTimeoutTask> i = new HashMap<>();
    SessionConnStat j = null;
    private Object k = new Object();
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean q = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ConnCb implements IConnCb {
        private Context a;
        private List<zm> b;
        private zm c;
        boolean d = false;

        ConnCb(Context context, List<zm> list, zm zmVar) {
            this.a = context;
            this.b = list;
            this.c = zmVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(final Session session, long j, int i) {
            boolean i2 = hu0.i();
            ALog.c("awcn.SessionRequest", "Connect Disconnect", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y(), "appIsBg", Boolean.valueOf(i2), "isHandleFinish", Boolean.valueOf(this.d));
            SessionRequest.this.d.h(SessionRequest.this, session);
            if (this.d) {
                return;
            }
            this.d = true;
            if (session.v) {
                if (i2 && (SessionRequest.this.e == null || !SessionRequest.this.e.c || C9708t9.i())) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.c.h(), Preloader.KEY_SESSION, session);
                } else if (NetworkStatusHelper.n()) {
                    try {
                        if (SessionRequest.this.d.f(SessionRequest.this, ab2.a) == null) {
                            int i3 = 10000;
                            if (SessionRequest.this.e != null && SessionRequest.this.e.c) {
                                i3 = C9708t9.a();
                            }
                            ALog.e("awcn.SessionRequest", "session disconnected, try to recreate session.", this.c.h(), "delay period ", Integer.valueOf(i3));
                            ThreadPoolExecutorFactory.j(new Runnable() { // from class: anet.channel.SessionRequest.ConnCb.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ConnCb connCb = ConnCb.this;
                                        SessionRequest.this.F(connCb.a, session.g().e(), ya2.a(SessionRequest.this.c.b), null, 0L);
                                    } catch (Exception unused) {
                                    }
                                }
                            }, (long) (Math.random() * i3), TimeUnit.MILLISECONDS);
                            return;
                        }
                        ALog.e("awcn.SessionRequest", "[onDisConnect]already have other session.", this.c.h(), new Object[0]);
                    } catch (Exception unused) {
                    }
                } else {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.c.h(), Preloader.KEY_SESSION, session);
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j, int i, int i2) {
            if (ALog.g(1)) {
                ALog.c("awcn.SessionRequest", "Connect failed", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y(), "isHandleFinish", Boolean.valueOf(this.d));
            }
            if (SessionRequest.this.h) {
                SessionRequest.this.h = false;
            } else if (!this.d) {
                this.d = true;
                if (SessionRequest.this.q.get()) {
                    SessionRequest.this.d.h(SessionRequest.this, session);
                    if (!session.w || !NetworkStatusHelper.n() || this.b.isEmpty()) {
                        SessionRequest.this.u();
                        SessionRequest.this.q(session, i, i2);
                        synchronized (SessionRequest.this.i) {
                            for (Map.Entry entry : SessionRequest.this.i.entrySet()) {
                                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = (SessionGetWaitTimeoutTask) entry.getValue();
                                if (sessionGetWaitTimeoutTask.isFinish.compareAndSet(false, true)) {
                                    ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask);
                                    ((SessionGetCallback) entry.getKey()).onSessionGetFail();
                                }
                            }
                            SessionRequest.this.i.clear();
                        }
                        return;
                    }
                    if (ALog.g(1)) {
                        ALog.c("awcn.SessionRequest", "use next connInfo to create session", this.c.h(), "host", SessionRequest.this.y());
                    }
                    zm zmVar = this.c;
                    if (zmVar.d == zmVar.e && (i2 == -2003 || i2 == -2410)) {
                        ListIterator<zm> listIterator = this.b.listIterator();
                        while (listIterator.hasNext()) {
                            if (session.i().equals(listIterator.next().a.getIp())) {
                                listIterator.remove();
                            }
                        }
                    }
                    if (lw2.d(session.i())) {
                        ListIterator<zm> listIterator2 = this.b.listIterator();
                        while (listIterator2.hasNext()) {
                            if (lw2.d(listIterator2.next().a.getIp())) {
                                listIterator2.remove();
                            }
                        }
                        if (SessionRequest.this.n != null) {
                            if (!SessionRequest.this.n.isDone()) {
                                ALog.c("awcn.SessionRequest", "it already failed , so start complex task!", session.r, new Object[0]);
                                SessionRequest.this.n.cancel(false);
                                ThreadPoolExecutorFactory.g(SessionRequest.this.m, ThreadPoolExecutorFactory.C0235b.b);
                                return;
                            }
                            ALog.c("awcn.SessionRequest", "we already start complex!", session.r, new Object[0]);
                            return;
                        }
                        List<zm> list = this.b;
                        if ((list == null || list.isEmpty()) && Inet64Util.n() == 3) {
                            this.b = SessionRequest.this.w(C0213a.a().getIpv4ConnStrategyListByHost(session.k(), SessionRequest.this.y().startsWith("https"), SessionRequest.this.x()), session.r);
                            ALog.e("awcn.SessionRequest", "ipv6 failed will retry with local dns ipv4 " + this.b.toString(), session.r, new Object[0]);
                        }
                    }
                    if (this.c.a().h() && hu0.i()) {
                        ListIterator<zm> listIterator3 = this.b.listIterator();
                        while (listIterator3.hasNext()) {
                            if (listIterator3.next().a().h()) {
                                listIterator3.remove();
                            }
                        }
                    }
                    if (this.b.isEmpty()) {
                        SessionRequest.this.u();
                        SessionRequest.this.q(session, i, i2);
                        synchronized (SessionRequest.this.i) {
                            for (Map.Entry entry2 : SessionRequest.this.i.entrySet()) {
                                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = (SessionGetWaitTimeoutTask) entry2.getValue();
                                if (sessionGetWaitTimeoutTask2.isFinish.compareAndSet(false, true)) {
                                    ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask2);
                                    ((SessionGetCallback) entry2.getKey()).onSessionGetFail();
                                }
                            }
                            SessionRequest.this.i.clear();
                        }
                        return;
                    }
                    zm remove = this.b.remove(0);
                    if (session.z) {
                        SessionRequest sessionRequest = SessionRequest.this;
                        Context context = this.a;
                        sessionRequest.s(context, remove, new ConnCb(context, this.b, remove), remove.h());
                        return;
                    }
                    SessionRequest sessionRequest2 = SessionRequest.this;
                    Context context2 = this.a;
                    sessionRequest2.t(context2, remove, new ConnCb(context2, this.b, remove), remove.h());
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j) {
            ALog.c("awcn.SessionRequest", "Connect Success", this.c.h(), Preloader.KEY_SESSION, session, "host", SessionRequest.this.y());
            try {
                try {
                } catch (Exception e) {
                    ALog.d("awcn.SessionRequest", "[onSuccess]:", this.c.h(), e, new Object[0]);
                }
                if (SessionRequest.this.h) {
                    SessionRequest.this.h = false;
                    session.c(false);
                    return;
                }
                if (C9708t9.p() && ((!SessionRequest.this.p.compareAndSet(false, true) || !SessionRequest.this.q.get()) && !session.A)) {
                    ALog.e("awcn.SessionRequest", "session connect already finish", session.r, new Object[0]);
                    session.c(false);
                }
                ALog.e("awcn.SessionRequest", "session connect Success", session.r, new Object[0]);
                SessionRequest.this.d.a(SessionRequest.this, session);
                SessionRequest.this.r(session);
                synchronized (SessionRequest.this.i) {
                    for (Map.Entry entry : SessionRequest.this.i.entrySet()) {
                        SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = (SessionGetWaitTimeoutTask) entry.getValue();
                        if (sessionGetWaitTimeoutTask.isFinish.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.a(sessionGetWaitTimeoutTask);
                            ((SessionGetCallback) entry.getKey()).onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.i.clear();
                }
                if (session.z) {
                    if (SessionRequest.this.f != null && !SessionRequest.this.f.q()) {
                        SessionRequest.this.f.s.isReported = false;
                        SessionRequest.this.f.c(false);
                        ALog.e("awcn.SessionRequest", "Complex session is success, cancel connectingSession !", null, "host", SessionRequest.this.b);
                    }
                } else if (SessionRequest.this.n != null && !SessionRequest.this.n.isDone()) {
                    SessionRequest.this.n.cancel(true);
                    SessionRequest.this.n = null;
                    ALog.e("awcn.SessionRequest", " session is success, remove complex task !", null, "host", SessionRequest.this.b);
                } else if (SessionRequest.this.o != null && !SessionRequest.this.o.q()) {
                    SessionRequest.this.o.s.isReported = false;
                    SessionRequest.this.o.c(false);
                    ALog.e("awcn.SessionRequest", " session is success, cancel complex session !", SessionRequest.this.o.r, "host", SessionRequest.this.b);
                }
            } finally {
                SessionRequest.this.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ConnectTimeoutTask implements Runnable {
        String seq;

        ConnectTimeoutTask(String str) {
            this.seq = null;
            this.seq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.q.get()) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.seq, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.j;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.j.start;
                if (SessionRequest.this.f != null) {
                    SessionRequest.this.f.w = false;
                    SessionRequest.this.f.b();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.j.syncValueFromSession(sessionRequest.f);
                }
                if (SessionRequest.this.o != null) {
                    SessionRequest.this.o.w = false;
                    SessionRequest.this.o.b();
                }
                x6.b().commitStat(SessionRequest.this.j);
                SessionRequest.this.E(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface IConnCb {
        void onDisConnect(Session session, long j, int i);

        void onFailed(Session session, long j, int i, int i2);

        void onSuccess(Session session, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class SessionComplexTask implements Runnable {
        private List<zm> connInfoList;
        private Context context;
        private SessionRequest sessionRequest;
        private int sessionType;

        public SessionComplexTask(Context context, SessionRequest sessionRequest, int i, List<zm> list) {
            this.connInfoList = new ArrayList();
            this.context = context;
            this.sessionRequest = sessionRequest;
            this.sessionType = i;
            this.connInfoList = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.d.f(this.sessionRequest, this.sessionType) != null) {
                ALog.e("awcn.SessionRequest", "SessionComplexTask cancel,  already connect successfully", null, "host", SessionRequest.this.b);
                return;
            }
            List<zm> list = this.connInfoList;
            if (list == null || list.size() <= 0) {
                ALog.e("awcn.SessionRequest", "SessionComplexTask cancel,  conn list is null", null, "host", SessionRequest.this.b);
                return;
            }
            zm remove = this.connInfoList.remove(0);
            ALog.e("awcn.SessionRequest", "SessionComplexTask run :" + remove.toString(), remove.h(), "host", SessionRequest.this.b);
            SessionRequest sessionRequest = SessionRequest.this;
            Context context = this.context;
            sessionRequest.s(context, remove, new ConnCb(context, this.connInfoList, remove), remove.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class SessionGetWaitTimeoutTask implements Runnable {
        SessionGetCallback cb;
        AtomicBoolean isFinish = new AtomicBoolean(false);

        protected SessionGetWaitTimeoutTask(SessionGetCallback sessionGetCallback) {
            this.cb = null;
            this.cb = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isFinish.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.i) {
                    SessionRequest.this.i.remove(this.cb);
                }
                this.cb.onSessionGetFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$a */
    /* loaded from: classes.dex */
    public class C0155a implements EventCb {
        final /* synthetic */ IConnCb a;
        final /* synthetic */ long b;

        C0155a(IConnCb iConnCb, long j) {
            this.a = iConnCb;
            this.b = j;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, sf0 sf0Var) {
            if (session == null) {
                return;
            }
            int i2 = sf0Var == null ? 0 : sf0Var.a;
            String str = sf0Var == null ? "" : sf0Var.b;
            if (i != 2) {
                if (i == 256) {
                    ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", sf0Var);
                    this.a.onFailed(session, this.b, i, i2);
                    return;
                } else if (i != 512) {
                    return;
                } else {
                    ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", sf0Var);
                    SessionRequest.this.B(session, 0, null);
                    this.a.onSuccess(session, this.b);
                    return;
                }
            }
            ALog.c("awcn.SessionRequest", null, session.r, "Session", session, "EventType", Integer.valueOf(i), "Event", sf0Var);
            if (SessionRequest.this.d.b(SessionRequest.this, session)) {
                this.a.onDisConnect(session, this.b, i);
            } else {
                this.a.onFailed(session, this.b, i, i2);
            }
            if (SessionRequest.this.e == null || !SessionRequest.this.e.c || SessionRequest.this.d.e(SessionRequest.this.c.p(zh2.e("https", jg1.SCHEME_SLASH, SessionRequest.this.e.a))) != null) {
                if (SessionRequest.this.e == null || !SessionRequest.this.e.c) {
                    return;
                }
                ALog.e("awcn.SessionRequest", "sessionPool has accs session, will not send msg to accs!", session.r, new Object[0]);
                return;
            }
            SessionRequest.this.B(session, i2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$b */
    /* loaded from: classes.dex */
    public class C0156b implements EventCb {
        final /* synthetic */ Session a;

        C0156b(Session session) {
            this.a = session;
        }

        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, sf0 sf0Var) {
            ALog.c("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i));
            ym ymVar = new ym();
            if (i == 512) {
                ymVar.a = true;
            }
            if (SessionRequest.this.e != null) {
                ymVar.b = SessionRequest.this.e.c;
            }
            if (!session.s.isReported) {
                ALog.e("awcn.SessionRequest", "isReported is false!,we will not report to StrategyCenter", this.a.r, new Object[0]);
            } else {
                C0213a.a().notifyConnEvent(this.a.k(), this.a.f(), ymVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$c */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0157c implements ServiceConnection {
        final /* synthetic */ Intent a;
        final /* synthetic */ Context b;

        ServiceConnectionC0157c(SessionRequest sessionRequest, Intent intent, Context context) {
            this.a = intent;
            this.b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.c("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
            try {
                try {
                    Messenger messenger = new Messenger(iBinder);
                    Message message = new Message();
                    message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.a);
                    messenger.send(message);
                } catch (Exception e) {
                    ALog.d("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e, new Object[0]);
                }
            } finally {
                this.b.unbindService(this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALog.c("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
            this.b.unbindService(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionRequest(String str, C0162c c0162c) {
        this.a = str;
        String substring = str.substring(str.indexOf(jg1.SCHEME_SLASH) + 3);
        this.b = substring;
        this.c = c0162c;
        this.e = c0162c.f.b(substring);
        this.d = c0162c.d;
    }

    private void A(Session session, IConnCb iConnCb, long j, String str) {
        if (iConnCb == null) {
            return;
        }
        session.v(4095, new C0155a(iConnCb, j));
        session.v(1792, new C0156b(session));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Session session, int i, String str) {
        if (C9708t9.L()) {
            D(session, i, str);
        }
        C(session, i, str);
    }

    private void C(Session session, int i, String str) {
        xa2 xa2Var = this.e;
        if (xa2Var == null || !xa2Var.c) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
        intent.putExtra("command", 103);
        intent.putExtra("host", session.h());
        intent.putExtra(Constants.KEY_CENTER_HOST, true);
        boolean q = session.q();
        if (!q) {
            intent.putExtra("errorCode", i);
            intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
        }
        intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, q);
        intent.putExtra(Constants.KEY_TYPE_INAPP, true);
        this.c.g.f(intent);
    }

    private void D(Session session, int i, String str) {
        xa2 xa2Var;
        Context c = hu0.c();
        if (c == null || (xa2Var = this.e) == null || !xa2Var.c) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent(Constants.ACTION_RECEIVE);
            intent.setPackage(c.getPackageName());
            intent.setClassName(c, AdapterUtilityImpl.msgService);
            intent.putExtra("command", 103);
            intent.putExtra("host", session.h());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean q = session.q();
            if (!q) {
                intent.putExtra("errorCode", i);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, q);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            if (Build.VERSION.SDK_INT >= 26) {
                c.bindService(intent, new ServiceConnectionC0157c(this, intent, c), 1);
            } else {
                c.startService(intent);
            }
        } catch (Throwable th) {
            ALog.d("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Session session, int i, int i2) {
        if (256 != i || i2 == -2613 || i2 == -2601) {
            return;
        }
        g4 g4Var = new g4();
        g4Var.e = "networkPrefer";
        g4Var.f = "policy";
        g4Var.b = this.a;
        g4Var.c = String.valueOf(i2);
        g4Var.a = false;
        x6.b().commitAlarm(g4Var);
        SessionConnStat sessionConnStat = this.j;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i2);
        this.j.errorCode = String.valueOf(i2);
        this.j.totalTime = System.currentTimeMillis() - this.j.start;
        this.j.syncValueFromSession(session);
        SessionConnStat sessionConnStat2 = this.j;
        SessionStatistic sessionStatistic = session.s;
        sessionConnStat2.isComplex = sessionStatistic.isComplex;
        if (!sessionStatistic.isReported) {
            sessionConnStat2.ret = 2;
        }
        x6.b().commitStat(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Session session) {
        g4 g4Var = new g4();
        g4Var.e = "networkPrefer";
        g4Var.f = "policy";
        g4Var.b = this.a;
        g4Var.a = true;
        x6.b().commitAlarm(g4Var);
        this.j.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.j;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.j.start;
        SessionConnStat sessionConnStat2 = this.j;
        sessionConnStat2.isComplex = session.s.isComplex;
        sessionConnStat2.isCreated = session.A;
        xa2 xa2Var = this.e;
        if (xa2Var != null && xa2Var.c) {
            List<Session> c = this.d.c(this);
            this.j.sessionCount = c != null ? c.size() : 0;
        }
        x6.b().commitStat(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Context context, zm zmVar, IConnCb iConnCb, String str) {
        ConnType a = zmVar.a();
        if (context != null && !a.i()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, zmVar);
            tnetSpdySession.Q(this.c.c);
            xa2 b = this.c.f.b(this.b);
            this.e = b;
            tnetSpdySession.R(b);
            tnetSpdySession.U(this.c.f.a(this.b));
            SessionStatistic sessionStatistic = tnetSpdySession.s;
            sessionStatistic.xqcConnEnv += "-isContainHttp3=" + this.l;
            this.f = tnetSpdySession;
        } else {
            this.f = new HttpSession(context, zmVar);
        }
        ALog.f("awcn.SessionRequest", "create connection...", str, BizTime.HOST, y(), "Type", zmVar.a(), "IP", zmVar.e(), "Port", Integer.valueOf(zmVar.f()), "heartbeat", Integer.valueOf(zmVar.c()), Preloader.KEY_SESSION, this.f);
        A(this.f, iConnCb, System.currentTimeMillis(), str);
        this.f.e();
        SessionConnStat sessionConnStat = this.j;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.j;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", zmVar.e());
            IConnStrategy iConnStrategy = zmVar.a;
            if (iConnStrategy != null) {
                this.j.firstIpType = iConnStrategy.getIpType();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        E(false);
        synchronized (this.k) {
            this.k.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047 A[Catch: all -> 0x008d, TryCatch #0 {all -> 0x008d, blocks: (B:3:0x0005, B:6:0x0010, B:8:0x0023, B:10:0x0033, B:15:0x003d, B:16:0x0041, B:18:0x0047, B:21:0x0058, B:23:0x005e, B:25:0x0062, B:29:0x006b, B:31:0x0075, B:32:0x0079, B:33:0x007d), top: B:38:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<anet.channel.strategy.IConnStrategy> v(int r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "awcn.SessionRequest"
            java.util.List r1 = java.util.Collections.EMPTY_LIST
            r2 = 0
            java.lang.String r3 = r10.y()     // Catch: java.lang.Throwable -> L8d
            tb.o01 r3 = tb.o01.g(r3)     // Catch: java.lang.Throwable -> L8d
            if (r3 != 0) goto L10
            return r1
        L10:
            anet.channel.strategy.IStrategyInstance r4 = anet.channel.strategy.C0213a.a()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r5 = r3.d()     // Catch: java.lang.Throwable -> L8d
            java.util.List r1 = r4.getConnStrategyListByHost(r5)     // Catch: java.lang.Throwable -> L8d
            boolean r4 = r1.isEmpty()     // Catch: java.lang.Throwable -> L8d
            r5 = 1
            if (r4 != 0) goto L7d
            java.lang.String r4 = "https"
            java.lang.String r3 = r3.j()     // Catch: java.lang.Throwable -> L8d
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch: java.lang.Throwable -> L8d
            boolean r4 = anet.channel.util.Inet64Util.o()     // Catch: java.lang.Throwable -> L8d
            if (r4 != 0) goto L3c
            int r4 = anet.channel.detect.Ipv6Detector.d()     // Catch: java.lang.Throwable -> L8d
            if (r4 != 0) goto L3a
            goto L3c
        L3a:
            r4 = 0
            goto L3d
        L3c:
            r4 = 1
        L3d:
            java.util.ListIterator r6 = r1.listIterator()     // Catch: java.lang.Throwable -> L8d
        L41:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L8d
            if (r7 == 0) goto L7d
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L8d
            anet.channel.strategy.IConnStrategy r7 = (anet.channel.strategy.IConnStrategy) r7     // Catch: java.lang.Throwable -> L8d
            anet.channel.strategy.ConnProtocol r8 = r7.getProtocol()     // Catch: java.lang.Throwable -> L8d
            anet.channel.entity.ConnType r8 = anet.channel.entity.ConnType.l(r8)     // Catch: java.lang.Throwable -> L8d
            if (r8 != 0) goto L58
            goto L41
        L58:
            boolean r9 = r8.k()     // Catch: java.lang.Throwable -> L8d
            if (r9 != r3) goto L79
            int r9 = tb.ab2.c     // Catch: java.lang.Throwable -> L8d
            if (r11 == r9) goto L69
            int r8 = r8.e()     // Catch: java.lang.Throwable -> L8d
            if (r8 == r11) goto L69
            goto L79
        L69:
            if (r4 == 0) goto L41
            java.lang.String r7 = r7.getIp()     // Catch: java.lang.Throwable -> L8d
            boolean r7 = tb.lw2.d(r7)     // Catch: java.lang.Throwable -> L8d
            if (r7 == 0) goto L41
            r6.remove()     // Catch: java.lang.Throwable -> L8d
            goto L41
        L79:
            r6.remove()     // Catch: java.lang.Throwable -> L8d
            goto L41
        L7d:
            java.lang.String r11 = "[getAvailStrategy]"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = "strategies"
            r3[r2] = r4     // Catch: java.lang.Throwable -> L8d
            r3[r5] = r1     // Catch: java.lang.Throwable -> L8d
            anet.channel.util.ALog.e(r0, r11, r12, r3)     // Catch: java.lang.Throwable -> L8d
            goto L95
        L8d:
            r11 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = ""
            anet.channel.util.ALog.d(r0, r3, r12, r11, r2)
        L95:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.v(int, java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<zm> w(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        this.l = false;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            IConnStrategy iConnStrategy = list.get(i2);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i3 = 0; i3 <= retryTimes; i3++) {
                i++;
                String y = y();
                zm zmVar = new zm(y, str + JSMethod.NOT_SET + i, iConnStrategy);
                zmVar.d = i3;
                zmVar.e = retryTimes;
                arrayList.add(zmVar);
                if (zmVar.a().h()) {
                    this.l = true;
                }
            }
        }
        return arrayList;
    }

    void E(boolean z) {
        this.q.set(z);
        if (z) {
            return;
        }
        if (this.g != null) {
            this.g.cancel(true);
            this.g = null;
        }
        this.f = null;
        this.o = null;
        if (this.n != null) {
            this.n.cancel(true);
            this.n = null;
        }
        this.m = null;
        this.p.set(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void F(Context context, int i, String str, SessionGetCallback sessionGetCallback, long j) {
        List<zm> b;
        String a = TextUtils.isEmpty(str) ? ya2.a(null) : str;
        ALog.c("awcn.SessionRequest", "SessionRequest start", a, "host", this.a, "type", Integer.valueOf(i));
        if (!this.q.compareAndSet(false, true)) {
            ALog.e("awcn.SessionRequest", "session connecting", a, "host", y());
            if (sessionGetCallback != null) {
                if (x() == i) {
                    SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = new SessionGetWaitTimeoutTask(sessionGetCallback);
                    synchronized (this.i) {
                        this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask);
                    }
                    ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask, j, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        Session f = this.d.f(this, i);
        if (f != null) {
            ALog.e("awcn.SessionRequest", "Available Session exist!!!", a, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(f);
            }
            u();
            return;
        }
        E(true);
        this.g = ThreadPoolExecutorFactory.j(new ConnectTimeoutTask(a), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.j = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.n()) {
            if (ALog.g(1)) {
                ALog.c("awcn.SessionRequest", "network is not available, can't create session", a, "isConnected", Boolean.valueOf(NetworkStatusHelper.n()));
            }
            u();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> v = v(i, a);
        if (!v.isEmpty()) {
            List<zm> w = w(v, a);
            zm remove = w.remove(0);
            t(context, remove, new ConnCb(context, w, remove), remove.h());
            if (em.d(this.b, remove.e()) && (b = em.b(this.f, w, 1)) != null && b.size() > 0) {
                long a2 = em.a();
                ALog.c("awcn.SessionRequest", "sessionComplexTask will start", null, "delay", Long.valueOf(a2));
                this.m = new SessionComplexTask(context, this, i, b);
                this.n = ThreadPoolExecutorFactory.j(this.m, a2, TimeUnit.MILLISECONDS);
            }
            if (sessionGetCallback != null) {
                SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = new SessionGetWaitTimeoutTask(sessionGetCallback);
                synchronized (this.i) {
                    this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask2);
                }
                ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask2, j, TimeUnit.MILLISECONDS);
            }
            return;
        }
        ALog.f("awcn.SessionRequest", "no avalible strategy, can't create session", a, "host", this.a, "type", Integer.valueOf(i));
        u();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void G(Context context, int i, String str, SessionGetCallback sessionGetCallback, long j) {
        List<zm> b;
        String a = TextUtils.isEmpty(str) ? ya2.a(null) : str;
        ALog.c("awcn.SessionRequest", "SessionRequest start", a, "host", this.a, "type", Integer.valueOf(i));
        if (!this.q.compareAndSet(false, true)) {
            ALog.e("awcn.SessionRequest", "session connecting", a, "host", y());
            if (sessionGetCallback != null) {
                if (x() == i) {
                    SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask = new SessionGetWaitTimeoutTask(sessionGetCallback);
                    synchronized (this.i) {
                        this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask);
                    }
                    ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask, j, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        Session f = this.d.f(this, i);
        if (f != null) {
            ALog.c("awcn.SessionRequest", "Available Session exist!!!", a, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(f);
            }
            u();
            return;
        }
        E(true);
        this.g = ThreadPoolExecutorFactory.j(new ConnectTimeoutTask(a), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.j = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.n()) {
            if (ALog.g(1)) {
                ALog.c("awcn.SessionRequest", "network is not available, can't create session", a, "isConnected", Boolean.valueOf(NetworkStatusHelper.n()));
            }
            u();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> v = v(i, a);
        if (!v.isEmpty()) {
            List<zm> w = w(v, a);
            zm remove = w.remove(0);
            t(context, remove, new ConnCb(context, w, remove), remove.h());
            if (em.d(this.b, remove.e()) && (b = em.b(this.f, w, 1)) != null && b.size() > 0) {
                long a2 = em.a();
                ALog.c("awcn.SessionRequest", "sessionComplexTask will start", null, "delay", Long.valueOf(a2));
                this.m = new SessionComplexTask(context, this, i, b);
                this.n = ThreadPoolExecutorFactory.j(this.m, a2, TimeUnit.MILLISECONDS);
            }
            SessionGetWaitTimeoutTask sessionGetWaitTimeoutTask2 = new SessionGetWaitTimeoutTask(sessionGetCallback);
            synchronized (this.i) {
                this.i.put(sessionGetCallback, sessionGetWaitTimeoutTask2);
            }
            ThreadPoolExecutorFactory.j(sessionGetWaitTimeoutTask2, j, TimeUnit.MILLISECONDS);
            return;
        }
        ALog.f("awcn.SessionRequest", "no avalible strategy, can't create session", a, "host", this.a, "type", Integer.valueOf(i));
        u();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(long j) throws InterruptedException, TimeoutException {
        ALog.c("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j));
        if (j <= 0) {
            return;
        }
        synchronized (this.k) {
            long currentTimeMillis = System.currentTimeMillis() + j;
            while (this.q.get()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                }
                this.k.wait(currentTimeMillis - currentTimeMillis2);
            }
            if (this.q.get()) {
                throw new TimeoutException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        List<Session> g = this.d.g(this);
        if (g != null) {
            for (Session session : g) {
                if (session != null && session.q() && !session.g().i()) {
                    session.u(true, 5000);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(boolean z) {
        ALog.c("awcn.SessionRequest", "closeSessions", this.c.b, "host", this.a, "autoCreate", Boolean.valueOf(z));
        if (!z && this.f != null) {
            this.f.w = false;
            this.f.c(false);
            if (this.o != null) {
                this.o.w = false;
                this.o.c(false);
            }
        }
        List<Session> g = this.d.g(this);
        if (g != null) {
            for (Session session : g) {
                if (session != null) {
                    session.c(z);
                }
            }
        }
    }

    protected void s(Context context, zm zmVar, IConnCb iConnCb, String str) {
        ConnType a = zmVar.a();
        if (context != null && !a.i()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, zmVar);
            tnetSpdySession.Q(this.c.c);
            tnetSpdySession.R(this.e);
            tnetSpdySession.U(this.c.f.a(this.b));
            this.o = tnetSpdySession;
        } else {
            this.o = new HttpSession(context, zmVar);
        }
        this.o.z = true;
        ALog.e("awcn.SessionRequest", "create complex connection...", str, BizTime.HOST, y(), "Type", zmVar.a(), "IP", zmVar.e(), "Port", Integer.valueOf(zmVar.f()), "heartbeat", Integer.valueOf(zmVar.c()), Preloader.KEY_SESSION, this.o);
        A(this.o, iConnCb, System.currentTimeMillis(), str);
        this.o.s.isComplex = true;
        this.o.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x() {
        Session session = this.f;
        if (session != null) {
            return session.k.e();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String y() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str) {
        ALog.c("awcn.SessionRequest", "reCreateSession", str, "host", this.a);
        p(true);
    }
}
