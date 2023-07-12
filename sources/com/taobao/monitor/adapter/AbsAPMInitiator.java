package com.taobao.monitor.adapter;

import android.app.Application;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import android.view.View;
import com.ali.ha.datahub.BizSubscriber;
import com.taobao.android.tbexecutor.tbhandler.HandlerThreadFactory;
import com.taobao.android.tbexecutor.threadpool.TBThreadPoolExecutor;
import com.taobao.monitor.APMLauncher;
import com.taobao.monitor.adapter.logger.LoggerAdapter;
import com.taobao.monitor.adapter.network.TBRestSender;
import com.taobao.monitor.adapter.procedure.getter.H5ProcedureGetterBridge;
import com.taobao.monitor.common.IHandlerThreadMaker;
import com.taobao.monitor.impl.data.AbsWebView;
import com.taobao.monitor.impl.data.utsession.IUTSession;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import com.taobao.monitor.test.APMTestPluginLauncher;
import com.uc.webview.export.WebView;
import com.ut.mini.internal.UTTeamWork;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import tb.b30;
import tb.dp2;
import tb.dt2;
import tb.e13;
import tb.e30;
import tb.fu0;
import tb.ho2;
import tb.k13;
import tb.kq1;
import tb.lu0;
import tb.nq1;
import tb.pb1;
import tb.rj2;
import tb.tu1;
import tb.uu1;
import tb.vj1;
import tb.vm2;
import tb.vu1;
import tb.yj2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
abstract class AbsAPMInitiator implements Serializable {
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final String TAG = "AbsAPMInitiator";
    private final long apmStartTime = ho2.a();
    private final long cpuStartTime = SystemClock.currentThreadTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements ThreadFactory {
        final /* synthetic */ AtomicInteger a;

        a(AbsAPMInitiator absAPMInitiator, AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "APM-common-" + this.a.getAndIncrement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements IHandlerThreadMaker {
        b(AbsAPMInitiator absAPMInitiator) {
        }

        @Override // com.taobao.monitor.common.IHandlerThreadMaker
        public HandlerThread make(String str) {
            return HandlerThreadFactory.handlerThread(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class c extends AbsWebView {
        c(AbsAPMInitiator absAPMInitiator) {
        }

        @Override // com.taobao.monitor.impl.data.AbsWebView
        public int d(View view) {
            return ((WebView) view).getProgress();
        }

        @Override // com.taobao.monitor.impl.data.IWebView
        public boolean isWebView(View view) {
            return view instanceof WebView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class d implements IUTSession {
        d(AbsAPMInitiator absAPMInitiator) {
        }

        @Override // com.taobao.monitor.impl.data.utsession.IUTSession
        public String getUtsid() {
            return UTTeamWork.getInstance().getUtsid();
        }
    }

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        initParams(hashMap);
        initThread();
        initDataLogger();
        kq1.a().f(application, hashMap);
        initAPMLauncher(application, hashMap);
        initNetwork();
        initTbRest(application);
        initDataHub(hashMap);
        initLauncherProcedure();
        initWebView();
        initExpendLauncher(application);
        initUTSession(hashMap);
        initTestPlugin(application, hashMap);
    }

    private void initAPMLauncher(Application application, HashMap<String, Object> hashMap) {
        initPage(application);
        vu1.b(application, hashMap);
        APMLauncher.g(application, hashMap);
    }

    private void initDataHub(HashMap<String, Object> hashMap) {
        if (rj2.h) {
            b30.a().b(new BizSubscriber(this) { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.4
                private void a(Runnable runnable) {
                    fu0.e().d().post(runnable);
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onBizDataReadyStage() {
                    IProcedure a2 = com.taobao.monitor.adapter.a.a();
                    if (a2 != null) {
                        a2.stage("onBizDataReadyTime", ho2.a());
                    }
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onStage(final String str, final String str2, long j) {
                    final long a2 = ho2.a();
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.4.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a3 = com.taobao.monitor.adapter.a.a();
                            if (a3 != null) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(str2, Long.valueOf(a2));
                                a3.addBizStage(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pub(final String str, final HashMap<String, String> hashMap2) {
                    if ("splash".equals(str)) {
                        lu0.c = true;
                    }
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap hashMap3;
                            if ("afc".equals(str) && (hashMap3 = hashMap2) != null) {
                                String str2 = (String) hashMap3.get("url");
                                if (!TextUtils.isEmpty(str2)) {
                                    e13.b().a(str2);
                                }
                                e30.a(AbsAPMInitiator.TAG, str, hashMap2);
                            }
                            pb1.a(AbsAPMInitiator.TAG, str, hashMap2);
                            IProcedure a2 = com.taobao.monitor.adapter.a.a();
                            if (a2 != null) {
                                a2.addBiz(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pubAB(final String str, final HashMap<String, String> hashMap2) {
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a2 = com.taobao.monitor.adapter.a.a();
                            if (a2 != null) {
                                a2.addBizAbTest(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void setMainBiz(final String str, final String str2) {
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.4.4
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a2 = com.taobao.monitor.adapter.a.a();
                            if (a2 != null) {
                                a2.addProperty("bizID", str);
                                if (TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                a2.addProperty("bizCode", str2);
                            }
                        }
                    });
                }
            });
        }
    }

    private void initDataLogger() {
        e30.b(new LoggerAdapter());
    }

    private void initLauncherProcedure() {
        IProcedure createProcedure = tu1.b.createProcedure(dp2.a("/startup"), new d.b().g(false).k(true).i(false).h(null).f());
        createProcedure.begin();
        uu1.PROCEDURE_MANAGER.s(createProcedure);
        IProcedure createProcedure2 = tu1.b.createProcedure("/APMSelf", new d.b().g(false).k(false).i(false).h(createProcedure).f());
        createProcedure2.begin();
        createProcedure2.addProperty("isMainThread", Boolean.valueOf(Looper.getMainLooper().getThread() == Thread.currentThread()));
        createProcedure2.addProperty("threadName", Thread.currentThread().getName());
        createProcedure2.stage("taskStart", this.apmStartTime);
        createProcedure2.stage("cpuStartTime", this.cpuStartTime);
        TBAPMAdapterSubTaskManager.h();
        createProcedure2.stage("taskEnd", ho2.a());
        createProcedure2.stage("cpuEndTime", SystemClock.currentThreadTimeMillis());
        createProcedure2.end();
    }

    private void initNetwork() {
        try {
            yj2.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initTbRest(Application application) {
        vj1.b().a(new TBRestSender());
    }

    private void initThread() {
        fu0.e().g(uu1.d().b());
        if (rj2.f) {
            vm2.b(new TBThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this, new AtomicInteger(0)), new ThreadPoolExecutor.AbortPolicy()));
            vm2.c(new b(this));
        }
    }

    private void initUTSession(HashMap<String, Object> hashMap) {
        if (nq1.a(hashMap.get("needUT"), true)) {
            dt2.a().b(new d(this));
        }
    }

    private void initWebView() {
        if (rj2.g) {
            WVPluginManager.registerPlugin(H5ProcedureGetterBridge.class.getSimpleName(), (Class<? extends WVApiPlugin>) H5ProcedureGetterBridge.class, false);
            k13.INSTANCE.a(new c(this));
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!rj2.b) {
            pb1.d(TAG, "init start");
            initAPMFunction(application, hashMap);
            rj2.b = true;
            rj2.a = true;
            pb1.d(TAG, "init end");
        }
        pb1.d(TAG, "apmStartTime:", Long.valueOf(ho2.a() - this.apmStartTime));
    }

    protected void initExpendLauncher(Application application) {
    }

    protected abstract void initPage(Application application);

    protected void initParams(HashMap<String, Object> hashMap) {
        rj2.h = nq1.a(hashMap.get(rj2.l), true);
    }

    protected void initTestPlugin(final Application application, final HashMap<String, Object> hashMap) {
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.adapter.AbsAPMInitiator.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if ((application.getApplicationInfo().flags & 2) != 0) {
                        pb1.e(true);
                    }
                    Class.forName("com.taobao.monitor.test.APMTestPluginLauncher");
                    APMTestPluginLauncher.init(application, hashMap);
                } catch (Throwable th) {
                    pb1.b(AbsAPMInitiator.TAG, th);
                }
            }
        });
    }
}
