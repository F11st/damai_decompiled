package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BaseReq {
    public String mTransaction;

    public void attachContext(Context context) {
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        if (bundle != null) {
            this.mTransaction = bundle.getString(ShareConstant.EXTRA_BASEREQ_TRANSACTION);
        }
    }

    public abstract int getSupportVersion();

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt(ShareConstant.EXTRA_COMMAND_TYPE, getType());
            bundle.putString(ShareConstant.EXTRA_BASEREQ_TRANSACTION, this.mTransaction);
        }
    }
}
