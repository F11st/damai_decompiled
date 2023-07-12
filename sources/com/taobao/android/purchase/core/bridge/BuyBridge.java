package com.taobao.android.purchase.core.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.WindVaneInterface;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BuyBridge extends WVApiPlugin {
    public static final String BRIDGE_PLUGIN_NAME = "BuyBridgeComponent";
    public static final String KEY_H5_RESULT = "data";
    private static final String KEY_SET_DATA_BRIDGE = "setData";
    private static final String KEY_SET_INTO_BRIDGE = "setInfo";

    private void returnErr(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_PARAM_ERR");
        wVCallBackContext.error(wVResult);
    }

    private void returnSuccess(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.addData("os", "android");
        wVResult.addData("version", "8.3.0");
        wVCallBackContext.success(wVResult);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!KEY_SET_INTO_BRIDGE.equals(str) && !KEY_SET_DATA_BRIDGE.equals(str)) {
            returnErr(wVCallBackContext);
            return false;
        }
        setInfo(wVCallBackContext, str2);
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        super.onDestroy();
    }

    @WindVaneInterface
    public final void setInfo(WVCallBackContext wVCallBackContext, String str) {
        if (this.mContext instanceof Activity) {
            Intent intent = new Intent();
            intent.putExtra("data", str);
            intent.putExtra("bridge_data", str);
            ((Activity) this.mContext).setResult(-1, intent);
            ((Activity) this.mContext).finish();
        }
        returnSuccess(wVCallBackContext);
    }
}
