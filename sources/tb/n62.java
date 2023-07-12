package tb;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class n62 implements SensorEventListener {
    private Activity b;
    private SensorManager f;
    private Sensor g;
    private boolean a = false;
    private ma2 c = new ma2(120, 3);
    private long d = 0;
    private boolean e = false;

    public n62(Activity activity) {
        this.b = activity;
    }

    private void a(boolean z) {
        if (z == this.e) {
            return;
        }
        if (z) {
            this.b.getWindow().addFlags(128);
        } else {
            this.b.getWindow().clearFlags(128);
        }
        this.e = z;
    }

    private void d() {
        if (!this.a && this.c.f()) {
            a(this.c.c() > 0.2f);
        } else {
            a(true);
        }
    }

    public void b() {
        if (this.f == null) {
            this.f = (SensorManager) this.b.getSystemService("sensor");
        }
        if (this.g == null) {
            this.g = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.f, 1);
        }
        this.e = false;
        a(true);
        this.c.e();
        this.f.registerListener(this, this.g, 250000);
    }

    public void c() {
        SensorManager sensorManager = this.f;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        a(false);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if ((sensorEvent.timestamp - this.d) / 1000000 < 250) {
            return;
        }
        this.c.a(sensorEvent.values);
        this.d = sensorEvent.timestamp;
        d();
    }
}
