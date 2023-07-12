package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.framework.d;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.compat.ICompatComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.initialize.c;
import com.alibaba.wireless.security.open.maldetection.IMalDetect;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.pkgvaliditycheck.IPkgValidityCheckComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecurityGuardManager {
    private static volatile SecurityGuardManager c;
    private static volatile IInitializeComponent d;
    private static JSONObject f;
    private static boolean g;
    public static final /* synthetic */ int i = 0;
    private ISGPluginManager a;
    private final Map<Integer, Class> b = new a(this);
    private static final Object e = new Object();
    private static Object h = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a extends HashMap<Integer, Class> {
        a(SecurityGuardManager securityGuardManager) {
            put(1, ISecureSignatureComponent.class);
            put(2, IDynamicDataStoreComponent.class);
            put(3, IStaticDataStoreComponent.class);
            put(5, IDataCollectionComponent.class);
            put(6, IStaticDataEncryptComponent.class);
            put(7, IDynamicDataEncryptComponent.class);
            put(8, ISimulatorDetectComponent.class);
            put(9, IStaticKeyEncryptComponent.class);
            put(10, IOpenSDKComponent.class);
            put(11, IUMIDComponent.class);
            put(12, IPkgValidityCheckComponent.class);
            put(13, IAtlasEncryptComponent.class);
            put(14, IMalDetect.class);
            put(15, INoCaptchaComponent.class);
            put(16, ISafeTokenComponent.class);
            put(17, ISecurityBodyComponent.class);
            put(18, ICompatComponent.class);
        }
    }

    private SecurityGuardManager(ISGPluginManager iSGPluginManager) {
        this.a = iSGPluginManager;
    }

    private static String getGlobalUserData() {
        String jSONObject;
        synchronized (h) {
            jSONObject = f.toString();
        }
        return jSONObject;
    }

    public static IInitializeComponent getInitializer() {
        return getInitializer(null);
    }

    public static IInitializeComponent getInitializer(String str) {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new com.alibaba.wireless.security.open.initialize.a(str);
                }
            }
        }
        return d;
    }

    public static SecurityGuardManager getInstance(Context context) throws SecException {
        return getInstance(context, null);
    }

    public static SecurityGuardManager getInstance(Context context, String str) throws SecException {
        if (c == null) {
            synchronized (SecurityGuardManager.class) {
                if (context == null) {
                    return null;
                }
                if (c == null && getInitializer(str).initialize(context) == 0) {
                    ISGPluginManager a2 = ((com.alibaba.wireless.security.open.initialize.a) getInitializer(str)).a();
                    if (a2 instanceof d) {
                        ((d) a2).a(g);
                    }
                    c = new SecurityGuardManager(a2);
                }
            }
        }
        if (c.a instanceof d) {
            ((d) c.a).a(g);
        }
        return c;
    }

    public static boolean getSilentMode() {
        return g;
    }

    public static boolean setGlobalUserData(String str, String str2) throws SecException {
        try {
            synchronized (h) {
                if (str == null && str2 == null) {
                    f = null;
                } else if (str == null || str2 == null) {
                    throw new SecException(118);
                } else {
                    if (f == null) {
                        f = new JSONObject();
                    }
                    f.put(str, str2);
                }
            }
            return true;
        } catch (JSONException e2) {
            throw new SecException(e2.getMessage(), 119);
        }
    }

    public static void setSilentMode(boolean z) {
        g = z;
    }

    IComponent a(int i2) {
        try {
            return (IComponent) getInterface(this.b.get(Integer.valueOf(i2)));
        } catch (SecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public IAtlasEncryptComponent getAtlasEncryptComp() {
        IAtlasEncryptComponent iAtlasEncryptComponent = (IAtlasEncryptComponent) a(13);
        if (iAtlasEncryptComponent == null) {
            new SecException(1098).printStackTrace();
        }
        return iAtlasEncryptComponent;
    }

    public ICompatComponent getCompatComp() {
        return (ICompatComponent) a(18);
    }

    public IDataCollectionComponent getDataCollectionComp() {
        return (IDataCollectionComponent) a(5);
    }

    public IDynamicDataEncryptComponent getDynamicDataEncryptComp() {
        return (IDynamicDataEncryptComponent) a(7);
    }

    public IDynamicDataStoreComponent getDynamicDataStoreComp() {
        return (IDynamicDataStoreComponent) a(2);
    }

    public <T> T getInterface(Class<T> cls) throws SecException {
        return (T) this.a.getInterface(cls);
    }

    public IMalDetect getMalDetectionComp() {
        IMalDetect iMalDetect = (IMalDetect) a(14);
        if (iMalDetect == null) {
            new SecException(SecExceptionCode.SEC_ERROR_MALDETECT_UNSUPPORTED).printStackTrace();
        }
        return iMalDetect;
    }

    public INoCaptchaComponent getNoCaptchaComp() {
        INoCaptchaComponent iNoCaptchaComponent = (INoCaptchaComponent) a(15);
        if (iNoCaptchaComponent == null) {
            new SecException(1299).printStackTrace();
        }
        return iNoCaptchaComponent;
    }

    public IOpenSDKComponent getOpenSDKComp() {
        return (IOpenSDKComponent) a(10);
    }

    public IPkgValidityCheckComponent getPackageValidityCheckComp() {
        return (IPkgValidityCheckComponent) a(12);
    }

    public String getSDKVerison() {
        return c.a();
    }

    public ISGPluginManager getSGPluginManager() {
        return this.a;
    }

    public ISafeTokenComponent getSafeTokenComp() {
        ISafeTokenComponent iSafeTokenComponent = (ISafeTokenComponent) a(16);
        if (iSafeTokenComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SAFETOKEN_UNKNOWN_ERR).printStackTrace();
        }
        return iSafeTokenComponent;
    }

    public ISecureSignatureComponent getSecureSignatureComp() {
        return (ISecureSignatureComponent) a(1);
    }

    public ISecurityBodyComponent getSecurityBodyComp() {
        ISecurityBodyComponent iSecurityBodyComponent = (ISecurityBodyComponent) a(17);
        if (iSecurityBodyComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SECURITYBODY_UNSUPPORTED).printStackTrace();
        }
        return iSecurityBodyComponent;
    }

    public ISimulatorDetectComponent getSimulatorDetectComp() {
        ISimulatorDetectComponent iSimulatorDetectComponent = (ISimulatorDetectComponent) a(8);
        if (iSimulatorDetectComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED).printStackTrace();
        }
        return iSimulatorDetectComponent;
    }

    public IStaticDataEncryptComponent getStaticDataEncryptComp() {
        return (IStaticDataEncryptComponent) a(6);
    }

    public IStaticDataStoreComponent getStaticDataStoreComp() {
        return (IStaticDataStoreComponent) a(3);
    }

    public IStaticKeyEncryptComponent getStaticKeyEncryptComp() {
        return (IStaticKeyEncryptComponent) a(9);
    }

    public IUMIDComponent getUMIDComp() {
        return (IUMIDComponent) a(11);
    }

    public Boolean isOpen() {
        return Boolean.TRUE;
    }
}
