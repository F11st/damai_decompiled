package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Response;
import com.youku.arch.v3.io.IMtopResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/youku/arch/v3/data/OneMtopResponse;", "Lcom/youku/arch/v3/data/Response;", "Lcom/youku/arch/v3/io/IMtopResponse;", "", "responseCode", "I", "getResponseCode", "()I", "setResponseCode", "(I)V", "", "mappingCode", "Ljava/lang/String;", "getMappingCode", "()Ljava/lang/String;", "setMappingCode", "(Ljava/lang/String;)V", "Lcom/youku/arch/v3/data/OneMtopResponse$Builder;", "builder", "<init>", "(Lcom/youku/arch/v3/data/OneMtopResponse$Builder;)V", "Builder", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class OneMtopResponse extends Response implements IMtopResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String mappingCode;
    private int responseCode;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/youku/arch/v3/data/OneMtopResponse$Builder;", "Lcom/youku/arch/v3/data/Response$Builder;", "", "responseCode", "setResponseCode", "", "mappingCode", "setMappingCode", "Lcom/youku/arch/v3/data/Response;", "build", "<set-?>", "I", "getResponseCode", "()I", "Ljava/lang/String;", "getMappingCode", "()Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Builder extends Response.Builder {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String mappingCode;
        private int responseCode;

        @Override // com.youku.arch.v3.data.Response.Builder
        @NotNull
        public Response build() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1852499855") ? (Response) ipChange.ipc$dispatch("-1852499855", new Object[]{this}) : new OneMtopResponse(this);
        }

        @Nullable
        public final String getMappingCode() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2132942174") ? (String) ipChange.ipc$dispatch("-2132942174", new Object[]{this}) : this.mappingCode;
        }

        public final int getResponseCode() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "485987158") ? ((Integer) ipChange.ipc$dispatch("485987158", new Object[]{this})).intValue() : this.responseCode;
        }

        @NotNull
        public final Builder setMappingCode(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-306575037")) {
                return (Builder) ipChange.ipc$dispatch("-306575037", new Object[]{this, str});
            }
            this.mappingCode = str;
            return this;
        }

        @NotNull
        public final Builder setResponseCode(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-435678645")) {
                return (Builder) ipChange.ipc$dispatch("-435678645", new Object[]{this, Integer.valueOf(i)});
            }
            this.responseCode = i;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneMtopResponse(@NotNull Builder builder) {
        super(builder);
        b41.i(builder, "builder");
        this.responseCode = builder.getResponseCode();
        this.mappingCode = builder.getMappingCode();
    }

    @Override // com.youku.arch.v3.io.IMtopResponse
    @Nullable
    public String getMappingCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "871283737") ? (String) ipChange.ipc$dispatch("871283737", new Object[]{this}) : this.mappingCode;
    }

    @Override // com.youku.arch.v3.io.IMtopResponse
    public int getResponseCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "289422029") ? ((Integer) ipChange.ipc$dispatch("289422029", new Object[]{this})).intValue() : this.responseCode;
    }

    public void setMappingCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059959171")) {
            ipChange.ipc$dispatch("-1059959171", new Object[]{this, str});
        } else {
            this.mappingCode = str;
        }
    }

    public void setResponseCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161549707")) {
            ipChange.ipc$dispatch("-1161549707", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.responseCode = i;
        }
    }
}
