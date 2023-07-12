package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.C8781c;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.a */
/* loaded from: classes2.dex */
public final class C8764a implements Interceptor {
    public C8764a(OkHttpClient okHttpClient) {
    }

    @Override // okhttp3.Interceptor
    public C8827q intercept(Interceptor.Chain chain) throws IOException {
        C8781c c8781c = (C8781c) chain;
        C8823o request = c8781c.request();
        C8776i c = c8781c.c();
        return c8781c.b(request, c, c.k(chain, !request.g().equals("GET")));
    }
}
