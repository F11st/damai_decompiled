package com.alibaba.security.realidentity.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.d.h;
import com.alibaba.security.common.d.q;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.c;
import com.alibaba.security.realidentity.a.e;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.b;
import com.alibaba.security.realidentity.c.a;
import com.alibaba.security.realidentity.view.RPTopBar;
import com.tencent.open.SocialConstants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPWebViewActivity extends RPBaseActivity {
    private static final String b = "RPWebViewActivity";
    private static final String c = "(function() {if(typeof(_windvane_backControl)!=='undefined') return _windvane_backControl(); else return 'false';})()";
    private static final String d = "(function() {if(typeof(window.WebViewJavaScriptBridge)!=='undefined') return 'true'; else return 'false';})()";
    private static final String e = "wvBackClickEvent";
    private static final String f = "rpOnBack";
    private c g;
    private FrameLayout h;
    private boolean k;
    private String l;
    private String m;
    private String i = "";
    private boolean j = false;
    ValueCallback<String> a = new ValueCallback<String>() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.3
        private void a(String str) {
            if (a.C0165a.a.a == null) {
                a.C0165a.a.a = RPWebViewActivity.d(RPWebViewActivity.this);
            }
            if (str == null || !"true".equals(str.replace("\"", "").replace("'", ""))) {
                if (RPWebViewActivity.this.g.j()) {
                    RPWebViewActivity.this.g.i();
                    return;
                }
                b bVar = g.a.a.h;
                if (bVar != null) {
                    bVar.onFinish(RPResult.AUDIT_NOT, "-10500", "执行H5方法失败");
                }
                RPWebViewActivity.this.finish();
                return;
            }
            RPWebViewActivity.this.g.a(g.a.a.d() ? RPWebViewActivity.e : RPWebViewActivity.f);
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            String str2 = str;
            if (a.C0165a.a.a == null) {
                a.C0165a.a.a = RPWebViewActivity.d(RPWebViewActivity.this);
            }
            if (str2 == null || !"true".equals(str2.replace("\"", "").replace("'", ""))) {
                if (RPWebViewActivity.this.g.j()) {
                    RPWebViewActivity.this.g.i();
                    return;
                }
                b bVar = g.a.a.h;
                if (bVar != null) {
                    bVar.onFinish(RPResult.AUDIT_NOT, "-10500", "执行H5方法失败");
                }
                RPWebViewActivity.this.finish();
                return;
            }
            RPWebViewActivity.this.g.a(g.a.a.d() ? RPWebViewActivity.e : RPWebViewActivity.f);
        }
    };

    static /* synthetic */ boolean c(RPWebViewActivity rPWebViewActivity) {
        rPWebViewActivity.k = true;
        return true;
    }

    private static void d() {
        g unused = g.a.a;
        a.C0165a.a.a(false);
    }

    private LastExitTrackMsg e() {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(this.g.d());
        lastExitTrackMsg.setParams(h.a(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private RPTrack.LastExitTrackParams f() {
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(this.g.d());
        return lastExitTrackParams;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.rp_alrealidentity_activity_rph5);
        RPTopBar rPTopBar = (RPTopBar) findViewById(R.id.topBar);
        rPTopBar.setTitle(getString(R.string.title_rp_h5));
        String stringExtra = getIntent().getStringExtra("url");
        this.m = getIntent().getStringExtra("token");
        this.h = (FrameLayout) findViewById(R.id.browser_fragment_layout);
        c a = i.a.a.a(this);
        this.g = a;
        if (a == null) {
            finish();
            return;
        }
        View b2 = a.b();
        if (b2 == null) {
            finish();
            return;
        }
        this.g.e();
        this.g.k();
        rPTopBar.getIvLeftParent().setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RPWebViewActivity.this.g.a(g.a.a.d() ? RPWebViewActivity.c : RPWebViewActivity.d, RPWebViewActivity.this.a);
            }
        });
        this.h.addView(b2);
        String f2 = this.g.f();
        if (TextUtils.isEmpty(f2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog("WebView UserAgent is NULL", h.a((Object) hashMap), "WebView UserAgent is NULL");
            createSdkExceptionLog.setCode(-1);
            g unused = g.a.a;
            g.a(this.m, createSdkExceptionLog);
        }
        this.i = f2;
        String str = VersionKey.RP_SDK_VERSION;
        this.g.c(f2 + " " + com.alibaba.security.realidentity.a.a.I + "/" + str);
        this.k = false;
        new e() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.2
            @Override // com.alibaba.security.realidentity.a.e
            public final void a(String str2) {
                RPWebViewActivity.this.l = str2;
            }

            @Override // com.alibaba.security.realidentity.a.e
            public final void b(String str2) {
                if (RPWebViewActivity.this.k || RPWebViewActivity.this.g.a() != 100) {
                    return;
                }
                RPWebViewActivity.a(RPWebViewActivity.this, "onPageFinished", str2, "", "", true);
            }

            @Override // com.alibaba.security.realidentity.a.e
            public final void a(final int i, final String str2, final String str3) {
                RPWebViewActivity.c(RPWebViewActivity.this);
                new com.alibaba.security.realidentity.c.a(new a.InterfaceC0171a() { // from class: com.alibaba.security.realidentity.activity.RPWebViewActivity.2.1
                    @Override // com.alibaba.security.realidentity.c.a.InterfaceC0171a
                    public final void a(Map<String, Boolean> map) {
                        RPWebViewActivity rPWebViewActivity = RPWebViewActivity.this;
                        RPWebViewActivity.a(rPWebViewActivity, "onReceivedError: " + str2, str3, i, str2, map);
                    }
                }).execute(str3);
            }

            @Override // com.alibaba.security.realidentity.a.e
            public final void a(Object obj, Object obj2) {
                RPWebViewActivity rPWebViewActivity = RPWebViewActivity.this;
                RPWebViewActivity.a(rPWebViewActivity, "onReceivedHttpError", rPWebViewActivity.g.c(), h.a(obj), h.a(obj2), false);
            }

            @Override // com.alibaba.security.realidentity.a.e
            public final void a() {
                RPWebViewActivity rPWebViewActivity = RPWebViewActivity.this;
                RPWebViewActivity.a(rPWebViewActivity, "onReceivedSslError", rPWebViewActivity.g.c(), (String) null, (String) null, false);
            }
        };
        this.g.b(stringExtra);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap2.put("ua", this.g.f());
        TrackLog createSdkWebViewEnterLog = TrackLog.createSdkWebViewEnterLog(h.a((Object) hashMap2));
        g unused2 = g.a.a;
        g.a(this.m, createSdkWebViewEnterLog);
        com.alibaba.security.realidentity.a.b.a().a("RPPage", "ViewEnter", null, null, null, null);
        q.a(getWindow().getDecorView());
        a.C0165a.a.a = null;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            c cVar = this.g;
            if (cVar != null) {
                cVar.c(this.i);
                this.g.h();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
            hashMap.put("ua", this.g.f());
            TrackLog createSdkWebViewExitLog = TrackLog.createSdkWebViewExitLog();
            createSdkWebViewExitLog.setParams(h.a((Object) hashMap));
            g unused = g.a.a;
            g.a(this.m, createSdkWebViewExitLog);
            g unused2 = g.a.a;
            a.C0165a.a.a(false);
        } catch (Throwable th) {
            com.alibaba.security.common.c.a.d(b, th.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.g.a(g.a.a.d() ? c : d, this.a);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c cVar = this.g;
        if (cVar != null) {
            cVar.l();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            if (com.alibaba.security.common.d.a.c.a(this) || com.alibaba.security.common.d.a.c.b(this)) {
                if (i >= 21) {
                    getWindow().setStatusBarColor(-1);
                } else if (i >= 19) {
                    if (i >= 21) {
                        Window window = getWindow();
                        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(-1);
                        window.getDecorView().setSystemUiVisibility(0);
                        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
                        if (childAt != null) {
                            childAt.setFitsSystemWindows(false);
                            ViewCompat.requestApplyInsets(childAt);
                        }
                    } else if (i >= 19) {
                        Window window2 = getWindow();
                        window2.addFlags(ConfigReporter.BIT_GETTER_IMP);
                        View childAt2 = ((ViewGroup) window2.findViewById(16908290)).getChildAt(0);
                        int a = com.alibaba.security.common.d.a.a.a((Context) this);
                        com.alibaba.security.common.d.a.a.a((Activity) this);
                        View view = new View(this);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a);
                        layoutParams.gravity = 48;
                        view.setLayoutParams(layoutParams);
                        view.setBackgroundColor(-1);
                        view.setTag("statusBarView");
                        ((ViewGroup) getWindow().getDecorView()).addView(view);
                        if (childAt2 != null && !"marginAdded".equals(childAt2.getTag())) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                            layoutParams2.topMargin += a;
                            childAt2.setLayoutParams(layoutParams2);
                            childAt2.setTag("marginAdded");
                        }
                        if (childAt2 != null) {
                            childAt2.setFitsSystemWindows(false);
                        }
                    }
                }
            }
            if (i >= 23) {
                getWindow().setBackgroundDrawableResource(17170445);
                getWindow().getDecorView().setSystemUiVisibility(9216);
                getWindow().setStatusBarColor(-1);
                View childAt3 = ((ViewGroup) getWindow().findViewById(16908290)).getChildAt(0);
                if (childAt3 != null) {
                    childAt3.setFitsSystemWindows(true);
                    ViewCompat.requestApplyInsets(childAt3);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.j) {
            return;
        }
        b bVar = g.a.a.h;
        if (bVar != null) {
            bVar.onStart();
        }
        this.j = true;
    }

    private void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("ua", this.g.f());
        TrackLog createSdkWebViewExitLog = TrackLog.createSdkWebViewExitLog();
        createSdkWebViewExitLog.setParams(h.a((Object) hashMap));
        g unused = g.a.a;
        g.a(this.m, createSdkWebViewExitLog);
    }

    private void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog("WebView UserAgent is NULL", h.a((Object) hashMap), "WebView UserAgent is NULL");
        createSdkExceptionLog.setCode(-1);
        g unused = g.a.a;
        g.a(this.m, createSdkExceptionLog);
    }

    private void a(String str, String str2, String str3, String str4, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("url", str2);
        hashMap.put("ua", this.g.f());
        hashMap.put("request", str3);
        hashMap.put("error", str4);
        String a = h.a((Object) hashMap);
        TrackLog createSdkWebViewLoadLog = TrackLog.createSdkWebViewLoadLog(str, a, "{\"success\": " + z + "}");
        g unused = g.a.a;
        g.a(this.m, createSdkWebViewLoadLog);
    }

    static /* synthetic */ LastExitTrackMsg d(RPWebViewActivity rPWebViewActivity) {
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.H5.getMsg());
        lastExitTrackMsg.setView("");
        RPTrack.LastExitTrackParams lastExitTrackParams = new RPTrack.LastExitTrackParams();
        lastExitTrackParams.setUrl(rPWebViewActivity.g.d());
        lastExitTrackMsg.setParams(h.a(lastExitTrackParams));
        return lastExitTrackMsg;
    }

    private void a(String str, String str2, int i, String str3, Map<String, Boolean> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("url", str2);
        hashMap.put("ips", map);
        hashMap.put("errorCode", String.valueOf(i));
        hashMap.put("ua", this.g.f());
        hashMap.put(SocialConstants.PARAM_COMMENT, str3);
        TrackLog createSdkWebViewErrorLog = TrackLog.createSdkWebViewErrorLog(str, h.a((Object) hashMap), "{\"success\": false}");
        createSdkWebViewErrorLog.setCode(-1);
        g unused = g.a.a;
        g.a(this.m, createSdkWebViewErrorLog);
    }

    private void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("ua", this.g.f());
        TrackLog createSdkWebViewEnterLog = TrackLog.createSdkWebViewEnterLog(h.a((Object) hashMap));
        g unused = g.a.a;
        g.a(this.m, createSdkWebViewEnterLog);
    }

    private void a(String str) {
        ((RPTopBar) findViewById(R.id.topBar)).setTitle(str);
    }

    static /* synthetic */ void a(RPWebViewActivity rPWebViewActivity, String str, String str2, String str3, String str4, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("url", str2);
        hashMap.put("ua", rPWebViewActivity.g.f());
        hashMap.put("request", str3);
        hashMap.put("error", str4);
        String a = h.a((Object) hashMap);
        TrackLog createSdkWebViewLoadLog = TrackLog.createSdkWebViewLoadLog(str, a, "{\"success\": " + z + "}");
        g unused = g.a.a;
        g.a(rPWebViewActivity.m, createSdkWebViewLoadLog);
    }

    static /* synthetic */ void a(RPWebViewActivity rPWebViewActivity, String str, String str2, int i, String str3, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("windvane", Boolean.valueOf(g.a.a.d()));
        hashMap.put("url", str2);
        hashMap.put("ips", map);
        hashMap.put("errorCode", String.valueOf(i));
        hashMap.put("ua", rPWebViewActivity.g.f());
        hashMap.put(SocialConstants.PARAM_COMMENT, str3);
        TrackLog createSdkWebViewErrorLog = TrackLog.createSdkWebViewErrorLog(str, h.a((Object) hashMap), "{\"success\": false}");
        createSdkWebViewErrorLog.setCode(-1);
        g unused = g.a.a;
        g.a(rPWebViewActivity.m, createSdkWebViewErrorLog);
    }
}
