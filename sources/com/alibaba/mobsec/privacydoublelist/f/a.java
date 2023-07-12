package com.alibaba.mobsec.privacydoublelist.f;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.reflect.Array;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class a {
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
