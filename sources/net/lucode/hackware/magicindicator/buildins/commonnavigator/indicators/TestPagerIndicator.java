package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.jp0;
import tb.st1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TestPagerIndicator extends View implements IPagerIndicator {
    private RectF mInnerRect;
    private int mInnerRectColor;
    private RectF mOutRect;
    private int mOutRectColor;
    private Paint mPaint;
    private List<st1> mPositionDataList;

    public TestPagerIndicator(Context context) {
        super(context);
        this.mOutRect = new RectF();
        this.mInnerRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mOutRectColor = SupportMenu.CATEGORY_MASK;
        this.mInnerRectColor = -16711936;
    }

    public int getInnerRectColor() {
        return this.mInnerRectColor;
    }

    public int getOutRectColor() {
        return this.mOutRectColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mOutRectColor);
        canvas.drawRect(this.mOutRect, this.mPaint);
        this.mPaint.setColor(this.mInnerRectColor);
        canvas.drawRect(this.mInnerRect, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<st1> list = this.mPositionDataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        st1 a = jp0.a(this.mPositionDataList, i);
        st1 a2 = jp0.a(this.mPositionDataList, i + 1);
        RectF rectF = this.mOutRect;
        int i3 = a.a;
        rectF.left = i3 + ((a2.a - i3) * f);
        int i4 = a.b;
        rectF.top = i4 + ((a2.b - i4) * f);
        int i5 = a.c;
        rectF.right = i5 + ((a2.c - i5) * f);
        int i6 = a.d;
        rectF.bottom = i6 + ((a2.d - i6) * f);
        RectF rectF2 = this.mInnerRect;
        int i7 = a.e;
        rectF2.left = i7 + ((a2.e - i7) * f);
        int i8 = a.f;
        rectF2.top = i8 + ((a2.f - i8) * f);
        int i9 = a.g;
        rectF2.right = i9 + ((a2.g - i9) * f);
        int i10 = a.h;
        rectF2.bottom = i10 + ((a2.h - i10) * f);
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<st1> list) {
        this.mPositionDataList = list;
    }

    public void setInnerRectColor(int i) {
        this.mInnerRectColor = i;
    }

    public void setOutRectColor(int i) {
        this.mOutRectColor = i;
    }
}
