package com.taomai.android.h5container.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TitleLinearLayout extends LinearLayout {
    public TitleLinearLayout(Context context) {
        super(context);
    }

    private int getLength(View view, int i, int i2, int i3, int i4) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        super.measureChildWithMargins(view, i, i2, i3, i4);
        return layoutParams.leftMargin + layoutParams.rightMargin + view.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (getChildCount() < 3) {
            super.measureChildWithMargins(view, i, i2, i3, i4);
        } else if (indexOfChild(view) == 1) {
            int length = getLength(getChildAt(0), i, i2, i3, i4);
            int length2 = getLength(getChildAt(2), i, i2, i3, i4);
            if (length > length2) {
                view.setPadding(0, 0, length - length2, 0);
            } else if (length < length2) {
                view.setPadding(length2 - length, 0, 0, 0);
            } else {
                view.setPadding(0, 0, 0, 0);
            }
            super.measureChildWithMargins(view, (i - length) - length2, i2, i3, i4);
        } else {
            super.measureChildWithMargins(view, i, i2, i3, i4);
        }
    }

    public TitleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public TitleLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
