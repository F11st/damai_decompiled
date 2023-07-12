package tb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.view.DLoopLinearLayout;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e90 {
    public static View a(Context context, View view, iy2 iy2Var, v80 v80Var) {
        x80 c = f90.c(view);
        DinamicViewAdvancedConstructor d = C6313b.d(c.a);
        if (d == null) {
            v80Var.e().b().a(p80.ERROR_CODE_VIEW_NOT_FOUND, c.a);
            return null;
        }
        View initializeViewWithModule = d.initializeViewWithModule(c.a, context, null, v80Var);
        if (initializeViewWithModule == null) {
            v80Var.e().b().a(p80.ERROR_CODE_VIEW_NOT_FOUND, c.a);
            return null;
        }
        if ((initializeViewWithModule instanceof DLoopLinearLayout) && (view instanceof DLoopLinearLayout)) {
            ((DLoopLinearLayout) initializeViewWithModule).setTemplateViews(((DLoopLinearLayout) view).cloneTemplateViews());
        }
        d.applyDefaultProperty(initializeViewWithModule);
        initializeViewWithModule.setTag(a90.PROPERTY_KEY, c);
        if (!c.c.isEmpty() || !c.d.isEmpty()) {
            iy2Var.a().add(initializeViewWithModule);
        }
        ArrayList<String> arrayList = new ArrayList<>(20);
        arrayList.addAll(c.b.keySet());
        d.bindDataImpl(initializeViewWithModule, c.b, arrayList, v80Var);
        return initializeViewWithModule;
    }

    public static View b(String str, Context context, AttributeSet attributeSet, v80 v80Var) {
        DinamicViewAdvancedConstructor d = C6313b.d(str);
        if (d == null) {
            v80Var.e().b().a(p80.ERROR_CODE_VIEW_NOT_FOUND, str);
            return null;
        }
        View initializeViewWithModule = d.initializeViewWithModule(str, context, attributeSet, v80Var);
        if (initializeViewWithModule == null) {
            v80Var.e().b().a(p80.ERROR_CODE_VIEW_NOT_FOUND, str);
            return null;
        }
        x80 handleAttributeSet = d.handleAttributeSet(attributeSet);
        d.applyDefaultProperty(initializeViewWithModule, handleAttributeSet.b, v80Var);
        if (!handleAttributeSet.c.isEmpty() || !handleAttributeSet.d.isEmpty()) {
            v80Var.e().a().add(initializeViewWithModule);
        }
        handleAttributeSet.a = str;
        initializeViewWithModule.setTag(a90.PROPERTY_KEY, handleAttributeSet);
        ArrayList<String> arrayList = new ArrayList<>(20);
        arrayList.addAll(handleAttributeSet.b.keySet());
        d.bindDataImpl(initializeViewWithModule, handleAttributeSet.b, arrayList, v80Var);
        return initializeViewWithModule;
    }
}
