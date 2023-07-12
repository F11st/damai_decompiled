package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import com.alipay.share.sdk.Constant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BaseReq {
    public String transaction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a();

    public void fromBundle(Bundle bundle) {
        this.transaction = bundle.getString(Constant.EXTRA_BASEREQ_TRANSACTION);
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt(Constant.EXTRA_COMMAND_TYPE, getType());
        bundle.putString(Constant.EXTRA_BASEREQ_TRANSACTION, this.transaction);
    }
}
