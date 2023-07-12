package com.taobao.weex.bridge;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.ui.IFComponentHolder;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXEaglePlugin {
    public static final int EAGLE_AND_SCRIPT = 2;
    public static final int EAGLE_ONLY = 1;
    public static final int NOT_SUPPORT = 0;

    boolean callEagleTaskFromWeex(String str, JSONObject jSONObject);

    void fireEvent(String str, String str2, String str3, String str4, String str5);

    @NonNull
    String getPluginName();

    String getSoLibName();

    void invokeExecJS(String str, String str2, String str3, WXJSObject[] wXJSObjectArr);

    void invokeJSCallback(String str, String str2, String str3, boolean z);

    boolean isLazyCompAndModuleSupport();

    boolean isSkipFrameworkInit(String str);

    int isSupportFireEvent(String str);

    int isSupportInvokeExecJS(String str);

    int isSupportJSCallback(String str);

    String isSupportedUrl(String str);

    void registerComponent(String str, IFComponentHolder iFComponentHolder, Map<String, Object> map);

    void registerModules(String str, ModuleFactory moduleFactory, boolean z);
}
