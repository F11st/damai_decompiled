package com.alibaba.pictures.bricks.component.script;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoContract;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.dc0;
import tb.k50;
import tb.wt2;
import tb.yb1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptInfoPresent extends AbsPresenter<GenericItem<ItemValue>, ScriptInfoModel, ScriptInfoView> implements ScriptInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String MSG_SCRIPT_BG_UPDATE = "EventBus://business/notification/msg_script_bg_update";
    @NotNull
    public static final String PRE_STICKY_HEADER = "EventBus://business/";
    public static final int REQUEST_CODE_HAS_PLAYED_LOGIN = 26505;
    public static final int REQUEST_CODE_PUBLISH_SUCCESS = 26504;
    @NotNull
    private String favoriteFlag;
    private boolean isCurrentUserFollowed;
    private boolean isCurrentUserHasPlayed;
    public LottieAnimationView mLottieWanna2SeeIcon;
    public TextView mWanna2SeeTv;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScriptInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.favoriteFlag = "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void followStatusChanged(String str, boolean z) {
        boolean r;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562818042")) {
            ipChange.ipc$dispatch("562818042", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        r = o.r(str, "0", false, 2, null);
        boolean z2 = !r;
        this.isCurrentUserFollowed = z2;
        if (z2) {
            i = R$raw.lottie_favourite_click;
        } else {
            i = R$raw.lottie_favorite_cancel;
        }
        getMLottieWanna2SeeIcon().setAnimation(i);
        getMLottieWanna2SeeIcon().setProgress(1.0f);
        if (z) {
            getMLottieWanna2SeeIcon().playAnimation();
        } else {
            getMLottieWanna2SeeIcon().setProgress(1.0f);
        }
        getMWanna2SeeTv().setText(this.isCurrentUserFollowed ? "已想玩" : "想玩");
        if (this.isCurrentUserFollowed) {
            getMWanna2SeeTv().setTextColor(Color.parseColor("#ff70b8"));
        } else {
            getMWanna2SeeTv().setTextColor(Color.parseColor("#3B3F43"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-10  reason: not valid java name */
    public static final void m154init$lambda10(ScriptInfoPresent scriptInfoPresent, GenericItem genericItem, View view) {
        Action action;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959206251")) {
            ipChange.ipc$dispatch("-959206251", new Object[]{scriptInfoPresent, genericItem, view});
            return;
        }
        b41.i(scriptInfoPresent, "this$0");
        b41.i(genericItem, "$item");
        if (scriptInfoPresent.isCurrentUserHasPlayed) {
            return;
        }
        if (!DoloresLoginHandler.Companion.a().c()) {
            yb1.a aVar = yb1.Companion;
            Activity activity = genericItem.getPageContext().getActivity();
            b41.g(activity, "null cannot be cast to non-null type android.content.Context");
            aVar.b(activity);
            return;
        }
        String id = ((ScriptInfoModel) scriptInfoPresent.getModel()).getScriptInfo().getId();
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        scriptInfoPresent.requestFollow(id, view);
        Map<String, Action> actions = scriptInfoPresent.getActions();
        if (actions == null || (action = actions.get("want_play")) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        HashMap<String, String> args = trackInfo.getArgs();
        b41.h(args, "args");
        args.put("favoriteFlag", scriptInfoPresent.isCurrentUserFollowed ? "0" : "1");
        UserTrackProviderProxy.click(view, trackInfo, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-4$lambda-0  reason: not valid java name */
    public static final void m155init$lambda4$lambda0(String str, GenericItem genericItem, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614020425")) {
            ipChange.ipc$dispatch("1614020425", new Object[]{str, genericItem, view});
            return;
        }
        b41.i(str, "$url");
        b41.i(genericItem, "$item");
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(str);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putInt("position", 0);
        bundle.putParcelableArrayList("pic_info", arrayList);
        Action action = new Action();
        action.setActionType(1);
        action.setExtra(bundle);
        action.setActionUrl("damai://videobrowse");
        NavProviderProxy.getProxy().toUri(genericItem.getPageContext().getActivity(), action);
    }

    private final void updateTopPlayLayout(final ScriptInfoHeaderBean scriptInfoHeaderBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "684505190")) {
            ipChange.ipc$dispatch("684505190", new Object[]{this, scriptInfoHeaderBean});
            return;
        }
        TextView textView = (TextView) ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_tv);
        textView.setText(this.isCurrentUserHasPlayed ? "已玩过" : "玩过");
        textView.setTextColor(this.isCurrentUserHasPlayed ? Color.parseColor("#4D3B3F43") : Color.parseColor("#3B3F43"));
        ((TextView) ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_icon)).setTextColor(this.isCurrentUserHasPlayed ? Color.parseColor("#4D3B3F43") : Color.parseColor("#3B3F43"));
        ((ScriptInfoView) getView()).getItemView().findViewById(R$id.script_detail_top_play_layout).setOnClickListener(new View.OnClickListener() { // from class: tb.b72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScriptInfoPresent.m156updateTopPlayLayout$lambda16(ScriptInfoPresent.this, scriptInfoHeaderBean, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateTopPlayLayout$lambda-16  reason: not valid java name */
    public static final void m156updateTopPlayLayout$lambda16(ScriptInfoPresent scriptInfoPresent, ScriptInfoHeaderBean scriptInfoHeaderBean, View view) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549431936")) {
            ipChange.ipc$dispatch("-549431936", new Object[]{scriptInfoPresent, scriptInfoHeaderBean, view});
            return;
        }
        b41.i(scriptInfoPresent, "this$0");
        b41.i(scriptInfoHeaderBean, "$scriptInfo");
        if (scriptInfoPresent.isCurrentUserHasPlayed) {
            BricksToastUtil.INSTANCE.b("已玩过的剧本可以在「我的-动态」里编辑哟～");
        } else if (!DoloresLoginHandler.Companion.a().c()) {
            Activity activity = ((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity();
            if (activity != null) {
                yb1.Companion.c(activity, REQUEST_CODE_HAS_PLAYED_LOGIN);
            }
        } else {
            Action action2 = null;
            Map<String, Action> actions = scriptInfoPresent.getActions();
            if (actions != null && (action = actions.get("played")) != null) {
                TrackInfo trackInfo = action.getTrackInfo();
                if (trackInfo != null) {
                    b41.h(trackInfo, "trackInfo");
                    UserTrackProviderProxy.click(view, trackInfo, false);
                }
                Action action3 = new Action();
                action3.setActionType(1);
                action3.setExtra(action.getExtra());
                action3.setActionUrl(action.getActionUrl());
                NavProviderProxy.getProxy().toUri(((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity(), action3);
                action2 = action;
            }
            if (action2 == null) {
                Action action4 = new Action();
                action4.setActionType(1);
                action4.setActionUrl("damai://V1/PublishPage?publisherType=ReleaseType_Evaluate&scriptId=" + scriptInfoHeaderBean.getId() + "&commentType=66");
                NavProviderProxy.getProxy().toUri(((GenericItem) scriptInfoPresent.getItem()).getPageContext().getActivity(), action4);
            }
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857673051")) {
            return ((Boolean) ipChange.ipc$dispatch("-857673051", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017334248")) {
            return ((Boolean) ipChange.ipc$dispatch("-2017334248", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626403408")) {
            return ((Boolean) ipChange.ipc$dispatch("1626403408", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @NotNull
    public final String getFavoriteFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "475401021") ? (String) ipChange.ipc$dispatch("475401021", new Object[]{this}) : this.favoriteFlag;
    }

    @NotNull
    public final LottieAnimationView getMLottieWanna2SeeIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119621816")) {
            return (LottieAnimationView) ipChange.ipc$dispatch("-1119621816", new Object[]{this});
        }
        LottieAnimationView lottieAnimationView = this.mLottieWanna2SeeIcon;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        b41.A("mLottieWanna2SeeIcon");
        return null;
    }

    @NotNull
    public final TextView getMWanna2SeeTv() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687308686")) {
            return (TextView) ipChange.ipc$dispatch("-1687308686", new Object[]{this});
        }
        TextView textView = this.mWanna2SeeTv;
        if (textView != null) {
            return textView;
        }
        b41.A("mWanna2SeeTv");
        return null;
    }

    public final boolean isCurrentUserFollowed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1202765477") ? ((Boolean) ipChange.ipc$dispatch("-1202765477", new Object[]{this})).booleanValue() : this.isCurrentUserFollowed;
    }

    public final boolean isCurrentUserHasPlayed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "299762842") ? ((Boolean) ipChange.ipc$dispatch("299762842", new Object[]{this})).booleanValue() : this.isCurrentUserHasPlayed;
    }

    public void requestFollow(@NotNull String str, @NotNull final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140523161")) {
            ipChange.ipc$dispatch("-140523161", new Object[]{this, str, view});
            return;
        }
        b41.i(str, "id");
        b41.i(view, "view");
        boolean z = this.isCurrentUserFollowed;
        view.setClickable(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.init(!z, "25:" + str);
        cc0.a(followRequest).doOnKTStart(new Function1<DoloresRequest<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.script.ScriptInfoPresent$requestFollow$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DoloresRequest<FollowStateBean> doloresRequest) {
                invoke2(doloresRequest);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable DoloresRequest<FollowStateBean> doloresRequest) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1885435443")) {
                    ipChange2.ipc$dispatch("1885435443", new Object[]{this, doloresRequest});
                }
            }
        }).doOnKTSuccess(new Function1<FollowStateBean, wt2>() { // from class: com.alibaba.pictures.bricks.component.script.ScriptInfoPresent$requestFollow$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (AndroidInstantRuntime.support(ipChange2, "2059688373")) {
                    ipChange2.ipc$dispatch("2059688373", new Object[]{this, followStateBean});
                    return;
                }
                b41.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
                ScriptInfoPresent scriptInfoPresent = ScriptInfoPresent.this;
                View view2 = view;
                boolean isFollowed = followStateBean.isFollowed();
                scriptInfoPresent.setCurrentUserFollowed(isFollowed);
                String str2 = followStateBean.status;
                if (str2 != null) {
                    b41.h(str2, "status");
                    String str3 = followStateBean.status;
                    b41.h(str3, "status");
                    scriptInfoPresent.setFavoriteFlag(str3);
                }
                scriptInfoPresent.followStatusChanged(followStateBean.status, true);
                if (isFollowed) {
                    BricksToastUtil.INSTANCE.d("想玩成功", "已添加到\"我的-想看&想玩\"", R$raw.toast_lottie_peach_heart);
                } else {
                    BricksToastUtil.INSTANCE.b("已取消想玩");
                }
                view2.setClickable(true);
            }
        }).doOnKTFail(new Function1<dc0<FollowStateBean>, wt2>() { // from class: com.alibaba.pictures.bricks.component.script.ScriptInfoPresent$requestFollow$4
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<FollowStateBean> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<FollowStateBean> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "37524521")) {
                    ipChange2.ipc$dispatch("37524521", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + dc0Var.e() + " , " + dc0Var.f());
                BricksToastUtil.INSTANCE.b("服务开小差,请重试");
                view.setClickable(true);
            }
        });
    }

    public final void setCurrentUserFollowed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44806397")) {
            ipChange.ipc$dispatch("44806397", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isCurrentUserFollowed = z;
        }
    }

    public final void setCurrentUserHasPlayed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693204386")) {
            ipChange.ipc$dispatch("-1693204386", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isCurrentUserHasPlayed = z;
        }
    }

    public final void setFavoriteFlag(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044556479")) {
            ipChange.ipc$dispatch("-2044556479", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.favoriteFlag = str;
    }

    public final void setMLottieWanna2SeeIcon(@NotNull LottieAnimationView lottieAnimationView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447771992")) {
            ipChange.ipc$dispatch("447771992", new Object[]{this, lottieAnimationView});
            return;
        }
        b41.i(lottieAnimationView, "<set-?>");
        this.mLottieWanna2SeeIcon = lottieAnimationView;
    }

    public final void setMWanna2SeeTv(@NotNull TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923552018")) {
            ipChange.ipc$dispatch("923552018", new Object[]{this, textView});
            return;
        }
        b41.i(textView, "<set-?>");
        this.mWanna2SeeTv = textView;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x011a A[SYNTHETIC] */
    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(@org.jetbrains.annotations.NotNull final com.youku.arch.v3.core.item.GenericItem<com.youku.arch.v3.core.ItemValue> r10) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.script.ScriptInfoPresent.init(com.youku.arch.v3.core.item.GenericItem):void");
    }
}
