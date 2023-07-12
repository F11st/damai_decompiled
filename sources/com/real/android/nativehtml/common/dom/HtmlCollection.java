package com.real.android.nativehtml.common.dom;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface HtmlCollection {
    public static final HtmlCollection EMPTY = new C6142a();

    /* compiled from: Taobao */
    /* renamed from: com.real.android.nativehtml.common.dom.HtmlCollection$a */
    /* loaded from: classes5.dex */
    static class C6142a implements HtmlCollection {
        C6142a() {
        }

        @Override // com.real.android.nativehtml.common.dom.HtmlCollection
        public int getLength() {
            return 0;
        }

        @Override // com.real.android.nativehtml.common.dom.HtmlCollection
        public Element item(int i) {
            return null;
        }
    }

    int getLength();

    Element item(int i);
}
