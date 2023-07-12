package com.taobao.weex.ui.config;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.youku.arch.v3.data.Constants;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AutoScanConfigRegister {
    public static final String TAG = "WeexScanConfigRegister";
    private static long scanDelay;

    public static void doScanConfig() {
        if (scanDelay > 0) {
            WXSDKManager.v().G().postOnUiThread(new Runnable() { // from class: com.taobao.weex.ui.config.AutoScanConfigRegister.1
                @Override // java.lang.Runnable
                public void run() {
                    AutoScanConfigRegister.doScanConfigAsync();
                }
            }, scanDelay);
        } else {
            doScanConfigAsync();
        }
    }

    public static void doScanConfigAsync() {
        Thread thread = new Thread(new Runnable() { // from class: com.taobao.weex.ui.config.AutoScanConfigRegister.2
            @Override // java.lang.Runnable
            public void run() {
                AutoScanConfigRegister.doScanConfigSync();
            }
        });
        thread.setName("AutoScanConfigRegister");
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doScanConfigSync() {
        String[] list;
        Application application = WXEnvironment.sApplication;
        if (application == null) {
            return;
        }
        try {
            String[] strArr = new String[0];
            try {
                list = application.getApplicationContext().getAssets().list("");
            } catch (IOException e) {
                WXLogUtils.e("WeexScanConfigRegister", e);
            }
            if (list != null && list.length != 0) {
                for (String str : list) {
                    if (!TextUtils.isEmpty(str) && str.startsWith("weex_config_") && str.endsWith(".json")) {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        String loadAsset = WXFileUtils.loadAsset(str, WXEnvironment.getApplication());
                        if (!TextUtils.isEmpty(loadAsset)) {
                            if (WXEnvironment.isApkDebugable()) {
                                WXLogUtils.d("WeexScanConfigRegister", str + " find config " + loadAsset);
                            }
                            JSONObject parseObject = JSON.parseObject(loadAsset);
                            if (parseObject.containsKey("modules")) {
                                JSONArray jSONArray = parseObject.getJSONArray("modules");
                                for (int i = 0; i < jSONArray.size(); i++) {
                                    ConfigModuleFactory fromConfig = ConfigModuleFactory.fromConfig(jSONArray.getJSONObject(i));
                                    if (fromConfig != null) {
                                        WXSDKEngine.registerModule(fromConfig.getName(), (ModuleFactory) fromConfig, false);
                                    }
                                }
                            }
                            if (parseObject.containsKey(Constants.COMPONENT)) {
                                JSONArray jSONArray2 = parseObject.getJSONArray(Constants.COMPONENT);
                                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                                    ConfigComponentHolder fromConfig2 = ConfigComponentHolder.fromConfig(jSONArray2.getJSONObject(i2));
                                    if (fromConfig2 == null) {
                                        return;
                                    }
                                    WXSDKEngine.registerComponent(fromConfig2, fromConfig2.isAppendTree(), fromConfig2.getType());
                                }
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            WXLogUtils.e("WeexScanConfigRegister", e2);
        }
    }

    public static void setScanDelay(long j) {
        scanDelay = j;
    }
}
