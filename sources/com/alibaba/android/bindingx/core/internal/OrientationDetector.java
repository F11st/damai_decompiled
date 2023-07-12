package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tb.bb1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class OrientationDetector implements SensorEventListener {
    private static OrientationDetector p;
    private static final Object q = new Object();
    private static final Set<Integer> r = o.j(15);
    private static final Set<Integer> s = o.j(11);
    private static final Set<Integer> t = o.j(1, 2);
    private HandlerThread a;
    private Handler b;
    private final Context c;
    private float[] d;
    private float[] e;
    private float[] f;
    private double[] g;
    @VisibleForTesting
    SensorManagerProxy h;
    private Set<Integer> k;
    private boolean l;
    private boolean m;
    private boolean n;
    private final Set<Integer> i = new HashSet();
    private ArrayList<OnOrientationChangedListener> o = new ArrayList<>();
    private final List<Set<Integer>> j = o.i(r, s, t);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface OnOrientationChangedListener {
        void onOrientationChanged(double d, double d2, double d3);
    }

    private OrientationDetector(@NonNull Context context) {
        this.c = context.getApplicationContext();
    }

    private static double[] b(float[] fArr, double[] dArr) {
        if (fArr.length != 9) {
            return dArr;
        }
        if (fArr[8] > 0.0f) {
            dArr[0] = Math.atan2(-fArr[1], fArr[4]);
            dArr[1] = Math.asin(fArr[7]);
            dArr[2] = Math.atan2(-fArr[6], fArr[8]);
        } else if (fArr[8] < 0.0f) {
            dArr[0] = Math.atan2(fArr[1], -fArr[4]);
            dArr[1] = -Math.asin(fArr[7]);
            dArr[1] = dArr[1] + (dArr[1] >= 0.0d ? -3.141592653589793d : 3.141592653589793d);
            dArr[2] = Math.atan2(fArr[6], -fArr[8]);
        } else {
            if (fArr[6] > 0.0f) {
                dArr[0] = Math.atan2(-fArr[1], fArr[4]);
                dArr[1] = Math.asin(fArr[7]);
                dArr[2] = -1.5707963267948966d;
            } else if (fArr[6] < 0.0f) {
                dArr[0] = Math.atan2(fArr[1], -fArr[4]);
                dArr[1] = -Math.asin(fArr[7]);
                dArr[1] = dArr[1] + (dArr[1] >= 0.0d ? -3.141592653589793d : 3.141592653589793d);
                dArr[2] = -1.5707963267948966d;
            } else {
                dArr[0] = Math.atan2(fArr[3], fArr[0]);
                dArr[1] = fArr[7] > 0.0f ? 1.5707963267948966d : -1.5707963267948966d;
                dArr[2] = 0.0d;
            }
        }
        if (dArr[0] < 0.0d) {
            dArr[0] = dArr[0] + 6.283185307179586d;
        }
        return dArr;
    }

    private void c(float[] fArr, double[] dArr) {
        if (fArr.length > 4) {
            System.arraycopy(fArr, 0, this.e, 0, 4);
            SensorManager.getRotationMatrixFromVector(this.f, this.e);
        } else {
            SensorManager.getRotationMatrixFromVector(this.f, fArr);
        }
        b(this.f, dArr);
        for (int i = 0; i < 3; i++) {
            dArr[i] = Math.toDegrees(dArr[i]);
        }
    }

    private void d() {
        if (this.f == null) {
            this.f = new float[9];
        }
        if (this.g == null) {
            this.g = new double[3];
        }
        if (this.e == null) {
            this.e = new float[4];
        }
    }

    private Handler e() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("DeviceOrientation");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.a.getLooper());
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OrientationDetector f(Context context) {
        OrientationDetector orientationDetector;
        synchronized (q) {
            if (p == null) {
                p = new OrientationDetector(context);
            }
            orientationDetector = p;
        }
        return orientationDetector;
    }

    private void g(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr2 == null || !SensorManager.getRotationMatrix(this.f, null, fArr, fArr2)) {
            return;
        }
        b(this.f, this.g);
        j(Math.toDegrees(this.g[0]), Math.toDegrees(this.g[1]), Math.toDegrees(this.g[2]));
    }

    private String h() {
        if (this.n) {
            return "NOT_AVAILABLE";
        }
        Set<Integer> set = this.k;
        return set == r ? "GAME_ROTATION_VECTOR" : set == s ? "ROTATION_VECTOR" : set == t ? "ACCELEROMETER_MAGNETIC" : "NOT_AVAILABLE";
    }

    private SensorManagerProxy i() {
        SensorManagerProxy sensorManagerProxy = this.h;
        if (sensorManagerProxy != null) {
            return sensorManagerProxy;
        }
        SensorManager sensorManager = (SensorManager) this.c.getSystemService("sensor");
        if (sensorManager != null) {
            this.h = new m(sensorManager);
        }
        return this.h;
    }

    private boolean k(int i, int i2) {
        SensorManagerProxy i3 = i();
        if (i3 == null) {
            return false;
        }
        return i3.registerListener(this, i, i2, e());
    }

    private boolean l(int i) {
        if (this.n) {
            return false;
        }
        if (this.k != null) {
            String h = h();
            bb1.a("[OrientationDetector] register sensor:" + h);
            return m(this.k, i, true);
        }
        d();
        for (Set<Integer> set : this.j) {
            this.k = set;
            if (m(set, i, true)) {
                String h2 = h();
                bb1.a("[OrientationDetector] register sensor:" + h2);
                return true;
            }
        }
        this.n = true;
        this.k = null;
        this.f = null;
        this.g = null;
        return false;
    }

    private boolean m(Set<Integer> set, int i, boolean z) {
        HashSet<Integer> hashSet = new HashSet(set);
        hashSet.removeAll(this.i);
        if (hashSet.isEmpty()) {
            return true;
        }
        boolean z2 = false;
        for (Integer num : hashSet) {
            boolean k = k(num.intValue(), i);
            if (!k && z) {
                r(hashSet);
                return false;
            } else if (k) {
                this.i.add(num);
                z2 = true;
            }
        }
        return z2;
    }

    private void o(boolean z) {
        this.l = z;
        this.m = z && this.k == t;
    }

    private void r(Iterable<Integer> iterable) {
        for (Integer num : iterable) {
            if (this.i.contains(num)) {
                i().unregisterListener(this, num.intValue());
                this.i.remove(num);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull OnOrientationChangedListener onOrientationChangedListener) {
        ArrayList<OnOrientationChangedListener> arrayList = this.o;
        if (arrayList == null || arrayList.contains(onOrientationChangedListener)) {
            return;
        }
        this.o.add(onOrientationChangedListener);
    }

    @VisibleForTesting
    void j(double d, double d2, double d3) {
        ArrayList<OnOrientationChangedListener> arrayList = this.o;
        if (arrayList != null) {
            try {
                Iterator<OnOrientationChangedListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onOrientationChanged(d, d2, d3);
                }
            } catch (Throwable th) {
                bb1.c("[OrientationDetector] ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(@Nullable OnOrientationChangedListener onOrientationChangedListener) {
        ArrayList<OnOrientationChangedListener> arrayList = this.o;
        if (arrayList != null) {
            if (onOrientationChangedListener == null) {
                arrayList.clear();
                return true;
            }
            return arrayList.remove(onOrientationChangedListener);
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (type == 1) {
            if (this.m) {
                g(fArr, this.d);
            }
        } else if (type == 2) {
            if (this.m) {
                if (this.d == null) {
                    this.d = new float[3];
                }
                float[] fArr2 = this.d;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            }
        } else if (type == 11) {
            if (this.l && this.k == s) {
                c(fArr, this.g);
                double[] dArr = this.g;
                j(dArr[0], dArr[1], dArr[2]);
            }
        } else if (type != 15) {
            bb1.b("unexpected sensor type:" + type);
        } else if (this.l) {
            c(fArr, this.g);
            double[] dArr2 = this.g;
            j(dArr2[0], dArr2[1], dArr2[2]);
        }
    }

    public boolean p(int i) {
        bb1.a("[OrientationDetector] sensor started");
        boolean l = l(i);
        if (l) {
            o(true);
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        bb1.a("[OrientationDetector] sensor stopped");
        r(new HashSet(this.i));
        o(false);
    }
}
