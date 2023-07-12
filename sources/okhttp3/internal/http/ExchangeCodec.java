package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.internal.connection.C8770e;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    C8770e connection();

    Sink createRequestBody(C8823o c8823o, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Source openResponseBodySource(C8827q c8827q) throws IOException;

    @Nullable
    C8827q.C8828a readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(C8827q c8827q) throws IOException;

    C8816l trailers() throws IOException;

    void writeRequestHeaders(C8823o c8823o) throws IOException;
}
