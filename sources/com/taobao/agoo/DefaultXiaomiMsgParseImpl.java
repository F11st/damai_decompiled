package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.PushMessageHelper;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DefaultXiaomiMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "xiaomi";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        try {
            String str = PushMessageHelper.MESSAGE_TYPE;
            String str2 = (String) PushMessageHelper.class.getField("KEY_MESSAGE").get(null);
            if (intent.getSerializableExtra(str2) != null) {
                Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
                return (String) cls.getMethod("getContent", new Class[0]).invoke(cls.cast(intent.getSerializableExtra(str2)), new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            ALog.e("DefaultXiaomiMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
