package com.alibaba.pictures.component.artist;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.player.video.opt.MultiConditionPlayOptHelper;
import cn.damai.user.star.StarIndexFragment;
import com.alibaba.pictures.bean.ArtistHeadBean;
import com.alibaba.pictures.bean.ArtistInfo;
import com.alibaba.pictures.bean.ArtistVideoInfo;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.FollowView;
import com.alient.onearch.adapter.BaseFragment;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.h8;
import tb.k50;
import tb.ol;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistHeaderPresent extends AbsPresenter<GenericItem<ItemValue>, ArtistHeaderModel, ArtistHeaderView> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String action_fansTips = "fansTips";
    @NotNull
    public static final String action_followBtn = "cardfollowBtn";
    @NotNull
    public static final String action_videoArea = "videoArea";
    private boolean ensureAddOneTime;
    private boolean isVideoMode;
    @Nullable
    private ArtistHeadBean mValue;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b extends ol {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArtistHeaderPresent e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ProxyVideoView proxyVideoView, String str, ArtistHeaderPresent artistHeaderPresent, Context context) {
            super(context, proxyVideoView, str, "top");
            this.e = artistHeaderPresent;
        }

        @Override // tb.ol, cn.damai.player.video.listener.VideoOperateListener
        public void onPlayClick(@Nullable VideoInfo videoInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "141212059")) {
                ipChange.ipc$dispatch("141212059", new Object[]{this, videoInfo});
                return;
            }
            super.onPlayClick(videoInfo);
            this.e.userTrack(true, ArtistHeaderPresent.action_videoArea, null, true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements ArtistUserAction {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alibaba.pictures.component.artist.ArtistUserAction
        public void onFansTipsClick(@NotNull ArtistInfo artistInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1694215806")) {
                ipChange.ipc$dispatch("1694215806", new Object[]{this, artistInfo});
                return;
            }
            b41.i(artistInfo, "bean");
            try {
                BricksToastUtil.INSTANCE.b(artistInfo.fansTips);
                ArtistHeaderPresent.userTrack$default(ArtistHeaderPresent.this, true, ArtistHeaderPresent.action_fansTips, null, false, 12, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistHeaderPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void userTrack(boolean z, String str, View view, boolean z2) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887406077")) {
            ipChange.ipc$dispatch("887406077", new Object[]{this, Boolean.valueOf(z), str, view, Boolean.valueOf(z2)});
            return;
        }
        try {
            Action action = getViewCard().getAction(str);
            if (action != null && (trackInfo = action.getTrackInfo()) != null) {
                if (z) {
                    UserTrackProviderProxy.click(trackInfo, z2);
                } else {
                    UserTrackProviderProxy.expose(view, trackInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void userTrack$default(ArtistHeaderPresent artistHeaderPresent, boolean z, String str, View view, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            view = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        artistHeaderPresent.userTrack(z, str, view, z2);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        String str;
        TrackInfo trackInfo;
        ArtistInfo artistInfo;
        ArtistInfo artistInfo2;
        ArtistVideoInfo artistVideoInfo;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1135160985")) {
            ipChange.ipc$dispatch("1135160985", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ArtistHeaderPresent) genericItem);
        ArtistHeadBean value = ((ArtistHeaderModel) getModel()).getValue();
        if (b41.d(this.mValue, value)) {
            return;
        }
        this.mValue = value;
        if (value != null && (artistVideoInfo = value.videoInfo) != null) {
            z = artistVideoInfo.isValid();
        }
        this.isVideoMode = z;
        View itemView = ((ArtistHeaderView) getView()).getItemView();
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        String str2 = null;
        RecyclerView recyclerView = fragment != null ? fragment.getRecyclerView() : null;
        GenericFragment fragment2 = genericItem.getPageContext().getFragment();
        BaseFragment baseFragment = fragment2 instanceof BaseFragment ? (BaseFragment) fragment2 : null;
        if (baseFragment == null || (str = baseFragment.getUtPageName()) == null) {
            str = StarIndexFragment.Default_PAGE;
        }
        String str3 = str;
        final ProxyVideoView videoView = ((ArtistHeaderView) getView()).getVideoView();
        FollowView followView = ((ArtistHeaderView) getView()).getFollowView();
        userTrack$default(this, false, action_fansTips, ((ArtistHeaderView) getView()).getFansView(), false, 8, null);
        if (recyclerView != null && videoView != null && !this.ensureAddOneTime) {
            this.ensureAddOneTime = true;
            userTrack$default(this, false, action_videoArea, videoView, false, 8, null);
            videoView.setListener(new b(videoView, str3, this, itemView.getContext()));
            videoView.setOptHelper(new MultiConditionPlayOptHelper(recyclerView, itemView, videoView));
            GenericFragment fragment3 = genericItem.getPageContext().getFragment();
            if (fragment3 != null) {
                fragment3.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.alibaba.pictures.component.artist.ArtistHeaderPresent$init$3$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* compiled from: Taobao */
                    /* loaded from: classes7.dex */
                    public /* synthetic */ class a {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[Lifecycle.Event.values().length];
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                        boolean z2;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "255154574")) {
                            ipChange2.ipc$dispatch("255154574", new Object[]{this, lifecycleOwner, event});
                            return;
                        }
                        b41.i(lifecycleOwner, "source");
                        b41.i(event, "event");
                        z2 = ArtistHeaderPresent.this.isVideoMode;
                        if (z2) {
                            int i = a.$EnumSwitchMapping$0[event.ordinal()];
                            if (i == 1) {
                                videoView.autoPlay();
                            } else if (i == 2) {
                                videoView.pause();
                            } else if (i != 3) {
                            } else {
                                videoView.release();
                            }
                        }
                    }
                });
            }
        }
        ((ArtistHeaderView) getView()).bind(this.mValue, new c());
        h8.a aVar = h8.Companion;
        h8 a2 = aVar.a();
        GenericFragment fragment4 = genericItem.getPageContext().getFragment();
        ArtistHeadBean artistHeadBean = this.mValue;
        a2.f(fragment4, (artistHeadBean == null || (artistInfo2 = artistHeadBean.artistInfo) == null) ? null : artistInfo2.id, followView, new Function1<Boolean, wt2>() { // from class: com.alibaba.pictures.component.artist.ArtistHeaderPresent$init$5
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return wt2.INSTANCE;
            }

            public final void invoke(boolean z2) {
                TrackInfo trackInfo2;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1281300452")) {
                    ipChange2.ipc$dispatch("-1281300452", new Object[]{this, Boolean.valueOf(z2)});
                    return;
                }
                Action action = ArtistHeaderPresent.this.getViewCard().getAction(ArtistHeaderPresent.action_followBtn);
                if (action == null || (trackInfo2 = action.getTrackInfo()) == null) {
                    return;
                }
                HashMap<String, String> args = trackInfo2.getArgs();
                if (args != null) {
                    args.put("status", z2 ? "0" : "1");
                }
                UserTrackProviderProxy.click(trackInfo2);
            }
        });
        ArtistHeadBean artistHeadBean2 = this.mValue;
        boolean z2 = !(artistHeadBean2 != null ? artistHeadBean2.isUnFollow() : true);
        h8 a3 = aVar.a();
        GenericFragment fragment5 = genericItem.getPageContext().getFragment();
        ArtistHeadBean artistHeadBean3 = this.mValue;
        if (artistHeadBean3 != null && (artistInfo = artistHeadBean3.artistInfo) != null) {
            str2 = artistInfo.id;
        }
        a3.i(fragment5, str2, z2);
        Action action = getViewCard().getAction(action_followBtn);
        if (action == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        HashMap<String, String> args = trackInfo.getArgs();
        if (args != null) {
            args.put("status", z2 ? "1" : "0");
        }
        UserTrackProviderProxy.expose(followView, trackInfo);
    }
}
