package cn.damai.category.discountticket.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HWRatioImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mHwRatio;

    public HWRatioImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129088429")) {
            ipChange.ipc$dispatch("-129088429", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (size * this.mHwRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public HWRatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HWRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.HWRatioImageView);
        this.mHwRatio = obtainStyledAttributes.getFloat(R$styleable.HWRatioImageView_h_w_ratio, 1.0f);
        obtainStyledAttributes.recycle();
    }
}
