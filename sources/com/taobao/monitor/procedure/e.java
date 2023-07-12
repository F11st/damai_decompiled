package com.taobao.monitor.procedure;

import com.taobao.monitor.procedure.d;
import tb.uu1;
import tb.xu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e implements IProcedureFactory {
    protected ProcedureImpl a(String str, d dVar) {
        IProcedure a = dVar.a();
        if (a == IProcedure.DEFAULT) {
            a = uu1.PROCEDURE_MANAGER.getCurrentProcedure();
        }
        ProcedureImpl procedureImpl = new ProcedureImpl(str, a, dVar.b(), dVar.c());
        if (dVar.e()) {
            procedureImpl.d(new com.taobao.monitor.network.a());
        }
        if (dVar.d()) {
            procedureImpl.d(new xu1());
        }
        return procedureImpl;
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str) {
        return createProcedure(str, new d.b().k(false).g(true).i(true).h(uu1.PROCEDURE_MANAGER.getCurrentProcedure()).f());
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str, d dVar) {
        if (dVar == null) {
            dVar = new d.b().k(false).g(true).i(true).h(uu1.PROCEDURE_MANAGER.getCurrentProcedure()).f();
        }
        return new ProcedureProxy(a(str, dVar));
    }
}
