package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PayResp extends BaseResp {
    public String extData;
    public String prepayId;
    public String returnKey;

    public PayResp() {
    }

    public PayResp(Bundle bundle) {
        fromBundle(bundle);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.prepayId = bundle.getString("_wxapi_payresp_prepayid");
        this.returnKey = bundle.getString("_wxapi_payresp_returnkey");
        this.extData = bundle.getString("_wxapi_payresp_extdata");
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payresp_prepayid", this.prepayId);
        bundle.putString("_wxapi_payresp_returnkey", this.returnKey);
        bundle.putString("_wxapi_payresp_extdata", this.extData);
    }
}
