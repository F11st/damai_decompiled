package tb;

import com.taobao.update.datasource.logger.Log;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xd0 extends be0 {
    private Log b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static xd0 a = new xd0();
    }

    public static xd0 INSTANCE() {
        return b.a;
    }

    @Override // tb.be0
    public String apiName() {
        return "mtop.alibaba.emas.publish.update.get";
    }

    @Override // tb.be0
    public String biz() {
        return lu2.MAIN;
    }

    @Override // tb.be0
    public String requestVersion() {
        return pu2.getVersionName();
    }

    private xd0() {
        this.b = ub1.getLog(xd0.class, (Log) null);
        new ArrayList();
    }
}
