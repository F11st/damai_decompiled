package com.youku.resource.widget.tips;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTipBgDrawable extends Drawable {
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ARROW_DOWN = 1;
    public static final int ARROW_UP = 0;
    public static final int GRADIENT_LEFT_RIGHT = 1;
    public static final int GRADIENT_TOPLEFT_BOTTOMRIGHT = 2;
    public static final int GRADIENT_TOP_BOTTOM = 0;
    private final int mAlign;
    private final int mArrowHeight;
    private final int mEndColor;
    private final int mGradient;
    private final int mOffset;
    private final int mPositon;
    private final int mStartColor;

    public YKTipBgDrawable(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mPositon = i;
        this.mAlign = i2;
        this.mStartColor = i6;
        this.mEndColor = i7;
        this.mGradient = i5;
        this.mOffset = i3;
        this.mArrowHeight = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        LinearGradient linearGradient;
        Path path = new Path();
        Paint paint = new Paint();
        int i = this.mGradient;
        if (i == 0) {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, Rect.height(getBounds()), this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        } else if (i == 1) {
            linearGradient = new LinearGradient(0.0f, 0.0f, Rect.width(getBounds()), 0.0f, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, Rect.width(getBounds()), Rect.height(getBounds()), this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
        int i2 = this.mPositon;
        if (i2 == 0) {
            path.moveTo(this.mArrowHeight / 2, 0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                path.addRoundRect(getBounds().left, 0.0f, getBounds().right, getBounds().bottom - (this.mArrowHeight / 2), 9999.0f, 9999.0f, Path.Direction.CW);
            } else {
                path.addRect(getBounds().left, 0.0f, getBounds().right, getBounds().bottom - (this.mArrowHeight / 2), Path.Direction.CW);
            }
            int i3 = this.mAlign;
            if (i3 == 1) {
                path.moveTo(this.mOffset - (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo(this.mOffset + (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo(this.mOffset, getBounds().bottom);
            } else if (i3 == 2) {
                path.moveTo((Rect.width(getBounds()) - this.mOffset) - (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo((Rect.width(getBounds()) - this.mOffset) + (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo(Rect.width(getBounds()) - this.mOffset, getBounds().bottom);
            } else {
                path.moveTo((Rect.width(getBounds()) / 2) - (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo((Rect.width(getBounds()) / 2) + (this.mArrowHeight / 2), getBounds().bottom - (this.mArrowHeight / 2));
                path.lineTo(Rect.width(getBounds()) / 2, getBounds().bottom);
            }
        } else if (i2 == 1) {
            int i4 = this.mAlign;
            if (i4 == 1) {
                path.moveTo(this.mOffset, 0.0f);
                int i5 = this.mOffset;
                int i6 = this.mArrowHeight;
                path.lineTo(i5 - (i6 / 2), i6 / 2);
                int i7 = this.mOffset;
                int i8 = this.mArrowHeight;
                path.lineTo(i7 + (i8 / 2), i8 / 2);
            } else if (i4 == 2) {
                path.moveTo(Rect.width(getBounds()) - this.mOffset, 0.0f);
                int width = Rect.width(getBounds()) - this.mOffset;
                int i9 = this.mArrowHeight;
                path.lineTo(width - (i9 / 2), i9 / 2);
                int width2 = Rect.width(getBounds()) - this.mOffset;
                int i10 = this.mArrowHeight;
                path.lineTo(width2 + (i10 / 2), i10 / 2);
            } else {
                path.moveTo(Rect.width(getBounds()) / 2, 0.0f);
                int i11 = this.mArrowHeight;
                path.lineTo((Rect.width(getBounds()) / 2) - (i11 / 2), i11 / 2);
                int i12 = this.mArrowHeight;
                path.lineTo((Rect.width(getBounds()) / 2) + (i12 / 2), i12 / 2);
            }
            path.moveTo(this.mArrowHeight / 2, 0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                path.addRoundRect(getBounds().left, this.mArrowHeight / 2, getBounds().right, getBounds().bottom, 9999.0f, 9999.0f, Path.Direction.CW);
            } else {
                path.addRect(getBounds().left, this.mArrowHeight / 2, getBounds().right, getBounds().bottom, Path.Direction.CW);
            }
        }
        canvas.drawPath(path, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
