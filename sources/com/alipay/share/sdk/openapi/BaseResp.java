package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import com.alipay.share.sdk.Constant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class BaseResp {
    public int errCode;
    public String errStr;
    public String transaction;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public void fromBundle(Bundle bundle) {
        this.errCode = bundle.getInt(Constant.EXTRA_BASEREQ_ERROR_CODE);
        this.errStr = bundle.getString(Constant.EXTRA_BASEREQ_ERROR_STRING);
        this.transaction = bundle.getString(Constant.EXTRA_BASEREQ_TRANSACTION);
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt(Constant.EXTRA_COMMAND_TYPE, getType());
        bundle.putInt(Constant.EXTRA_BASEREQ_ERROR_CODE, this.errCode);
        bundle.putString(Constant.EXTRA_BASEREQ_ERROR_STRING, this.errStr);
        bundle.putString(Constant.EXTRA_BASEREQ_TRANSACTION, this.transaction);
    }
}
