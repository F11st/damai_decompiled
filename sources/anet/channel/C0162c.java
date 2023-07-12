package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.detect.NetworkDetector;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.C0214b;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.IAmdcSign;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.C0241c;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.preloader.Preloader;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.apache.commons.lang3.time.DateUtils;
import tb.C9708t9;
import tb.ab2;
import tb.hu0;
import tb.jg1;
import tb.lw2;
import tb.o01;
import tb.xa2;
import tb.ya2;
import tb.zh2;

/* compiled from: Taobao */
/* renamed from: anet.channel.c */
/* loaded from: classes.dex */
public class C0162c {
    public static final String TAG = "awcn.SessionCenter";
    static Map<C0159a, C0162c> i = new HashMap();
    private static boolean j = false;
    Context a;
    String b;
    C0159a c;
    final C0165d d = new C0165d();
    final LruCache<String, SessionRequest> e = new LruCache<>(32);
    final C0161b f = new C0161b();
    final AccsSessionManager g;
    final C0164b h;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.c$a */
    /* loaded from: classes.dex */
    class C0163a implements IAmdcSign {
        final /* synthetic */ String a;
        final /* synthetic */ ISecurity b;

        C0163a(String str, ISecurity iSecurity) {
            this.a = str;
            this.b = iSecurity;
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public String getAppkey() {
            return this.a;
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public String sign(String str) {
            return this.b.sign(C0162c.this.a, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
        }

        @Override // anet.channel.strategy.dispatch.IAmdcSign
        public boolean useSecurityGuard() {
            return !this.b.isSecOff();
        }
    }

    private C0162c(C0159a c0159a) {
        C0164b c0164b = new C0164b(this, null);
        this.h = c0164b;
        this.a = hu0.c();
        this.c = c0159a;
        this.b = c0159a.i();
        c0164b.a();
        this.g = new AccsSessionManager(this);
        if (c0159a.i().equals("[default]")) {
            return;
        }
        AmdcRuntimeInfo.i(new C0163a(c0159a.i(), c0159a.m()));
    }

    public static synchronized void D(ENV env) {
        synchronized (C0162c.class) {
            try {
                if (hu0.e() != env) {
                    ALog.f(TAG, "switch env", null, "old", hu0.e(), "new", env);
                    hu0.n(env);
                    C0213a.a().switchEnv();
                    SpdyAgent.getInstance(hu0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
                }
                Iterator<Map.Entry<C0159a, C0162c>> it = i.entrySet().iterator();
                while (it.hasNext()) {
                    C0162c value = it.next().getValue();
                    if (value.c.l() != env) {
                        ALog.f(TAG, "remove instance", value.b, "ENVIRONMENT", value.c.l());
                        value.g.d(false);
                        value.h.b();
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                ALog.d(TAG, "switch env error.", null, th, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(C0214b.C0221g c0221g) {
        try {
            C0214b.C0218d[] c0218dArr = c0221g.c;
            if (c0218dArr != null && c0218dArr.length != 0) {
                for (C0214b.C0218d c0218d : c0218dArr) {
                    if (c0218d.g) {
                        v(c0218d);
                    }
                    String str = c0218d.e;
                    if (str != null) {
                        x(c0218d.c, c0218d.a, str);
                    }
                    if (c0218d.i) {
                        w(c0218d.c, c0218d.a);
                    }
                }
            }
        } catch (Exception e) {
            ALog.d(TAG, "checkStrategy failed", this.b, e, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(C0214b.C0221g c0221g) {
        C0214b.C0219e[] c0219eArr;
        try {
            for (C0214b.C0219e c0219e : c0221g.b) {
                if (c0219e.k) {
                    u(c0219e);
                }
                String str = c0219e.e;
                if (str != null) {
                    x(c0219e.c, c0219e.a, str);
                }
                if (c0219e.m) {
                    w(c0219e.c, c0219e.a);
                }
            }
        } catch (Exception e) {
            ALog.d(TAG, "checkStrategy failed", this.b, e, new Object[0]);
        }
    }

    @Deprecated
    public static synchronized C0162c k() {
        Context b;
        synchronized (C0162c.class) {
            if (!j && (b = C0241c.b()) != null) {
                y(b);
            }
            C0162c c0162c = null;
            for (Map.Entry<C0159a, C0162c> entry : i.entrySet()) {
                C0162c value = entry.getValue();
                if (entry.getKey() != C0159a.DEFAULT_CONFIG) {
                    return value;
                }
                c0162c = value;
            }
            return c0162c;
        }
    }

    public static synchronized C0162c l(C0159a c0159a) {
        C0162c c0162c;
        Context b;
        synchronized (C0162c.class) {
            if (c0159a != null) {
                if (!j && (b = C0241c.b()) != null) {
                    y(b);
                }
                c0162c = i.get(c0159a);
                if (c0162c == null) {
                    c0162c = new C0162c(c0159a);
                    i.put(c0159a, c0162c);
                }
            } else {
                throw new NullPointerException("config is null!");
            }
        }
        return c0162c;
    }

    public static synchronized C0162c m(String str) {
        C0162c l;
        synchronized (C0162c.class) {
            C0159a k = C0159a.k(str);
            if (k != null) {
                l = l(k);
            } else {
                throw new RuntimeException("tag not exist!");
            }
        }
        return l;
    }

    private SessionRequest q(o01 o01Var) {
        String cNameByHost = C0213a.a().getCNameByHost(o01Var.d());
        if (cNameByHost == null) {
            cNameByHost = o01Var.d();
        }
        String j2 = o01Var.j();
        if (!o01Var.e()) {
            j2 = C0213a.a().getSchemeByHost(cNameByHost, j2);
        }
        return p(zh2.e(j2, jg1.SCHEME_SLASH, cNameByHost));
    }

    private void u(C0214b.C0219e c0219e) {
        boolean z;
        boolean z2;
        ALog.f(TAG, "find effectNow", this.b, "host", c0219e.a);
        C0214b.C0215a[] c0215aArr = c0219e.h;
        String[] strArr = c0219e.f;
        for (Session session : this.d.g(p(zh2.a(c0219e.c, c0219e.a)))) {
            if (!session.g().i()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr.length) {
                        z = false;
                        break;
                    } else if (session.i().equals(strArr[i2])) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= c0215aArr.length) {
                            z2 = false;
                            break;
                        } else if (session.j() == c0215aArr[i3].a && session.g().equals(ConnType.l(ConnProtocol.valueOf(c0215aArr[i3])))) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (ALog.g(2)) {
                            ALog.f(TAG, "aisle not match", session.r, "port", Integer.valueOf(session.j()), "connType", session.g(), "aisle", Arrays.toString(c0215aArr));
                        }
                        session.c(true);
                    }
                } else {
                    if (ALog.g(2)) {
                        ALog.f(TAG, "ip not match", session.r, "session ip", session.i(), "ips", Arrays.toString(strArr));
                    }
                    session.c(true);
                }
            }
        }
    }

    private void v(C0214b.C0218d c0218d) {
        boolean z;
        boolean z2;
        ALog.f(TAG, "find effectNow by dns", this.b, "host", c0218d.a);
        C0214b.C0223i[] c0223iArr = c0218d.k;
        if (c0223iArr == null || c0223iArr.length == 0) {
            return;
        }
        for (Session session : this.d.g(p(zh2.a(c0218d.c, c0218d.a)))) {
            if (!session.g().i()) {
                int i2 = 0;
                while (true) {
                    C0214b.C0223i[] c0223iArr2 = c0218d.k;
                    if (i2 < c0223iArr2.length) {
                        C0214b.C0216b[] c0216bArr = c0223iArr2[i2].a;
                        if (c0216bArr != null && c0216bArr.length != 0) {
                            for (int i3 = 0; i3 < c0216bArr.length; i3++) {
                                C0214b.C0217c[] c0217cArr = c0216bArr[i3].b;
                                String[] strArr = c0216bArr[i3].a;
                                if (c0217cArr != null && c0217cArr.length != 0 && strArr != null && strArr.length != 0) {
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= strArr.length) {
                                            z = false;
                                            break;
                                        } else if (session.i().equals(strArr[i4])) {
                                            z = true;
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= c0217cArr.length) {
                                            z2 = false;
                                            break;
                                        } else if (session.j() == c0217cArr[i5].a && session.g().equals(ConnType.l(ConnProtocol.valueOf(c0217cArr[i5])))) {
                                            z2 = true;
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    }
                                    if (z & z2) {
                                        if (ALog.g(2)) {
                                            ALog.f(TAG, "ip & ConnStrategy match", session.r, TbAuthConstants.IP, session.i(), "port", Integer.valueOf(session.j()), "connType", session.g());
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            continue;
                        }
                        i2++;
                    } else {
                        if (ALog.g(2)) {
                            ALog.f(TAG, "ip & ConnStrategy not match", session.r, TbAuthConstants.IP, session.i(), "port", Integer.valueOf(session.j()), "connType", session.g());
                        }
                        session.c(true);
                    }
                }
            }
        }
    }

    private void w(String str, String str2) {
        if (C9708t9.E()) {
            for (Session session : this.d.g(p(zh2.a(str, str2)))) {
                if (!lw2.d(session.f) && !session.z) {
                    ALog.e(TAG, "reconnect to ipv6", session.r, "session host", session.d, TbAuthConstants.IP, session.f);
                    session.c(true);
                }
            }
        }
    }

    private void x(String str, String str2, String str3) {
        for (Session session : this.d.g(p(zh2.a(str, str2)))) {
            if (!zh2.g(session.m, str3)) {
                ALog.f(TAG, "unit change", session.r, "session unit", session.m, "unit", str3);
                session.c(true);
            }
        }
    }

    public static synchronized void y(Context context) {
        synchronized (C0162c.class) {
            if (context != null) {
                hu0.l(context.getApplicationContext());
                if (!j) {
                    Map<C0159a, C0162c> map = i;
                    C0159a c0159a = C0159a.DEFAULT_CONFIG;
                    map.put(c0159a, new C0162c(c0159a));
                    AppLifecycle.b();
                    NetworkStatusHelper.t(context);
                    if (!C9708t9.O()) {
                        C0213a.a().initialize(hu0.c());
                    }
                    if (hu0.j()) {
                        NetworkDetector.c();
                    }
                    j = true;
                }
            } else {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            }
        }
    }

    public static synchronized void z(Context context, C0159a c0159a) {
        synchronized (C0162c.class) {
            if (context == null) {
                ALog.e(TAG, "context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. context is null");
            } else if (c0159a != null) {
                y(context);
                if (!i.containsKey(c0159a)) {
                    i.put(c0159a, new C0162c(c0159a));
                }
            } else {
                ALog.e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. config is null");
            }
        }
    }

    public void A(ISessionListener iSessionListener) {
        this.g.g(iSessionListener);
    }

    public void B(String str, int i2) {
        this.f.d(str, i2);
    }

    public void C(xa2 xa2Var) {
        this.f.e(xa2Var);
        if (xa2Var.b) {
            this.g.b();
        }
    }

    public void E(ISessionListener iSessionListener) {
        this.g.h(iSessionListener);
    }

    public void F(String str) {
        xa2 f = this.f.f(str);
        if (f == null || !f.b) {
            return;
        }
        this.g.b();
    }

    public void d(o01 o01Var, int i2, long j2, SessionGetCallback sessionGetCallback) {
        Objects.requireNonNull(sessionGetCallback, "cb is null");
        if (j2 > 0) {
            try {
                o(o01Var, i2, j2, sessionGetCallback);
                return;
            } catch (Exception unused) {
                sessionGetCallback.onSessionGetFail();
                return;
            }
        }
        throw new InvalidParameterException("timeout must > 0");
    }

    public void g() {
        this.g.d(true);
    }

    public Session h(String str, long j2) {
        return j(o01.g(str), ab2.c, j2);
    }

    @Deprecated
    public Session i(String str, ConnType.TypeLevel typeLevel, long j2) {
        return j(o01.g(str), typeLevel == ConnType.TypeLevel.SPDY ? ab2.a : ab2.b, j2);
    }

    public Session j(o01 o01Var, int i2, long j2) {
        try {
            return n(o01Var, i2, j2, null);
        } catch (NoAvailStrategyException e) {
            ALog.f(TAG, "[Get]" + e.getMessage(), this.b, null, "url", o01Var.n());
            return null;
        } catch (ConnectException e2) {
            ALog.e(TAG, "[Get]connect exception", this.b, "errMsg", e2.getMessage(), "url", o01Var.n());
            return null;
        } catch (InvalidParameterException e3) {
            ALog.d(TAG, "[Get]param url is invalid", this.b, e3, "url", o01Var);
            return null;
        } catch (TimeoutException e4) {
            ALog.d(TAG, "[Get]timeout exception", this.b, e4, "url", o01Var.n());
            return null;
        } catch (Exception e5) {
            ALog.d(TAG, "[Get]" + e5.getMessage(), this.b, null, "url", o01Var.n());
            return null;
        }
    }

    protected Session n(o01 o01Var, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        xa2 b;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.b, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (o01Var != null) {
            String str = this.b;
            Object[] objArr = new Object[6];
            objArr[0] = IRequestConst.U;
            objArr[1] = o01Var.n();
            objArr[2] = "sessionType";
            objArr[3] = i2 == ab2.a ? "LongLink" : "ShortLink";
            objArr[4] = "timeout";
            objArr[5] = Long.valueOf(j2);
            ALog.f(TAG, "getInternal", str, objArr);
            SessionRequest q = q(o01Var);
            Session f = this.d.f(q, i2);
            if (f != null) {
                ALog.c(TAG, "get internal hit cache session", this.b, Preloader.KEY_SESSION, f);
            } else if (this.c == C0159a.DEFAULT_CONFIG && i2 != ab2.b) {
                if (sessionGetCallback != null) {
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                return null;
            } else if (hu0.i() && i2 == ab2.a && C9708t9.i() && (b = this.f.b(o01Var.d())) != null && b.c) {
                ALog.k(TAG, "app background, forbid to create accs session", this.b, new Object[0]);
                throw new ConnectException("accs session connecting forbidden in background");
            } else {
                q.F(this.a, i2, ya2.a(this.b), sessionGetCallback, j2);
                if (sessionGetCallback == null && j2 > 0 && (i2 == ab2.c || q.x() == i2)) {
                    q.n(j2);
                    f = this.d.f(q, i2);
                    if (f == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return f;
        } else {
            throw new InvalidParameterException("httpUrl is null");
        }
    }

    protected void o(o01 o01Var, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        xa2 b;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.b, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        } else if (o01Var == null) {
            throw new InvalidParameterException("httpUrl is null");
        } else {
            if (sessionGetCallback != null) {
                String str = this.b;
                Object[] objArr = new Object[6];
                objArr[0] = IRequestConst.U;
                objArr[1] = o01Var.n();
                objArr[2] = "sessionType";
                objArr[3] = i2 == ab2.a ? "LongLink" : "ShortLink";
                objArr[4] = "timeout";
                objArr[5] = Long.valueOf(j2);
                ALog.c(TAG, "getInternal", str, objArr);
                SessionRequest q = q(o01Var);
                Session f = this.d.f(q, i2);
                if (f != null) {
                    ALog.c(TAG, "get internal hit cache session", this.b, Preloader.KEY_SESSION, f);
                    sessionGetCallback.onSessionGetSuccess(f);
                    return;
                } else if (this.c == C0159a.DEFAULT_CONFIG && i2 != ab2.b) {
                    sessionGetCallback.onSessionGetFail();
                    return;
                } else if (hu0.i() && i2 == ab2.a && C9708t9.i() && (b = this.f.b(o01Var.d())) != null && b.c) {
                    ALog.k(TAG, "app background, forbid to create accs session", this.b, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                } else {
                    q.G(this.a, i2, ya2.a(this.b), sessionGetCallback, j2);
                    return;
                }
            }
            throw new InvalidParameterException("sessionGetCallback is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SessionRequest p(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.e) {
            sessionRequest = this.e.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.e.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }

    public Session r(String str, long j2) throws Exception {
        return n(o01.g(str), ab2.c, j2, null);
    }

    @Deprecated
    public Session s(String str, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return n(o01.g(str), typeLevel == ConnType.TypeLevel.SPDY ? ab2.a : ab2.b, j2, null);
    }

    public Session t(o01 o01Var, int i2, long j2) throws Exception {
        return n(o01Var, i2, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.c$b */
    /* loaded from: classes.dex */
    public class C0164b implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {
        boolean a;

        private C0164b() {
            this.a = false;
        }

        void a() {
            AppLifecycle.f(this);
            NetworkStatusHelper.a(this);
            C0213a.a().registerListener(this);
        }

        void b() {
            C0213a.a().unregisterListener(this);
            AppLifecycle.g(this);
            NetworkStatusHelper.s(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.f(C0162c.TAG, "[background]", C0162c.this.b, new Object[0]);
            if (!C0162c.j) {
                ALog.e(C0162c.TAG, "background not inited!", C0162c.this.b, new Object[0]);
                return;
            }
            try {
                C0213a.a().saveData();
                if (C9708t9.i() && "OPPO".equalsIgnoreCase(Build.getBRAND())) {
                    ALog.f(C0162c.TAG, "close session for OPPO", C0162c.this.b, new Object[0]);
                    C0162c.this.g.d(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.f(C0162c.TAG, "[forground]", C0162c.this.b, new Object[0]);
            if (C0162c.this.a == null || this.a) {
                return;
            }
            this.a = true;
            try {
                if (!C0162c.j) {
                    ALog.e(C0162c.TAG, "forground not inited!", C0162c.this.b, new Object[0]);
                    return;
                }
                try {
                    if (C9708t9.K() && AppLifecycle.b != 0 && System.currentTimeMillis() - AppLifecycle.b > DateUtils.MILLIS_PER_MINUTE) {
                        C0162c.this.g.d(true);
                    } else {
                        C0162c.this.g.b();
                    }
                    if (C9708t9.o() && AppLifecycle.b != 0 && System.currentTimeMillis() - AppLifecycle.b > 30000) {
                        ALog.e(C0162c.TAG, "foreground check session available.", C0162c.this.b, new Object[0]);
                        List<SessionRequest> d = C0162c.this.d.d();
                        if (!d.isEmpty()) {
                            for (SessionRequest sessionRequest : d) {
                                sessionRequest.o();
                            }
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.a = false;
                    throw th;
                }
                this.a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(C0162c.TAG, "onNetworkStatusChanged.", C0162c.this.b, "networkStatus", networkStatus);
            List<SessionRequest> d = C0162c.this.d.d();
            if (!d.isEmpty()) {
                for (SessionRequest sessionRequest : d) {
                    ALog.c(C0162c.TAG, "network change, try recreate session", C0162c.this.b, new Object[0]);
                    sessionRequest.z(null);
                }
            }
            C0162c.this.g.b();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(C0214b.C0221g c0221g) {
            if (C9708t9.N()) {
                C0162c.this.e(c0221g);
            } else {
                C0162c.this.f(c0221g);
            }
            C0162c.this.g.b();
        }

        /* synthetic */ C0164b(C0162c c0162c, C0163a c0163a) {
            this();
        }
    }
}
