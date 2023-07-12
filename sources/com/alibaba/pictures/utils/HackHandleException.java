package com.alibaba.pictures.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0013\b\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u000fR(\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/alibaba/pictures/utils/HackHandleException;", "", "Ljava/lang/Class;", "hackedClass", "Ljava/lang/Class;", "getHackedClass", "()Ljava/lang/Class;", "setHackedClass", "(Ljava/lang/Class;)V", "", "hackedMethodName", "Ljava/lang/String;", "getHackedMethodName", "()Ljava/lang/String;", "setHackedMethodName", "(Ljava/lang/String;)V", "hackedFieldName", "getHackedFieldName", "setHackedFieldName", "Ljava/lang/Exception;", "cause", "<init>", "(Ljava/lang/Exception;)V", "message", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class HackHandleException extends Throwable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Class<?> hackedClass;
    @Nullable
    private String hackedFieldName;
    @Nullable
    private String hackedMethodName;

    public HackHandleException(@Nullable Exception exc) {
        super(exc);
    }

    @Nullable
    public final Class<?> getHackedClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1040434191") ? (Class) ipChange.ipc$dispatch("1040434191", new Object[]{this}) : this.hackedClass;
    }

    @Nullable
    public final String getHackedFieldName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "130554027") ? (String) ipChange.ipc$dispatch("130554027", new Object[]{this}) : this.hackedFieldName;
    }

    @Nullable
    public final String getHackedMethodName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1677609340") ? (String) ipChange.ipc$dispatch("1677609340", new Object[]{this}) : this.hackedMethodName;
    }

    public final void setHackedClass(@Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770359695")) {
            ipChange.ipc$dispatch("770359695", new Object[]{this, cls});
        } else {
            this.hackedClass = cls;
        }
    }

    public final void setHackedFieldName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34020907")) {
            ipChange.ipc$dispatch("34020907", new Object[]{this, str});
        } else {
            this.hackedFieldName = str;
        }
    }

    public final void setHackedMethodName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705512734")) {
            ipChange.ipc$dispatch("-705512734", new Object[]{this, str});
        } else {
            this.hackedMethodName = str;
        }
    }

    public HackHandleException(@Nullable String str) {
        super(str);
    }
}
