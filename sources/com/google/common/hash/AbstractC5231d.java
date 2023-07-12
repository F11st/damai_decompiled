package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import tb.du1;

/* compiled from: Taobao */
@CanIgnoreReturnValue
/* renamed from: com.google.common.hash.d */
/* loaded from: classes10.dex */
abstract class AbstractC5231d extends AbstractC5230c {
    private final ByteBuffer a;
    private final int b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5231d(int i) {
        this(i, i);
    }

    private void b() {
        this.a.flip();
        while (this.a.remaining() >= this.c) {
            d(this.a);
        }
        this.a.compact();
    }

    private void c() {
        if (this.a.remaining() < 8) {
            b();
        }
    }

    private Hasher f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            c();
            return this;
        }
        int position = this.b - this.a.position();
        for (int i = 0; i < position; i++) {
            this.a.put(byteBuffer.get());
        }
        b();
        while (byteBuffer.remaining() >= this.c) {
            d(byteBuffer);
        }
        this.a.put(byteBuffer);
        return this;
    }

    protected abstract HashCode a();

    protected abstract void d(ByteBuffer byteBuffer);

    protected abstract void e(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        b();
        this.a.flip();
        if (this.a.remaining() > 0) {
            e(this.a);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return a();
    }

    protected AbstractC5231d(int i, int i2) {
        du1.d(i2 % i == 0);
        this.a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        this.a.put(b);
        c();
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        this.a.putChar(c);
        c();
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        this.a.putInt(i);
        c();
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        this.a.putLong(j);
        c();
        return this;
    }

    @Override // com.google.common.hash.AbstractC5230c, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        this.a.putShort(s);
        c();
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return f(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return f(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }
}
