package com.taobao.slide.api;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ta.utdid2.device.UTDevice;
import com.taobao.orange.OConstant;
import com.taobao.slide.control.C6887a;
import com.taobao.slide.core.C6889b;
import com.taobao.slide.core.SlideReceiver;
import com.taobao.slide.plugin.SlideWVPlugin;
import com.taobao.slide.request.AbstractC6891b;
import com.taobao.slide.task.PushTask;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.core.Constants;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.au1;
import tb.da1;
import tb.fh2;
import tb.gx2;
import tb.hh1;
import tb.il2;
import tb.ki2;
import tb.m42;
import tb.nl;
import tb.u21;
import tb.v31;
import tb.vd2;
import tb.zv0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SlideLoad {
    public static boolean f;
    AtomicBoolean a;
    Context b;
    String c;
    C6889b d;
    Map<ki2, SlideSubscriber> e;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.slide.api.SlideLoad$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String[] val$podNames;
        final /* synthetic */ SlideSubscriber val$subscriber;

        AnonymousClass2(String[] strArr, SlideSubscriber slideSubscriber) {
            this.val$podNames = strArr;
            this.val$subscriber = slideSubscriber;
        }

        @Override // java.lang.Runnable
        public void run() {
            ki2 ki2Var = new ki2(this.val$podNames);
            SlideLoad slideLoad = SlideLoad.this;
            C6889b c6889b = slideLoad.d;
            if (c6889b == null) {
                slideLoad.e.put(ki2Var, this.val$subscriber);
                m42.k("Load", "subscribe delay wait init complete", new Object[0]);
                return;
            }
            c6889b.p(ki2Var, this.val$subscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.slide.api.SlideLoad$a */
    /* loaded from: classes11.dex */
    public static class C6885a {
        private static final SlideLoad a = new SlideLoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(hh1.POINT_UTDID, 0);
        String string = sharedPreferences.getString("local", "");
        if (!this.c.equals(string)) {
            sharedPreferences.edit().putString("local", this.c).commit();
            if (TextUtils.isEmpty(string)) {
                hh1.c(hh1.POINT_UTDID, null);
                return;
            }
            m42.k("Load", "init utdid has changed", new Object[0]);
            hh1.b(hh1.POINT_UTDID, null, null, null);
            return;
        }
        hh1.c(hh1.POINT_UTDID, null);
    }

    public static SlideLoad h() {
        return C6885a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            AbstractC6891b.d = true;
        } catch (Throwable unused) {
            m42.k("Load", "init not found taobao networksdk", new Object[0]);
        }
        try {
            v31.a(new vd2(this.d));
        } catch (Throwable unused2) {
            m42.k("Load", "init not found networksdk interceptor", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(SlideConfig slideConfig) {
        fh2 fh2Var = new fh2();
        C6887a.a(new da1("did_hash", this.c, new zv0()).e(true), new da1("ttid", slideConfig.getTtid(), fh2Var).e(true), new da1("app_ver", slideConfig.getAppVersion(), new gx2()).e(true), new da1(OConstant.CANDIDATE_OSVER, String.valueOf(Build.VERSION.SDK_INT), new gx2()).e(true), new da1("m_vendor", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER(), fh2Var).e(true), new da1(OConstant.CANDIDATE_BRAND, com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND(), fh2Var).e(true), new da1(OConstant.CANDIDATE_MODEL, com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL(), fh2Var).e(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        this.b.registerReceiver(new SlideReceiver(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            WVPluginManager.registerPlugin(SlideWVPlugin.SLIDE_PLUGIN_NAME, (Class<? extends WVApiPlugin>) SlideWVPlugin.class);
        } catch (Throwable unused) {
            m42.k("Load", "SlideWVPlugin register fail, can not find WV", new Object[0]);
        }
    }

    @AnyThread
    public JSONObject g() {
        C6889b c6889b = this.d;
        if (c6889b != null) {
            return JSON.parseObject(JSON.toJSONString(c6889b.d()));
        }
        return null;
    }

    @AnyThread
    public void i(String str) {
        il2.b(new PushTask(str, this.d));
    }

    @AnyThread
    public void j(@NonNull Context context, @NonNull final SlideConfig slideConfig) {
        final long currentTimeMillis = System.currentTimeMillis();
        au1.e(context, "init error as context is null");
        au1.e(slideConfig, "init error as slideConfig is null");
        if (this.a.get()) {
            m42.c("Load", "init already", new Object[0]);
            return;
        }
        this.b = context.getApplicationContext();
        il2.b(new Runnable() { // from class: com.taobao.slide.api.SlideLoad.1
            @Override // java.lang.Runnable
            public void run() {
                if (SlideLoad.this.a.get()) {
                    return;
                }
                try {
                    if (nl.i(SlideLoad.this.b)) {
                        SlideLoad.this.m();
                        SlideLoad slideLoad = SlideLoad.this;
                        slideLoad.c = UTDevice.getUtdid(slideLoad.b);
                        boolean z = (SlideLoad.this.b.getApplicationInfo().flags & 2) != 0;
                        SlideLoad.f = z;
                        m42.h(!z);
                        m42.g("Load", "init start", "sdkVersion", "1.0.0", "utdid", SlideLoad.this.c, Constants.CONFIG, slideConfig.toString());
                        SlideLoad.this.l(slideConfig);
                        SlideLoad slideLoad2 = SlideLoad.this;
                        slideLoad2.d = new C6889b(slideLoad2.b, slideConfig);
                        SlideLoad.this.d.h();
                        SlideLoad.this.k();
                        SlideLoad.this.a.set(true);
                        for (Map.Entry<ki2, SlideSubscriber> entry : SlideLoad.this.e.entrySet()) {
                            SlideLoad.this.d.p(entry.getKey(), entry.getValue());
                        }
                        SlideLoad.this.e.clear();
                        SlideLoad.this.f();
                        SlideLoad.this.n();
                        m42.g("Load", UCCore.LEGACY_EVENT_INIT, "time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    m42.k("Load", "init broken as not in main process", new Object[0]);
                } catch (Throwable th) {
                    u21.c(null, 1000);
                    m42.j("Load", UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
                }
            }
        });
    }

    private SlideLoad() {
        this.a = new AtomicBoolean(false);
        this.e = new ConcurrentHashMap();
    }
}
