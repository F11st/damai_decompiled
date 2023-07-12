package com.alibaba.pictures.bricks.coupon.order.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GxTemplate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String bizId;
    @NotNull
    private final String templateId;
    @Nullable
    private String templateVersion;

    public GxTemplate(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        this.bizId = str;
        this.templateId = str2;
        this.templateVersion = str3;
    }

    @NotNull
    public final String getBizId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "983933855") ? (String) ipChange.ipc$dispatch("983933855", new Object[]{this}) : this.bizId;
    }

    @NotNull
    public final String getTemplateId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "638535930") ? (String) ipChange.ipc$dispatch("638535930", new Object[]{this}) : this.templateId;
    }

    @Nullable
    public final String getTemplateVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2105993615") ? (String) ipChange.ipc$dispatch("2105993615", new Object[]{this}) : this.templateVersion;
    }

    public final void setTemplateVersion(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143105991")) {
            ipChange.ipc$dispatch("1143105991", new Object[]{this, str});
        } else {
            this.templateVersion = str;
        }
    }
}
