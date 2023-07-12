package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXNativeGridLayout extends DXNativeFrameLayout {
    private float[] linePts;
    private boolean needSeparator;
    private Paint paint;

    public DXNativeGridLayout(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needSeparator) {
            canvas.drawLines(this.linePts, this.paint);
        }
    }

    public void setLines(boolean z, @ColorInt int i, int i2, @Size(multiple = 4) float[] fArr) {
        this.needSeparator = z;
        if (z) {
            if (fArr != null && fArr.length != 0 && i2 != 0) {
                if (this.paint == null) {
                    this.paint = new Paint();
                }
                this.paint.setColor(i);
                this.paint.setStrokeWidth(i2);
                this.linePts = fArr;
                return;
            }
            this.needSeparator = false;
        }
    }

    public DXNativeGridLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public DXNativeGridLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }
}
