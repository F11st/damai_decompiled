package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;
import tb.g13;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface WebSocket {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Factory {
        WebSocket newWebSocket(C8823o c8823o, g13 g13Var);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    C8823o request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
