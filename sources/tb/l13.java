package tb;

import com.taobao.monitor.performance.IApmAdapterFactory;
import com.taobao.monitor.performance.IWXApmAdapter;
import com.taobao.weex.performance.WXInstanceApm;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l13 implements IApmAdapterFactory {
    private IWXApmAdapter a = new a(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements IWXApmAdapter {
        a(l13 l13Var) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBiz(String str, Map<String, Object> map) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBizAbTest(String str, Map<String, Object> map) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBizStage(String str, Map<String, Object> map) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addProperty(String str, Object obj) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addStatistic(String str, double d) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onEnd() {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onEvent(String str, Object obj) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStage(String str, long j) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStart() {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStart(String str) {
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStop() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements IWXApmAdapter {
        private final IWXApmAdapter a;

        /* synthetic */ b(IWXApmAdapter iWXApmAdapter, a aVar) {
            this(iWXApmAdapter);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBiz(String str, Map<String, Object> map) {
            this.a.addBiz(str, map);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBizAbTest(String str, Map<String, Object> map) {
            this.a.addBizAbTest(str, map);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addBizStage(String str, Map<String, Object> map) {
            this.a.addBizStage(str, map);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addProperty(String str, Object obj) {
            this.a.addProperty(str, obj);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void addStatistic(String str, double d) {
            this.a.addStatistic(str, d);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onEnd() {
            this.a.onEnd();
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onEvent(String str, Object obj) {
            this.a.onEvent(str, obj);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStage(String str, long j) {
            this.a.onStage(str, j);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStart(String str) {
            this.a.onStart(str);
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStop() {
            this.a.onStop();
        }

        private b(IWXApmAdapter iWXApmAdapter) {
            this.a = iWXApmAdapter;
        }

        @Override // com.taobao.monitor.performance.IWXApmAdapter
        public void onStart() {
            this.a.onStart();
        }
    }

    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapter() {
        return createApmAdapterByType(WXInstanceApm.WEEX_PAGE_TOPIC);
    }

    @Override // com.taobao.monitor.performance.IApmAdapterFactory
    public IWXApmAdapter createApmAdapterByType(String str) {
        return new b(jd0.f ? new n13(str) : this.a, null);
    }
}
