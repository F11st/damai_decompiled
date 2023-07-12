package cn.damai.login.havana;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.util.ToastUtil;
import com.ali.user.mobile.helper.IDialogHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.snackbar.Snackbar;
import tb.h4;
import tb.wu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class HavanaDialogHelper implements IDialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMDialog a;
    private DMProgressDialog b;

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void alert(Activity activity, String str, View view, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2, Boolean bool, DialogInterface.OnCancelListener onCancelListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874167909")) {
            ipChange.ipc$dispatch("1874167909", new Object[]{this, activity, str, view, str2, onClickListener, str3, onClickListener2, bool, onCancelListener});
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void alert(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243290181")) {
            ipChange.ipc$dispatch("-243290181", new Object[]{this, activity, str, str2, str3, onClickListener, str4, onClickListener2});
        } else {
            alert(activity, str, str2, str3, onClickListener, str4, onClickListener2, true, true, null);
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void dismissAlertDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579123903")) {
            ipChange.ipc$dispatch("579123903", new Object[]{this});
            return;
        }
        try {
            DMDialog dMDialog = this.a;
            if (dMDialog == null || !dMDialog.isShowing()) {
                return;
            }
            this.a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void dismissProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066660558")) {
            ipChange.ipc$dispatch("-2066660558", new Object[]{this});
            return;
        }
        try {
            DMProgressDialog dMProgressDialog = this.b;
            if (dMProgressDialog == null || !dMProgressDialog.isShowing()) {
                return;
            }
            this.b.dismiss();
            this.b = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void showProgressDialog(Activity activity, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715797809")) {
            ipChange.ipc$dispatch("1715797809", new Object[]{this, activity, str, Boolean.valueOf(z)});
        } else {
            showProgressDialog(activity, str, true, null, z);
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void snackBar(View view, String str, int i, String str2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948341716")) {
            ipChange.ipc$dispatch("948341716", new Object[]{this, view, str, Integer.valueOf(i), str2, onClickListener});
        } else {
            Snackbar.make(view, str, i).setAction(str2, onClickListener).show();
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void toast(Context context, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152239173")) {
            ipChange.ipc$dispatch("-1152239173", new Object[]{this, context, str, Integer.valueOf(i)});
        } else {
            ToastUtil.i(str);
        }
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void alert(final Activity activity, final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2, boolean z, final boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877347508")) {
            ipChange.ipc$dispatch("877347508", new Object[]{this, activity, str, str2, str3, onClickListener, str4, onClickListener2, Boolean.valueOf(z), Boolean.valueOf(z2), onCancelListener});
            return;
        }
        dismissAlertDialog();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: cn.damai.login.havana.HavanaDialogHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.login.havana.HavanaDialogHelper$1$a */
            /* loaded from: classes15.dex */
            public class a implements DialogInterface.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1993372235")) {
                        ipChange.ipc$dispatch("1993372235", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    DialogInterface.OnClickListener onClickListener = onClickListener2;
                    if (onClickListener != null) {
                        onClickListener.onClick(null, i);
                    }
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.login.havana.HavanaDialogHelper$1$b */
            /* loaded from: classes15.dex */
            public class b implements DialogInterface.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1332014038")) {
                        ipChange.ipc$dispatch("-1332014038", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                        return;
                    }
                    DialogInterface.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(null, i);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1593902393")) {
                    ipChange2.ipc$dispatch("1593902393", new Object[]{this});
                    return;
                }
                HavanaDialogHelper.this.a = new h4(activity).h(str3, new b()).f(str4, new a()).i((TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? "" : str).e(TextUtils.isEmpty(str2) ? str : str2).d(z2).j();
                Activity activity2 = activity;
                wu0.g(activity2, (activity2 == null || activity2.getWindow() == null) ? null : HavanaDialogHelper.this.a.getWindow().getDecorView());
            }
        });
    }

    @Override // com.ali.user.mobile.helper.IDialogHelper
    public void showProgressDialog(final Activity activity, String str, boolean z, DialogInterface.OnCancelListener onCancelListener, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72494890")) {
            ipChange.ipc$dispatch("72494890", new Object[]{this, activity, str, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2)});
        } else if (activity == null || activity.isFinishing()) {
        } else {
            activity.runOnUiThread(new Runnable() { // from class: cn.damai.login.havana.HavanaDialogHelper.2
                private static transient /* synthetic */ IpChange $ipChange;

                /* compiled from: Taobao */
                /* renamed from: cn.damai.login.havana.HavanaDialogHelper$2$a */
                /* loaded from: classes15.dex */
                public class a implements DialogInterface.OnDismissListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    a(AnonymousClass2 anonymousClass2) {
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-321815109")) {
                            ipChange.ipc$dispatch("-321815109", new Object[]{this, dialogInterface});
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1397388888")) {
                        ipChange2.ipc$dispatch("1397388888", new Object[]{this});
                        return;
                    }
                    HavanaDialogHelper.this.dismissProgressDialog();
                    if (HavanaDialogHelper.this.b == null) {
                        HavanaDialogHelper.this.b = new DMProgressDialog(activity).a();
                        HavanaDialogHelper.this.b.setOnDismissListener(new a(this));
                    }
                    Activity activity2 = activity;
                    wu0.g(activity2, (activity2 == null || activity2.getWindow() == null) ? null : HavanaDialogHelper.this.b.getWindow().getDecorView());
                    HavanaDialogHelper.this.b.show();
                }
            });
        }
    }
}
