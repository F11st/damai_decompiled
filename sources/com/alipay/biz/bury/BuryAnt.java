package com.alipay.biz.bury;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BuryAnt {
    public long signature = System.currentTimeMillis();

    public void forceToDeath() {
        this.signature = -1L;
    }
}
