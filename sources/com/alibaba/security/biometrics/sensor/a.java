package com.alibaba.security.biometrics.sensor;

import android.app.Activity;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.alibaba.security.biometrics.sensor.a.b;
import com.alibaba.security.biometrics.sensor.a.c;
import com.alibaba.security.biometrics.sensor.a.d;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.model.DisplayInfo;
import com.alibaba.security.biometrics.sensor.model.MotionEventData;
import com.alibaba.security.biometrics.sensor.model.RpCollectInfo;
import com.alibaba.security.biometrics.sensor.model.SensorData;
import com.alibaba.security.common.d.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements com.alibaba.security.biometrics.sensor.api.a {
    public static final String a = "key_need_collect";
    public static final String b = "key_enabled_sensors";
    public static final String c = "key_interval";
    public static final String d = "key_max_click_count";
    public static final String e = "key_max_sensor_count";
    public static final String f = "processResult";
    public static final String g = "data";
    private final b l;
    private final c m;
    private final d n;
    private final String o;
    private volatile boolean p = false;

    public a(Activity activity) {
        this.l = new b(activity);
        this.m = new c(activity);
        this.n = new d(activity);
        this.o = activity.getClass().getSimpleName();
    }

    @Override // com.alibaba.security.biometrics.sensor.api.a
    public final void a(HashMap<String, String> hashMap) throws RpSecException {
        String str = hashMap.get(a);
        if (!TextUtils.isEmpty(str)) {
            this.p = Boolean.parseBoolean(str);
        }
        com.alibaba.security.biometrics.sensor.b.a aVar = new com.alibaba.security.biometrics.sensor.b.a(hashMap);
        this.l.a(aVar);
        this.m.a(aVar);
        this.n.a(aVar);
    }

    @Override // com.alibaba.security.biometrics.sensor.api.a
    public final HashMap<String, Object> a(int i) throws RpSecException {
        if (this.p) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (i == 1) {
                this.l.a();
                this.m.a();
                this.n.a();
                hashMap.put(f, Boolean.TRUE);
                hashMap.put("data", null);
            } else if (i == 2) {
                ArrayList arrayList = new ArrayList();
                RpCollectInfo rpCollectInfo = new RpCollectInfo();
                List<DisplayInfo> b2 = this.l.b();
                List<MotionEventData> list = this.m.d;
                List<SensorData> list2 = this.n.d;
                rpCollectInfo.setActivityName(this.o);
                rpCollectInfo.setDisplayInfoArray(b2);
                rpCollectInfo.setDisplayModelSize(b2.size());
                rpCollectInfo.setSensorDataArray(list2);
                rpCollectInfo.setSensorListSize(list2.size());
                rpCollectInfo.setMotionDataArray(list);
                rpCollectInfo.setMotionListSize(list.size());
                rpCollectInfo.setTimestamp(System.currentTimeMillis());
                arrayList.add(rpCollectInfo);
                hashMap.put(f, Boolean.TRUE);
                hashMap.put("data", h.a(arrayList));
            } else if (i == 3) {
                this.m.c = false;
                d dVar = this.n;
                SensorManager sensorManager = dVar.c;
                if (sensorManager != null) {
                    dVar.e = false;
                    sensorManager.unregisterListener(dVar);
                    hashMap.put(f, Boolean.TRUE);
                    hashMap.put("data", null);
                } else {
                    throw new RpSecException("No sensor manager found while processing stop", -200);
                }
            } else if (i == 4) {
                this.m.d();
                this.n.d();
                hashMap.put(f, Boolean.TRUE);
                hashMap.put("data", null);
            }
            return hashMap;
        }
        throw new RpSecException("There is no need to collect device data", (int) RpSecException.EXCEPTION_NO_NEED_FOR_COLLECTION);
    }

    private List<RpCollectInfo> a() {
        ArrayList arrayList = new ArrayList();
        RpCollectInfo rpCollectInfo = new RpCollectInfo();
        List<DisplayInfo> b2 = this.l.b();
        List<MotionEventData> list = this.m.d;
        List<SensorData> list2 = this.n.d;
        rpCollectInfo.setActivityName(this.o);
        rpCollectInfo.setDisplayInfoArray(b2);
        rpCollectInfo.setDisplayModelSize(b2.size());
        rpCollectInfo.setSensorDataArray(list2);
        rpCollectInfo.setSensorListSize(list2.size());
        rpCollectInfo.setMotionDataArray(list);
        rpCollectInfo.setMotionListSize(list.size());
        rpCollectInfo.setTimestamp(System.currentTimeMillis());
        arrayList.add(rpCollectInfo);
        return arrayList;
    }
}
