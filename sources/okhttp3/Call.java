package okhttp3;

import java.io.IOException;
import okio.C8857o;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Call extends Cloneable {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Factory {
        Call newCall(C8823o c8823o);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    C8827q execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C8823o request();

    C8857o timeout();
}
