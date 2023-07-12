package tb;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.phenix.compat.stat.NavigationInfoObtainer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aj1 implements Application.ActivityLifecycleCallbacks, NavigationInfoObtainer {
    private static final aj1 c = new aj1();
    private String a;
    private String b;

    public static aj1 a() {
        return c;
    }

    @Override // com.taobao.phenix.compat.stat.NavigationInfoObtainer
    public String getCurrentUrl() {
        return this.b;
    }

    @Override // com.taobao.phenix.compat.stat.NavigationInfoObtainer
    public String getCurrentWindowName() {
        return this.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.a = activity.getLocalClassName();
            Intent intent = activity.getIntent();
            if (intent != null) {
                this.b = intent.getDataString();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
