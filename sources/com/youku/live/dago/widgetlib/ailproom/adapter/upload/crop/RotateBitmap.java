package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RotateBitmap {
    private static transient /* synthetic */ IpChange $ipChange;
    private Bitmap bitmap;
    private int rotation;

    public RotateBitmap(Bitmap bitmap, int i) {
        this.bitmap = bitmap;
        this.rotation = i % 360;
    }

    public Bitmap getBitmap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-228589524") ? (Bitmap) ipChange.ipc$dispatch("-228589524", new Object[]{this}) : this.bitmap;
    }

    public int getHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732563383")) {
            return ((Integer) ipChange.ipc$dispatch("-732563383", new Object[]{this})).intValue();
        }
        if (this.bitmap == null) {
            return 0;
        }
        if (isOrientationChanged()) {
            return this.bitmap.getWidth();
        }
        return this.bitmap.getHeight();
    }

    public Matrix getRotateMatrix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939457517")) {
            return (Matrix) ipChange.ipc$dispatch("1939457517", new Object[]{this});
        }
        Matrix matrix = new Matrix();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && this.rotation != 0) {
            matrix.preTranslate(-(bitmap.getWidth() / 2), -(this.bitmap.getHeight() / 2));
            matrix.postRotate(this.rotation);
            matrix.postTranslate(getWidth() / 2, getHeight() / 2);
        }
        return matrix;
    }

    public int getRotation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-834859886") ? ((Integer) ipChange.ipc$dispatch("-834859886", new Object[]{this})).intValue() : this.rotation;
    }

    public int getWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358729350")) {
            return ((Integer) ipChange.ipc$dispatch("-1358729350", new Object[]{this})).intValue();
        }
        if (this.bitmap == null) {
            return 0;
        }
        if (isOrientationChanged()) {
            return this.bitmap.getHeight();
        }
        return this.bitmap.getWidth();
    }

    public boolean isOrientationChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "35871309") ? ((Boolean) ipChange.ipc$dispatch("35871309", new Object[]{this})).booleanValue() : (this.rotation / 90) % 2 != 0;
    }

    public void recycle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407382112")) {
            ipChange.ipc$dispatch("-1407382112", new Object[]{this});
            return;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.bitmap = null;
        }
    }

    public void setBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540179628")) {
            ipChange.ipc$dispatch("540179628", new Object[]{this, bitmap});
        } else {
            this.bitmap = bitmap;
        }
    }

    public void setRotation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799929680")) {
            ipChange.ipc$dispatch("799929680", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.rotation = i;
        }
    }
}
