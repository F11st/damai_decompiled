package com.ali.user.mobile.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface IDialogHelper {
    void alert(Activity activity, String str, View view, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2, Boolean bool, DialogInterface.OnCancelListener onCancelListener);

    void alert(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2);

    void alert(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener);

    void dismissAlertDialog();

    void dismissProgressDialog();

    void showProgressDialog(Activity activity, String str, boolean z);

    void showProgressDialog(Activity activity, String str, boolean z, DialogInterface.OnCancelListener onCancelListener, boolean z2);

    void snackBar(View view, String str, int i, String str2, View.OnClickListener onClickListener);

    void toast(Context context, String str, int i);
}
