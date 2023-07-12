package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.charset.Charset;

/* compiled from: Taobao */
@CanIgnoreReturnValue
/* loaded from: classes10.dex */
abstract class c implements Hasher {
    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public abstract Hasher putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public abstract Hasher putChar(char c);

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public abstract Hasher putInt(int i);

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public abstract Hasher putLong(long j);

    @Override // com.google.common.hash.Hasher
    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public final Hasher putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putShort(short s) {
        putByte((byte) s);
        putByte((byte) (s >>> 8));
        return this;
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.PrimitiveSink
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }
}
