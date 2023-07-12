package tb;

import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.C8735a;
import okhttp3.C8748f;
import okhttp3.C8749g;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.internal.connection.C8766c;
import okhttp3.internal.connection.C8772f;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class w31 {
    public static w31 a;

    public abstract void a(C8816l.C8817a c8817a, String str);

    public abstract void b(C8816l.C8817a c8817a, String str, String str2);

    public abstract void c(C8749g c8749g, SSLSocket sSLSocket, boolean z);

    public abstract int d(C8827q.C8828a c8828a);

    public abstract boolean e(C8735a c8735a, C8735a c8735a2);

    @Nullable
    public abstract C8766c f(C8827q c8827q);

    public abstract void g(C8827q.C8828a c8828a, C8766c c8766c);

    public abstract Call h(OkHttpClient okHttpClient, C8823o c8823o);

    public abstract C8772f i(C8748f c8748f);
}
