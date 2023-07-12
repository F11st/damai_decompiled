package cn.damai.uikit.util;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Timer;
import java.util.TimerTask;
import tb.g3;
import tb.i3;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogShowTimeListener a;
    public long b;
    public long c;
    private Application d;
    private Activity e;
    private boolean f;
    private g3 g;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a extends g3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.g3
        public boolean a(Activity activity) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-247403979") ? ((Boolean) ipChange.ipc$dispatch("-247403979", new Object[]{this, activity})).booleanValue() : TDialog.this.e != null && TDialog.this.e == activity;
        }

        @Override // tb.g3, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "974323639")) {
                ipChange.ipc$dispatch("974323639", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.c = System.currentTimeMillis();
                TDialog.this.d();
            }
        }

        @Override // tb.g3, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-249239886")) {
                ipChange.ipc$dispatch("-249239886", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.b = System.currentTimeMillis();
            }
        }
    }

    public TDialog(@NonNull Context context) {
        super(context);
        this.f = false;
        this.g = new a();
        e(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185886413")) {
            ipChange.ipc$dispatch("-1185886413", new Object[]{this});
            return;
        }
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(this.c - this.b);
        }
    }

    private void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1488113680")) {
            ipChange.ipc$dispatch("-1488113680", new Object[]{this, context});
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.e = activity;
            Application application = activity.getApplication();
            this.d = application;
            if (application != null) {
                i3.d(application).b(this.g);
            }
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823046733")) {
            ipChange.ipc$dispatch("1823046733", new Object[]{this});
            return;
        }
        Application application = this.d;
        if (application == null || this.g == null) {
            return;
        }
        i3.d(application).e(this.g);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687565620")) {
            ipChange.ipc$dispatch("-1687565620", new Object[]{this});
            return;
        }
        this.f = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        f();
    }

    public void g(OnDialogShowTimeListener onDialogShowTimeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692575178")) {
            ipChange.ipc$dispatch("-692575178", new Object[]{this, onDialogShowTimeListener});
        } else {
            this.a = onDialogShowTimeListener;
        }
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805999407")) {
            ipChange.ipc$dispatch("1805999407", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: cn.damai.uikit.util.TDialog.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1418813853")) {
                    ipChange2.ipc$dispatch("1418813853", new Object[]{this});
                    return;
                }
                TDialog.this.dismiss();
                timer.cancel();
            }
        }, i * 1000);
    }

    @Override // android.app.Dialog
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134037618")) {
            ipChange.ipc$dispatch("2134037618", new Object[]{this});
            return;
        }
        this.f = false;
        super.hide();
        d();
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006257961")) {
            ipChange.ipc$dispatch("-1006257961", new Object[]{this});
            return;
        }
        this.f = true;
        this.b = System.currentTimeMillis();
        super.show();
    }

    public TDialog(@NonNull Context context, int i) {
        super(context, i);
        this.f = false;
        this.g = new a();
        e(context);
    }
}
