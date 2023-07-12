package com.taobao.weex.ui.view.border;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.dom.CSSShorthand;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BorderUtil {
    BorderUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int fetchFromSparseArray(@Nullable SparseIntArray sparseIntArray, int i, int i2) {
        return sparseIntArray == null ? i2 : sparseIntArray.get(i, sparseIntArray.get(CSSShorthand.EDGE.ALL.ordinal()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateSparseArray(@NonNull SparseIntArray sparseIntArray, int i, int i2) {
        CSSShorthand.EDGE edge = CSSShorthand.EDGE.ALL;
        if (i == edge.ordinal()) {
            sparseIntArray.put(edge.ordinal(), i2);
            sparseIntArray.put(CSSShorthand.EDGE.TOP.ordinal(), i2);
            sparseIntArray.put(CSSShorthand.EDGE.LEFT.ordinal(), i2);
            sparseIntArray.put(CSSShorthand.EDGE.RIGHT.ordinal(), i2);
            sparseIntArray.put(CSSShorthand.EDGE.BOTTOM.ordinal(), i2);
            return;
        }
        sparseIntArray.put(i, i2);
    }
}
