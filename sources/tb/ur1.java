package tb;

import android.content.Context;
import com.taobao.phenix.builder.ChainBuilders;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.decode.EncodedDataInspector;
import com.taobao.phenix.loader.LocalSchemeHandler;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.strategy.ModuleStrategySupplier;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ur1 implements ChainBuilders {
    private static ur1 v;
    public static boolean w;
    private Context j;
    private boolean k;
    private ye n;
    private EncodedDataInspector o;
    private ImageFlowMonitor p;
    private ModuleStrategySupplier q;
    private boolean r;
    private List<LocalSchemeHandler> s;
    private ImageDecodingListener t;
    private boolean u = false;
    private boolean l = true;
    private boolean m = true;
    private final be1 a = new be1();
    private final qc b = new qc();
    private final u90 c = new u90();
    private final se d = new se();
    private final li0 e = new li0();
    private final i01 f = new i01();
    private final f62 g = new f62();
    private final il1 i = new il1(this);
    private final v90 h = new v90();

    private ur1() {
    }

    private dh1 l(String str) {
        ModuleStrategySupplier moduleStrategySupplier = this.q;
        if (moduleStrategySupplier != null) {
            return moduleStrategySupplier.get(str);
        }
        return null;
    }

    public static synchronized ur1 o() {
        ur1 ur1Var;
        synchronized (ur1.class) {
            if (v == null) {
                v = new ur1();
            }
            ur1Var = v;
        }
        return ur1Var;
    }

    public qc a() {
        return this.b;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public Context applicationContext() {
        return this.j;
    }

    public synchronized void b() {
        cu1.d(this.j, "Phenix.with(Context) hasn't been called before chain producer building");
        this.i.a();
        this.k = true;
        xt2.f("Initialize", "Phenix chain producer build complete", new Object[0]);
    }

    public se c() {
        return this.d;
    }

    @Deprecated
    public void d(ds1 ds1Var) {
        if (ds1Var != null) {
            ds1Var.cancel();
        }
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public u90 diskCacheBuilder() {
        return this.c;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public v90 diskCacheKVBuilder() {
        return this.h;
    }

    public void e() {
        if (this.k) {
            this.a.build().clear();
            for (DiskCache diskCache : this.c.build().getAll()) {
                if (diskCache.open(this.j)) {
                    diskCache.clear();
                }
            }
            xt2.i("UserAction", "clear all phenix cache", new Object[0]);
        }
    }

    public p22 f(String str, String str2, int i, boolean z) {
        String D;
        int C;
        cu1.b(!h42.b(), "fetchDiskCache must be called in non-main thread");
        p22 p22Var = null;
        if (this.k) {
            if (z) {
                D = str2;
                C = i;
            } else {
                com.taobao.phenix.request.a aVar = new com.taobao.phenix.request.a(str2, this.n, this.r);
                if (aVar.G().n()) {
                    return null;
                }
                D = aVar.D();
                C = aVar.C();
            }
            l(str);
            DiskCache diskCache = diskCacheBuilder().build().get(17);
            if (diskCache != null && diskCache.open(this.j)) {
                p22Var = diskCache.get(D, C);
            }
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(p22Var != null);
            xt2.l("UserAction", str2, "fetch disk cache, module=%s, catalog=%d, direct=%b, result=%B", objArr);
            return p22Var;
        }
        return null;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public li0 fileLoaderBuilder() {
        return this.e;
    }

    ye g() {
        return this.n;
    }

    public EncodedDataInspector h() {
        return this.o;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public i01 httpLoaderBuilder() {
        return this.f;
    }

    public List<LocalSchemeHandler> i() {
        return this.s;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public boolean isGenericTypeCheckEnabled() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageDecodingListener j() {
        return this.t;
    }

    public ImageFlowMonitor k() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public il1 m() {
        return this.i;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public be1 memCacheBuilder() {
        return this.a;
    }

    public SchedulerSupplier n() {
        return this.i.c();
    }

    public boolean p() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.m;
    }

    public wr1 s(String str) {
        return u(null, str, o().g());
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public f62 schedulerBuilder() {
        return this.g;
    }

    public wr1 t(String str, String str2) {
        return u(str, str2, o().g());
    }

    public wr1 u(String str, String str2, ye yeVar) {
        return new wr1(l(str), str2, yeVar);
    }

    public wr1 v(String str, ye yeVar) {
        return u(null, str, yeVar);
    }

    public boolean w(LocalSchemeHandler localSchemeHandler) {
        synchronized (this) {
            if (this.s == null) {
                this.s = new CopyOnWriteArrayList();
            }
        }
        return this.s.add(localSchemeHandler);
    }

    public void x(ImageDecodingListener imageDecodingListener) {
        this.t = imageDecodingListener;
    }

    public void y(ImageFlowMonitor imageFlowMonitor) {
        this.p = imageFlowMonitor;
        xt2.f("Initialize", "setup image flow monitor=%s", imageFlowMonitor);
    }

    public synchronized ur1 z(Context context) {
        cu1.d(context, "Phenix with context must not be null.");
        if (this.j == null) {
            this.j = context.getApplicationContext();
        }
        return this;
    }
}
