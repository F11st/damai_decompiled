package com.alibaba.wireless.security.aopsdk.i;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.reflect.Array;
import tb.jn1;

/* renamed from: com.alibaba.wireless.security.aopsdk.i.b */
/* loaded from: classes.dex */
public class StringUtils {
    public static String a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return obj != null ? obj.toString() : "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            sb.append(a(Array.get(obj, i)));
            if (i != length - 1) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
