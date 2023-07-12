package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    okhttp3.internal.connection.e connection();

    Sink createRequestBody(o oVar, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Source openResponseBodySource(q qVar) throws IOException;

    @Nullable
    q.a readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(q qVar) throws IOException;

    l trailers() throws IOException;

    void writeRequestHeaders(o oVar) throws IOException;
}
