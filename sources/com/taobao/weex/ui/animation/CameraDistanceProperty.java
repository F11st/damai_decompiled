package com.taobao.weex.ui.animation;

import android.os.Build;
import android.util.Property;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class CameraDistanceProperty extends Property<View, Float> {
    private static final String TAG = "CameraDistance";
    private static CameraDistanceProperty instance;

    private CameraDistanceProperty() {
        super(Float.class, TAG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Property<View, Float> getInstance() {
        return instance;
    }

    @Override // android.util.Property
    public Float get(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Float.valueOf(view.getCameraDistance());
        }
        return Float.valueOf(Float.NaN);
    }

    @Override // android.util.Property
    public void set(View view, Float f) {
        view.setCameraDistance(f.floatValue());
    }
}
