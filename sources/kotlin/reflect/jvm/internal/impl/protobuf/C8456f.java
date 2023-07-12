package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f */
/* loaded from: classes3.dex */
public class C8456f extends ByteString {
    private static final int[] g;
    private final int a;
    private final ByteString b;
    private final ByteString c;
    private final int d;
    private final int e;
    private int f;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f$b */
    /* loaded from: classes3.dex */
    private static class C8458b {
        private final Stack<ByteString> a;

        private C8458b() {
            this.a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.a.pop();
            while (!this.a.isEmpty()) {
                pop = new C8456f(this.a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.j()) {
                e(byteString);
            } else if (byteString instanceof C8456f) {
                C8456f c8456f = (C8456f) byteString;
                c(c8456f.b);
                c(c8456f.c);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i) {
            int binarySearch = Arrays.binarySearch(C8456f.g, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(ByteString byteString) {
            int d = d(byteString.size());
            int i = C8456f.g[d + 1];
            if (!this.a.isEmpty() && this.a.peek().size() < i) {
                int i2 = C8456f.g[d];
                ByteString pop = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().size() < i2) {
                    pop = new C8456f(this.a.pop(), pop);
                }
                C8456f c8456f = new C8456f(pop, byteString);
                while (!this.a.isEmpty()) {
                    if (this.a.peek().size() >= C8456f.g[d(c8456f.size()) + 1]) {
                        break;
                    }
                    c8456f = new C8456f(this.a.pop(), c8456f);
                }
                this.a.push(c8456f);
                return;
            }
            this.a.push(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f$c */
    /* loaded from: classes3.dex */
    public static class C8459c implements Iterator<C8453e> {
        private final Stack<C8456f> a;
        private C8453e b;

        private C8453e a(ByteString byteString) {
            while (byteString instanceof C8456f) {
                C8456f c8456f = (C8456f) byteString;
                this.a.push(c8456f);
                byteString = c8456f.b;
            }
            return (C8453e) byteString;
        }

        private C8453e b() {
            while (!this.a.isEmpty()) {
                C8453e a = a(this.a.pop().c);
                if (!a.isEmpty()) {
                    return a;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public C8453e next() {
            C8453e c8453e = this.b;
            if (c8453e != null) {
                this.b = b();
                return c8453e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private C8459c(ByteString byteString) {
            this.a = new Stack<>();
            this.b = a(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f$d */
    /* loaded from: classes3.dex */
    public class C8460d implements ByteString.ByteIterator {
        private final C8459c a;
        private ByteString.ByteIterator b;
        int c;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c > 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (!this.b.hasNext()) {
                this.b = this.a.next().iterator();
            }
            this.c--;
            return this.b.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private C8460d(C8456f c8456f) {
            C8459c c8459c = new C8459c(c8456f);
            this.a = c8459c;
            this.b = c8459c.next().iterator();
            this.c = c8456f.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        g = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = g;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    private static C8453e A(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.g(bArr, 0, 0, size);
        byteString2.g(bArr, 0, size, size2);
        return new C8453e(bArr);
    }

    private boolean B(ByteString byteString) {
        C8459c c8459c = new C8459c(this);
        C8453e next = c8459c.next();
        C8459c c8459c2 = new C8459c(byteString);
        C8453e next2 = c8459c2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? next.x(next2, i2, min) : next2.x(next, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.a;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = c8459c.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == size2) {
                next2 = c8459c2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString z(ByteString byteString, ByteString byteString2) {
        C8456f c8456f = byteString instanceof C8456f ? (C8456f) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return A(byteString, byteString2);
            }
            if (c8456f != null && c8456f.c.size() + byteString2.size() < 128) {
                byteString2 = new C8456f(c8456f.b, A(c8456f.c, byteString2));
            } else if (c8456f != null && c8456f.b.i() > c8456f.c.i() && c8456f.i() > byteString2.i()) {
                byteString2 = new C8456f(c8456f.b, new C8456f(c8456f.c, byteString2));
            } else {
                if (size < g[Math.max(byteString.i(), byteString2.i()) + 1]) {
                    return new C8458b().b(byteString, byteString2);
                }
                return new C8456f(byteString, byteString2);
            }
        }
        return byteString2;
    }

    public boolean equals(Object obj) {
        int q;
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (this.a != byteString.size()) {
                return false;
            }
            if (this.a == 0) {
                return true;
            }
            if (this.f == 0 || (q = byteString.q()) == 0 || this.f == q) {
                return B(byteString);
            }
            return false;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void h(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            this.b.h(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.c.h(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.b.h(bArr, i, i2, i6);
            this.c.h(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public int hashCode() {
        int i = this.f;
        if (i == 0) {
            int i2 = this.a;
            i = o(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int i() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean j() {
        return this.a >= g[this.e];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean k() {
        int p = this.b.p(0, 0, this.d);
        ByteString byteString = this.c;
        return byteString.p(p, 0, byteString.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: l */
    public ByteString.ByteIterator iterator() {
        return new C8460d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream m() {
        return CodedInputStream.g(new C8461e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int o(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.o(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.o(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.o(this.b.o(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int p(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.d;
        if (i4 <= i5) {
            return this.b.p(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.c.p(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.c.p(this.b.p(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int q() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String s(String str) throws UnsupportedEncodingException {
        return new String(r(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void v(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.d;
        if (i3 <= i4) {
            this.b.v(outputStream, i, i2);
        } else if (i >= i4) {
            this.c.v(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.b.v(outputStream, i, i5);
            this.c.v(outputStream, 0, i2 - i5);
        }
    }

    private C8456f(ByteString byteString, ByteString byteString2) {
        this.f = 0;
        this.b = byteString;
        this.c = byteString2;
        int size = byteString.size();
        this.d = size;
        this.a = size + byteString2.size();
        this.e = Math.max(byteString.i(), byteString2.i()) + 1;
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.f$e */
    /* loaded from: classes3.dex */
    private class C8461e extends InputStream {
        private C8459c a;
        private C8453e b;
        private int c;
        private int d;
        private int e;
        private int f;

        public C8461e() {
            c();
        }

        private void a() {
            if (this.b != null) {
                int i = this.d;
                int i2 = this.c;
                if (i == i2) {
                    this.e += i2;
                    this.d = 0;
                    if (this.a.hasNext()) {
                        C8453e next = this.a.next();
                        this.b = next;
                        this.c = next.size();
                        return;
                    }
                    this.b = null;
                    this.c = 0;
                }
            }
        }

        private void c() {
            C8459c c8459c = new C8459c(C8456f.this);
            this.a = c8459c;
            C8453e next = c8459c.next();
            this.b = next;
            this.c = next.size();
            this.d = 0;
            this.e = 0;
        }

        private int d(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                a();
                if (this.b != null) {
                    int min = Math.min(this.c - this.d, i3);
                    if (bArr != null) {
                        this.b.g(bArr, this.d, i, min);
                        i += min;
                    }
                    this.d += min;
                    i3 -= min;
                } else if (i3 == i2) {
                    return -1;
                }
            }
            return i2 - i3;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return C8456f.this.size() - (this.e + this.d);
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f = this.e + this.d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            Objects.requireNonNull(bArr);
            if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return d(bArr, i, i2);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            c();
            d(null, 0, this.f);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return d(null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            C8453e c8453e = this.b;
            if (c8453e == null) {
                return -1;
            }
            int i = this.d;
            this.d = i + 1;
            return c8453e.w(i) & 255;
        }
    }
}
