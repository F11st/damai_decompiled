package com.xiaomi.push.service;

import com.xiaomi.push.service.bx;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class by implements Runnable {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        try {
            concurrentHashMap = this.a.f950a;
            for (bx.a aVar : concurrentHashMap.values()) {
                aVar.run();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("Sync job exception :" + e.getMessage());
        }
        this.a.f951a = false;
    }
}
