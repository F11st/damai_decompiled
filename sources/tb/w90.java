package tb;

import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.phenix.request.C6865a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w90 extends AbstractC9433ma<oe0, oe0> {
    private DiskCacheKeyValueStore k;

    public w90(DiskCacheSupplier diskCacheSupplier, DiskCacheKeyValueStore diskCacheKeyValueStore) {
        super(1, 0, diskCacheSupplier);
        this.k = diskCacheKeyValueStore;
    }

    private boolean M(C6865a c6865a) {
        DiskCacheKeyValueStore diskCacheKeyValueStore = this.k;
        return diskCacheKeyValueStore != null && diskCacheKeyValueStore.isTTLDomain(c6865a.N());
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    @Override // tb.jh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(com.taobao.rxm.consume.Consumer<tb.oe0, com.taobao.phenix.request.C6865a> r24) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.w90.a(com.taobao.rxm.consume.Consumer):boolean");
    }
}
