package cn.wh.auth.server;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ResultRequestService {
    private FragmentC2794a a;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface Callback {
        void onActivityResult(int i, int i2, Intent intent);
    }

    public ResultRequestService(Activity activity) {
        this.a = b(activity);
    }

    private FragmentC2794a a(FragmentManager fragmentManager) {
        return (FragmentC2794a) fragmentManager.findFragmentByTag(FragmentC2794a.TAG);
    }

    private FragmentC2794a b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentC2794a a = a(fragmentManager);
        if (a == null) {
            FragmentC2794a fragmentC2794a = new FragmentC2794a();
            fragmentManager.beginTransaction().add(fragmentC2794a, FragmentC2794a.TAG).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return fragmentC2794a;
        }
        return a;
    }

    public void c(Intent intent, Callback callback) {
        this.a.a(intent, callback);
    }
}
