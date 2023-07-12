package cn.damai.user.star.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CircleView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int RADIUS_DP = 3;
    private Paint mPaint;
    private int mRadius;

    public CircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159385576")) {
            ipChange.ipc$dispatch("159385576", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        canvas.drawCircle(width / 2.0f, height / 2.0f, this.mRadius, this.mPaint);
    }

    public CircleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-16777216);
        this.mRadius = ScreenUtil.dip2px(context, 3.0f);
    }
}
