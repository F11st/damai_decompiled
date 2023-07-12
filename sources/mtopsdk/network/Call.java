package mtopsdk.network;

import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Call {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    void enqueue(NetworkCallback networkCallback);

    Response execute() throws Exception;

    Request request();
}
