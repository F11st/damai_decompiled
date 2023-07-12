package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Connection {
    @Nullable
    C8815k handshake();

    Protocol protocol();

    C8831s route();

    Socket socket();
}
