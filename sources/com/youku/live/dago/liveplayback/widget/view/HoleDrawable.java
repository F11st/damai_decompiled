package com.youku.live.dago.liveplayback.widget.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HoleDrawable extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Drawable mInnerDrawable;
    private Paint mSrcPaint;
    private Path mSrcPath = new Path();

    public HoleDrawable(Drawable drawable) {
        this.mInnerDrawable = drawable;
        Paint paint = new Paint(1);
        this.mSrcPaint = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327514626")) {
            ipChange.ipc$dispatch("327514626", new Object[]{this, canvas});
            return;
        }
        this.mInnerDrawable.setBounds(getBounds());
        Path path = this.mSrcPath;
        if (path != null && !path.isEmpty()) {
            Rect bounds = getBounds();
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds), this.mSrcPaint, 31);
            this.mInnerDrawable.draw(canvas);
            this.mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(this.mSrcPath, this.mSrcPaint);
            this.mSrcPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
            return;
        }
        this.mInnerDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "303767301") ? ((Integer) ipChange.ipc$dispatch("303767301", new Object[]{this})).intValue() : this.mInnerDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225102968")) {
            ipChange.ipc$dispatch("225102968", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mInnerDrawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354206650")) {
            ipChange.ipc$dispatch("-1354206650", new Object[]{this, colorFilter});
        } else {
            this.mInnerDrawable.setColorFilter(colorFilter);
        }
    }

    public void setPath(Path path) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694747932")) {
            ipChange.ipc$dispatch("1694747932", new Object[]{this, path});
        } else {
            this.mSrcPath = path;
        }
    }
}
