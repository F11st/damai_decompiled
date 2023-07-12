package cn.damai.search.component.feed;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.onearch.view.AbsPresenter;
import cn.damai.search.component.feed.ContentContract;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.event.EventHandler;
import tb.c82;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ContentPresenter extends AbsPresenter<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>, ContentContract.View> implements ContentContract.Presenter<IItem<ItemValue>, ContentContract.Model<IItem<ItemValue>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public ContentPresenter(String str, String str2, View view, EventHandler eventHandler, String str3) {
        super(str, str2, view, eventHandler, str3);
    }

    private Context getContext2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126287702")) {
            return (Context) ipChange.ipc$dispatch("-1126287702", new Object[]{this});
        }
        VIEW view = this.view;
        if (view == 0 || ((ContentContract.View) view).getRenderView() == null) {
            return null;
        }
        return ((ContentContract.View) this.view).getRenderView().getContext();
    }

    @Override // cn.damai.search.component.feed.ContentContract.Presenter
    public void exposeContentCard(View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926507888")) {
            ipChange.ipc$dispatch("1926507888", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        } else {
            userTrackExpose(view, c82.j(getTrackArgs(), noteBean));
        }
    }

    @Override // cn.damai.search.component.feed.ContentContract.Presenter
    public void gotoContentActivity(NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799715894")) {
            ipChange.ipc$dispatch("1799715894", new Object[]{this, noteBean, Integer.valueOf(i)});
            return;
        }
        Context context2 = getContext2();
        if (context2 != null) {
            if (TextUtils.isEmpty(noteBean.schema)) {
                Bundle bundle = new Bundle();
                bundle.putString("contentId", noteBean.id);
                DMNav.from(context2).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
            } else {
                DMNav.from(context2).toUri(noteBean.schema);
            }
            userTrackClick(c82.j(getTrackArgs(), noteBean), true);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290696797")) {
            ipChange.ipc$dispatch("-1290696797", new Object[]{this, iItem});
            return;
        }
        super.init(iItem);
        ((ContentContract.View) this.view).render(((ContentContract.Model) this.model).getNoteBean(), iItem.getIndex());
    }
}
