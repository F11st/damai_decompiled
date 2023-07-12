package android.taobao.windvane.jsbridge.api;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.jsbridge.IJsApiFailedCallBack;
import android.taobao.windvane.jsbridge.IJsApiSucceedCallBack;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVWebView;
import android.text.TextUtils;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVBase extends WVApiPlugin {
    private void copyToClipboard(WVCallBackContext wVCallBackContext, String str) {
        String str2 = "HY_PARAM_ERR";
        WVResult wVResult = new WVResult("HY_PARAM_ERR");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("text")) {
                    String string = jSONObject.getString("text");
                    if (Build.VERSION.SDK_INT >= 11) {
                        ((ClipboardManager) this.mWebView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(string, string));
                        WVResult wVResult2 = new WVResult(WVResult.SUCCESS);
                        try {
                            wVCallBackContext.success(wVResult2);
                            return;
                        } catch (JSONException e) {
                            e = e;
                            wVResult = wVResult2;
                            e.printStackTrace();
                            wVResult.addData("msg", str2);
                            wVCallBackContext.error(wVResult);
                        }
                    }
                    wVResult = new WVResult("HY_FAILED");
                    str2 = "HY_FAILED";
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        wVResult.addData("msg", str2);
        wVCallBackContext.error(wVResult);
    }

    public void addTailJSBridge(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(PushClientConstants.TAG_CLASS_NAME);
            String string2 = jSONObject.getString("handlerName");
            String string3 = jSONObject.getString("params");
            WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
            wVCallMethodContext.objectName = string;
            wVCallMethodContext.methodName = string2;
            wVCallMethodContext.params = string3;
            wVCallMethodContext.webview = this.mWebView;
            wVCallMethodContext.succeedCallBack = new IJsApiSucceedCallBack() { // from class: android.taobao.windvane.jsbridge.api.WVBase.1
                @Override // android.taobao.windvane.jsbridge.IJsApiSucceedCallBack
                public void succeed(String str2) {
                }
            };
            wVCallMethodContext.failedCallBack = new IJsApiFailedCallBack() { // from class: android.taobao.windvane.jsbridge.api.WVBase.2
                @Override // android.taobao.windvane.jsbridge.IJsApiFailedCallBack
                public void fail(String str2) {
                }
            };
            if (WVJsBridge.getInstance().mTailBridges == null) {
                WVJsBridge.getInstance().mTailBridges = new ArrayList<>();
            }
            WVJsBridge.getInstance().mTailBridges.add(wVCallMethodContext);
            TaoLog.i(WVAPI.PluginName.API_BASE, "addTailJSBridge : " + str);
        } catch (Exception unused) {
        }
    }

    public void checkPermissions(WVCallBackContext wVCallBackContext, String str) {
        try {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("permissions");
                if (jSONArray.length() < 1) {
                    wVCallBackContext.error("HY_PARAM_ERR");
                    return;
                }
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = (String) jSONArray.get(i);
                }
                Map<String, String> checkPermissions = PermissionChecker.checkPermissions(this.mContext, strArr);
                if (checkPermissions != null && checkPermissions.size() > 0) {
                    WVResult wVResult = new WVResult(WVResult.SUCCESS);
                    wVResult.addData("result", new JSONObject(checkPermissions));
                    wVCallBackContext.success(wVResult);
                    return;
                }
                wVCallBackContext.error(new WVResult("HY_FAILED"));
            } catch (JSONException e) {
                e.printStackTrace();
                WVResult wVResult2 = new WVResult("HY_PARAM_ERR");
                wVResult2.addData("reason", "JSONException: " + e);
                wVCallBackContext.error(wVResult2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            WVResult wVResult3 = new WVResult("HY_PARAM_ERR");
            wVResult3.addData("reason", "JSONException: " + e2);
            wVCallBackContext.error(wVResult3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void commitUTEvent(android.taobao.windvane.jsbridge.WVCallBackContext r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64
            r4.<init>(r1)     // Catch: org.json.JSONException -> L64
            java.lang.String r5 = "eventId"
            int r5 = r4.getInt(r5)     // Catch: org.json.JSONException -> L64
            java.lang.String r6 = "arg1"
            java.lang.String r6 = r4.getString(r6)     // Catch: org.json.JSONException -> L64
            java.lang.String r7 = "arg2"
            java.lang.String r7 = r4.getString(r7)     // Catch: org.json.JSONException -> L64
            java.lang.String r8 = "arg3"
            java.lang.String r8 = r4.getString(r8)     // Catch: org.json.JSONException -> L64
            java.lang.String r9 = "args"
            org.json.JSONObject r4 = r4.getJSONObject(r9)     // Catch: org.json.JSONException -> L64
            r9 = 0
            if (r4 == 0) goto L59
            int r9 = r4.length()     // Catch: org.json.JSONException -> L64
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: org.json.JSONException -> L64
            java.util.Iterator r10 = r4.keys()     // Catch: org.json.JSONException -> L64
            r11 = 0
        L37:
            boolean r12 = r10.hasNext()     // Catch: org.json.JSONException -> L64
            if (r12 == 0) goto L59
            java.lang.Object r12 = r10.next()     // Catch: org.json.JSONException -> L64
            java.lang.String r12 = (java.lang.String) r12     // Catch: org.json.JSONException -> L64
            java.lang.String r13 = r4.getString(r12)     // Catch: org.json.JSONException -> L64
            java.lang.String r14 = "%s=%s"
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch: org.json.JSONException -> L64
            r15[r3] = r12     // Catch: org.json.JSONException -> L64
            r15[r2] = r13     // Catch: org.json.JSONException -> L64
            java.lang.String r12 = java.lang.String.format(r14, r15)     // Catch: org.json.JSONException -> L64
            r9[r11] = r12     // Catch: org.json.JSONException -> L64
            int r11 = r11 + 1
            goto L37
        L59:
            r4 = 64403(0xfb93, float:9.0248E-41)
            if (r4 != r5) goto L64
            android.taobao.windvane.monitor.UserTrackUtil.commitEvent(r5, r6, r7, r8, r9)     // Catch: org.json.JSONException -> L62
            goto L65
        L62:
            goto L65
        L64:
            r2 = 0
        L65:
            android.taobao.windvane.jsbridge.WVResult r3 = new android.taobao.windvane.jsbridge.WVResult
            r3.<init>()
            java.lang.String r4 = "Base"
            if (r2 == 0) goto L8c
            r0.success(r3)
            boolean r0 = android.taobao.windvane.util.TaoLog.getLogStatus()
            if (r0 == 0) goto La8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "commitUTEvent: param="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.taobao.windvane.util.TaoLog.d(r4, r0)
            goto La8
        L8c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "commitUTEvent: parameter error, param="
            r2.append(r5)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.taobao.windvane.util.TaoLog.e(r4, r1)
            java.lang.String r1 = "HY_PARAM_ERR"
            r3.setResult(r1)
            r0.error(r3)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVBase.commitUTEvent(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("isWindVaneSDK".equals(str)) {
            isWindVaneSDK(wVCallBackContext, str2);
            return true;
        } else if ("plusUT".equals(str)) {
            plusUT(wVCallBackContext, str2);
            return true;
        } else if ("commitUTEvent".equals(str)) {
            commitUTEvent(wVCallBackContext, str2);
            return true;
        } else if ("isInstall".equals(str)) {
            isInstall(wVCallBackContext, str2);
            return true;
        } else if ("isAppsInstalled".equals(str)) {
            isAppsInstalled(wVCallBackContext, str2);
            return true;
        } else if ("copyToClipboard".equals(str)) {
            copyToClipboard(wVCallBackContext, str2);
            return true;
        } else if ("addTailJSBridge".equals(str)) {
            addTailJSBridge(wVCallBackContext, str2);
            return true;
        } else if ("checkPermissions".equals(str)) {
            checkPermissions(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    public void isAppsInstalled(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            WVResult wVResult = new WVResult();
            PackageManager packageManager = this.mWebView.getContext().getPackageManager();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    PackageInfo packageInfo = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(jSONObject.getJSONObject(next).optString("android"), 0);
                    } catch (Exception unused) {
                    }
                    wVResult.addData(next, packageInfo == null ? "0" : "1");
                } catch (JSONException e) {
                    e.printStackTrace();
                    wVResult.addData(next, "0");
                }
            }
            wVResult.setSuccess();
            wVCallBackContext.success(wVResult);
        } catch (JSONException e2) {
            e2.printStackTrace();
            wVCallBackContext.error();
        }
    }

    public void isInstall(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).getString("android");
        } catch (JSONException unused) {
            TaoLog.e(WVAPI.PluginName.API_BASE, "isInstall parse params error, params: " + str);
            str2 = null;
        }
        WVResult wVResult = new WVResult();
        boolean isAppInstalled = CommonUtils.isAppInstalled(this.mWebView.getContext(), str2);
        if (TaoLog.getLogStatus()) {
            TaoLog.d(WVAPI.PluginName.API_BASE, "isInstall " + isAppInstalled + " for package " + str2);
        }
        if (isAppInstalled) {
            wVCallBackContext.success(wVResult);
        } else {
            wVCallBackContext.error(wVResult);
        }
    }

    public void isWindVaneSDK(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        WVResult wVResult = new WVResult();
        wVResult.addData("os", "android");
        wVResult.addData("version", GlobalConfig.VERSION);
        wVResult.addData("debug", Boolean.valueOf(EnvUtil.isAppDebug()));
        if (TaoLog.getLogStatus()) {
            TaoLog.d(WVAPI.PluginName.API_BASE, "isWindVaneSDK: version=8.5.0");
        }
        if (EnvEnum.DAILY.equals(GlobalConfig.env)) {
            str2 = "daily";
        } else {
            str2 = EnvEnum.PRE.equals(GlobalConfig.env) ? "pre" : "release";
        }
        wVResult.addData("env", str2);
        wVResult.addData("container", this.mWebView instanceof WVWebView ? "WVWebView" : "WVUCWebView");
        wVCallBackContext.success(wVResult);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void plusUT(android.taobao.windvane.jsbridge.WVCallBackContext r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "args"
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L72
            r5.<init>(r1)     // Catch: org.json.JSONException -> L72
            java.lang.String r6 = "eid"
            int r6 = r5.getInt(r6)     // Catch: org.json.JSONException -> L72
            java.lang.String r7 = "a1"
            java.lang.String r7 = r5.getString(r7)     // Catch: org.json.JSONException -> L72
            java.lang.String r8 = "a2"
            java.lang.String r8 = r5.getString(r8)     // Catch: org.json.JSONException -> L72
            java.lang.String r9 = "a3"
            java.lang.String r9 = r5.getString(r9)     // Catch: org.json.JSONException -> L72
            java.lang.String[] r10 = new java.lang.String[r4]     // Catch: org.json.JSONException -> L72
            boolean r11 = r5.has(r2)     // Catch: org.json.JSONException -> L72
            if (r11 == 0) goto L60
            org.json.JSONObject r2 = r5.getJSONObject(r2)     // Catch: org.json.JSONException -> L72
            if (r2 == 0) goto L60
            int r5 = r2.length()     // Catch: org.json.JSONException -> L72
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch: org.json.JSONException -> L72
            java.util.Iterator r5 = r2.keys()     // Catch: org.json.JSONException -> L72
            r11 = 0
        L3e:
            boolean r12 = r5.hasNext()     // Catch: org.json.JSONException -> L72
            if (r12 == 0) goto L60
            java.lang.Object r12 = r5.next()     // Catch: org.json.JSONException -> L72
            java.lang.String r12 = (java.lang.String) r12     // Catch: org.json.JSONException -> L72
            java.lang.String r13 = r2.getString(r12)     // Catch: org.json.JSONException -> L72
            java.lang.String r14 = "%s=%s"
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch: org.json.JSONException -> L72
            r15[r4] = r12     // Catch: org.json.JSONException -> L72
            r15[r3] = r13     // Catch: org.json.JSONException -> L72
            java.lang.String r12 = java.lang.String.format(r14, r15)     // Catch: org.json.JSONException -> L72
            r10[r11] = r12     // Catch: org.json.JSONException -> L72
            int r11 = r11 + 1
            goto L3e
        L60:
            r2 = 9100(0x238c, float:1.2752E-41)
            if (r6 < r2) goto L68
            r2 = 9200(0x23f0, float:1.2892E-41)
            if (r6 < r2) goto L6c
        L68:
            r2 = 19999(0x4e1f, float:2.8025E-41)
            if (r6 != r2) goto L72
        L6c:
            android.taobao.windvane.monitor.UserTrackUtil.commitEvent(r6, r7, r8, r9, r10)     // Catch: org.json.JSONException -> L70
            goto L73
        L70:
            goto L73
        L72:
            r3 = 0
        L73:
            android.taobao.windvane.jsbridge.WVResult r2 = new android.taobao.windvane.jsbridge.WVResult
            r2.<init>()
            java.lang.String r4 = "Base"
            if (r3 == 0) goto L9b
            r0.success(r2)
            boolean r0 = android.taobao.windvane.util.TaoLog.getLogStatus()
            if (r0 == 0) goto Lb8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "plusUT: param="
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.taobao.windvane.util.TaoLog.d(r4, r0)
            goto Lb8
        L9b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "plusUT: parameter error, param="
            r3.append(r5)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.taobao.windvane.util.TaoLog.e(r4, r1)
            java.lang.String r1 = "HY_PARAM_ERR"
            r2.setResult(r1)
            r0.error(r2)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVBase.plusUT(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }
}
