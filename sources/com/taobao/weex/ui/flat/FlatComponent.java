package com.taobao.weex.ui.flat;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.flat.widget.Widget;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public interface FlatComponent<T extends Widget> {
    @NonNull
    T getOrCreateFlatWidget();

    boolean promoteToView(boolean z);
}
