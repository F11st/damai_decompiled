package mtopsdk.network.domain;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class RequestBody {
    public static RequestBody create(final String str, final byte[] bArr) throws Exception {
        Objects.requireNonNull(bArr, "content == null");
        return new RequestBody() { // from class: mtopsdk.network.domain.RequestBody.1
            @Override // mtopsdk.network.domain.RequestBody
            public long contentLength() {
                return bArr.length;
            }

            @Override // mtopsdk.network.domain.RequestBody
            public String contentType() {
                return str;
            }

            @Override // mtopsdk.network.domain.RequestBody
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }

    public long contentLength() {
        return -1L;
    }

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;
}
