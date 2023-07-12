package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.a90;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DLoopLinearLayoutConstructor extends DinamicViewAdvancedConstructor {
    public static final String TAG = "DLoopLinearLayoutConstructor";

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void applyDefaultProperty(View view, Map<String, Object> map, v80 v80Var) {
        super.applyDefaultProperty(view, map, v80Var);
        DLoopLinearLayout dLoopLinearLayout = (DLoopLinearLayout) view;
        dLoopLinearLayout.setBaselineAligned(false);
        if (!map.containsKey(DAttrConstant.LL_ORIENTATION)) {
            dLoopLinearLayout.setOrientation(1);
        }
        dLoopLinearLayout.setTag(a90.TAG_DINAMIC_BIND_DATA_LIST, v80Var.e().a());
    }

    public void bindListData(DLoopLinearLayout dLoopLinearLayout, v80 v80Var, List list) {
        dLoopLinearLayout.bindListData(v80Var, list);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeView(String str, Context context, AttributeSet attributeSet) {
        return new DLoopLinearLayout(context, attributeSet);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
        DLoopLinearLayout dLoopLinearLayout = (DLoopLinearLayout) view;
        if (arrayList.contains(DAttrConstant.LL_ORIENTATION)) {
            setOrientation(dLoopLinearLayout, (String) map.get(DAttrConstant.LL_ORIENTATION));
        }
        if (arrayList.contains(DAttrConstant.VIEW_LIST_DATA)) {
            bindListData(dLoopLinearLayout, v80Var, (List) map.get(DAttrConstant.VIEW_LIST_DATA));
        }
    }

    public void setOrientation(DLoopLinearLayout dLoopLinearLayout, String str) {
        if (!TextUtils.isEmpty(str)) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue == 0) {
                dLoopLinearLayout.setOrientation(1);
                return;
            } else if (intValue != 1) {
                return;
            } else {
                dLoopLinearLayout.setOrientation(0);
                return;
            }
        }
        dLoopLinearLayout.setOrientation(0);
    }
}
