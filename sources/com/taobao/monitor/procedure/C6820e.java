package com.taobao.monitor.procedure;

import com.taobao.monitor.network.C6807a;
import com.taobao.monitor.procedure.C6817d;
import tb.uu1;
import tb.xu1;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.e */
/* loaded from: classes11.dex */
public class C6820e implements IProcedureFactory {
    protected ProcedureImpl a(String str, C6817d c6817d) {
        IProcedure a = c6817d.a();
        if (a == IProcedure.DEFAULT) {
            a = uu1.PROCEDURE_MANAGER.getCurrentProcedure();
        }
        ProcedureImpl procedureImpl = new ProcedureImpl(str, a, c6817d.b(), c6817d.c());
        if (c6817d.e()) {
            procedureImpl.d(new C6807a());
        }
        if (c6817d.d()) {
            procedureImpl.d(new xu1());
        }
        return procedureImpl;
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str) {
        return createProcedure(str, new C6817d.C6819b().k(false).g(true).i(true).h(uu1.PROCEDURE_MANAGER.getCurrentProcedure()).f());
    }

    @Override // com.taobao.monitor.procedure.IProcedureFactory
    public IProcedure createProcedure(String str, C6817d c6817d) {
        if (c6817d == null) {
            c6817d = new C6817d.C6819b().k(false).g(true).i(true).h(uu1.PROCEDURE_MANAGER.getCurrentProcedure()).f();
        }
        return new ProcedureProxy(a(str, c6817d));
    }
}
