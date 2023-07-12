package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C8736b;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.C8831s;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: tb.a9
        @Override // okhttp3.Authenticator
        public final C8823o authenticate(C8831s c8831s, C8827q c8827q) {
            return C8736b.a(c8831s, c8827q);
        }
    };

    @Nullable
    C8823o authenticate(@Nullable C8831s c8831s, C8827q c8827q) throws IOException;
}
