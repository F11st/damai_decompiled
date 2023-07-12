package com.real.android.nativehtml.common.dom;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import tb.qb0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface Platform {
    Element createElement(qb0 qb0Var, ElementType elementType, String str);

    float getPixelPerDp();

    void openInBrowser(URI uri);

    InputStream openInputStream(URI uri) throws IOException;
}
