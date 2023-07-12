package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamic.view.DLinearLayout;
import java.util.ArrayList;
import java.util.Map;
import tb.a90;
import tb.p62;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DLinearLayoutConstructor extends DinamicViewAdvancedConstructor {
    public static final String TAG = "DLinearLayoutConstructor";

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        super.applyDefaultProperty(view, map, v80Var);
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setBaselineAligned(false);
        if (map.containsKey(DAttrConstant.LL_ORIENTATION)) {
            return;
        }
        linearLayout.setOrientation(0);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new DLinearLayout(context);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        DLinearLayout dLinearLayout = (DLinearLayout) view;
        if (arrayList.contains(DAttrConstant.LL_ORIENTATION)) {
            setOrientation(dLinearLayout, (String) map.get(DAttrConstant.LL_ORIENTATION));
        }
        if (arrayList.contains(DAttrConstant.VIEW_CLIP_TOP_LEFT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_TOP_RIGHT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_BOTTOM_LEFT_RADIUS) || arrayList.contains(DAttrConstant.VIEW_CLIP_BOTTOM_RIGHT_RADIUS)) {
            int b = p62.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_TOP_LEFT_RADIUS), 0);
            int b2 = p62.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_TOP_RIGHT_RADIUS), 0);
            int b3 = p62.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_BOTTOM_LEFT_RADIUS), 0);
            float f = b;
            float f2 = b2;
            float b4 = p62.b(view.getContext(), map.get(DAttrConstant.VIEW_CLIP_BOTTOM_RIGHT_RADIUS), 0);
            float f3 = b3;
            view.setTag(a90.LAYOUT_RADII, new float[]{f, f, f2, f2, b4, b4, f3, f3});
        }
    }

    public void setOrientation(LinearLayout linearLayout, String str) {
        if (!TextUtils.isEmpty(str)) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue == 0) {
                linearLayout.setOrientation(1);
                return;
            } else if (intValue != 1) {
                return;
            } else {
                linearLayout.setOrientation(0);
                return;
            }
        }
        linearLayout.setOrientation(0);
    }
}
