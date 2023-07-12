package tb;

import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.l;
import okhttp3.q;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class w31 {
    public static w31 a;

    public abstract void a(l.a aVar, String str);

    public abstract void b(l.a aVar, String str, String str2);

    public abstract void c(okhttp3.g gVar, SSLSocket sSLSocket, boolean z);

    public abstract int d(q.a aVar);

    public abstract boolean e(okhttp3.a aVar, okhttp3.a aVar2);

    @Nullable
    public abstract okhttp3.internal.connection.c f(okhttp3.q qVar);

    public abstract void g(q.a aVar, okhttp3.internal.connection.c cVar);

    public abstract Call h(OkHttpClient okHttpClient, okhttp3.o oVar);

    public abstract okhttp3.internal.connection.f i(okhttp3.f fVar);
}
