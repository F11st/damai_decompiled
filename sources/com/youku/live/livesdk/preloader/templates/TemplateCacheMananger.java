package com.youku.live.livesdk.preloader.templates;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IRemoteConfig;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.livesdk.preloader.templates.t9.v000200010000;
import com.youku.live.widgets.model.template.TemplateModel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TemplateCacheMananger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CONFIG_ENABLE = "1";
    private static final String ORANGE_NAMESPACE_YKLIVEROOM_ABTEST = "YKLiveRoom_ABTest";
    private static final String SUPPORT_ORANGE_TEMPLATE_CACHE = "supportOrangeTemplateCache";
    private static TemplateCacheMananger sInstance;
    private volatile boolean isInit = false;
    private Map<String, Map<String, ITemplate>> mCaches;

    TemplateCacheMananger() {
        initCaches();
    }

    private Map<String, Map<String, ITemplate>> getCaches() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70676269")) {
            return (Map) ipChange.ipc$dispatch("70676269", new Object[]{this});
        }
        if (this.mCaches == null) {
            synchronized (this) {
                if (this.mCaches == null) {
                    this.mCaches = new ConcurrentHashMap();
                }
            }
        }
        return this.mCaches;
    }

    public static TemplateCacheMananger getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762088293")) {
            return (TemplateCacheMananger) ipChange.ipc$dispatch("-762088293", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (TemplateCacheMananger.class) {
                if (sInstance == null) {
                    sInstance = new TemplateCacheMananger();
                }
            }
        }
        return sInstance;
    }

    private void initCaches() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528182870")) {
            ipChange.ipc$dispatch("-528182870", new Object[]{this});
            return;
        }
        Map<String, Map<String, ITemplate>> caches = getCaches();
        if (caches != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("2.2.3", v000200010000.getInstance());
            caches.put("9", concurrentHashMap);
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            concurrentHashMap2.put("2.2.3", com.youku.live.livesdk.preloader.templates.t35.v000200010000.getInstance());
            caches.put("35", concurrentHashMap2);
            ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
            concurrentHashMap3.put("2.2.3", com.youku.live.livesdk.preloader.templates.t44.v000200010000.getInstance());
            caches.put("44", concurrentHashMap3);
        }
    }

    private void initWithOrangeCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136328993")) {
            ipChange.ipc$dispatch("1136328993", new Object[]{this});
        } else if (OptConfigUtils.getConfig(SUPPORT_ORANGE_TEMPLATE_CACHE, true)) {
            OrangeTemplateCache.getInstance().updateWithCaches(getCaches());
        }
    }

    public String getLayout(String str, String str2, boolean z) {
        String string;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736082561")) {
            return (String) ipChange.ipc$dispatch("-736082561", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        Map<String, ITemplate> map = getCaches().get(str);
        ITemplate iTemplate = map != null ? map.get(str2) : null;
        if (iTemplate != null) {
            if (z) {
                return iTemplate.getLandscapeLayout();
            }
            return iTemplate.getPortraitLayout();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("layout_");
            sb.append("templateId_");
            sb.append(str);
            sb.append(JSMethod.NOT_SET);
            sb.append("sdkVersion_");
            sb.append(str2.replace(".", JSMethod.NOT_SET));
            sb.append(JSMethod.NOT_SET);
            sb.append("orientation_");
            sb.append(z ? "landscape" : "portrait");
            string = ((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", sb.toString(), null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public TemplateModel getTemplateModel(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-672836272")) {
            return (TemplateModel) ipChange.ipc$dispatch("-672836272", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        Map<String, ITemplate> map = getCaches().get(str);
        ITemplate iTemplate = map != null ? map.get(str2) : null;
        if (iTemplate != null) {
            if (z) {
                return iTemplate.getLandscapeModel();
            }
            return iTemplate.getPortraitModel();
        }
        return null;
    }

    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1109237477")) {
            ipChange.ipc$dispatch("-1109237477", new Object[]{this});
        } else if (this.isInit) {
        } else {
            this.isInit = true;
            com.youku.live.livesdk.preloader.templates.t35.v000200010000.getInstance().init();
            com.youku.live.livesdk.preloader.templates.t44.v000200010000.getInstance().init();
            v000200010000.getInstance().init();
            initWithOrangeCache();
        }
    }

    public TemplateCacheMananger updateTemplate(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1427112607") ? (TemplateCacheMananger) ipChange.ipc$dispatch("1427112607", new Object[]{this, str, str2, str3, str4}) : updateTemplate(str, str2, str3, str4, null, null);
    }

    public TemplateCacheMananger updateTemplate(String str, String str2, String str3, String str4, TemplateModel templateModel, TemplateModel templateModel2) {
        Map<String, ITemplate> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1570649951")) {
            return (TemplateCacheMananger) ipChange.ipc$dispatch("1570649951", new Object[]{this, str, str2, str3, str4, templateModel, templateModel2});
        }
        if ("1".equals(((IRemoteConfig) Dsl.getService(IRemoteConfig.class)).getString("YKLiveRoom_ABTest", "LayoutCachesUpdate", "1"))) {
            Map<String, Map<String, ITemplate>> caches = getCaches();
            if (caches.containsKey(str)) {
                map = caches.get(str);
            } else {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                caches.put(str, concurrentHashMap);
                map = concurrentHashMap;
            }
            if (map != null) {
                map.put(str2, new AbsTemplate(str3, str4, templateModel, templateModel2));
            }
            return this;
        }
        return this;
    }
}
