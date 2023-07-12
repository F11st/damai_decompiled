package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.discover.bean.ContentShareInfo;
import cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.uikit.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ac implements BigNoteBindListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;

    public ac(Activity activity) {
        this.a = activity;
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746213031")) {
            return ((Boolean) ipChange.ipc$dispatch("746213031", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    private void d(NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "915404795")) {
            ipChange.ipc$dispatch("915404795", new Object[]{this, noteBean});
            return;
        }
        Bundle bundle = new Bundle();
        if (noteBean.relatedInfo != null) {
            bundle.putString("themeId", "0");
            bundle.putString(g41.ISSUE_PARAM_LIVE_THEME_NAME, noteBean.relatedInfo.value);
        }
        if (noteBean.extraRelatedInfo != null) {
            bundle.putString("circleId", "0");
            bundle.putString("circleName", noteBean.extraRelatedInfo.value);
        }
        bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
        bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, noteBean.sourceId);
        DMNav.from(this.a).withExtras(bundle).forResult(2020).toUri(NavUri.b("issue"));
    }

    private void e(NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000230382")) {
            ipChange.ipc$dispatch("-2000230382", new Object[]{this, noteBean});
            return;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("targetId", noteBean.id);
            bundle.putInt("targetType", jm1.j(noteBean.subType, 1));
            bundle.putInt("type", 5);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("report"));
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void OnPraiseViewClickReport(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997682619")) {
            ipChange.ipc$dispatch("997682619", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        }
    }

    public void b(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822227063")) {
            ipChange.ipc$dispatch("-822227063", new Object[]{this, noteBean, Integer.valueOf(i)});
        }
    }

    public void c(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852375328")) {
            ipChange.ipc$dispatch("-852375328", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("contentId", noteBean.id);
        bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
        NavProxy.from(this.a).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_CONTENT_DETAIL));
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void dnaOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689215043")) {
            ipChange.ipc$dispatch("-1689215043", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void hookExposeItem(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1706241016")) {
            ipChange.ipc$dispatch("-1706241016", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void likeOnClickReport(boolean z, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775235023")) {
            ipChange.ipc$dispatch("-1775235023", new Object[]{this, Boolean.valueOf(z), str, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
        rm1.a(this, noteBean, i);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void onMoreActionClick(NoteBean noteBean, BottomActionDialog.Action action, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713597076")) {
            ipChange.ipc$dispatch("-713597076", new Object[]{this, noteBean, action, Integer.valueOf(i)});
        } else if (!a() || noteBean == null || action == null || TextUtils.isEmpty(action.name)) {
        } else {
            String str = action.name;
            str.hashCode();
            if (str.equals(BottomActionDialog.REPORT)) {
                e(noteBean);
            } else if (str.equals(BottomActionDialog.EDIT)) {
                b(noteBean, i);
                d(noteBean);
            }
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void shareClick(NoteBean noteBean, ContentShareInfo contentShareInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281955284")) {
            ipChange.ipc$dispatch("1281955284", new Object[]{this, noteBean, contentShareInfo, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BigNoteBindListener
    public void userOnClickReport(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665754927")) {
            ipChange.ipc$dispatch("665754927", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
    }
}
