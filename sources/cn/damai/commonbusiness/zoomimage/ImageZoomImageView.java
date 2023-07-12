package cn.damai.commonbusiness.zoomimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Observable;
import java.util.Observer;
import tb.t23;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ImageZoomImageView extends ImageView implements Observer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAspectQuotient;
    private Bitmap mBitmap;
    private final Paint mPaint;
    private final Rect mRectDst;
    private final Rect mRectSrc;
    private t23 mState;

    public ImageZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint(2);
        this.mRectSrc = new Rect();
        this.mRectDst = new Rect();
    }

    private void calculateAspectQuotient() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930281846")) {
            ipChange.ipc$dispatch("-1930281846", new Object[]{this});
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mAspectQuotient = (bitmap.getWidth() / this.mBitmap.getHeight()) / (getWidth() / getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869304433")) {
            ipChange.ipc$dispatch("869304433", new Object[]{this, canvas});
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1604162374")) {
            ipChange.ipc$dispatch("1604162374", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        calculateAspectQuotient();
    }

    public void setImage(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510394608")) {
            ipChange.ipc$dispatch("-510394608", new Object[]{this, bitmap});
            return;
        }
        this.mBitmap = bitmap;
        calculateAspectQuotient();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154223969")) {
            ipChange.ipc$dispatch("-154223969", new Object[]{this, bitmap});
            return;
        }
        super.setImageBitmap(bitmap);
        setImage(bitmap);
    }

    public void setZoomState(t23 t23Var) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-962986856")) {
            throw null;
        }
        ipChange.ipc$dispatch("-962986856", new Object[]{this, t23Var});
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723178614")) {
            ipChange.ipc$dispatch("723178614", new Object[]{this, observable, obj});
        } else {
            invalidate();
        }
    }
}
