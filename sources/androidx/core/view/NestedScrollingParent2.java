package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr, int i3);

    void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i2);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i2);

    void onStopNestedScroll(@NonNull View view, int i);
}
