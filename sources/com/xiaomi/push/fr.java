package com.xiaomi.push;

import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class fr extends fl {
    public fr() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fl
    /* renamed from: a */
    public ByteBuffer mo889a(ByteBuffer byteBuffer) {
        return m892a().length == 0 ? byteBuffer : super.mo889a(byteBuffer);
    }

    @Override // com.xiaomi.push.fl
    public int c() {
        if (m892a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
