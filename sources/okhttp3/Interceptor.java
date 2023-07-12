package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Interceptor {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        q proceed(o oVar) throws IOException;

        int readTimeoutMillis();

        o request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    q intercept(Chain chain) throws IOException;
}
