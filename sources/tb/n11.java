package tb;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.image.IImageExtendedSupport;
import com.taobao.tao.image.IImageStrategySupport;
import com.taobao.tao.image.ImageStrategyConfig;
import com.taobao.tao.util.OssImageUrlStrategy;
import com.taobao.tao.util.TaobaoImageUrlStrategy;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n11 {
    public static final String ALI_CDN_DOMAIN = "aliCdnDomain";
    public static final String APG_BUSINESS_WHITE_LIST = "apgBizWhiteList";
    public static final String APG_IMAGE_DOMAIN = "apgImageDomain";
    public static final String CDN_10000_HEIGHT = "cdn10000Height";
    public static final String CDN_10000_WIDTH = "cdn10000Width";
    public static final String CDN_IMAGE_SIZE = "cdnImageSizes";
    public static final String CONVERT_EXCLUDE_PATH = "domainConvertExcludePath";
    public static final String DOMAIN_DEST = "domainDest";
    public static final String DOMAIN_SWITCH = "domainSwitch";
    public static final String EXACT_EXCLUDE_DOMAIN = "exactExcludeDomain";
    public static final String FUZZY_EXCLUDE_PATH = "fuzzyExcludePath";
    public static final String GLOBAL_SWITCH = "globalSwitch";
    public static final String IMAGE_CONFIG = "android_image_strategy_config";
    public static final String IMAGE_STRATEGY = "image_strategy";
    public static final String LEVEL_MODEL_SIZES = "levelModelImageSizes";
    public static final String LEVEL_MODEL_XZSIZES = "levelModelXZImageSizes";
    public static final String LEVEL_RATIO = "levelRatio";
    public static final String MODULES = "modules";
    public static final String OSS_CDN_DOMAIN = "ossCdnDomain";
    public static final String OSS_FUZZY_EXCLUDE = "ossFuzzyExclude";
    public static final String STRICT_ALI_CDN_DOMAIN = "strictCDNDomainWL";
    public static final String STRICT_CONVERT_EXCLUDE_PATH = "strictDomainConvertBL";
    public static final String STRICT_EXACT_EXCLUDE_DOMAIN = "strictExactDomainBL";
    public static final String XZ_CDN_IMAGE_SIZE = "xzcdnImageSizes";
    private static HashMap<String, String> c;
    private static n11 d;
    private IImageStrategySupport a;
    private IImageExtendedSupport b;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        c = hashMap;
        hashMap.put(GLOBAL_SWITCH, "1");
        c.put(DOMAIN_SWITCH, "1");
        c.put("modules", "default,search,detail,shop,weitao,weapp,weappsharpen,bala,home,tbchannel");
        c.put("default", "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q75\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put("search", "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put("detail", "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.SHOP, "{ \"highNetQ\": \"q75\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"s150\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.WEITAO, "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q75\", \"highNetSharpen\": \"s110\", \"lowNetSharpen\": \"s110\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.WEAPP, "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.WEAPPSHARPEN, "{ \"highNetQ\": \"q75\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"s150\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.BALA, "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put("home", "{ \"highNetQ\": \"q90\", \"lowNetQ\": \"q50\", \"highNetSharpen\": \"\", \"lowNetSharpen\": \"\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        c.put(ImageStrategyConfig.TBCHANNEL, "{ \"highNetQ\": \"q50\", \"lowNetQ\": \"q30\", \"highNetSharpen\": \"s150\", \"lowNetSharpen\": \"s150\", \"highNetScale\": \"1\", \"lowNetScale\": \"1\", \"useWebP\": 1 }");
        d = null;
    }

    public n11(Application application, IImageStrategySupport iImageStrategySupport) {
        this.a = iImageStrategySupport;
        TaobaoImageUrlStrategy.getInstance().initDip(application);
        qb1.e(qb1.COMMON_TAG, "construct ImageInitBusinss with IImageStrategySupport(webp support:%b)", Boolean.valueOf(this.a.isSupportWebP()));
    }

    private HashMap<String, TaobaoImageUrlStrategy.ServiceImageSwitch> a(String[] strArr) {
        HashMap<String, TaobaoImageUrlStrategy.ServiceImageSwitch> hashMap = new HashMap<>();
        for (String str : strArr) {
            String configString = this.a.getConfigString(IMAGE_CONFIG, str, c.get(str));
            if (!TextUtils.isEmpty(configString)) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = JSON.parseObject(configString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (jSONObject != null) {
                    TaobaoImageUrlStrategy.ServiceImageSwitch serviceImageSwitch = new TaobaoImageUrlStrategy.ServiceImageSwitch();
                    serviceImageSwitch.setAreaName(str);
                    serviceImageSwitch.setUseWebp(g(jSONObject.getString("useWebP")));
                    serviceImageSwitch.setHighNetQ(jSONObject.getString("highNetQ"));
                    serviceImageSwitch.setLowNetQ(jSONObject.getString("lowNetQ"));
                    serviceImageSwitch.setHighNetSharpen(jSONObject.getString("highNetSharpen"));
                    serviceImageSwitch.setLowNetSharpen(jSONObject.getString("lowNetSharpen"));
                    serviceImageSwitch.setHighNetScale(h(jSONObject.getString("highNetScale")));
                    serviceImageSwitch.setLowNetScale(h(jSONObject.getString("lowNetScale")));
                    hashMap.put(str, serviceImageSwitch);
                }
            }
        }
        return hashMap;
    }

    public static n11 c() {
        return d;
    }

    public static n11 e(Application application, IImageStrategySupport iImageStrategySupport) {
        if (d == null) {
            d = new n11(application, iImageStrategySupport);
        }
        return d;
    }

    private boolean g(String str) {
        return "true".equals(str) || "1".equals(str);
    }

    private double h(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 1.0d;
        }
    }

    private int i(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        int length = split.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = i(split[i]);
        }
        return iArr;
    }

    private String[] k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    public IImageExtendedSupport b() {
        return this.b;
    }

    public IImageStrategySupport d() {
        return this.a;
    }

    @SuppressLint({"NewApi"})
    public synchronized void f() {
        String configString = this.a.getConfigString(IMAGE_CONFIG, CDN_IMAGE_SIZE, "");
        String configString2 = this.a.getConfigString(IMAGE_CONFIG, CDN_10000_WIDTH, "");
        String configString3 = this.a.getConfigString(IMAGE_CONFIG, CDN_10000_HEIGHT, "");
        String configString4 = this.a.getConfigString(IMAGE_CONFIG, XZ_CDN_IMAGE_SIZE, "");
        String configString5 = this.a.getConfigString(IMAGE_CONFIG, LEVEL_MODEL_SIZES, "");
        String configString6 = this.a.getConfigString(IMAGE_CONFIG, LEVEL_MODEL_XZSIZES, "");
        String configString7 = this.a.getConfigString(IMAGE_CONFIG, DOMAIN_DEST, "");
        String configString8 = this.a.getConfigString(IMAGE_CONFIG, ALI_CDN_DOMAIN, "");
        String configString9 = this.a.getConfigString(IMAGE_CONFIG, OSS_CDN_DOMAIN, "");
        String configString10 = this.a.getConfigString(IMAGE_CONFIG, EXACT_EXCLUDE_DOMAIN, "");
        String configString11 = this.a.getConfigString(IMAGE_CONFIG, FUZZY_EXCLUDE_PATH, "");
        String configString12 = this.a.getConfigString(IMAGE_CONFIG, OSS_FUZZY_EXCLUDE, "");
        String configString13 = this.a.getConfigString(IMAGE_CONFIG, CONVERT_EXCLUDE_PATH, "");
        String configString14 = this.a.getConfigString(IMAGE_CONFIG, LEVEL_RATIO, "");
        String configString15 = this.a.getConfigString(IMAGE_CONFIG, DOMAIN_SWITCH, c.get(DOMAIN_SWITCH));
        String configString16 = this.a.getConfigString(IMAGE_CONFIG, GLOBAL_SWITCH, c.get(GLOBAL_SWITCH));
        String configString17 = this.a.getConfigString(IMAGE_CONFIG, APG_IMAGE_DOMAIN, "");
        String configString18 = this.a.getConfigString(IMAGE_CONFIG, APG_BUSINESS_WHITE_LIST, "");
        String configString19 = this.a.getConfigString(IMAGE_CONFIG, "modules", c.get("modules"));
        String configString20 = this.a.getConfigString(IMAGE_CONFIG, STRICT_ALI_CDN_DOMAIN, "");
        String configString21 = this.a.getConfigString(IMAGE_CONFIG, STRICT_EXACT_EXCLUDE_DOMAIN, "");
        String configString22 = this.a.getConfigString(IMAGE_CONFIG, STRICT_CONVERT_EXCLUDE_PATH, "");
        TaobaoImageUrlStrategy.getInstance().initImageUrlStrategy(j(configString), j(configString2), j(configString3), j(configString4), j(configString5), j(configString6), a(k(configString19)), configString7, configString17, j(configString18), k(configString13), k(configString8), k(configString10), k(configString11), g(configString16), g(configString15), configString14, true);
        OssImageUrlStrategy.getInstance().setupConfigs(k(configString9), k(configString12));
        TaobaoImageUrlStrategy.getInstance().updateStrictCDNDomainWhiteList(k(configString20));
        TaobaoImageUrlStrategy.getInstance().updateStrictCDNDomainBlackList(k(configString21));
        TaobaoImageUrlStrategy.getInstance().updateStrictConvergenceBlackList(k(configString22));
        qb1.e(qb1.COMMON_TAG, "orange notify(%s) update\ncdnImageSize:%s\ncdn10000Width:%s\ncdn10000Height:%s\nxzCdnSize:%s\nlevelModelSizes:%s\nlevelModelXzSizes:%s\ndomainDest:%s\napgDomain:%s\napgBizWL:%s\ndomainSwitch:%s\nglobalSwitch:%s\naliCdnDomain:%s\nexactExcludePath:%s\nfuzzyExcludePath:%s\nconvertExcludePath:%s\nmodules:%s\nlevelRatio:%s\nossCdnDomains:%s\nossFuzzyExcludes:%s\nstrictCDNDomainWL:%s\nstrictExactDomainBL:%s\nstrictDomainConvertBL:%s", IMAGE_CONFIG, configString, configString2, configString3, configString4, configString5, configString6, configString7, configString17, configString18, configString15, configString16, configString8, configString10, configString11, configString13, configString19, configString14, configString9, configString12, configString20, configString21, configString22);
    }
}
