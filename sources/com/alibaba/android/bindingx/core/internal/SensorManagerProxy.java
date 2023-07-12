package com.alibaba.android.bindingx.core.internal;

import android.hardware.SensorEventListener;
import android.os.Handler;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
interface SensorManagerProxy {
    boolean registerListener(SensorEventListener sensorEventListener, int i, int i2, Handler handler);

    void unregisterListener(SensorEventListener sensorEventListener, int i);
}
