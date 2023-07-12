package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z0 implements SensorEventListener {
    private Context a;
    SensorManager b;
    Sensor c;
    Sensor d;
    Sensor e;
    public boolean f = false;
    public double g = 0.0d;
    private float h = 1013.25f;
    private float i = 0.0f;
    Handler j = new Handler();
    double k = 0.0d;
    double l = 0.0d;
    double m = 0.0d;
    double n = 0.0d;
    double[] o = new double[3];
    volatile double p = 0.0d;
    long q = 0;
    long r = 0;

    public z0(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        try {
            this.a = context;
            if (this.b == null) {
                this.b = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.c = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 6);
            } catch (Throwable unused) {
            }
            try {
                this.d = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 11);
            } catch (Throwable unused2) {
            }
            try {
                this.e = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.b, 1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            j1.h(th, "AMapSensorManager", "<init>");
        }
    }

    private void b(float[] fArr) {
        double[] dArr = this.o;
        dArr[0] = (dArr[0] * 0.800000011920929d) + (fArr[0] * 0.19999999f);
        dArr[1] = (dArr[1] * 0.800000011920929d) + (fArr[1] * 0.19999999f);
        dArr[2] = (dArr[2] * 0.800000011920929d) + (fArr[2] * 0.19999999f);
        this.k = fArr[0] - dArr[0];
        this.l = fArr[1] - dArr[1];
        this.m = fArr[2] - dArr[2];
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.q < 100) {
            return;
        }
        double d = this.k;
        double d2 = this.l;
        double d3 = (d * d) + (d2 * d2);
        double d4 = this.m;
        double sqrt = Math.sqrt(d3 + (d4 * d4));
        this.r++;
        this.q = currentTimeMillis;
        this.p += sqrt;
        if (this.r >= 30) {
            this.n = this.p / this.r;
            this.p = 0.0d;
            this.r = 0L;
        }
    }

    private void d(float[] fArr) {
        if (fArr != null) {
            this.g = m1.b(SensorManager.getAltitude(this.h, fArr[0]));
        }
    }

    private void f(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            float[] fArr3 = new float[3];
            SensorManager.getOrientation(fArr2, fArr3);
            float degrees = (float) Math.toDegrees(fArr3[0]);
            this.i = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.i = (float) Math.floor(degrees);
        }
    }

    public final void a() {
        SensorManager sensorManager = this.b;
        if (sensorManager == null || this.f) {
            return;
        }
        this.f = true;
        try {
            Sensor sensor = this.c;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.j);
            }
        } catch (Throwable th) {
            j1.h(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.d;
            if (sensor2 != null) {
                this.b.registerListener(this, sensor2, 3, this.j);
            }
        } catch (Throwable th2) {
            j1.h(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.e;
            if (sensor3 != null) {
                this.b.registerListener(this, sensor3, 3, this.j);
            }
        } catch (Throwable th3) {
            j1.h(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public final void c() {
        SensorManager sensorManager = this.b;
        if (sensorManager == null || !this.f) {
            return;
        }
        this.f = false;
        try {
            Sensor sensor = this.c;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.d;
            if (sensor2 != null) {
                this.b.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.e;
            if (sensor3 != null) {
                this.b.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }

    public final double e() {
        return this.g;
    }

    public final float g() {
        return this.i;
    }

    public final double h() {
        return this.n;
    }

    public final void i() {
        try {
            c();
            this.c = null;
            this.d = null;
            this.b = null;
            this.e = null;
            this.f = false;
        } catch (Throwable th) {
            j1.h(th, "AMapSensorManager", Constants.Event.SLOT_LIFECYCLE.DESTORY);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.e != null) {
                    b((float[]) sensorEvent.values.clone());
                }
            } else if (type != 6) {
                if (type != 11) {
                    return;
                }
                try {
                    if (this.d != null) {
                        f((float[]) sensorEvent.values.clone());
                    }
                } catch (Throwable unused) {
                }
            } else {
                try {
                    if (this.c != null) {
                        float[] fArr = (float[]) sensorEvent.values.clone();
                        float f = fArr[0];
                        d(fArr);
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }
}
