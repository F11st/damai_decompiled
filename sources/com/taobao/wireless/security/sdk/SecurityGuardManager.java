package com.taobao.wireless.security.sdk;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.taobao.wireless.security.sdk.atlasencrypt.IAtlasEncryptComponent;
import com.taobao.wireless.security.sdk.datacollection.IDataCollectionComponent;
import com.taobao.wireless.security.sdk.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.taobao.wireless.security.sdk.dynamicdatastore.IDynamicDataStoreComponent;
import com.taobao.wireless.security.sdk.indiekit.IIndieKitComponent;
import com.taobao.wireless.security.sdk.initialize.C6979a;
import com.taobao.wireless.security.sdk.initialize.IInitializeComponent;
import com.taobao.wireless.security.sdk.nocaptcha.INoCaptchaComponent;
import com.taobao.wireless.security.sdk.pkgvaliditycheck.IPkgValidityCheckComponent;
import com.taobao.wireless.security.sdk.rootdetect.IRootDetectComponent;
import com.taobao.wireless.security.sdk.safetoken.ISafeTokenComponent;
import com.taobao.wireless.security.sdk.securesignature.ISecureSignatureComponent;
import com.taobao.wireless.security.sdk.securityDNS.ISecurityDNSComponent;
import com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent;
import com.taobao.wireless.security.sdk.simulatordetect.ISimulatorDetectComponent;
import com.taobao.wireless.security.sdk.staticdataencrypt.IStaticDataEncryptComponent;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;
import java.lang.reflect.GenericDeclaration;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SecurityGuardManager {
    private static volatile SecurityGuardManager b;
    private static volatile IInitializeComponent c;
    private static final Object d = new Object();
    public static final /* synthetic */ int e = 0;
    private com.alibaba.wireless.security.open.SecurityGuardManager a;

    private SecurityGuardManager(Context context) {
        try {
            this.a = com.alibaba.wireless.security.open.SecurityGuardManager.getInstance(context);
        } catch (SecException e2) {
            e2.printStackTrace();
        }
    }

    private <T> T a(Class<T> cls) {
        try {
            com.alibaba.wireless.security.open.SecurityGuardManager securityGuardManager = this.a;
            if (securityGuardManager != null) {
                return (T) securityGuardManager.getInterface(cls);
            }
            return null;
        } catch (SecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static IInitializeComponent getInitializer() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new C6979a();
                }
            }
        }
        return c;
    }

    public static SecurityGuardManager getInstance(Context context) {
        if (b == null) {
            synchronized (SecurityGuardManager.class) {
                if (context == null) {
                    return null;
                }
                if (b == null && getInitializer().initialize(context) == 0) {
                    b = new SecurityGuardManager(context);
                }
            }
        }
        return b;
    }

    public IAtlasEncryptComponent getAtlasEncryptComp() {
        return (IAtlasEncryptComponent) getComponent(15);
    }

    public IComponent getComponent(int i) {
        GenericDeclaration genericDeclaration;
        switch (i) {
            case 1:
                genericDeclaration = ISecureSignatureComponent.class;
                break;
            case 2:
                genericDeclaration = IDynamicDataStoreComponent.class;
                break;
            case 3:
                genericDeclaration = IIndieKitComponent.class;
                break;
            case 4:
                genericDeclaration = IStaticDataStoreComponent.class;
                break;
            case 5:
                genericDeclaration = IRootDetectComponent.class;
                break;
            case 6:
                genericDeclaration = IDataCollectionComponent.class;
                break;
            case 7:
                genericDeclaration = IStaticDataEncryptComponent.class;
                break;
            case 8:
                genericDeclaration = ISecurityBodyComponent.class;
                break;
            case 9:
                genericDeclaration = IDynamicDataEncryptComponent.class;
                break;
            case 10:
                genericDeclaration = ISimulatorDetectComponent.class;
                break;
            case 11:
                genericDeclaration = ISecurityDNSComponent.class;
                break;
            case 12:
                genericDeclaration = IPkgValidityCheckComponent.class;
                break;
            case 13:
            default:
                return null;
            case 14:
                genericDeclaration = INoCaptchaComponent.class;
                break;
            case 15:
                genericDeclaration = IAtlasEncryptComponent.class;
                break;
            case 16:
                genericDeclaration = ISafeTokenComponent.class;
                break;
        }
        return (IComponent) a(genericDeclaration);
    }

    public IDataCollectionComponent getDataCollectionComp() {
        return (IDataCollectionComponent) getComponent(6);
    }

    public IDynamicDataEncryptComponent getDynamicDataEncryptComp() {
        return (IDynamicDataEncryptComponent) getComponent(9);
    }

    public IDynamicDataStoreComponent getDynamicDataStoreComp() {
        return (IDynamicDataStoreComponent) getComponent(2);
    }

    public IIndieKitComponent getIndieKitComp() {
        return (IIndieKitComponent) getComponent(3);
    }

    public <T> T getInterface(Class<T> cls) {
        try {
            return (T) this.a.getInterface(cls);
        } catch (SecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public INoCaptchaComponent getNoCaptchaComp() {
        return (INoCaptchaComponent) getComponent(14);
    }

    public IPkgValidityCheckComponent getPackageValidityCheckComp() {
        return (IPkgValidityCheckComponent) getComponent(12);
    }

    public IRootDetectComponent getRootDetectComp() {
        return (IRootDetectComponent) getComponent(5);
    }

    public String getSDKVerison() {
        com.alibaba.wireless.security.open.SecurityGuardManager securityGuardManager = this.a;
        if (securityGuardManager != null) {
            return securityGuardManager.getSDKVerison();
        }
        return null;
    }

    public ISafeTokenComponent getSafeTokenComp() {
        return (ISafeTokenComponent) getComponent(16);
    }

    public ISecureSignatureComponent getSecureSignatureComp() {
        return (ISecureSignatureComponent) getComponent(1);
    }

    public ISecurityBodyComponent getSecurityBodyComp() {
        return (ISecurityBodyComponent) getComponent(8);
    }

    public ISecurityDNSComponent getSecurityDNSComp() {
        return (ISecurityDNSComponent) getComponent(11);
    }

    public ISimulatorDetectComponent getSimulatorDetectComp() {
        return (ISimulatorDetectComponent) getComponent(10);
    }

    public IStaticDataEncryptComponent getStaticDataEncryptComp() {
        return (IStaticDataEncryptComponent) getComponent(7);
    }

    public IStaticDataStoreComponent getStaticDataStoreComp() {
        return (IStaticDataStoreComponent) getComponent(4);
    }

    public Boolean isOpen() {
        return Boolean.FALSE;
    }
}
