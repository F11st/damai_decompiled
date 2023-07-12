package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class e implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "gProp";
    private static e e;
    private Map<String, b> a = new HashMap();
    private List<String> b = new ArrayList();
    private List<String> c = new ArrayList();
    private Map<String, List<String>> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
        public List<String> a;
        public List<String> b;

        private b() {
            this.a = null;
            this.b = null;
        }

        private boolean b(String str) {
            List<String> list = this.b;
            return list == null || list.contains(jn1.MUL) || this.b.contains(str);
        }

        private boolean c(String str) {
            List<String> list = this.a;
            if (list != null) {
                return list.contains(jn1.MUL) || this.a.contains(str);
            }
            return false;
        }

        public boolean a(String str) {
            return !c(str) && b(str);
        }
    }

    private e() {
    }

    private boolean b(String str) {
        for (LogField logField : LogField.values()) {
            if (logField.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static e d() {
        if (e == null) {
            e = new e();
        }
        return e;
    }

    private void e() {
        Map<String, b> map = this.a;
        if (map != null && map.size() >= 1) {
            for (String str : this.b) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, b> entry : this.a.entrySet()) {
                    String key = entry.getKey();
                    if (yh2.f(key) || b(key)) {
                        return;
                    }
                    if (!a(key, str)) {
                        arrayList.add(key);
                    }
                }
                this.d.put(str, arrayList);
            }
            this.d.put("other", this.c);
            Logger.f("UTGlobalPropConfigListener", "mBlackGlobalPropItemMap", this.d);
            return;
        }
        Logger.f("UTGlobalPropConfigListener", "mBlackGlobalPropItemMap is null");
    }

    private synchronized void f(String str) {
        Logger.f("UTGlobalPropConfigListener", "parseConfig", str);
        this.a.clear();
        this.c.clear();
        this.d.clear();
        this.b.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (Map.Entry entry : ((HashMap) JSON.parseObject(str, Map.class)).entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (!yh2.f(str2) && !b(str2)) {
                        Map map = (Map) entry.getValue();
                        if (map != null) {
                            b bVar = new b();
                            try {
                                List<String> list = (List) map.get("eidin");
                                bVar.b = list;
                                if (list != null) {
                                    for (String str3 : list) {
                                        if (!jn1.MUL.equalsIgnoreCase(str3) && !this.b.contains(str3)) {
                                            this.b.add(str3);
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                                bVar.b = null;
                            }
                            try {
                                List<String> list2 = (List) map.get("eidnin");
                                bVar.a = list2;
                                if (list2 != null) {
                                    for (String str4 : list2) {
                                        if (!jn1.MUL.equalsIgnoreCase(str4) && !this.b.contains(str4)) {
                                            this.b.add(str4);
                                        }
                                    }
                                }
                            } catch (Exception unused2) {
                                bVar.a = null;
                            }
                            List<String> list3 = bVar.b;
                            if (list3 != null && list3.size() > 0) {
                                if (!bVar.b.contains(jn1.MUL)) {
                                    this.c.add(str2);
                                }
                            } else {
                                List<String> list4 = bVar.a;
                                if (list4 != null && list4.size() > 0 && bVar.a.contains(jn1.MUL)) {
                                    this.c.add(str2);
                                }
                            }
                            if (bVar.b != null || bVar.a != null) {
                                this.a.put(str2, bVar);
                                Logger.f("UTGlobalPropConfigListener", "key", str2, "globalPropItem.eidin", bVar.b, "globalPropItem.eidnin", bVar.a);
                            }
                        }
                    }
                    return;
                }
            } catch (Exception e2) {
                Logger.h("UTGlobalPropConfigListener", e2, new Object[0]);
            }
        }
        e();
    }

    public boolean a(String str, String str2) {
        b bVar;
        Map<String, b> map = this.a;
        if (map == null) {
            return true;
        }
        try {
            if (!map.containsKey(str) || (bVar = this.a.get(str)) == null) {
                return true;
            }
            return bVar.a(str2);
        } catch (Exception unused) {
        }
        return true;
    }

    public synchronized List<String> c(String str) {
        if ("65501".equalsIgnoreCase(str) || "65502".equalsIgnoreCase(str) || "65503".equalsIgnoreCase(str)) {
            return null;
        }
        try {
            if (this.b.contains(str)) {
                return this.d.get(str);
            }
            return this.d.get("other");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        try {
            f(str2);
        } catch (Exception unused) {
        }
    }
}
