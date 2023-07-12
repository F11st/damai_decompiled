package com.alibaba.security.biometrics.sensor.a;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.security.biometrics.sensor.api.RpSecException;
import com.alibaba.security.biometrics.sensor.model.SensorData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d extends a<List<SensorData>> implements SensorEventListener {
    private static final String f = d.class.getSimpleName();
    public SensorManager c;
    public final List<SensorData> d;
    public boolean e;
    private final List<Sensor> g;

    public d(Activity activity) {
        super(activity);
        this.g = new ArrayList();
        this.d = new ArrayList();
        this.e = false;
    }

    private List<SensorData> e() {
        return this.d;
    }

    private boolean f() {
        return this.e;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a(com.alibaba.security.biometrics.sensor.b.a aVar) throws RpSecException {
        super.a(aVar);
        Activity activity = this.a;
        if (activity != null) {
            SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
            this.c = sensorManager;
            if (sensorManager != null) {
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null && sensorList.size() > 0) {
                    com.alibaba.security.biometrics.sensor.b.a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.a();
                        if (this.b.a().size() > 0) {
                            for (Sensor sensor : sensorList) {
                                for (Integer num : this.b.a()) {
                                    if (num.intValue() == sensor.getType()) {
                                        this.g.add(sensor);
                                    }
                                }
                            }
                            return;
                        }
                    }
                    throw new RpSecException("The collector strategy is null", -400);
                }
                throw new RpSecException("No sensors found on this device", -300);
            }
            throw new RpSecException("No sensor manager found while get system service", -200);
        }
        throw new RpSecException("No activity found when initialized", -100);
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final /* bridge */ /* synthetic */ List<SensorData> b() {
        return this.d;
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final boolean c() throws RpSecException {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            this.e = false;
            sensorManager.unregisterListener(this);
            return false;
        }
        throw new RpSecException("No sensor manager found while processing stop", -200);
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void d() throws RpSecException {
        if (this.c != null) {
            List<SensorData> list = this.d;
            if (list != null) {
                list.clear();
                return;
            }
            return;
        }
        throw new RpSecException("No sensor manager found while processing reset", -200);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.g.contains(sensorEvent.sensor)) {
            String str = f;
            com.alibaba.security.common.c.a.a(str, "<SENSOR_TEST_LOG> Into SensorData collecting >>> 2");
            if (this.e) {
                int size = this.d.size();
                com.alibaba.security.biometrics.sensor.b.a aVar = this.b;
                int i = aVar.b;
                if (i > 2000 || i <= 0) {
                    aVar.b = 2000;
                }
                if (size <= aVar.b) {
                    com.alibaba.security.common.c.a.a(str, "<SENSOR_TEST_LOG> SensorData collecting now >>> 3");
                    SensorData sensorData = new SensorData();
                    if (sensorEvent.sensor.getType() == 1) {
                        sensorData.setType(1);
                        float[] fArr = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr[0], fArr[1], fArr[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 4) {
                        sensorData.setType(4);
                        float[] fArr2 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr2[0], fArr2[1], fArr2[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 9) {
                        sensorData.setType(9);
                        float[] fArr3 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr3[0], fArr3[1], fArr3[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 2) {
                        sensorData.setType(2);
                        float[] fArr4 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr4[0], fArr4[1], fArr4[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 10) {
                        sensorData.setType(10);
                        float[] fArr5 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr5[0], fArr5[1], fArr5[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 5) {
                        sensorData.setType(5);
                        sensorData.setValues(new float[]{sensorEvent.values[0]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 6) {
                        sensorData.setType(6);
                        sensorData.setValues(new float[]{sensorEvent.values[0]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 13) {
                        sensorData.setType(7);
                        sensorData.setValues(new float[]{sensorEvent.values[0]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 8) {
                        sensorData.setType(8);
                        sensorData.setValues(new float[]{sensorEvent.values[0]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 3) {
                        sensorData.setType(9);
                        float[] fArr6 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr6[0], fArr6[1], fArr6[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    if (sensorEvent.sensor.getType() == 11) {
                        sensorData.setType(11);
                        float[] fArr7 = sensorEvent.values;
                        sensorData.setValues(new float[]{fArr7[0], fArr7[1], fArr7[2]});
                        sensorData.setTimestamp(System.currentTimeMillis());
                    }
                    this.d.add(sensorData);
                }
            }
        }
    }

    @Override // com.alibaba.security.biometrics.sensor.a.a
    public final void a() throws RpSecException {
        if (this.c != null) {
            List<Sensor> list = this.g;
            if (list != null && list.size() > 0) {
                this.e = true;
                for (Sensor sensor : this.g) {
                    this.c.registerListener(this, sensor, 2);
                }
                return;
            }
            throw new RpSecException("No enabled sensors", (int) RpSecException.EXCEPTION_NO_ENABLED_SENSORS);
        }
        throw new RpSecException("No sensor manager found while processing start", -200);
    }

    private static SensorData a(SensorEvent sensorEvent) {
        SensorData sensorData = new SensorData();
        if (sensorEvent.sensor.getType() == 1) {
            sensorData.setType(1);
            float[] fArr = sensorEvent.values;
            sensorData.setValues(new float[]{fArr[0], fArr[1], fArr[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 4) {
            sensorData.setType(4);
            float[] fArr2 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr2[0], fArr2[1], fArr2[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 9) {
            sensorData.setType(9);
            float[] fArr3 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr3[0], fArr3[1], fArr3[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 2) {
            sensorData.setType(2);
            float[] fArr4 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr4[0], fArr4[1], fArr4[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 10) {
            sensorData.setType(10);
            float[] fArr5 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr5[0], fArr5[1], fArr5[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 5) {
            sensorData.setType(5);
            sensorData.setValues(new float[]{sensorEvent.values[0]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 6) {
            sensorData.setType(6);
            sensorData.setValues(new float[]{sensorEvent.values[0]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 13) {
            sensorData.setType(7);
            sensorData.setValues(new float[]{sensorEvent.values[0]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 8) {
            sensorData.setType(8);
            sensorData.setValues(new float[]{sensorEvent.values[0]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 3) {
            sensorData.setType(9);
            float[] fArr6 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr6[0], fArr6[1], fArr6[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        if (sensorEvent.sensor.getType() == 11) {
            sensorData.setType(11);
            float[] fArr7 = sensorEvent.values;
            sensorData.setValues(new float[]{fArr7[0], fArr7[1], fArr7[2]});
            sensorData.setTimestamp(System.currentTimeMillis());
        }
        return sensorData;
    }
}
