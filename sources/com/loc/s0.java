package com.loc;

import java.nio.ByteBuffer;
import tb.b73;
import tb.c83;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class s0 extends c83 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    @Override // tb.c83
    public final int b(CharSequence charSequence) {
        try {
            return super.b(charSequence);
        } catch (Throwable th) {
            b73.a(th);
            return super.b("");
        }
    }
}
