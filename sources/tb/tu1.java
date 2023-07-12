package tb;

import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.IProcedureFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tu1 implements IProcedureFactory {
    public static tu1 b = new tu1();
    private IProcedureFactory a;

    private tu1() {
    }

    public tu1 a(IProcedureFactory iProcedureFactory) {
        this.a = iProcedureFactory;
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str) {
        IProcedureFactory iProcedureFactory = this.a;
        if (iProcedureFactory == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureFactory.createProcedure(str);
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str, com.taobao.monitor.procedure.d dVar) {
        IProcedureFactory iProcedureFactory = this.a;
        if (iProcedureFactory == null) {
            return IProcedure.DEFAULT;
        }
        return iProcedureFactory.createProcedure(str, dVar);
    }
}
