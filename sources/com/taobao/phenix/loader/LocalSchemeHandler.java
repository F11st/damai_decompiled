package com.taobao.phenix.loader;

import java.io.IOException;
import tb.p22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface LocalSchemeHandler {
    p22 handleScheme(String str) throws IOException;

    boolean isSupported(String str);
}
