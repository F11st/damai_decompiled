package anetwork.channel;

import android.os.Handler;
import anetwork.channel.aidl.Connection;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Network {
    Future<Response> asyncSend(Request request, Object obj, Handler handler, NetworkListener networkListener);

    Connection getConnection(Request request, Object obj);

    Response syncSend(Request request, Object obj);
}
