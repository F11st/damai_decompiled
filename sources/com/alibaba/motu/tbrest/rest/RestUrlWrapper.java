package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.utils.MD5Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestUrlWrapper {
    public static final String FIELD_APPKEY = "appkey";
    public static final String FIELD_APPVERSION = "app_version";
    public static final String FIELD_CHANNEL = "channel";
    public static final String FIELD_PLATFORM = "platform";
    public static final String FIELD_SDK_VERSION = "sdk_version";
    public static final String FIELD_T = "t";
    public static final String FIELD_UTDID = "utdid";
    public static final String FIELD_V = "v";
    static boolean enableSecuritySDK;
    static Context mContext;

    private static String _getEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String _wrapUrl(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) throws java.lang.Exception {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = java.lang.String.valueOf(r0)
            boolean r13 = com.alibaba.motu.tbrest.rest.RestUrlWrapper.enableSecuritySDK
            java.lang.String r0 = ""
            java.lang.String r1 = "4.1.0"
            java.lang.String r2 = "3.0"
            if (r13 == 0) goto L6d
            android.content.Context r13 = com.alibaba.motu.tbrest.rest.RestUrlWrapper.mContext
            if (r13 == 0) goto L6d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L64
            r13.<init>()     // Catch: java.lang.Exception -> L64
            r13.append(r9)     // Catch: java.lang.Exception -> L64
            r13.append(r10)     // Catch: java.lang.Exception -> L64
            r13.append(r11)     // Catch: java.lang.Exception -> L64
            r13.append(r12)     // Catch: java.lang.Exception -> L64
            r13.append(r1)     // Catch: java.lang.Exception -> L64
            r13.append(r14)     // Catch: java.lang.Exception -> L64
            r13.append(r8)     // Catch: java.lang.Exception -> L64
            r13.append(r2)     // Catch: java.lang.Exception -> L64
            r13.append(r0)     // Catch: java.lang.Exception -> L64
            if (r6 != 0) goto L39
            r6 = r0
        L39:
            r13.append(r6)     // Catch: java.lang.Exception -> L64
            if (r7 != 0) goto L3f
            r7 = r0
        L3f:
            r13.append(r7)     // Catch: java.lang.Exception -> L64
            java.lang.String r6 = r13.toString()     // Catch: java.lang.Exception -> L64
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Exception -> L64
            java.lang.String r6 = com.alibaba.motu.tbrest.utils.MD5Utils.getMd5Hex(r6)     // Catch: java.lang.Exception -> L64
            com.alibaba.motu.tbrest.rest.RestSecuritySDKRequestAuthentication r7 = new com.alibaba.motu.tbrest.rest.RestSecuritySDKRequestAuthentication     // Catch: java.lang.Exception -> L64
            android.content.Context r13 = com.alibaba.motu.tbrest.rest.RestUrlWrapper.mContext     // Catch: java.lang.Exception -> L64
            r7.<init>(r13, r9)     // Catch: java.lang.Exception -> L64
            java.lang.String r6 = r7.getSign(r6)     // Catch: java.lang.Exception -> L64
            boolean r7 = com.alibaba.motu.tbrest.utils.StringUtils.isNotBlank(r1)     // Catch: java.lang.Exception -> L62
            if (r7 == 0) goto L6b
            java.lang.String r7 = "1"
            goto L6f
        L62:
            r7 = move-exception
            goto L66
        L64:
            r7 = move-exception
            r6 = r0
        L66:
            java.lang.String r13 = "security sdk signed"
            com.alibaba.motu.tbrest.utils.LogUtil.w(r13, r7)
        L6b:
            r7 = r0
            goto L6f
        L6d:
            r6 = r0
            r7 = r6
        L6f:
            boolean r13 = com.alibaba.motu.tbrest.utils.StringUtils.isEmpty(r5)
            if (r13 != 0) goto L87
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            java.lang.String r5 = "&"
            r13.append(r5)
            java.lang.String r5 = r13.toString()
            goto L88
        L87:
            r5 = r0
        L88:
            r13 = 13
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r3 = 0
            r13[r3] = r4
            r4 = 1
            r13[r4] = r5
            r4 = 2
            java.lang.String r5 = _getEncoded(r9)
            r13[r4] = r5
            r4 = 3
            java.lang.String r5 = _getEncoded(r11)
            r13[r4] = r5
            r4 = 4
            java.lang.String r5 = _getEncoded(r10)
            r13[r4] = r5
            r4 = 5
            java.lang.String r5 = _getEncoded(r2)
            r13[r4] = r5
            r4 = 6
            java.lang.String r5 = _getEncoded(r6)
            r13[r4] = r5
            r4 = 7
            java.lang.String r5 = _getEncoded(r14)
            r13[r4] = r5
            r4 = 8
            r13[r4] = r1
            r4 = 9
            r13[r4] = r12
            r4 = 10
            r13[r4] = r8
            r4 = 11
            r13[r4] = r0
            r4 = 12
            r13[r4] = r7
            java.lang.String r4 = "%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s"
            java.lang.String r4 = java.lang.String.format(r4, r13)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.rest.RestUrlWrapper._wrapUrl(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void enableSecuritySDK() {
        enableSecuritySDK = true;
    }

    public static String getSignedTransferUrl(String str, Map<String, Object> map, Map<String, Object> map2, Context context, String str2, String str3, String str4, String str5, String str6, String str7) throws Exception {
        String str8 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str9 : RestKeyArraySorter.getInstance().sortResourcesList(strArr, true)) {
                str8 = str8 + str9 + MD5Utils.getMd5Hex((byte[]) map2.get(str9));
            }
        }
        try {
            return _wrapUrl(str, null, null, str8, context, str2, str3, str4, str5, str6, str7);
        } catch (Exception unused) {
            return _wrapUrl(RestConstants.getTransferUrl(), null, null, str8, context, str2, str3, str4, str5, str6, str7);
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
