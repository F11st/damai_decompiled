package com.taobao.android.dinamic.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;
import tb.e90;
import tb.m80;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DHorizontalScrollLayout extends DFrameLayout {
    String SL_LAYOUT_TYPE_FRAME;
    String SL_LAYOUT_TYPE_LINEAR;
    String SL_SCROLLBAR_INVISIBLE;
    String SL_SCROLLBAR_VISIBLE;
    ViewGroup containerView;
    FrameLayout scrollView;

    public DHorizontalScrollLayout(Context context) {
        super(context);
        this.SL_LAYOUT_TYPE_LINEAR = "linear";
        this.SL_LAYOUT_TYPE_FRAME = TypedValues.Attributes.S_FRAME;
        this.SL_SCROLLBAR_INVISIBLE = DAttrConstant.VISIBILITY_INVISIBLE;
        this.SL_SCROLLBAR_VISIBLE = "visible";
    }

    private void generateChildView(AttributeSet attributeSet, v80 v80Var) {
        Map<String, Object> map = C6313b.d(m80.D_HORIZONTAL_SCROLL_LAYOUT).handleAttributeSet(attributeSet).b;
        String str = (String) map.get(DAttrConstant.SL_LAYOUT_TYPE);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        this.scrollView = horizontalScrollView;
        horizontalScrollView.setOverScrollMode(2);
        this.scrollView.setVerticalScrollBarEnabled(false);
        if (!TextUtils.equals((String) map.get(DAttrConstant.SL_SCOLLBAR), this.SL_SCROLLBAR_VISIBLE)) {
            this.scrollView.setHorizontalScrollBarEnabled(false);
        }
        if (TextUtils.equals(str, this.SL_LAYOUT_TYPE_FRAME)) {
            DFrameLayout dFrameLayout = (DFrameLayout) e90.b(m80.D_FRAME_LAYOUT, getContext(), attributeSet, v80Var);
            this.containerView = dFrameLayout;
            this.scrollView.addView(dFrameLayout);
        } else {
            DLinearLayout dLinearLayout = (DLinearLayout) e90.b(m80.D_LINEAR_LAYOUT, getContext(), attributeSet, v80Var);
            this.containerView = dLinearLayout;
            this.scrollView.addView(dLinearLayout);
        }
        super.addView(this.scrollView, -1, generateLayoutParams(attributeSet));
        map.remove(DAttrConstant.SL_LAYOUT_TYPE);
        map.remove(DAttrConstant.SL_SCOLLBAR);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.addView(view, i, layoutParams);
        }
    }

    public DHorizontalScrollLayout(Context context, AttributeSet attributeSet, v80 v80Var) {
        super(context, attributeSet);
        this.SL_LAYOUT_TYPE_LINEAR = "linear";
        this.SL_LAYOUT_TYPE_FRAME = TypedValues.Attributes.S_FRAME;
        this.SL_SCROLLBAR_INVISIBLE = DAttrConstant.VISIBILITY_INVISIBLE;
        this.SL_SCROLLBAR_VISIBLE = "visible";
        generateChildView(attributeSet, v80Var);
    }
}
