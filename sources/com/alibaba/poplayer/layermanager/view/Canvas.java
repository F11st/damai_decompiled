package com.alibaba.poplayer.layermanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.poplayer.R$id;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Canvas extends FrameLayout {
    public Canvas(@NonNull Context context) {
        super(context);
    }

    public void addViewByLevel(View view, int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            int i3 = R$id.layermanager_canvas_innerview_id;
            int intValue = ((Integer) childAt.getTag(i3)).intValue();
            if (intValue == i) {
                return;
            }
            if (intValue > i) {
                view.setTag(i3, Integer.valueOf(i));
                addView(view, i2);
                return;
            }
        }
        view.setTag(R$id.layermanager_canvas_innerview_id, Integer.valueOf(i));
        addView(view, getChildCount());
    }

    public ArrayList<View> all() {
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            arrayList.add(getChildAt(i));
        }
        return arrayList;
    }

    public boolean contains(View view) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    public View findViewByLevel(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (((Integer) getChildAt(i2).getTag(R$id.layermanager_canvas_innerview_id)).intValue() == i) {
                return getChildAt(i2);
            }
        }
        return null;
    }

    public Canvas(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Canvas(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
