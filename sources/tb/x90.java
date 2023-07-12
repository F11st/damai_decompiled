package tb;

import android.text.TextUtils;
import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.phenix.request.C6865a;
import com.taobao.rxm.consume.Consumer;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x90 extends AbstractC9433ma<z40, z40> {
    private DiskCacheKeyValueStore k;

    public x90(DiskCacheSupplier diskCacheSupplier, DiskCacheKeyValueStore diskCacheKeyValueStore) {
        super(0, 2, diskCacheSupplier);
        this.k = diskCacheKeyValueStore;
    }

    private boolean N(C6865a c6865a) {
        Map<String, String> H = c6865a.H();
        return (this.k == null || H == null || TextUtils.isEmpty(H.get("max-age")) || !this.k.isTTLDomain(c6865a.N())) ? false : true;
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: M */
    public void consumeNewResult(Consumer<z40, C6865a> consumer, boolean z, z40 z40Var) {
        xt2.n("Phenix", "DiskCache Writer Started.", consumer.getContext());
        consumer.onNewResult(z40Var, z);
        L(consumer.getContext(), z40Var.d(), true);
        if (N(consumer.getContext())) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str = consumer.getContext().H().get("max-age");
                if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                    String str2 = consumer.getContext().D() + consumer.getContext().C();
                    long longValue = Long.valueOf(str).longValue();
                    consumer.getContext().U().B = !(this.k.isExpectedTime(longValue) ? this.k.put(str2, longValue) : false);
                    consumer.getContext().U().A = System.currentTimeMillis() - currentTimeMillis;
                }
                xt2.n("Phenix", "DiskCache Writer Put TTL Time", consumer.getContext());
            } catch (Exception e) {
                hh0.c("TTL", "ttl put error=%s", e);
            }
        }
        xt2.n("Phenix", "DiskCache Writer Ended.", consumer.getContext());
    }

    @Override // tb.jh
    protected boolean a(Consumer<z40, C6865a> consumer) {
        return false;
    }
}
