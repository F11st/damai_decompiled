package com.alibaba.pictures.share.common.ui.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.alibaba.pictures.share.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class DialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private AlertDialog a;
    @NotNull
    private final Activity b;

    public DialogHelper(@NotNull Activity activity) {
        b41.i(activity, "activity");
        this.b = activity;
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119565433")) {
            ipChange.ipc$dispatch("119565433", new Object[]{this});
        } else {
            this.b.runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.common.ui.dialog.DialogHelper$dismissProgressDialog$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    AlertDialog alertDialog;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-362456827")) {
                        ipChange2.ipc$dispatch("-362456827", new Object[]{this});
                        return;
                    }
                    alertDialog = DialogHelper.this.a;
                    if (alertDialog == null || !alertDialog.isShowing() || DialogHelper.this.d().isFinishing()) {
                        return;
                    }
                    alertDialog.dismiss();
                }
            });
        }
    }

    @NotNull
    public final Activity d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-809070699") ? (Activity) ipChange.ipc$dispatch("-809070699", new Object[]{this}) : this.b;
    }

    public final void e(@Nullable CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210437412")) {
            ipChange.ipc$dispatch("1210437412", new Object[]{this, charSequence});
        } else {
            f(charSequence, false, null, true);
        }
    }

    public final void f(@Nullable CharSequence charSequence, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962879947")) {
            ipChange.ipc$dispatch("1962879947", new Object[]{this, charSequence, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2)});
        } else {
            g(charSequence, z, onCancelListener, z2, null);
        }
    }

    public final void g(@Nullable final CharSequence charSequence, final boolean z, @Nullable final DialogInterface.OnCancelListener onCancelListener, final boolean z2, @Nullable final DialogInterface.OnKeyListener onKeyListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358146133")) {
            ipChange.ipc$dispatch("-1358146133", new Object[]{this, charSequence, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2), onKeyListener});
            return;
        }
        c();
        this.b.runOnUiThread(new Runnable() { // from class: com.alibaba.pictures.share.common.ui.dialog.DialogHelper$showProgressDialog$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public final void run() {
                AlertDialog alertDialog;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1876905659")) {
                    ipChange2.ipc$dispatch("1876905659", new Object[]{this});
                } else if (DialogHelper.this.d().isFinishing()) {
                } else {
                    DialogHelper dialogHelper = DialogHelper.this;
                    GenericProgressDialog genericProgressDialog = new GenericProgressDialog(DialogHelper.this.d(), R$style.loading_style);
                    alertDialog = DialogHelper.this.a;
                    if (alertDialog != null) {
                        alertDialog.setMessage(charSequence);
                    }
                    genericProgressDialog.c(z2);
                    genericProgressDialog.setCancelable(z);
                    genericProgressDialog.setOnCancelListener(onCancelListener);
                    DialogInterface.OnKeyListener onKeyListener2 = onKeyListener;
                    if (onKeyListener2 != null) {
                        genericProgressDialog.setOnKeyListener(onKeyListener2);
                    }
                    genericProgressDialog.setCanceledOnTouchOutside(false);
                    genericProgressDialog.show();
                    wt2 wt2Var = wt2.INSTANCE;
                    dialogHelper.a = genericProgressDialog;
                }
            }
        });
    }
}
