package com.taobao.weex.ui.config;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;
import com.taobao.weex.utils.WXLogUtils;
import com.vivo.push.PushClientConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConfigModuleFactory<T extends WXModule> implements ModuleFactory<T> {
    public static final String TAG = "WeexScanConfigRegister";
    private ClassLoader mClassLoader;
    private String mClassName;
    private Class<T> mClazz;
    private Map<String, Invoker> mMethodMap;
    private String mName;
    private String[] methods;

    public ConfigModuleFactory(String str, String str2, String[] strArr) {
        this.mName = str;
        this.mClassName = str2;
        this.methods = strArr;
    }

    public static ConfigModuleFactory fromConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString(PushClientConstants.TAG_CLASS_NAME);
            JSONArray jSONArray = jSONObject.getJSONArray("methods");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                String[] strArr = new String[jSONArray.size()];
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("WeexScanConfigRegister", " resolve module " + string + " className " + string2 + " methods " + jSONArray);
                }
                return new ConfigModuleFactory(string, string2, (String[]) jSONArray.toArray(strArr));
            }
            return null;
        } catch (Exception e) {
            WXLogUtils.e("WeexScanConfigRegister", e);
            return null;
        }
    }

    private void generateMethodMap() {
        Method[] methods;
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("WeexScanConfigRegister", "extractMethodNames:" + this.mClazz.getSimpleName());
        }
        HashMap hashMap = new HashMap();
        try {
            for (Method method : this.mClazz.getMethods()) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                int length = declaredAnnotations.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Annotation annotation = declaredAnnotations[i];
                    if (annotation != null) {
                        if (annotation instanceof JSMethod) {
                            JSMethod jSMethod = (JSMethod) annotation;
                            hashMap.put(JSMethod.NOT_SET.equals(jSMethod.alias()) ? method.getName() : jSMethod.alias(), new MethodInvoker(method, jSMethod.uiThread()));
                        } else if (annotation instanceof WXModuleAnno) {
                            hashMap.put(method.getName(), new MethodInvoker(method, ((WXModuleAnno) annotation).runOnUIThread()));
                            break;
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = hashMap;
    }

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() throws IllegalAccessException, InstantiationException {
        if (this.mClazz == null) {
            this.mClazz = (Class<T>) WXSDKManager.v().k().getModuleClass(this.mName, this.mClassName, WXEnvironment.getApplication().getApplicationContext());
        }
        return this.mClazz.newInstance();
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public Invoker getMethodInvoker(String str) {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        return this.mMethodMap.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public String[] getMethods() {
        String[] strArr = this.methods;
        return strArr == null ? new String[0] : strArr;
    }

    public String getName() {
        return this.mName;
    }

    public T buildInstance(WXSDKInstance wXSDKInstance) throws IllegalAccessException, InstantiationException {
        if (wXSDKInstance == null) {
            return buildInstance();
        }
        if (this.mClazz == null || this.mClassLoader != wXSDKInstance.getContext().getClassLoader()) {
            this.mClazz = (Class<T>) WXSDKManager.v().k().getModuleClass(this.mName, this.mClassName, wXSDKInstance.getContext());
            this.mClassLoader = wXSDKInstance.getContext().getClassLoader();
        }
        return this.mClazz.newInstance();
    }
}
