package com.alibaba.pictures.share.common.ui.dialog;

import com.alibaba.pictures.share.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class DialogHelper$showProgressDialog$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ CharSequence $msg;
    final /* synthetic */ boolean $transparent;
    final /* synthetic */ DialogHelper this$0;

    DialogHelper$showProgressDialog$1(DialogHelper dialogHelper, boolean z, CharSequence charSequence, boolean z2) {
        this.this$0 = dialogHelper;
        this.$transparent = z;
        this.$msg = charSequence;
        this.$cancelable = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073419164")) {
            ipChange.ipc$dispatch("2073419164", new Object[]{this});
        } else if (this.this$0.d().isFinishing()) {
        } else {
            DialogHelper dialogHelper = this.this$0;
            GenericProgressDialog genericProgressDialog = new GenericProgressDialog(this.this$0.d(), this.$transparent ? R$style.loading_style_transparent : R$style.loading_style);
            CharSequence charSequence = this.$msg;
            if (charSequence == null) {
                charSequence = "";
            }
            genericProgressDialog.setMessage(charSequence);
            genericProgressDialog.c(true);
            genericProgressDialog.setCancelable(this.$cancelable);
            genericProgressDialog.setOnCancelListener(null);
            genericProgressDialog.setCanceledOnTouchOutside(false);
            genericProgressDialog.show();
            wt2 wt2Var = wt2.INSTANCE;
            dialogHelper.a = genericProgressDialog;
        }
    }
}
