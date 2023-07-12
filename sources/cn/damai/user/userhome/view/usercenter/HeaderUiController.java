package cn.damai.user.userhome.view.usercenter;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.user.userhome.bean.UserHomeDataBean;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface HeaderUiController extends GetAttentionView {
    void hideRealNameAuthView();

    void setBGAtmosphereUrl(String str);

    void setUserAvatarUrl(String str);

    void setUserNickView(String str);

    void showEmptyHeadView(ModeEmpty modeEmpty);

    void update(UserHomeDataBean userHomeDataBean, @Nullable RealNameAuthStatusBean realNameAuthStatusBean);
}
