package com.alipay.sdk.m.x;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.u.C4302e;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.x.b */
/* loaded from: classes10.dex */
public class C4342b {

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.x.b$a */
    /* loaded from: classes10.dex */
    public static class DialogInterface$OnKeyListenerC4343a implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    public static Dialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder a = a(context, str, str3, onClickListener, str4, onClickListener2);
        a.setTitle(str);
        a.setMessage(str2);
        AlertDialog create = a.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new DialogInterface$OnKeyListenerC4343a());
        try {
            create.show();
        } catch (Throwable th) {
            C4302e.a(C4230a.z, "showDialog ", th);
        }
        return create;
    }

    public static AlertDialog.Builder a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(str3) && onClickListener2 != null) {
            builder.setPositiveButton(str3, onClickListener2);
        }
        if (!TextUtils.isEmpty(str2) && onClickListener != null) {
            builder.setNegativeButton(str2, onClickListener);
        }
        return builder;
    }
}
