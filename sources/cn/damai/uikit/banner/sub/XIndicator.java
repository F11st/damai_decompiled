package cn.damai.uikit.banner.sub;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.banner.sub.XBanner;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class XIndicator extends View implements XBanner.OnBannerPageChangedListener {
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

    public XIndicator(Context context) {
        this(context, null);
    }

    @Override // cn.damai.uikit.banner.sub.XBanner.OnBannerPageChangedListener
    public void onChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719152991")) {
            ipChange.ipc$dispatch("719152991", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1740654894")) {
            ipChange.ipc$dispatch("-1740654894", new Object[]{this, canvas});
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

    public XIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.XIndicator);
        this.normalColor = obtainStyledAttributes.getColor(R$styleable.XIndicator_normal_color, Color.parseColor("#19000000"));
        this.selectColor = obtainStyledAttributes.getColor(R$styleable.XIndicator_select_color, Color.parseColor("#FF2869"));
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.radius = l62.a(context, 3.0f);
        this.offset = l62.a(context, 12.0f);
    }
}
