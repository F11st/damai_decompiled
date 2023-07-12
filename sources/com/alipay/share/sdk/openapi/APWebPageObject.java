package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APWebPageObject implements APMediaMessage.IMediaObject {
    private String a = "APSDK.ZFBWebPageObject";
    public String webpageUrl;

    public APWebPageObject() {
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.webpageUrl;
        if (str == null || str.length() == 0 || this.webpageUrl.length() > 10240) {
            Log.e(this.a, "checkArgs fail, webpageUrl is invalid");
            return false;
        }
        return true;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(Constant.EXTRA_WEB_PAGE_OBJECT_URL, this.webpageUrl);
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 1001;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString(Constant.EXTRA_WEB_PAGE_OBJECT_URL);
    }

    public APWebPageObject(String str) {
        this.webpageUrl = str;
    }
}
