package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MaxHeightLinearLayout extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mMaxHeight;
    private float mMaxRatio;
    private float mMinHeight;

    public MaxHeightLinearLayout(Context context) {
        super(context);
        this.mMaxRatio = 0.75f;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337277467")) {
            ipChange.ipc$dispatch("-1337277467", new Object[]{this});
            return;
        }
        this.mMaxHeight = this.mMaxRatio * DisplayMetrics.getheightPixels(q60.b(getContext()));
        float a = q60.a(getContext(), 125.0f);
        this.mMinHeight = a;
        float f = this.mMaxHeight;
        if (f >= a) {
            a = f;
        }
        this.mMaxHeight = a;
    }

    private void initAtts(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322420647")) {
            ipChange.ipc$dispatch("-322420647", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.mMaxRatio);
        if (obtainStyledAttributes != null) {
            this.mMaxRatio = obtainStyledAttributes.getFloat(R$styleable.mMaxRatio_linear_max_ratio, 0.75f);
            obtainStyledAttributes.recycle();
        }
    }

    public int getMaxHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-924063277") ? ((Integer) ipChange.ipc$dispatch("-924063277", new Object[]{this})).intValue() : (int) this.mMaxHeight;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046055434")) {
            ipChange.ipc$dispatch("-2046055434", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            float f = this.mMaxHeight;
            if (size > f) {
                size = (int) f;
            }
        }
        if (mode == 0) {
            float f2 = this.mMaxHeight;
            if (size > f2) {
                size = (int) f2;
            }
        }
        if (mode == Integer.MIN_VALUE) {
            float f3 = this.mMaxHeight;
            if (size > f3) {
                size = (int) f3;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public MaxHeightLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRatio = 0.75f;
        initAtts(context, attributeSet);
        init();
    }

    public MaxHeightLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRatio = 0.75f;
        initAtts(context, attributeSet);
        init();
    }
}
