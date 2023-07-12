package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RatioFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public RatioFrameLayout(@NonNull Context context) {
        super(context);
    }

    private int getChildHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "171604713")) {
            return ((Integer) ipChange.ipc$dispatch("171604713", new Object[]{this})).intValue();
        }
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        if (childAt instanceof ImageView) {
            return ((ImageView) childAt).getDrawable().getIntrinsicHeight();
        }
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067773592")) {
            ipChange.ipc$dispatch("-2067773592", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size2 > (i5 = (size / 16) * 9)) {
            size2 = i5;
        }
        if (mode == 0 && size2 > (i4 = (size / 16) * 9)) {
            size2 = i4;
        }
        if (mode == Integer.MIN_VALUE && size2 > (i3 = (size / 16) * 9)) {
            size2 = i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size2, mode));
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
