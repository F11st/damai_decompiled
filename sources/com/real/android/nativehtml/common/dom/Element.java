package com.real.android.nativehtml.common.dom;

import tb.fq;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface Element {
    String getAttribute(String str);

    HtmlCollection getChildren();

    fq getComputedStyle();

    ContentType getElementContentType();

    ElementType getElementType();

    String getLocalName();

    qb0 getOwnerDocument();

    Element getParentElement();

    fq getStyle();

    String getTextContent();

    void insertBefore(Element element, Element element2);

    void setAttribute(String str, String str2);

    void setComputedStyle(fq fqVar);

    void setParentElement(Element element);

    void setTextContent(String str);
}
