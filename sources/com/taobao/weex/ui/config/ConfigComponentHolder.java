package com.taobao.weex.ui.config;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.SimpleComponentHolder;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConfigComponentHolder implements IFComponentHolder {
    public static final String TAG = "WeexScanConfigRegister";
    private boolean mAppendTree;
    private Class mClass;
    private ClassLoader mClassLoader;
    private String mClassName;
    private Map<String, Invoker> mMethodInvokers;
    private Map<String, Invoker> mPropertyInvokers;
    private String mType;
    private String[] methods;

    public ConfigComponentHolder(String str, boolean z, String str2, String[] strArr) {
        this.mType = str;
        this.mAppendTree = z;
        this.mClassName = str2;
        this.methods = strArr;
    }

    public static final ConfigComponentHolder fromConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("name");
            boolean booleanValue = jSONObject.getBooleanValue("appendTree");
            String string2 = jSONObject.getString(PushClientConstants.TAG_CLASS_NAME);
            JSONArray jSONArray = jSONObject.containsKey("methods") ? jSONObject.getJSONArray("methods") : null;
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                String[] strArr = new String[0];
                if (jSONArray != null) {
                    strArr = new String[jSONArray.size()];
                    jSONArray.toArray(strArr);
                }
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("WeexScanConfigRegister", "resolve component " + string + " className " + string2 + " methods " + jSONArray);
                }
                return new ConfigComponentHolder(string, booleanValue, string2, strArr);
            }
            return null;
        } catch (Exception e) {
            WXLogUtils.e("WeexScanConfigRegister", e);
            return null;
        }
    }

    private synchronized boolean generate() {
        Class cls = this.mClass;
        if (cls == null) {
            return false;
        }
        Pair<Map<String, Invoker>, Map<String, Invoker>> methods = SimpleComponentHolder.getMethods(cls);
        this.mPropertyInvokers = (Map) methods.first;
        this.mMethodInvokers = (Map) methods.second;
        return true;
    }

    @Override // com.taobao.weex.ui.ComponentCreator
    public synchronized WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        WXComponent createInstance;
        if (this.mClass == null || this.mClassLoader != wXSDKInstance.getContext().getClassLoader()) {
            this.mClass = WXSDKManager.v().k().getComponentClass(this.mType, this.mClassName, wXSDKInstance);
            this.mClassLoader = wXSDKInstance.getContext().getClassLoader();
        }
        createInstance = new SimpleComponentHolder.ClazzComponentCreator(this.mClass).createInstance(wXSDKInstance, wXVContainer, basicComponentData);
        createInstance.bindHolder(this);
        return createInstance;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public Invoker getMethodInvoker(String str) {
        if (this.mMethodInvokers != null || generate()) {
            return this.mMethodInvokers.get(str);
        }
        return null;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public String[] getMethods() {
        String[] strArr = this.methods;
        return strArr == null ? new String[0] : strArr;
    }

    @Override // com.taobao.weex.ui.IFComponentHolder
    public synchronized Invoker getPropertyInvoker(String str) {
        if (this.mPropertyInvokers != null || generate()) {
            return this.mPropertyInvokers.get(str);
        }
        return null;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isAppendTree() {
        return this.mAppendTree;
    }

    @Override // com.taobao.weex.ui.IFComponentHolder
    public void loadIfNonLazy() {
    }
}
