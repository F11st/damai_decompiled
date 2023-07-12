package com.taobao.accs.init;

import android.app.Application;
import android.content.ComponentName;
import android.text.TextUtils;
import anet.channel.util.AppLifecycle;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.aranger.ARanger;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_CrossActivityStarted implements Serializable {
    public void init(Application application, HashMap<String, Object> hashMap) {
        try {
            ALog.e("Launcher_CrossActivityStarted", "onStarted", new Object[0]);
            AppLifecycle.e();
            if (!TextUtils.isEmpty(Launcher_InitAccs.mAppkey) && Launcher_InitAccs.mContext != null) {
                if (Launcher_InitAccs.mIsInited) {
                    if (!OrangeAdapter.isChannelModeEnable() || ARanger.isConnect(new ComponentName(Launcher_InitAccs.mContext, AccsIPCProvider.class))) {
                        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.init.Launcher_CrossActivityStarted.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ACCSClient.getAccsClient().bindApp(Launcher_InitAccs.mTtid, Launcher_InitAccs.mAppReceiver);
                                } catch (AccsException e) {
                                    ALog.e("Launcher_CrossActivityStarted", "bindApp", e, new Object[0]);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            ALog.e("Launcher_CrossActivityStarted", "params null!!!", "appkey", Launcher_InitAccs.mAppkey, WPKFactory.INIT_KEY_CONTEXT, Launcher_InitAccs.mContext);
        } catch (Throwable th) {
            ALog.e("Launcher_CrossActivityStarted", "onStarted", th, new Object[0]);
            th.printStackTrace();
        }
    }
}
