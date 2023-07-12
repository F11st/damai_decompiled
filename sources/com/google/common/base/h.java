package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.jn1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class h {
    public static boolean a(@NullableDecl String str) {
        return f.e(str);
    }

    public static String b(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = c(objArr[i2]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) valueOf, i3, indexOf);
            sb.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
                sb.append(objArr[i4]);
            }
            sb.append(jn1.ARRAY_END);
        }
        return sb.toString();
    }

    private static String c(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e);
            return jn1.L + str + " threw " + e.getClass().getName() + jn1.G;
        }
    }
}
