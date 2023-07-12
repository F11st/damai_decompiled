package anetwork.channel.interceptor;

import anet.channel.request.a;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Interceptor {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Chain {
        Callback callback();

        Future proceed(a aVar, Callback callback);

        a request();
    }

    Future intercept(Chain chain);
}
