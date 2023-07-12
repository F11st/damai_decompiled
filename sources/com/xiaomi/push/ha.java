package com.xiaomi.push;

import com.xiaomi.push.ao;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ha extends ao.b {
    final /* synthetic */ Runnable a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        this.a.run();
    }
}
