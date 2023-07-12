package com.youku.gaiax.impl.register;

import android.os.SystemClock;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.weex.common.Constants;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.extension.UCCore;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.api.proxy.IProxyNet;
import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.api.proxy.IProxySource;
import com.youku.gaiax.api.proxy.IProxyTask;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.GaiaXStableApiImpl;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteCacheUtils;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteSourceUtils;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteVersionUtils;
import com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity;
import com.youku.gaiax.impl.utils.ConfigUtils;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.k;
import kotlin.jvm.functions.Function0;
import org.apache.commons.net.SocketClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.eq0;
import tb.k50;
import tb.ns0;
import tb.wt2;
import tb.yq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\b\u0016\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J \u0010-\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\"01J\u0016\u00103\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0016\u00104\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0006\u00105\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u0016\u00107\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u000e\u00108\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u00109\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0016\u00109\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fJ\u0006\u0010:\u001a\u00020\fJ\u0006\u0010;\u001a\u00020\u0002J\u0092\u0001\u0010K\u001a\u0004\u0018\u00010\u001d2\u0006\u0010+\u001a\u00020\f2\u0006\u0010<\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0016J\u0010\u0010L\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010M\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"H\u0016J(\u0010P\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010N\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\fH\u0016J0\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010+\u001a\u00020\f2\u0006\u0010<\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0016J8\u0010R\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\"2\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\fH\u0016J\b\u0010S\u001a\u00020\u0002H\u0016R\u0016\u0010T\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010X\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010UR(\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0Z0Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020%8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010^R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020\f0`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateSource;", "Ltb/wt2;", "initRemoteCacheDirectory", "resetNetTimestamp", "", "getNetTimestamp", "finalTimestamp", "setNetTimestamp", "getAppVersion", "appVersion", "setAppVersion", "", "env", "setAppEnv", "getAppEnv", "templateBiz", "Lcom/alibaba/fastjson/JSONArray;", "templatesId", "requestTemplates", "templates", "", "autoLoadDepend", "processTemplatesData", "layer", "autoLoadDependTemplates", "Ltb/ns0;", "gxTemplate", "addTemplateToCache", "Lcom/youku/gaiax/impl/register/remote/IGaiaXRemoteTemplateEntity;", "entity", "createTemplateFromBinary", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "", "writeTemplateToLocal", "templateReleaseStatus", "", "getTargetStatus", "initLocalTemplateSource", "timestamp", "requestAllTemplate", "initRemoteTemplateSource", "templateId", "result", "fillPrepareTemplate", "Lcom/alibaba/gaiax/GXTemplateEngine$i;", "gxTemplateItem", "getTemplate", "", "getAllRemoteTemplatesInMemory", "getRemoteTemplateFromDB", "getRemoteTemplateVersion", "launchDB", "launchRemote", "templateExistWithRemote", "requestRemoteTemplatesWithAsync", "requestRemoteTemplatesWithSync", "getRemoteGaiaXCachePath", "cleanRemoteTemplates", "templateVersion", "templatePlatform", "templateDesc", "templateResourceUrl", "templateLocalUrl", "templatePriority", "templateSupportMinVersion", "templateSupportMaxVersion", "templateCreateTime", "templateModifyTime", "templateCreateEmpId", "templateModifyEmpId", "templateStatus", "templateExtInfo", "templateFileType", "createTemplateEntity", "insertTemplateEntity", "getAll", "status", "platform", "getAllWithStatusAndAppVersion", "getTemplateEntityWithStatus", "getTemplateEntityWithStatusAndAppVersion", "clearAllToDB", "isHaveEmptyResult", "Z", "isHaveParseError", "isSyncNetTemplate", "isSyncLocalTemplate", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "remoteTemplateCache", "Ljava/util/concurrent/ConcurrentHashMap;", "pageNum", "I", Constants.Name.PAGE_SIZE, "", "remoteCheckCache", "Ljava/util/Set;", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GXExtensionTemplateRemoteSource implements GXRegisterCenter.GXIExtensionTemplateSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GXExtensionTemplateRemoteSource> instance$delegate;
    private boolean isHaveEmptyResult;
    private boolean isHaveParseError;
    private volatile boolean isSyncLocalTemplate;
    private volatile boolean isSyncNetTemplate;
    private int pageNum;
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<ns0>> remoteTemplateCache = new ConcurrentHashMap<>();
    private final int pageSize = 50;
    @NotNull
    private final Set<String> remoteCheckCache = new LinkedHashSet();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource$Companion;", "", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "remoteInstance", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "instance", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GXExtensionTemplateRemoteSource getInstance() {
            return (GXExtensionTemplateRemoteSource) GXExtensionTemplateRemoteSource.instance$delegate.getValue();
        }

        @NotNull
        public final GXExtensionTemplateRemoteSource remoteInstance() {
            IProxySource source = GaiaXProxy.Companion.getInstance().getSource();
            GXExtensionTemplateRemoteSource remoteTemplateSource = source == null ? null : source.getRemoteTemplateSource();
            return remoteTemplateSource == null ? getInstance() : remoteTemplateSource;
        }
    }

    static {
        Lazy<GXExtensionTemplateRemoteSource> b;
        b = b.b(new Function0<GXExtensionTemplateRemoteSource>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GXExtensionTemplateRemoteSource invoke() {
                return new GXExtensionTemplateRemoteSource();
            }
        });
        instance$delegate = b;
    }

    public GXExtensionTemplateRemoteSource() {
        initRemoteCacheDirectory();
    }

    private final void addTemplateToCache(ns0 ns0Var) {
        if (ns0Var != null) {
            CopyOnWriteArraySet<ns0> copyOnWriteArraySet = this.remoteTemplateCache.get(ns0Var.a());
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.remoteTemplateCache.put(ns0Var.a(), copyOnWriteArraySet);
            }
            copyOnWriteArraySet.add(ns0Var);
            Log log = Log.INSTANCE;
            if (log.isLaunchLog()) {
                log.d("[GaiaX]", "addTemplateToCache() called with: gxTemplate = " + ns0Var + " remoteTemplateCache = " + this.remoteTemplateCache.size() + " bizTemplates = " + copyOnWriteArraySet.size());
            }
        }
    }

    private final void autoLoadDependTemplates(String str, String str2) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = JSON.parseObject(str2).getJSONObject("package");
            if (jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject("dependencies")) == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                jSONArray.add(entry.getKey());
            }
            if (!jSONArray.isEmpty()) {
                requestTemplates(str, jSONArray);
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    private final ns0 createTemplateFromBinary(IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity) {
        File file = new File(iGaiaXRemoteTemplateEntity.getLocalPath());
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", b41.r("GaiaX远程模板初始化逻辑 - createTemplateFromBinary - start - ", file.getAbsolutePath()));
        }
        eq0 eq0Var = eq0.INSTANCE;
        File absoluteFile = file.getAbsoluteFile();
        b41.h(absoluteFile, "file.absoluteFile");
        JSONObject b = eq0Var.b(absoluteFile);
        ns0 ns0Var = new ns0(iGaiaXRemoteTemplateEntity.getTemplateId(), iGaiaXRemoteTemplateEntity.getTemplateBiz(), iGaiaXRemoteTemplateEntity.getTemplateVersion(), yq0.g(b, "layer"), yq0.g(b, "css"), yq0.g(b, "databinding"), yq0.g(b, "js"));
        ns0Var.i("remote");
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", b41.r("GaiaX远程模板初始化逻辑 - createTemplateFromBinary - end - ", ns0Var));
        }
        return ns0Var;
    }

    private final void fillPrepareTemplate(String str, String str2, JSONArray jSONArray) {
        GXTemplateInfo gXTemplateInfo;
        List<GXTemplateInfo> k;
        CopyOnWriteArraySet<ns0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        Object obj = null;
        if (copyOnWriteArraySet != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : copyOnWriteArraySet) {
                if (b41.d(((ns0) obj2).d(), str2)) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int h = ((ns0) obj).h();
                    do {
                        Object next = it.next();
                        int h2 = ((ns0) next).h();
                        if (h < h2) {
                            obj = next;
                            h = h2;
                        }
                    } while (it.hasNext());
                }
            }
            obj = (ns0) obj;
        }
        if (obj == null) {
            jSONArray.add(str2);
            return;
        }
        ConcurrentHashMap<String, GXTemplateInfo> concurrentHashMap = GXExtensionTemplateInfoSource.Companion.getInstance().getDataCache().get(str);
        if (concurrentHashMap == null || (gXTemplateInfo = concurrentHashMap.get(str2)) == null || (k = gXTemplateInfo.k()) == null) {
            return;
        }
        for (GXTemplateInfo gXTemplateInfo2 : k) {
            fillPrepareTemplate(gXTemplateInfo2.s().a(), gXTemplateInfo2.s().d(), jSONArray);
        }
    }

    private final String getAppEnv() {
        String string;
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        return (prefs == null || (string = prefs.getString("GAIAX_NET_CONFIG", "app_env", "")) == null) ? "" : string;
    }

    private final long getAppVersion() {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return 0L;
        }
        return prefs.getLong("GAIAX_NET_CONFIG", "app_version", 0L);
    }

    private final long getNetTimestamp() {
        boolean z;
        IProxyPrefs prefs;
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        long appVersion = gaiaXRemoteSourceUtils.getAppVersion();
        boolean z2 = true;
        if (getAppVersion() != appVersion) {
            setAppVersion(appVersion);
            resetNetTimestamp();
            z = true;
        } else {
            z = false;
        }
        String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
        if (b41.d(getAppEnv(), onlineStatus)) {
            z2 = z;
        } else {
            setAppEnv(onlineStatus);
            resetNetTimestamp();
        }
        if (z2 || (prefs = GaiaXProxy.Companion.getInstance().getPrefs()) == null) {
            return 0L;
        }
        return prefs.getLong("GAIAX_NET_CONFIG", "net_all_timestamp", 0L);
    }

    private final int getTargetStatus(String str) {
        switch (str.hashCode()) {
            case -1861416333:
                return !str.equals("PUBLISH_OFFLINE") ? 0 : -2;
            case -797325479:
                return !str.equals("DAILY_ONLINE") ? 0 : 3;
            case 77184:
                str.equals("NEW");
                return 0;
            case 20817807:
                return !str.equals("PRE_ONLINE") ? 0 : 1;
            case 363160483:
                return !str.equals("PUBLISH_ONLINE") ? 0 : 2;
            case 410862599:
                return !str.equals("PRE_OFFLINE") ? 0 : -1;
            case 818224509:
                return !str.equals("DAILY_OFFLINE") ? 0 : -3;
            default:
                return 0;
        }
    }

    private final void initLocalTemplateSource() {
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        String platform = gaiaXRemoteSourceUtils.getPlatform();
        String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
        long appVersion = gaiaXRemoteSourceUtils.getAppVersion();
        List<IGaiaXRemoteTemplateEntity> allWithStatusAndAppVersion = getAllWithStatusAndAppVersion(onlineStatus, appVersion, platform);
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            StringBuilder sb = new StringBuilder();
            sb.append("GaiaX远程模板初始化逻辑 - initLocalTemplateSource - start - ");
            sb.append(onlineStatus);
            sb.append(' ');
            sb.append(appVersion);
            sb.append(' ');
            sb.append(platform);
            sb.append(' ');
            sb.append(allWithStatusAndAppVersion == null ? null : Integer.valueOf(allWithStatusAndAppVersion.size()));
            log.d("[GaiaX]", sb.toString());
        }
        if (allWithStatusAndAppVersion != null) {
            ArrayList<IGaiaXRemoteTemplateEntity> arrayList = new ArrayList();
            for (Object obj : allWithStatusAndAppVersion) {
                File file = new File(((IGaiaXRemoteTemplateEntity) obj).getLocalPath());
                if (file.exists() && file.isFile()) {
                    arrayList.add(obj);
                }
            }
            for (IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity : arrayList) {
                Log log2 = Log.INSTANCE;
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 解析模板数据 - start 业务:" + iGaiaXRemoteTemplateEntity.getTemplateBiz() + "  模板:" + iGaiaXRemoteTemplateEntity.getTemplateId() + "  版本:" + iGaiaXRemoteTemplateEntity.getTemplateVersion() + "  状态：" + iGaiaXRemoteTemplateEntity.getReleaseStatus() + "  平台:" + iGaiaXRemoteTemplateEntity.getTemplatePlatform() + " 支持最大版本:" + iGaiaXRemoteTemplateEntity.getSupportMinVersion() + "  支持最小版本:" + iGaiaXRemoteTemplateEntity.getSupportMaxVersion());
                }
                addTemplateToCache(createTemplateFromBinary(iGaiaXRemoteTemplateEntity));
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 解析模板数据 - end");
                    log2.d("[GaiaX]", SocketClient.NETASCII_EOL);
                }
            }
        }
        Log log3 = Log.INSTANCE;
        if (log3.isLaunchLog()) {
            log3.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - initLocalTemplateSource - end - " + onlineStatus + ' ' + appVersion);
        }
    }

    private final void initRemoteCacheDirectory() {
        File file = new File(GaiaXRemoteCacheUtils.INSTANCE.getCachePath());
        if (file.exists()) {
            return;
        }
        resetNetTimestamp();
        file.mkdirs();
    }

    private final void initRemoteTemplateSource() {
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 开始");
        }
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        boolean z = false;
        if (features != null && !features.isNetworkConnected()) {
            z = true;
        }
        if (z) {
            return;
        }
        requestAllTemplate(Math.max(getNetTimestamp(), 0L));
        IStable stable = GaiaX.Companion.getInstance().stable();
        GaiaXStableApiImpl gaiaXStableApiImpl = stable instanceof GaiaXStableApiImpl ? (GaiaXStableApiImpl) stable : null;
        if (gaiaXStableApiImpl != null) {
            gaiaXStableApiImpl.notifyRemoteTemplateStateSuccess();
        }
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 结束");
        }
    }

    private final void processTemplatesData(JSONArray jSONArray, boolean z) {
        Iterator it;
        String str;
        for (Object obj : jSONArray) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("status");
            String g = yq0.g(jSONObject, "metadata.templateId");
            String g2 = yq0.g(jSONObject, "metadata.templateVersion");
            String g3 = yq0.g(jSONObject, "scene.sceneId");
            try {
                Log log = Log.INSTANCE;
                if (log.isLaunchLog()) {
                    JSONArray e = yq0.e(jSONObject, "clientVersions");
                    log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 解析模板 业务：" + g3 + " - 模板：" + g + " - 版本：" + g2 + " - 状态：" + ((Object) string) + " - 版本范围:" + e);
                }
                List<IGaiaXRemoteTemplateEntity> writeTemplateToLocal = writeTemplateToLocal(jSONObject);
                String str2 = SocketClient.NETASCII_EOL;
                if (writeTemplateToLocal != null) {
                    Iterator it2 = writeTemplateToLocal.iterator();
                    while (it2.hasNext()) {
                        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity = (IGaiaXRemoteTemplateEntity) it2.next();
                        File file = new File(iGaiaXRemoteTemplateEntity.getLocalPath());
                        if (file.exists() && file.isFile()) {
                            insertTemplateEntity(iGaiaXRemoteTemplateEntity);
                            GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
                            String onlineStatus = gaiaXRemoteSourceUtils.getOnlineStatus();
                            String platform = gaiaXRemoteSourceUtils.getPlatform();
                            if (b41.d(onlineStatus, iGaiaXRemoteTemplateEntity.getReleaseStatus()) && b41.d(platform, iGaiaXRemoteTemplateEntity.getTemplatePlatform())) {
                                it = it2;
                                str = str2;
                                List<IGaiaXRemoteTemplateEntity> templateEntityWithStatusAndAppVersion = getTemplateEntityWithStatusAndAppVersion(iGaiaXRemoteTemplateEntity.getTemplateId(), iGaiaXRemoteTemplateEntity.getTemplateBiz(), onlineStatus, gaiaXRemoteSourceUtils.getAppVersion(), platform);
                                IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity2 = templateEntityWithStatusAndAppVersion == null ? null : (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatusAndAppVersion);
                                if (iGaiaXRemoteTemplateEntity2 != null) {
                                    ns0 createTemplateFromBinary = createTemplateFromBinary(iGaiaXRemoteTemplateEntity2);
                                    addTemplateToCache(createTemplateFromBinary);
                                    Log log2 = Log.INSTANCE;
                                    if (log2.isLaunchLog()) {
                                        log2.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 更新模板 业务：" + iGaiaXRemoteTemplateEntity2.getTemplateBiz() + " - 模板：" + iGaiaXRemoteTemplateEntity2.getTemplateId() + " - 版本：" + iGaiaXRemoteTemplateEntity2.getTemplateVersion() + " - 状态：" + iGaiaXRemoteTemplateEntity2.getReleaseStatus() + " - 平台:" + iGaiaXRemoteTemplateEntity2.getTemplatePlatform() + " - 支持最大版本:" + iGaiaXRemoteTemplateEntity2.getSupportMaxVersion() + " - 支持最小版本:" + iGaiaXRemoteTemplateEntity2.getSupportMinVersion());
                                        log2.d("[GaiaX]", str);
                                    }
                                    if (z) {
                                        autoLoadDependTemplates(iGaiaXRemoteTemplateEntity2.getTemplateBiz(), createTemplateFromBinary.f());
                                    }
                                } else {
                                    throw new IllegalArgumentException("processTemplatesData entity already inserted but not query a result");
                                }
                            } else {
                                it = it2;
                                str = str2;
                            }
                            str2 = str;
                            it2 = it;
                        } else {
                            throw new IllegalArgumentException("processTemplatesData id = " + g + " biz = " + g3 + " msg = file not exist " + ((Object) file.getAbsolutePath()));
                        }
                    }
                    continue;
                } else if (log.isLaunchLog()) {
                    log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 跳过 业务：" + g3 + " - 模板：" + g + " - 版本：" + g2);
                    log.d("[GaiaX]", SocketClient.NETASCII_EOL);
                }
            } catch (Exception e2) {
                if (!this.isHaveParseError) {
                    this.isHaveParseError = true;
                }
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e2);
            }
        }
    }

    static /* synthetic */ void processTemplatesData$default(GXExtensionTemplateRemoteSource gXExtensionTemplateRemoteSource, JSONArray jSONArray, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processTemplatesData");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        gXExtensionTemplateRemoteSource.processTemplatesData(jSONArray, z);
    }

    private final void requestAllTemplate(long j) {
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyMonitor monitor = companion.getInstance().getMonitor();
        if (monitor != null) {
            IProxyMonitor.DefaultImpls.monitor$default(monitor, "template_remote_request", null, null, null, UCCore.LEGACY_EVENT_INIT, 0L, null, null, null, 494, null);
        }
        IProxyNet net2 = companion.getInstance().getNet();
        IProxyNet.NetResponse requestTemplateWithPage = net2 == null ? null : net2.requestTemplateWithPage(this.pageNum, this.pageSize, j);
        if (requestTemplateWithPage != null) {
            if (requestTemplateWithPage.isSuccess()) {
                IProxyMonitor monitor2 = companion.getInstance().getMonitor();
                if (monitor2 != null) {
                    IProxyMonitor.DefaultImpls.monitor$default(monitor2, "template_remote_request", null, null, null, "success", 0L, null, null, null, 494, null);
                }
                int d = yq0.d(requestTemplateWithPage.getData(), "hasMore");
                long f = yq0.f(requestTemplateWithPage.getData(), "timestamp");
                yq0.d(requestTemplateWithPage.getData(), Constants.Name.PAGE_SIZE);
                JSONArray jSONArray = requestTemplateWithPage.getData().getJSONArray("result");
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                if (!this.isHaveEmptyResult && jSONArray.isEmpty()) {
                    this.isHaveEmptyResult = true;
                }
                processTemplatesData$default(this, jSONArray, false, 2, null);
                if (d == 1) {
                    this.pageNum++;
                    requestAllTemplate(j);
                    return;
                }
                boolean z = this.isHaveEmptyResult;
                if (z || this.isHaveParseError) {
                    if (z) {
                        Log log = Log.INSTANCE;
                        if (log.isLaunchLog()) {
                            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 接口请求 - 数据为空的情况，没有待更新的模板，不更新时间戳");
                            return;
                        }
                        return;
                    }
                    return;
                }
                long max = Math.max(f, 0L);
                setNetTimestamp(max);
                Log log2 = Log.INSTANCE;
                if (log2.isLaunchLog()) {
                    log2.d("[GaiaX]", b41.r("GaiaX远程模板更新逻辑 - 接口请求 - 完全成功 - 时间戳 = ", Long.valueOf(max)));
                    return;
                }
                return;
            }
            IProxyMonitor monitor3 = companion.getInstance().getMonitor();
            if (monitor3 != null) {
                IProxyMonitor.DefaultImpls.monitor$default(monitor3, "template_remote_request", null, null, null, "error", 0L, null, null, null, 494, null);
            }
            throw new IllegalArgumentException("requestAllTemplate - 接口请求 - 失败 msg = " + requestTemplateWithPage.getMessage() + " or response is null");
        }
        throw new IllegalArgumentException("requestAllTemplate response is null");
    }

    private final void requestTemplates(String str, JSONArray jSONArray) {
        IProxyNet.NetResponse requestTemplates;
        IProxyNet net2 = GaiaXProxy.Companion.getInstance().getNet();
        if (net2 == null) {
            requestTemplates = null;
        } else {
            String jSONString = jSONArray.toJSONString();
            b41.h(jSONString, "templatesId.toJSONString()");
            requestTemplates = net2.requestTemplates(jSONString);
        }
        if (requestTemplates != null) {
            if (requestTemplates.isSuccess()) {
                JSONArray jSONArray2 = requestTemplates.getData().getJSONArray("result");
                if (jSONArray2 == null) {
                    jSONArray2 = new JSONArray();
                }
                if (jSONArray2.isEmpty()) {
                    Log log = Log.INSTANCE;
                    if (log.isLog()) {
                        log.d("[GaiaX]", b41.r("requestTemplates - 成功 但是数据为空，可能没有新模板需要更新，或者该模板不是远程模板 模板=", jSONArray));
                        return;
                    }
                    return;
                }
                this.isHaveParseError = false;
                processTemplatesData(jSONArray2, true);
                if (this.isHaveParseError) {
                    for (Object obj : jSONArray) {
                        this.remoteCheckCache.remove(b41.r(str, obj));
                    }
                    return;
                }
                return;
            }
            for (Object obj2 : jSONArray) {
                this.remoteCheckCache.remove(b41.r(str, obj2));
            }
            throw new IllegalArgumentException("requestTemplates - 失败 templatesId = " + jSONArray + " msg = " + requestTemplates.getMessage());
        }
        throw new IllegalArgumentException(b41.r("requestTemplates NetResponse is null, templatesId = ", jSONArray));
    }

    private final void resetNetTimestamp() {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return;
        }
        prefs.putLong("GAIAX_NET_CONFIG", "net_all_timestamp", 0L);
    }

    private final void setAppEnv(String str) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return;
        }
        prefs.putString("GAIAX_NET_CONFIG", "app_env", str);
    }

    private final void setAppVersion(long j) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return;
        }
        prefs.putLong("GAIAX_NET_CONFIG", "app_version", j);
    }

    private final void setNetTimestamp(long j) {
        IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
        if (prefs == null) {
            return;
        }
        prefs.putLong("GAIAX_NET_CONFIG", "net_all_timestamp", j);
    }

    private final List<IGaiaXRemoteTemplateEntity> writeTemplateToLocal(JSONObject jSONObject) {
        Iterator<Object> it;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        int i;
        String g = yq0.g(jSONObject, "metadata.templateId");
        int d = yq0.d(jSONObject, "metadata.templateVersion");
        String g2 = yq0.g(jSONObject, "scene.sceneId");
        String g3 = yq0.g(jSONObject, "status");
        List<IGaiaXRemoteTemplateEntity> templateEntityWithStatus = getTemplateEntityWithStatus(g, d, g2, g3);
        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity = templateEntityWithStatus == null ? null : (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatus);
        if (iGaiaXRemoteTemplateEntity == null || !new File(iGaiaXRemoteTemplateEntity.getLocalPath()).exists()) {
            String writeToSD = GaiaXRemoteCacheUtils.INSTANCE.writeToSD(yq0.g(jSONObject, "templateFileData"));
            String g4 = yq0.g(jSONObject, SocialConstants.PARAM_APP_DESC);
            String string = jSONObject.getString("priority");
            String g5 = yq0.g(jSONObject, "creator.timestamp");
            String g6 = yq0.g(jSONObject, "creator.empId");
            String g7 = yq0.g(jSONObject, "lastModifier.timestamp");
            String g8 = yq0.g(jSONObject, "lastModifier.empId");
            String g9 = yq0.g(jSONObject, "templateFileType");
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("clientVersions");
            boolean z = true;
            if (jSONArray != null) {
                Iterator<Object> it2 = jSONArray.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    Objects.requireNonNull(next, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                    JSONObject jSONObject2 = (JSONObject) next;
                    String string2 = jSONObject2.getString("platform");
                    IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
                    boolean z2 = false;
                    if (features != null && features.checkRemoteTemplatePlatform(string2) == z) {
                        z2 = true;
                    }
                    if (z2) {
                        GaiaXRemoteVersionUtils gaiaXRemoteVersionUtils = GaiaXRemoteVersionUtils.INSTANCE;
                        long minVersion = gaiaXRemoteVersionUtils.getMinVersion(jSONObject2);
                        long maxVersion = gaiaXRemoteVersionUtils.getMaxVersion(jSONObject2);
                        b41.h(string2, "platform");
                        b41.h(string, "templatePriority");
                        it = it2;
                        arrayList = arrayList2;
                        str = string;
                        str2 = g3;
                        str3 = g2;
                        i = d;
                        IGaiaXRemoteTemplateEntity createTemplateEntity = createTemplateEntity(g, d, g2, string2, g4, "", writeToSD, str, minVersion, maxVersion, g5, g7, g6, g8, str2, "", g9);
                        if (createTemplateEntity != null) {
                            arrayList.add(createTemplateEntity);
                        }
                    } else {
                        it = it2;
                        arrayList = arrayList2;
                        str = string;
                        str2 = g3;
                        str3 = g2;
                        i = d;
                    }
                    arrayList2 = arrayList;
                    string = str;
                    g3 = str2;
                    g2 = str3;
                    d = i;
                    z = true;
                    it2 = it;
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (!arrayList3.isEmpty()) {
                return arrayList3;
            }
        }
        return null;
    }

    public final void cleanRemoteTemplates() {
        resetNetTimestamp();
        clearAllToDB();
    }

    public void clearAllToDB() {
    }

    @Nullable
    public IGaiaXRemoteTemplateEntity createTemplateEntity(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j, long j2, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14) {
        b41.i(str, "templateId");
        b41.i(str2, "templateBiz");
        b41.i(str3, "templatePlatform");
        b41.i(str4, "templateDesc");
        b41.i(str5, "templateResourceUrl");
        b41.i(str6, "templateLocalUrl");
        b41.i(str7, "templatePriority");
        b41.i(str8, "templateCreateTime");
        b41.i(str9, "templateModifyTime");
        b41.i(str10, "templateCreateEmpId");
        b41.i(str11, "templateModifyEmpId");
        b41.i(str12, "templateStatus");
        b41.i(str13, "templateExtInfo");
        b41.i(str14, "templateFileType");
        return null;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getAll() {
        return null;
    }

    @NotNull
    public final Map<String, List<JSONObject>> getAllRemoteTemplatesInMemory() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, CopyOnWriteArraySet<ns0>> entry : this.remoteTemplateCache.entrySet()) {
            ArrayList arrayList = new ArrayList();
            for (ns0 ns0Var : entry.getValue()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put((JSONObject) "templateId", ns0Var.d());
                jSONObject.put((JSONObject) "templateVersion", (String) Integer.valueOf(ns0Var.h()));
                jSONObject.put((JSONObject) "templateBiz", ns0Var.a());
                arrayList.add(jSONObject);
            }
            hashMap.put(entry.getKey(), arrayList);
        }
        return hashMap;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getAllWithStatusAndAppVersion(@NotNull String str, long j, @NotNull String str2) {
        b41.i(str, "status");
        b41.i(str2, "platform");
        return null;
    }

    @NotNull
    public final String getRemoteGaiaXCachePath() {
        return GaiaXRemoteCacheUtils.INSTANCE.getCachePath();
    }

    @NotNull
    public final JSONObject getRemoteTemplateFromDB(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        JSONObject jSONObject = new JSONObject();
        GaiaXRemoteSourceUtils gaiaXRemoteSourceUtils = GaiaXRemoteSourceUtils.INSTANCE;
        List<IGaiaXRemoteTemplateEntity> templateEntityWithStatusAndAppVersion = getTemplateEntityWithStatusAndAppVersion(str2, str, gaiaXRemoteSourceUtils.getOnlineStatus(), gaiaXRemoteSourceUtils.getAppVersion(), gaiaXRemoteSourceUtils.getPlatform());
        IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity = templateEntityWithStatusAndAppVersion == null ? null : (IGaiaXRemoteTemplateEntity) k.R(templateEntityWithStatusAndAppVersion);
        if (iGaiaXRemoteTemplateEntity == null) {
            return new JSONObject();
        }
        ns0 createTemplateFromBinary = createTemplateFromBinary(iGaiaXRemoteTemplateEntity);
        JSONObject jSONObject2 = new JSONObject();
        GXTemplateInfo.Companion companion = GXTemplateInfo.Companion;
        jSONObject2.put((JSONObject) "index.json", (String) companion.n(createTemplateFromBinary.f()));
        jSONObject2.put((JSONObject) "index.css", (String) companion.l(createTemplateFromBinary.b()));
        jSONObject2.put((JSONObject) "index.databinding", (String) companion.m(createTemplateFromBinary.c()));
        jSONObject2.put((JSONObject) "index.js", createTemplateFromBinary.e());
        jSONObject.put((JSONObject) com.youku.arch.v3.data.Constants.TEMPLATE, (String) jSONObject2);
        jSONObject.put((JSONObject) "templateId", str2);
        jSONObject.put((JSONObject) "templateBiz", str);
        jSONObject.put((JSONObject) "templateVersion", (String) Integer.valueOf(iGaiaXRemoteTemplateEntity.getTemplateVersion()));
        jSONObject.put((JSONObject) "templateType", "remote");
        return jSONObject;
    }

    public final int getRemoteTemplateVersion(@NotNull String str, @NotNull String str2) {
        Object obj;
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        CopyOnWriteArraySet<ns0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        if (copyOnWriteArraySet == null) {
            return -1;
        }
        Iterator<T> it = copyOnWriteArraySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (b41.d(((ns0) obj).d(), str2)) {
                break;
            }
        }
        ns0 ns0Var = (ns0) obj;
        if (ns0Var == null) {
            return -1;
        }
        return ns0Var.h();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionTemplateSource
    @Nullable
    public ns0 getTemplate(@NotNull GXTemplateEngine.i iVar) {
        b41.i(iVar, "gxTemplateItem");
        String b = iVar.b();
        if (b.length() == 0) {
            b = iVar.a();
        }
        CopyOnWriteArraySet<ns0> copyOnWriteArraySet = this.remoteTemplateCache.get(b);
        Object obj = null;
        if (copyOnWriteArraySet == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : copyOnWriteArraySet) {
            if (b41.d(((ns0) obj2).d(), iVar.d())) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int h = ((ns0) obj).h();
                do {
                    Object next = it.next();
                    int h2 = ((ns0) next).h();
                    if (h < h2) {
                        obj = next;
                        h = h2;
                    }
                } while (it.hasNext());
            }
        }
        return (ns0) obj;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatus(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        b41.i(str, "templateId");
        b41.i(str2, "templateBiz");
        b41.i(str3, "templateStatus");
        return null;
    }

    @Nullable
    public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatusAndAppVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4) {
        b41.i(str, "templateId");
        b41.i(str2, "templateBiz");
        b41.i(str3, "templateStatus");
        b41.i(str4, "platform");
        return null;
    }

    public void insertTemplateEntity(@NotNull IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity) {
        b41.i(iGaiaXRemoteTemplateEntity, "entity");
    }

    public final void launchDB() {
        long j;
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 开始");
            j = SystemClock.elapsedRealtime();
        } else {
            j = 0;
        }
        if (ConfigUtils.INSTANCE.checkRemoteData() && !this.isSyncLocalTemplate) {
            this.isSyncLocalTemplate = true;
            try {
                initLocalTemplateSource();
            } catch (Exception e) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            }
        }
        Log log2 = Log.INSTANCE;
        if (log2.isLaunchLog()) {
            log2.d("[GaiaX]", "GaiaX远程模板初始化逻辑 - 结束 耗时(" + (SystemClock.elapsedRealtime() - j) + ')');
            log2.d("[GaiaX]", SocketClient.NETASCII_EOL);
        }
    }

    public final void launchRemote() {
        long j;
        Log log = Log.INSTANCE;
        if (log.isLaunchLog()) {
            log.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 开始");
            j = SystemClock.elapsedRealtime();
        } else {
            j = 0;
        }
        if (ConfigUtils.INSTANCE.checkRemoteData() && !this.isSyncNetTemplate) {
            this.isSyncNetTemplate = true;
            try {
                initRemoteTemplateSource();
            } catch (Exception e) {
                ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
            }
        }
        Log log2 = Log.INSTANCE;
        if (log2.isLaunchLog()) {
            log2.d("[GaiaX]", "GaiaX远程模板更新逻辑 - 结束 耗时(" + (SystemClock.elapsedRealtime() - j) + ')');
        }
        IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
        if (monitor == null) {
            return;
        }
        monitor.monitorLocalAndRemote();
    }

    public final void requestRemoteTemplatesWithAsync(@NotNull final String str) {
        b41.i(str, "templatesId");
        IProxyTask task = GaiaXProxy.Companion.getInstance().getTask();
        if (task == null) {
            return;
        }
        task.executeTask(new Function0<wt2>() { // from class: com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource$requestRemoteTemplatesWithAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    GXExtensionTemplateRemoteSource.this.requestTemplates(str);
                } catch (Exception e) {
                    ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
                }
            }
        });
    }

    @Deprecated(message = "")
    public final void requestRemoteTemplatesWithSync(@NotNull String str) {
        b41.i(str, "templatesId");
        try {
            requestTemplates(str);
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    public final boolean templateExistWithRemote(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        CopyOnWriteArraySet<ns0> copyOnWriteArraySet = this.remoteTemplateCache.get(str);
        Object obj = null;
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (b41.d(((ns0) next).d(), str2)) {
                    obj = next;
                    break;
                }
            }
            obj = (ns0) obj;
        }
        return obj != null;
    }

    public final void requestRemoteTemplatesWithSync(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        try {
            String r = b41.r(str, str2);
            if (this.remoteCheckCache.contains(r)) {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d("[GaiaX]", "requestRemoteTemplatesWithSync() called with: key = " + r + ", continue");
                    return;
                }
                return;
            }
            this.remoteCheckCache.add(r);
            JSONArray jSONArray = new JSONArray();
            fillPrepareTemplate(str, str2, jSONArray);
            Log log2 = Log.INSTANCE;
            if (log2.isLog()) {
                log2.d("[GaiaX]", b41.r("requestRemoteTemplatesWithSync() called with: result = ", jSONArray));
            }
            if (!jSONArray.isEmpty()) {
                requestTemplates(str, jSONArray);
            }
        } catch (Exception e) {
            ExceptionUtils.INSTANCE.throwExceptionOrAlarm(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "")
    public final void requestTemplates(String str) {
        IProxyNet net2 = GaiaXProxy.Companion.getInstance().getNet();
        IProxyNet.NetResponse requestTemplates = net2 == null ? null : net2.requestTemplates(str);
        if (requestTemplates != null) {
            if (requestTemplates.isSuccess()) {
                JSONArray jSONArray = requestTemplates.getData().getJSONArray("result");
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                if (!jSONArray.isEmpty()) {
                    processTemplatesData(jSONArray, true);
                    return;
                }
                throw new IllegalArgumentException(b41.r("requestTemplates - 成功 但是数据为空 模板=", str));
            }
            throw new IllegalArgumentException("requestTemplates - 失败 templatesId = " + str + " msg = " + requestTemplates.getMessage());
        }
        throw new IllegalArgumentException(b41.r("requestTemplates NetResponse is null, templatesId = ", str));
    }
}
