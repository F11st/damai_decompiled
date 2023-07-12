package cn.damai.tetris.component.home.widget.banner.sub;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RoundRadiusImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mClipPath;
    private Paint mPaint;
    private int mRoundRadius;
    private int mStrokeColor;
    private int mStrokeWidth;

    public RoundRadiusImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282922815")) {
            ipChange.ipc$dispatch("-1282922815", new Object[]{this, canvas});
            return;
        }
        boolean z = this.mClipPath != null;
        if (z) {
            canvas.save();
            canvas.clipPath(this.mClipPath);
        }
        super.onDraw(canvas);
        if (z) {
            canvas.restore();
        }
        if (this.mClipPath == null || (i = this.mStrokeWidth) <= 0) {
            return;
        }
        this.mPaint.setStrokeWidth(i);
        this.mPaint.setColor(this.mStrokeColor);
        canvas.drawPath(this.mClipPath, this.mPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261437327")) {
            ipChange.ipc$dispatch("1261437327", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRoundRadius > 0) {
            Path path = new Path();
            this.mClipPath = path;
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            int i5 = this.mRoundRadius;
            path.addRoundRect(rectF, i5, i5, Path.Direction.CW);
            return;
        }
        this.mClipPath = null;
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundRadiusImageView);
        this.mRoundRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundRadiusImageView_r_round_radius, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundRadiusImageView_r_stroke_width, 0);
        this.mStrokeColor = obtainStyledAttributes.getColor(R$styleable.RoundRadiusImageView_r_stroke_color, 0);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
    }
}
