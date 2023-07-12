package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.api.a */
/* loaded from: classes10.dex */
class C5526a {
    static final C5526a b = new C5526a();
    private static final Object c = new Object();
    List<Activity> a = new ArrayList(1);

    C5526a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity) {
        synchronized (c) {
            this.a.remove(activity);
        }
    }
}
