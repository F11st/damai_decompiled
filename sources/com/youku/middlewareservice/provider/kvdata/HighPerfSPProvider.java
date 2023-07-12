package com.youku.middlewareservice.provider.kvdata;

import android.content.SharedPreferences;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface HighPerfSPProvider {
    String[] allKeys(String str);

    boolean contains(String str, String str2);

    boolean getBoolean(String str, String str2);

    boolean getBoolean(String str, String str2, boolean z);

    float getFloat(String str, String str2);

    float getFloat(String str, String str2, float f);

    int getInt(String str, String str2);

    int getInt(String str, String str2, int i);

    long getLong(String str, String str2);

    long getLong(String str, String str2, long j);

    SharedPreferences getMultiProcessPreference(String str);

    SharedPreferences getPreference(String str);

    String getString(String str, String str2);

    String getString(String str, String str2, String str3);

    Set<String> getStringSet(String str, String str2, Set<String> set);

    void importFromSharedPreferences(String str, SharedPreferences sharedPreferences);

    boolean putBoolean(String str, String str2, boolean z);

    boolean putFloat(String str, String str2, float f);

    boolean putInt(String str, String str2, int i);

    boolean putLong(String str, String str2, long j);

    boolean putString(String str, String str2, String str3);

    boolean putStringSet(String str, String str2, Set<String> set);

    void removeValueForKey(String str, String str2);
}
