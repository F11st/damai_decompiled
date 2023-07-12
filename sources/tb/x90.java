package tb;

import android.text.TextUtils;
import com.taobao.phenix.cache.disk.DiskCacheKeyValueStore;
import com.taobao.phenix.cache.disk.DiskCacheSupplier;
import com.taobao.rxm.consume.Consumer;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x90 extends ma<z40, z40> {
    private DiskCacheKeyValueStore k;

    public x90(DiskCacheSupplier diskCacheSupplier, DiskCacheKeyValueStore diskCacheKeyValueStore) {
        super(0, 2, diskCacheSupplier);
        this.k = diskCacheKeyValueStore;
    }

    private boolean N(com.taobao.phenix.request.a aVar) {
        Map<String, String> H = aVar.H();
        return (this.k == null || H == null || TextUtils.isEmpty(H.get("max-age")) || !this.k.isTTLDomain(aVar.N())) ? false : true;
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: M */
    public void consumeNewResult(Consumer<z40, com.taobao.phenix.request.a> consumer, boolean z, z40 z40Var) {
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
    protected boolean a(Consumer<z40, com.taobao.phenix.request.a> consumer) {
        return false;
    }
}
