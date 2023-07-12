package com.taobao.android.dinamicx;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    protected DXEngineConfig a;
    protected String b;
    protected d c;

    public b(@NonNull d dVar) {
        if (dVar == null) {
            DXEngineConfig dXEngineConfig = new DXEngineConfig(DXEngineConfig.DX_DEFAULT_BIZTYPE);
            this.a = dXEngineConfig;
            this.b = dXEngineConfig.a;
            this.c = new d(dXEngineConfig);
            return;
        }
        this.c = dVar;
        DXEngineConfig dXEngineConfig2 = dVar.a;
        this.a = dXEngineConfig2;
        this.b = dXEngineConfig2.a;
    }

    public String a() {
        return this.b;
    }

    public DXEngineConfig b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull DXEngineConfig dXEngineConfig) {
        if (dXEngineConfig == null) {
            DXEngineConfig dXEngineConfig2 = new DXEngineConfig(DXEngineConfig.DX_DEFAULT_BIZTYPE);
            this.a = dXEngineConfig2;
            this.b = dXEngineConfig2.a;
            return;
        }
        this.a = dXEngineConfig;
        this.b = dXEngineConfig.a;
    }
}
