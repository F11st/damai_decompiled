package com.taobao.monitor.impl.data.block;

import com.taobao.application.common.C6673b;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.impl.C6674a;
import java.util.HashMap;
import org.json.JSONObject;
import tb.a80;
import tb.e30;
import tb.m3;
import tb.yc;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BlockWatcher$1 implements Runnable {
    final /* synthetic */ yc this$0;
    final /* synthetic */ long val$blockTime;
    final /* synthetic */ int val$gc;
    final /* synthetic */ StringBuilder val$sb;

    BlockWatcher$1(yc ycVar, long j, StringBuilder sb, int i) {
        this.val$blockTime = j;
        this.val$sb = sb;
        this.val$gc = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        IAppPreferences d = C6673b.d();
        HashMap hashMap = new HashMap();
        hashMap.put("blockTime", Long.valueOf(this.val$blockTime));
        hashMap.put("mainThreadStackTrace", this.val$sb.toString());
        hashMap.put("topActivity", m3.b(C6674a.g().getTopActivity()));
        hashMap.put("deviceLevel", Integer.valueOf(d.getInt("deviceLevel", -1)));
        hashMap.put("gcCount", Integer.valueOf(this.val$gc));
        hashMap.put("activeThread", Integer.valueOf(Thread.activeCount()));
        hashMap.put("runtimeInfo", a80.a().b("Block").toString());
        e30.a("BlockWatcher", new JSONObject(hashMap));
    }
}
