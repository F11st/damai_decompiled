package cn.damai.user.userhome.view.usercenter;

import android.view.View;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface HeadUserTrackListener {
    void onExposeDnaLayout(View view);

    void onUtDNAViewClick(boolean z);

    void onUtFollowChangeClick(boolean z);

    void onUtHeadAvatarClick();

    void onUtHeadBackImgClick();

    void onUtOpenLoginPageClick();

    void onUtOpenRealNameAuthClick(RealNameAuthStatusBean realNameAuthStatusBean);

    void onUtOpenRelateInfoClick(String str);

    void onUtOpenUserInfoEditClick();
}
