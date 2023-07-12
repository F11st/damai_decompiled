package io.flutter.wpkbridge;

import android.webkit.ValueCallback;
import io.flutter.wpkbridge.U4Line;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class U4StatLine extends U4Line implements U4Line.Clearable {
    private static U4Line.RecyclePool<U4StatLine> sPool = new U4Line.RecyclePool<>(U4StatLine.class, new Class[0], new Object[0]);

    public static U4StatLine obtain() {
        return sPool.obtain();
    }

    public void recycle() {
        sPool.recycle(this);
    }

    public U4StatLine sendToTarget(ValueCallback<U4StatLine> valueCallback) {
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this);
        }
        return this;
    }
}
