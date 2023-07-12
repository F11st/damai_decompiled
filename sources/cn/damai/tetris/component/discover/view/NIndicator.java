package cn.damai.tetris.component.discover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class NIndicator extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int mBgEColor;
    private final Paint mBgPaint;
    private final RectF mBgRect;
    private final int mBgSColor;
    LinearGradient mGradient;
    private final int mIndicatorEColor;
    private final int mIndicatorSColor;
    private final Paint mPaint;
    private Float mRadius;
    private final RectF mRect;
    private final Matrix matrix;
    private float progress;
    private float ratio;
    private int viewWidth;

    public NIndicator(Context context) {
        super(context);
        this.mBgPaint = new Paint(1);
        this.mBgRect = new RectF();
        this.mRadius = Float.valueOf(0.0f);
        this.mPaint = new Paint(1);
        this.mRect = new RectF();
        this.viewWidth = 0;
        this.mBgSColor = Color.parseColor("#EFEFEF");
        this.mBgEColor = Color.parseColor("#EBEAFB");
        this.mIndicatorEColor = Color.parseColor("#FFBEED");
        this.mIndicatorSColor = Color.parseColor("#FF70B8");
        this.ratio = 0.5f;
        this.progress = 0.0f;
        this.matrix = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1070781588")) {
            ipChange.ipc$dispatch("-1070781588", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.progress = f;
        invalidate();
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-346634511")) {
            ipChange.ipc$dispatch("-346634511", new Object[]{this, recyclerView});
        } else {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.component.discover.view.NIndicator.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView2, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1651238510")) {
                        ipChange2.ipc$dispatch("1651238510", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    super.onScrolled(recyclerView2, i, i2);
                    NIndicator.this.setProgress((recyclerView2.computeHorizontalScrollOffset() * 1.0f) / (recyclerView2.computeHorizontalScrollRange() - recyclerView2.computeHorizontalScrollExtent()));
                }
            });
        }
    }

    public void bindViewPager(final ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2147174315")) {
            ipChange.ipc$dispatch("-2147174315", new Object[]{this, viewPager});
        } else {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.tetris.component.discover.view.NIndicator.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1136824396")) {
                        ipChange2.ipc$dispatch("1136824396", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1413753067")) {
                        ipChange2.ipc$dispatch("1413753067", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    } else {
                        NIndicator.this.setProgress((i + f) / viewPager.getChildCount());
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1925177705")) {
                        ipChange2.ipc$dispatch("-1925177705", new Object[]{this, Integer.valueOf(i)});
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10386497")) {
            ipChange.ipc$dispatch("10386497", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawRoundRect(this.mBgRect, this.mRadius.floatValue(), this.mRadius.floatValue(), this.mBgPaint);
        }
        int i = this.viewWidth;
        float f = this.ratio;
        float f2 = i * (1.0f - f) * this.progress;
        RectF rectF = this.mBgRect;
        float f3 = rectF.left + f2;
        this.mRect.set(f3, rectF.top, (i * f) + f3, rectF.bottom);
        this.matrix.setTranslate(f3, 0.0f);
        this.mGradient.setLocalMatrix(this.matrix);
        if (canvas != null) {
            canvas.drawRoundRect(this.mRect, this.mRadius.floatValue(), this.mRadius.floatValue(), this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945686769")) {
            ipChange.ipc$dispatch("-945686769", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        float f = i;
        float f2 = i2;
        this.mBgRect.set(0.0f, 0.0f, f * 1.0f, 1.0f * f2);
        this.mRadius = Float.valueOf(f2 / 2.0f);
        this.mGradient = new LinearGradient(this.mRadius.floatValue(), 0.0f, f / 2.0f, this.mRadius.floatValue(), this.mIndicatorSColor, this.mIndicatorEColor, Shader.TileMode.MIRROR);
        this.mBgPaint.setShader(new LinearGradient(this.mRadius.floatValue(), 0.0f, f, this.mRadius.floatValue(), this.mBgSColor, this.mBgEColor, Shader.TileMode.CLAMP));
        this.mPaint.setShader(this.mGradient);
    }

    public void setRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067331294")) {
            ipChange.ipc$dispatch("-1067331294", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.ratio = f;
        invalidate();
    }

    public NIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBgPaint = new Paint(1);
        this.mBgRect = new RectF();
        this.mRadius = Float.valueOf(0.0f);
        this.mPaint = new Paint(1);
        this.mRect = new RectF();
        this.viewWidth = 0;
        this.mBgSColor = Color.parseColor("#EFEFEF");
        this.mBgEColor = Color.parseColor("#EBEAFB");
        this.mIndicatorEColor = Color.parseColor("#FFBEED");
        this.mIndicatorSColor = Color.parseColor("#FF70B8");
        this.ratio = 0.5f;
        this.progress = 0.0f;
        this.matrix = new Matrix();
    }

    public NIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBgPaint = new Paint(1);
        this.mBgRect = new RectF();
        this.mRadius = Float.valueOf(0.0f);
        this.mPaint = new Paint(1);
        this.mRect = new RectF();
        this.viewWidth = 0;
        this.mBgSColor = Color.parseColor("#EFEFEF");
        this.mBgEColor = Color.parseColor("#EBEAFB");
        this.mIndicatorEColor = Color.parseColor("#FFBEED");
        this.mIndicatorSColor = Color.parseColor("#FF70B8");
        this.ratio = 0.5f;
        this.progress = 0.0f;
        this.matrix = new Matrix();
    }
}
