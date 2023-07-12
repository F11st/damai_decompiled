package com.alibaba.pictures.component.artist;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.player.video.ProxyVideoView;
import com.alibaba.pictures.bean.ArtistHeadBean;
import com.alibaba.pictures.bean.ArtistInfo;
import com.alibaba.pictures.bricks.view.BricksHWRatioLayout;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alibaba.pictures.bricks.view.FollowView;
import com.alibaba.pictures.component.artist.ArtistHeaderContract;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k62;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ArtistHeaderView extends AbsView<GenericItem<ItemValue>, ArtistHeaderModel, ArtistHeaderPresent> implements ArtistHeaderContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    private final View mBottomView;
    private final Context mContext;
    private final View mDividerTv;
    private final ViewGroup mFansLayout;
    private final View mFansTipV;
    private final FollowView mFollowLayout;
    private final ImageView mGuideImg;
    private final TextView mGuideTv;
    private final View mGuideV;
    private final ImageView mHeadBgImg;
    private final ImageView mHeadImg;
    private final BricksHWRatioLayout mHwRatioLayout;
    private final TextView mNameTv;
    private final ViewGroup mSellLayout;
    @Nullable
    private ArtistUserAction mUserAction;
    private final ProxyVideoView mVideoView;
    private final View mVipV;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtistHeaderView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mContext = view.getContext();
        this.mHwRatioLayout = (BricksHWRatioLayout) view.findViewById(R$id.id_bricks_artist_head_layout);
        this.mBottomView = view.findViewById(R$id.id_bricks_artist_bottom_layout);
        this.mVideoView = (ProxyVideoView) view.findViewById(R$id.id_bricks_artist_head_video);
        this.mGuideV = view.findViewById(R$id.id_bricks_artist_guide_layout);
        this.mGuideTv = (TextView) view.findViewById(R$id.id_bricks_artist_guide_text);
        this.mGuideImg = (ImageView) view.findViewById(R$id.id_bricks_artist_guide_img);
        this.mHeadBgImg = (ImageView) view.findViewById(R$id.id_bricks_artist_head_img);
        this.mHeadImg = (ImageView) view.findViewById(R$id.id_bricks_artist_avatar);
        this.mNameTv = (TextView) view.findViewById(R$id.id_bricks_artist_name);
        this.mVipV = view.findViewById(R$id.id_bricks_artist_vip_tag);
        this.mFansLayout = (ViewGroup) view.findViewById(R$id.id_bricks_artist_fans_layout);
        this.mFansTipV = view.findViewById(R$id.id_bricks_artist_fans_tips);
        this.mDividerTv = view.findViewById(R$id.id_bricks_artist_divider);
        this.mSellLayout = (ViewGroup) view.findViewById(R$id.id_bricks_artist_sell_layout);
        this.mFollowLayout = (FollowView) view.findViewById(R$id.id_bricks_artist_follow);
    }

    private final void addTextView(ArtistInfo.TextInfo textInfo, ViewGroup viewGroup) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339069904")) {
            ipChange.ipc$dispatch("-1339069904", new Object[]{this, textInfo, viewGroup});
            return;
        }
        if (textInfo.isNumStyle()) {
            textView = new DigitTextView(this.mContext, null, 0, 6, null);
            textView.setTextColor(-16777216);
            textView.setTextSize(1, 18.0f);
        } else {
            textView = new TextView(this.mContext);
            if (!b41.d("万", textInfo.value) && !b41.d("场", textInfo.value)) {
                textView.setTextSize(1, 12.0f);
                textView.setTextColor(Color.parseColor("#5f6672"));
                textView.setPadding(0, k62.a(this.mContext, 2.0f), 0, 0);
            } else {
                textView.setTextSize(1, 15.0f);
                textView.getPaint().setFakeBoldText(true);
                textView.setTextColor(-16777216);
            }
        }
        textView.setText(textInfo.value);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = k62.a(this.mContext, 2.0f);
        wt2 wt2Var = wt2.INSTANCE;
        viewGroup.addView(textView, marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-7  reason: not valid java name */
    public static final void m192bind$lambda7(boolean z, ArtistHeaderView artistHeaderView, ArtistHeadBean artistHeadBean, View view) {
        ArtistUserAction artistUserAction;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712141050")) {
            ipChange.ipc$dispatch("712141050", new Object[]{Boolean.valueOf(z), artistHeaderView, artistHeadBean, view});
            return;
        }
        b41.i(artistHeaderView, "this$0");
        if (!z || (artistUserAction = artistHeaderView.mUserAction) == null) {
            return;
        }
        ArtistInfo artistInfo = artistHeadBean.artistInfo;
        b41.h(artistInfo, "bean.artistInfo");
        artistUserAction.onFansTipsClick(artistInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x023d, code lost:
        if (((r12 == null || (r12 = r12.fansTips) == null || r12.length() <= 0) ? false : true) != false) goto L83;
     */
    @Override // com.alibaba.pictures.component.artist.ArtistHeaderContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bind(@org.jetbrains.annotations.Nullable final com.alibaba.pictures.bean.ArtistHeadBean r11, @org.jetbrains.annotations.NotNull com.alibaba.pictures.component.artist.ArtistUserAction r12) {
        /*
            Method dump skipped, instructions count: 598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.component.artist.ArtistHeaderView.bind(com.alibaba.pictures.bean.ArtistHeadBean, com.alibaba.pictures.component.artist.ArtistUserAction):void");
    }

    @Override // com.alibaba.pictures.component.artist.ArtistHeaderContract.View
    @NotNull
    public View getFansView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397847590")) {
            return (View) ipChange.ipc$dispatch("397847590", new Object[]{this});
        }
        ViewGroup viewGroup = this.mFansLayout;
        b41.h(viewGroup, "mFansLayout");
        return viewGroup;
    }

    @Override // com.alibaba.pictures.component.artist.ArtistHeaderContract.View
    @NotNull
    public FollowView getFollowView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354387928")) {
            return (FollowView) ipChange.ipc$dispatch("-1354387928", new Object[]{this});
        }
        FollowView followView = this.mFollowLayout;
        b41.h(followView, "mFollowLayout");
        return followView;
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1681415219") ? (View) ipChange.ipc$dispatch("1681415219", new Object[]{this}) : this.itemView;
    }

    @Override // com.alibaba.pictures.component.artist.ArtistHeaderContract.View
    @Nullable
    public ProxyVideoView getVideoView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1915195531") ? (ProxyVideoView) ipChange.ipc$dispatch("1915195531", new Object[]{this}) : this.mVideoView;
    }
}
