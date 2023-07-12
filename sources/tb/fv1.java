package tb;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import cn.damai.common.util.ACache;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class fv1 extends hq1 implements ValueAnimator.AnimatorUpdateListener, Animatable {
    protected ValueAnimator e;
    protected int b = 0;
    protected int c = 0;
    protected int d = 0;
    protected Path f = new Path();

    public fv1() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, ACache.TIME_HOUR);
        this.e = ofInt;
        ofInt.setDuration(10000L);
        this.e.setInterpolator(null);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        float f = width;
        float max = Math.max(1.0f, f / 22.0f);
        if (this.b != width || this.c != height) {
            this.f.reset();
            float f2 = f - max;
            float f3 = height / 2.0f;
            this.f.addCircle(f2, f3, max, Path.Direction.CW);
            float f4 = f - (5.0f * max);
            this.f.addRect(f4, f3 - max, f2, f3 + max, Path.Direction.CW);
            this.f.addCircle(f4, f3, max, Path.Direction.CW);
            this.b = width;
            this.c = height;
        }
        canvas.save();
        float f5 = f / 2.0f;
        float f6 = height / 2.0f;
        canvas.rotate(this.d, f5, f6);
        for (int i = 0; i < 12; i++) {
            this.a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f5, f6);
            canvas.drawPath(this.f, this.a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.e.isRunning()) {
            return;
        }
        this.e.addUpdateListener(this);
        this.e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.e.isRunning()) {
            this.e.removeAllListeners();
            this.e.removeAllUpdateListeners();
            this.e.cancel();
        }
    }
}
