package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ForwardArticleHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.ForwardArticleHolder$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2772a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        View$OnClickListenerC2772a(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "151862503")) {
                ipChange.ipc$dispatch("151862503", new Object[]{this, view});
            } else if (wh2.j(this.a.url)) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a.url);
                DMNav.from(ForwardArticleHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.ForwardArticleHolder$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2773b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        View$OnClickListenerC2773b(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2031814424")) {
                ipChange.ipc$dispatch("-2031814424", new Object[]{this, view});
            } else if (wh2.j(this.a.originalUrl)) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a.originalUrl);
                DMNav.from(ForwardArticleHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
            }
        }
    }

    public ForwardArticleHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        List<DynamicFeedData> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907059237")) {
            ipChange.ipc$dispatch("-907059237", new Object[]{this, feedMergeDataDO});
        } else if (feedMergeDataDO == null || (list = feedMergeDataDO.dynamicData) == null || list.size() <= 0) {
        } else {
            DynamicFeedData dynamicFeedData = feedMergeDataDO.dynamicData.get(0);
            String str = dynamicFeedData.comment;
            int i = R$id.tv_comment;
            v(str, i);
            v(dynamicFeedData.forwardTitle, R$id.tv_comment_text);
            v(dynamicFeedData.forwardContent, R$id.tv_comment_content);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.user_feeds_article_img);
            List<String> list2 = dynamicFeedData.forwardImgs;
            if (list2 != null && list2.size() > 0) {
                DMImageCreator k = C0504a.b().c(dynamicFeedData.forwardImgs.get(0)).k(new DMRoundedCornersBitmapProcessor(t60.a(this.w, 3.0f), 0));
                int i2 = R$drawable.uikit_default_image_bg_grey;
                k.i(i2).c(i2).g(imageView);
            }
            this.itemView.findViewById(i).setOnClickListener(new View$OnClickListenerC2772a(dynamicFeedData));
            this.itemView.findViewById(R$id.rl_content_wrapper).setOnClickListener(new View$OnClickListenerC2773b(dynamicFeedData));
        }
    }
}
