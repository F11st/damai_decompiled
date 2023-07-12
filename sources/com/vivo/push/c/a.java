package com.vivo.push.c;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.ali.user.mobile.rpc.safe.AES;
import com.vivo.push.util.p;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a implements c {
    private KeyStore a;
    private SecretKey b;

    public a() {
        a();
        b();
    }

    private void a() {
        try {
            KeyStore keyStore = KeyStore.getInstance(AES.ANDROID_KEYSTORE);
            this.a = keyStore;
            keyStore.load(null);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    private SecretKey b() {
        try {
            SecretKey secretKey = this.b;
            if (secretKey != null) {
                return secretKey;
            }
            if (!c()) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", AES.ANDROID_KEYSTORE);
                if (Build.VERSION.SDK_INT >= 23) {
                    keyGenerator.init(new KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                }
                this.b = keyGenerator.generateKey();
            } else {
                this.b = d();
            }
            return this.b;
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "getSecretKey error" + e.getMessage());
            return null;
        }
    }

    private boolean c() {
        try {
            if (this.a == null) {
                a();
            }
            return this.a.containsAlias("AesKeyAlias");
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "hasAESKey error" + e.getMessage());
            return false;
        }
    }

    private SecretKey d() {
        try {
            return ((KeyStore.SecretKeyEntry) this.a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "getAESSecretKey error" + e.getMessage());
            return null;
        }
    }
}
