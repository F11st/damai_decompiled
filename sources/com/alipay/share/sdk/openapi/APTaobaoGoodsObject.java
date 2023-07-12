package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.openapi.APMediaMessage;
import com.alipay.share.sdk.openapi.ui.Ui;

/* loaded from: classes10.dex */
public class APTaobaoGoodsObject implements APMediaMessage.IMediaObject {
    public String tag1;
    public String tag2;
    public Ui ui;
    public String webpageUrl;

    public APTaobaoGoodsObject() {
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str == null || str.length() == 0 || this.webpageUrl.length() > 10240) {
            Log.e("APSDK.APTaobaoObject", "checkArgs fail, webpageUrl is invalid");
            return false;
        }
        return true;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        throw new Error("Unresolved compilation problem: \n\ttip1BgColor cannot be resolved or is not a field\n");
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 1010;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
    }

    public APTaobaoGoodsObject(String str) {
        this.webpageUrl = str;
    }
}
