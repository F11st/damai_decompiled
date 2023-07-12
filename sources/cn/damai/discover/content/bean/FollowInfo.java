package cn.damai.discover.content.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.discover.content.net.ContentCard;
import cn.damai.login.LoginManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FollowInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentId;
    public int focusCount;
    public boolean isFocus;
    public final List<FollowedUser> mUsers;
    public boolean needAnimation;
    public boolean needSetUiMarginTop;
    public String targetId;
    public String targetType;

    public FollowInfo(ContentDetail contentDetail, ContentCard contentCard) {
        ScriptBean scriptBean;
        ArrayList arrayList = new ArrayList();
        this.mUsers = arrayList;
        boolean z = false;
        this.needAnimation = false;
        this.isFocus = false;
        this.needSetUiMarginTop = false;
        if (contentDetail != null) {
            this.isFocus = contentDetail.focus;
            this.contentId = contentDetail.contentId;
            this.focusCount = contentDetail.focusCount;
            if (!cb2.d(contentDetail.focusList)) {
                arrayList.addAll(contentDetail.focusList);
            }
        }
        if (contentDetail != null && contentDetail.itemType == 2 && (scriptBean = contentDetail.scriptInfo) != null) {
            this.targetType = "25";
            this.targetId = scriptBean.getId();
        } else if (contentCard != null) {
            this.targetType = contentCard.targetType;
            this.targetId = contentCard.targetId;
        }
        this.needSetUiMarginTop = (contentCard == null || !contentCard.isHasBody()) ? true : true;
    }

    public boolean isHasFlowParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1381032784") ? ((Boolean) ipChange.ipc$dispatch("1381032784", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.targetType) || TextUtils.isEmpty(this.targetId)) ? false : true;
    }

    public void updateMyFollowFromFollowList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658383961")) {
            ipChange.ipc$dispatch("658383961", new Object[]{this, Boolean.valueOf(z)});
        } else if (LoginManager.k().q()) {
            String E = z20.E();
            String i = z20.i();
            if (TextUtils.isEmpty(E)) {
                return;
            }
            String str = null;
            try {
                str = z20.B(Login.getHeadPicLink());
            } catch (Exception e) {
                e.printStackTrace();
            }
            FollowedUser followedUser = new FollowedUser(E, i, str);
            if (z) {
                this.focusCount++;
                this.mUsers.remove(followedUser);
                this.mUsers.add(0, followedUser);
                return;
            }
            this.mUsers.remove(followedUser);
            this.focusCount--;
        }
    }
}
