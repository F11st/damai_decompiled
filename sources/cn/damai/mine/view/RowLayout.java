package cn.damai.mine.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RowLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<View> childShowing;

    public RowLayout(Context context) {
        super(context);
        this.childShowing = new ArrayList();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        int i5 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1652882253")) {
            ipChange.ipc$dispatch("1652882253", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (this.childShowing.size() <= 1) {
            super.onLayout(z, i, i2, i3, i4);
        } else {
            int paddingLeft = getPaddingLeft();
            while (i5 < this.childShowing.size()) {
                View view = this.childShowing.get(i5);
                int i6 = paddingLeft + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int i7 = ((i4 - i2) - measuredHeight) / 2;
                int i8 = measuredWidth + i6;
                view.layout(i6, i7, i8, measuredHeight + i7);
                i5++;
                paddingLeft = i8;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867658789")) {
            ipChange.ipc$dispatch("-867658789", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.childShowing.clear();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    this.childShowing.add(childAt);
                }
            }
        }
        int size = this.childShowing.size();
        if (size <= 1) {
            super.onMeasure(i, i2);
            return;
        }
        int size2 = View.MeasureSpec.getSize(i);
        int paddingLeft = (size2 - getPaddingLeft()) - getPaddingRight();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < size; i6++) {
            View view = this.childShowing.get(i6);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            measureChild(view, i, i2);
            i4 += view.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i5 = Math.max(i5, view.getMeasuredHeight());
        }
        View view2 = this.childShowing.get(0);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        measureChild(view2, View.MeasureSpec.makeMeasureSpec(((paddingLeft - i4) - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin, Integer.MIN_VALUE), i2);
        setMeasuredDimension(size2, Math.max(i5, view2.getMeasuredHeight()) + getPaddingTop() + getPaddingBottom());
    }

    public RowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.childShowing = new ArrayList();
    }

    public RowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.childShowing = new ArrayList();
    }
}
