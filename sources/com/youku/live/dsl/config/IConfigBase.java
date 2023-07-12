package com.youku.live.dsl.config;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IConfigBase {
    boolean getBoolean(String str, String str2, boolean z);

    double getDouble(String str, String str2, double d);

    float getFloat(String str, String str2, float f);

    int getInt(String str, String str2, int i);

    long getLong(String str, String str2, long j);

    String getString(String str, String str2, String str3);

    List<String> getStringArray(String str, String str2, List<String> list, String str3);

    String[] getStringArray(String str, String str2, String[] strArr, String str3);
}
