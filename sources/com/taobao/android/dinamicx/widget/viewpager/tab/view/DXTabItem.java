package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXTabItem extends FrameLayout {
    private View selectView;
    private boolean selected;
    private View tabView;
    private View unSelectView;

    public DXTabItem(@NonNull Context context) {
        this(context, null);
    }

    public View getSelectView() {
        return this.selectView;
    }

    public View getUnSelectView() {
        return this.unSelectView;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.selected;
    }

    public void setSelectView(View view) {
        if (this.selectView == view) {
            return;
        }
        this.selectView = view;
        addView(view);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.selected = z;
        if (z) {
            View view = this.selectView;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.unSelectView;
            if (view2 != null) {
                view2.setAlpha(0.0f);
                return;
            }
            return;
        }
        View view3 = this.selectView;
        if (view3 != null) {
            view3.setAlpha(0.0f);
        }
        View view4 = this.unSelectView;
        if (view4 != null) {
            view4.setAlpha(1.0f);
        }
    }

    public void setUnSelectView(View view) {
        if (this.unSelectView == view) {
            return;
        }
        this.unSelectView = view;
        addView(view);
    }

    public DXTabItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DXTabItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }
}
