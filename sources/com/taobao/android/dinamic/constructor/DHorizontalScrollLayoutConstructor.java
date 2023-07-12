package com.taobao.android.dinamic.constructor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.view.DHorizontalScrollLayout;
import java.util.ArrayList;
import java.util.Map;
import tb.v80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DHorizontalScrollLayoutConstructor extends DinamicViewAdvancedConstructor {
    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public View initializeViewWithModule(String str, Context context, AttributeSet attributeSet, v80 v80Var) {
        return new DHorizontalScrollLayout(context, attributeSet, v80Var);
    }

    @Override // com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor
    public void setAttributes(View view, Map<String, Object> map, ArrayList<String> arrayList, v80 v80Var) {
        super.setAttributes(view, map, arrayList, v80Var);
    }
}
