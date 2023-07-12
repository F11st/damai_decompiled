package kotlin.reflect.jvm.internal.impl.protobuf;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.b */
/* loaded from: classes3.dex */
public class C8444b extends C8453e {
    private final int c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.b$b */
    /* loaded from: classes3.dex */
    public class C8446b implements ByteString.ByteIterator {
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
            int i = this.a;
            if (i < this.b) {
                byte[] bArr = C8444b.this.a;
                this.a = i + 1;
                return bArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private C8446b() {
            int y = C8444b.this.y();
            this.a = y;
            this.b = y + C8444b.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8444b(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0) {
            if (i + i2 <= bArr.length) {
                this.c = i;
                this.d = i2;
                return;
            }
            StringBuilder sb2 = new StringBuilder(48);
            sb2.append("Offset+Length too large: ");
            sb2.append(i);
            sb2.append(jn1.PLUS);
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.C8453e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void h(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, y() + i, bArr, i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.C8453e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* renamed from: l */
    public ByteString.ByteIterator iterator() {
        return new C8446b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.C8453e, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.C8453e
    public byte w(int i) {
        if (i >= 0) {
            if (i < size()) {
                return this.a[this.c + i];
            }
            int size = size();
            StringBuilder sb = new StringBuilder(41);
            sb.append("Index too large: ");
            sb.append(i);
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append(size);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("Index too small: ");
        sb2.append(i);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.C8453e
    public int y() {
        return this.c;
    }
}
