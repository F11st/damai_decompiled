package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.alibaba.pictures.bricks.component.home.feed.VoteContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VotePresent extends AbsPresenter<GenericItem<ItemValue>, VoteModel, VoteView> implements VoteContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VotePresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    @NotNull
    public final Map<String, String> getTrackArgs(@Nullable VoteBean voteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86257796")) {
            return (Map) ipChange.ipc$dispatch("-86257796", new Object[]{this, voteBean});
        }
        Map<String, String> trackArgs = getTrackArgs();
        b41.h(trackArgs, "trackArgs");
        trackArgs.put("card_id", voteBean != null ? voteBean.id : null);
        return trackArgs;
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.VoteContract.Present
    public void ut4CancelVoteClick(@Nullable VoteInfoBean voteInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "153966806")) {
            ipChange.ipc$dispatch("153966806", new Object[]{this, voteInfoBean});
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.VoteContract.Present
    public void ut4VoteCardExposure(@Nullable View view, @Nullable VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797321062")) {
            ipChange.ipc$dispatch("-797321062", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.VoteContract.Present
    public void ut4VoteClick(@Nullable VoteInfoBean voteInfoBean, @Nullable VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888813049")) {
            ipChange.ipc$dispatch("-888813049", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272913257")) {
            ipChange.ipc$dispatch("1272913257", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((VotePresent) genericItem);
        VoteInfoBean value = ((VoteModel) getModel()).getValue();
        b41.h(value, "model.value");
        ((VoteView) getView()).bindView(value);
    }
}
