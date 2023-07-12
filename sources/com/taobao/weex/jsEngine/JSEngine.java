package com.taobao.weex.jsEngine;

import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.s41;
import tb.tf;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JSEngine implements Serializable {
    public static final ConcurrentHashMap<Long, JSContext> mCreatedJSContext = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<s41, EnvCallback> mEnvCallbacks = new ConcurrentHashMap<>();
    private static JSEngine mJsEngine;

    private JSEngine() {
    }

    public static JSEngine getInstance() {
        if (mJsEngine == null) {
            synchronized (JSEngine.class) {
                if (mJsEngine == null) {
                    mJsEngine = new JSEngine();
                }
            }
        }
        return mJsEngine;
    }

    @Nullable
    public JSContext createJSContext() {
        if (!WXSDKEngine.isInitialized()) {
            WXLogUtils.e("Create JSContext Failed because of weex has not been initialized");
            return null;
        }
        return new JSContext();
    }

    public void engineCrashed() {
        for (Map.Entry<s41, EnvCallback> entry : mEnvCallbacks.entrySet()) {
            entry.getValue().error(tf.ERROR_JSENGINE_CRASHED);
        }
        ConcurrentHashMap<Long, JSContext> concurrentHashMap = mCreatedJSContext;
        HashMap hashMap = new HashMap(concurrentHashMap);
        concurrentHashMap.clear();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            ((JSContext) entry2.getValue()).destroy();
        }
        hashMap.clear();
    }

    public void engineInitFinished() {
        for (Map.Entry<s41, EnvCallback> entry : mEnvCallbacks.entrySet()) {
            entry.getValue().error(tf.JSENGINE_INIT_FINISH);
        }
    }

    public void registerEnvCallback(s41 s41Var, EnvCallback envCallback) {
    }

    public void unRegisterEnvCallback(s41 s41Var) {
    }
}
