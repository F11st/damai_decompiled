package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: tb.a9
        @Override // okhttp3.Authenticator
        public final okhttp3.o authenticate(okhttp3.s sVar, okhttp3.q qVar) {
            return okhttp3.b.a(sVar, qVar);
        }
    };

    @Nullable
    o authenticate(@Nullable s sVar, q qVar) throws IOException;
}
