package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HorTagView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public HorTagView(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238917262")) {
            ipChange.ipc$dispatch("-1238917262", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int paddingLeft = getPaddingLeft();
        int measuredWidth = (getMeasuredWidth() - paddingLeft) - getPaddingRight();
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = marginLayoutParams.rightMargin + measuredWidth2 + marginLayoutParams.leftMargin;
                if (i6 > measuredWidth) {
                    childAt.layout(paddingLeft, 0, paddingLeft, 0);
                } else {
                    int i7 = marginLayoutParams.topMargin + paddingTop;
                    childAt.layout(paddingLeft, i7, measuredWidth2 + paddingLeft, measuredHeight + i7);
                    paddingLeft += i6;
                    measuredWidth -= i6;
                }
            }
        }
    }

    public HorTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1228984948") ? (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-1228984948", new Object[]{this}) : new FrameLayout.LayoutParams(-2, -2);
    }

    public HorTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
