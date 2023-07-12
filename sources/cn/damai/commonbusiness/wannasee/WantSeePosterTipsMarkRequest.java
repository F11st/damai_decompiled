package cn.damai.commonbusiness.wannasee;

import cn.damai.network.ApiConstant;
import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeePosterTipsMarkRequest extends DamaiBaseRequest<Object> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int operateType;
    @Nullable
    private String targetId;
    private int targetType;

    public WantSeePosterTipsMarkRequest() {
        this.API_NAME = ApiConstant.API_NAME_RELATION_UPDATE;
        this.VERSION = "1.2";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
        this.operateType = 1;
        this.targetType = 31;
    }

    public final int getOperateType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "655165228") ? ((Integer) ipChange.ipc$dispatch("655165228", new Object[]{this})).intValue() : this.operateType;
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1729460679") ? (String) ipChange.ipc$dispatch("-1729460679", new Object[]{this}) : this.targetId;
    }

    public final int getTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1651041413") ? ((Integer) ipChange.ipc$dispatch("-1651041413", new Object[]{this})).intValue() : this.targetType;
    }

    public final void setOperateType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244650914")) {
            ipChange.ipc$dispatch("-244650914", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.operateType = i;
        }
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956001339")) {
            ipChange.ipc$dispatch("-1956001339", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }

    public final void setTargetType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582799225")) {
            ipChange.ipc$dispatch("-582799225", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.targetType = i;
        }
    }
}
