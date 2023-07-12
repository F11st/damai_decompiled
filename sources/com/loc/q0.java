package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class q0 {
    s0 a;
    private ByteBuffer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.b = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.a = new s0(this.b);
    }

    public final q0 a() {
        this.a.c(this.b);
        return this;
    }
}
