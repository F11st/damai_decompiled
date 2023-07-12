package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.loader.network.C6862a;
import com.taobao.phenix.loader.network.HttpLoader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i01 implements Builder<HttpLoader> {
    public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    public static final int DEFAULT_READ_TIMEOUT = 10000;
    private boolean a;
    private HttpLoader b;
    private Integer c;
    private Integer d;

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: a */
    public synchronized HttpLoader build() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        if (this.b == null) {
            this.b = new C6862a();
        }
        HttpLoader httpLoader = this.b;
        Integer num = this.c;
        httpLoader.connectTimeout(num != null ? num.intValue() : 15000);
        HttpLoader httpLoader2 = this.b;
        Integer num2 = this.d;
        httpLoader2.readTimeout(num2 != null ? num2.intValue() : 10000);
        return this.b;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: b */
    public i01 with(HttpLoader httpLoader) {
        cu1.e(!this.a, "HttpLoaderBuilder has been built, not allow with() now");
        this.b = httpLoader;
        return this;
    }
}
