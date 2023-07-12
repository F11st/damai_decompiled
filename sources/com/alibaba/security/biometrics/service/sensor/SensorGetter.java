package com.alibaba.security.biometrics.service.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.security.common.c.C3800a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SensorGetter implements SensorEventListener {
    private static final String TAG = "SensorGetter";
    @SuppressLint({"StaticFieldLeak"})
    private static SensorGetter mSensorGetter;
    private Context context;
    private ThreadPoolExecutor executorService;
    private Sensor mLightSensor;
    private Sensor mProximitySensor;
    private SensorManager mSensorManager;
    private Handler mUiHandler;
    private boolean started;
    private float mLightValue = -1.0f;
    private float mProximityValue = -1.0f;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface SensorCallback {
        void onGetSensorValue(float f);
    }

    private SensorGetter() {
    }

    public static SensorGetter getDefault() {
        if (mSensorGetter == null) {
            synchronized (SensorGetter.class) {
                if (mSensorGetter == null) {
                    mSensorGetter = new SensorGetter();
                }
            }
        }
        return mSensorGetter;
    }

    public void collectLightSensorInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(5, sensorCallback);
    }

    public void collectOneShotAsync(final int i, final SensorCallback sensorCallback) {
        if (this.executorService == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "rpsdk-sensorGetter");
                }
            });
            this.executorService = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        if (this.mUiHandler == null) {
            this.mUiHandler = new Handler(Looper.getMainLooper());
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.executorService;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.submit(new Runnable() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2
                @Override // java.lang.Runnable
                public void run() {
                    final long currentTimeMillis = System.currentTimeMillis();
                    if (sensorCallback != null) {
                        if (SensorGetter.this.mSensorManager == null) {
                            SensorGetter sensorGetter = SensorGetter.this;
                            sensorGetter.mSensorManager = (SensorManager) sensorGetter.context.getApplicationContext().getSystemService("sensor");
                        }
                        if (SensorGetter.this.mSensorManager != null) {
                            Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(SensorGetter.this.mSensorManager, i);
                            if (defaultSensor == null) {
                                sensorCallback.onGetSensorValue(-1.0f);
                                return;
                            }
                            final CountDownLatch countDownLatch = new CountDownLatch(1);
                            final float[] fArr = new float[1];
                            SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2.1
                                @Override // android.hardware.SensorEventListener
                                public void onAccuracyChanged(Sensor sensor, int i2) {
                                }

                                @Override // android.hardware.SensorEventListener
                                public void onSensorChanged(SensorEvent sensorEvent) {
                                    try {
                                        try {
                                            fArr[0] = sensorEvent.values[0];
                                            C3800a.b(SensorGetter.TAG, "name:" + sensorEvent.sensor.getName() + "\tvalue:" + sensorEvent.values[0] + "\tcost:" + (System.currentTimeMillis() - currentTimeMillis));
                                        } catch (Exception unused) {
                                            C3800a.b();
                                        }
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            };
                            if (Build.VERSION.SDK_INT >= 19) {
                                SensorGetter.this.mSensorManager.registerListener(sensorEventListener, defaultSensor, 3, 0);
                            } else {
                                SensorGetter.this.mSensorManager.registerListener(sensorEventListener, defaultSensor, 3);
                            }
                            try {
                                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
                            } catch (Exception unused) {
                                C3800a.b();
                            }
                            SensorGetter.this.mUiHandler.post(new Runnable() { // from class: com.alibaba.security.biometrics.service.sensor.SensorGetter.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    sensorCallback.onGetSensorValue(fArr[0]);
                                }
                            });
                            if (SensorGetter.this.mSensorManager != null) {
                                SensorGetter.this.mSensorManager.unregisterListener(sensorEventListener, defaultSensor);
                                return;
                            }
                            return;
                        }
                        sensorCallback.onGetSensorValue(-1.0f);
                        return;
                    }
                    C3800a.d(SensorGetter.TAG, "sensorCallback is null");
                }
            });
        }
    }

    public void collectProximityInfo(SensorCallback sensorCallback) {
        collectOneShotAsync(8, sensorCallback);
    }

    public float getCurrentLightValue() {
        return this.mLightValue;
    }

    public float getProximityValue() {
        return this.mProximityValue;
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 5) {
                this.mLightValue = sensorEvent.values[0];
            }
            if (sensorEvent.sensor.getType() == 8) {
                this.mProximityValue = sensorEvent.values[0];
            }
        } catch (Exception unused) {
            C3800a.b();
        }
    }

    public void start() {
        if (this.started) {
            return;
        }
        if (this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) this.context.getApplicationContext().getSystemService("sensor");
        }
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            Sensor defaultSensor = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(sensorManager, 5);
            this.mLightSensor = defaultSensor;
            if (defaultSensor != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mSensorManager.registerListener(this, defaultSensor, 3, 0);
                } else {
                    this.mSensorManager.registerListener(this, defaultSensor, 3);
                }
            }
            Sensor defaultSensor2 = com.alibaba.wireless.security.aopsdk.replace.android.hardware.SensorManager.getDefaultSensor(this.mSensorManager, 8);
            this.mProximitySensor = defaultSensor2;
            if (defaultSensor2 != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mSensorManager.registerListener(this, defaultSensor2, 3, 0);
                } else {
                    this.mSensorManager.registerListener(this, defaultSensor2, 3);
                }
            }
        }
        this.started = true;
    }

    public void stop() {
        if (this.started) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager != null) {
                Sensor sensor = this.mLightSensor;
                if (sensor != null) {
                    sensorManager.unregisterListener(this, sensor);
                }
                Sensor sensor2 = this.mProximitySensor;
                if (sensor2 != null) {
                    this.mSensorManager.unregisterListener(this, sensor2);
                }
            }
            this.mSensorManager = null;
            this.started = false;
        }
    }
}
