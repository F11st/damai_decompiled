package com.alipay.sdk.m.x;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.j.C4214d;
import com.alipay.sdk.m.j.EnumC4213c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4318n;
import com.alipay.sdk.m.x.C4354e;
import com.taobao.weex.bridge.WXBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.x.d */
/* loaded from: classes10.dex */
public class C4345d extends AbstractC4344c implements C4354e.InterfaceC4361f, C4354e.InterfaceC4362g, C4354e.InterfaceC4363h {
    public static final String A = "action";
    public static final String B = "pushWindow";
    public static final String C = "h5JsFuncCallback";
    public static final String D = "sdkInfo";
    public static final String E = "canUseTaoLogin";
    public static final String F = "taoLogin";
    public static final String l = "sdk_result_code:";
    public static final String m = "alipayjsbridge://";
    public static final String n = "onBack";
    public static final String o = "setTitle";
    public static final String p = "onRefresh";
    public static final String q = "showBackButton";
    public static final String r = "onExit";
    public static final String s = "onLoadJs";
    public static final String t = "callNativeFunc";
    public static final String u = "back";
    public static final String v = "title";
    public static final String w = "refresh";
    public static final String x = "backButton";
    public static final String y = "refreshButton";
    public static final String z = "exit";
    public boolean e;
    public String f;
    public boolean g;
    public final C4293a h;
    public boolean i;
    public C4354e j;
    public C4364f k;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$a */
    /* loaded from: classes10.dex */
    public class RunnableC4346a implements Runnable {
        public RunnableC4346a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4345d.this.a.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$b */
    /* loaded from: classes10.dex */
    public class C4347b extends AbstractanimationAnimation$AnimationListenerC4351e {
        public final /* synthetic */ C4354e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4347b(C4354e c4354e) {
            super(null);
            this.a = c4354e;
        }

        @Override // com.alipay.sdk.m.x.C4345d.AbstractanimationAnimation$AnimationListenerC4351e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.a();
            C4345d.this.g = false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$c */
    /* loaded from: classes10.dex */
    public class C4348c extends AbstractanimationAnimation$AnimationListenerC4351e {
        public final /* synthetic */ C4354e a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C4348c(C4354e c4354e, String str) {
            super(null);
            this.a = c4354e;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.x.C4345d.AbstractanimationAnimation$AnimationListenerC4351e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C4345d.this.removeView(this.a);
            C4345d.this.j.a(this.b);
            C4345d.this.g = false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$d */
    /* loaded from: classes10.dex */
    public class RunnableC4349d implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ SslErrorHandler b;

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.x.d$d$a */
        /* loaded from: classes10.dex */
        public class DialogInterface$OnClickListenerC4350a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC4350a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC4349d.this.b.cancel();
                C4218a.b(C4345d.this.h, "net", C4226b.A, "2");
                C4212b.a(C4212b.a());
                RunnableC4349d.this.a.finish();
            }
        }

        public RunnableC4349d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.a = activity;
            this.b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4342b.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new DialogInterface$OnClickListenerC4350a(), null, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$e  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractanimationAnimation$AnimationListenerC4351e implements Animation.AnimationListener {
        public AbstractanimationAnimation$AnimationListenerC4351e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ AbstractanimationAnimation$AnimationListenerC4351e(RunnableC4346a runnableC4346a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$g */
    /* loaded from: classes10.dex */
    public static class C4353g implements C4214d.InterfaceC4215a {
        public final C4352f a;
        public final String b;

        public C4353g(C4352f c4352f, String str) {
            this.a = c4352f;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.j.C4214d.InterfaceC4215a
        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.a.a(new JSONObject().put("success", z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public C4345d(Activity activity, C4293a c4293a, String str) {
        super(activity, str);
        this.e = true;
        this.f = "GET";
        this.g = false;
        this.j = null;
        this.k = new C4364f();
        this.h = c4293a;
        g();
    }

    private synchronized boolean e() {
        if (this.k.b()) {
            this.a.finish();
        } else {
            this.g = true;
            C4354e c4354e = this.j;
            this.j = this.k.c();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C4347b(c4354e));
            c4354e.setAnimation(translateAnimation);
            removeView(c4354e);
            addView(this.j);
        }
        return true;
    }

    private synchronized void f() {
        Activity activity = this.a;
        C4354e c4354e = this.j;
        if (activity != null && c4354e != null) {
            if (this.e) {
                activity.finish();
            } else {
                c4354e.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    private synchronized boolean g() {
        try {
            C4354e c4354e = new C4354e(this.a, this.h, new C4354e.C4360e(!a(), !a()));
            this.j = c4354e;
            c4354e.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            addView(this.j);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void h() {
        C4354e c4354e = this.j;
        if (c4354e != null) {
            c4354e.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void i() {
        WebView webView = this.j.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            C4364f c4364f = this.k;
            if (c4364f != null && !c4364f.b()) {
                e();
            } else {
                a(false);
            }
        }
    }

    @Override // com.alipay.sdk.m.x.AbstractC4344c
    public synchronized void c() {
        this.j.a();
        this.k.a();
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4362g
    public synchronized boolean d(C4354e c4354e, String str) {
        C4293a c4293a = this.h;
        C4218a.a(c4293a, C4226b.l, "h5ld", SystemClock.elapsedRealtime() + "|" + C4318n.i(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            h();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.alipay.sdk.m.x.AbstractC4344c
    public synchronized boolean b() {
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (a()) {
            C4354e c4354e = this.j;
            if (c4354e != null && c4354e.getWebView() != null) {
                if (c4354e.getWebView().canGoBack()) {
                    if (d()) {
                        EnumC4213c b = EnumC4213c.b(EnumC4213c.NETWORK_ERROR.b());
                        C4212b.a(C4212b.a(b.b(), b.a(), ""));
                        activity.finish();
                    }
                } else {
                    C4212b.a(C4212b.a());
                    activity.finish();
                }
                return true;
            }
            activity.finish();
            return true;
        }
        if (!this.g) {
            f();
        }
        return true;
    }

    public synchronized void a(String str, String str2, boolean z2) {
        this.f = str2;
        this.j.getTitle().setText(str);
        this.e = z2;
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4361f
    public synchronized void c(C4354e c4354e, String str) {
        if (!str.startsWith("http") && !c4354e.getUrl().endsWith(str)) {
            this.j.getTitle().setText(str);
        }
    }

    public boolean d() {
        return this.i;
    }

    private synchronized void a(boolean z2) {
        C4212b.a(z2);
        this.a.finish();
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$f */
    /* loaded from: classes10.dex */
    public static class C4352f {
        public final WeakReference<C4354e> a;
        public final String b;
        public final String c;
        public final JSONObject d;
        public boolean e = false;

        public C4352f(C4354e c4354e, String str, String str2, JSONObject jSONObject) {
            this.a = new WeakReference<>(c4354e);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            C4354e c4354e;
            if (this.e || (c4354e = (C4354e) C4318n.a(this.a)) == null) {
                return;
            }
            this.e = true;
            c4354e.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.c), a(jSONObject.toString())));
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }
    }

    @Override // com.alipay.sdk.m.x.AbstractC4344c
    public synchronized void a(String str) {
        if ("POST".equals(this.f)) {
            this.j.a(str, (byte[]) null);
        } else {
            this.j.a(str);
        }
        AbstractC4344c.a(this.j.getWebView());
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4361f
    public synchronized boolean a(C4354e c4354e, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(l)) {
            this.a.runOnUiThread(new RunnableC4346a());
        }
        jsPromptResult.cancel();
        return true;
    }

    private synchronized boolean b(String str, String str2) {
        C4354e c4354e = this.j;
        try {
            C4354e c4354e2 = new C4354e(this.a, this.h, new C4354e.C4360e(!a(), !a()));
            this.j = c4354e2;
            c4354e2.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.j.getTitle().setText(str2);
            }
            this.g = true;
            this.k.a(c4354e);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C4348c(c4354e, str));
            this.j.setAnimation(translateAnimation);
            addView(this.j);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4362g
    public synchronized boolean a(C4354e c4354e, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (C4318n.a(this.h, str, activity)) {
            return true;
        }
        if (str.startsWith(m)) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, C4230a.p)) {
            a(false);
        } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } else {
            this.j.a(str);
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4362g
    public synchronized boolean a(C4354e c4354e, int i, String str, String str2) {
        this.i = true;
        C4293a c4293a = this.h;
        C4218a.b(c4293a, "net", C4226b.y, "onReceivedError:" + i + "|" + str2);
        c4354e.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4362g
    public synchronized boolean b(C4354e c4354e, String str) {
        C4293a c4293a = this.h;
        C4218a.a(c4293a, C4226b.l, "h5ldd", SystemClock.elapsedRealtime() + "|" + C4318n.i(str));
        h();
        c4354e.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4362g
    public synchronized boolean a(C4354e c4354e, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        C4293a c4293a = this.h;
        C4218a.b(c4293a, "net", C4226b.z, "2-" + sslError);
        activity.runOnUiThread(new RunnableC4349d(activity, sslErrorHandler));
        return true;
    }

    private synchronized void b(String str) {
        Map<String, String> b = C4318n.b(this.h, str);
        if (str.startsWith(t)) {
            a(b.get("func"), b.get("cbId"), b.get("data"));
        } else if (str.startsWith(n)) {
            i();
        } else if (str.startsWith("setTitle") && b.containsKey("title")) {
            this.j.getTitle().setText(b.get("title"));
        } else if (str.startsWith(p)) {
            this.j.getWebView().reload();
        } else if (str.startsWith("showBackButton") && b.containsKey("bshow")) {
            this.j.getBackButton().setVisibility(TextUtils.equals("true", b.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(r)) {
            C4212b.a(b.get("result"));
            a(TextUtils.equals("true", b.get("bsucc")));
        } else if (str.startsWith(s)) {
            this.j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private synchronized void a(String str, String str2, String str3) {
        C4354e c4354e = this.j;
        if (c4354e == null) {
            return;
        }
        JSONObject h = C4318n.h(str3);
        C4352f c4352f = new C4352f(c4354e, str, str2, h);
        Context context = c4354e.getContext();
        String str4 = c4352f.b;
        char c = 65535;
        switch (str4.hashCode()) {
            case -1785164386:
                if (str4.equals(E)) {
                    c = '\b';
                    break;
                }
                break;
            case -552487705:
                if (str4.equals(F)) {
                    c = '\t';
                    break;
                }
                break;
            case 3015911:
                if (str4.equals("back")) {
                    c = 2;
                    break;
                }
                break;
            case 3127582:
                if (str4.equals("exit")) {
                    c = 3;
                    break;
                }
                break;
            case 110371416:
                if (str4.equals("title")) {
                    c = 0;
                    break;
                }
                break;
            case 1085444827:
                if (str4.equals("refresh")) {
                    c = 1;
                    break;
                }
                break;
            case 1703426986:
                if (str4.equals("pushWindow")) {
                    c = 6;
                    break;
                }
                break;
            case 1906413305:
                if (str4.equals(x)) {
                    c = 4;
                    break;
                }
                break;
            case 1947723784:
                if (str4.equals(D)) {
                    c = 7;
                    break;
                }
                break;
            case 2033767917:
                if (str4.equals(y)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (h.has("title")) {
                    c4354e.getTitle().setText(h.optString("title", ""));
                    break;
                }
                break;
            case 1:
                c4354e.getWebView().reload();
                break;
            case 2:
                i();
                break;
            case 3:
                C4212b.a(h.optString("result", null));
                a(h.optBoolean("success", false));
                break;
            case 4:
                c4354e.getBackButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                break;
            case 5:
                c4354e.getRefreshButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                break;
            case 6:
                b(h.optString("url"), h.optString("title", ""));
                break;
            case 7:
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "15.8.11");
                jSONObject.put("app_name", this.h.b());
                jSONObject.put("app_version", this.h.c());
                c4352f.a(jSONObject);
                break;
            case '\b':
                String url = c4354e.getUrl();
                if (!C4318n.a(this.h, url)) {
                    C4218a.b(this.h, C4226b.l, "jsUrlErr", url);
                    break;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    boolean a = C4214d.a(this.h, context);
                    jSONObject2.put(ConfigManager.q, a);
                    C4218a.a(this.h, C4226b.l, C4226b.t0, String.valueOf(a));
                    c4352f.a(jSONObject2);
                    break;
                }
            case '\t':
                String url2 = c4354e.getUrl();
                if (!C4318n.a(this.h, url2)) {
                    C4218a.b(this.h, C4226b.l, "jsUrlErr", url2);
                    break;
                } else {
                    String optString = h.optString("random");
                    JSONObject optJSONObject = h.optJSONObject(WXBridgeManager.OPTIONS);
                    if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                        String optString2 = optJSONObject.optString("url");
                        String optString3 = optJSONObject.optString("action");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                            C4214d.a(this.h, (Activity) context, 1010, optString2, optString3, new C4353g(c4352f, optString));
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4363h
    public synchronized void b(C4354e c4354e) {
        f();
    }

    @Override // com.alipay.sdk.m.x.C4354e.InterfaceC4363h
    public synchronized void a(C4354e c4354e) {
        c4354e.getWebView().reload();
        c4354e.getRefreshButton().setVisibility(4);
    }
}
