package com.alibaba.security.tools.flexible.component;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.lang.reflect.Field;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GradientDrawableComp implements IFlexibleComp {
    private static final String TAG = "GradientDrawableComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            try {
                Field declaredField = GradientDrawable.class.getDeclaredField("mGradientState");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(background);
                Field declaredField2 = obj.getClass().getDeclaredField("mUseLevel");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 != null) {
                    if (((Boolean) obj2).booleanValue()) {
                        return;
                    }
                    declaredField2.set(obj, Boolean.TRUE);
                    Field declaredField3 = obj.getClass().getDeclaredField("mRadius");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj);
                    if (obj3 != null) {
                        float floatValue = ((Float) obj3).floatValue();
                        if (floatValue > 0.0f) {
                            declaredField3.set(obj, Float.valueOf(FlexibleComponent.INSTANCE.calculate(bigDecimal, floatValue)));
                            return;
                        }
                        Field declaredField4 = obj.getClass().getDeclaredField("mRadiusArray");
                        float[] fArr = (float[]) declaredField4.get(obj);
                        if (fArr == null) {
                            return;
                        }
                        for (int i = 0; i < fArr.length; i++) {
                            float f = fArr[i];
                            if (f > 0.0f) {
                                fArr[i] = FlexibleComponent.INSTANCE.calculate(bigDecimal, f);
                            }
                        }
                        declaredField4.set(obj, fArr);
                        return;
                    }
                    throw new ClassCastException("null cannot be cast to non-null type kotlin.Float");
                }
                throw new ClassCastException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception unused) {
                C3800a.b();
            }
        }
    }
}
