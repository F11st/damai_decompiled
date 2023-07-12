package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class InFieldCommentsBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GROUP = "GROUP";
    public static final String STRATEGY = "STRATEGY";
    private static final long serialVersionUID = -3024366000535311922L;
    public String comment;
    public String groupJumpUrl;
    public String id;
    public int index;
    public String nickName;
    public String picUrl;
    public String showVideoIcon;
    public String type;
    public String userPic;

    public boolean isCanDowngradeToStrategy() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2026158979") ? ((Boolean) ipChange.ipc$dispatch("-2026158979", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.id);
    }

    public boolean isTypeGROUP() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2087935805") ? ((Boolean) ipChange.ipc$dispatch("2087935805", new Object[]{this})).booleanValue() : TextUtils.equals(GROUP, this.type);
    }

    public boolean isTypeStrategy() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-498400861") ? ((Boolean) ipChange.ipc$dispatch("-498400861", new Object[]{this})).booleanValue() : TextUtils.equals(STRATEGY, this.type);
    }
}
