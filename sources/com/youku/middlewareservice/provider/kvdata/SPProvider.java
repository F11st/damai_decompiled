package com.youku.middlewareservice.provider.kvdata;

import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface SPProvider {
    boolean getPreferenceBoolean(String str);

    boolean getPreferenceBoolean(String str, boolean z);

    int getPreferenceInt(String str);

    int getPreferenceInt(String str, int i);

    long getPreferenceLong(String str);

    long getPreferenceLong(String str, long j);

    String getPreferenceString(String str);

    String getPreferenceString(String str, String str2);

    SharedPreferences getSharedPreferences();

    SharedPreferences getSharedPreferences(String str);

    void savePreference(String str, int i);

    void savePreference(String str, long j);

    void savePreference(String str, String str2);

    void savePreference(String str, boolean z);
}
