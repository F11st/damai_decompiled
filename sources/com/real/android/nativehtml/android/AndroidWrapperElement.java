package com.real.android.nativehtml.android;

import android.content.Context;
import android.view.View;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.C6149b;
import com.real.android.nativehtml.common.layout.Layout;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class AndroidWrapperElement extends AbstractAndroidComponentElement {
    View child;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidWrapperElement(Context context, qb0 qb0Var, String str, View view) {
        super(context, qb0Var, str);
        if (view != null) {
            addView(view);
            this.child = view;
        }
    }

    public HtmlCollection getChildren() {
        return HtmlCollection.EMPTY;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxHeightForWidth(float f, float f2) {
        if (this.child == null) {
            return 0.0f;
        }
        float a = this.document.h().a();
        this.child.measure(Math.round(f * a) | 1073741824, 0);
        return this.child.getMeasuredHeight() / a;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxWidth(Layout.Directive directive, float f) {
        if (this.child == null) {
            return 0.0f;
        }
        float a = this.document.h().a();
        this.child.measure(C6140a.a(directive) | Math.round(f * a), 0);
        return this.child.getMeasuredWidth() / a;
    }

    public void insertBefore(Element element, Element element2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float a = getOwnerDocument().h().a();
        int round = Math.round((this.computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, this.containingBoxWidth) + this.computedStyle.g(CssProperty.PADDING_LEFT, this.containingBoxWidth)) * a);
        int round2 = Math.round(a * (this.computedStyle.g(CssProperty.BORDER_TOP_WIDTH, this.containingBoxWidth) + this.computedStyle.g(CssProperty.PADDING_TOP, this.containingBoxWidth)));
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.layout(round, round2, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float a = this.document.h().a();
        float[] b = C6149b.b(this, Layout.Directive.FIT_CONTENT, this.containingBoxWidth);
        setMeasuredDimension(Math.round(b[0] * a), Math.round(b[1] * a));
    }
}
