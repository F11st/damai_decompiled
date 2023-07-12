package com.alibaba.appmonitor.sample;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import tb.ea2;
import tb.ve0;
import tb.yh2;
import tb.zs2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.appmonitor.sample.a */
/* loaded from: classes6.dex */
public class C3317a extends zs2 {
    private static C3317a c;
    private static final String[] d = {"ap_stat", "ap_counter", "ap_alarm"};
    private Map<EventType, AMConifg> a = Collections.synchronizedMap(new HashMap(3));
    private int b;

    /* JADX WARN: Multi-variable type inference failed */
    private C3317a() {
        EventType[] values;
        p();
        for (EventType eventType : EventType.values()) {
            Class<? extends ve0> cls = eventType.getCls();
            AMConifg d2 = d(Variables.n().k().i(cls, null, "module,mp ASC ", -1));
            if (d2 == null) {
                try {
                    AMConifg aMConifg = (AMConifg) cls.newInstance();
                    try {
                        aMConifg.module = "event_type";
                        aMConifg.setSampling(eventType.getDefaultSampling());
                    } catch (Exception unused) {
                    }
                    d2 = aMConifg;
                } catch (Exception unused2) {
                }
            }
            this.a.put(eventType, d2);
        }
    }

    private AMConifg d(List<AMConifg> list) {
        AMConifg aMConifg;
        int size = list.size();
        int i = 0;
        while (i < size && !"event_type".equalsIgnoreCase(list.get(i).module)) {
            i++;
        }
        if (i < size) {
            aMConifg = list.remove(i);
            Logger.r("remove root element", new Object[0]);
        } else {
            Logger.r("cannot found the root element", new Object[0]);
            aMConifg = null;
        }
        if (aMConifg == null) {
            return null;
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AMConifg aMConifg2 = list.get(i2);
            if (TextUtils.isEmpty(aMConifg2.monitorPoint)) {
                aMConifg.add(aMConifg2.module, aMConifg2);
            } else {
                aMConifg.getOrBulidNext(aMConifg2.module).add(aMConifg2.monitorPoint, aMConifg2);
            }
        }
        return aMConifg;
    }

    public static C3317a h() {
        if (c == null) {
            synchronized (C3317a.class) {
                if (c == null) {
                    c = new C3317a();
                }
            }
        }
        return c;
    }

    private boolean m(EventType eventType, String str, String str2) {
        if (eventType != null && eventType == EventType.COUNTER && ea2.module.equalsIgnoreCase(str)) {
            return ea2.UPLOAD_TRAFFIC_OFFLINE.equalsIgnoreCase(str2) || ea2.TNET_REQUEST_SEND_OFFLINE.equalsIgnoreCase(str2);
        }
        return false;
    }

    private AMConifg n(Class<? extends AMConifg> cls, JSONObject jSONObject) {
        AMConifg aMConifg = null;
        try {
            AMConifg newInstance = cls.newInstance();
            try {
                if (jSONObject.containsKey("offline")) {
                    newInstance.offline = jSONObject.getString("offline");
                }
                if (jSONObject.containsKey("cp")) {
                    newInstance.setSampling(jSONObject.getIntValue("cp"));
                }
                if (newInstance instanceof AlarmConfig) {
                    AlarmConfig alarmConfig = (AlarmConfig) newInstance;
                    if (jSONObject.containsKey("scp")) {
                        alarmConfig.successSampling = jSONObject.getIntValue("scp");
                    }
                    if (jSONObject.containsKey("fcp")) {
                        alarmConfig.failSampling = jSONObject.getIntValue("fcp");
                    }
                    return alarmConfig;
                } else if (newInstance instanceof StatConfig) {
                    StatConfig statConfig = (StatConfig) newInstance;
                    if (jSONObject.containsKey("detail")) {
                        statConfig.detail = jSONObject.getIntValue("detail");
                        return newInstance;
                    }
                    return newInstance;
                } else {
                    return newInstance;
                }
            } catch (Throwable unused) {
                aMConifg = newInstance;
                Logger.i("new AppMonitorConfig error", new Object[0]);
                return aMConifg;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // tb.zs2
    public String[] a() {
        return d;
    }

    @Override // tb.zs2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.zs2
    public void c(String str, Map<String, String> map) {
        AMConifg newInstance;
        Logger.f("", "namespace", str, "config:", map);
        if (yh2.e(str) || map == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        EventType eventTypeByNameSpace = EventType.getEventTypeByNameSpace(str);
        Class cls = eventTypeByNameSpace.getCls();
        try {
            if (map.containsKey("event_type")) {
                newInstance = n(cls, JSON.parseObject(map.get("event_type")));
                map.remove("event_type");
            } else {
                try {
                    newInstance = cls.newInstance();
                    if (newInstance instanceof AlarmConfig) {
                        AlarmConfig alarmConfig = (AlarmConfig) newInstance;
                        alarmConfig.successSampling = eventTypeByNameSpace.getDefaultSampling();
                        alarmConfig.failSampling = eventTypeByNameSpace.getDefaultSampling();
                    } else {
                        newInstance.setSampling(eventTypeByNameSpace.getDefaultSampling());
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            newInstance.module = "event_type";
            for (String str2 : map.keySet()) {
                JSONObject parseObject = JSON.parseObject(map.get(str2));
                if (parseObject != null) {
                    AMConifg n = n(cls, parseObject);
                    n.module = str2;
                    JSONObject jSONObject = parseObject.getJSONObject("mps");
                    if (jSONObject != null) {
                        for (String str3 : jSONObject.keySet()) {
                            AMConifg n2 = n(cls, jSONObject.getJSONObject(str3));
                            n2.module = str2;
                            n2.monitorPoint = str3;
                            n.add(str3, n2);
                            arrayList.add(n2);
                        }
                    }
                    newInstance.add(str2, n);
                    arrayList.add(n);
                }
            }
            arrayList.add(newInstance);
            this.a.put(eventTypeByNameSpace, newInstance);
            Variables.n().k().b(newInstance.getClass());
            Variables.n().k().q(arrayList);
        } catch (Throwable th) {
            Logger.i("", "parse config error", th);
        }
    }

    public boolean e(String str, String str2, Boolean bool, Map<String, String> map) {
        return i(str, str2, bool, map);
    }

    public boolean f(EventType eventType, String str, String str2) {
        return l(eventType, str, str2, null);
    }

    public boolean g(EventType eventType, String str, String str2, Map<String, String> map) {
        return l(eventType, str, str2, map);
    }

    public boolean i(String str, String str2, Boolean bool, Map<String, String> map) {
        AMConifg aMConifg = this.a.get(EventType.ALARM);
        if (aMConifg == null || !(aMConifg instanceof AlarmConfig)) {
            return false;
        }
        return ((AlarmConfig) aMConifg).isSampled(this.b, str, str2, bool, map);
    }

    public boolean j(String str, String str2) {
        AMConifg aMConifg = this.a.get(EventType.STAT);
        if (aMConifg == null) {
            return false;
        }
        return ((StatConfig) aMConifg).isDetail(str, str2);
    }

    public boolean k(EventType eventType, String str, String str2) {
        if (m(eventType, str, str2)) {
            return true;
        }
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            return aMConifg.isOffline(str, str2);
        }
        return false;
    }

    public boolean l(EventType eventType, String str, String str2, Map<String, String> map) {
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            return aMConifg.isSampled(this.b, str, str2, map);
        }
        Logger.f("eventTypeSample  ==null", new Object[0]);
        return false;
    }

    public void o(EventType eventType, int i) {
        AMConifg aMConifg = this.a.get(eventType);
        if (aMConifg != null) {
            aMConifg.setSampling(i);
        }
        Logger.f("setSampling end", new Object[0]);
    }

    public void p() {
        this.b = new Random().nextInt(10000);
    }
}
