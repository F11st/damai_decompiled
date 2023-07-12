package com.youku.gaiax.provider.module;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.realidentity.jsbridge.a;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxySource;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import com.youku.gaiax.impl.register.remote.IGaiaXRemoteTemplateEntity;
import com.youku.gaiax.provider.module.GaiaXProxySource;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.gaiax.provider.module.source.DAOUtils;
import com.youku.gaiax.provider.module.source.db.YKDB;
import com.youku.gaiax.provider.module.source.db.YKTemplateEntity;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource;", "Lcom/youku/gaiax/api/proxy/IProxySource;", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "getAssetsTemplateSource", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "getRemoteTemplateSource", "<init>", "()V", "GaiaXYKAssetsTemplateSource", "GaiaXYKRemoteTemplateSource", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxySource implements IProxySource {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006`\rJ\u001a\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u000fH\u0016R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKAssetsTemplateSource;", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateAssetsSource;", "", "", "getAllBizNames", a.V, "", "getAssetsTemplateNumSizeByPath", "Ljava/util/ArrayList;", "Lcom/alibaba/fastjson/JSONObject;", "Lkotlin/collections/ArrayList;", "getAssetsRawJsonSizeByPath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getAllAssetsTemplateNums", "", "getAllTemplate", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GaiaXYKAssetsTemplateSource extends GXExtensionTemplateAssetsSource {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<GaiaXYKAssetsTemplateSource> instance$delegate;
        @NotNull
        private final Context context;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion;", "", "Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKAssetsTemplateSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKAssetsTemplateSource;", "instance", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GaiaXYKAssetsTemplateSource getInstance() {
                return (GaiaXYKAssetsTemplateSource) GaiaXYKAssetsTemplateSource.instance$delegate.getValue();
            }
        }

        static {
            Lazy<GaiaXYKAssetsTemplateSource> b;
            b = b.b(new Function0<GaiaXYKAssetsTemplateSource>() { // from class: com.youku.gaiax.provider.module.GaiaXProxySource$GaiaXYKAssetsTemplateSource$Companion$instance$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GaiaXProxySource.GaiaXYKAssetsTemplateSource invoke() {
                    IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                    Context applicationContext = app2 == null ? null : app2.applicationContext();
                    b41.f(applicationContext);
                    return new GaiaXProxySource.GaiaXYKAssetsTemplateSource(applicationContext);
                }
            });
            instance$delegate = b;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GaiaXYKAssetsTemplateSource(@NotNull Context context) {
            super(context);
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            this.context = context;
        }

        private final List<String> getAllBizNames() {
            ArrayList arrayList = new ArrayList();
            PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
            if (companion.isDamaiApp()) {
                arrayList.add("damai");
            } else if (companion.isTppApp()) {
                arrayList.add("tpp");
            }
            return arrayList;
        }

        private final ArrayList<JSONObject> getAssetsRawJsonSizeByPath(String str) {
            Context applicationContext;
            AssetManager assets;
            String[] list;
            ArrayList<JSONObject> arrayList = new ArrayList<>();
            try {
                IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                if (app2 != null && (applicationContext = app2.applicationContext()) != null && (assets = applicationContext.getAssets()) != null && (list = assets.list(str)) != null) {
                    for (String str2 : list) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put((JSONObject) "templateId", str2);
                        jSONObject.put((JSONObject) "templateVersion", "");
                        jSONObject.put((JSONObject) "templateBiz", str);
                        arrayList.add(jSONObject);
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        private final int getAssetsTemplateNumSizeByPath(String str) {
            Context applicationContext;
            AssetManager assets;
            String[] list;
            try {
                IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                if (app2 != null && (applicationContext = app2.applicationContext()) != null && (assets = applicationContext.getAssets()) != null && (list = assets.list(str)) != null) {
                    return list.length;
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }

        @NotNull
        public final HashMap<String, Integer> getAllAssetsTemplateNums() {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String str : getAllBizNames()) {
                hashMap.put(str, Integer.valueOf(getAssetsTemplateNumSizeByPath(str)));
            }
            return hashMap;
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource
        @NotNull
        public Map<String, List<JSONObject>> getAllTemplate() {
            HashMap hashMap = new HashMap();
            for (String str : getAllBizNames()) {
                hashMap.put(str, getAssetsRawJsonSizeByPath(str));
            }
            return hashMap;
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource, tb.cq0
        @NotNull
        public Context getContext() {
            return this.context;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0090\u0001\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J6\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016¨\u0006'"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKRemoteTemplateSource;", "Lcom/youku/gaiax/impl/register/GXExtensionTemplateRemoteSource;", "Lcom/youku/gaiax/impl/register/remote/IGaiaXRemoteTemplateEntity;", "entity", "Ltb/wt2;", "insertTemplateEntity", "", "templateId", "", "templateVersion", "templateBiz", "templatePlatform", "templateDesc", "templateResourceUrl", "templateLocalUrl", "templatePriority", "", "templateSupportMinVersion", "templateSupportMaxVersion", "templateCreateTime", "templateModifyTime", "templateCreateEmpId", "templateModifyEmpId", "templateStatus", "templateExtInfo", "templateFileType", "createTemplateEntity", "", "getTemplateEntityWithStatus", "appVersion", "platform", "getTemplateEntityWithStatusAndAppVersion", "status", "getAllWithStatusAndAppVersion", "getAll", "clearAllToDB", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GaiaXYKRemoteTemplateSource extends GXExtensionTemplateRemoteSource {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<GaiaXYKRemoteTemplateSource> instance$delegate;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKRemoteTemplateSource$Companion;", "", "Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKRemoteTemplateSource;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/provider/module/GaiaXProxySource$GaiaXYKRemoteTemplateSource;", "instance", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k50 k50Var) {
                this();
            }

            @NotNull
            public final GaiaXYKRemoteTemplateSource getInstance() {
                return (GaiaXYKRemoteTemplateSource) GaiaXYKRemoteTemplateSource.instance$delegate.getValue();
            }
        }

        static {
            Lazy<GaiaXYKRemoteTemplateSource> b;
            b = b.b(new Function0<GaiaXYKRemoteTemplateSource>() { // from class: com.youku.gaiax.provider.module.GaiaXProxySource$GaiaXYKRemoteTemplateSource$Companion$instance$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GaiaXProxySource.GaiaXYKRemoteTemplateSource invoke() {
                    return new GaiaXProxySource.GaiaXYKRemoteTemplateSource();
                }
            });
            instance$delegate = b;
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        public void clearAllToDB() {
            YKDB.Companion companion = YKDB.Companion;
            Application application = AppInfoProviderProxy.getApplication();
            b41.h(application, "getApplication()");
            YKDB instance = companion.instance(application);
            if (instance == null) {
                return;
            }
            instance.clearAllTables();
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        @NotNull
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
            return new YKTemplateEntity(str, i, str2, str3, str4, str5, str6, str7, j, j2, str8, str9, str10, str11, str12, str13, str14);
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        @NotNull
        public List<IGaiaXRemoteTemplateEntity> getAll() {
            return DAOUtils.INSTANCE.remoteDAO().getAll();
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        @NotNull
        public List<IGaiaXRemoteTemplateEntity> getAllWithStatusAndAppVersion(@NotNull String str, long j, @NotNull String str2) {
            b41.i(str, "status");
            b41.i(str2, "platform");
            return DAOUtils.INSTANCE.remoteDAO().getAllTemplatesWithStatusAndAppVersion(str, j, str2);
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        @NotNull
        public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatus(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
            b41.i(str, "templateId");
            b41.i(str2, "templateBiz");
            b41.i(str3, "templateStatus");
            return DAOUtils.INSTANCE.remoteDAO().getTemplateWithStatus(str, i, str2, str3);
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        @NotNull
        public List<IGaiaXRemoteTemplateEntity> getTemplateEntityWithStatusAndAppVersion(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, @NotNull String str4) {
            b41.i(str, "templateId");
            b41.i(str2, "templateBiz");
            b41.i(str3, "templateStatus");
            b41.i(str4, "platform");
            return DAOUtils.INSTANCE.remoteDAO().getTemplatesWithStatusAndAppVersion(str, str2, str3, j, str4);
        }

        @Override // com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource
        public void insertTemplateEntity(@NotNull IGaiaXRemoteTemplateEntity iGaiaXRemoteTemplateEntity) {
            b41.i(iGaiaXRemoteTemplateEntity, "entity");
            DAOUtils.INSTANCE.remoteDAO().insert((YKTemplateEntity) iGaiaXRemoteTemplateEntity);
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxySource
    @Nullable
    public GXExtensionTemplateAssetsSource getAssetsTemplateSource() {
        return GaiaXYKAssetsTemplateSource.Companion.getInstance();
    }

    @Override // com.youku.gaiax.api.proxy.IProxySource
    @Nullable
    public GXExtensionTemplateRemoteSource getRemoteTemplateSource() {
        return GaiaXYKRemoteTemplateSource.Companion.getInstance();
    }

    @Override // com.youku.gaiax.api.proxy.IProxySource
    public void sourceInit() {
        IProxySource.DefaultImpls.sourceInit(this);
    }
}
