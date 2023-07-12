package com.youku.gaiax.provider.module.source;

import android.app.Application;
import com.youku.gaiax.provider.module.source.db.AssetsTemplateDAO;
import com.youku.gaiax.provider.module.source.db.RemoteTemplateDAO;
import com.youku.gaiax.provider.module.source.db.YKDB;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/source/DAOUtils;", "", "Lcom/youku/gaiax/provider/module/source/db/AssetsTemplateDAO;", "assetsDao", "Lcom/youku/gaiax/provider/module/source/db/RemoteTemplateDAO;", "remoteDAO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DAOUtils {
    @NotNull
    public static final DAOUtils INSTANCE = new DAOUtils();
    @NotNull
    public static final String TAG = "[GaiaX]";

    private DAOUtils() {
    }

    @NotNull
    public final AssetsTemplateDAO assetsDao() {
        YKDB.Companion companion = YKDB.Companion;
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        YKDB instance = companion.instance(application);
        if (instance == null) {
            return null;
        }
        return instance.assetsDao();
    }

    @NotNull
    public final RemoteTemplateDAO remoteDAO() {
        YKDB.Companion companion = YKDB.Companion;
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        YKDB instance = companion.instance(application);
        if (instance == null) {
            return null;
        }
        return instance.remoteDao();
    }
}
