package okhttp3.internal.cache;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C8823o;
import okhttp3.C8827q;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface InternalCache {
    @Nullable
    C8827q get(C8823o c8823o) throws IOException;

    @Nullable
    CacheRequest put(C8827q c8827q) throws IOException;

    void remove(C8823o c8823o) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(C8761b c8761b);

    void update(C8827q c8827q, C8827q c8827q2);
}
