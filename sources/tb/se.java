package tb;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.taobao.phenix.builder.Builder;
import com.taobao.tcommon.core.BytesPool;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class se implements Builder<BytesPool> {
    private BytesPool a;
    private Integer b;
    private boolean c;
    private ComponentCallbacks2 d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.se$a */
    /* loaded from: classes11.dex */
    public class ComponentCallbacks2C9691a implements ComponentCallbacks2 {
        final /* synthetic */ BytesPool a;

        ComponentCallbacks2C9691a(BytesPool bytesPool) {
            this.a = bytesPool;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            xt2.a("BytesPool", "ComponentCallbacks2 onTrimMemory, level=%d", Integer.valueOf(i));
            if (i >= 60) {
                this.a.clear();
                xt2.i("BytesPool", "clear all at TRIM_MEMORY_MODERATE", new Object[0]);
            }
        }
    }

    private BytesPool b(BytesPool bytesPool) {
        Context applicationContext = ur1.o().applicationContext();
        if (applicationContext != null && Build.VERSION.SDK_INT >= 14) {
            ComponentCallbacks2C9691a componentCallbacks2C9691a = new ComponentCallbacks2C9691a(bytesPool);
            this.d = componentCallbacks2C9691a;
            applicationContext.registerComponentCallbacks(componentCallbacks2C9691a);
        }
        return bytesPool;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: a */
    public synchronized BytesPool build() {
        if (this.c) {
            return this.a;
        }
        this.c = true;
        BytesPool bytesPool = this.a;
        if (bytesPool == null) {
            Integer num = this.b;
            this.a = new i91(num != null ? num.intValue() : 1048576);
        } else {
            Integer num2 = this.b;
            if (num2 != null) {
                bytesPool.resize(num2.intValue());
            }
        }
        return b(this.a);
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: c */
    public se with(BytesPool bytesPool) {
        cu1.e(!this.c, "BytesPoolBuilder has been built, not allow with() now");
        this.a = bytesPool;
        return this;
    }

    protected void finalize() {
        Context applicationContext;
        ComponentCallbacks2 componentCallbacks2;
        try {
            super.finalize();
            applicationContext = ur1.o().applicationContext();
            if (applicationContext == null || (componentCallbacks2 = this.d) == null) {
                return;
            }
        } catch (Throwable unused) {
            applicationContext = ur1.o().applicationContext();
            if (applicationContext == null || (componentCallbacks2 = this.d) == null) {
                return;
            }
        }
        applicationContext.unregisterComponentCallbacks(componentCallbacks2);
    }
}
