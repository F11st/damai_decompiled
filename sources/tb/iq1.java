package tb;

import android.net.Uri;
import com.taobao.alivfssdk.fresco.cache.common.CacheKey;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class iq1 implements CacheKey {
    final String a;
    public final String b;

    public iq1(String str, String str2) {
        this.a = (String) bu1.a(str);
        this.b = str2;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return this.a.contains(uri.toString());
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        iq1 iq1Var = (iq1) obj;
        String str = this.a;
        if (str == null ? iq1Var.a == null : str.equals(iq1Var.a)) {
            String str2 = this.b;
            String str3 = iq1Var.b;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheKey
    public String toString() {
        return this.a;
    }
}
