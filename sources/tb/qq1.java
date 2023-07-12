package tb;

import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class qq1 {
    @Nullable
    public static String a(@Nullable Object[] objArr, int i, @Nullable Class[] clsArr) {
        if (objArr == null || objArr.length == 0) {
            return "operationList is null or 0";
        }
        if (i <= 0) {
            int abs = Math.abs(i);
            if (objArr.length != abs) {
                return "operationList expected length is " + abs + ", but is " + objArr.length;
            }
        } else if (objArr.length < i) {
            return "operationList expected length is more then " + i + ", but is " + objArr.length;
        }
        if (clsArr == null || clsArr.length <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (objArr[i2] != null && clsArr[i2] != null && !clsArr[i2].isInstance(objArr[i2])) {
                return "operationList`s item type is wrong. Number " + i2 + " is " + objArr[i2].getClass() + ", but expected type is " + clsArr[i2];
            } else if (objArr[i2] == null && clsArr[i2] != null) {
                return "operationList`s item type is wrong. Number " + i2 + " is null, but expected type is " + clsArr[i2];
            } else if (objArr[i2] != null && clsArr[i2] == null) {
                return "operationList`s item type is wrong. Number " + i2 + " is " + objArr[i2].getClass() + ", but expected type is null";
            }
        }
        return null;
    }
}
