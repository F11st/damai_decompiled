package com.ali.user.open.ucc.webview;

import android.os.Bundle;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.webview.BridgeCallbackContext;
import com.ali.user.open.core.webview.BridgeMethod;
import com.ali.user.open.core.webview.INavHelper;
import com.ali.user.open.ucc.biz.UccH5Presenter;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccSystemJSBridge {
    public static final String ALU_SYSTEM_JSBRIDGE = "aluUccJSBridge";

    @BridgeMethod
    public void aluOpenWebViewByUrl(BridgeCallbackContext bridgeCallbackContext, String str) {
        if (bridgeCallbackContext == null) {
            return;
        }
        try {
            String string = new JSONObject(str).getString("url");
            Bundle bundle = new Bundle();
            bundle.putString("url", string);
            if (ConfigManager.getInstance().getNavHelper() != null) {
                ((INavHelper) ConfigManager.getInstance().getNavHelper().newInstance()).navTo(bridgeCallbackContext.getActivity(), string);
            } else {
                UccH5Presenter.openUrl(bridgeCallbackContext.getActivity(), bundle, null);
            }
            bridgeCallbackContext.success(new JSONObject().toString());
        } catch (Throwable th) {
            bridgeCallbackContext.onFailure(1001, th.getMessage());
        }
    }
}
