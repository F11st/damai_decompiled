package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.content.Context;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class VersionedGestureDetector {
    private static transient /* synthetic */ IpChange $ipChange;

    public static GestureDetector newInstance(Context context, OnGestureListener onGestureListener) {
        GestureDetector froyoGestureDetector;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633466650")) {
            return (GestureDetector) ipChange.ipc$dispatch("633466650", new Object[]{context, onGestureListener});
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            froyoGestureDetector = new CupcakeGestureDetector(context);
        } else if (i < 8) {
            froyoGestureDetector = new EclairGestureDetector(context);
        } else {
            froyoGestureDetector = new FroyoGestureDetector(context);
        }
        froyoGestureDetector.setOnGestureListener(onGestureListener);
        return froyoGestureDetector;
    }
}
