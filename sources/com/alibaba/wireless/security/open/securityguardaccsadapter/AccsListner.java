package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.util.Log;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsListner extends AccsAbstractDataListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "CallbackListener";
    private static volatile IRouterComponent gGlobalRounterComponent;

    private IRouterComponent getRouterComponent() {
        if (gGlobalRounterComponent == null) {
            synchronized (AccsListner.class) {
                if (gGlobalRounterComponent == null) {
                    try {
                        gGlobalRounterComponent = SecurityGuardManager.getInstance(AccsAdapter.gContext).getSGPluginManager().getRouter();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return gGlobalRounterComponent;
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (bArr != null) {
            String str4 = new String(bArr);
            IRouterComponent routerComponent = getRouterComponent();
            if (routerComponent != null) {
                Log.d(TAG, "Call Do Command");
                routerComponent.doCommand(11152, str4);
            }
        }
    }

    @Override // com.taobao.accs.base.AccsAbstractDataListener, com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
