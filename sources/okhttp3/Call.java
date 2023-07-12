package okhttp3;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Call extends Cloneable {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Factory {
        Call newCall(o oVar);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    q execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    o request();

    okio.o timeout();
}
