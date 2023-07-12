package com.youku.live.dago.liveplayback.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import com.youku.live.widgets.dom.CSSLayout;
import com.youku.live.widgets.protocol.IDagoTouchDispatchTopLayer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TouchableCSSLayout extends CSSLayout implements IDagoTouchDispatchTopLayer {
    public TouchableCSSLayout(Context context) {
        this(context, null);
    }

    public TouchableCSSLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TouchableCSSLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
