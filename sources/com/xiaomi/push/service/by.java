package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
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
            for (bx.AbstractRunnableC7746a abstractRunnableC7746a : concurrentHashMap.values()) {
                abstractRunnableC7746a.run();
            }
        } catch (Exception e) {
            AbstractC7535b.m586a("Sync job exception :" + e.getMessage());
        }
        this.a.f951a = false;
    }
}
