package cn.damai.seat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BgFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int RADIUS = 12;
    private Path bgPath;
    private Paint mBgPaint;
    private Paint mRadiusPaint;
    private int topRadius;
    private Path topRadiusPath;

    public BgFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721135908")) {
            ipChange.ipc$dispatch("-721135908", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Path path = this.bgPath;
        if (path == null || this.topRadiusPath == null) {
            return;
        }
        canvas.drawPath(path, this.mBgPaint);
        canvas.drawPath(this.topRadiusPath, this.mRadiusPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656007914")) {
            ipChange.ipc$dispatch("1656007914", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.bgPath = null;
        this.topRadiusPath = null;
        int i5 = this.topRadius;
        if (i <= i5 * 2 || i2 <= i5) {
            return;
        }
        Path path = new Path();
        this.bgPath = path;
        path.moveTo(0.0f, this.topRadius);
        this.bgPath.quadTo(0.0f, 0.0f, this.topRadius, 0.0f);
        this.bgPath.lineTo(i - this.topRadius, 0.0f);
        float f = i;
        this.bgPath.quadTo(f, 0.0f, f, this.topRadius);
        float f2 = i2;
        this.bgPath.lineTo(f, f2);
        this.bgPath.lineTo(0.0f, f2);
        this.bgPath.close();
        Path path2 = new Path();
        this.topRadiusPath = path2;
        path2.moveTo(0.0f, this.topRadius);
        this.topRadiusPath.quadTo(0.0f, 0.0f, this.topRadius, 0.0f);
        this.topRadiusPath.lineTo(i - this.topRadius, 0.0f);
        this.topRadiusPath.quadTo(f, 0.0f, f, this.topRadius);
    }

    public BgFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BgFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgPaint = new Paint(1);
        this.mRadiusPaint = new Paint(1);
        setWillNotDraw(false);
        this.topRadius = m62.a(context, 12.0f);
        this.mBgPaint.setColor(-1);
        this.mBgPaint.setStyle(Paint.Style.FILL);
        this.mRadiusPaint.setColor(Color.parseColor("#0D000000"));
        this.mRadiusPaint.setStyle(Paint.Style.STROKE);
        this.mRadiusPaint.setStrokeWidth(3.0f);
    }
}
