package com.alibaba.security.rp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.rp.RPSDK;
import com.alibaba.security.rp.scanface.AuditResultCallback;
import com.alibaba.security.rp.service.aidl.IRPCompletedListener;
import com.alibaba.security.rp.service.aidl.IRPService;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPService extends Service {
    public static final int AUDIT_EXCEPTION = -2;
    public static final int AUDIT_FAIL = 1;
    public static final int AUDIT_IN_AUDIT = 0;
    public static final int AUDIT_NOT = -1;
    public static final int AUDIT_PASS = 2;
    protected final IRPService.Stub binder = new IRPService.Stub() { // from class: com.alibaba.security.rp.service.RPService.1
        @Override // com.alibaba.security.rp.service.aidl.IRPService
        public void start(String str, IRPCompletedListener iRPCompletedListener) {
            RPService.collectUsingLog("RPService", "start");
        }

        @Override // com.alibaba.security.rp.service.aidl.IRPService
        public void startVerifyByNative(String str, String str2, final IRPCompletedListener iRPCompletedListener) {
            RPService.collectUsingLog("RPService", "startVerifyByNative");
            RPSDK.setContext(RPService.this);
            RPSDK.startVerifyByNative(str, new AuditResultCallback() { // from class: com.alibaba.security.rp.service.RPService.1.1
                @Override // com.alibaba.security.rp.scanface.AuditResultCallback
                public void onAuditStatus(int i) {
                    try {
                        if (i == -2) {
                            iRPCompletedListener.onAuditResult(-2);
                        } else if (i == -1) {
                            iRPCompletedListener.onAuditResult(-1);
                        } else if (i == 0) {
                            iRPCompletedListener.onAuditResult(0);
                        } else if (i == 1) {
                            iRPCompletedListener.onAuditResult(1);
                        } else if (i != 2) {
                        } else {
                            iRPCompletedListener.onAuditResult(2);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }

        @Override // com.alibaba.security.rp.service.aidl.IRPService
        public void startVerifyByUrl(String str, final IRPCompletedListener iRPCompletedListener) {
            RPService.collectUsingLog("RPService", "startVerifyByUrl");
            RPSDK.startVerifyByUrl(str, RPService.this, new RPSDK.RPCompletedListener() { // from class: com.alibaba.security.rp.service.RPService.1.2
                @Override // com.alibaba.security.rp.RPSDK.RPCompletedListener
                public void onAuditResult(RPSDK.AUDIT audit) {
                    int audit2 = audit.getAudit();
                    int i = 2;
                    if (audit2 == -2 || audit2 == -1 || audit2 == 0) {
                        i = audit.getAudit();
                    } else if (audit2 != 1) {
                        i = audit2 != 2 ? -2 : 1;
                    }
                    try {
                        iRPCompletedListener.onAuditResult(i);
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void collectUsingLog(String str, String str2) {
        TrackLog createClassInvokedMonitor = TrackLog.createClassInvokedMonitor(str, str2);
        createClassInvokedMonitor.setVerifyToken(g.a.a.d);
        createClassInvokedMonitor.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createClassInvokedMonitor.addTag10("Android");
        a.C0165a.a.a(createClassInvokedMonitor);
        a.C0165a.a.a(false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }
}
