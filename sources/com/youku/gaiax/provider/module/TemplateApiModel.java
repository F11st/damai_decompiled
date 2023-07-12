package com.youku.gaiax.provider.module;

import com.huawei.hms.actions.SearchIntents;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.provider.module.net.YYBaseMtopRequest;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.gaiax.provider.module.util.Utils;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.EnvUrlProviderProxy;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import mtopsdk.mtop.domain.MethodEnum;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/youku/gaiax/provider/module/TemplateApiModel;", "Lcom/youku/gaiax/provider/module/net/YYBaseMtopRequest;", "Ljava/io/Serializable;", "", "getSystemInfoTemp", "Lmtopsdk/mtop/domain/MethodEnum;", "getHttpMethod", "", "getNeedEcode", "getNeedSession", "getVersion", "getApiName", "Lcom/youku/gaiax/provider/module/TemplateApiModel$Query;", SearchIntents.EXTRA_QUERY, "Lcom/youku/gaiax/provider/module/TemplateApiModel$Query;", "getQuery", "()Lcom/youku/gaiax/provider/module/TemplateApiModel$Query;", "setQuery", "(Lcom/youku/gaiax/provider/module/TemplateApiModel$Query;)V", "systemInfo", "Ljava/lang/String;", "getSystemInfo", "()Ljava/lang/String;", "setSystemInfo", "(Ljava/lang/String;)V", "<init>", "()V", "Query", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TemplateApiModel extends YYBaseMtopRequest implements Serializable {
    @NotNull
    private Query query = new Query();
    @NotNull
    private String systemInfo = getSystemInfoTemp();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/youku/gaiax/provider/module/TemplateApiModel$Query;", "", "", "pageNo", "I", "getPageNo", "()I", "setPageNo", "(I)V", Constants.Name.PAGE_SIZE, "getPageSize", "setPageSize", "", "env", "Ljava/lang/String;", "getEnv", "()Ljava/lang/String;", "setEnv", "(Ljava/lang/String;)V", "templateIds", "getTemplateIds", "setTemplateIds", "onlyNewestTemplate", "getOnlyNewestTemplate", "setOnlyNewestTemplate", "", "timestamp", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "unzipFileData", "getUnzipFileData", "setUnzipFileData", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Query {
        @NotNull
        private String env;
        @NotNull
        private String onlyNewestTemplate;
        private int pageNo;
        private int pageSize = 50;
        @NotNull
        private String templateIds;
        private long timestamp;
        private int unzipFileData;

        public Query() {
            String str = "publish";
            if (EnvUrlProviderProxy.isDaily()) {
                str = "daily";
            } else if (EnvUrlProviderProxy.isPre()) {
                str = "pre";
            } else {
                EnvUrlProviderProxy.isOnline();
            }
            this.env = str;
            this.templateIds = "";
            this.onlyNewestTemplate = "0";
        }

        @NotNull
        public final String getEnv() {
            return this.env;
        }

        @NotNull
        public final String getOnlyNewestTemplate() {
            return this.onlyNewestTemplate;
        }

        public final int getPageNo() {
            return this.pageNo;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        @NotNull
        public final String getTemplateIds() {
            return this.templateIds;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final int getUnzipFileData() {
            return this.unzipFileData;
        }

        public final void setEnv(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.env = str;
        }

        public final void setOnlyNewestTemplate(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.onlyNewestTemplate = str;
        }

        public final void setPageNo(int i) {
            this.pageNo = i;
        }

        public final void setPageSize(int i) {
            this.pageSize = i;
        }

        public final void setTemplateIds(@NotNull String str) {
            b41.i(str, "<set-?>");
            this.templateIds = str;
        }

        public final void setTimestamp(long j) {
            this.timestamp = j;
        }

        public final void setUnzipFileData(int i) {
            this.unzipFileData = i;
        }
    }

    private final String getSystemInfoTemp() {
        HashMap hashMap = new HashMap();
        String appKey = AppInfoProviderProxy.getAppKey();
        if (appKey == null) {
            appKey = "";
        }
        hashMap.put("appKey", appKey);
        String versionName = AppInfoProviderProxy.getVersionName();
        if (versionName == null) {
            versionName = "";
        }
        hashMap.put("ver", versionName);
        String ttid = AppInfoProviderProxy.getTTID();
        hashMap.put("pid", ttid != null ? ttid : "");
        hashMap.put("responsive", "0");
        String convertMapToDataStr = Utils.convertMapToDataStr(hashMap);
        b41.h(convertMapToDataStr, "convertMapToDataStr(systemInfo)");
        return convertMapToDataStr;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getApiName() {
        PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
        return companion.isDamaiApp() ? "mtop.damai.wireless.gaia.template.query" : companion.isTppApp() ? "mtop.taopiaopiao.wireless.gaia.template.query" : "";
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public MethodEnum getHttpMethod() {
        return MethodEnum.POST;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedEcode() {
        return false;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    public boolean getNeedSession() {
        return false;
    }

    @NotNull
    public final Query getQuery() {
        return this.query;
    }

    @NotNull
    public final String getSystemInfo() {
        return this.systemInfo;
    }

    @Override // com.youku.gaiax.provider.module.net.YYBaseMtopRequest
    @NotNull
    public String getVersion() {
        return "1.0";
    }

    public final void setQuery(@NotNull Query query) {
        b41.i(query, "<set-?>");
        this.query = query;
    }

    public final void setSystemInfo(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.systemInfo = str;
    }
}
