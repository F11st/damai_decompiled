package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.alivfssdk.cache.C6258a;
import com.taobao.alivfssdk.cache.C6261b;
import com.taobao.alivfssdk.cache.IAVFSCache;
import com.taobao.phenix.cache.disk.DiskCache;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x4 implements DiskCache {
    private final int a;
    private final String b;
    private IAVFSCache c;
    private volatile int d;

    public x4(int i, String str) {
        cu1.b(!TextUtils.isEmpty(str), "name cannot be empty when constructing AlivfsDiskCache");
        this.a = i;
        this.b = "phximgs_" + str;
    }

    private synchronized boolean a() {
        C6258a a;
        if (this.c == null && (a = C6261b.d().a(this.b)) != null) {
            C9152g0 c9152g0 = new C9152g0();
            c9152g0.a = Long.valueOf(this.d);
            a.f(c9152g0);
            this.c = a.c();
        }
        return this.c != null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public synchronized void clear() {
        C6261b.d().g(this.b);
        xt2.f("DiskCache", "remove alivfs cache module(%s)", this.b);
        this.c = null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean close() {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public p22 get(String str, int i) {
        int lengthForKey;
        InputStream inputStreamForKey;
        if (!a() || (lengthForKey = (int) this.c.lengthForKey(str, String.valueOf(i))) <= 0 || (inputStreamForKey = this.c.inputStreamForKey(str, String.valueOf(i))) == null) {
            return null;
        }
        return new p22(inputStreamForKey, lengthForKey);
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int[] getCatalogs(String str) {
        List<String> extendsKeysForKey;
        if (!a() || (extendsKeysForKey = this.c.extendsKeysForKey(str)) == null || extendsKeysForKey.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[extendsKeysForKey.size()];
        for (int i = 0; i < extendsKeysForKey.size(); i++) {
            try {
                iArr[i] = Integer.parseInt(extendsKeysForKey.get(i));
            } catch (NumberFormatException unused) {
            }
        }
        return iArr;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public long getLength(String str, int i) {
        if (a()) {
            long lengthForKey = (int) this.c.lengthForKey(str, String.valueOf(i));
            if (lengthForKey > 0) {
                return lengthForKey;
            }
            return -1L;
        }
        return -1L;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int getPriority() {
        return this.a;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean isSupportCatalogs() {
        return true;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public void maxSize(int i) {
        this.d = i;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean open(Context context) {
        return a();
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, InputStream inputStream) {
        return a() && inputStream != null && this.c.setStreamForKey(str, String.valueOf(i), inputStream);
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean remove(String str, int i) {
        return a() && this.c.removeObjectForKey(str, String.valueOf(i));
    }

    public String toString() {
        return "AlivfsDiskCache(" + Integer.toHexString(hashCode()) + ", name@" + this.b + jn1.BRACKET_END_STR;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, byte[] bArr, int i2, int i3) {
        return put(str, i, (bArr == null || i3 <= 0) ? null : new ByteArrayInputStream(bArr, i2, i3));
    }
}
