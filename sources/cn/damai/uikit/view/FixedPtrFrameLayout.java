package cn.damai.uikit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FixedPtrFrameLayout extends PtrFrameLayout {
    public FixedPtrFrameLayout(Context context) {
        this(context, null);
    }

    public FixedPtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedPtrFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            Field declaredField = PtrFrameLayout.class.getDeclaredField("mPagingTouchSlop");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(scaledTouchSlop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
