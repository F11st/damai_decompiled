package com.taobao.tao.util;

import android.text.TextUtils;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyExtra;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageStrategyDecider {
    public static String decideUrl(String str, Integer num, Integer num2, Object obj) {
        ImageStrategyConfig a;
        int max;
        if (obj instanceof ImageStrategyConfig) {
            a = (ImageStrategyConfig) obj;
        } else {
            a = ImageStrategyConfig.o("default").a();
        }
        if (a.g() == ImageStrategyConfig.SizeLimitType.WIDTH_LIMIT) {
            max = num.intValue();
        } else if (a.g() == ImageStrategyConfig.SizeLimitType.HEIGHT_LIMIT) {
            max = num2.intValue();
        } else {
            max = Math.max(num.intValue(), num2.intValue());
        }
        if (max > 0) {
            max = (int) (max / TaobaoImageUrlStrategy.getInstance().getDip());
        }
        if (qb1.f(qb1.LEVEL_D)) {
            qb1.a(qb1.COMMON_TAG, "ImageStrategyDecider decideUrl, url=%s, width=%d, height=%d, info=%s", str, num, num2, a.q());
        }
        return TaobaoImageUrlStrategy.getInstance().decideUrl(str, max, a);
    }

    private static String doStrictConvergeAndWebP(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        TaobaoImageUrlStrategy.UriCDNInfo uriCDNInfo = new TaobaoImageUrlStrategy.UriCDNInfo(str);
        if (OssImageUrlStrategy.getInstance().isOssDomain(uriCDNInfo.host)) {
            if (OssImageUrlStrategy.getInstance().isFuzzyExclude(str)) {
                return str;
            }
            ImageStrategyExtra.ImageUrlInfo baseUrlInfo = ImageStrategyExtra.getBaseUrlInfo(str);
            String str2 = baseUrlInfo.base;
            if (TextUtils.isEmpty(str2) || str2.indexOf(64) <= 0) {
                return str;
            }
            if (".jpg".equals(baseUrlInfo.ext) || ".png".equals(baseUrlInfo.ext)) {
                return str2.substring(0, str2.length() - 4) + ".webp" + baseUrlInfo.suffix;
            }
            return str;
        } else if (TaobaoImageUrlStrategy.getInstance().isStrictCdnImage(uriCDNInfo)) {
            if (TaobaoImageUrlStrategy.getInstance().isDomainSwitch()) {
                str = TaobaoImageUrlStrategy.getInstance().strictConvergenceUrl(uriCDNInfo, false);
            }
            ImageStrategyExtra.ImageUrlInfo baseUrlInfo2 = ImageStrategyExtra.getBaseUrlInfo(str);
            String str3 = baseUrlInfo2.base;
            if (TextUtils.isEmpty(str3) || str3.endsWith("_.webp")) {
                return str;
            }
            return str3 + "_.webp" + baseUrlInfo2.suffix;
        } else {
            return str;
        }
    }

    public static String justConvergeAndWebP(String str) {
        String doStrictConvergeAndWebP = doStrictConvergeAndWebP(str);
        qb1.a(qb1.COMMON_TAG, "ImageStrategyDecider justConvergeAndWebP, raw=%s, ret=%s", str, doStrictConvergeAndWebP);
        return doStrictConvergeAndWebP;
    }
}
