package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TopRoundLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int lastH;
    private int lastW;
    private Path mPath;
    private int topRadius;

    public TopRoundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582015902")) {
            ipChange.ipc$dispatch("582015902", new Object[]{this, canvas});
            return;
        }
        try {
            if (this.topRadius > 0) {
                int width = getWidth();
                int height = getHeight();
                if (this.lastH != height || this.lastW != width) {
                    this.mPath = null;
                }
                this.lastH = height;
                this.lastW = width;
                if (this.mPath == null) {
                    this.mPath = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    int i = this.topRadius;
                    this.mPath.addRoundRect(rectF, new float[]{i, i, i, i, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                }
            } else {
                this.mPath = null;
            }
            if (this.mPath != null) {
                canvas.save();
                canvas.clipPath(this.mPath);
            }
            super.draw(canvas);
            if (this.mPath != null) {
                canvas.restore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTopRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411565693")) {
            ipChange.ipc$dispatch("1411565693", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.topRadius = i;
        this.mPath = null;
        invalidate();
    }

    public TopRoundLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopRoundLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.topRadius = 0;
        this.lastW = -1;
        this.lastH = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TopRoundLinearLayout);
        this.topRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TopRoundLinearLayout_trl_top_radius, 0);
        obtainStyledAttributes.recycle();
    }
}
