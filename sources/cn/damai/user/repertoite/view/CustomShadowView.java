package cn.damai.user.repertoite.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CustomShadowView extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    Context mContext;
    private Paint mPaint;

    public CustomShadowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-16777216);
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1787768612")) {
            ipChange.ipc$dispatch("1787768612", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        this.mPaint.setShadowLayer(10.0f, 15.0f, 15.0f, -7829368);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, t60.a(this.mContext, 130.0f), t60.a(this.mContext, 170.0f)), 75.0f, 75.0f, this.mPaint);
    }
}
