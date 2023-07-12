package com.alibaba.aliweex.adapter.module;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.aliweex.utils.MemoryMonitor;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXModule;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXDeviceModule extends WXModule {
    private SensorManager sm = null;
    private Sensor accelerometerSensor = null;
    private Sensor magneticFieldSensor = null;
    private Sensor orientationSensor = null;
    float[] accelerometerValues = new float[3];
    float[] magneticFieldValues = new float[3];
    float[] orientationValues = new float[3];
    private Hashtable<JSCallback, Double> successCallbacks = new Hashtable<>();
    private Hashtable<JSCallback, Long> lastUpdateTimes = new Hashtable<>();
    private HashMap datasMap = new HashMap();
    private int sensorSpeed = 3;
    final SensorEventListener sensorEventListener = new a();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = WXDeviceModule.this.orientationValues;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = WXDeviceModule.this.magneticFieldValues;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            } else if (sensorEvent.sensor.getType() == 1) {
                float[] fArr5 = sensorEvent.values;
                float[] fArr6 = WXDeviceModule.this.accelerometerValues;
                System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
            }
            Enumeration keys = WXDeviceModule.this.successCallbacks.keys();
            while (keys.hasMoreElements()) {
                JSCallback jSCallback = (JSCallback) keys.nextElement();
                if (jSCallback != null) {
                    Double d = (Double) WXDeviceModule.this.successCallbacks.get(jSCallback);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - (WXDeviceModule.this.lastUpdateTimes.containsKey(jSCallback) ? ((Long) WXDeviceModule.this.lastUpdateTimes.get(jSCallback)).longValue() : 0L) < d.doubleValue()) {
                        return;
                    }
                    WXDeviceModule.this.lastUpdateTimes.put(jSCallback, Long.valueOf(currentTimeMillis));
                    float[] fArr7 = new float[3];
                    float[] fArr8 = new float[9];
                    WXDeviceModule wXDeviceModule = WXDeviceModule.this;
                    SensorManager.getRotationMatrix(fArr8, null, wXDeviceModule.accelerometerValues, wXDeviceModule.magneticFieldValues);
                    SensorManager.getOrientation(fArr8, fArr7);
                    SensorManager.getOrientation(fArr8, fArr7);
                    double d2 = -Math.toDegrees(fArr7[0]);
                    while (d2 < 0.0d) {
                        d2 += 360.0d;
                    }
                    double degrees = Math.toDegrees(fArr7[2]);
                    if (degrees > 90.0d) {
                        degrees -= 180.0d;
                    } else if (degrees < -90.0d) {
                        degrees += 180.0d;
                    }
                    if (d2 == 0.0d && degrees == 0.0d) {
                        return;
                    }
                    WXDeviceModule.this.datasMap.put("alpha", Double.valueOf(d2));
                    WXDeviceModule.this.datasMap.put("beta", Float.valueOf(-WXDeviceModule.this.orientationValues[1]));
                    WXDeviceModule.this.datasMap.put("gamma", Double.valueOf(degrees));
                    jSCallback.invokeAndKeepAlive(WXDeviceModule.this.datasMap);
                }
            }
        }
    }

    @JSMethod(uiThread = false)
    public void getLevel(JSCallback jSCallback) {
        String b = MemoryMonitor.b();
        HashMap hashMap = new HashMap(1);
        hashMap.put("summary", b);
        jSCallback.invoke(hashMap);
    }

    @JSMethod(uiThread = false)
    public void getMemoryInfo(JSCallback jSCallback) {
        String c = MemoryMonitor.c();
        HashMap hashMap = new HashMap(1);
        hashMap.put("evaluatedStatus", c);
        jSCallback.invoke(hashMap);
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.sensorEventListener);
        }
        super.onActivityPause();
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            sensorManager.registerListener(this.sensorEventListener, this.accelerometerSensor, this.sensorSpeed);
            this.sm.registerListener(this.sensorEventListener, this.magneticFieldSensor, this.sensorSpeed);
            this.sm.registerListener(this.sensorEventListener, this.orientationSensor, this.sensorSpeed);
        }
        super.onActivityResume();
    }

    @JSMethod(uiThread = false)
    public void stopOrientation(String str) {
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.sensorEventListener);
            this.sm = null;
        }
        Hashtable<JSCallback, Double> hashtable = this.successCallbacks;
        if (hashtable != null) {
            hashtable.clear();
        }
        Hashtable<JSCallback, Long> hashtable2 = this.lastUpdateTimes;
        if (hashtable2 != null) {
            hashtable2.clear();
        }
    }

    @JSMethod(uiThread = false)
    public void watchOrientation(String str, JSCallback jSCallback, JSCallback jSCallback2) {
        double d = 83.0d;
        try {
            d = new JSONObject(str).optDouble(Constants.Name.INTERVAL, 83.0d);
            if (d < 16.7d) {
                d = 16.7d;
            }
        } catch (JSONException unused) {
        }
        if (d < 50.0d) {
            this.sensorSpeed = 0;
        } else if (d < 100.0d) {
            this.sensorSpeed = 1;
        }
        SensorManager sensorManager = (SensorManager) this.mWXSDKInstance.getContext().getSystemService("sensor");
        this.sm = sensorManager;
        this.sm.registerListener(this.sensorEventListener, com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, -1), 3);
        this.accelerometerSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.sm, 1);
        this.magneticFieldSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.sm, 2);
        this.orientationSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.sm, 3);
        this.sm.registerListener(this.sensorEventListener, this.accelerometerSensor, this.sensorSpeed);
        this.sm.registerListener(this.sensorEventListener, this.magneticFieldSensor, this.sensorSpeed);
        this.sm.registerListener(this.sensorEventListener, this.orientationSensor, this.sensorSpeed);
        Hashtable<JSCallback, Double> hashtable = this.successCallbacks;
        if (hashtable != null) {
            hashtable.put(jSCallback, Double.valueOf(d));
        }
    }
}
