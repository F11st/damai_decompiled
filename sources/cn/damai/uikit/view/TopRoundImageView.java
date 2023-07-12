package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TopRoundImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mPath;
    private int mTopRoundRadius;

    public TopRoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1759820538")) {
            ipChange.ipc$dispatch("-1759820538", new Object[]{this, canvas});
            return;
        }
        try {
            if (this.mTopRoundRadius <= 0 || this.mPath == null) {
                z = false;
            }
            if (z) {
                canvas.save();
                canvas.clipPath(this.mPath);
            }
            super.onDraw(canvas);
            if (z) {
                canvas.restore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "823741588")) {
            ipChange.ipc$dispatch("823741588", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        Path path = new Path();
        this.mPath = path;
        int i5 = this.mTopRoundRadius;
        path.addRoundRect(rectF, new float[]{i5, i5, i5, i5, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
    }

    public TopRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TopRoundImageView);
        this.mTopRoundRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.TopRoundImageView_top_round_radius, 0);
        obtainStyledAttributes.recycle();
    }
}
