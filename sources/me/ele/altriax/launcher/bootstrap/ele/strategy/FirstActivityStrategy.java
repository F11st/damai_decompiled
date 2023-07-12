package me.ele.altriax.launcher.bootstrap.ele.strategy;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FirstActivityStrategy implements Strategy {
    private static FirstActivityCreatedBizListener firstActivityCreatedBizListener;
    private FirstActivityCreatedListener firstActivityCreatedListener;
    private List<String> firstActivityFilter = new ArrayList();
    private AtomicInteger firstActivity = new AtomicInteger(0);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface FirstActivityCreatedBizListener {
        void onFirstActivityCreated(@NonNull Activity activity, @NonNull Bundle bundle);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface FirstActivityCreatedListener {
        void onFirstActivityCreated(@NonNull Activity activity, @NonNull Bundle bundle);
    }

    public static void setFirstActivityCreatedBizListener(@NonNull FirstActivityCreatedBizListener firstActivityCreatedBizListener2) {
        firstActivityCreatedBizListener = firstActivityCreatedBizListener2;
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.strategy.Strategy
    public void activity(@NonNull Activity activity, @NonNull String str, @NonNull Bundle bundle) {
        if (this.firstActivity.compareAndSet(0, 1)) {
            if (this.firstActivityCreatedListener != null) {
                List<String> list = this.firstActivityFilter;
                if (list != null && list.size() > 0) {
                    for (String str2 : this.firstActivityFilter) {
                        if (!str.equals(str2)) {
                            this.firstActivityCreatedListener.onFirstActivityCreated(activity, bundle);
                        }
                    }
                } else {
                    this.firstActivityCreatedListener.onFirstActivityCreated(activity, bundle);
                }
            }
            FirstActivityCreatedBizListener firstActivityCreatedBizListener2 = firstActivityCreatedBizListener;
            if (firstActivityCreatedBizListener2 != null) {
                firstActivityCreatedBizListener2.onFirstActivityCreated(activity, bundle);
            }
        }
    }

    public void setFirstActivityCreatedListener(@NonNull FirstActivityCreatedListener firstActivityCreatedListener) {
        this.firstActivityCreatedListener = firstActivityCreatedListener;
    }

    public void setFirstActivityFilter(@NonNull List<String> list) {
        this.firstActivityFilter = list;
    }
}
