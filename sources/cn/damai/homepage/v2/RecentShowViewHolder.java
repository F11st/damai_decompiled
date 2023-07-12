package cn.damai.homepage.v2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.bean.RecentShowBean;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.LiveRoomView;
import cn.damai.uikit.view.ScoreStarViewV2;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.HashMap;
import tb.C9826vr;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RecentShowViewHolder extends BaseViewHolder<RecentShowBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    Context mContext;
    ImageView mIndexImage;
    LiveRoomView mLiveRoomView;
    ImageView mRankItemImage;
    DMDigitTextView mRankItemPrice;
    LinearLayout mRankItemPriceLayout;
    DMDigitTextView mRankItemPriceUnknown;
    DMCategroyTagView mRankItemTag;
    TextView mRankItemTime;
    TextView mRankItemTitle;
    LinearLayout mScoreLayout;
    ScoreStarViewV2 mScoreStar;
    DMDigitTextView mScoreText;
    private HashMap<String, Integer> rankMap;

    public RecentShowViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mRankItemImage = (ImageView) this.itemView.findViewById(R$id.homepage_rank_item_image_normal);
        this.mRankItemTitle = (TextView) this.itemView.findViewById(R$id.homepage_rank_item_title);
        this.mRankItemTime = (TextView) this.itemView.findViewById(R$id.homepage_rank_item_time);
        this.mRankItemPriceLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_rank_item_price_layout);
        this.mRankItemPrice = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_rank_item_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_rank_item_price_unknown);
        this.mRankItemPriceUnknown = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        this.mRankItemTag = (DMCategroyTagView) this.itemView.findViewById(R$id.homepage_rank_item_image_tag);
        this.mLiveRoomView = (LiveRoomView) this.itemView.findViewById(R$id.homepage_rank_item_live_room);
        this.mScoreLayout = (LinearLayout) this.itemView.findViewById(R$id.score_ll);
        this.mScoreText = (DMDigitTextView) this.itemView.findViewById(R$id.score_text);
        this.mScoreStar = (ScoreStarViewV2) this.itemView.findViewById(R$id.score_icon);
        this.mIndexImage = (ImageView) this.itemView.findViewById(R$id.homepage_rank_item_rank);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(t60.a(this.mContext, 98.0f), -2));
    }

    private Integer getImageByIndex(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087127666")) {
            return (Integer) ipChange.ipc$dispatch("1087127666", new Object[]{this, str});
        }
        if (this.rankMap == null) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            this.rankMap = hashMap;
            hashMap.put("1", Integer.valueOf(R$drawable.homepage_rank_icon_0));
            this.rankMap.put("2", Integer.valueOf(R$drawable.homepage_rank_icon_1));
            this.rankMap.put("3", Integer.valueOf(R$drawable.homepage_rank_icon_2));
            this.rankMap.put("4", Integer.valueOf(R$drawable.homepage_rank_icon_3));
            this.rankMap.put("5", Integer.valueOf(R$drawable.homepage_rank_icon_4));
            this.rankMap.put("6", Integer.valueOf(R$drawable.homepage_rank_icon_5));
            this.rankMap.put("7", Integer.valueOf(R$drawable.homepage_rank_icon_6));
            this.rankMap.put("8", Integer.valueOf(R$drawable.homepage_rank_icon_7));
            this.rankMap.put("9", Integer.valueOf(R$drawable.homepage_rank_icon_8));
            this.rankMap.put("10", Integer.valueOf(R$drawable.homepage_rank_icon_9));
        }
        return this.rankMap.get(str);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864134138")) {
            ipChange.ipc$dispatch("-864134138", new Object[]{this, iItem});
        } else {
            handleView(getValue(), getModuleRank());
        }
    }

    public void handleView(RecentShowBean recentShowBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187827383")) {
            ipChange.ipc$dispatch("-187827383", new Object[]{this, recentShowBean, Integer.valueOf(i)});
        } else if (recentShowBean == null) {
        } else {
            recentShowBean.position = i;
            if (this.mRankItemImage.getTag() instanceof C9826vr) {
                ((C9826vr) this.mRankItemImage.getTag()).cancel();
            }
            DMImageCreator f = C0504a.b().f(recentShowBean.projectPic, t60.a(this.context, 98.0f), t60.a(this.mContext, 131.0f));
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            this.mRankItemImage.setTag(f.i(i2).c(i2).g(this.mRankItemImage));
            this.mRankItemTitle.setText(recentShowBean.projectName);
            if (!TextUtils.isEmpty(recentShowBean.priceLow) && !recentShowBean.priceLow.equals("价格待定") && !recentShowBean.priceLow.equals("待定")) {
                this.mRankItemPrice.setText(recentShowBean.priceLow);
                this.mRankItemPriceLayout.setVisibility(0);
                this.mRankItemPriceUnknown.setVisibility(8);
            } else {
                this.mRankItemPriceLayout.setVisibility(8);
                this.mRankItemPriceUnknown.setVisibility(0);
            }
            if (recentShowBean.isLiveRoom()) {
                this.mRankItemTag.setVisibility(8);
                this.mLiveRoomView.setLiveType(recentShowBean.getLiveType());
                this.mLiveRoomView.setVisibility(0);
            } else {
                this.mLiveRoomView.setVisibility(8);
                if (TextUtils.isEmpty(recentShowBean.discountRate)) {
                    this.mRankItemTag.setTagName(recentShowBean.categoryName);
                } else {
                    this.mRankItemTag.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
                    this.mRankItemTag.setTagName(String.format("%s%s", recentShowBean.discountRate, "折起"));
                }
                this.mRankItemTag.setVisibility((TextUtils.isEmpty(recentShowBean.categoryName) && TextUtils.isEmpty(recentShowBean.discountRate)) ? 8 : 0);
            }
            if (!TextUtils.isEmpty(recentShowBean.ranking)) {
                this.mScoreLayout.setVisibility(8);
                this.mIndexImage.setVisibility(0);
                Integer imageByIndex = getImageByIndex(recentShowBean.ranking);
                if (imageByIndex != null) {
                    this.mIndexImage.setImageResource(imageByIndex.intValue());
                }
            } else if (recentShowBean.itemScore > 0.0d) {
                this.mScoreLayout.setVisibility(0);
                this.mIndexImage.setVisibility(8);
                this.mScoreText.setText(String.valueOf(recentShowBean.itemScore));
                this.mScoreStar.updateView(recentShowBean.itemScore);
            } else {
                this.mScoreLayout.setVisibility(8);
                this.mIndexImage.setVisibility(8);
            }
            this.mRankItemTime.setText(recentShowBean.describeName);
            this.mRankItemTime.setVisibility(0);
            this.itemView.setTag(recentShowBean);
        }
    }
}
