package com.taobao.tao.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alipay.sdk.m.u.n;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.ImageStrategyExtra;
import com.youku.alixplayer.MsgID;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.uplayer.AliMediaPlayer;
import java.util.HashMap;
import tb.n11;
import tb.qb1;
import tb.v;

@SuppressLint({"NewApi"})
/* loaded from: classes11.dex */
public class TaobaoImageUrlStrategy {
    private static final float DEFAULT_LEVEL_RATIO = 0.1f;
    private int[] mApgBizWhiteList;
    private boolean mIsNetworkSlow;
    private long mLastUpdateTime;
    private HashMap<String, ServiceImageSwitch> mServiceImageSwitchList;
    private static final int[] CDN = {16, 20, 24, 30, 32, 36, 40, 48, 50, 60, 64, 70, 72, 80, 88, 90, 100, 110, 120, 125, 128, 130, 145, 160, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 180, AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH, 200, 210, 220, PlayerGuideTipsView.ANIM_DURATION_ALPHA, 234, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 250, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 290, 300, 310, 315, 320, 336, 350, 360, 400, 430, n.g, 468, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, 490, 540, 560, 570, 580, 600, 640, 670, LoginConstant.RESULT_WINDWANE_CLOSEW, 728, 760, 960, 970};
    private static final int[] CDN10000Width = {110, 150, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 220, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 290, 450, 570, 580, 620, 790};
    private static final int[] CDN10000Height = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 220, MsgID.TYPE_MSG_BEGIN_PLAYBACK, 500};
    private static final int[] XZCDN = {72, 88, 90, 100, 110, 120, 145, 160, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT, 180, 200, PlayerGuideTipsView.ANIM_DURATION_ALPHA, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE, 290, 310, 320, 360, 430, n.g, 580, 640};
    private static final int[] LEVEL_MODEL_CDN = {90, 110, 200, 320, n.g, 600, 760, 960, 1200};
    private static final int[] LEVEL_MODEL_XZCDN = {90, 110, 200, 320, n.g, 640};
    private static final String[] FUZZY_EXCLUDE_PATH = {"getAvatar"};
    private static final String[] LOOSE_CDN_DOMAIN_WHITE_LIST = {".alicdn.com", ".tbcdn.cn", ".taobaocdn.com", ".wimg.taobao.com", "img.taobao.com", "i.mmcdn.cn"};
    private static final String[] LOOSE_CDN_DOMAIN_BLACK_LIST = {"a.tbcdn.cn", "b.tbcdn.cn", "gqrcode.alicdn.com", "g.tbcdn.cn", "m.alicdn.com", "assets.alicdn.com", "g.alicdn.com", "ag.alicdn.com", "a.dd.alicdn.com", "uaction.alicdn.com", "wwc.alicdn.com", "osdes.alicdn.com", "download.taobaocdn.com", "gtb-fun.alicdn.com", "qianniu.alicdn.com", "gamc.alicdn.com", "glife-img.alicdn.com", "ossgw.alicdn.com", "gjusp.alicdn.com", "alchemy-img.alicdn.com", "alpha.alicdn.com", "h5.m.taobao.com"};
    private static final String APG_DOMAIN_DEST = "ms.alicdn.com";
    private static final String[] LOOSE_CONVERGENCE_BLACK_LIST = {"i.mmcdn.cn", "cbu01.alicdn.com", "ilce.alicdn.com", APG_DOMAIN_DEST};
    private static final String DOMAIN_DEST = "gw.alicdn.com";
    private static final String[] STRICT_CDN_DOMAIN_WHITE_LIST = {".tbcdn.cn", ".taobaocdn.com", ".wimg.taobao.com", "img.taobao.com", "i.mmcdn.cn", DOMAIN_DEST, "img.alicdn.com", "gtms03.alicdn.com", "ilce.alicdn.com"};
    private static final String[] STRICT_CDN_DOMAIN_BLACK_LIST = {"a.tbcdn.cn", "b.tbcdn.cn", "g.tbcdn.cn", "download.taobaocdn.com"};
    private static final String[] STRICT_CONVERGENCE_BLACK_LIST = {"i.mmcdn.cn", "ilce.alicdn.com", APG_DOMAIN_DEST};
    private int[] mCdn10000Width = CDN10000Width;
    private int[] mCdn10000Height = CDN10000Height;
    private int[] mCdnSizes = CDN;
    private int[] mXzCdnSizes = XZCDN;
    private int[] mLevelModelCdnSizes = LEVEL_MODEL_CDN;
    private int[] mLevelModelXzCdnSizes = LEVEL_MODEL_XZCDN;
    private String[] mLooseCDNDomainWhiteList = LOOSE_CDN_DOMAIN_WHITE_LIST;
    private String[] mLooseCDNDomainBlackList = LOOSE_CDN_DOMAIN_BLACK_LIST;
    private String[] mLooseConvergenceBlackList = LOOSE_CONVERGENCE_BLACK_LIST;
    private String[] mFuzzyExcludePath = FUZZY_EXCLUDE_PATH;
    private String mDoMainDest = DOMAIN_DEST;
    private String mApgImageDomain = APG_DOMAIN_DEST;
    private String[] mStrictCDNDomainWhiteList = STRICT_CDN_DOMAIN_WHITE_LIST;
    private String[] mStrictCDNDomainBlackList = STRICT_CDN_DOMAIN_BLACK_LIST;
    private String[] mStrictConvergenceBlackList = STRICT_CONVERGENCE_BLACK_LIST;
    private boolean mGlobalSwitch = true;
    private boolean mDomainSwitch = true;
    private float mDip = 1.0f;
    private boolean mWebpOn = true;
    private boolean mIsLowQuality = false;
    private float mLevelRatio = 0.1f;

    /* loaded from: classes11.dex */
    public enum CutType {
        xz("xz", "1c"),
        non("", "");
        
        String ossCut;
        String tfsCut;

        CutType(String str, String str2) {
            this.tfsCut = "";
            this.ossCut = "";
            this.tfsCut = str;
            this.ossCut = str2;
        }

        public String getCutType() {
            return this.tfsCut;
        }

        public String getOssCut() {
            return this.ossCut;
        }
    }

    /* loaded from: classes11.dex */
    public enum ImageQuality {
        q90("q90", "90q"),
        q75("q75", "75q"),
        q60("q60", "60q"),
        q50("q50", "50q"),
        q30("q30", "30q"),
        non("", "");
        
        String ossQ;
        String tfsQ;

        ImageQuality(String str, String str2) {
            this.tfsQ = "";
            this.ossQ = "";
            this.tfsQ = str;
            this.ossQ = str2;
        }

        public String getImageQuality() {
            return this.tfsQ;
        }

        public String getOssQuality() {
            return this.ossQ;
        }
    }

    /* loaded from: classes11.dex */
    public enum ImageSharpen {
        s100("s100"),
        s110("s110"),
        s120("s120"),
        s130("s130"),
        s140("s140"),
        s150("s150"),
        non("");
        
        String mImageSharpen;

        ImageSharpen(String str) {
            this.mImageSharpen = "";
            this.mImageSharpen = str;
        }

        public String getImageSharpen() {
            return this.mImageSharpen;
        }
    }

    /* loaded from: classes11.dex */
    public static class ServiceImageSwitch {
        private String areaName;
        private double highNetScale;
        private String highNetSharpen;
        private double lowNetScale;
        private String lowNetSharpen;
        private String suffix;
        private boolean useWebp = true;
        private String lowNetQ = ImageQuality.q75.getImageQuality();
        private String highNetQ = ImageQuality.q90.getImageQuality();

        public ServiceImageSwitch() {
            ImageSharpen imageSharpen = ImageSharpen.non;
            this.lowNetSharpen = imageSharpen.getImageSharpen();
            this.highNetSharpen = imageSharpen.getImageSharpen();
            this.lowNetScale = 1.0d;
            this.highNetScale = 1.0d;
        }

        public String getAreaName() {
            return this.areaName;
        }

        public String getHighNetQ() {
            return this.highNetQ;
        }

        public double getHighNetScale() {
            return this.highNetScale;
        }

        public String getHighNetSharpen() {
            return this.highNetSharpen;
        }

        public String getLowNetQ() {
            return this.lowNetQ;
        }

        public double getLowNetScale() {
            return this.lowNetScale;
        }

        public String getLowNetSharpen() {
            return this.lowNetSharpen;
        }

        public String getSuffix() {
            return this.suffix;
        }

        public boolean isUseWebp() {
            return this.useWebp;
        }

        public void setAreaName(String str) {
            this.areaName = str;
        }

        public void setHighNetQ(String str) {
            if (TextUtils.isEmpty(str)) {
                str = ImageQuality.q90.getImageQuality();
            }
            this.highNetQ = str;
        }

        public void setHighNetScale(double d) {
            if (d <= 0.0d) {
                d = this.highNetScale;
            }
            this.highNetScale = d;
        }

        public void setHighNetSharpen(String str) {
            if (TextUtils.isEmpty(str)) {
                str = this.highNetSharpen;
            }
            this.highNetSharpen = str;
        }

        public void setLowNetQ(String str) {
            if (TextUtils.isEmpty(str)) {
                str = ImageQuality.q75.getImageQuality();
            }
            this.lowNetQ = str;
        }

        public void setLowNetScale(double d) {
            if (d <= 0.0d) {
                d = this.lowNetScale;
            }
            this.lowNetScale = d;
        }

        public void setLowNetSharpen(String str) {
            if (TextUtils.isEmpty(str)) {
                str = this.lowNetSharpen;
            }
            this.lowNetSharpen = str;
        }

        public void setSuffix(String str) {
            this.suffix = str;
        }

        public void setUseWebp(boolean z) {
            this.useWebp = z;
        }

        public String toString() {
            return "areaName =" + this.areaName + " mUseWebp =" + this.useWebp + " mLowNetQ =" + this.lowNetQ + " mHighNetQ =" + this.highNetQ + " mLowNetSharpen =" + this.lowNetSharpen + " mHighNetSharpen =" + this.highNetSharpen + "m LowNetScale =" + this.lowNetScale + " mHighNetScale =" + this.highNetScale;
        }
    }

    /* loaded from: classes11.dex */
    public static class UriCDNInfo {
        public final String host;
        public final Uri uri;
        public final String url;

        public UriCDNInfo(String str) {
            this.url = str;
            Uri parse = Uri.parse(str);
            this.uri = parse;
            if (parse != null && parse.getHost() != null) {
                this.host = parse.getHost();
            } else {
                this.host = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        public static final TaobaoImageUrlStrategy instance = new TaobaoImageUrlStrategy();
    }

    private int binarySearch(int[] iArr, int i, boolean z) {
        int i2;
        int length = iArr.length - 1;
        int i3 = 0;
        while (i3 <= length) {
            int i4 = (i3 + length) / 2;
            if (i == iArr[i4]) {
                return i4;
            }
            if (i < iArr[i4]) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        if (length < 0) {
            return 0;
        }
        return (!z || (i2 = length + 1) > iArr.length + (-1)) ? length : i2;
    }

    private String changeUrl(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(124);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return str.replace(" ", "");
    }

    private String[] convergenceUrl(String[] strArr, String[] strArr2, String str, String str2, boolean z) {
        Uri parse;
        if (TextUtils.isEmpty(this.mDoMainDest) || TextUtils.isEmpty(str)) {
            return new String[]{str, str2};
        }
        if (str2 == null && (parse = Uri.parse(str)) != null) {
            str2 = parse.getHost();
        }
        if (str2 == null || str2.equals(this.mDoMainDest)) {
            return new String[]{str, str2};
        }
        int length = strArr2 != null ? strArr2.length : 0;
        for (int i = 0; i < length; i++) {
            if (str2.indexOf(strArr2[i]) >= 0) {
                return new String[]{str, str2};
            }
        }
        if (z) {
            int length2 = strArr != null ? strArr.length : 0;
            int i2 = 0;
            while (i2 < length2 && str2.indexOf(strArr[i2]) < 0) {
                i2++;
            }
            if (i2 >= length2) {
                return new String[]{str, str2};
            }
        }
        return new String[]{str.replaceFirst(str2, this.mDoMainDest), this.mDoMainDest};
    }

    private void decideUrlSuffix(boolean z, StringBuffer stringBuffer, String str) {
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
            z = true;
        }
        if (z) {
            stringBuffer.append(".jpg");
        }
    }

    private boolean decideUrlWH(boolean z, StringBuffer stringBuffer, ImageStrategyExtra.ImageUrlInfo imageUrlInfo, ImageStrategyConfig imageStrategyConfig, double d, double d2, int i) {
        return decideUrlWH(z, stringBuffer, imageUrlInfo, imageStrategyConfig.e(), imageStrategyConfig.c(), d, d2, i, imageStrategyConfig.b(), imageStrategyConfig.h() == null || imageStrategyConfig.h().booleanValue());
    }

    private void decideUrlWebP(StringBuffer stringBuffer, boolean z, boolean z2) {
        if (z || (z2 && this.mWebpOn && isSupportWebP())) {
            stringBuffer.append("_.webp");
        }
    }

    private boolean decideValueByNetwork(boolean z, StringBuffer stringBuffer, String str, String str2) {
        if (!isNetworkSlow()) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z) {
            stringBuffer.append('_');
        }
        stringBuffer.append(str);
        return true;
    }

    private int findBestLevel(int[] iArr, int i, int i2) {
        int length = iArr.length;
        char c = 65535;
        while (i >= 0 && i < length) {
            int i3 = iArr[i];
            if (i2 > i3) {
                if (c >= 0) {
                    if (c == 2) {
                        break;
                    }
                } else {
                    c = 1;
                }
                i++;
            } else if (i2 >= i3) {
                break;
            } else {
                if (c >= 0) {
                    if (c == 1) {
                        break;
                    }
                } else {
                    c = 2;
                }
                i--;
            }
        }
        if (i < 0) {
            i = 0;
        } else if (i >= length) {
            i = length - 1;
        } else if (c == 1 && i2 <= iArr[i - 1] * (this.mLevelRatio + 1.0f)) {
            i--;
        } else if (c == 2 && i2 > iArr[i] * (this.mLevelRatio + 1.0f)) {
            i++;
        }
        return iArr[i];
    }

    public static TaobaoImageUrlStrategy getInstance() {
        return a.instance;
    }

    private boolean isApgAllowedWithBiz(int i) {
        int[] iArr = this.mApgBizWhiteList;
        if (iArr == null || iArr.length <= 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isExcludeUrl(String[] strArr, String str, String str2) {
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (strArr != null) {
            if (str2 == null && (parse = Uri.parse(str)) != null) {
                str2 = parse.getHost();
            }
            for (String str3 : strArr) {
                if (str3.equals(str2)) {
                    return true;
                }
            }
        }
        if (this.mFuzzyExcludePath != null) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.mFuzzyExcludePath;
                if (i >= strArr2.length) {
                    break;
                } else if (str.indexOf(strArr2[i]) >= 0) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private boolean isValidSizes(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            if (i2 >= i3) {
                return false;
            }
            i++;
            i2 = i3;
        }
        return true;
    }

    private ImageSize matchWH2CDN10000(int i, int i2, int i3) {
        return matchWH2CDN10000(i, i2, i3, true);
    }

    public String decideUrl(String str, int i) {
        return decideUrl(str, i, "", CutType.non);
    }

    public float getDip() {
        return this.mDip;
    }

    public void initDip(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        if (defaultDisplay != null) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            float f = displayMetrics.density;
            this.mDip = f;
            this.mIsLowQuality = f > 2.0f;
        }
    }

    public synchronized void initImageUrlStrategy(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, HashMap<String, ServiceImageSwitch> hashMap, String str, String str2, int[] iArr7, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, boolean z, boolean z2, String str3, boolean z3) {
        this.mWebpOn = z3;
        this.mGlobalSwitch = z;
        if (z) {
            setAliCdnDomain(strArr2);
            setCdnSize(iArr);
            setCdn10000WidthSize(iArr2);
            setCdn10000HeightSize(iArr3);
            setXzCdnSize(iArr4);
            setLevelModelCdnSize(iArr5);
            setLevelModelXzCdnSize(iArr6);
            setLevelRatio(str3);
            setServiceIamgeSwitch(hashMap);
            setDoMainDest(str);
            this.mDomainSwitch = z2;
            setExactExcludeDomain(strArr3);
            setFuzzyExcludePath(strArr4);
            setExcludeDomainPath(strArr);
            this.mApgImageDomain = TextUtils.isEmpty(str2) ? APG_DOMAIN_DEST : str2;
            this.mApgBizWhiteList = iArr7;
        }
    }

    public boolean isCdnImage(UriCDNInfo uriCDNInfo) {
        return isCdnImage(uriCDNInfo.url, uriCDNInfo.host);
    }

    public boolean isDomainSwitch() {
        return this.mDomainSwitch;
    }

    public boolean isInCDN(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.mCdnSizes;
            if (i2 >= iArr.length) {
                return false;
            }
            if (iArr[i2] == i) {
                return true;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNetworkSlow() {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.mLastUpdateTime > 2000000000) {
            this.mIsNetworkSlow = n11.c() != null && n11.c().d().isNetworkSlow();
            this.mLastUpdateTime = nanoTime;
        }
        return this.mIsNetworkSlow;
    }

    public boolean isStrictCdnImage(UriCDNInfo uriCDNInfo) {
        String str = uriCDNInfo.host;
        if (!isExcludeUrl(this.mStrictCDNDomainBlackList, uriCDNInfo.url, str) && str != null) {
            int i = 0;
            while (true) {
                String[] strArr = this.mStrictCDNDomainWhiteList;
                if (i >= strArr.length) {
                    break;
                } else if (str.indexOf(strArr[i]) >= 0) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSupportWebP() {
        return n11.c() != null && n11.c().d().isSupportWebP();
    }

    public int matchSize(int i) {
        if (this.mCdnSizes.length <= 0) {
            return i;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.mCdnSizes;
            if (i2 < iArr.length - 1) {
                int i3 = iArr[i2];
                i2++;
                int i4 = iArr[i2];
                int i5 = i - i3;
                int i6 = i4 - i;
                if (i5 >= 0 && i6 >= 0) {
                    return i5 < i6 ? i3 : i4;
                }
            } else {
                return iArr[iArr.length - 1];
            }
        }
    }

    public TaobaoImageUrlStrategy setAliCdnDomain(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mLooseCDNDomainWhiteList = strArr;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setCdn10000HeightSize(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.mCdn10000Height = iArr;
        } else {
            this.mCdn10000Height = CDN10000Height;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setCdn10000WidthSize(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.mCdn10000Width = iArr;
        } else {
            this.mCdn10000Width = CDN10000Width;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setCdnSize(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.mCdnSizes = iArr;
        } else {
            this.mCdnSizes = CDN;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setDoMainDest(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDoMainDest = str;
        } else {
            this.mDoMainDest = DOMAIN_DEST;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setExactExcludeDomain(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mLooseCDNDomainBlackList = strArr;
        } else {
            this.mLooseCDNDomainBlackList = LOOSE_CDN_DOMAIN_BLACK_LIST;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setExcludeDomainPath(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mLooseConvergenceBlackList = strArr;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setFuzzyExcludePath(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mFuzzyExcludePath = strArr;
        } else {
            this.mFuzzyExcludePath = FUZZY_EXCLUDE_PATH;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setLevelModelCdnSize(int[] iArr) {
        if (isValidSizes(iArr)) {
            this.mLevelModelCdnSizes = iArr;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setLevelModelXzCdnSize(int[] iArr) {
        if (isValidSizes(iArr)) {
            this.mLevelModelXzCdnSizes = iArr;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setLevelRatio(String str) {
        try {
            this.mLevelRatio = Float.parseFloat(str);
        } catch (Exception unused) {
        }
        float f = this.mLevelRatio;
        if (f < 0.0f || f > 1.0f) {
            this.mLevelRatio = 0.1f;
        }
        return this;
    }

    public TaobaoImageUrlStrategy setServiceIamgeSwitch(HashMap<String, ServiceImageSwitch> hashMap) {
        this.mServiceImageSwitchList = hashMap;
        return this;
    }

    public TaobaoImageUrlStrategy setXzCdnSize(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.mXzCdnSizes = iArr;
        } else {
            this.mXzCdnSizes = XZCDN;
        }
        return this;
    }

    public String strictConvergenceUrl(UriCDNInfo uriCDNInfo, boolean z) {
        return convergenceUrl(this.mStrictCDNDomainWhiteList, this.mStrictConvergenceBlackList, uriCDNInfo.url, uriCDNInfo.host, z)[0];
    }

    public int taoXZCDN(int i, boolean z, boolean z2) {
        if (z2) {
            int[] iArr = this.mLevelModelXzCdnSizes;
            return findBestLevel(iArr, iArr.length / 2, i);
        }
        int[] iArr2 = this.mXzCdnSizes;
        return iArr2[binarySearch(iArr2, i, z)];
    }

    public int taobaoCDN10000Height(int i, boolean z) {
        return this.mCdn10000Height[binarySearch(this.mCdn10000Height, i, z)];
    }

    public int taobaoCDN10000Width(int i, boolean z) {
        return this.mCdn10000Width[binarySearch(this.mCdn10000Width, i, z)];
    }

    public int taobaoCDNPatten(int i, boolean z) {
        return taobaoCDNPatten(i, z, true);
    }

    public void updateStrictCDNDomainBlackList(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mStrictCDNDomainBlackList = strArr;
    }

    public void updateStrictCDNDomainWhiteList(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mStrictCDNDomainWhiteList = strArr;
    }

    public void updateStrictConvergenceBlackList(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mStrictConvergenceBlackList = strArr;
    }

    private ImageSize matchWH2CDN10000(int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        boolean z3 = true;
        if ((i == 10000 && i2 == 10000) || (i == 0 && i2 == 0)) {
            i = taobaoCDNPatten((int) (i3 * this.mDip), true, z);
            i2 = i;
        } else {
            if (i2 == 10000) {
                i = taobaoCDN10000Width((int) (i3 * this.mDip), true);
                i2 = 10000;
            } else if (i == 10000) {
                i2 = taobaoCDN10000Height((int) (i3 * this.mDip), true);
                i = 10000;
            } else {
                z2 = true;
            }
            return new ImageSize(z2, z3, i, i2);
        }
        z3 = false;
        return new ImageSize(z2, z3, i, i2);
    }

    public String decideUrl(String str, int i, String str2) {
        return decideUrl(str, i, "", CutType.non);
    }

    public boolean isCdnImage(String str) {
        return isCdnImage(str, null);
    }

    public int taobaoCDNPatten(int i, boolean z, boolean z2) {
        if (z2) {
            int[] iArr = this.mLevelModelCdnSizes;
            return findBestLevel(iArr, iArr.length / 2, i);
        }
        int[] iArr2 = this.mCdnSizes;
        return iArr2[binarySearch(iArr2, i, z)];
    }

    private boolean isCdnImage(String str, String str2) {
        Uri parse;
        if (isExcludeUrl(this.mLooseCDNDomainBlackList, str, str2)) {
            return false;
        }
        if (str2 == null && (parse = Uri.parse(str)) != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            int i = 0;
            while (true) {
                String[] strArr = this.mLooseCDNDomainWhiteList;
                if (i >= strArr.length) {
                    break;
                } else if (str2.indexOf(strArr[i]) >= 0) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    @Deprecated
    public String decideUrl(String str, int i, String str2, CutType cutType) {
        return decideUrl(str, i, str2, cutType, -1, -1, true, true, true);
    }

    private boolean decideUrlWH(boolean z, StringBuffer stringBuffer, ImageStrategyExtra.ImageUrlInfo imageUrlInfo, int i, int i2, double d, double d2, int i3, CutType cutType, boolean z2) {
        int taobaoCDNPatten;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i3 > 0) {
            double d3 = i3;
            if (!isNetworkSlow()) {
                d = d2;
            }
            i3 = (int) (d3 * d);
        }
        ImageSize imageSize = null;
        if (i3 < 0) {
            if (imageUrlInfo != null && (i6 = imageUrlInfo.width) > 0 && (i7 = imageUrlInfo.height) > 0) {
                imageSize = new ImageSize(true, false, i6, i7);
            }
        } else if (i >= 0 && i2 >= 0) {
            imageSize = matchWH2CDN10000(i, i2, i3, z2);
            imageSize.keep = false;
        } else if (imageUrlInfo != null && (i4 = imageUrlInfo.width) > 0 && (i5 = imageUrlInfo.height) > 0) {
            imageSize = matchWH2CDN10000(i4, i5, i3, z2);
        } else {
            if (cutType != null && cutType != CutType.non) {
                taobaoCDNPatten = taoXZCDN((int) (i3 * this.mDip), true, z2);
            } else {
                taobaoCDNPatten = taobaoCDNPatten((int) (i3 * this.mDip), true, z2);
            }
            imageSize = new ImageSize(taobaoCDNPatten, taobaoCDNPatten);
        }
        if (imageSize == null) {
            return false;
        }
        if (!z) {
            stringBuffer.append('_');
        }
        stringBuffer.append(imageSize.width);
        stringBuffer.append('x');
        stringBuffer.append(imageSize.height);
        if (imageSize.keep && imageUrlInfo != null) {
            stringBuffer.append(imageUrlInfo.cj);
        } else if (!imageSize.limitWH && cutType != null) {
            stringBuffer.append(cutType.getCutType());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String decideUrl(java.lang.String r26, int r27, com.taobao.tao.image.ImageStrategyConfig r28) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.util.TaobaoImageUrlStrategy.decideUrl(java.lang.String, int, com.taobao.tao.image.ImageStrategyConfig):java.lang.String");
    }

    /* loaded from: classes11.dex */
    public static class ImageSize {
        public int height;
        public boolean keep;
        public boolean limitWH;
        public int width;

        public ImageSize(boolean z, boolean z2, int i, int i2) {
            this.keep = z;
            this.limitWH = z2;
            this.width = i;
            this.height = i2;
        }

        public ImageSize(int i, int i2) {
            this(false, false, i, i2);
        }
    }

    public String[] convergenceUrl(UriCDNInfo uriCDNInfo, boolean z) {
        return convergenceUrl(this.mLooseCDNDomainWhiteList, this.mLooseConvergenceBlackList, uriCDNInfo.url, uriCDNInfo.host, z);
    }

    public boolean isExcludeUrl(String str) {
        return isExcludeUrl(this.mLooseCDNDomainBlackList, str, null);
    }

    public String convergenceUrl(String str) {
        return convergenceUrl(this.mLooseCDNDomainWhiteList, this.mLooseConvergenceBlackList, str, null, true)[0];
    }

    @Deprecated
    public String decideUrl(String str, int i, String str2, CutType cutType, int i2, int i3, boolean z, boolean z2, boolean z3) {
        String str3;
        String str4;
        boolean z4;
        String str5;
        double d;
        double d2;
        String str6;
        String str7;
        StringBuffer stringBuffer;
        String str8;
        boolean z5;
        ServiceImageSwitch serviceImageSwitch;
        String str9;
        if (str == null) {
            qb1.e(qb1.COMMON_TAG, "origin url is null", new Object[0]);
            return null;
        }
        String changeUrl = changeUrl(str);
        UriCDNInfo uriCDNInfo = new UriCDNInfo(changeUrl);
        if (OssImageUrlStrategy.getInstance().isOssDomain(uriCDNInfo.host)) {
            return OssImageUrlStrategy.getInstance().decideUrl(changeUrl, i, ImageStrategyConfig.o("default").a());
        }
        if (!isCdnImage(uriCDNInfo)) {
            qb1.g(qb1.COMMON_TAG, "origin not cdn url:%s", changeUrl);
            return changeUrl;
        }
        if (this.mDomainSwitch) {
            changeUrl = convergenceUrl(uriCDNInfo, false)[0];
        }
        String str10 = changeUrl;
        ImageStrategyExtra.ImageUrlInfo baseUrlInfo = ImageStrategyExtra.getBaseUrlInfo(str10);
        if (baseUrlInfo.base.endsWith("_sum.jpg")) {
            baseUrlInfo.base = baseUrlInfo.base.substring(0, str9.length() - 8);
        } else if (baseUrlInfo.base.endsWith("_m.jpg") || baseUrlInfo.base.endsWith("_b.jpg")) {
            baseUrlInfo.base = baseUrlInfo.base.substring(0, str3.length() - 6);
        }
        ImageStrategyExtra.parseImageUrl(baseUrlInfo.base, baseUrlInfo);
        StringBuffer stringBuffer2 = new StringBuffer(baseUrlInfo.base.length() + 27);
        stringBuffer2.append(baseUrlInfo.base);
        String imageQuality = (this.mIsLowQuality ? ImageQuality.q50 : ImageQuality.q75).getImageQuality();
        String imageQuality2 = (this.mIsLowQuality ? ImageQuality.q75 : ImageQuality.q90).getImageQuality();
        ImageSharpen imageSharpen = ImageSharpen.non;
        String imageSharpen2 = imageSharpen.getImageSharpen();
        String imageSharpen3 = imageSharpen.getImageSharpen();
        if (!this.mGlobalSwitch || this.mServiceImageSwitchList == null || TextUtils.isEmpty(str2) || (serviceImageSwitch = this.mServiceImageSwitchList.get(str2)) == null || !z3) {
            str4 = "";
            z4 = z;
            str5 = imageSharpen3;
            d = 1.0d;
            d2 = 0.7d;
            str6 = imageQuality;
            str7 = imageQuality2;
        } else {
            boolean isUseWebp = serviceImageSwitch.isUseWebp();
            String lowNetQ = serviceImageSwitch.getLowNetQ();
            String highNetQ = serviceImageSwitch.getHighNetQ();
            imageSharpen2 = serviceImageSwitch.getLowNetSharpen();
            str5 = serviceImageSwitch.getHighNetSharpen();
            double lowNetScale = serviceImageSwitch.getLowNetScale();
            double highNetScale = serviceImageSwitch.getHighNetScale();
            str4 = serviceImageSwitch.getSuffix();
            d = highNetScale;
            z4 = isUseWebp;
            d2 = lowNetScale;
            str6 = lowNetQ;
            str7 = highNetQ;
        }
        String str11 = str4;
        String str12 = imageSharpen2;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        boolean decideUrlWH = decideUrlWH(false, stringBuffer2, baseUrlInfo, i2, i3, d2, d, i, cutType, true);
        if (z2) {
            stringBuffer = stringBuffer2;
            decideUrlWH = decideValueByNetwork(decideUrlWH, stringBuffer, str14, str15) || decideUrlWH;
        } else {
            stringBuffer = stringBuffer2;
        }
        if (decideValueByNetwork(decideUrlWH, stringBuffer, str12, str13) || decideUrlWH) {
            str8 = str11;
            z5 = true;
        } else {
            str8 = str11;
            z5 = false;
        }
        decideUrlSuffix(z5, stringBuffer, str8);
        decideUrlWebP(stringBuffer, false, z4 && !baseUrlInfo.suffix.contains("imgwebptag=0"));
        stringBuffer.append(baseUrlInfo.suffix);
        String stringBuffer3 = stringBuffer.toString();
        if (qb1.f(qb1.LEVEL_D)) {
            qb1.a(qb1.COMMON_TAG, "[Non-Config] Dip=%.1f UISize=%d Area=%s\nOriginUrl=%s\nDecideUrl=%s", Float.valueOf(this.mDip), Integer.valueOf(i), str2, str10, stringBuffer3);
        }
        return stringBuffer3;
    }
}
