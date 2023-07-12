package com.taobao.android.tlog.protocol;

import android.util.Log;
import com.taobao.android.tlog.protocol.utils.Base64;
import com.taobao.android.tlog.protocol.utils.MD5Utils;
import com.taobao.android.tlog.protocol.utils.RSAUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TLogSecret {
    public static final Integer encryptionType = 0;
    private final String DEFAULT_RSAPUBLICKEY;
    private String TAG;
    private String mRc4EncryptSecret;
    private String mRsaPublicMd5;
    private String rsaPublishKey;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class CreateInstance {
        private static TLogSecret instance = new TLogSecret();

        private CreateInstance() {
        }
    }

    public static synchronized TLogSecret getInstance() {
        TLogSecret tLogSecret;
        synchronized (TLogSecret.class) {
            tLogSecret = CreateInstance.instance;
        }
        return tLogSecret;
    }

    public String getRc4EncryptSecretValue(String str) throws Exception {
        if (this.mRc4EncryptSecret == null) {
            this.mRc4EncryptSecret = Base64.encodeBase64String(RSAUtils.encryptByPublicKey(str.getBytes(), getRsaPublishKey()));
        }
        String str2 = this.mRc4EncryptSecret;
        if (str2 == null) {
            Log.e(this.TAG, " rc4 Encrypt secret obtain failure ");
            return null;
        }
        return str2;
    }

    public String getRsaMd5Value() {
        if (this.mRsaPublicMd5 == null) {
            this.mRsaPublicMd5 = MD5Utils.encrypt(getRsaPublishKey().getBytes());
        }
        return this.mRsaPublicMd5;
    }

    public String getRsaPublishKey() {
        String str = this.rsaPublishKey;
        return str == null ? "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1cueeBrz4VMOr09PxnO7ILYh6jDhcZwEUgzjPfwy2apBZIHAfGagR8LzN35O0UhvoeN570mJP4g0nLm2KL1H/K1NGYqT254w0sdV51kzO/yu+WcfgPkPLosnR1kVaPqiYKT2Bl1Yi85ZJwApO2y8lPmFwpIrMmKiTYqR2Gmd9nQIDAQAB" : str;
    }

    public void setRsapublickey(String str) {
        if (str != null) {
            this.rsaPublishKey = str;
        }
    }

    private TLogSecret() {
        this.TAG = "TLogProtocol";
        this.DEFAULT_RSAPUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1cueeBrz4VMOr09PxnO7ILYh6jDhcZwEUgzjPfwy2apBZIHAfGagR8LzN35O0UhvoeN570mJP4g0nLm2KL1H/K1NGYqT254w0sdV51kzO/yu+WcfgPkPLosnR1kVaPqiYKT2Bl1Yi85ZJwApO2y8lPmFwpIrMmKiTYqR2Gmd9nQIDAQAB";
        this.rsaPublishKey = null;
    }
}
