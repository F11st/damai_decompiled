package org.android.agoo.mezu;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class MeizuRegister {
    public static final String TAG = "MeizuPush";
    private static Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class MeizuMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
        MeizuMsgParseImpl() {
        }

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String getMsgSource() {
            return "meizu";
        }

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String parseMsgFromIntent(Intent intent) {
            String str = null;
            if (intent == null) {
                ALog.e(MeizuRegister.TAG, "parseMsgFromIntent null", new Object[0]);
                return null;
            }
            try {
                str = intent.getStringExtra(AgooConstants.MESSAGE_MEIZU_PAYLOAD);
                ALog.i(MeizuRegister.TAG, "parseMsgFromIntent", "msg", str);
                return str;
            } catch (Throwable th) {
                ALog.e(MeizuRegister.TAG, "parseMsgFromIntent", th, new Object[0]);
                return str;
            }
        }
    }

    public static void register(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (!MzSystemUtils.isBrandMeizu(context)) {
                ALog.i(TAG, "not meizu return", new Object[0]);
                return;
            }
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (!UtilityImpl.isMainProcess(applicationContext)) {
                ALog.i(TAG, "not in main process, return", new Object[0]);
                return;
            }
            BaseNotifyClickActivity.addNotifyListener(new MeizuMsgParseImpl());
            PushManager.register(mContext, str, str2);
        } catch (Throwable th) {
            ALog.e(TAG, "register", th, new Object[0]);
        }
    }
}
