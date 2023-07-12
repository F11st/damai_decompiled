package org.android.spdy;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class QuicProofVerifier {
    private static Set<TrustAnchor> LoadFromAndroidSystem(CertificateFactory certificateFactory) {
        return a.e().f();
    }

    @Deprecated
    public static int VerifyProof(String str, int i, String str2, int i2, String str3, String[] strArr, String str4, String str5) {
        return 0;
    }

    public static int VerifyProof(String str, String[] strArr) {
        CertificateFactory certificateFactoryFromInited = getCertificateFactoryFromInited();
        if (certificateFactoryFromInited == null) {
            spduLog.Loge("tnet-jni", "factory is null");
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        PKIXParameters pKIXParametersFromPresetCA = getPKIXParametersFromPresetCA();
        CertPathValidator androidCertPathValidator = getAndroidCertPathValidator();
        if (pKIXParametersFromPresetCA != null && androidCertPathValidator != null) {
            for (String str2 : strArr) {
                try {
                    arrayList.add((X509Certificate) certificateFactoryFromInited.generateCertificate(new ByteArrayInputStream(str2.getBytes(StandardCharsets.ISO_8859_1))));
                } catch (InvalidAlgorithmParameterException e) {
                    e.printStackTrace();
                    return 0;
                } catch (CertPathValidatorException e2) {
                    e2.printStackTrace();
                    return 0;
                } catch (CertificateException e3) {
                    e3.printStackTrace();
                    return 0;
                }
            }
            androidCertPathValidator.validate(certificateFactoryFromInited.generateCertPath(arrayList), pKIXParametersFromPresetCA);
            spduLog.Logd("tnet-jni", "validate ok  : " + androidCertPathValidator);
            return 1;
        }
        spduLog.Logd("tnet-jni", "InitializeFromAndroidSystem fail, params = " + pKIXParametersFromPresetCA + " validator = " + androidCertPathValidator);
        return 0;
    }

    private static CertPathValidator getAndroidCertPathValidator() {
        return a.e().b();
    }

    private static CertificateFactory getCertificateFactoryFromInited() {
        return a.e().d();
    }

    private static PKIXParameters getPKIXParametersFromPresetCA() {
        PKIXParameters c = a.e().c();
        if (c == null) {
            Set<TrustAnchor> LoadFromAndroidSystem = LoadFromAndroidSystem(getCertificateFactoryFromInited());
            if (LoadFromAndroidSystem == null) {
                return null;
            }
            return a.e().g(LoadFromAndroidSystem);
        }
        return c;
    }
}
