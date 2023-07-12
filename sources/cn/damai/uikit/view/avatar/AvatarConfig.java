package cn.damai.uikit.view.avatar;

import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AvatarConfig implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean clearDrawableWhenDiffUrlSet;
    public int innerBorderDrawableRid;
    public int outBorderDrawableRid;
    public int placeHolderDrawableRid;
    public boolean showOutBorder;
    public boolean showVTag;
    public int yyTagDrawableRid;

    public AvatarConfig() {
        this.innerBorderDrawableRid = R$drawable.uikit_dm_avatar_inner_border;
        this.outBorderDrawableRid = -1;
        this.placeHolderDrawableRid = R$drawable.uikit_account_place_holder_default;
        this.showOutBorder = false;
        this.yyTagDrawableRid = -1;
        this.showVTag = false;
        this.clearDrawableWhenDiffUrlSet = true;
    }

    public static AvatarConfig blackDiamondConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2020357303") ? (AvatarConfig) ipChange.ipc$dispatch("2020357303", new Object[0]) : new AvatarConfig(R$drawable.avatar_out_border_868bff, true, R$drawable.dm_yy_black_member_icon);
    }

    public static AvatarConfig defaultConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "951093117") ? (AvatarConfig) ipChange.ipc$dispatch("951093117", new Object[0]) : new AvatarConfig();
    }

    public static AvatarConfig mineTabNoneLoginConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362229213")) {
            return (AvatarConfig) ipChange.ipc$dispatch("362229213", new Object[0]);
        }
        AvatarConfig avatarConfig = new AvatarConfig();
        avatarConfig.placeHolderDrawableRid = R$drawable.mine_icon_user_default_none_login;
        return avatarConfig;
    }

    public static AvatarConfig normalDiamondConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-160186863") ? (AvatarConfig) ipChange.ipc$dispatch("-160186863", new Object[0]) : new AvatarConfig(R$drawable.avatar_out_border_ffaf86, true, R$drawable.dm_yy_member_icon);
    }

    public static AvatarConfig vTagConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586761384")) {
            return (AvatarConfig) ipChange.ipc$dispatch("586761384", new Object[0]);
        }
        AvatarConfig avatarConfig = new AvatarConfig();
        avatarConfig.showVTag = true;
        return avatarConfig;
    }

    public int getInnerBorderDrawableRid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1786326382") ? ((Integer) ipChange.ipc$dispatch("1786326382", new Object[]{this})).intValue() : this.innerBorderDrawableRid;
    }

    public int getOutBorderDrawableRid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "586355494") ? ((Integer) ipChange.ipc$dispatch("586355494", new Object[]{this})).intValue() : this.outBorderDrawableRid;
    }

    public int getPlaceHolderDrawableRid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825779487") ? ((Integer) ipChange.ipc$dispatch("1825779487", new Object[]{this})).intValue() : this.placeHolderDrawableRid;
    }

    public int getYyTagDrawableRid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-567026714") ? ((Integer) ipChange.ipc$dispatch("-567026714", new Object[]{this})).intValue() : this.yyTagDrawableRid;
    }

    public boolean isShowOutBorder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1296904145") ? ((Boolean) ipChange.ipc$dispatch("-1296904145", new Object[]{this})).booleanValue() : this.showOutBorder;
    }

    public boolean isShowVTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-941912155") ? ((Boolean) ipChange.ipc$dispatch("-941912155", new Object[]{this})).booleanValue() : this.showVTag;
    }

    public AvatarConfig(int i, boolean z, int i2) {
        this.innerBorderDrawableRid = R$drawable.uikit_dm_avatar_inner_border;
        this.outBorderDrawableRid = -1;
        this.placeHolderDrawableRid = R$drawable.uikit_account_place_holder_default;
        this.showOutBorder = false;
        this.yyTagDrawableRid = -1;
        this.showVTag = false;
        this.clearDrawableWhenDiffUrlSet = true;
        this.outBorderDrawableRid = i;
        this.showOutBorder = z;
        this.yyTagDrawableRid = i2;
    }
}
