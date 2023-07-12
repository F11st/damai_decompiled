package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APTextObject implements APMediaMessage.IMediaObject {
    public String text;

    public APTextObject() {
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.text;
        if (str == null || str.length() == 0 || this.text.length() > 10240) {
            Log.e("APSDK.ZFBTextObject", "checkArgs fail, text is invalid");
            return false;
        }
        return true;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(Constant.EXTRA_TEXT_OBJECT_TEXT, this.text);
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 11;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString(Constant.EXTRA_TEXT_OBJECT_TEXT);
    }

    public APTextObject(String str) {
        this.text = str;
    }
}
