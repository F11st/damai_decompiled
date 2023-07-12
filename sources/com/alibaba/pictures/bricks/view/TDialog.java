package com.alibaba.pictures.bricks.view;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Timer;
import java.util.TimerTask;
import tb.f3;
import tb.h3;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogShowTimeListener a;
    public long b;
    public long c;
    private Application d;
    private Activity e;
    private boolean f;
    private f3 g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnDialogShowTimeListener {
        void exposureTime(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a extends f3 {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.f3
        public boolean a(Activity activity) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1023780606") ? ((Boolean) ipChange.ipc$dispatch("1023780606", new Object[]{this, activity})).booleanValue() : TDialog.this.e != null && TDialog.this.e == activity;
        }

        @Override // tb.f3, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1819778958")) {
                ipChange.ipc$dispatch("1819778958", new Object[]{this, activity});
            } else if (TDialog.this.f) {
                TDialog.this.c = System.currentTimeMillis();
                TDialog.this.d();
            }
        }

        @Override // tb.f3, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "190071227")) {
                ipChange.ipc$dispatch("190071227", new Object[]{this, activity});
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
        if (AndroidInstantRuntime.support(ipChange, "2059453450")) {
            ipChange.ipc$dispatch("2059453450", new Object[]{this});
            return;
        }
        OnDialogShowTimeListener onDialogShowTimeListener = this.a;
        if (onDialogShowTimeListener != null) {
            onDialogShowTimeListener.exposureTime(this.c - this.b);
        }
    }

    private void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1928860217")) {
            ipChange.ipc$dispatch("1928860217", new Object[]{this, context});
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.e = activity;
            Application application = activity.getApplication();
            this.d = application;
            if (application != null) {
                h3.d(application).b(this.g);
            }
        }
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55692316")) {
            ipChange.ipc$dispatch("-55692316", new Object[]{this});
            return;
        }
        Application application = this.d;
        if (application == null || this.g == null) {
            return;
        }
        h3.d(application).e(this.g);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594210325")) {
            ipChange.ipc$dispatch("1594210325", new Object[]{this});
            return;
        }
        this.f = false;
        this.c = System.currentTimeMillis();
        super.dismiss();
        d();
        f();
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159543224")) {
            ipChange.ipc$dispatch("159543224", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.alibaba.pictures.bricks.view.TDialog.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2074742054")) {
                    ipChange2.ipc$dispatch("2074742054", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-1308486711")) {
            ipChange.ipc$dispatch("-1308486711", new Object[]{this});
            return;
        }
        this.f = false;
        super.hide();
        d();
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-153814994")) {
            ipChange.ipc$dispatch("-153814994", new Object[]{this});
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
