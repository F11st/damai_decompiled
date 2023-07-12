package com.real.android.nativehtml.common.io;

import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.Platform;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.xmlpull.v1.XmlPullParserException;
import tb.f13;
import tb.gq;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a {
    private final HtmlNormalizer a;
    private final Platform b;
    private gq c;
    private qb0 d;
    private f13 e;
    private RequestHandler f;
    String g = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.real.android.nativehtml.common.io.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C0270a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ContentType.values().length];
            a = iArr;
            try {
                iArr[ContentType.COMPONENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ContentType.DATA_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ContentType.TEXT_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(Platform platform, RequestHandler requestHandler, f13 f13Var) {
        this.b = platform;
        this.f = requestHandler;
        this.e = f13Var;
        try {
            this.a = new HtmlNormalizer();
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        }
    }

    private String a(String str, boolean z) {
        boolean z2 = !z;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > ' ') {
                sb.append(charAt);
                z2 = false;
            } else if (!z2) {
                sb.append(' ');
                z2 = true;
            }
        }
        return sb.toString();
    }

    private void c(Element element) throws IOException, XmlPullParserException {
        while (this.a.e() != 3 && this.a.e() != 1) {
            if ((this.a.e() != 2 && this.a.e() != 4) || (this.a.e() == 4 && this.a.h().trim().isEmpty())) {
                this.a.i();
            } else if (this.a.e() == 2 && qb0.d(this.a.f()) != ElementType.FORMATTED_TEXT) {
                if (qb0.d(this.a.f()).equals(ElementType.SKIP)) {
                    this.a.i();
                    c(element);
                    this.a.i();
                } else {
                    Element e = e();
                    if (e.getElementType() == ElementType.COMPONENT) {
                        element.insertBefore(e, null);
                    } else if (e.getLocalName().equals("head") && this.d.e() == null) {
                        this.d.l(e);
                    }
                    this.a.i();
                }
            } else {
                g(element);
            }
        }
    }

    private void d(Element element) throws IOException, XmlPullParserException {
        while (this.a.e() != 3 && this.a.e() != 1) {
            if (this.a.e() == 2) {
                element.insertBefore(e(), null);
            }
            this.a.i();
        }
    }

    private Element e() throws IOException, XmlPullParserException {
        this.g += AltriaXLaunchTime.SPACE;
        Element b = this.d.b(this.a.f());
        for (int i = 0; i < this.a.a(); i++) {
            b.setAttribute(this.a.b(i), this.a.c(i));
        }
        this.a.i();
        int i2 = C0270a.a[b.getElementContentType().ordinal()];
        if (i2 == 1) {
            c(b);
        } else if (i2 == 2) {
            d(b);
        } else if (i2 != 3) {
            f(null);
        } else {
            StringBuilder sb = new StringBuilder();
            f(sb);
            String sb2 = sb.toString();
            if ("style".equals(b.getLocalName())) {
                this.c.k(sb2, this.d.i(), new int[0], null, null);
            }
            b.setTextContent(sb2);
        }
        this.g = this.g.substring(2);
        return b;
    }

    private void f(StringBuilder sb) throws IOException, XmlPullParserException {
        while (this.a.e() != 3) {
            int e = this.a.e();
            if (e == 2) {
                this.a.i();
                f(sb);
                this.a.i();
            } else if (e == 4) {
                if (sb != null) {
                    sb.append(this.a.h());
                }
                this.a.i();
            } else {
                throw new RuntimeException("Unexpected event: " + this.a.g());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
        if (r0 != r4) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(com.real.android.nativehtml.common.dom.Element r11) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.real.android.nativehtml.common.io.a.g(com.real.android.nativehtml.common.dom.Element):void");
    }

    public Element b(Reader reader, URI uri) {
        try {
            this.a.j(reader);
            this.a.i();
            this.d = new qb0(this.b, this.f, this.e, uri);
            this.c = gq.f(20);
            Element b = this.d.b("body");
            c(b);
            if (b.getChildren().getLength() == 1) {
                b = b.getChildren().item(0);
                b.setParentElement(null);
            }
            this.d.k(b);
            this.c.a(b, this.d.i());
            return b;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException(e2);
        }
    }

    Element h(Element element, Element element2, Element element3) {
        if (element.getParentElement() != element2) {
            element3 = h(element.getParentElement(), element2, element3);
        }
        Element b = this.d.b(element.getLocalName());
        element3.insertBefore(b, null);
        return b;
    }
}
