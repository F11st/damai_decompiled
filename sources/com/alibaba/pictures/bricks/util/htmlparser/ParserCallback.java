package com.alibaba.pictures.bricks.util.htmlparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.vz0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ParserCallback {
    void characters(@Nullable char[] cArr, int i, int i2);

    void endDocument();

    void endElement(int i, @Nullable String str);

    void startDocument(int i);

    void startElement(@NotNull vz0 vz0Var);
}
