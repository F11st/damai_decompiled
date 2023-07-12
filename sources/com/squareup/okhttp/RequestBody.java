package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import okio.BufferedSink;
import okio.Source;
import okio.h;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class RequestBody {
    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new RequestBody() { // from class: com.squareup.okhttp.RequestBody.1
            @Override // com.squareup.okhttp.RequestBody
            public long contentLength() {
                return i2;
            }

            @Override // com.squareup.okhttp.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.squareup.okhttp.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i, i2);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new RequestBody() { // from class: com.squareup.okhttp.RequestBody.2
            @Override // com.squareup.okhttp.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // com.squareup.okhttp.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // com.squareup.okhttp.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = null;
                try {
                    source = h.j(file);
                    bufferedSink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }
}
