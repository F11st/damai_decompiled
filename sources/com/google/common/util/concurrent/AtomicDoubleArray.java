package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import tb.jn1;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i) {
        this.longs = new AtomicLongArray(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.C5253b builder = ImmutableLongArray.builder();
        for (int i = 0; i < readInt; i++) {
            builder.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.d().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeDouble(get(i));
        }
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i);
            longBitsToDouble = Double.longBitsToDouble(j) + d;
        } while (!this.longs.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i, double d, double d2) {
        return this.longs.compareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.longs.get(i));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i);
            longBitsToDouble = Double.longBitsToDouble(j);
        } while (!this.longs.compareAndSet(i, j, Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i, double d) {
        return Double.longBitsToDouble(this.longs.getAndSet(i, Double.doubleToRawLongBits(d)));
    }

    public final void lazySet(int i, double d) {
        this.longs.lazySet(i, Double.doubleToRawLongBits(d));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i, double d) {
        this.longs.set(i, Double.doubleToRawLongBits(d));
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder((length + 1) * 19);
        sb.append(jn1.ARRAY_START);
        int i = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i)));
            if (i == length) {
                sb.append(jn1.ARRAY_END);
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i++;
        }
    }

    public final boolean weakCompareAndSet(int i, double d, double d2) {
        return this.longs.weakCompareAndSet(i, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d2));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(dArr[i]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
