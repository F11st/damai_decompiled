package com.taobao.phenix.chain;

import com.taobao.phenix.cache.memory.MemoryCacheProducer;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.loader.file.b;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.ce1;
import tb.d62;
import tb.h42;
import tb.w90;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PhenixProduceListener implements ProducerListener<com.taobao.phenix.request.a> {
    private final IPhenixListener<ce1> a;
    private final ImageDecodingListener b;
    private final com.taobao.phenix.request.a c;
    private ScheduledAction d;
    private Scheduler e;
    private Map<String, Long> f = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public String a;
        public ImageStatistics.FromType b;

        public a(String str, ImageStatistics.FromType fromType) {
            this.a = str;
            this.b = fromType;
        }
    }

    public PhenixProduceListener(com.taobao.phenix.request.a aVar, IPhenixListener<ce1> iPhenixListener, ImageDecodingListener imageDecodingListener) {
        this.a = iPhenixListener;
        this.c = aVar;
        this.b = imageDecodingListener;
    }

    private void c(Class cls, boolean z, boolean z2) {
        if (this.a == null || z || z2 || cls != MemoryCacheProducer.class) {
            return;
        }
        Scheduler scheduler = this.e;
        if (scheduler != null && (!scheduler.isScheduleMainThread() || !h42.b())) {
            if (this.d == null) {
                this.d = new ScheduledAction(3, null, null) { // from class: com.taobao.phenix.chain.PhenixProduceListener.1
                    @Override // com.taobao.rxm.schedule.ScheduledAction
                    public void run(Consumer consumer, d62 d62Var) {
                        ce1 ce1Var = new ce1(PhenixProduceListener.this.c.P());
                        ce1Var.c(PhenixProduceListener.this.c.N());
                        PhenixProduceListener.this.a.onHappen(ce1Var);
                    }
                };
            }
            this.e.schedule(this.d);
            return;
        }
        this.a.onHappen(new ce1(this.c.P()));
    }

    private a d(Class cls, boolean z) {
        if (cls == MemoryCacheProducer.class) {
            return new a(ImageStatistics.KEY_READ_MEMORY_CACHE, ImageStatistics.FromType.FROM_MEMORY_CACHE);
        }
        if (cls == b.class) {
            return new a(ImageStatistics.KEY_READ_LOCAL_FILE, ImageStatistics.FromType.FROM_LOCAL_FILE);
        }
        if (cls == w90.class) {
            return new a(ImageStatistics.KEY_READ_DISK_CACHE, ImageStatistics.FromType.FROM_DISK_CACHE);
        }
        if (cls == com.taobao.phenix.loader.network.b.class) {
            return new a(z ? "download" : "connect", ImageStatistics.FromType.FROM_NETWORK);
        } else if (cls == com.taobao.phenix.bitmap.a.class) {
            return new a(z ? ImageStatistics.KEY_BITMAP_PROCESS : ImageStatistics.KEY_BITMAP_SCALE, z ? ImageStatistics.FromType.FROM_UNKNOWN : ImageStatistics.FromType.FROM_LARGE_SCALE);
        } else if (cls == com.taobao.phenix.decode.a.class) {
            return new a(ImageStatistics.KEY_BITMAP_DECODE, ImageStatistics.FromType.FROM_UNKNOWN);
        } else {
            return null;
        }
    }

    public Map<String, Long> e() {
        return this.f;
    }

    @Override // com.taobao.rxm.produce.ProducerListener
    /* renamed from: f */
    public void onEnterIn(com.taobao.phenix.request.a aVar, Class cls, boolean z, boolean z2) {
        a d;
        String str;
        if ((z && !z2) || (d = d(cls, z)) == null || (str = d.a) == null) {
            return;
        }
        this.f.put(str, Long.valueOf(0 - System.currentTimeMillis()));
        ImageDecodingListener imageDecodingListener = this.b;
        if (imageDecodingListener == null || cls != com.taobao.phenix.decode.a.class) {
            return;
        }
        imageDecodingListener.onDecodeStart(aVar.d(), aVar.N());
    }

    @Override // com.taobao.rxm.produce.ProducerListener
    /* renamed from: g */
    public void onExitOut(com.taobao.phenix.request.a aVar, Class cls, boolean z, boolean z2, boolean z3) {
        a d;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        c(cls, z, z2);
        if ((z && !z3) || (d = d(cls, z)) == null || (str = d.a) == null) {
            return;
        }
        Long l = this.f.get(str);
        if (l != null && l.longValue() < 0) {
            this.f.put(d.a, Long.valueOf(currentTimeMillis + l.longValue()));
        }
        if (z2 && d.b != ImageStatistics.FromType.FROM_UNKNOWN) {
            this.c.U().b(d.b);
        }
        ImageDecodingListener imageDecodingListener = this.b;
        if (imageDecodingListener == null || cls != com.taobao.phenix.decode.a.class) {
            return;
        }
        imageDecodingListener.onDecodeFinish(aVar.d(), aVar.N());
    }

    public void h(Scheduler scheduler) {
        this.e = scheduler;
    }
}
