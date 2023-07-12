package com.taobao.tao.util;

import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageStrategyExtra {
    private static Pattern sCdnRuleRegex;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ImageUrlInfo {
        public String base;
        public String cj = "";
        public boolean existCi;
        public boolean existCo;
        public String ext;
        public int height;
        public String quality;
        public String sharpen;
        public String suffix;
        public int width;
    }

    private static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static ImageUrlInfo getBaseUrlInfo(String str) {
        ImageUrlInfo imageUrlInfo = new ImageUrlInfo();
        int indexOf = str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        if (indexOf > 0) {
            imageUrlInfo.suffix = str.substring(indexOf);
            imageUrlInfo.base = str.substring(0, indexOf);
        } else {
            int indexOf2 = str.indexOf("?");
            if (indexOf2 > 0) {
                imageUrlInfo.suffix = str.substring(indexOf2);
                imageUrlInfo.base = str.substring(0, indexOf2);
            } else {
                imageUrlInfo.suffix = "";
                imageUrlInfo.base = str;
            }
        }
        int lastIndexOf = imageUrlInfo.base.lastIndexOf(46);
        if (lastIndexOf > 0 && lastIndexOf > imageUrlInfo.base.lastIndexOf(47)) {
            imageUrlInfo.ext = imageUrlInfo.base.substring(lastIndexOf);
        }
        return imageUrlInfo;
    }

    public static ImageUrlInfo parseImageUrl(String str) {
        return parseImageUrl(str, null);
    }

    public static String signutf8(String str) {
        if (str == null) {
            return null;
        }
        try {
            return byte2hex(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("utf-8"))).toLowerCase();
        } catch (Exception unused) {
            throw new RuntimeException("sign error !");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImageUrlInfo parseImageUrl(String str, ImageUrlInfo imageUrlInfo) {
        if (imageUrlInfo == null) {
            imageUrlInfo = new ImageUrlInfo();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        imageUrlInfo.ext = str.substring(lastIndexOf);
        if (sCdnRuleRegex == null) {
            sCdnRuleRegex = Pattern.compile("_(?:(?:(?:\\.webp)|(?:\\.apg))|((?:(?:(\\d+)x(\\d+)(xz)?(co0)?(c[xy]\\d+i\\d)?)|([Qq]\\d{2})|(s\\d{2,3})){1,3}(?:\\.jpg)?(?:_(?:(?:\\.webp)|(?:\\.apg)))?))(?:END_IMAGE_URL)?$");
        }
        Matcher matcher = sCdnRuleRegex.matcher(str);
        int lastIndexOf2 = str.lastIndexOf(47);
        if (lastIndexOf2 < 0) {
            lastIndexOf2 = 0;
        }
        if (matcher.find(lastIndexOf2) && matcher.groupCount() >= 6) {
            try {
                String group = matcher.group(2);
                String group2 = matcher.group(3);
                String group3 = matcher.group(4);
                imageUrlInfo.existCo = !TextUtils.isEmpty(matcher.group(5));
                imageUrlInfo.existCi = !TextUtils.isEmpty(matcher.group(6));
                String group4 = matcher.group(7);
                String group5 = matcher.group(8);
                if (!TextUtils.isEmpty(group)) {
                    imageUrlInfo.width = Integer.parseInt(group);
                }
                if (!TextUtils.isEmpty(group2)) {
                    imageUrlInfo.height = Integer.parseInt(group2);
                }
                if (!TextUtils.isEmpty(group3)) {
                    imageUrlInfo.cj = group3;
                }
                if (!TextUtils.isEmpty(group4)) {
                    imageUrlInfo.quality = group4;
                }
                if (!TextUtils.isEmpty(group5)) {
                    imageUrlInfo.sharpen = group5;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                qb1.b(qb1.COMMON_TAG, "ImageStrategyExtra parseImageUrl convert number error:%s", e.getMessage());
            }
            imageUrlInfo.base = matcher.replaceFirst("");
            return imageUrlInfo;
        }
        return null;
    }
}
