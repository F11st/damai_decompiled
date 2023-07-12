package com.ali.user.mobile.info;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AlipayInfo {
    private static AlipayInfo INSTANCE = null;
    private static final String TAG = "login.AlipayInfo";
    private APSecuritySdk alipaySecuritySdk;
    private String mApdid;
    private String mApdidToken;

    private AlipayInfo() {
    }

    private void generateAlipayTokens(final DataCallback<String> dataCallback) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("utdid", AppInfo.getInstance().getUtdid());
            int envModeConfig = getEnvModeConfig(DataProviderFactory.getDataProvider().getEnvType());
            if (this.alipaySecuritySdk != null) {
                TLogAdapter.e(TAG, "generateAlipayTokens");
                this.alipaySecuritySdk.initToken(envModeConfig, hashMap, new APSecuritySdk.InitResultListener() { // from class: com.ali.user.mobile.info.AlipayInfo.1
                    @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
                    public void onResult(APSecuritySdk.TokenResult tokenResult) {
                        if (tokenResult != null) {
                            AlipayInfo.this.mApdid = tokenResult.apdid;
                            AlipayInfo.this.mApdidToken = tokenResult.apdidToken;
                        } else {
                            TLogAdapter.e(AlipayInfo.TAG, "generateAlipayTokens Failed!");
                        }
                        DataCallback dataCallback2 = dataCallback;
                        if (dataCallback2 != null) {
                            dataCallback2.result(AlipayInfo.this.mApdidToken);
                        }
                    }
                });
                TLogAdapter.d(TAG, "init mApdid=" + this.mApdid);
            } else {
                TLogAdapter.e(TAG, "generateAlipayTokens Failed: alipaySecuritySdk null");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private int getEnvModeConfig(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 2;
        }
        return 1;
    }

    public static synchronized AlipayInfo getInstance() {
        AlipayInfo alipayInfo;
        synchronized (AlipayInfo.class) {
            if (INSTANCE == null) {
                INSTANCE = new AlipayInfo();
            }
            alipayInfo = INSTANCE;
        }
        return alipayInfo;
    }

    private void initApdid() {
        if (TextUtils.isEmpty(this.mApdid)) {
            generateAlipayTokens(null);
        }
    }

    public String getApdid() {
        if (TextUtils.isEmpty(this.mApdid) && this.alipaySecuritySdk != null) {
            generateAlipayTokens(null);
        }
        return this.mApdid;
    }

    public String getApdidToken() {
        if (TextUtils.isEmpty(this.mApdidToken) && this.alipaySecuritySdk != null) {
            generateAlipayTokens(null);
            UserTrackAdapter.sendUT("Event_InitApdidToken");
        }
        TLogAdapter.d(TAG, "mApdidToken=" + this.mApdidToken);
        return this.mApdidToken;
    }

    public void init() {
        try {
            this.alipaySecuritySdk = APSecuritySdk.getInstance(DataProviderFactory.getApplicationContext());
            initApdid();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void getApdidToken(DataCallback<String> dataCallback) {
        if (TextUtils.isEmpty(this.mApdidToken)) {
            if (this.alipaySecuritySdk == null) {
                try {
                    this.alipaySecuritySdk = APSecuritySdk.getInstance(DataProviderFactory.getApplicationContext());
                } catch (Throwable th) {
                    th.printStackTrace();
                    TLogAdapter.e(TAG, th.getMessage());
                }
            }
            generateAlipayTokens(dataCallback);
            UserTrackAdapter.sendUT("Event_InitApdidToken");
            return;
        }
        dataCallback.result(this.mApdidToken);
    }
}
