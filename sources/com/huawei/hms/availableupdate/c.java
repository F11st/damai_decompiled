package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    public static final c b = new c();
    public static final Object c = new Object();
    public final List<Activity> a = new ArrayList(1);

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

    public void b(Activity activity) {
        synchronized (c) {
            this.a.remove(activity);
        }
    }
}
