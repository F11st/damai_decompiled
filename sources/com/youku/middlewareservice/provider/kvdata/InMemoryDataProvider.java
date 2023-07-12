package com.youku.middlewareservice.provider.kvdata;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface InMemoryDataProvider {
    void clearGlobalData(String str);

    boolean getGlobalBooleanData(String str, String str2, boolean z);

    int getGlobalIntData(String str, String str2, int i);

    long getGlobalLongData(String str, String str2, long j);

    Object getGlobalObjectData(String str, String str2);

    String getGlobalStringData(String str, String str2);

    boolean hasGlobalData(String str, String str2);

    Object removeGlobalData(String str, String str2);

    void setGlobalData(String str, String str2, int i);

    void setGlobalData(String str, String str2, long j);

    void setGlobalData(String str, String str2, Object obj);

    void setGlobalData(String str, String str2, boolean z);
}
