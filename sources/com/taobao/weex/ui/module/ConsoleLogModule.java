package com.taobao.weex.ui.module;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.LogLevel;
import com.youku.resource.widget.YKActionSheet;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConsoleLogModule extends WXModule {
    @Nullable
    private LogLevel getLogLevel(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 109935:
                    if (str.equals("off")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3237038:
                    if (str.equals("info")) {
                        c = 1;
                        break;
                    }
                    break;
                case 95458899:
                    if (str.equals("debug")) {
                        c = 2;
                        break;
                    }
                    break;
                case 96784904:
                    if (str.equals("error")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1124446108:
                    if (str.equals(YKActionSheet.ACTION_STYLE_WARNING)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return LogLevel.OFF;
                case 1:
                    return LogLevel.INFO;
                case 2:
                    return LogLevel.DEBUG;
                case 3:
                    return LogLevel.ERROR;
                case 4:
                    return LogLevel.WARN;
            }
        }
        return null;
    }

    @JSMethod(uiThread = false)
    public void setPerfMode(@Nullable String str) {
        WXEnvironment.isPerf = "true".equals(str);
        WXBridgeManager.getInstance().setLogLevel(WXEnvironment.sLogLevel.getValue(), WXEnvironment.isPerf());
    }

    @JSMethod(uiThread = false)
    public void switchLogLevel(@Nullable String str, @Nullable JSCallback jSCallback) {
        LogLevel logLevel = getLogLevel(str);
        ArrayMap arrayMap = new ArrayMap();
        if (logLevel != null) {
            WXEnvironment.sLogLevel = logLevel;
            WXBridgeManager.getInstance().setLogLevel(WXEnvironment.sLogLevel.getValue(), WXEnvironment.isPerf());
            arrayMap.put("status", "success");
        } else {
            arrayMap.put("status", AKBaseAbility.CALLBACK_FAILURE);
        }
        if (jSCallback != null) {
            jSCallback.invoke(arrayMap);
        }
    }
}
