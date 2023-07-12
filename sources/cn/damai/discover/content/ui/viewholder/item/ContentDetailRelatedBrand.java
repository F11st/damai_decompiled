package cn.damai.discover.content.ui.viewholder.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.discover.content.bean.RelatedBrandOrArtist;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ContentDetailRelatedBrand extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundRadiusImageView mAvatarView;
    private ImageView mBrandTagView;
    private TextView mDescView;
    private TextView mNameView;
    private ImageView mTagView;

    public ContentDetailRelatedBrand(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1047637845")) {
            ipChange.ipc$dispatch("1047637845", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.item_content_detail_related_brand_artist_single, (ViewGroup) this, true);
        this.mAvatarView = (RoundRadiusImageView) findViewById(R$id.live_content_detail_related_brand_avatar);
        this.mNameView = (TextView) findViewById(R$id.live_content_detail_related_brand_name);
        this.mDescView = (TextView) findViewById(R$id.live_content_detail_related_brand_desc);
        this.mTagView = (ImageView) findViewById(R$id.live_content_detail_related_brand_tag);
        this.mBrandTagView = (ImageView) findViewById(R$id.iv_brand_icon);
    }

    public void handleView(RelatedBrandOrArtist relatedBrandOrArtist) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356009127")) {
            ipChange.ipc$dispatch("356009127", new Object[]{this, relatedBrandOrArtist});
        } else if (relatedBrandOrArtist != null && !wh2.j(relatedBrandOrArtist.id) && !wh2.j(relatedBrandOrArtist.name)) {
            if (!wh2.j(relatedBrandOrArtist.headPic)) {
                C0504a.b().c(relatedBrandOrArtist.headPic).g(this.mAvatarView);
            }
            this.mNameView.setText(relatedBrandOrArtist.name);
            this.mDescView.setText(relatedBrandOrArtist.additionDescription);
            if (relatedBrandOrArtist.type == 2) {
                this.mTagView.setVisibility(0);
                this.mBrandTagView.setVisibility(8);
                return;
            }
            this.mTagView.setVisibility(8);
            this.mBrandTagView.setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public ContentDetailRelatedBrand(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ContentDetailRelatedBrand(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ContentDetailRelatedBrand(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }
}
