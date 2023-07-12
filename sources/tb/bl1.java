package tb;

import android.content.Context;
import com.taobao.phenix.cache.disk.DiskCache;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bl1 implements DiskCache {
    private final int a;

    public bl1(int i) {
        this.a = i;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    /* renamed from: a */
    public ne0 get(String str, int i) {
        return null;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public void clear() {
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean close() {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int[] getCatalogs(String str) {
        return new int[0];
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public long getLength(String str, int i) {
        return -1L;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public int getPriority() {
        return this.a;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean isSupportCatalogs() {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public void maxSize(int i) {
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean open(Context context) {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, InputStream inputStream) {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean put(String str, int i, byte[] bArr, int i2, int i3) {
        return false;
    }

    @Override // com.taobao.phenix.cache.disk.DiskCache
    public boolean remove(String str, int i) {
        return false;
    }
}
