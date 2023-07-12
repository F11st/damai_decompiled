package com.taobao.android.riverlogger.remote;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.riverlogger.remote.a */
/* loaded from: classes12.dex */
class C6580a {
    private static PublicKey a;

    private static PublicKey a() throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (a == null) {
            a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArlNJx85tVyR+jWmjFhwT7CAc2o0Fu8NGEhX/yHyJcJSrRgCdXiheAwaE6Nhex8y8uw4U1gIplq8tKqowMFcF7v67AXA4oS68yI6ci7wCSOSI58OsvW1ACD10mG7gmO/8/zphiSDYLZbQLzH29YSutnc5nAabSGZcZ4PG2JwcqefwWK9ei6RJKa10XcZ5e4qU0fQqBlOFSdy4MaBoDBJiGbvrkVfPuic2ApmbwP0vVLcml0WmP+vECpA18xoUAFpvjGgTUdZ9swTjzoQuO4adeWiZNO3lpG5/pZmVuUlufPb9rA8EZW/Tp9/10DCVu0wcga6IROtAiD8O/5xRBOXKDQIDAQAB", 0)));
        }
        return a;
    }

    public static boolean b(byte[] bArr, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(a());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception unused) {
            return false;
        }
    }
}
