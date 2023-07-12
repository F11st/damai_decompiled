package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString EMPTY = new e(new byte[0]);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    private static ByteString a(Iterator<ByteString> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return a(it, i2).b(a(it, i - i2));
    }

    public static ByteString c(Iterable<ByteString> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            for (ByteString byteString : iterable) {
                collection.add(byteString);
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return EMPTY;
        }
        return a(collection.iterator(), collection.size());
    }

    public static ByteString d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static ByteString e(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new e(bArr2);
    }

    public static ByteString f(String str) {
        try {
            return new e(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static a n() {
        return new a(128);
    }

    public ByteString b(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (size + size2 < 2147483647L) {
            return f.z(this, byteString);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append(jn1.PLUS);
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public void g(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else if (i3 >= 0) {
            int i4 = i + i3;
            if (i4 <= size()) {
                int i5 = i2 + i3;
                if (i5 <= bArr.length) {
                    if (i3 > 0) {
                        h(bArr, i, i2, i3);
                        return;
                    }
                    return;
                }
                StringBuilder sb3 = new StringBuilder(34);
                sb3.append("Target end offset < 0: ");
                sb3.append(i5);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i4);
            throw new IndexOutOfBoundsException(sb4.toString());
        } else {
            StringBuilder sb5 = new StringBuilder(23);
            sb5.append("Length < 0: ");
            sb5.append(i3);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void h(byte[] bArr, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int i();

    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean j();

    public abstract boolean k();

    @Override // java.lang.Iterable
    /* renamed from: l */
    public abstract ByteIterator iterator();

    public abstract CodedInputStream m();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int o(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int p(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int q();

    public byte[] r() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        h(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String s(String str) throws UnsupportedEncodingException;

    public abstract int size();

    public String t() {
        try {
            return s("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(OutputStream outputStream, int i, int i2) throws IOException {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= size()) {
                if (i2 > 0) {
                    v(outputStream, i, i2);
                    return;
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder(39);
            sb2.append("Source end offset exceeded: ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i2);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void v(OutputStream outputStream, int i, int i2) throws IOException;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends OutputStream {
        private static final byte[] f = new byte[0];
        private final int a;
        private final ArrayList<ByteString> b;
        private int c;
        private byte[] d;
        private int e;

        a(int i) {
            if (i >= 0) {
                this.a = i;
                this.b = new ArrayList<>();
                this.d = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] a(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        private void b(int i) {
            this.b.add(new e(this.d));
            int length = this.c + this.d.length;
            this.c = length;
            this.d = new byte[Math.max(this.a, Math.max(i, length >>> 1))];
            this.e = 0;
        }

        private void c() {
            int i = this.e;
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.b.add(new e(this.d));
                this.d = f;
            } else if (i > 0) {
                this.b.add(new e(a(bArr, i)));
            }
            this.c += this.e;
            this.e = 0;
        }

        public synchronized int e() {
            return this.c + this.e;
        }

        public synchronized ByteString f() {
            c();
            return ByteString.c(this.b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(e()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.e == this.d.length) {
                b(1);
            }
            byte[] bArr = this.d;
            int i2 = this.e;
            this.e = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i3 = this.e;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.e += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                b(i4);
                System.arraycopy(bArr, i + length2, this.d, 0, i4);
                this.e = i4;
            }
        }
    }
}
