package cn.damai.onearch.component.project;

import android.view.View;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.onearch.component.project.OneProject;
import cn.damai.onearch.component.project.OneProjectPresent;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class OneProjectPresent extends AbsPresenter<GenericItem<ItemValue>, OneProjectModel, OneProjectView> implements OneProject.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneProjectPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-2$lambda-1  reason: not valid java name */
    public static final void m65init$lambda2$lambda1(OneProjectPresent oneProjectPresent, View view) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854741213")) {
            ipChange.ipc$dispatch("854741213", new Object[]{oneProjectPresent, view});
            return;
        }
        b41.i(oneProjectPresent, "this$0");
        Action itemAction = oneProjectPresent.getItemAction();
        if (itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938410361")) {
            ipChange.ipc$dispatch("938410361", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((OneProjectPresent) genericItem);
        ProjectItemViewHolder viewHolder = ((OneProjectView) getView()).getViewHolder();
        viewHolder.n(((OneProjectModel) getModel()).getProject(), true);
        viewHolder.w(new View.OnClickListener() { // from class: tb.tm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OneProjectPresent.m65init$lambda2$lambda1(OneProjectPresent.this, view);
            }
        });
        Action itemAction = getItemAction();
        if (itemAction == null || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.expose(((OneProjectView) getView()).getRenderView(), trackInfo);
    }
}
