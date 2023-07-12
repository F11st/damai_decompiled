package com.alibaba.pictures.dolores.business;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.dc0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/alibaba/pictures/dolores/business/Result;", "BizResponse", "", "", "isSuccess", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "", "api", "Ljava/lang/String;", "getApi", "()Ljava/lang/String;", "setApi", "(Ljava/lang/String;)V", "", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "Ltb/dc0;", "response", "Ltb/dc0;", "getResponse", "()Ltb/dc0;", "setResponse", "(Ltb/dc0;)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public class Result<BizResponse> implements Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String api;
    @Nullable
    private Boolean isSuccess;
    @Nullable
    private dc0<BizResponse> response;
    @Nullable
    private Object tag;

    @NotNull
    public Object clone() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-712079600") ? ipChange.ipc$dispatch("-712079600", new Object[]{this}) : super.clone();
    }

    @Nullable
    public final String getApi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311044199") ? (String) ipChange.ipc$dispatch("-311044199", new Object[]{this}) : this.api;
    }

    @Nullable
    public final dc0<BizResponse> getResponse() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1278325726") ? (dc0) ipChange.ipc$dispatch("1278325726", new Object[]{this}) : this.response;
    }

    @Nullable
    public final Object getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2124841045") ? ipChange.ipc$dispatch("-2124841045", new Object[]{this}) : this.tag;
    }

    @Nullable
    public final Boolean isSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "130357187") ? (Boolean) ipChange.ipc$dispatch("130357187", new Object[]{this}) : this.isSuccess;
    }

    public final void setApi(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366112509")) {
            ipChange.ipc$dispatch("366112509", new Object[]{this, str});
        } else {
            this.api = str;
        }
    }

    public final void setResponse(@Nullable dc0<BizResponse> dc0Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213711978")) {
            ipChange.ipc$dispatch("213711978", new Object[]{this, dc0Var});
        } else {
            this.response = dc0Var;
        }
    }

    public final void setSuccess(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670474845")) {
            ipChange.ipc$dispatch("-670474845", new Object[]{this, bool});
        } else {
            this.isSuccess = bool;
        }
    }

    public final void setTag(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377184143")) {
            ipChange.ipc$dispatch("377184143", new Object[]{this, obj});
        } else {
            this.tag = obj;
        }
    }
}
