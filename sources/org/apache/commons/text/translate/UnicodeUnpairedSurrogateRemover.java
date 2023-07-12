package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    @Override // org.apache.commons.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        return i >= 55296 && i <= 57343;
    }
}
