package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream J = CodedOutputStream.J(outputStream, CodedOutputStream.u(CodedOutputStream.v(serializedSize) + serializedSize));
        J.o0(serializedSize);
        writeTo(J);
        J.I();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {
        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        public abstract BuilderType clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, c cVar) throws IOException;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class a extends FilterInputStream {
            private int a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(InputStream inputStream, int i) {
                super(inputStream);
                this.a = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long skip = super.skip(Math.min(j, this.a));
                if (skip >= 0) {
                    this.a = (int) (this.a - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.a;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.a -= read;
                }
                return read;
            }
        }
    }
}
