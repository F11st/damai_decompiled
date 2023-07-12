package com.taobao.monitor.adapter;

import android.app.Application;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.ali.ha.datahub.BizSubscriber;
import com.taobao.monitor.APMLauncher;
import com.taobao.monitor.adapter.network.TBRestSender;
import com.taobao.monitor.impl.data.AbsWebView;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.d;
import com.uc.webview.export.WebView;
import java.io.Serializable;
import java.util.HashMap;
import tb.b30;
import tb.dp2;
import tb.fu0;
import tb.ho2;
import tb.k13;
import tb.lu0;
import tb.nq1;
import tb.pb1;
import tb.rj2;
import tb.tu1;
import tb.uu1;
import tb.vj1;
import tb.vu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SimpleApmInitiator implements Serializable {
    private static final String TAG = "TBAPMAdapterLaunchers";
    private long apmStartTime = ho2.a();
    private long cpuStartTime = SystemClock.currentThreadTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a extends AbsWebView {
        a(SimpleApmInitiator simpleApmInitiator) {
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

    private void initAPMFunction(Application application, HashMap<String, Object> hashMap) {
        fu0.e().g(uu1.d().b());
        initAPMLauncher(application, hashMap);
        initTbRest(application);
        initDataHub(hashMap);
        initLauncherProcedure();
        initWebView();
    }

    private void initAPMLauncher(Application application, HashMap<String, Object> hashMap) {
        vu1.b(application, hashMap);
        APMLauncher.g(application, hashMap);
    }

    private void initDataHub(HashMap<String, Object> hashMap) {
        boolean a2 = nq1.a(hashMap.get(rj2.l), true);
        rj2.h = a2;
        if (a2) {
            b30.a().b(new BizSubscriber(this) { // from class: com.taobao.monitor.adapter.SimpleApmInitiator.1
                private void a(Runnable runnable) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        fu0.e().d().post(runnable);
                    } else {
                        runnable.run();
                    }
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onBizDataReadyStage() {
                    IProcedure a3 = com.taobao.monitor.adapter.a.a();
                    if (a3 != null) {
                        a3.stage("onBizDataReadyTime", ho2.a());
                    }
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void onStage(final String str, final String str2, long j) {
                    final long a3 = ho2.a();
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.SimpleApmInitiator.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a4 = com.taobao.monitor.adapter.a.a();
                            if (a4 != null) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(str2, Long.valueOf(a3));
                                a4.addBizStage(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pub(final String str, final HashMap<String, String> hashMap2) {
                    if ("splash".equals(str)) {
                        lu0.c = true;
                    }
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.SimpleApmInitiator.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a3 = com.taobao.monitor.adapter.a.a();
                            if (a3 != null) {
                                a3.addBiz(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void pubAB(final String str, final HashMap<String, String> hashMap2) {
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.SimpleApmInitiator.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a3 = com.taobao.monitor.adapter.a.a();
                            if (a3 != null) {
                                a3.addBizAbTest(str, hashMap2);
                            }
                        }
                    });
                }

                @Override // com.ali.ha.datahub.BizSubscriber
                public void setMainBiz(final String str, final String str2) {
                    a(new Runnable() { // from class: com.taobao.monitor.adapter.SimpleApmInitiator.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            IProcedure a3 = com.taobao.monitor.adapter.a.a();
                            if (a3 != null) {
                                a3.addProperty("bizID", str);
                                if (TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                a3.addProperty("bizCode", str2);
                            }
                        }
                    });
                }
            });
        }
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

    private void initTbRest(Application application) {
        vj1.b().a(new TBRestSender());
    }

    private void initWebView() {
        if (rj2.g) {
            k13.INSTANCE.a(new a(this));
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (!rj2.b) {
            pb1.d(TAG, "init start");
            rj2.a = true;
            initAPMFunction(application, hashMap);
            pb1.d(TAG, "init end");
            rj2.b = true;
        }
        pb1.d(TAG, "apmStartTime:", Long.valueOf(ho2.a() - this.apmStartTime));
    }
}
