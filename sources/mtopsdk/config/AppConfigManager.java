package mtopsdk.config;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.SymbolExpUtil;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.cache.domain.ApiCacheDo;
import mtopsdk.mtop.cache.domain.AppConfigDo;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppConfigManager {
    private static final String CACEH_KEY_TYPE = "kt=";
    private static final String CACHE_KEY_LIST = "ks=";
    private static final String FILE_DIR_MTOP = "/mtop";
    private static final String FILE_NAME_API_CACHE_CONFIG = "apiCacheConf";
    private static final String FILE_NAME_APP_CONFIG = "appConf";
    private static final String TAG = "mtopsdk.AppConfigManager";
    private static AppConfigManager instance;
    ConcurrentHashMap<String, ApiCacheDo> apiCacheGroup = new ConcurrentHashMap<>();
    private Set<String> tradeUnitApiSet = new HashSet();

    public static AppConfigManager getInstance() {
        if (instance == null) {
            synchronized (AppConfigManager.class) {
                if (instance == null) {
                    instance = new AppConfigManager();
                }
            }
        }
        return instance;
    }

    public void addApiCacheDoToGroup(String str, ApiCacheDo apiCacheDo) {
        if (StringUtils.isBlank(str) || apiCacheDo == null) {
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d(TAG, "[addApiCacheDoToGroup] apiCacheDo:" + apiCacheDo);
        }
        this.apiCacheGroup.put(str, apiCacheDo);
    }

    public ApiCacheDo getApiCacheDoByKey(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return this.apiCacheGroup.get(str);
    }

    public boolean isTradeUnitApi(String str) {
        return this.tradeUnitApiSet.contains(str);
    }

    public boolean parseAppConfig(@NonNull String str, String str2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("clientCache");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("clientCacheAppConfList")) == null) {
                return false;
            }
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(length);
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("api");
                    String optString2 = optJSONObject2.optString("v");
                    String optString3 = optJSONObject2.optString("block");
                    String concatStr2LowerCase = StringUtils.concatStr2LowerCase(optString, optString2);
                    ApiCacheDo apiCacheDoByKey = getInstance().getApiCacheDoByKey(concatStr2LowerCase);
                    if (apiCacheDoByKey != null) {
                        apiCacheDoByKey.blockName = optString3;
                    } else {
                        getInstance().addApiCacheDoToGroup(concatStr2LowerCase, new ApiCacheDo(optString, optString2, optString3));
                    }
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("unit");
            if (optJSONObject3 != null && (optJSONArray2 = optJSONObject3.optJSONArray("tradeUnitApiList")) != null) {
                HashSet hashSet = new HashSet();
                for (int length2 = optJSONArray2.length() - 1; length2 >= 0; length2--) {
                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(length2);
                    if (optJSONObject4 != null) {
                        hashSet.add(StringUtils.concatStr2LowerCase(optJSONObject4.optString("api"), optJSONObject4.optString("v")));
                    }
                }
                this.tradeUnitApiSet = hashSet;
            }
            return true;
        } catch (Exception e) {
            TBSdkLog.e(TAG, str2, "[parseAppConfig]parse appConf node error.", e);
            return false;
        }
    }

    public void parseCacheControlHeader(@NonNull String str, @NonNull ApiCacheDo apiCacheDo) {
        if (str == null || apiCacheDo == null) {
            return;
        }
        String[] split = str.split(",");
        int length = split.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            String str2 = split[i];
            try {
                if (HttpHeaderConstant.OFFLINE_FLAG_ON.equalsIgnoreCase(str2)) {
                    apiCacheDo.offline = true;
                } else if (HttpHeaderConstant.PRIVATE_FLAG_FALSE.equalsIgnoreCase(str2)) {
                    apiCacheDo.privateScope = z;
                } else if (str2.contains(CACEH_KEY_TYPE)) {
                    String substring = str2.substring(3);
                    char c = 65535;
                    switch (substring.hashCode()) {
                        case 64897:
                            if (substring.equals("ALL")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 69104:
                            if (substring.equals(ApiCacheDo.CacheKeyType.EXC)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 72638:
                            if (substring.equals(ApiCacheDo.CacheKeyType.INC)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 2402104:
                            if (substring.equals("NONE")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    if (c == 0) {
                        apiCacheDo.cacheKeyType = "ALL";
                    } else if (c == 1) {
                        apiCacheDo.cacheKeyType = "NONE";
                    } else if (c == 2) {
                        apiCacheDo.cacheKeyType = ApiCacheDo.CacheKeyType.INC;
                    } else if (c == 3) {
                        apiCacheDo.cacheKeyType = ApiCacheDo.CacheKeyType.EXC;
                    }
                } else {
                    if (str2.contains(CACHE_KEY_LIST)) {
                        apiCacheDo.cacheKeyItems = Arrays.asList(str2.substring(3).split(SymbolExpUtil.SYMBOL_VERTICALBAR));
                    }
                    apiCacheDo.cacheControlHeader = str;
                }
            } catch (Exception unused) {
                TBSdkLog.w(TAG, "[parseCacheControlHeader] parse item in CacheControlHeader error.item =" + str2 + ",CacheControlHeader=" + str);
            }
            i++;
            z = false;
        }
    }

    public void reloadAppConfig(MtopConfig mtopConfig) {
        if (mtopConfig == null) {
            return;
        }
        try {
            File file = new File(mtopConfig.context.getExternalFilesDir(null).getAbsoluteFile() + FILE_DIR_MTOP);
            AppConfigDo appConfigDo = (AppConfigDo) MtopUtils.readObject(file, FILE_NAME_APP_CONFIG);
            if (appConfigDo != null && StringUtils.isNotBlank(appConfigDo.appConf) && appConfigDo.appConfigVersion > mtopConfig.xAppConfigVersion) {
                synchronized (mtopConfig.lock) {
                    if (appConfigDo.appConfigVersion > mtopConfig.xAppConfigVersion && getInstance().parseAppConfig(appConfigDo.appConf, "")) {
                        mtopConfig.xAppConfigVersion = appConfigDo.appConfigVersion;
                        TBSdkLog.i(TAG, "[reloadAppConfig] reload appConf succeed. appConfVersion=" + mtopConfig.xAppConfigVersion);
                    }
                }
            }
            Map map = (Map) MtopUtils.readObject(file, FILE_NAME_API_CACHE_CONFIG);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    ApiCacheDo apiCacheDo = (ApiCacheDo) entry.getValue();
                    ApiCacheDo apiCacheDo2 = this.apiCacheGroup.get(str);
                    if (apiCacheDo2 == null) {
                        this.apiCacheGroup.put(str, apiCacheDo);
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i(TAG, "[reloadAppConfig] add apiCacheDo config,apiKey=" + str);
                        }
                    } else if (!apiCacheDo2.equals(apiCacheDo)) {
                        apiCacheDo2.cacheControlHeader = apiCacheDo.cacheControlHeader;
                        apiCacheDo2.privateScope = apiCacheDo.privateScope;
                        apiCacheDo2.offline = apiCacheDo.offline;
                        apiCacheDo2.cacheKeyType = apiCacheDo.cacheKeyType;
                        apiCacheDo2.cacheKeyItems = apiCacheDo.cacheKeyItems;
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i(TAG, "[reloadAppConfig] update apiCacheDo config,apiKey=" + str);
                        }
                    }
                }
            }
        } catch (Exception unused) {
            TBSdkLog.e(TAG, "[reloadAppConfig] reload appConf file error.");
        }
    }

    public void storeApiCacheDoMap(final Context context, final String str) {
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.config.AppConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MtopUtils.writeObject(AppConfigManager.this.apiCacheGroup, new File(context.getExternalFilesDir(null).getAbsoluteFile() + AppConfigManager.FILE_DIR_MTOP), AppConfigManager.FILE_NAME_API_CACHE_CONFIG);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i(AppConfigManager.TAG, str, "[storeApiCacheDoMap] save apiCacheConf succeed.");
                    }
                } catch (Exception e) {
                    TBSdkLog.e(AppConfigManager.TAG, str, "[storeApiCacheDoMap] save apiCacheConf error.", e);
                }
            }
        });
    }
}
