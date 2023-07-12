package com.youku.middlewareservice_impl.provider.kvdata;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.orange.OrangeConfig;
import com.youku.middlewareservice.provider.kvdata.CloudConfigProvider;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class OrangeConfigProviderImpl implements CloudConfigProvider {
    private static final String DEFAULT_VALUE = "OrangeConfigProviderImplDefaultValue";
    private static final String TAG = "OrangeConfigProviderImp";

    private static String getFromOrange(String str, String str2, String str3) {
        return OrangeConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.CloudConfigProvider
    public String get(String str, String str2, String str3) {
        return getFromOrange(str, str2, str3);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.CloudConfigProvider
    public int get(String str, String str2, int i) {
        String config = OrangeConfig.getInstance().getConfig(str, str2, DEFAULT_VALUE);
        if (TextUtils.isEmpty(config) || DEFAULT_VALUE.equals(config)) {
            return i;
        }
        try {
            return Integer.parseInt(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    @Override // com.youku.middlewareservice.provider.kvdata.CloudConfigProvider
    public Integer get(String str, String str2, Integer num) {
        String config = OrangeConfig.getInstance().getConfig(str, str2, DEFAULT_VALUE);
        if (TextUtils.isEmpty(config) || DEFAULT_VALUE.equals(config)) {
            return num;
        }
        try {
            return Integer.valueOf(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return num;
        }
    }

    @Override // com.youku.middlewareservice.provider.kvdata.CloudConfigProvider
    public float get(String str, String str2, float f) {
        String config = OrangeConfig.getInstance().getConfig(str, str2, DEFAULT_VALUE);
        if (TextUtils.isEmpty(config) || DEFAULT_VALUE.equals(config)) {
            return f;
        }
        try {
            return Float.parseFloat(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    @Override // com.youku.middlewareservice.provider.kvdata.CloudConfigProvider
    public Float get(String str, String str2, Float f) {
        String config = OrangeConfig.getInstance().getConfig(str, str2, DEFAULT_VALUE);
        if (TextUtils.isEmpty(config) || DEFAULT_VALUE.equals(config)) {
            return f;
        }
        try {
            return Float.valueOf(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }
}
