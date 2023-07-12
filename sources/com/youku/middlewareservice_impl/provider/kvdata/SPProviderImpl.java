package com.youku.middlewareservice_impl.provider.kvdata;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.alient.oneservice.provider.impl.kvdata.DefaultShareperfence;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.kvdata.SPProvider;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class SPProviderImpl implements SPProvider {
    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public boolean getPreferenceBoolean(String str) {
        return DefaultShareperfence.getBoolean(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public int getPreferenceInt(String str) {
        return DefaultShareperfence.getInt(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public long getPreferenceLong(String str) {
        return DefaultShareperfence.getLong(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public String getPreferenceString(String str) {
        return DefaultShareperfence.getString(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public SharedPreferences getSharedPreferences(String str) {
        return AppInfoProviderProxy.getAppContext().getSharedPreferences(str, 0);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public void savePreference(String str, String str2) {
        DefaultShareperfence.savePreference(str, str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public boolean getPreferenceBoolean(String str, boolean z) {
        return DefaultShareperfence.getBoolean(str, z);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public int getPreferenceInt(String str, int i) {
        return DefaultShareperfence.getInt(str, i);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public long getPreferenceLong(String str, long j) {
        return DefaultShareperfence.getLong(str, j);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public String getPreferenceString(String str, String str2) {
        return DefaultShareperfence.getString(str, str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public SharedPreferences getSharedPreferences() {
        return DefaultShareperfence.getSp();
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public void savePreference(String str, int i) {
        DefaultShareperfence.savePreference(str, i);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public void savePreference(String str, long j) {
        DefaultShareperfence.savePreference(str, j);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.SPProvider
    public void savePreference(String str, boolean z) {
        DefaultShareperfence.savePreference(str, z);
    }
}
