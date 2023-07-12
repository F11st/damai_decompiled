package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BuyBtnVO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String btnStatus;
    @Nullable
    private String btnText;

    @Nullable
    public final String getBtnStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "718111953") ? (String) ipChange.ipc$dispatch("718111953", new Object[]{this}) : this.btnStatus;
    }

    @Nullable
    public final String getBtnText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262732916") ? (String) ipChange.ipc$dispatch("-262732916", new Object[]{this}) : this.btnText;
    }

    public final void setBtnStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178570811")) {
            ipChange.ipc$dispatch("-1178570811", new Object[]{this, str});
        } else {
            this.btnStatus = str;
        }
    }

    public final void setBtnText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171039382")) {
            ipChange.ipc$dispatch("-1171039382", new Object[]{this, str});
        } else {
            this.btnText = str;
        }
    }
}
