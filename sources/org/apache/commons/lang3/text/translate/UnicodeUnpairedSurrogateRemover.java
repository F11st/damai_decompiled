package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        return i >= 55296 && i <= 57343;
    }
}
