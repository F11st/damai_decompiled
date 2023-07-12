package tb;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import cn.damai.launcher.splash.GuideActivity;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.update.adapter.UIConfirm;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.dialog.CustomDialog;
import com.taobao.update.dialog.Dialog;
import com.taobao.update.framework.UpdateRuntime;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qr2 implements UIConfirm {
    public static boolean sClickbg2Exit;
    private boolean a;
    private boolean b;
    private boolean c;

    /* compiled from: Taobao */
    /* renamed from: tb.qr2$a */
    /* loaded from: classes11.dex */
    class C9616a implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ String a;
        final /* synthetic */ UserAction b;

        C9616a(String str, UserAction userAction) {
            this.a = str;
            this.b = userAction;
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
            Log.e("UIConfirmImpl", "alertForConfirm " + activity.getComponentName().getClassName() + "onresume!");
            if (C9444mm.blackDialogActivity.contains(activity.getClass().getName())) {
                return;
            }
            UpdateRuntime.getContext().unregisterActivityLifecycleCallbacks(this);
            qr2.this.c(activity, this.a, this.b);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.qr2$b */
    /* loaded from: classes11.dex */
    public class View$OnClickListenerC9617b implements View.OnClickListener {
        final /* synthetic */ UserAction a;

        View$OnClickListenerC9617b(qr2 qr2Var, UserAction userAction) {
            this.a = userAction;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.onConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.qr2$c */
    /* loaded from: classes11.dex */
    public class View$OnClickListenerC9618c implements View.OnClickListener {
        final /* synthetic */ UserAction a;

        View$OnClickListenerC9618c(qr2 qr2Var, UserAction userAction) {
            this.a = userAction;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.qr2$d */
    /* loaded from: classes11.dex */
    public class DialogInterface$OnClickListenerC9619d implements DialogInterface.OnClickListener {
        final /* synthetic */ UserAction a;

        DialogInterface$OnClickListenerC9619d(qr2 qr2Var, UserAction userAction) {
            this.a = userAction;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.onConfirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.qr2$e */
    /* loaded from: classes11.dex */
    public class DialogInterface$OnClickListenerC9620e implements DialogInterface.OnClickListener {
        final /* synthetic */ UserAction a;

        DialogInterface$OnClickListenerC9620e(qr2 qr2Var, UserAction userAction) {
            this.a = userAction;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.onCancel();
        }
    }

    public qr2() {
        this.c = false;
        this.a = sClickbg2Exit;
    }

    private String b(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity, String str, UserAction userAction) {
        CustomDialog customDialog;
        try {
            if (!this.b && this.c) {
                customDialog = new CustomDialog.C6927b(activity).setTitle("手机淘宝新版本更新啦,诚邀\n        你抢先体验!").setMessage(str).setNegativeButton(new DialogInterface$OnClickListenerC9620e(this, userAction)).setPositiveButton("立即参与", new DialogInterface$OnClickListenerC9619d(this, userAction)).create();
                customDialog.show();
            }
            Dialog dialog = new Dialog(activity, b(userAction.getTitleText(), PurchaseConstants.NORMAL_WARNING_TITLE), str, this.a);
            dialog.addAcceptButton(b(userAction.getConfirmText(), "同意"), new View$OnClickListenerC9617b(this, userAction));
            dialog.addCancelButton(b(userAction.getCancelText(), "拒绝"), new View$OnClickListenerC9618c(this, userAction));
            customDialog = dialog;
            customDialog.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.taobao.update.adapter.UIConfirm
    public void alertForConfirm(String str, UserAction userAction) {
        List<String> list;
        if (userAction.getConfirmText().equals("立即安装")) {
            this.b = true;
        }
        Log.e("UIConfirmImpl", "alertForConfirm" + UpdateRuntime.getContext());
        Activity peekTopActivity = l3.getInstance().peekTopActivity();
        if (peekTopActivity != null && !peekTopActivity.isFinishing() && !peekTopActivity.getClass().getName().contains(GuideActivity.TAG) && !peekTopActivity.getClass().getName().toLowerCase().contains("welcome") && ((list = C9444mm.blackDialogActivity) == null || !list.contains(peekTopActivity.getClass().getName()))) {
            c(peekTopActivity, str, userAction);
            return;
        }
        Log.e("UIConfirmImpl", peekTopActivity == null ? "null" : peekTopActivity.getClass().getName());
        UpdateRuntime.getContext().registerActivityLifecycleCallbacks(new C9616a(str, userAction));
    }

    public qr2(boolean z) {
        this.c = false;
        this.a = z;
    }
}
