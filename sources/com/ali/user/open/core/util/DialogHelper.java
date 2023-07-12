package com.ali.user.open.core.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.ali.user.open.core.R;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.webview.AUProgressDialog;
import com.ali.user.open.core.webview.BaseWebViewActivity;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DialogHelper {
    private static volatile DialogHelper instance;
    private AlertDialog mAlertDialog;
    private AlertDialog mProgressDialog;

    public static DialogHelper getInstance() {
        if (instance == null) {
            synchronized (DialogHelper.class) {
                if (instance == null) {
                    instance = new DialogHelper();
                }
            }
        }
        return instance;
    }

    public void alert(final Activity activity, final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2) {
        if (activity == null) {
            return;
        }
        dismissAlertDialog(activity);
        activity.runOnUiThread(new Runnable() { // from class: com.ali.user.open.core.util.DialogHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 == null || activity2.isFinishing()) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, Build.VERSION.SDK_INT >= 21 ? 16974393 : 16973939));
                if (!TextUtils.isEmpty(str)) {
                    builder.setTitle(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.setMessage(str2);
                } else {
                    builder.setMessage(activity.getString(R.string.member_sdk_network_not_available_message));
                }
                if (!TextUtils.isEmpty(str3)) {
                    builder.setPositiveButton(str3, onClickListener);
                }
                if (!TextUtils.isEmpty(str4)) {
                    builder.setNegativeButton(str4, onClickListener2);
                }
                builder.setCancelable(false);
                try {
                    DialogHelper.this.mAlertDialog = builder.show();
                    DialogHelper.this.mAlertDialog.getButton(-1).setTextColor(activity.getResources().getColor(17170444));
                    DialogHelper.this.mAlertDialog.getButton(-2).setTextColor(activity.getResources().getColor(17170444));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void dismissAlertDialog(Activity activity) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.ali.user.open.core.util.DialogHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mAlertDialog == null || !DialogHelper.this.mAlertDialog.isShowing()) {
                    return;
                }
                try {
                    DialogHelper.this.mAlertDialog.dismiss();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    DialogHelper.this.mAlertDialog = null;
                    throw th;
                }
                DialogHelper.this.mAlertDialog = null;
            }
        });
    }

    public void dismissProgressDialog(Activity activity) {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.ali.user.open.core.util.DialogHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mProgressDialog == null || !DialogHelper.this.mProgressDialog.isShowing()) {
                    return;
                }
                try {
                    try {
                        DialogHelper.this.mProgressDialog.dismiss();
                    } catch (Exception unused) {
                        SDKLogger.w(BaseWebViewActivity.TAG, "dismissProgressDialog");
                    }
                } finally {
                    DialogHelper.this.mProgressDialog = null;
                }
            }
        });
    }

    public void showProgressDialog(final Activity activity, final String str, final boolean z, final DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialog = this.mProgressDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            activity.runOnUiThread(new Runnable() { // from class: com.ali.user.open.core.util.DialogHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    if (activity2 == null || activity2.isFinishing()) {
                        return;
                    }
                    DialogHelper.this.mProgressDialog = new AUProgressDialog(activity);
                    DialogHelper.this.mProgressDialog.setMessage(str);
                    ((AUProgressDialog) DialogHelper.this.mProgressDialog).setProgressVisiable(true);
                    DialogHelper.this.mProgressDialog.setCancelable(z);
                    DialogHelper.this.mProgressDialog.setOnCancelListener(onCancelListener);
                    try {
                        DialogHelper.this.mProgressDialog.show();
                    } catch (Exception unused) {
                    }
                    DialogHelper.this.mProgressDialog.setCanceledOnTouchOutside(false);
                }
            });
        }
    }
}
