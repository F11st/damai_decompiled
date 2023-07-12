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
/* renamed from: com.alibaba.analytics.core.config.e */
/* loaded from: classes5.dex */
public class C3112e implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "gProp";
    private static C3112e e;
    private Map<String, C3114b> a = new HashMap();
    private List<String> b = new ArrayList();
    private List<String> c = new ArrayList();
    private Map<String, List<String>> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.config.e$b */
    /* loaded from: classes15.dex */
    public static class C3114b {
        public List<String> a;
        public List<String> b;

        private C3114b() {
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

    private C3112e() {
    }

    private boolean b(String str) {
        for (LogField logField : LogField.values()) {
            if (logField.toString().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static C3112e d() {
        if (e == null) {
            e = new C3112e();
        }
        return e;
    }

    private void e() {
        Map<String, C3114b> map = this.a;
        if (map != null && map.size() >= 1) {
            for (String str : this.b) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, C3114b> entry : this.a.entrySet()) {
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
                            C3114b c3114b = new C3114b();
                            try {
                                List<String> list = (List) map.get("eidin");
                                c3114b.b = list;
                                if (list != null) {
                                    for (String str3 : list) {
                                        if (!jn1.MUL.equalsIgnoreCase(str3) && !this.b.contains(str3)) {
                                            this.b.add(str3);
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                                c3114b.b = null;
                            }
                            try {
                                List<String> list2 = (List) map.get("eidnin");
                                c3114b.a = list2;
                                if (list2 != null) {
                                    for (String str4 : list2) {
                                        if (!jn1.MUL.equalsIgnoreCase(str4) && !this.b.contains(str4)) {
                                            this.b.add(str4);
                                        }
                                    }
                                }
                            } catch (Exception unused2) {
                                c3114b.a = null;
                            }
                            List<String> list3 = c3114b.b;
                            if (list3 != null && list3.size() > 0) {
                                if (!c3114b.b.contains(jn1.MUL)) {
                                    this.c.add(str2);
                                }
                            } else {
                                List<String> list4 = c3114b.a;
                                if (list4 != null && list4.size() > 0 && c3114b.a.contains(jn1.MUL)) {
                                    this.c.add(str2);
                                }
                            }
                            if (c3114b.b != null || c3114b.a != null) {
                                this.a.put(str2, c3114b);
                                Logger.f("UTGlobalPropConfigListener", "key", str2, "globalPropItem.eidin", c3114b.b, "globalPropItem.eidnin", c3114b.a);
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
        C3114b c3114b;
        Map<String, C3114b> map = this.a;
        if (map == null) {
            return true;
        }
        try {
            if (!map.containsKey(str) || (c3114b = this.a.get(str)) == null) {
                return true;
            }
            return c3114b.a(str2);
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
