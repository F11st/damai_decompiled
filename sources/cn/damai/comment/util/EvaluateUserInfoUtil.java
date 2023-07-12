package cn.damai.comment.util;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.UserTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;
import tb.zk;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class EvaluateUserInfoUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnClickUserExtraListener {
        void onUserExtraLister(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private static class a {
        private static final EvaluateUserInfoUtil a = new EvaluateUserInfoUtil();
    }

    public static final EvaluateUserInfoUtil a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2112246299") ? (EvaluateUserInfoUtil) ipChange.ipc$dispatch("2112246299", new Object[0]) : a.a;
    }

    public void b(CommentUserDoBean commentUserDoBean, DMAvatar dMAvatar, ImageView imageView, TextView textView, UserTagView userTagView, int i) {
        int parseInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337338617")) {
            ipChange.ipc$dispatch("-1337338617", new Object[]{this, commentUserDoBean, dMAvatar, imageView, textView, userTagView, Integer.valueOf(i)});
            return;
        }
        if (commentUserDoBean != null && !TextUtils.isEmpty(commentUserDoBean.getHeaderImage())) {
            dMAvatar.setAvatar(commentUserDoBean.getHeaderImage());
        } else {
            dMAvatar.setAvatarPlaceholder(R$drawable.uikit_user_default_icon);
        }
        if (commentUserDoBean != null && commentUserDoBean.isVip()) {
            dMAvatar.setAvatarCrownVisibility(0);
            dMAvatar.setAvatarBorderVisibility(0);
            zk.b(imageView, commentUserDoBean.getVipLevelIcon());
        } else {
            imageView.setVisibility(8);
            dMAvatar.setAvatarCrownVisibility(8);
            dMAvatar.setAvatarBorderVisibility(8);
        }
        if (commentUserDoBean != null) {
            dMAvatar.setYYMemberTagView(commentUserDoBean.isVip(), commentUserDoBean.getMemberFlag());
            if (!TextUtils.isEmpty(commentUserDoBean.getNickname())) {
                textView.setText(commentUserDoBean.getNickname());
            } else {
                textView.setText("");
            }
            if (userTagView != null) {
                if (commentUserDoBean.getUserTypeCode() == 3 && (i == 1 || i == 2)) {
                    userTagView.setTagNameVisibility(8);
                    userTagView.setIconSize(mu0.a(), 63, 16);
                    userTagView.setTagType(commentUserDoBean.getUserTypeCode(), true);
                } else {
                    userTagView.setVisibility(8);
                }
            }
        } else {
            textView.setText("");
        }
        if (commentUserDoBean != null) {
            try {
                parseInt = Integer.parseInt(commentUserDoBean.getvTag());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (parseInt <= 0 && (commentUserDoBean == null || commentUserDoBean.isVip() || !commentUserDoBean.isPerformFilmVip())) {
                dMAvatar.setAvatarVTagVisibility(0);
                return;
            } else {
                dMAvatar.setAvatarVTagVisibility(8);
            }
        }
        parseInt = 0;
        if (parseInt <= 0) {
        }
        dMAvatar.setAvatarVTagVisibility(8);
    }
}
