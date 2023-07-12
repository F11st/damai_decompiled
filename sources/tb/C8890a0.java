package tb;

import com.taobao.monitor.performance.IApmAdapterFactory;
import com.taobao.monitor.performance.IWXApmAdapter;

/* compiled from: Taobao */
/* renamed from: tb.a0 */
/* loaded from: classes11.dex */
public class C8890a0 implements IApmAdapterFactory {
    private static final C8890a0 b = new C8890a0();
    private IApmAdapterFactory a = new f50();

    private C8890a0() {
    }

    public static C8890a0 a() {
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
