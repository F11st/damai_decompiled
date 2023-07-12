package kotlin.reflect.jvm.internal.impl.protobuf;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e extends ByteString {
    protected final byte[] a;
    private int b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class b implements ByteString.ByteIterator {
        private int a;
        private final int b;

        @Override // java.util.Iterator
        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = e.this.a;
                int i = this.a;
                this.a = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private b() {
            this.a = 0;
            this.b = e.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(byte[] bArr) {
        this.a = bArr;
    }

    static int z(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ByteString) && size() == ((ByteString) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof e) {
                return x((e) obj, 0, size());
            }
            if (obj instanceof f) {
                return obj.equals(this);
            }
            String valueOf = String.valueOf(obj.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 49);
            sb.append("Has a new type of ByteString been created? Found ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void h(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    public int hashCode() {
        int i = this.b;
        if (i == 0) {
            int size = size();
            i = o(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.b = i;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int i() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean j() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean k() {
        int y = y();
        return h.f(this.a, y, size() + y);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: l */
    public ByteString.ByteIterator iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream m() {
        return CodedInputStream.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int o(int i, int i2, int i3) {
        return z(i, this.a, y() + i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int p(int i, int i2, int i3) {
        int y = y() + i2;
        return h.g(i, this.a, y, i3 + y);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int q() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String s(String str) throws UnsupportedEncodingException {
        return new String(this.a, y(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.a.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void v(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.a, y() + i, i2);
    }

    public byte w(int i) {
        return this.a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(e eVar, int i, int i2) {
        if (i2 <= eVar.size()) {
            if (i + i2 <= eVar.size()) {
                byte[] bArr = this.a;
                byte[] bArr2 = eVar.a;
                int y = y() + i2;
                int y2 = y();
                int y3 = eVar.y() + i;
                while (y2 < y) {
                    if (bArr[y2] != bArr2[y3]) {
                        return false;
                    }
                    y2++;
                    y3++;
                }
                return true;
            }
            int size = eVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i);
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append(i2);
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int y() {
        return 0;
    }
}
