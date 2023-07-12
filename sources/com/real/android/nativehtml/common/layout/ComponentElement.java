package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.layout.Layout;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface ComponentElement extends Element {
    float getIntrinsicContentBoxHeightForWidth(float f, float f2);

    float getIntrinsicContentBoxWidth(Layout.Directive directive, float f);

    void moveRelative(float f, float f2);

    void setBorderBoxBounds(float f, float f2, float f3, float f4, float f5);
}
