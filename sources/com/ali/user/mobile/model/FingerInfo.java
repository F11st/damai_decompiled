package com.ali.user.mobile.model;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FingerInfo implements Serializable, Comparator {
    public String key;
    public long loginTime;
    public String value;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            long j = ((FingerInfo) obj).loginTime;
            long j2 = ((FingerInfo) obj2).loginTime;
            if (j > j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
