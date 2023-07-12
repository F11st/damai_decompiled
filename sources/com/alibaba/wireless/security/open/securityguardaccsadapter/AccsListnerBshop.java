package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsListnerBshop extends AccsAbstractDataListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "CallbackListener";
    private static volatile IFCComponent ifcComponent;
    public static Context mContext;

    public AccsListnerBshop(Context context) {
        mContext = context;
    }

    private IFCComponent getIfcComponent() {
        if (ifcComponent == null) {
            synchronized (AccsListnerBshop.class) {
                if (ifcComponent == null) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("key_login_module", Boolean.TRUE);
                        ifcComponent = (IFCComponent) SecurityGuardManager.getInstance(mContext, "").getInterface(IFCComponent.class);
                        ifcComponent.setUp(mContext, hashMap);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return ifcComponent;
    }

    private boolean isUIProcess() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) mContext.getSystemService("activity")).getRunningAppProcesses();
        String packageName = mContext.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && packageName.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
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
        try {
            if (isUIProcess() && bArr != null && bArr.length != 0) {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String string = jSONObject.getString("code");
                String string2 = jSONObject.getString("location");
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0) {
                    IFCActionCallback iFCActionCallback = new IFCActionCallback() { // from class: com.alibaba.wireless.security.open.securityguardaccsadapter.AccsListnerBshop.1
                        @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
                        public void onAction(long j, FCAction.FCMainAction fCMainAction, long j2, HashMap hashMap) {
                        }

                        @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
                        public void onPreAction(long j, boolean z) {
                        }
                    };
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(string2);
                    hashMap.put("location", arrayList);
                    getIfcComponent().processFCContent(Integer.valueOf(string).intValue(), hashMap, iFCActionCallback, IFCComponent.ResponseHeaderType.KVL);
                }
            }
        } catch (Exception unused) {
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

    private AccsListnerBshop() {
    }
}
