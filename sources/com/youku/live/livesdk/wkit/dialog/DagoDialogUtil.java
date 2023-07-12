package com.youku.live.livesdk.wkit.dialog;

import android.app.Activity;
import android.app.Dialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.dialog.DagoLiveDialog;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DagoDialogUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Dialog createDialog(Activity activity, DagoLiveDialog.DialogConfig dialogConfig) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1492952909") ? (Dialog) ipChange.ipc$dispatch("1492952909", new Object[]{activity, dialogConfig}) : new DagoLiveDialog(activity, dialogConfig);
    }

    public static void showDialog(Activity activity, String str, String str2, DagoLiveDialog.OnDialogButtonClickListener onDialogButtonClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042682962")) {
            ipChange.ipc$dispatch("-1042682962", new Object[]{activity, str, str2, onDialogButtonClickListener});
            return;
        }
        DagoLiveDialog.DialogConfig dialogConfig = new DagoLiveDialog.DialogConfig();
        dialogConfig.title = str;
        dialogConfig.content = str2;
        dialogConfig.onOkBtnClickListener = onDialogButtonClickListener;
        createDialog(activity, dialogConfig).show();
    }
}
