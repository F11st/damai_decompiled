package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FroyoGestureDetector extends EclairGestureDetector {
    private static transient /* synthetic */ IpChange $ipChange;
    final ScaleGestureDetector mDetector;

    public FroyoGestureDetector(Context context) {
        super(context);
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.FroyoGestureDetector.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1468157980")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1468157980", new Object[]{this, scaleGestureDetector})).booleanValue();
                }
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                FroyoGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1466279047")) {
                    return ((Boolean) ipChange.ipc$dispatch("1466279047", new Object[]{this, scaleGestureDetector})).booleanValue();
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1949330037")) {
                    ipChange.ipc$dispatch("1949330037", new Object[]{this, scaleGestureDetector});
                }
            }
        });
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean isScaling() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-961960527") ? ((Boolean) ipChange.ipc$dispatch("-961960527", new Object[]{this})).booleanValue() : this.mDetector.isInProgress();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.EclairGestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375309183")) {
            return ((Boolean) ipChange.ipc$dispatch("375309183", new Object[]{this, motionEvent})).booleanValue();
        }
        this.mDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
