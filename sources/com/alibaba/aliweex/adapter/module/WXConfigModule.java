package com.alibaba.aliweex.adapter.module;

import android.text.TextUtils;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.adapter.IConfigGeneratorAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXConfigModule extends WXModule implements IConfigModuleListener, Destroyable {
    public static final String NAME = "orange";
    private IConfigModuleAdapter adapter;
    private Map<String, Map<String, String>> eventMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.WXConfigModule$a */
    /* loaded from: classes5.dex */
    public class C3046a implements IConfigModuleAdapter {
        C3046a(WXConfigModule wXConfigModule) {
        }

        @Override // com.alibaba.aliweex.IConfigAdapter
        public boolean checkMode(String str) {
            return false;
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleAdapter
        public void destroy() {
        }

        @Override // com.alibaba.aliweex.IConfigAdapter
        public String getConfig(String str, String str2, String str3) {
            return null;
        }

        @Override // com.alibaba.aliweex.IConfigAdapter
        public Map<String, String> getConfigs(String str) {
            return null;
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleAdapter
        public void registerListener(String[] strArr, IConfigModuleListener iConfigModuleListener) {
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleAdapter
        public void unregisterListener(String[] strArr, IConfigModuleListener iConfigModuleListener) {
        }
    }

    private IConfigModuleAdapter getConfigAdapter() {
        IConfigGeneratorAdapter d;
        if (this.adapter == null && (d = C3004a.l().d()) != null) {
            this.adapter = d.generateConfigInstance("");
        }
        if (this.adapter == null) {
            this.adapter = new C3046a(this);
        }
        return this.adapter;
    }

    private static String[] getNameSpace(String str) {
        return new String[]{str};
    }

    @Override // com.taobao.weex.common.WXModule
    @JSMethod
    public void addEventListener(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = WXUtils.getString(map.get("action"), "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        super.addEventListener(str, str2, map);
        Map<String, String> map2 = this.eventMap.get(str);
        if (map2 == null) {
            map2 = new HashMap<>();
            this.eventMap.put(str, map2);
        }
        map2.put(string, str2);
        getConfigAdapter().registerListener(getNameSpace(str), this);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        getConfigAdapter().destroy();
        removeAllEventListener();
    }

    @JSMethod(uiThread = false)
    public Object getConfig(String str) {
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getString("namespace");
        String string2 = parseObject.getString("key");
        String string3 = parseObject.getString("defaultValue");
        if (TextUtils.isEmpty(string2)) {
            return getConfigAdapter().getConfigs(string);
        }
        return getConfigAdapter().getConfig(string, string2, string3);
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
        super.onActivityDestroy();
        getConfigAdapter().destroy();
        removeAllEventListener();
    }

    @Override // com.alibaba.aliweex.adapter.IConfigModuleListener
    public void onConfigUpdate(String str, Map<String, String> map) {
        List<String> eventCallbacks = getEventCallbacks(str);
        if (eventCallbacks == null || eventCallbacks.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("namespace", str);
        hashMap.put("configVersion", map.get("configVersion"));
        hashMap.put("args", getConfigAdapter().getConfigs(str));
        for (String str2 : eventCallbacks) {
            WXSDKManager.v().b(this.mWXSDKInstance.getInstanceId(), str2, hashMap, true);
        }
    }

    @JSMethod
    public void removeActionListener(String str, Map<String, Object> map) {
        Map<String, String> map2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String string = WXUtils.getString(map.get("action"), "");
        if (TextUtils.isEmpty(string) || (map2 = this.eventMap.get(str)) == null || map2.isEmpty()) {
            return;
        }
        getEventCallbacks(str).remove(map2.remove(string));
        if (map2.isEmpty()) {
            this.eventMap.remove(str);
            getConfigAdapter().unregisterListener(getNameSpace(str), this);
        }
    }

    @JSMethod
    public void removeAllEventListener() {
        Iterator<Map.Entry<String, Map<String, String>>> it = this.eventMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, String>> next = it.next();
            getConfigAdapter().unregisterListener(getNameSpace(next.getKey()), this);
            super.removeAllEventListeners(next.getKey());
            it.remove();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void removeAllEventListeners(String str) {
        super.removeAllEventListeners(str);
        getConfigAdapter().unregisterListener(getNameSpace(str), this);
        this.eventMap.remove(str);
    }

    @JSMethod
    public void removeEventListener(String str) {
        removeAllEventListeners(str);
    }
}
