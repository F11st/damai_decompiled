package tb;

import com.taobao.monitor.performance.IApmAdapterFactory;
import com.taobao.monitor.performance.IWXApmAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a0 implements IApmAdapterFactory {
    private static final a0 b = new a0();
    private IApmAdapterFactory a = new f50();

    private a0() {
    }

    public static a0 a() {
        return b;
    }

    public void b(IApmAdapterFactory iApmAdapterFactory) {
        this.a = iApmAdapterFactory;
    }

    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapter() {
        return this.a.createApmAdapter();
    }

    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapterByType(String str) {
        return this.a.createApmAdapterByType(str);
    }
}
