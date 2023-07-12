package com.ali.user.open.core.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.MemberExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BridgeCallbackContext {
    public int requestId;
    public WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(String str) {
        WebView webView = this.webView;
        if (webView == null) {
            return;
        }
        webView.getSettings().setSavePassword(false);
        this.webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatJsonString(String str) {
        return str.replace("\\", "\\\\");
    }

    public Activity getActivity() {
        return (Activity) this.webView.getContext();
    }

    public void onFailure(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            onFailure(jSONObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void success(final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.core.webview.BridgeCallbackContext.1
            @Override // java.lang.Runnable
            public void run() {
                BridgeCallbackContext.this.callback(TextUtils.isEmpty(str) ? String.format("javascript:window.HavanaBridge.onSuccess(%s);", Integer.valueOf(BridgeCallbackContext.this.requestId)) : String.format("javascript:window.HavanaBridge.onSuccess(%s,'%s');", Integer.valueOf(BridgeCallbackContext.this.requestId), BridgeCallbackContext.formatJsonString(str)));
            }
        });
    }

    public void onFailure(final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.core.webview.BridgeCallbackContext.2
            @Override // java.lang.Runnable
            public void run() {
                BridgeCallbackContext.this.callback(TextUtils.isEmpty(str) ? String.format("javascript:window.HavanaBridge.onFailure(%s,'');", Integer.valueOf(BridgeCallbackContext.this.requestId)) : String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", Integer.valueOf(BridgeCallbackContext.this.requestId), BridgeCallbackContext.formatJsonString(str)));
            }
        });
    }
}
