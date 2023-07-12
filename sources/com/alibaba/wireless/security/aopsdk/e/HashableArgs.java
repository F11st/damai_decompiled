package com.alibaba.wireless.security.aopsdk.e;

import java.util.Arrays;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.b */
/* loaded from: classes.dex */
public class HashableArgs {
    private final Object[] a;

    public HashableArgs(Object[] objArr) {
        this.a = objArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HashableArgs)) {
            return false;
        }
        Object[] objArr = ((HashableArgs) obj).a;
        Object[] objArr2 = this.a;
        if (objArr2 == null && objArr == null) {
            return true;
        }
        if (objArr2 == null || objArr == null || objArr2.length != objArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Object[] objArr3 = this.a;
            if (i >= objArr3.length) {
                return true;
            }
            if (!(objArr3[i] == null && objArr[i] == null) && (objArr3[i] == null || objArr[i] == null || !objArr3[i].equals(objArr[i]))) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }
}
