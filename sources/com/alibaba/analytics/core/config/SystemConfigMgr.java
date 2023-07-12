package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.qs2;
import tb.ve0;
import tb.zs2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SystemConfigMgr extends zs2 {
    private static SystemConfigMgr e;
    private final Map<String, String> a = Collections.synchronizedMap(new HashMap());
    private final Map<String, List<IKVChangeListener>> b = Collections.synchronizedMap(new HashMap());
    private final String[] c = {"utap_system"};
    private final Map<String, C3106a> d = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IKVChangeListener {
        void onChange(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.analytics.core.config.SystemConfigMgr$a */
    /* loaded from: classes15.dex */
    public static class C3106a {
        private int a = -1;
        private List<String> b = new ArrayList();

        private C3106a() {
        }

        private boolean b(String str) {
            if (!TextUtils.isEmpty(str) && this.b != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    String str2 = this.b.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.length() > 2 && str2.startsWith("%") && str2.endsWith("%")) {
                            if (str.contains(str2.substring(1, str2.length() - 1))) {
                                return true;
                            }
                        } else if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static C3106a c(String str) {
            try {
                C3106a c3106a = new C3106a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("all_d")) {
                    c3106a.a = jSONObject.optInt("all_d", -1);
                }
                if (jSONObject.has("arg1")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray("arg1");
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    c3106a.b = arrayList;
                }
                return c3106a;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public boolean a(String str) {
            int i = this.a;
            if (i == 0) {
                return b(str);
            }
            if (1 == i) {
                return !b(str);
            }
            return false;
        }
    }

    private SystemConfigMgr() {
        try {
            if (Variables.n().k() != null) {
                List<? extends ve0> i = Variables.n().k().i(C3110c.class, null, null, -1);
                if (i.size() > 0) {
                    Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap(i.size()));
                    for (int i2 = 0; i2 < i.size(); i2++) {
                        synchronizedMap.put(((C3110c) i.get(i2)).a, ((C3110c) i.get(i2)).b);
                    }
                    m(synchronizedMap);
                }
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
    }

    private boolean d(Map<String, String> map, int i) {
        C3106a c3106a = this.d.get(String.valueOf(i));
        if (c3106a != null) {
            LogField logField = LogField.ARG1;
            return c3106a.a(map.containsKey(logField.toString()) ? map.get(logField.toString()) : null);
        }
        return false;
    }

    private void f(String str, String str2) {
        List<IKVChangeListener> list = this.b.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).onChange(str, str2);
            }
        }
        qs2.b(str, str2);
    }

    public static synchronized SystemConfigMgr i() {
        SystemConfigMgr systemConfigMgr;
        synchronized (SystemConfigMgr.class) {
            if (e == null) {
                e = new SystemConfigMgr();
            }
            systemConfigMgr = e;
        }
        return systemConfigMgr;
    }

    private List<ve0> k(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            C3110c c3110c = new C3110c();
            c3110c.a = str;
            c3110c.b = map.get(str);
            arrayList.add(c3110c);
        }
        return arrayList;
    }

    private void m(Map<String, String> map) {
        n(map);
        HashMap hashMap = new HashMap(this.a.size());
        hashMap.putAll(this.a);
        this.a.clear();
        this.a.putAll(map);
        for (String str : this.a.keySet()) {
            if ((this.a.get(str) == null && hashMap.get(str) != null) || (this.a.get(str) != null && !this.a.get(str).equalsIgnoreCase((String) hashMap.get(str)))) {
                f(str, this.a.get(str));
            }
            hashMap.remove(str);
        }
        for (String str2 : hashMap.keySet()) {
            f(str2, this.a.get(str2));
        }
    }

    private synchronized void n(Map<String, String> map) {
        Map<String, C3106a> map2;
        C3106a c;
        if (map != null) {
            if (map.containsKey("delay")) {
                if ((this.a.get("delay") == null || !map.get("delay").equals(this.a.get("delay"))) && (map2 = this.d) != null) {
                    map2.clear();
                    try {
                        JSONObject jSONObject = new JSONObject(map.get("delay"));
                        Iterator<String> keys = jSONObject.keys();
                        if (keys == null) {
                            return;
                        }
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject.getString(next);
                            if (!TextUtils.isEmpty(string) && (c = C3106a.c(string)) != null) {
                                this.d.put(next, c);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        Map<String, C3106a> map3 = this.d;
        if (map3 != null) {
            map3.clear();
        }
    }

    @Override // tb.zs2
    public String[] a() {
        return this.c;
    }

    @Override // tb.zs2
    public void c(String str, Map<String, String> map) {
        if ("utap_system".equalsIgnoreCase(str)) {
            m(map);
            Variables.n().k().b(C3110c.class);
            Variables.n().k().q(k(this.a));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x0097, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:11:0x001c, B:16:0x0030, B:18:0x003c, B:21:0x0042, B:23:0x0051, B:26:0x0057, B:28:0x0066, B:31:0x006c, B:33:0x007b, B:36:0x0081, B:38:0x008d, B:14:0x002c), top: B:50:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[Catch: all -> 0x0097, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:11:0x001c, B:16:0x0030, B:18:0x003c, B:21:0x0042, B:23:0x0051, B:26:0x0057, B:28:0x0066, B:31:0x006c, B:33:0x007b, B:36:0x0081, B:38:0x008d, B:14:0x002c), top: B:50:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean e(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r0 = r5.d     // Catch: java.lang.Throwable -> L97
            r1 = 0
            if (r0 == 0) goto L95
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L97
            r2 = 1
            if (r0 >= r2) goto Lf
            goto L95
        Lf:
            com.alibaba.analytics.core.model.LogField r0 = com.alibaba.analytics.core.model.LogField.EVENTID     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L97
            boolean r2 = r6.containsKey(r2)     // Catch: java.lang.Throwable -> L97
            r3 = -1
            if (r2 == 0) goto L2f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L97
            java.lang.Object r0 = r6.get(r0)     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L97
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L97
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L97
            goto L30
        L2b:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L97
        L2f:
            r0 = -1
        L30:
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r2 = r5.d     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L97
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L42
            boolean r6 = r5.d(r6, r0)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r5)
            return r6
        L42:
            int r2 = r0 % 10
            int r0 = r0 - r2
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r2 = r5.d     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L97
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L57
            boolean r6 = r5.d(r6, r0)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r5)
            return r6
        L57:
            int r2 = r0 % 100
            int r0 = r0 - r2
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r2 = r5.d     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L97
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L6c
            boolean r6 = r5.d(r6, r0)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r5)
            return r6
        L6c:
            int r2 = r0 % 1000
            int r0 = r0 - r2
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r2 = r5.d     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L97
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L81
            boolean r6 = r5.d(r6, r0)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r5)
            return r6
        L81:
            java.util.Map<java.lang.String, com.alibaba.analytics.core.config.SystemConfigMgr$a> r0 = r5.d     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L97
            boolean r0 = r0.containsKey(r2)     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L93
            boolean r6 = r5.d(r6, r3)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r5)
            return r6
        L93:
            monitor-exit(r5)
            return r1
        L95:
            monitor-exit(r5)
            return r1
        L97:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.config.SystemConfigMgr.e(java.util.Map):boolean");
    }

    public synchronized boolean g() {
        Map<String, C3106a> map = this.d;
        if (map != null) {
            if (map.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public String h(String str) {
        return this.a.get(str);
    }

    public int j(String str) {
        String h = h(str);
        if (!TextUtils.isEmpty(h)) {
            try {
                return Integer.valueOf(h).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void l(String str, IKVChangeListener iKVChangeListener) {
        List<IKVChangeListener> list;
        synchronized (this.b) {
            if (this.b.get(str) == null) {
                list = new ArrayList<>();
            } else {
                list = this.b.get(str);
            }
            list.add(iKVChangeListener);
            this.b.put(str, list);
        }
    }
}
