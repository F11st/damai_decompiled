package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OpenBusiLuckyMoney {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Req extends BaseReq {
        private static final int MAX_URL_LENGHT = 10240;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5 = this.appId;
            return str5 != null && str5.length() > 0 && (str = this.timeStamp) != null && str.length() > 0 && (str2 = this.nonceStr) != null && str2.length() > 0 && (str3 = this.signType) != null && str3.length() > 0 && (str4 = this.signature) != null && str4.length() > 0;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 13;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
            bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
            bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
            bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
            bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
            bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
        }
    }
}
