package com.ut.mini.behavior.module;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.behavior.expression.ExpressionEvaluator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ModulesMgr {
    private static final String TAG = "ModulesMgr";
    public static final String UT_TAG = "ut_tag";
    private final Object Lock_Object;
    private ModulesConfig mModulesConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static ModulesMgr instance = new ModulesMgr();

        private SingletonHolder() {
        }
    }

    public static ModulesMgr getInstance() {
        return SingletonHolder.instance;
    }

    void init(String str) {
        if (yh2.f(str)) {
            this.mModulesConfig = null;
            return;
        }
        try {
            this.mModulesConfig = (ModulesConfig) JSON.parseObject(str, ModulesConfig.class);
        } catch (Exception e) {
            Logger.h(TAG, e, new Object[0]);
        }
    }

    public Map<String, String> makeTag(Map<String, String> map) {
        synchronized (this.Lock_Object) {
            ModulesConfig modulesConfig = this.mModulesConfig;
            if (modulesConfig == null) {
                return null;
            }
            List<Module> list = modulesConfig.moduleList;
            if (list != null) {
                ArrayList arrayList = null;
                for (Module module : list) {
                    if (ExpressionEvaluator.getInstance().evaluateData(module.data, map)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(module.name);
                    }
                }
                if (arrayList != null) {
                    String str = "";
                    try {
                        str = JSON.toJSONString(arrayList);
                    } catch (Exception unused) {
                    }
                    if (!str.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(UT_TAG, str);
                        return hashMap;
                    }
                }
            }
            return null;
        }
    }

    private ModulesMgr() {
        this.Lock_Object = new Object();
    }

    public void init(ModulesConfig modulesConfig) {
        synchronized (this.Lock_Object) {
            this.mModulesConfig = modulesConfig;
        }
    }
}
