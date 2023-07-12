package com.taobao.ma.bar.business.helper;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaBarBusinessHelper {
    public static String buildUrl(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(map.size());
        sb.append(str);
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (i == 0) {
                sb.append("?");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            } else {
                sb.append("&");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            i++;
        }
        return sb.toString();
    }
}
