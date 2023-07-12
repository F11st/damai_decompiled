package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SecurityCipher {
    private Context a;

    public SecurityCipher(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    public String atlasEncryptString(String str) throws JAQException {
        try {
            IAtlasEncryptComponent atlasEncryptComp = SecurityGuardManager.getInstance(this.a).getAtlasEncryptComp();
            if (atlasEncryptComp != null) {
                return atlasEncryptComp.atlasSafeEncrypt(str, "0335");
            }
            throw new SecException(1098);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public byte[] decryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticBinarySafeDecrypt(16, str, bArr, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public String decryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticSafeDecrypt(16, str2, str, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public byte[] encryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticBinarySafeEncrypt(16, str, bArr, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }

    public String encryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.a).getStaticDataEncryptComp().staticSafeEncrypt(16, str2, str, "0335");
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }
}
