package tb;

import android.net.Uri;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class wh1 implements CacheKey {
    final List<CacheKey> a;

    public List<CacheKey> a() {
        return this.a;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof wh1) {
            return this.a.equals(((wh1) obj).a);
        }
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public String toString() {
        return "MultiCacheKey:" + this.a.toString();
    }
}
