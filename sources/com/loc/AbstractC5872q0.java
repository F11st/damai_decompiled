package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
/* renamed from: com.loc.q0 */
/* loaded from: classes10.dex */
public abstract class AbstractC5872q0 {
    s0 a;
    private ByteBuffer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC5872q0(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.a = new s0(this.b);
    }

    public final AbstractC5872q0 a() {
        this.a.c(this.b);
        return this;
    }
}
