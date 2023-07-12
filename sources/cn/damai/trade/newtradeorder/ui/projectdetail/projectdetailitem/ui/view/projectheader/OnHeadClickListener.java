package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.graphics.Bitmap;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRatingContentLabelBean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface OnHeadClickListener {
    void onLoadedPosterPic(String str, Bitmap bitmap, boolean z);

    void onMarketStallClick();

    void onNoticeClick();

    void onPosterClick();

    void onPromotionTagsClick();

    void onRankListClick();

    void onScoreBottomTagClick(ProjectRatingContentLabelBean projectRatingContentLabelBean);

    void onScoreCommentClick(String str, String str2, String str3);

    void onScoreHeadTipClick(String str, String str2);

    void onSeatIconClick();

    void onServiceEtcClick();

    void onShowTimeClick();

    void onVenueMapIconClick();

    void onVenueNameClick();

    void onVideoClick(int i);

    void onWannaSeeActionClick();
}
