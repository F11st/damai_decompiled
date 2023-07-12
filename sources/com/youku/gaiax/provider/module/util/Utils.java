package com.youku.gaiax.provider.module.util;

import android.text.TextUtils;
import anet.channel.util.ALog;
import com.alibaba.fastjson.JSON;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import mtopsdk.common.util.TBSdkLog;
import tb.jn1;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Utils {
    public static final String DAMAI_PLATFORM = "DAMAI-ANDROID";
    public static final String TPP_PLATFORM = "TAOPIAOPIAO-ANDROID";

    public static String convertMapToDataStr(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(jn1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        if (TextUtils.isEmpty(value.toString())) {
                            sb.append(JSON.toJSONString(value));
                        } else if (TextUtils.isDigitsOnly(value.toString())) {
                            sb.append(value);
                        } else if (Boolean.TRUE.equals(value)) {
                            sb.append(true);
                        } else if (Boolean.FALSE.equals(value)) {
                            sb.append(false);
                        } else {
                            sb.append(JSON.toJSONString(value));
                        }
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[converMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(value);
                        sb2.append(" to dataStr error.");
                        TBSdkLog.e("mtopsdk.ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String encodeQueryParams(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append("=");
                    sb.append(URLEncoder.encode(zh2.j(entry.getValue()), str).replace(jn1.PLUS, "%20"));
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (UnsupportedEncodingException e) {
            ALog.d("Request", "format params failed", null, e, new Object[0]);
        }
        return sb.toString();
    }

    public static boolean equals(double d, double d2, double d3) {
        return Math.abs(d - d2) <= d3;
    }

    public static byte[] gzipCompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length > 0) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, bArr.length);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = null;
                }
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                gZIPOutputStream = null;
            }
        }
        return null;
    }
}
