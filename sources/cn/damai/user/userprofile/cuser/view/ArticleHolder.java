package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.image.a;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ArticleHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;

    public ArticleHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        List<ArticleFeedData> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799263302")) {
            ipChange.ipc$dispatch("-799263302", new Object[]{this, feedMergeDataDO});
        } else if (feedMergeDataDO == null || (list = feedMergeDataDO.articleData) == null || list.size() <= 0) {
        } else {
            ArticleFeedData articleFeedData = feedMergeDataDO.articleData.get(0);
            v(articleFeedData.articleTitle, R$id.tv_comment_text);
            v(articleFeedData.articleContent, R$id.tv_comment);
            DMImageCreator k = a.b().c(articleFeedData.img).k(new DMRoundedCornersBitmapProcessor(t60.a(this.w, 3.0f), 0));
            int i = R$drawable.uikit_default_image_bg_grey;
            k.i(i).c(i).g((ImageView) this.itemView.findViewById(R$id.user_feeds_article_img));
        }
    }
}
