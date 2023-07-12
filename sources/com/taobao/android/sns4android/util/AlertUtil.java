package com.taobao.android.sns4android.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ali.user.mobile.helper.IDialogHelper;
import com.taobao.android.sns4android.R;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AlertUtil {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.util.AlertUtil$a */
    /* loaded from: classes12.dex */
    static class DialogInterface$OnClickListenerC6627a implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC6627a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public static void alertConfirm(Context context, AlertModel alertModel, IDialogHelper iDialogHelper) {
        View inflate = LayoutInflater.from(context).inflate(R.C6590layout.aliuser_alert_confirm_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_content);
        if (!TextUtils.isEmpty(alertModel.title)) {
            textView.setText(alertModel.title);
        }
        String str = alertModel.content;
        if (str != null) {
            textView2.setText(str);
        }
        iDialogHelper.alert((Activity) context, "", inflate, context.getString(R.string.aliuser_i_know), new DialogInterface$OnClickListenerC6627a(), null, null, Boolean.FALSE, null);
    }
}
