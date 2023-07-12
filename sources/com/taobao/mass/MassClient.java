package com.taobao.mass;

import android.content.ComponentName;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.ProcessStateListener;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class MassClient {
    private static final String TAG = "MassClient";
    private static volatile MassClient instance;
    private Handler handler;
    private IMassService iMassService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements ProcessStateListener {
        final /* synthetic */ ComponentName a;

        a(ComponentName componentName) {
            this.a = componentName;
        }

        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStart(String str) {
        }

        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStop(String str) {
            try {
                MassClient.this.iMassService = (IMassService) ARanger.createSingleton(this.a, IMassService.class, new Pair[0]);
            } catch (IPCException e) {
                ALog.e(MassClient.TAG, "[getMassService]", null, e);
            }
        }
    }

    private MassClient() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
    }

    public static MassClient getInstance() {
        if (instance == null) {
            synchronized (MassClient.class) {
                if (instance == null) {
                    instance = new MassClient();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IMassService getMassService() {
        if (this.iMassService == null) {
            ComponentName componentName = new ComponentName(ARanger.getContext(), AccsIPCProvider.class);
            try {
                this.iMassService = (IMassService) ARanger.createSingleton(componentName, IMassService.class, new Pair[0]);
            } catch (IPCException e) {
                ALog.e(TAG, "[getMassService]", null, e);
            }
            ARanger.registerProcessStateListener(new a(componentName));
        }
        return this.iMassService;
    }

    public List<String> getTopicsByService(String str) {
        try {
            return OrangeAdapter.isChannelModeEnable() ? getMassService().getTopicsByService(str) : Collections.emptyList();
        } catch (Exception e) {
            ALog.e(TAG, "getTopicsByService error", e, new Object[0]);
            return Collections.emptyList();
        }
    }

    public void registerTopic(final String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e(TAG, "registerTopic error, topic is null", new Object[0]);
        } else if (OrangeAdapter.isChannelModeEnable()) {
            this.handler.post(new Runnable() { // from class: com.taobao.mass.MassClient.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MassClient.this.getMassService().registerTopic(str, str2);
                    } catch (Exception e) {
                        ALog.e(MassClient.TAG, "registerTopic error", e, new Object[0]);
                    }
                }
            });
        }
    }

    public void unregisterTopic(final String str, final String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e(TAG, "unregisterTopic error, topic is null", new Object[0]);
        } else if (OrangeAdapter.isChannelModeEnable()) {
            this.handler.post(new Runnable() { // from class: com.taobao.mass.MassClient.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MassClient.this.getMassService().unregisterTopic(str, str2);
                    } catch (Exception e) {
                        ALog.e(MassClient.TAG, "unregisterTopic error", e, new Object[0]);
                    }
                }
            });
        }
    }
}
