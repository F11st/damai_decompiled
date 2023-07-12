package cn.damai.user.star.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.user.star.view.XunYanBanner;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class XunYanIndicator extends View implements XunYanBanner.OnBannerPageChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CIRCLE_OFFSET = 12;
    private static final int CIRCLE_RADIUS_DP = 3;
    private Paint mPaint;
    private int normalColor;
    private int offset;
    private int radius;
    private int selectColor;
    private int selectPos;
    private int total;

    public XunYanIndicator(Context context) {
        this(context, null);
    }

    @Override // cn.damai.user.star.view.XunYanBanner.OnBannerPageChangedListener
    public void onChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178760780")) {
            ipChange.ipc$dispatch("-1178760780", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.total = i;
        this.selectPos = i2;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988385959")) {
            ipChange.ipc$dispatch("1988385959", new Object[]{this, canvas});
            return;
        }
        int width = getWidth();
        if (width > 0 && (i = this.total) > 0 && (i2 = this.selectPos) >= 0 && i2 <= i - 1) {
            float height = getHeight() / 2.0f;
            float f = (width - ((this.total - 1) * this.offset)) / 2.0f;
            for (int i3 = 0; i3 < this.total; i3++) {
                if (i3 == this.selectPos) {
                    this.mPaint.setColor(this.selectColor);
                } else {
                    this.mPaint.setColor(this.normalColor);
                }
                canvas.drawCircle(f, height, this.radius, this.mPaint);
                f += this.offset;
            }
        }
    }

    public XunYanIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XunYanIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.radius = ScreenUtil.dip2px(context, 3.0f);
        this.offset = ScreenUtil.dip2px(context, 12.0f);
        this.selectColor = Color.parseColor("#000000");
        this.normalColor = Color.parseColor("#19000000");
    }
}
