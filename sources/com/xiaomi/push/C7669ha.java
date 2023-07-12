package com.xiaomi.push;

import com.xiaomi.push.ao;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.ha */
/* loaded from: classes11.dex */
final class C7669ha extends ao.AbstractC7600b {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7669ha(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.ao.AbstractC7600b
    public void b() {
        this.a.run();
    }
}
