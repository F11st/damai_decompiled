package com.ut.mini.core.sign;

import com.alibaba.analytics.utils.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import tb.km1;
import tb.ly1;
import tb.qc1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private String mAppSecret;
    private String mAppkey;
    private byte[] mDefaultAppAppSecret;
    private boolean mEncode;

    public UTBaseRequestAuthentication(String str, String str2) {
        this.mEncode = false;
        this.mAppkey = null;
        this.mAppSecret = null;
        this.mDefaultAppAppSecret = null;
        this.mAppkey = str;
        this.mAppSecret = str2;
    }

    public static String calcHmac(byte[] bArr, byte[] bArr2) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(bArr, mac.getAlgorithm()));
        return qc1.c(mac.doFinal(bArr2));
    }

    private byte[] getDefaultAppAppSecret() {
        if (this.mDefaultAppAppSecret == null) {
            this.mDefaultAppAppSecret = ly1.c(new byte[]{66, km1.OP_UNARY_MIN, km1.OP_GET_OPT_JUMP, -119, 118, -104, -30, 4, -95, 15, -26, -12, -75, -102, 71, 23, -3, -120, -1, -57, km1.OP_GET_OPT_JUMP, 99, -16, -101, 103, -74, 93, -114, 112, -26, -24, -24});
        }
        return this.mDefaultAppAppSecret;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.mAppkey;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        String str2;
        String calcHmac;
        if (this.mAppkey == null || (str2 = this.mAppSecret) == null) {
            Logger.i("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            try {
                if (this.mEncode) {
                    calcHmac = calcHmac(str2.getBytes(), str.getBytes());
                } else {
                    calcHmac = calcHmac(getDefaultAppAppSecret(), str.getBytes());
                }
                return calcHmac;
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public boolean isEncode() {
        return this.mEncode;
    }

    public UTBaseRequestAuthentication(String str, String str2, boolean z) {
        this.mEncode = false;
        this.mAppkey = null;
        this.mAppSecret = null;
        this.mDefaultAppAppSecret = null;
        this.mAppkey = str;
        this.mAppSecret = str2;
        this.mEncode = z;
    }
}
