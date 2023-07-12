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
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.e;
import com.taobao.weex.bridge.WXBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d extends com.alipay.sdk.m.x.c implements e.f, e.g, e.h {
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
    public final com.alipay.sdk.m.s.a h;
    public boolean i;
    public com.alipay.sdk.m.x.e j;
    public com.alipay.sdk.m.x.f k;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b extends e {
        public final /* synthetic */ com.alipay.sdk.m.x.e a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.alipay.sdk.m.x.e eVar) {
            super(null);
            this.a = eVar;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.a();
            d.this.g = false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c extends e {
        public final /* synthetic */ com.alipay.sdk.m.x.e a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.alipay.sdk.m.x.e eVar, String str) {
            super(null);
            this.a = eVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.x.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.a);
            d.this.j.a(this.b);
            d.this.g = false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0205d implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ SslErrorHandler b;

        /* compiled from: Taobao */
        /* renamed from: com.alipay.sdk.m.x.d$d$a */
        /* loaded from: classes10.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC0205d.this.b.cancel();
                com.alipay.sdk.m.k.a.b(d.this.h, "net", com.alipay.sdk.m.k.b.A, "2");
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
                RunnableC0205d.this.a.finish();
            }
        }

        public RunnableC0205d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.a = activity;
            this.b = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.sdk.m.x.b.a(this.a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), null, null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class e implements Animation.AnimationListener {
        public e() {
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

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class g implements d.a {
        public final f a;
        public final String b;

        public g(f fVar, String str) {
            this.a = fVar;
            this.b = str;
        }

        @Override // com.alipay.sdk.m.j.d.a
        public void a(boolean z, JSONObject jSONObject, String str) {
            try {
                this.a.a(new JSONObject().put("success", z).put("random", this.b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, com.alipay.sdk.m.s.a aVar, String str) {
        super(activity, str);
        this.e = true;
        this.f = "GET";
        this.g = false;
        this.j = null;
        this.k = new com.alipay.sdk.m.x.f();
        this.h = aVar;
        g();
    }

    private synchronized boolean e() {
        if (this.k.b()) {
            this.a.finish();
        } else {
            this.g = true;
            com.alipay.sdk.m.x.e eVar = this.j;
            this.j = this.k.c();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new b(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.j);
        }
        return true;
    }

    private synchronized void f() {
        Activity activity = this.a;
        com.alipay.sdk.m.x.e eVar = this.j;
        if (activity != null && eVar != null) {
            if (this.e) {
                activity.finish();
            } else {
                eVar.a("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    private synchronized boolean g() {
        try {
            com.alipay.sdk.m.x.e eVar = new com.alipay.sdk.m.x.e(this.a, this.h, new e.C0207e(!a(), !a()));
            this.j = eVar;
            eVar.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            addView(this.j);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void h() {
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    private synchronized void i() {
        WebView webView = this.j.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            com.alipay.sdk.m.x.f fVar = this.k;
            if (fVar != null && !fVar.b()) {
                e();
            } else {
                a(false);
            }
        }
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void c() {
        this.j.a();
        this.k.a();
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean d(com.alipay.sdk.m.x.e eVar, String str) {
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "h5ld", SystemClock.elapsedRealtime() + "|" + n.i(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            h();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.g ? true : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized boolean b() {
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (a()) {
            com.alipay.sdk.m.x.e eVar = this.j;
            if (eVar != null && eVar.getWebView() != null) {
                if (eVar.getWebView().canGoBack()) {
                    if (d()) {
                        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b2.b(), b2.a(), ""));
                        activity.finish();
                    }
                } else {
                    com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
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

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized void c(com.alipay.sdk.m.x.e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.j.getTitle().setText(str);
        }
    }

    public boolean d() {
        return this.i;
    }

    private synchronized void a(boolean z2) {
        com.alipay.sdk.m.j.b.a(z2);
        this.a.finish();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f {
        public final WeakReference<com.alipay.sdk.m.x.e> a;
        public final String b;
        public final String c;
        public final JSONObject d;
        public boolean e = false;

        public f(com.alipay.sdk.m.x.e eVar, String str, String str2, JSONObject jSONObject) {
            this.a = new WeakReference<>(eVar);
            this.b = str;
            this.c = str2;
            this.d = jSONObject;
        }

        public void a(JSONObject jSONObject) {
            com.alipay.sdk.m.x.e eVar;
            if (this.e || (eVar = (com.alipay.sdk.m.x.e) n.a(this.a)) == null) {
                return;
            }
            this.e = true;
            eVar.a(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.c), a(jSONObject.toString())));
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }
    }

    @Override // com.alipay.sdk.m.x.c
    public synchronized void a(String str) {
        if ("POST".equals(this.f)) {
            this.j.a(str, (byte[]) null);
        } else {
            this.j.a(str);
        }
        com.alipay.sdk.m.x.c.a(this.j.getWebView());
    }

    @Override // com.alipay.sdk.m.x.e.f
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains(l)) {
            this.a.runOnUiThread(new a());
        }
        jsPromptResult.cancel();
        return true;
    }

    private synchronized boolean b(String str, String str2) {
        com.alipay.sdk.m.x.e eVar = this.j;
        try {
            com.alipay.sdk.m.x.e eVar2 = new com.alipay.sdk.m.x.e(this.a, this.h, new e.C0207e(!a(), !a()));
            this.j = eVar2;
            eVar2.setChromeProxy(this);
            this.j.setWebClientProxy(this);
            this.j.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.j.getTitle().setText(str2);
            }
            this.g = true;
            this.k.a(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new c(eVar, str));
            this.j.setAnimation(translateAnimation);
            addView(this.j);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        if (n.a(this.h, str, activity)) {
            return true;
        }
        if (str.startsWith(m)) {
            b(str.substring(17));
        } else if (TextUtils.equals(str, com.alipay.sdk.m.l.a.p)) {
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

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, int i, String str, String str2) {
        this.i = true;
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.b(aVar, "net", com.alipay.sdk.m.k.b.y, "onReceivedError:" + i + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean b(com.alipay.sdk.m.x.e eVar, String str) {
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "h5ldd", SystemClock.elapsedRealtime() + "|" + n.i(str));
        h();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.g
    public synchronized boolean a(com.alipay.sdk.m.x.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.a;
        if (activity == null) {
            return true;
        }
        com.alipay.sdk.m.s.a aVar = this.h;
        com.alipay.sdk.m.k.a.b(aVar, "net", com.alipay.sdk.m.k.b.z, "2-" + sslError);
        activity.runOnUiThread(new RunnableC0205d(activity, sslErrorHandler));
        return true;
    }

    private synchronized void b(String str) {
        Map<String, String> b2 = n.b(this.h, str);
        if (str.startsWith(t)) {
            a(b2.get("func"), b2.get("cbId"), b2.get("data"));
        } else if (str.startsWith(n)) {
            i();
        } else if (str.startsWith("setTitle") && b2.containsKey("title")) {
            this.j.getTitle().setText(b2.get("title"));
        } else if (str.startsWith(p)) {
            this.j.getWebView().reload();
        } else if (str.startsWith("showBackButton") && b2.containsKey("bshow")) {
            this.j.getBackButton().setVisibility(TextUtils.equals("true", b2.get("bshow")) ? 0 : 4);
        } else if (str.startsWith(r)) {
            com.alipay.sdk.m.j.b.a(b2.get("result"));
            a(TextUtils.equals("true", b2.get("bsucc")));
        } else if (str.startsWith(s)) {
            this.j.a("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    private synchronized void a(String str, String str2, String str3) {
        com.alipay.sdk.m.x.e eVar = this.j;
        if (eVar == null) {
            return;
        }
        JSONObject h = n.h(str3);
        f fVar = new f(eVar, str, str2, h);
        Context context = eVar.getContext();
        String str4 = fVar.b;
        char c2 = 65535;
        switch (str4.hashCode()) {
            case -1785164386:
                if (str4.equals(E)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -552487705:
                if (str4.equals(F)) {
                    c2 = '\t';
                    break;
                }
                break;
            case 3015911:
                if (str4.equals("back")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3127582:
                if (str4.equals("exit")) {
                    c2 = 3;
                    break;
                }
                break;
            case 110371416:
                if (str4.equals("title")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1085444827:
                if (str4.equals("refresh")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1703426986:
                if (str4.equals("pushWindow")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1906413305:
                if (str4.equals(x)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1947723784:
                if (str4.equals(D)) {
                    c2 = 7;
                    break;
                }
                break;
            case 2033767917:
                if (str4.equals(y)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (h.has("title")) {
                    eVar.getTitle().setText(h.optString("title", ""));
                    break;
                }
                break;
            case 1:
                eVar.getWebView().reload();
                break;
            case 2:
                i();
                break;
            case 3:
                com.alipay.sdk.m.j.b.a(h.optString("result", null));
                a(h.optBoolean("success", false));
                break;
            case 4:
                eVar.getBackButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                break;
            case 5:
                eVar.getRefreshButton().setVisibility(h.optBoolean("show", true) ? 0 : 4);
                break;
            case 6:
                b(h.optString("url"), h.optString("title", ""));
                break;
            case 7:
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "15.8.11");
                jSONObject.put("app_name", this.h.b());
                jSONObject.put("app_version", this.h.c());
                fVar.a(jSONObject);
                break;
            case '\b':
                String url = eVar.getUrl();
                if (!n.a(this.h, url)) {
                    com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url);
                    break;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    boolean a2 = com.alipay.sdk.m.j.d.a(this.h, context);
                    jSONObject2.put(ConfigManager.q, a2);
                    com.alipay.sdk.m.k.a.a(this.h, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.t0, String.valueOf(a2));
                    fVar.a(jSONObject2);
                    break;
                }
            case '\t':
                String url2 = eVar.getUrl();
                if (!n.a(this.h, url2)) {
                    com.alipay.sdk.m.k.a.b(this.h, com.alipay.sdk.m.k.b.l, "jsUrlErr", url2);
                    break;
                } else {
                    String optString = h.optString("random");
                    JSONObject optJSONObject = h.optJSONObject(WXBridgeManager.OPTIONS);
                    if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                        String optString2 = optJSONObject.optString("url");
                        String optString3 = optJSONObject.optString("action");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                            com.alipay.sdk.m.j.d.a(this.h, (Activity) context, 1010, optString2, optString3, new g(fVar, optString));
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void b(com.alipay.sdk.m.x.e eVar) {
        f();
    }

    @Override // com.alipay.sdk.m.x.e.h
    public synchronized void a(com.alipay.sdk.m.x.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }
}
