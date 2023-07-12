package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ca {

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ca$a */
    /* loaded from: classes10.dex */
    public enum EnumC4496a {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        
        private int f;

        EnumC4496a(int i) {
            this.f = i;
        }
    }

    void a(long j, long j2);

    void a(EnumC4496a enumC4496a);

    void n();

    void o();

    void p();
}
