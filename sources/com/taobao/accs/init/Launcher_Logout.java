package com.taobao.accs.init;

import android.app.Application;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoRegister;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_Logout implements Serializable {
    private static final String TAG = Launcher_Logout.class.getSimpleName();

    public void init(Application application, HashMap<String, Object> hashMap) {
        ALog.i("Launcher_Logout", "logout", new Object[0]);
        Launcher_InitAccs.mUserId = null;
        Launcher_InitAccs.mSid = null;
        try {
            ACCSClient.getAccsClient().unbindUser();
            if (OrangeAdapter.isRegIdSwitchEnable(application)) {
                TaobaoRegister.removeAlias(application, new ICallback() { // from class: com.taobao.accs.init.Launcher_Logout.1
                    @Override // com.taobao.agoo.ICallback
                    public void onFailure(String str, String str2) {
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            String str3 = Launcher_Logout.TAG;
                            ALog.d(str3, "removeAlias fail, errDesc:" + str2 + " errorCode:" + str, new Object[0]);
                        }
                    }

                    @Override // com.taobao.agoo.ICallback
                    public void onSuccess() {
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(Launcher_Logout.TAG, "removeAlias success", new Object[0]);
                        }
                    }
                });
            }
        } catch (AccsException e) {
            ALog.e(TAG, e.getMessage(), new Object[0]);
        }
    }
}
