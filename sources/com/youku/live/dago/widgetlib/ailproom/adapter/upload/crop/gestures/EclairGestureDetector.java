package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures;

import android.content.Context;
import android.view.MotionEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.Compat;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class EclairGestureDetector extends CupcakeGestureDetector {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int INVALID_POINTER_ID = -1;
    int mActivePointerId;
    int mActivePointerIndex;

    public EclairGestureDetector(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mActivePointerIndex = 0;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector
    float getActiveX(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943437540")) {
            return ((Float) ipChange.ipc$dispatch("1943437540", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector
    float getActiveY(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954753667")) {
            return ((Float) ipChange.ipc$dispatch("1954753667", new Object[]{this, motionEvent})).floatValue();
        }
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.CupcakeGestureDetector, com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721179590")) {
            return ((Boolean) ipChange.ipc$dispatch("-721179590", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.mActivePointerId = -1;
        } else if (action == 6) {
            int pointerIndex = Compat.getPointerIndex(motionEvent.getAction());
            if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                int i = pointerIndex != 0 ? 0 : 1;
                this.mActivePointerId = motionEvent.getPointerId(i);
                this.mLastTouchX = motionEvent.getX(i);
                this.mLastTouchY = motionEvent.getY(i);
            }
        }
        int i2 = this.mActivePointerId;
        this.mActivePointerIndex = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return super.onTouchEvent(motionEvent);
    }
}
