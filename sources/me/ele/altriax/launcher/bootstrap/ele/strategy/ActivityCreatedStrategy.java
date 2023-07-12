package me.ele.altriax.launcher.bootstrap.ele.strategy;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ActivityCreatedStrategy implements Strategy {
    private ActivityCreatedListener activityCreatedListener;
    private List<String> whiteList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ActivityCreatedListener {
        void onBaseActivityCreated(@NonNull Activity activity);

        void onWebActivityCreated(@NonNull Activity activity);
    }

    @Override // me.ele.altriax.launcher.bootstrap.ele.strategy.Strategy
    public void activity(@NonNull Activity activity, @NonNull String str, @NonNull Bundle bundle) {
        if (ExternalLink.getBaseBlackList().contains(str)) {
            return;
        }
        if (ExternalLink.getBaseWhiteList().contains(str) && !this.whiteList.contains(str)) {
            ActivityCreatedListener activityCreatedListener = this.activityCreatedListener;
            if (activityCreatedListener != null) {
                activityCreatedListener.onBaseActivityCreated(activity);
            }
            this.whiteList.add(str);
        }
        if (!ExternalLink.getWebWhiteList().contains(str) || this.whiteList.contains(str)) {
            return;
        }
        ActivityCreatedListener activityCreatedListener2 = this.activityCreatedListener;
        if (activityCreatedListener2 != null) {
            activityCreatedListener2.onWebActivityCreated(activity);
        }
        this.whiteList.add(str);
    }

    public void setActivityCreatedListener(@NonNull ActivityCreatedListener activityCreatedListener) {
        this.activityCreatedListener = activityCreatedListener;
    }
}
