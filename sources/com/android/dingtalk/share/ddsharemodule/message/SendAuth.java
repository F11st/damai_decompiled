package com.android.dingtalk.share.ddsharemodule.message;

import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SendAuth {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final int MIN_SUPPORT_VERSION = 20160101;
        public static final String SNS_LOGIN = "sns_login";
        private static final String TAG = "SendDDAuth.Req";
        public String scope;
        public String state;

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public boolean checkArgs() {
            String str = this.scope;
            if (str != null && str.length() != 0 && this.scope.length() <= 1024) {
                String str2 = this.state;
                if (str2 == null || str2.length() <= 1024) {
                    return true;
                }
                Log.e(TAG, "checkArgs fail, state is invalid");
                return false;
            }
            Log.e(TAG, "checkArgs fail, scope is invalid");
            return false;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (bundle != null) {
                this.scope = bundle.getString(ShareConstant.EXTRA_SEND_AUTH_SCOPE, null);
                this.state = bundle.getString(ShareConstant.EXTRA_SEND_AUTH_STATE, null);
            }
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public int getSupportVersion() {
            return 20160101;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public int getType() {
            return 100;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            if (bundle != null) {
                bundle.putString(ShareConstant.EXTRA_SEND_AUTH_SCOPE, this.scope);
                bundle.putString(ShareConstant.EXTRA_SEND_AUTH_STATE, this.state);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Resp extends BaseResp {
        private static final String TAG = "SendDDAuth.Resp";
        public String code;
        public String state;

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        boolean checkArgs() {
            return true;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (bundle != null) {
                this.code = bundle.getString(ShareConstant.EXTRA_SEND_AUTH_CODE, null);
                this.state = bundle.getString(ShareConstant.EXTRA_SEND_AUTH_STATE, null);
            }
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        public int getType() {
            return 100;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            if (bundle != null) {
                bundle.putString(ShareConstant.EXTRA_SEND_AUTH_CODE, this.code);
                bundle.putString(ShareConstant.EXTRA_SEND_AUTH_STATE, this.state);
            }
        }
    }
}
