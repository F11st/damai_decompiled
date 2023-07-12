package com.alibaba.pictures.bricks.artist;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.alibaba.pictures.bricks.artist.ArtistFragment$refreshNavbar$1;
import com.alibaba.pictures.bricks.bean.ArtistTopBean;
import com.alibaba.pictures.bricks.util.share.ShareProxy;
import com.alibaba.pictures.bricks.view.FollowView;
import com.alient.onearch.adapter.PageInfoBean;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistFragment$refreshNavbar$1 extends Lambda implements Function0<TrackInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ArtistTopBean $top;
    final /* synthetic */ ArtistFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistFragment$refreshNavbar$1(ArtistFragment artistFragment, ArtistTopBean artistTopBean) {
        super(0);
        this.this$0 = artistFragment;
        this.$top = artistTopBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-2  reason: not valid java name */
    public static final void m110invoke$lambda3$lambda2(ArtistTopBean.ShareBean shareBean, ArtistFragment artistFragment, View view) {
        Map<String, Action> map;
        Action action;
        TrackInfo trackInfo;
        Window window;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "155475426")) {
            ipChange.ipc$dispatch("155475426", new Object[]{shareBean, artistFragment, view});
            return;
        }
        b41.i(shareBean, "$this_apply");
        b41.i(artistFragment, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("title", shareBean.shareTitle);
        bundle.putString("message", shareBean.shareSubTitle);
        bundle.putString("producturl", shareBean.shareUrl);
        bundle.putString("projectName", shareBean.shareTitle);
        bundle.putBoolean("showGenerateImage", true);
        bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_ARTIST_IMAGE);
        if (!vh2.INSTANCE.c(shareBean.sharePic)) {
            bundle.putString("imageurl", shareBean.sharePic);
            bundle.putString("projectImage", shareBean.sharePic);
        }
        ShareProxy.IShareProxy a = ShareProxy.a();
        FragmentActivity activity = artistFragment.getActivity();
        FragmentActivity activity2 = artistFragment.getActivity();
        a.share(activity, bundle, (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView());
        PageInfoBean topBasePageInfo = artistFragment.getTopBasePageInfo();
        if (topBasePageInfo == null || (map = topBasePageInfo.action) == null || (action = map.get("share")) == null || (trackInfo = action.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.click(trackInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final TrackInfo invoke() {
        TextView textView;
        RelativeLayout relativeLayout;
        FollowView followView;
        Map<String, Action> map;
        Action action;
        TrackInfo trackInfo;
        FollowView followView2;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        Map<String, Action> map2;
        Action action2;
        TrackInfo trackInfo2;
        RelativeLayout relativeLayout4;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1743920484")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1743920484", new Object[]{this});
        }
        textView = this.this$0.title;
        if (textView != null) {
            textView.setText(this.$top.artistName);
        }
        final ArtistTopBean.ShareBean shareBean = this.$top.shareVO;
        if (shareBean != null) {
            final ArtistFragment artistFragment = this.this$0;
            relativeLayout2 = artistFragment.shareLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            PageInfoBean topBasePageInfo = artistFragment.getTopBasePageInfo();
            if (topBasePageInfo != null && (map2 = topBasePageInfo.action) != null && (action2 = map2.get("share")) != null && (trackInfo2 = action2.getTrackInfo()) != null) {
                b41.h(trackInfo2, "trackInfo");
                relativeLayout4 = artistFragment.shareLayout;
                UserTrackProviderProxy.expose(relativeLayout4, trackInfo2);
            }
            relativeLayout3 = artistFragment.shareLayout;
            if (relativeLayout3 != null) {
                relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: tb.j8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtistFragment$refreshNavbar$1.m110invoke$lambda3$lambda2(ArtistTopBean.ShareBean.this, artistFragment, view);
                    }
                });
            }
        } else {
            relativeLayout = this.this$0.shareLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
        String str = this.$top.followStatus;
        z = ((str == null || str.length() == 0) || b41.d(this.$top.followStatus, "0")) ? true : true;
        followView = this.this$0.follow;
        if (followView != null) {
            followView.updateFollow(!z);
        }
        PageInfoBean topBasePageInfo2 = this.this$0.getTopBasePageInfo();
        if (topBasePageInfo2 == null || (map = topBasePageInfo2.action) == null || (action = map.get(ArtistFragment.ACTION_BAR_FOLLOW_BTN)) == null || (trackInfo = action.getTrackInfo()) == null) {
            return null;
        }
        ArtistFragment artistFragment2 = this.this$0;
        HashMap<String, String> args = trackInfo.getArgs();
        if (args != null) {
            args.put("status", z ? "0" : "1");
        }
        followView2 = artistFragment2.follow;
        UserTrackProviderProxy.expose(followView2, trackInfo);
        return trackInfo;
    }
}
