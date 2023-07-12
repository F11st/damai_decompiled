package tb;

import android.content.Context;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.taobao.phenix.compat.stat.NonCriticalErrorReporter;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zj2 implements NonCriticalErrorReporter {
    private final Context a;
    private final BizErrorReporter b = BizErrorReporter.getInstance();

    public zj2(Context context) {
        this.a = context;
    }

    @Override // com.taobao.phenix.compat.stat.NonCriticalErrorReporter
    public void onNonCriticalErrorHappen(String str, Throwable th, Map<String, Object> map) {
        if (th == null) {
            return;
        }
        try {
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            bizErrorModule.businessType = "IMAGE_ERROR";
            bizErrorModule.exceptionCode = str;
            bizErrorModule.exceptionArgs = map;
            bizErrorModule.throwable = th;
            this.b.send(this.a, bizErrorModule);
        } catch (Exception unused) {
            xt2.c("TBNonCriticalErrorReporter", "onNonCriticalErrorHappen error", new Object[0]);
        }
    }
}
