package tb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l3 {
    private static l3 b;
    private List<WeakReference<Activity>> a = new ArrayList();

    private l3() {
    }

    public static synchronized l3 getInstance() {
        l3 l3Var;
        synchronized (l3.class) {
            if (b == null) {
                b = new l3();
            }
            l3Var = b;
        }
        return l3Var;
    }

    public void clearActivityStack() {
        try {
            for (WeakReference<Activity> weakReference : this.a) {
                if (weakReference != null && weakReference.get() != null && !weakReference.get().isFinishing()) {
                    weakReference.get().finish();
                }
            }
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    public void handleActivityStack(String str, Intent intent, int i, int i2) {
        String str2;
        if (this.a.size() > 0) {
            List<WeakReference<Activity>> list = this.a;
            str2 = list.get(list.size() - 1).get().getClass().getName();
        } else {
            str2 = null;
        }
        if (TextUtils.equals(str2, str) && (i2 == 1 || (i & 536870912) == 536870912)) {
            intent.addFlags(536870912);
        } else if (i2 == 2 || i2 == 3 || (i & ConfigReporter.BIT_GETTER_IMP) == 67108864) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= this.a.size()) {
                    break;
                }
                WeakReference<Activity> weakReference = this.a.get(i3);
                if (weakReference != null && weakReference.get() != null && weakReference.get().getClass().getName().equals(str)) {
                    z = true;
                    break;
                }
                i3++;
            }
            if (z) {
                List<WeakReference<Activity>> list2 = this.a;
                int i4 = i3 + 1;
                for (WeakReference<Activity> weakReference2 : list2.subList(i4, list2.size())) {
                    if (weakReference2 != null && weakReference2.get() != null) {
                        weakReference2.get().finish();
                    }
                }
                List<WeakReference<Activity>> list3 = this.a;
                list3.subList(i4, list3.size()).clear();
                intent.addFlags(536870912);
            }
        }
    }

    public boolean isActivityStackEmpty() {
        return this.a.size() == 0;
    }

    public Activity peekTopActivity() {
        List<WeakReference<Activity>> list = this.a;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<WeakReference<Activity>> list2 = this.a;
        WeakReference<Activity> weakReference = list2.get(list2.size() - 1);
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }

    public void popFromActivityStack(Activity activity) {
        for (int i = 0; i < this.a.size(); i++) {
            WeakReference<Activity> weakReference = this.a.get(i);
            if (weakReference != null && weakReference.get() != null && weakReference.get() == activity) {
                this.a.remove(weakReference);
            }
        }
    }

    public void pushToActivityStack(Activity activity) {
        this.a.add(new WeakReference<>(activity));
    }

    public int sizeOfActivityStack() {
        return this.a.size();
    }
}
