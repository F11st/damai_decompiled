package com.android.dingtalk.share.ddsharemodule.message;

import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DDTextMessage extends BaseMediaObject {
    private static final String TAG = "DDTextMessage";
    private static final int TEXT_TITLE_MAX_LENGTH = 10240;
    public String mText;

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.mText;
        if (str == null || str.length() == 0 || this.mText.length() > 10240) {
            Log.e(TAG, "checkArgs fail, text is invalid");
            return false;
        }
        return true;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ShareConstant.EXTRA_TEXT_OBJECT_TEXT, this.mText);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mText = bundle.getString(ShareConstant.EXTRA_TEXT_OBJECT_TEXT);
    }
}
