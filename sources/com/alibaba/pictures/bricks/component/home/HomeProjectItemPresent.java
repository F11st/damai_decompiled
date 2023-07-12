package com.alibaba.pictures.bricks.component.home;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.damai.category.category.ui.StarFragment;
import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import com.alibaba.pictures.bricks.component.home.HomeProjectItemPresent;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alibaba.pictures.bricks.onearch.TrackType;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.dc0;
import tb.wt2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeProjectItemPresent extends AbsPresenter<GenericItem<ItemValue>, HomeProjectItemModel, HomeProjectItemView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeProjectItemPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-3$lambda-2  reason: not valid java name */
    public static final void m117init$lambda3$lambda2(TextView textView, HomeProjectItemPresent homeProjectItemPresent, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036083143")) {
            ipChange.ipc$dispatch("2036083143", new Object[]{textView, homeProjectItemPresent, view});
            return;
        }
        b41.i(textView, "$this_apply");
        b41.i(homeProjectItemPresent, "this$0");
        textView.setTag(((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue().id);
        homeProjectItemPresent.requestToFollow(!((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue().followState(), ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue().id);
    }

    private final void requestToFollow(boolean z, String str) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754274060")) {
            ipChange.ipc$dispatch("-1754274060", new Object[]{this, Boolean.valueOf(z), str});
        } else if (DoloresLoginHandler.Companion.a().c()) {
            FollowUpdateRequest followUpdateRequest = new FollowUpdateRequest();
            followUpdateRequest.init(z, str);
            cc0.a(followUpdateRequest).doOnKTStart(new Function1<DoloresRequest<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.HomeProjectItemPresent$requestToFollow$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(DoloresRequest<FollowStateBean> doloresRequest) {
                    invoke2(doloresRequest);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable DoloresRequest<FollowStateBean> doloresRequest) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-148767844")) {
                        ipChange2.ipc$dispatch("-148767844", new Object[]{this, doloresRequest});
                    }
                }
            }).doOnKTSuccess(new Function1<FollowStateBean, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.HomeProjectItemPresent$requestToFollow$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(FollowStateBean followStateBean) {
                    invoke2(followStateBean);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FollowStateBean followStateBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1940888620")) {
                        ipChange2.ipc$dispatch("1940888620", new Object[]{this, followStateBean});
                        return;
                    }
                    b41.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
                    HomeProjectItemPresent homeProjectItemPresent = HomeProjectItemPresent.this;
                    boolean isFollowed = followStateBean.isFollowed();
                    ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue().isFollow = isFollowed ? "true" : "false";
                    ((GenericItem) homeProjectItemPresent.getItem()).getComponent().getProperty().getData();
                    ((HomeProjectItemView) homeProjectItemPresent.getView()).updateWantSeeBtn(isFollowed);
                    if (isFollowed) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("id", ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue().id);
                        EventDispatcher eventDispatcher = ((GenericItem) homeProjectItemPresent.getItem()).getPageContext().getEventDispatcher();
                        if (eventDispatcher != null) {
                            eventDispatcher.dispatchEvent("EventBus://fragment/notification/home/item/follow-request", hashMap);
                        }
                    }
                }
            }).doOnKTFail(new Function1<dc0<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.home.HomeProjectItemPresent$requestToFollow$4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<FollowStateBean> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<FollowStateBean> dc0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-621714606")) {
                        ipChange2.ipc$dispatch("-621714606", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + dc0Var.e() + dc0Var.d());
                }
            });
            Map<String, Action> actions = getActions();
            TrackInfo trackInfo = (actions == null || (action = actions.get("wantSee")) == null) ? null : action.getTrackInfo();
            if (trackInfo != null) {
                String str2 = z ? "0" : "1";
                HashMap<String, String> args = trackInfo.getArgs();
                if (args != null) {
                    args.put("type", str2);
                }
                userTrack(TrackType.click, ((HomeProjectItemView) getView()).getMWantSeeBtn(), trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), trackInfo.getArgs(), false);
            }
        } else {
            GenericFragment fragment = ((GenericItem) getItem()).getPageContext().getFragment();
            if (fragment != null) {
                yb1.Companion.d(fragment, 10);
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373702619")) {
            ipChange.ipc$dispatch("373702619", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((HomeProjectItemPresent) genericItem);
        HomeProjectItemBean value = ((HomeProjectItemModel) getModel()).getValue();
        b41.h(value, "model.value");
        ((HomeProjectItemView) getView()).bindView(value);
        final TextView mWantSeeBtn = ((HomeProjectItemView) getView()).getMWantSeeBtn();
        if (mWantSeeBtn != null) {
            TrackInfo trackInfo = null;
            if (!(mWantSeeBtn.getVisibility() == 0)) {
                mWantSeeBtn = null;
            }
            if (mWantSeeBtn != null) {
                Map<String, Action> actions = getActions();
                if (actions != null && (action = actions.get("wantSee")) != null) {
                    trackInfo = action.getTrackInfo();
                }
                if (trackInfo != null) {
                    String str = !((HomeProjectItemModel) getModel()).getValue().followState() ? "0" : "1";
                    HashMap<String, String> args = trackInfo.getArgs();
                    if (args != null) {
                        args.put("type", str);
                    }
                    userTrack(TrackType.expose, ((HomeProjectItemView) getView()).getMWantSeeBtn(), trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), trackInfo.getArgs(), false);
                }
                mWantSeeBtn.setOnClickListener(new View.OnClickListener() { // from class: tb.ty0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeProjectItemPresent.m117init$lambda3$lambda2(mWantSeeBtn, this, view);
                    }
                });
            }
        }
    }
}
