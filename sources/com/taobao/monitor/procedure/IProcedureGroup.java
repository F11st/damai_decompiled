package com.taobao.monitor.procedure;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IProcedureGroup extends IProcedure {
    void addSubProcedure(IProcedure iProcedure);

    void removeSubProcedure(IProcedure iProcedure);
}
