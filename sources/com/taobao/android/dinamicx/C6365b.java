package com.taobao.android.dinamicx;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.b */
/* loaded from: classes12.dex */
public class C6365b {
    protected DXEngineConfig a;
    protected String b;
    protected C6367d c;

    public C6365b(@NonNull C6367d c6367d) {
        if (c6367d == null) {
            DXEngineConfig dXEngineConfig = new DXEngineConfig(DXEngineConfig.DX_DEFAULT_BIZTYPE);
            this.a = dXEngineConfig;
            this.b = dXEngineConfig.a;
            this.c = new C6367d(dXEngineConfig);
            return;
        }
        this.c = c6367d;
        DXEngineConfig dXEngineConfig2 = c6367d.a;
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
    public C6365b(@NonNull DXEngineConfig dXEngineConfig) {
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
