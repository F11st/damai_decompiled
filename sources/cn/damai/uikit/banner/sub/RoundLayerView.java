package cn.damai.uikit.banner.sub;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RoundLayerView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mPath;
    private Paint paint;
    private int radius;

    public RoundLayerView(Context context) {
        this(context, null);
    }

    private void drawCorner(Canvas canvas, Path path, float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182714497")) {
            ipChange.ipc$dispatch("-1182714497", new Object[]{this, canvas, path, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
            return;
        }
        canvas.save();
        canvas.translate(f, f2);
        canvas.rotate(f3);
        canvas.drawPath(path, this.paint);
        canvas.restore();
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647087229")) {
            ipChange.ipc$dispatch("647087229", new Object[]{this, context, attributeSet});
            return;
        }
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(-1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundLayerView);
        this.radius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundLayerView_x_round_radius, 0);
        obtainStyledAttributes.recycle();
        Path path = new Path();
        this.mPath = path;
        path.moveTo(0.0f, 0.0f);
        this.mPath.lineTo(this.radius, 0.0f);
        this.mPath.quadTo(0.0f, 0.0f, 0.0f, this.radius);
        this.mPath.close();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517949119")) {
            ipChange.ipc$dispatch("-1517949119", new Object[]{this, canvas});
            return;
        }
        try {
            drawCorner(canvas, this.mPath, 0.0f, 0.0f, 0.0f);
            drawCorner(canvas, this.mPath, getWidth(), 0.0f, 90.0f);
            drawCorner(canvas, this.mPath, getWidth(), getHeight(), 180.0f);
            drawCorner(canvas, this.mPath, 0.0f, getHeight(), 270.0f);
        } catch (Exception unused) {
        }
    }

    public RoundLayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint(1);
        init(context, attributeSet);
    }
}
