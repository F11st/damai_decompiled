package com.alibaba.security.rp;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.rp.scanface.AuditResultCallback;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes8.dex */
public class RPSDK {
    private static Context mCtx;

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes8.dex */
    public enum AUDIT {
        AUDIT_EXCEPTION(-2),
        AUDIT_NOT(-1),
        AUDIT_IN_AUDIT(0),
        AUDIT_PASS(1),
        AUDIT_FAIL(2);
        
        private int audit;

        AUDIT(int i) {
            this.audit = i;
        }

        public final int getAudit() {
            return this.audit;
        }
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes8.dex */
    public interface RPCompletedListener {
        void onAuditResult(AUDIT audit);
    }

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes8.dex */
    public enum RPSDKEnv {
        RPSDKEnv_ONLINE(0),
        RPSDKEnv_PRE(1),
        RPSDKEnv_DAILY(2);
        
        private int env;

        RPSDKEnv(int i) {
            this.env = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AUDIT changeToAudit(RPResult rPResult) {
        if (rPResult == RPResult.AUDIT_FAIL) {
            return AUDIT.AUDIT_FAIL;
        }
        if (rPResult == RPResult.AUDIT_PASS) {
            return AUDIT.AUDIT_PASS;
        }
        if (rPResult == RPResult.AUDIT_IN_AUDIT) {
            return AUDIT.AUDIT_IN_AUDIT;
        }
        if (rPResult == RPResult.AUDIT_NOT) {
            return AUDIT.AUDIT_NOT;
        }
        if (rPResult == RPResult.AUDIT_EXCEPTION) {
            return AUDIT.AUDIT_EXCEPTION;
        }
        return AUDIT.AUDIT_NOT;
    }

    @Deprecated
    public static Context getContext() {
        return mCtx;
    }

    @Deprecated
    public static String getDeviceInfo() {
        return RPVerify.getDeviceInfo();
    }

    @Deprecated
    public static void initialize(RPSDKEnv rPSDKEnv, Context context) {
        mCtx = context.getApplicationContext();
        RPEnv rPEnv = RPEnv.ONLINE;
        if (rPSDKEnv == RPSDKEnv.RPSDKEnv_DAILY) {
            rPEnv = RPEnv.DAILY;
        } else if (rPSDKEnv == RPSDKEnv.RPSDKEnv_PRE) {
            rPEnv = RPEnv.PRE;
        } else {
            RPSDKEnv rPSDKEnv2 = RPSDKEnv.RPSDKEnv_ONLINE;
        }
        RPVerify.init(context, rPEnv);
    }

    @Deprecated
    public static void setContext(Context context) {
        mCtx = context;
    }

    @Deprecated
    public static void start(String str, Context context, final RPCompletedListener rPCompletedListener) {
        RPVerify.start(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.1
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                RPCompletedListener rPCompletedListener2 = RPCompletedListener.this;
                if (rPCompletedListener2 != null) {
                    rPCompletedListener2.onAuditResult(RPSDK.changeToAudit(rPResult));
                }
            }
        });
    }

    @Deprecated
    public static void startVerifyByNative(String str, final AuditResultCallback auditResultCallback) {
        Context context = mCtx;
        if (context == null) {
            return;
        }
        RPVerify.startByNative(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.3
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                AuditResultCallback auditResultCallback2 = AuditResultCallback.this;
                if (auditResultCallback2 != null) {
                    auditResultCallback2.onAuditStatus(rPResult.code);
                }
            }
        });
    }

    @Deprecated
    public static void startVerifyByUrl(String str, Context context, final RPCompletedListener rPCompletedListener) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RPVerify.startWithUrl(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.2
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                RPCompletedListener rPCompletedListener2 = RPCompletedListener.this;
                if (rPCompletedListener2 != null) {
                    rPCompletedListener2.onAuditResult(RPSDK.changeToAudit(rPResult));
                }
            }
        });
    }

    @Deprecated
    public static void initialize(RPSDKEnv rPSDKEnv, Context context, String str) {
        mCtx = context.getApplicationContext();
        RPEnv rPEnv = RPEnv.ONLINE;
        if (rPSDKEnv == RPSDKEnv.RPSDKEnv_DAILY) {
            rPEnv = RPEnv.DAILY;
        } else if (rPSDKEnv == RPSDKEnv.RPSDKEnv_PRE) {
            rPEnv = RPEnv.PRE;
        } else {
            RPSDKEnv rPSDKEnv2 = RPSDKEnv.RPSDKEnv_ONLINE;
        }
        RPVerify.init(context, rPEnv, str);
    }
}
