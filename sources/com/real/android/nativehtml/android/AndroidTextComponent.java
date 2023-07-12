package com.real.android.nativehtml.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.ComponentElement;
import com.real.android.nativehtml.common.layout.Layout;
import com.real.android.nativehtml.common.util.HtmlCollectionImpl;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import tb.fq;
import tb.qb0;
import tb.td0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class AndroidTextComponent extends TextView implements ComponentElement {
    private static final fq EMTPY_STYLE = new fq();
    static final int PAINT_MASK = -25;
    private static final String TAG = "AndroidTextComponent";
    private HtmlCollectionImpl children;
    private fq computedStyle;
    SpannableStringBuilder content;
    float contentBoxWidth;
    private boolean dirty;
    private final qb0 document;
    float x;
    float y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a extends ClickableSpan {
        final /* synthetic */ Element a;

        a(Element element) {
            this.a = element;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AndroidTextComponent.this.document.g().openLink(AndroidTextComponent.this.document.j(this.a.getAttribute("href")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            try {
                iArr[CssEnum.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CssEnum.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CssEnum.UNDERLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CssEnum.LINE_THROUGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CssEnum.SUB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CssEnum.SUPER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public AndroidTextComponent(Context context, qb0 qb0Var) {
        super(context);
        this.children = new HtmlCollectionImpl();
        this.content = new SpannableStringBuilder("");
        this.document = qb0Var;
        setTextIsSelectable(true);
    }

    private void validateContent() {
        if (this.dirty) {
            this.dirty = false;
            this.content.clear();
            this.content.clearSpans();
            for (int i = 0; i < this.children.getLength(); i++) {
                updateChild(this.children.item(i), this.computedStyle);
            }
            setText(this.content);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getAttribute(String str) {
        return null;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public HtmlCollection getChildren() {
        return this.children;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public fq getComputedStyle() {
        return this.computedStyle;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ContentType getElementContentType() {
        return ContentType.FORMATTED_TEXT;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public ElementType getElementType() {
        return ElementType.COMPONENT;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxHeightForWidth(float f, float f2) {
        validateContent();
        float a2 = this.document.h().a();
        measure(Math.round(f * a2) | 1073741824, 0);
        return getMeasuredHeight() / a2;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public float getIntrinsicContentBoxWidth(Layout.Directive directive, float f) {
        validateContent();
        float a2 = this.document.h().a();
        measure(Math.round(f * a2) | Integer.MIN_VALUE, 0);
        return getMeasuredWidth() / a2;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getLocalName() {
        return "text-container";
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public qb0 getOwnerDocument() {
        return this.document;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public Element getParentElement() {
        return (Element) getParent();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public fq getStyle() {
        return EMTPY_STYLE;
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public String getTextContent() {
        return td0.a(this);
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void insertBefore(Element element, Element element2) {
        this.children.insertBefore(this, element, element2);
        this.dirty = true;
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void moveRelative(float f, float f2) {
        this.x += f;
        this.y += f2;
    }

    @Override // android.view.View
    public void requestLayout() {
        this.dirty = true;
        super.requestLayout();
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setAttribute(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.real.android.nativehtml.common.layout.ComponentElement
    public void setBorderBoxBounds(float f, float f2, float f3, float f4, float f5) {
        this.contentBoxWidth = f5;
        this.x = f;
        this.y = f2;
        float a2 = this.document.h().a();
        setMeasuredDimension(Math.round(f3 * a2), Math.round(f4 * a2));
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setComputedStyle(fq fqVar) {
        this.computedStyle = fqVar;
        setTextSize(0, fqVar.g(CssProperty.FONT_SIZE, 0.0f) * this.document.h().a());
        setTextColor(fqVar.e(CssProperty.COLOR));
        setTypeface(com.real.android.nativehtml.android.a.e(fqVar));
        setPaintFlags((getPaintFlags() & PAINT_MASK) | com.real.android.nativehtml.android.a.c(fqVar));
        setTextIsSelectable(fqVar.f(CssProperty.USER_SELECT) != CssEnum.NONE);
        int i = b.a[this.computedStyle.f(CssProperty.TEXT_ALIGN).ordinal()];
        if (i == 1) {
            setGravity(5);
        } else if (i != 2) {
            setGravity(3);
        } else {
            setGravity(17);
        }
        this.dirty = true;
        if (HtmlView.isTextOneLine()) {
            setSingleLine(true);
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setParentElement(Element element) {
    }

    @Override // com.real.android.nativehtml.common.dom.Element
    public void setTextContent(String str) {
        throw new UnsupportedOperationException();
    }

    void updateChild(Element element, fq fqVar) {
        String attribute;
        int length = this.content.length();
        HtmlCollection children = element.getChildren();
        fq computedStyle = element.getComputedStyle();
        if (element.getLocalName().equals(BrightRemindSetting.BRIGHT_REMIND)) {
            this.content.append((CharSequence) StringUtils.LF);
        } else if (element.getLocalName().equals("img")) {
            this.content.append((CharSequence) "□");
        } else if (children.getLength() != 0) {
            for (int i = 0; i < children.getLength(); i++) {
                updateChild(children.item(i), computedStyle);
            }
        } else {
            this.content.append((CharSequence) element.getTextContent());
        }
        int length2 = this.content.length();
        ArrayList arrayList = new ArrayList();
        float a2 = this.document.h().a();
        if (element.getLocalName().equals("img") && (attribute = element.getAttribute("src")) != null && !attribute.isEmpty()) {
            Bitmap a3 = ((AndroidPlatform) this.document.f()).a(element, this.document.j(attribute));
            if (a3 != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), a3);
                float width = a3.getWidth();
                float height = a3.getHeight();
                CssProperty cssProperty = CssProperty.WIDTH;
                if (computedStyle.k(cssProperty)) {
                    width = computedStyle.g(cssProperty, this.contentBoxWidth);
                    if (computedStyle.k(CssProperty.HEIGHT)) {
                        height = computedStyle.g(cssProperty, this.contentBoxWidth);
                    } else {
                        height *= width / a3.getWidth();
                    }
                } else {
                    CssProperty cssProperty2 = CssProperty.HEIGHT;
                    if (computedStyle.k(cssProperty2)) {
                        height = computedStyle.g(cssProperty2, this.contentBoxWidth);
                        width *= height / a3.getHeight();
                    }
                }
                bitmapDrawable.setBounds(0, 0, Math.round(width * a2), Math.round(height * a2));
                arrayList.add(new ImageSpan(bitmapDrawable, 1));
            }
        }
        String b2 = com.real.android.nativehtml.android.a.b(computedStyle);
        if (!b2.equals(com.real.android.nativehtml.android.a.b(fqVar))) {
            arrayList.add(new TypefaceSpan(b2));
        }
        int d = com.real.android.nativehtml.android.a.d(computedStyle);
        if (d != com.real.android.nativehtml.android.a.d(fqVar)) {
            arrayList.add(new StyleSpan(d));
        }
        CssProperty cssProperty3 = CssProperty.FONT_SIZE;
        float g = fqVar.g(cssProperty3, 0.0f);
        if (g != computedStyle.g(cssProperty3, 0.0f)) {
            arrayList.add(new AbsoluteSizeSpan(Math.round(g * a2)));
        }
        CssProperty cssProperty4 = CssProperty.COLOR;
        int e = computedStyle.e(cssProperty4);
        if (e != fqVar.e(cssProperty4)) {
            arrayList.add(new ForegroundColorSpan(e));
        }
        CssProperty cssProperty5 = CssProperty.TEXT_DECORATION;
        CssEnum f = computedStyle.f(cssProperty5);
        if (f != fqVar.f(cssProperty5)) {
            int i2 = b.a[f.ordinal()];
            if (i2 == 3) {
                arrayList.add(new UnderlineSpan());
            } else if (i2 == 4) {
                arrayList.add(new StrikethroughSpan());
            }
        }
        CssProperty cssProperty6 = CssProperty.VERTICAL_ALIGN;
        CssEnum f2 = computedStyle.f(cssProperty6);
        if (f2 != fqVar.f(cssProperty6)) {
            int i3 = b.a[f2.ordinal()];
            if (i3 == 5) {
                arrayList.add(new SubscriptSpan());
            } else if (i3 == 6) {
                arrayList.add(new SuperscriptSpan());
            }
        }
        if (element.getLocalName().equals("a") && element.getAttribute("href") != null) {
            setTextIsSelectable(false);
            setMovementMethod(LinkMovementMethod.getInstance());
            arrayList.add(new a(element));
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.content.setSpan(it.next(), length, length2, 0);
            }
        }
    }
}
