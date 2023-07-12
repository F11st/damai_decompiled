package com.alibaba.security.realidentity.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class a {
    protected static final String b = "SecurityGuardManager";
    public RPEnv a = RPEnv.ONLINE;
    protected Context c;
    public String d;
    public String e;
    protected com.alibaba.security.realidentity.e.a f;

    public a(com.alibaba.security.realidentity.e.a aVar) {
        this.f = aVar;
    }

    private static boolean j() {
        return true;
    }

    private String k() throws Throwable {
        IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.c, null).getStaticDataStoreComp();
        if (staticDataStoreComp == null) {
            return null;
        }
        return staticDataStoreComp.getAppKeyByIndex(1, null);
    }

    private static int l() {
        return 1;
    }

    private static void m() {
        com.alibaba.security.common.c.a.c("SecurityGuardManager", "看到该日志，说明接入的图片yw_1222_" + ((String) null) + "存在问题。图片错误码：");
    }

    private int n() {
        RPEnv rPEnv = this.a;
        if (rPEnv == RPEnv.DAILY) {
            return 2;
        }
        if (rPEnv == RPEnv.PRE) {
            return 1;
        }
        RPEnv rPEnv2 = RPEnv.ONLINE;
        return 0;
    }

    private String o() {
        RPEnv rPEnv = this.a;
        if (rPEnv == RPEnv.DAILY) {
            return "DAILY";
        }
        if (rPEnv == RPEnv.PRE) {
            return "PREONLINE";
        }
        RPEnv rPEnv2 = RPEnv.ONLINE;
        return "ONLINE";
    }

    public final void a(Context context) {
        this.c = context;
        try {
            IInitializeComponent initializer = SecurityGuardManager.getInitializer();
            initializer.registerInitFinishListener(new IInitializeComponent.IInitFinishListener() { // from class: com.alibaba.security.realidentity.d.a.1
                @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
                public final void onError() {
                    a.this.c("security guard initialize error");
                }

                @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
                public final void onSuccess() {
                }
            });
            initializer.initializeAsync(context.getApplicationContext());
        } catch (Throwable th) {
            a("security guard initialize fail", th);
            m();
        }
    }

    public byte[] a(byte[] bArr, String str) {
        return null;
    }

    public final void b() {
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(this.c, null);
            if (securityGuardManager != null) {
                ((ISecurityBodyComponent) securityGuardManager.getInterface(ISecurityBodyComponent.class)).leaveRiskScene(2);
            }
        } catch (Throwable th) {
            a("security guard leave fail", th);
            m();
        }
    }

    protected final void c(String str) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, "", "");
        createSdkExceptionLog.setCode(-1);
        com.alibaba.security.realidentity.e.a aVar = this.f;
        if (aVar != null) {
            aVar.b(createSdkExceptionLog);
        }
    }

    public final String d() {
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.c, null).getStaticDataStoreComp();
            if (staticDataStoreComp == null) {
                return null;
            }
            return staticDataStoreComp.getAppKeyByIndex(0, null);
        } catch (Throwable th) {
            a("getSgMd5AppKey fail", th);
            m();
            return null;
        }
    }

    public final String e() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        try {
            ISecurityBodyComponent securityBodyComp = SecurityGuardManager.getInstance(this.c, null).getSecurityBodyComp();
            if (securityBodyComp == null) {
                c("getWuaToken securityBodyComponent null");
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            RPEnv rPEnv = this.a;
            String str = "ONLINE";
            if (rPEnv == RPEnv.DAILY) {
                str = "DAILY";
            } else if (rPEnv == RPEnv.PRE) {
                str = "PREONLINE";
            } else {
                RPEnv rPEnv2 = RPEnv.ONLINE;
            }
            hashMap.put("HOSTENV", str);
            String securityBodyDataEx = securityBodyComp.getSecurityBodyDataEx(null, null, null, hashMap, 4, 0);
            this.e = securityBodyDataEx;
            return securityBodyDataEx;
        } catch (Throwable th) {
            m();
            a("getWuaToken fail", th);
            return null;
        }
    }

    public final String f() {
        try {
            return ((ISecurityBodyComponent) SecurityGuardManager.getInstance(this.c).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, "", null, 4, 0);
        } catch (Throwable th) {
            m();
            a("getWuaToken fail", th);
            return null;
        }
    }

    public final String g() {
        try {
            return ((ISecurityBodyComponent) SecurityGuardManager.getInstance(this.c, null).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, null, null, 8, 4);
        } catch (Throwable th) {
            m();
            a("getMiniWuaToken fail", th);
            return null;
        }
    }

    public final String h() {
        int i;
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(this.c, null).getUMIDComp();
            if (uMIDComp == null) {
                c("getUmidToken umidComponent is null");
                return null;
            }
            RPEnv rPEnv = this.a;
            if (rPEnv == RPEnv.DAILY) {
                i = 2;
            } else if (rPEnv == RPEnv.PRE) {
                i = 1;
            } else {
                RPEnv rPEnv2 = RPEnv.ONLINE;
                i = 0;
            }
            uMIDComp.initUMIDSync(i);
            String securityToken = uMIDComp.getSecurityToken(i);
            this.d = securityToken;
            return securityToken;
        } catch (Throwable th) {
            m();
            a("getSgDataStoreComponent fail", th);
            return null;
        }
    }

    protected abstract String i();

    public final String c() {
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.c, null).getStaticDataStoreComp();
            if (staticDataStoreComp == null) {
                return null;
            }
            return staticDataStoreComp.getAppKeyByIndex(1, null);
        } catch (Throwable th) {
            a("getSgDataStoreComponent fail", th);
            m();
            return null;
        }
    }

    public final Pair<Boolean, String> a() {
        try {
            if (((ISecurityBodyComponent) SecurityGuardManager.getInstance(this.c, null).getInterface(ISecurityBodyComponent.class)).enterRiskScene(2, null)) {
                return new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "SecurityGuard enter risk scene failed");
        } catch (Throwable th) {
            a("security guard enter fail", th);
            m();
            if (th instanceof SecException) {
                Boolean bool = Boolean.FALSE;
                return new Pair<>(bool, "SecurityGuard enter risk scene exception, error code is: " + th.getErrorCode());
            }
            Boolean bool2 = Boolean.FALSE;
            return new Pair<>(bool2, "SecurityGuard enter risk scene exception, error code is: " + com.alibaba.security.common.d.b.a(th));
        }
    }

    public final String b(@NonNull String str) {
        try {
            ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(this.c, null).getSecureSignatureComp();
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            securityGuardParamContext.appKey = d();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 4;
            return secureSignatureComp.signRequest(securityGuardParamContext, null);
        } catch (Throwable th) {
            a("getSgSignMd5Result fail", th);
            m();
            return null;
        }
    }

    public final String a(@NonNull String str) {
        try {
            ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(this.c, null).getSecureSignatureComp();
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            HashMap hashMap = new HashMap();
            hashMap.put("INPUT", str);
            securityGuardParamContext.appKey = c();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            return secureSignatureComp.signRequest(securityGuardParamContext, null);
        } catch (Throwable th) {
            a("getSgSignSHA1Result fail", th);
            m();
            return null;
        }
    }

    private static SecurityGuardManager b(Context context) throws Throwable {
        return SecurityGuardManager.getInstance(context, null);
    }

    private void a(String str, Throwable th) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, com.alibaba.security.common.d.b.a(th), "");
        createSdkExceptionLog.setCode(-1);
        com.alibaba.security.realidentity.e.a aVar = this.f;
        if (aVar != null) {
            aVar.b(createSdkExceptionLog);
        }
    }

    private void a(RPEnv rPEnv) {
        this.a = rPEnv;
        this.d = null;
        this.e = null;
    }
}
