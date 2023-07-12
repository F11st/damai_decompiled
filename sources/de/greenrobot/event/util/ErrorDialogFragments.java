package de.greenrobot.event.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ErrorDialogFragments {
    public static int a;
    public static Class<?> b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class Support extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.b(dialogInterface, i, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(ErrorDialogManager.KEY_MESSAGE));
        int i = a;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void b(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        Class<?> cls = b;
        if (cls == null) {
            if (!bundle.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) || activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        try {
            cls.newInstance();
            throw null;
        } catch (Exception e) {
            throw new RuntimeException("Event cannot be constructed", e);
        }
    }
}
