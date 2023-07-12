package com.amap.api.mapcore.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class aa implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private float d;
    private Context e;
    private IAMapDelegate f;
    private Marker g;
    private long c = 0;
    private boolean h = true;

    public aa(Context context, IAMapDelegate iAMapDelegate) {
        this.e = context.getApplicationContext();
        this.f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.b = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(final SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.c < 100) {
                return;
            }
            if (this.f.getGLMapEngine() == null || this.f.getGLMapEngine().getAnimateionsCount() <= 0) {
                ep.a().a(new Runnable() { // from class: com.amap.api.mapcore.util.aa.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (sensorEvent.sensor.getType() != 3) {
                            return;
                        }
                        float a = (sensorEvent.values[0] + aa.a(aa.this.e)) % 360.0f;
                        if (a > 180.0f) {
                            a -= 360.0f;
                        } else if (a < -180.0f) {
                            a += 360.0f;
                        }
                        if (Math.abs(aa.this.d - a) < 3.0f) {
                            return;
                        }
                        aa aaVar = aa.this;
                        if (Float.isNaN(a)) {
                            a = 0.0f;
                        }
                        aaVar.d = a;
                        if (aa.this.g != null) {
                            try {
                                if (!aa.this.h) {
                                    aa.this.g.setRotateAngle(360.0f - aa.this.d);
                                } else {
                                    aa.this.f.moveCamera(ah.d(aa.this.d));
                                    aa.this.g.setRotateAngle(-aa.this.d);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        aa.this.c = System.currentTimeMillis();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.unregisterListener(this, sensor);
    }

    public void a() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager == null || (sensor = this.b) == null) {
            return;
        }
        sensorManager.registerListener(this, sensor, 3);
    }

    public void a(Marker marker) {
        this.g = marker;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public static int a(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(tb.v.ATTACH_MODE_WINDOW)) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : -90;
                }
                return 180;
            }
            return 90;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
