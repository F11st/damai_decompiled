package com.real.android.nativehtml.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.Layout;
import com.real.android.nativehtml.common.layout.c;
import tb.bi2;
import tb.fq;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AndroidContainerElement extends AbstractAndroidComponentElement implements HtmlCollection {
    Layout layout;

    public AndroidContainerElement(Context context, qb0 qb0Var, String str) {
        super(context, qb0Var, str);
    }

    private Layout getLayout() {
        if (this.layout == null) {
            if (getLocalName().equals("table")) {
                this.layout = new c();
            } else {
                this.layout = new com.real.android.nativehtml.common.layout.a();
            }
        }
        return this.layout;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        return this;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.COMPONENTS;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxHeightForWidth(float f, float f2) {
        return getLayout().layout(this, 0.0f, 0.0f, f, true);
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxWidth(Layout.Directive directive, float f) {
        return getLayout().measureWidth(this, directive, f);
    }

    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public int getLength() {
        return getChildCount();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        if (element2 == null) {
            addView((View) element);
            return;
        }
        addView((View) element, indexOfChild((View) element2));
    }

    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public Element item(int i) {
        return (Element) getChildAt(i);
    }

    @Override // com.real.android.nativehtml.android.AbstractAndroidComponentElement, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CssEnum f = getComputedStyle().f(CssProperty.LIST_STYLE_TYPE);
        float a = getOwnerDocument().h().a();
        int i = 1;
        Paint.FontMetrics fontMetrics = null;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            fq computedStyle = ((Element) childAt).getComputedStyle();
            if (computedStyle.f(CssProperty.DISPLAY) == CssEnum.LIST_ITEM && f != CssEnum.NONE) {
                if (fontMetrics == null) {
                    fontMetrics = new Paint.FontMetrics();
                }
                int i3 = i + 1;
                String a2 = bi2.a(f, i);
                a.f(computedStyle, a, this.paint);
                this.paint.getFontMetrics(fontMetrics);
                float g = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, 0.0f) + computedStyle.g(CssProperty.PADDING_TOP, 0.0f);
                canvas.drawText(a2, (childAt.getX() + ((computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, 0.0f) + computedStyle.g(CssProperty.PADDING_LEFT, 0.0f)) * a)) - this.paint.measureText(a2), (childAt.getY() + (g * a)) - fontMetrics.top, this.paint);
                i = i3;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float a = getOwnerDocument().h().a();
        if (!getLocalName().equals("tr")) {
            fq computedStyle = getComputedStyle();
            float g = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_LEFT, this.containingBoxWidth);
            Layout layout = getLayout();
            layout.layout(this, g, computedStyle.g(CssProperty.BORDER_TOP_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_TOP, this.containingBoxWidth), (((i3 - i) / a) - g) - (computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, this.containingBoxWidth) + computedStyle.g(CssProperty.PADDING_RIGHT, this.containingBoxWidth)), false);
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            float f3 = 0.0f;
            if (childAt instanceof AbstractAndroidComponentElement) {
                AbstractAndroidComponentElement abstractAndroidComponentElement = (AbstractAndroidComponentElement) childAt;
                f3 = abstractAndroidComponentElement.x * a;
                f2 = abstractAndroidComponentElement.y;
            } else if (childAt instanceof AndroidTextComponent) {
                AndroidTextComponent androidTextComponent = (AndroidTextComponent) childAt;
                f3 = androidTextComponent.x * a;
                f2 = androidTextComponent.y;
            } else {
                f = 0.0f;
                childAt.layout(Math.round(f3), Math.round(f), Math.round(f3 + childAt.getMeasuredWidth()), Math.round(f + childAt.getMeasuredHeight()));
            }
            f = f2 * a;
            childAt.layout(Math.round(f3), Math.round(f), Math.round(f3 + childAt.getMeasuredWidth()), Math.round(f + childAt.getMeasuredHeight()));
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float measureWidth;
        if (!(getParent() instanceof AndroidContainerElement)) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            float a = getOwnerDocument().h().a();
            float f = size / a;
            fq computedStyle = getComputedStyle();
            float g = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f) + computedStyle.g(CssProperty.PADDING_LEFT, f);
            float g2 = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f) + computedStyle.g(CssProperty.PADDING_TOP, f);
            float g3 = computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f) + computedStyle.g(CssProperty.PADDING_BOTTOM, f);
            float g4 = computedStyle.g(CssProperty.PADDING_RIGHT, f) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f);
            if (mode == 1073741824) {
                measureWidth = (f - g) - g4;
            } else {
                measureWidth = getLayout().measureWidth(this, mode == Integer.MIN_VALUE ? Layout.Directive.MINIMUM : Layout.Directive.FIT_CONTENT, f);
            }
            setMeasuredDimension(Math.round((g + measureWidth + g4) * a), Math.round((g2 + getLayout().layout(this, g, g2, measureWidth, true) + g3) * a));
            return;
        }
        throw new RuntimeException("onMeasure expected for root HTML container only");
    }
}
