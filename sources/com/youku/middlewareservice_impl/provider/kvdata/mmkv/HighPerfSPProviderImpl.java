package com.youku.middlewareservice_impl.provider.kvdata.mmkv;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider;
import java.util.Set;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class HighPerfSPProviderImpl implements HighPerfSPProvider {
    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public String[] allKeys(String str) {
        return MmkvUtil.getMMKV(str).allKeys();
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean contains(String str, String str2) {
        return MmkvUtil.getMMKV(str).contains(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean getBoolean(String str, String str2) {
        return MmkvUtil.getMMKV(str).decodeBool(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public float getFloat(String str, String str2) {
        return MmkvUtil.getMMKV(str).decodeFloat(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public int getInt(String str, String str2) {
        return MmkvUtil.getMMKV(str).decodeInt(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public long getLong(String str, String str2) {
        return MmkvUtil.getMMKV(str).decodeLong(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public SharedPreferences getMultiProcessPreference(String str) {
        return MmkvUtil.getMMKVMultiProcess(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public SharedPreferences getPreference(String str) {
        return MmkvUtil.getMMKV(str);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public String getString(String str, String str2) {
        return MmkvUtil.getMMKV(str).decodeString(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public Set<String> getStringSet(String str, String str2, Set<String> set) {
        return MmkvUtil.getMMKV(str).getStringSet(str2, set);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public void importFromSharedPreferences(String str, SharedPreferences sharedPreferences) {
        MmkvUtil.getMMKV(str).importFromSharedPreferences(sharedPreferences);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putBoolean(String str, String str2, boolean z) {
        return MmkvUtil.getMMKV(str).encode(str2, z);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putFloat(String str, String str2, float f) {
        return MmkvUtil.getMMKV(str).encode(str2, f);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putInt(String str, String str2, int i) {
        return MmkvUtil.getMMKV(str).encode(str2, i);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putLong(String str, String str2, long j) {
        return MmkvUtil.getMMKV(str).encode(str2, j);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putString(String str, String str2, String str3) {
        return MmkvUtil.getMMKV(str).encode(str2, str3);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean putStringSet(String str, String str2, Set<String> set) {
        return MmkvUtil.getMMKV(str).encode(str2, set);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public void removeValueForKey(String str, String str2) {
        MmkvUtil.getMMKV(str).removeValueForKey(str2);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public boolean getBoolean(String str, String str2, boolean z) {
        return MmkvUtil.getMMKV(str).decodeBool(str2, z);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public float getFloat(String str, String str2, float f) {
        return MmkvUtil.getMMKV(str).decodeFloat(str2, f);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public int getInt(String str, String str2, int i) {
        return MmkvUtil.getMMKV(str).decodeInt(str2, i);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public long getLong(String str, String str2, long j) {
        return MmkvUtil.getMMKV(str).decodeLong(str2, j);
    }

    @Override // com.youku.middlewareservice.provider.kvdata.HighPerfSPProvider
    public String getString(String str, String str2, String str3) {
        return MmkvUtil.getMMKV(str).decodeString(str2, str3);
    }
}
