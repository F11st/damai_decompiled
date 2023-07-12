package anetwork.channel.interceptor;

import anet.channel.request.C0193a;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Interceptor {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Chain {
        Callback callback();

        Future proceed(C0193a c0193a, Callback callback);

        C0193a request();
    }

    Future intercept(Chain chain);
}
