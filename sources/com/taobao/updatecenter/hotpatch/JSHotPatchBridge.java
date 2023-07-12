package com.taobao.updatecenter.hotpatch;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.WVResult;
import android.text.TextUtils;
import android.util.Log;
import tb.vq1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JSHotPatchBridge extends WVApiPlugin {
    private static final String CleanHotPatch = "cleanHotPatch";
    private static final String GetHotPatchInfo = "getHotPatchInfo";
    private static final String JSHotPatchBridge = "JSHotPatchBridge";
    private static final String TAG = "JSHotPatchBridge";

    public static void init() {
        WVPluginManager.registerPlugin("JSHotPatchBridge", (Class<? extends WVApiPlugin>) JSHotPatchBridge.class, true);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Log.i("JSHotPatchBridge", "action is : " + str);
        if (str.equals(GetHotPatchInfo)) {
            vq1 successedPatchInfo = HotPatchManager.getInstance().getSuccessedPatchInfo();
            if (wVCallBackContext != null) {
                WVResult wVResult = new WVResult();
                wVResult.addData("info", successedPatchInfo.toString());
                wVCallBackContext.success(wVResult);
            }
            return true;
        } else if (str.equals(CleanHotPatch)) {
            HotPatchManager.getInstance().cleanPatchs(true);
            HotPatchManager.getInstance().cleanDexPatch();
            WVResult wVResult2 = new WVResult();
            wVResult2.addData("info", "succeed");
            wVCallBackContext.success(wVResult2);
            return true;
        } else {
            return false;
        }
    }
}
