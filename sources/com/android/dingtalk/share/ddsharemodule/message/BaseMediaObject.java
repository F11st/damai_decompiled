package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BaseMediaObject implements DDMediaMessage.IMediaObject {
    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void attachContext(Context context) {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public boolean checkArgs() {
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return Integer.MAX_VALUE;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 0;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
    }
}
