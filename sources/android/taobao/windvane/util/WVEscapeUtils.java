package android.taobao.windvane.util;

import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import cn.damai.ticklet.bean.UserTicketTable;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.weex.utils.WXUtils;
import com.tencent.connect.common.Constants;
import com.uc.webview.export.extension.UCCore;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import tb.g41;
import tb.in2;
import tb.jg1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVEscapeUtils {
    private static final String[] hex = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", Constants.VIA_REPORT_TYPE_START_WAP, Constants.VIA_REPORT_TYPE_START_GROUP, "18", Constants.VIA_ACT_TYPE_NINETEEN, "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", in2.PERFORM_CANCEL, UserTicketTable.COUPON_TICKET, RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", g41.ISSUE_PARAM_COMMENT_TYPE_SCRIPT, "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", UCCore.OPTION_HARDWARE_ACCELERATED, "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", AbstractC3840a.V, "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
    private static final byte[] val = {63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, 14, 15, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, 14, 15, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63};

    private static String decodeUrl(String str) {
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append(jg1.SCHEME_SLASH);
            stringBuffer.append(url.getHost());
            int port = url.getPort();
            if (port != 80 && port != -1) {
                stringBuffer.append(":" + port);
            }
            String path = url.getPath();
            String query = url.getQuery();
            if (!TextUtils.isEmpty(path)) {
                boolean z = path.lastIndexOf("/") == path.length() - 1;
                String[] split = path.split("/");
                if (split != null) {
                    stringBuffer.append("/");
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        if (!TextUtils.isEmpty(split[i])) {
                            stringBuffer.append(URLEncoder.encode(tryDecode(split[i]), "utf-8"));
                            if (i < length - 1) {
                                stringBuffer.append("/");
                            }
                        }
                    }
                }
                if (z) {
                    stringBuffer.append("/");
                }
            }
            if (!TextUtils.isEmpty(query)) {
                stringBuffer.append("?");
                String[] split2 = query.split("&");
                if (split2 != null) {
                    int length2 = split2.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        String[] split3 = split2[i2].split("=");
                        if (split3 != null && split3.length == 2) {
                            String str2 = split3[0];
                            String encode = URLEncoder.encode(tryDecode(split3[1]), "utf-8");
                            stringBuffer.append(str2 + "=" + encode);
                            if (i2 < length2 - 1) {
                                stringBuffer.append("&");
                            }
                        }
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                stringBuffer.append('+');
            } else if ('A' <= charAt && charAt <= 'Z') {
                stringBuffer.append(charAt);
            } else if ('a' <= charAt && charAt <= 'z') {
                stringBuffer.append(charAt);
            } else if ('0' <= charAt && charAt <= '9') {
                stringBuffer.append(charAt);
            } else if (charAt == '-' || charAt == '_' || charAt == '.' || charAt == '!' || charAt == '~' || charAt == '*' || charAt == '/' || charAt == '(' || charAt == ')') {
                stringBuffer.append(charAt);
            } else if (charAt <= 127) {
                stringBuffer.append(WXUtils.PERCENT);
                stringBuffer.append(hex[charAt]);
            } else {
                stringBuffer.append(WXUtils.PERCENT);
                stringBuffer.append('u');
                String[] strArr = hex;
                stringBuffer.append(strArr[charAt >>> '\b']);
                stringBuffer.append(strArr[charAt & 255]);
            }
        }
        return stringBuffer.toString();
    }

    private static String tryDecode(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = URLDecoder.decode(str, "utf-8");
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    str2 = URLDecoder.decode(str, "gbk");
                } catch (Throwable unused2) {
                }
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    str2 = unescape(str);
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
        }
        return str2;
    }

    public static String tryDecodeUrl(String str) {
        try {
            URI.create(str);
            return str;
        } catch (Throwable unused) {
            return decodeUrl(str);
        }
    }

    public static String unescape(String str) {
        int i;
        byte b;
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '+') {
                stringBuffer.append(' ');
            } else if ('A' <= charAt && charAt <= 'Z') {
                stringBuffer.append(charAt);
            } else if ('a' <= charAt && charAt <= 'z') {
                stringBuffer.append(charAt);
            } else if ('0' <= charAt && charAt <= '9') {
                stringBuffer.append(charAt);
            } else if (charAt == '-' || charAt == '_' || charAt == '.' || charAt == '!' || charAt == '~' || charAt == '*' || charAt == '/' || charAt == '(' || charAt == ')') {
                stringBuffer.append(charAt);
            } else if (charAt == '%') {
                int i3 = i2 + 1;
                if ('u' != str.charAt(i3)) {
                    byte[] bArr = val;
                    i = (bArr[str.charAt(i3)] | 0) << 4;
                    i2 += 2;
                    b = bArr[str.charAt(i2)];
                } else {
                    byte[] bArr2 = val;
                    i = (((((bArr2[str.charAt(i2 + 2)] | 0) << 4) | bArr2[str.charAt(i2 + 3)]) << 4) | bArr2[str.charAt(i2 + 4)]) << 4;
                    i2 += 5;
                    b = bArr2[str.charAt(i2)];
                }
                stringBuffer.append((char) (b | i));
            }
            i2++;
        }
        return stringBuffer.toString();
    }
}
