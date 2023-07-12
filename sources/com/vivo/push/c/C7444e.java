package com.vivo.push.c;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.user.mobile.rpc.safe.AES;
import com.vivo.push.util.C7523p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.c.e */
/* loaded from: classes11.dex */
public final class C7444e implements InterfaceC7441b {
    private static PrivateKey a;
    private static PublicKey b;
    private static KeyStore c;
    private static X500Principal d;
    private Context e;

    public C7444e(Context context) {
        this.e = context;
        try {
            b();
            a(context);
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (c == null) {
                b();
            }
            return c.containsAlias(str);
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.InterfaceC7441b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b2 = b(this.e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(b2);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            C7523p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    private static void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance(AES.ANDROID_KEYSTORE);
            c = keyStore;
            keyStore.load(null);
            d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.c.InterfaceC7441b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }

    private static PrivateKey b(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = a;
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            C7523p.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        if (!b("PushRsaKeyAlias")) {
            a(context);
        }
        KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private static void a(Context context) {
        try {
            if (context == null) {
                C7523p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
            } else if (!b("PushRsaKeyAlias")) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", AES.ANDROID_KEYSTORE);
                    keyPairGenerator.initialize(build);
                    keyPairGenerator.generateKeyPair();
                }
            } else {
                C7523p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.c.InterfaceC7441b
    public final PublicKey a() {
        PublicKey publicKey;
        try {
            publicKey = b;
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
        }
        if (publicKey != null) {
            return publicKey;
        }
        if (!b("PushRsaKeyAlias")) {
            a(this.e);
        }
        KeyStore.Entry entry = c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            b = publicKey2;
            return publicKey2;
        }
        return null;
    }
}
