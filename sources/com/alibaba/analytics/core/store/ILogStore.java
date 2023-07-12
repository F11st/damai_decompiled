package com.alibaba.analytics.core.store;

import java.util.List;
import tb.qa1;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ILogStore {
    void clear();

    int clearOldLogByCount(int i);

    int clearOldLogByField(String str, String str2);

    int count();

    int delete(List<qa1> list);

    List<qa1> get(int i);

    double getDbFileSize();

    boolean insert(List<qa1> list);

    void update(List<qa1> list);

    void updateLogPriority(List<qa1> list);
}
