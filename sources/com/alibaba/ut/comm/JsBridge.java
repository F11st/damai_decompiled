package com.alibaba.ut.comm;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.ut.IWebView;
import com.taobao.weex.bridge.WXBridgeManager;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;
import tb.ks2;
import tb.mb1;
import tb.ms2;
import tb.pr2;
import tb.qj2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class JsBridge {
    private IWebView a;

    public JsBridge(IWebView iWebView) {
        this.a = null;
        this.a = iWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (window.Aplus4UT && window.");
        sb.append(str);
        sb.append(") { window.");
        sb.append(str);
        sb.append(jn1.BRACKET_START_STR);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'");
                sb.append(strArr[i]);
                sb.append("'");
                if (i < strArr.length - 1) {
                    sb.append(',');
                }
            }
        }
        sb.append(");}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jn1.BRACKET_START_STR);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                sb.append("'");
                sb.append(strArr[i]);
                sb.append("'");
                if (i < strArr.length - 1) {
                    sb.append(',');
                }
            }
        }
        sb.append(");");
        return sb.toString();
    }

    private void e(String str, String[] strArr) {
        g(this.a, str, strArr);
    }

    public static void g(final IWebView iWebView, final String str, final String[] strArr) {
        iWebView.post(new Runnable() { // from class: com.alibaba.ut.comm.JsBridge.1
            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                String str2;
                try {
                    String c = str.contains("Aplus4UT") ? JsBridge.c(str, strArr) : JsBridge.d(str, strArr);
                    try {
                        mb1.h("js:", c);
                        iWebView.evaluateJavascript(c, null);
                    } catch (Throwable th) {
                        str2 = c;
                        th = th;
                        mb1.j(null, th, "native to js", str2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                }
            }
        });
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void CALL(String str) {
        Object obj;
        mb1.k("p", str);
        mb1.k("wmg_test", str);
        if (TextUtils.isEmpty(str)) {
            mb1.k("p", str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("methodName");
            String optString2 = jSONObject.optString("params");
            String optString3 = jSONObject.optString(WXBridgeManager.METHOD_CALLBACK);
            String optString4 = jSONObject.optString("sid");
            String str2 = "0";
            String str3 = "SUCCESS";
            try {
                obj = f(this.a.getContext(), null, optString, optString2);
            } catch (Exception e) {
                str2 = "1";
                str3 = e.toString();
                mb1.j(null, e, new Object[0]);
                obj = null;
            }
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (obj == null) {
                obj = "";
            }
            jSONObject2.put("result", obj);
            jSONObject2.put("code", str2);
            jSONObject2.put("msg", str3);
            e(optString3, new String[]{optString4, jSONObject2.toString()});
        } catch (JSONException e2) {
            mb1.j(null, e2, new Object[0]);
        }
    }

    @JavascriptInterface
    public String UTEnv() {
        IWebView iWebView = this.a;
        return iWebView == null ? "default" : iWebView instanceof qj2 ? C3834a.C3837c.d : iWebView instanceof pr2 ? "ucwebview" : "iwebview";
    }

    @JavascriptInterface
    public String bridgeVersion() {
        return ks2.SDK_VERSION;
    }

    public Object f(Context context, String str, String str2, String str3) throws Exception {
        if (str2.equalsIgnoreCase("pageAppear")) {
            ms2.j(context, str3);
        } else if (str2.equalsIgnoreCase("pageDisAppear")) {
            ms2.k(context, str3);
        } else if (str2.equalsIgnoreCase("updatePageProperties")) {
            ms2.t(context, str3);
            return Boolean.TRUE;
        } else if (str2.equalsIgnoreCase("updatePageUtparam")) {
            ms2.v(context, str3);
        } else if (str2.equalsIgnoreCase("updateNextPageUtparam")) {
            ms2.r(str3);
        } else if (str2.equalsIgnoreCase("updateNextPageProperties")) {
            ms2.q(str3);
        } else if (str2.equalsIgnoreCase("getParam")) {
            return ms2.g();
        } else {
            if (str2.equalsIgnoreCase("getDeviceInfo")) {
                return ms2.d();
            }
            if (str2.equalsIgnoreCase("setAplusParams")) {
                ms2.n(context.hashCode() + "", str3);
            } else if (str2.equalsIgnoreCase("getAplusParams")) {
                return ms2.c(context.hashCode() + "");
            } else if (str2.equalsIgnoreCase("removeAplusParams")) {
                ms2.l(context.hashCode() + "");
            } else if (str2.equalsIgnoreCase("utCustomEvent")) {
                ms2.z(str3);
            } else if (str2.equalsIgnoreCase("getPageSpmUrl")) {
                return ms2.f(context);
            } else {
                if (str2.equalsIgnoreCase("getPageSpmPre")) {
                    return ms2.e(context);
                }
                if (str2.equalsIgnoreCase("updatePageURL")) {
                    ms2.u(context, str3);
                } else if (str2.equalsIgnoreCase("updatePageName")) {
                    ms2.s(context, str3);
                } else if (str2.equalsIgnoreCase("turnOnRealtimeDebug")) {
                    ms2.p(str3);
                } else if (str2.equalsIgnoreCase("userRegister")) {
                    ms2.y(str3);
                } else if (str2.equalsIgnoreCase("updateUserAccount")) {
                    ms2.x(str3);
                } else if (str2.equalsIgnoreCase("addTPKItem")) {
                    ms2.b(str3);
                } else if (str2.equalsIgnoreCase("updateSessionProperties")) {
                    ms2.w(str3);
                } else if (str2.equalsIgnoreCase("setGlobalProperty")) {
                    ms2.o(str3);
                } else if (str2.equalsIgnoreCase("setAplus4UT")) {
                    ms2.m(context);
                }
            }
        }
        return null;
    }

    @JavascriptInterface
    public void onPageShow() {
    }
}
