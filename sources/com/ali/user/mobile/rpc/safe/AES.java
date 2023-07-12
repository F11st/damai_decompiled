package com.ali.user.mobile.rpc.safe;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.taobao.login4android.constants.LoginStatus;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AES {
    public static final String ALGORITHM = "AES";
    public static final String ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final String BLOCK_MODE = "CBC";
    public static int Error_invalid = 5001;
    public static int Error_other = 5002;
    public static final String MY_KEY = "com.ali.user.sdk.fingerprint";
    public static final String PADDING = "PKCS7Padding";
    public static final String TAG = "AES";
    public final KeyStore mKeyStore;

    public AES() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
        this.mKeyStore = keyStore;
        keyStore.load(null);
    }

    public void checkValid(CommonCallback commonCallback) throws Exception {
        if (commonCallback == null) {
            return;
        }
        try {
            Cipher.getInstance("AES/CBC/PKCS7Padding").init(3, getKey());
            commonCallback.onSuccess();
        } catch (KeyPermanentlyInvalidatedException e) {
            try {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "CheckValidException", e.getMessage(), String.valueOf(Error_invalid), null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                this.mKeyStore.deleteEntry(MY_KEY);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            commonCallback.onFail(Error_invalid, "指纹变更");
        } catch (Exception e2) {
            try {
                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "CheckValidException", e2.getMessage(), String.valueOf(Error_other), null);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.mKeyStore.deleteEntry(MY_KEY);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            commonCallback.onFail(Error_other, "指纹失败");
        }
    }

    @TargetApi(23)
    void createKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", ANDROID_KEYSTORE);
        keyGenerator.init(new KeyGenParameterSpec.Builder(MY_KEY, 3).setBlockModes(BLOCK_MODE).setEncryptionPaddings(PADDING).setUserAuthenticationRequired(true).build());
        keyGenerator.generateKey();
        TLogAdapter.e("AES", "createKey");
    }

    @TargetApi(23)
    public Cipher getCipher(boolean z) throws Exception {
        Key key = getKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        try {
            cipher.init(3, key);
            LoginStatus.resetFingerPrintEntrolled();
        } catch (Exception e) {
            e.printStackTrace();
            this.mKeyStore.deleteEntry(MY_KEY);
            if (z) {
                getCipher(false);
                LoginStatus.compareAndSetNewFingerPrintEntrolled(false, true);
            } else {
                try {
                    UserTrackAdapter.sendUT("KeyPermanentlyInvalidatedException", e.getLocalizedMessage());
                    TLogAdapter.e("AES", e);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                throw new Exception("create cipher failed", e);
            }
        }
        return cipher;
    }

    public Key getKey() throws Exception {
        if (!this.mKeyStore.isKeyEntry(MY_KEY)) {
            createKey();
        }
        TLogAdapter.e("AES", "getKeyFromCache");
        return this.mKeyStore.getKey(MY_KEY, null);
    }

    public boolean checkValid() throws Exception {
        Cipher.getInstance("AES/CBC/PKCS7Padding").init(3, getKey());
        return true;
    }
}
