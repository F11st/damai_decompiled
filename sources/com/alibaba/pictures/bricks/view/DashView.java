package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DashView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int dashGapPx;
    private final int dashHeightPx;
    private final Paint mPaint;
    private final Rect mRect;

    public DashView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039114414")) {
            ipChange.ipc$dispatch("2039114414", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        try {
            int width = getWidth();
            int height = getHeight();
            int i = this.dashHeightPx;
            if (height <= i || i <= 0 || width <= 0) {
                return;
            }
            int i2 = height / i;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.dashHeightPx;
                int i5 = (this.dashGapPx + i4) * i3;
                this.mRect.set(0, i5, width, i4 + i5);
                canvas.drawRect(this.mRect, this.mPaint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DashView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DashView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRect = new Rect();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        s60 s60Var = s60.INSTANCE;
        this.dashGapPx = s60Var.a(context, 1.5f);
        this.dashHeightPx = s60Var.a(context, 2.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
    }
}
