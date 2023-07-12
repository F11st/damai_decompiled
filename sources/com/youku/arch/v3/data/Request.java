package com.youku.arch.v3.data;

import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.util.IdGenerator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001JB\u0011\b\u0016\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GB\u0011\b\u0016\u0012\u0006\u0010H\u001a\u00020\u0000¢\u0006\u0004\bF\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\"\u0010!\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010#\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\"\u0010/\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR0\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000203\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R0\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010>\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006K"}, d2 = {"Lcom/youku/arch/v3/data/Request;", "Lcom/youku/arch/v3/io/IRequest;", "", "data", "Ltb/wt2;", "setData", "", "id", "J", "getId", "()J", "setId", "(J)V", "apiName", "Ljava/lang/String;", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "cacheTag", "getCacheTag", "setCacheTag", "", "isNeedECode", "Z", "()Z", "setNeedECode", "(Z)V", "isNeedSession", "setNeedSession", "isNeedCache", "setNeedCache", "isSync", "setSync", "", "timeout", "I", "getTimeout", "()I", "setTimeout", "(I)V", "customDomain", "getCustomDomain", "setCustomDomain", "strategy", "getStrategy", "setStrategy", "", "", "dataParams", "Ljava/util/Map;", "getDataParams", "()Ljava/util/Map;", "setDataParams", "(Ljava/util/Map;)V", "headers", "getHeaders", "setHeaders", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "Lcom/youku/arch/v3/data/Request$Builder;", "builder", "<init>", "(Lcom/youku/arch/v3/data/Request$Builder;)V", "request", "(Lcom/youku/arch/v3/data/Request;)V", "Builder", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Request implements IRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String apiName;
    @Nullable
    private Bundle bundle;
    @Nullable
    private String cacheTag;
    @Nullable
    private String customDomain;
    @Nullable
    private Map<String, Object> dataParams;
    @Nullable
    private Map<String, String> headers;
    private long id;
    private boolean isNeedCache;
    private boolean isNeedECode;
    private boolean isNeedSession;
    private boolean isSync;
    private long strategy;
    private int timeout;
    @Nullable
    private String version;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010J\u001c\u0010\u0017\u001a\u00020\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J\u001c\u0010\u0019\u001a\u00020\u00002\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0002J\u0010\u0010#\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u0006\u0010%\u001a\u00020$R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010&R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010(R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010)R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010*R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010*R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010&¨\u0006/"}, d2 = {"Lcom/youku/arch/v3/data/Request$Builder;", "", "", "apiName", "setApiName", "version", "setVersion", "", "needCache", "setNeedCache", "needECode", "setNeedECode", "needSession", "setNeedSession", "isSync", "setIsSync", "", "strategy", "setStrategy", "requestId", "setRequestId", "", "dataParams", "setDataParams", "headers", "setHeaders", "Landroid/os/Bundle;", "bundle", "setBundle", "", "timeout", "setTimeout", "cacheTag", "setCacheTag", "domain", "setCustomDomain", "Lcom/youku/arch/v3/data/Request;", "build", "Ljava/lang/String;", "J", "Z", "I", "Ljava/util/Map;", "Landroid/os/Bundle;", "customDomain", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Builder {
        private static transient /* synthetic */ IpChange $ipChange;
        @JvmField
        @Nullable
        public String apiName;
        @JvmField
        @Nullable
        public Bundle bundle;
        @JvmField
        @Nullable
        public String cacheTag;
        @JvmField
        @Nullable
        public String customDomain;
        @JvmField
        @Nullable
        public Map<String, Object> dataParams;
        @JvmField
        @Nullable
        public Map<String, String> headers;
        @JvmField
        public boolean isSync;
        @JvmField
        public boolean needCache;
        @JvmField
        public boolean needECode;
        @JvmField
        public boolean needSession;
        @JvmField
        public long requestId;
        @JvmField
        public long strategy = 2;
        @JvmField
        public int timeout;
        @JvmField
        @Nullable
        public String version;

        @NotNull
        public final Request build() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1161702197") ? (Request) ipChange.ipc$dispatch("1161702197", new Object[]{this}) : new Request(this);
        }

        @NotNull
        public final Builder setApiName(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "653310573")) {
                return (Builder) ipChange.ipc$dispatch("653310573", new Object[]{this, str});
            }
            this.apiName = str;
            return this;
        }

        @NotNull
        public final Builder setBundle(@Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2126991782")) {
                return (Builder) ipChange.ipc$dispatch("2126991782", new Object[]{this, bundle});
            }
            this.bundle = bundle;
            return this;
        }

        @NotNull
        public final Builder setCacheTag(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "827497664")) {
                return (Builder) ipChange.ipc$dispatch("827497664", new Object[]{this, str});
            }
            this.cacheTag = str;
            return this;
        }

        @NotNull
        public final Builder setCustomDomain(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2100423139")) {
                return (Builder) ipChange.ipc$dispatch("-2100423139", new Object[]{this, str});
            }
            this.customDomain = str;
            return this;
        }

        @NotNull
        public final Builder setDataParams(@Nullable Map<String, Object> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-18709049")) {
                return (Builder) ipChange.ipc$dispatch("-18709049", new Object[]{this, map});
            }
            this.dataParams = map;
            return this;
        }

        @NotNull
        public final Builder setHeaders(@Nullable Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1505128271")) {
                return (Builder) ipChange.ipc$dispatch("-1505128271", new Object[]{this, map});
            }
            this.headers = map;
            return this;
        }

        @NotNull
        public final Builder setIsSync(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2128922659")) {
                return (Builder) ipChange.ipc$dispatch("2128922659", new Object[]{this, Boolean.valueOf(z)});
            }
            this.isSync = z;
            return this;
        }

        @NotNull
        public final Builder setNeedCache(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2001176580")) {
                return (Builder) ipChange.ipc$dispatch("-2001176580", new Object[]{this, Boolean.valueOf(z)});
            }
            this.needCache = z;
            return this;
        }

        @NotNull
        public final Builder setNeedECode(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2132072844")) {
                return (Builder) ipChange.ipc$dispatch("2132072844", new Object[]{this, Boolean.valueOf(z)});
            }
            this.needECode = z;
            return this;
        }

        @NotNull
        public final Builder setNeedSession(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "804433640")) {
                return (Builder) ipChange.ipc$dispatch("804433640", new Object[]{this, Boolean.valueOf(z)});
            }
            this.needSession = z;
            return this;
        }

        @NotNull
        public final Builder setRequestId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-638897202")) {
                return (Builder) ipChange.ipc$dispatch("-638897202", new Object[]{this, Long.valueOf(j)});
            }
            this.requestId = j;
            return this;
        }

        @NotNull
        public final Builder setStrategy(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "153172197")) {
                return (Builder) ipChange.ipc$dispatch("153172197", new Object[]{this, Long.valueOf(j)});
            }
            this.strategy = j;
            return this;
        }

        @NotNull
        public final Builder setTimeout(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1204383992")) {
                return (Builder) ipChange.ipc$dispatch("1204383992", new Object[]{this, Integer.valueOf(i)});
            }
            this.timeout = i;
            return this;
        }

        @NotNull
        public final Builder setVersion(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-257854208")) {
                return (Builder) ipChange.ipc$dispatch("-257854208", new Object[]{this, str});
            }
            this.version = str;
            return this;
        }
    }

    public Request(@NotNull Builder builder) {
        b41.i(builder, "builder");
        this.id = IdGenerator.getId();
        this.strategy = 2L;
        setApiName(builder.apiName);
        setId(builder.requestId);
        setVersion(builder.version);
        setNeedECode(builder.needECode);
        setNeedSession(builder.needSession);
        setSync(builder.isSync);
        setStrategy(builder.strategy);
        setDataParams(builder.dataParams);
        setHeaders(builder.headers);
        setNeedCache(builder.needCache);
        setBundle(builder.bundle);
        setTimeout(builder.timeout);
        setCacheTag(builder.cacheTag);
        setCustomDomain(builder.customDomain);
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1628354141") ? (String) ipChange.ipc$dispatch("-1628354141", new Object[]{this}) : this.apiName;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public Bundle getBundle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "925989450") ? (Bundle) ipChange.ipc$dispatch("925989450", new Object[]{this}) : this.bundle;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public String getCacheTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1028122704") ? (String) ipChange.ipc$dispatch("1028122704", new Object[]{this}) : this.cacheTag;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public String getCustomDomain() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "435751981") ? (String) ipChange.ipc$dispatch("435751981", new Object[]{this}) : this.customDomain;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public Map<String, Object> getDataParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1988859475") ? (Map) ipChange.ipc$dispatch("-1988859475", new Object[]{this}) : this.dataParams;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public Map<String, String> getHeaders() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-384185743") ? (Map) ipChange.ipc$dispatch("-384185743", new Object[]{this}) : this.headers;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1947114175") ? ((Long) ipChange.ipc$dispatch("-1947114175", new Object[]{this})).longValue() : this.id;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public long getStrategy() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1637410217") ? ((Long) ipChange.ipc$dispatch("1637410217", new Object[]{this})).longValue() : this.strategy;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public int getTimeout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "452927860") ? ((Integer) ipChange.ipc$dispatch("452927860", new Object[]{this})).intValue() : this.timeout;
    }

    @Override // com.youku.arch.v3.io.IRequest
    @Nullable
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "539382582") ? (String) ipChange.ipc$dispatch("539382582", new Object[]{this}) : this.version;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public boolean isNeedCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-78983808") ? ((Boolean) ipChange.ipc$dispatch("-78983808", new Object[]{this})).booleanValue() : this.isNeedCache;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public boolean isNeedECode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1403781360") ? ((Boolean) ipChange.ipc$dispatch("-1403781360", new Object[]{this})).booleanValue() : this.isNeedECode;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public boolean isNeedSession() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1203231828") ? ((Boolean) ipChange.ipc$dispatch("-1203231828", new Object[]{this})).booleanValue() : this.isNeedSession;
    }

    @Override // com.youku.arch.v3.io.IRequest
    public boolean isSync() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1240941835") ? ((Boolean) ipChange.ipc$dispatch("1240941835", new Object[]{this})).booleanValue() : this.isSync;
    }

    public void setApiName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555624397")) {
            ipChange.ipc$dispatch("-555624397", new Object[]{this, str});
        } else {
            this.apiName = str;
        }
    }

    public void setBundle(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837016294")) {
            ipChange.ipc$dispatch("-1837016294", new Object[]{this, bundle});
        } else {
            this.bundle = bundle;
        }
    }

    public void setCacheTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924704910")) {
            ipChange.ipc$dispatch("1924704910", new Object[]{this, str});
        } else {
            this.cacheTag = str;
        }
    }

    public void setCustomDomain(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021290577")) {
            ipChange.ipc$dispatch("1021290577", new Object[]{this, str});
        } else {
            this.customDomain = str;
        }
    }

    public final void setData(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258968996")) {
            ipChange.ipc$dispatch("-258968996", new Object[]{this, str});
        }
    }

    public void setDataParams(@Nullable Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748773351")) {
            ipChange.ipc$dispatch("-1748773351", new Object[]{this, map});
        } else {
            this.dataParams = map;
        }
    }

    public void setHeaders(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074968893")) {
            ipChange.ipc$dispatch("2074968893", new Object[]{this, map});
        } else {
            this.headers = map;
        }
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445583581")) {
            ipChange.ipc$dispatch("-445583581", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public void setNeedCache(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892737746")) {
            ipChange.ipc$dispatch("892737746", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNeedCache = z;
        }
    }

    public void setNeedECode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521280702")) {
            ipChange.ipc$dispatch("-1521280702", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNeedECode = z;
        }
    }

    public void setNeedSession(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397250138")) {
            ipChange.ipc$dispatch("-397250138", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNeedSession = z;
        }
    }

    public void setStrategy(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "130892475")) {
            ipChange.ipc$dispatch("130892475", new Object[]{this, Long.valueOf(j)});
        } else {
            this.strategy = j;
        }
    }

    public void setSync(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "728987251")) {
            ipChange.ipc$dispatch("728987251", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isSync = z;
        }
    }

    public void setTimeout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615844586")) {
            ipChange.ipc$dispatch("-615844586", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.timeout = i;
        }
    }

    public void setVersion(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075262720")) {
            ipChange.ipc$dispatch("-2075262720", new Object[]{this, str});
        } else {
            this.version = str;
        }
    }

    public Request(@NotNull Request request) {
        b41.i(request, "request");
        this.id = IdGenerator.getId();
        this.strategy = 2L;
        setApiName(request.getApiName());
        setVersion(request.getVersion());
        setDataParams(request.getDataParams());
        setHeaders(request.getHeaders());
        setSync(request.isSync());
        setNeedECode(request.isNeedECode());
        setNeedSession(request.isNeedSession());
        setTimeout(request.getTimeout());
        setCacheTag(request.getCacheTag());
        setCustomDomain(request.getCustomDomain());
    }
}
