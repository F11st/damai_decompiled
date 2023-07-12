package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class DmInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @JvmField
    @Nullable
    public ArrayList<String> allDmTags;
    @JvmField
    @Nullable
    public String dmHeadImageUrl;
    @Nullable
    private Long dmId;
    @JvmField
    @Nullable
    public String dmName;
    @JvmField
    @Nullable
    public ArrayList<String> dmTags;

    @Nullable
    public final Long getDmId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1162851931") ? (Long) ipChange.ipc$dispatch("-1162851931", new Object[]{this}) : this.dmId;
    }

    public final void setDmId(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555046621")) {
            ipChange.ipc$dispatch("-1555046621", new Object[]{this, l});
        } else {
            this.dmId = l;
        }
    }
}
