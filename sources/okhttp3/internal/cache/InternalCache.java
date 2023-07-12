package okhttp3.internal.cache;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.o;
import okhttp3.q;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface InternalCache {
    @Nullable
    q get(o oVar) throws IOException;

    @Nullable
    CacheRequest put(q qVar) throws IOException;

    void remove(o oVar) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(b bVar);

    void update(q qVar, q qVar2);
}
