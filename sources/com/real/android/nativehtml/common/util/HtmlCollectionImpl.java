package com.real.android.nativehtml.common.util;

import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HtmlCollectionImpl extends ArrayList<Element> implements HtmlCollection {
    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public int getLength() {
        return size();
    }

    public void insertBefore(Element element, Element element2, Element element3) {
        add(element2);
        element2.setParentElement(element);
    }

    @Override // com.real.android.nativehtml.common.dom.HtmlCollection
    public Element item(int i) {
        return get(i);
    }
}
