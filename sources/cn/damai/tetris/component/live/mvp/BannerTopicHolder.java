package cn.damai.tetris.component.live.mvp;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.live.bean.LiveHeaderCardItemBean;
import cn.damai.uikit.tag.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BannerTopicHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private ImageView c;
    private DMCategroyTagView d;
    private TextView e;
    private TextView f;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BannerPresenter a;
        final /* synthetic */ int b;

        a(BannerTopicHolder bannerTopicHolder, BannerPresenter bannerPresenter, int i) {
            this.a = bannerPresenter;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-428472540")) {
                ipChange.ipc$dispatch("-428472540", new Object[]{this, view});
                return;
            }
            LiveHeaderCardItemBean liveHeaderCardItemBean = (LiveHeaderCardItemBean) view.getTag();
            BannerPresenter bannerPresenter = this.a;
            if (bannerPresenter != null) {
                bannerPresenter.itemClick(liveHeaderCardItemBean, this.b);
            }
        }
    }

    public BannerTopicHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.live_banner_topic_item, (ViewGroup) null));
        layoutInflater.getContext();
        this.a = this.itemView.findViewById(R$id.layout_left);
        this.b = this.itemView.findViewById(R$id.layout_right);
        this.c = (ImageView) this.itemView.findViewById(R$id.image_view);
        this.d = (DMCategroyTagView) this.itemView.findViewById(R$id.tag_view);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_title);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_desc);
    }

    public void a(int i, int i2, LiveHeaderCardItemBean liveHeaderCardItemBean, BannerPresenter bannerPresenter) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388720172")) {
            ipChange.ipc$dispatch("-1388720172", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), liveHeaderCardItemBean, bannerPresenter});
        } else if (liveHeaderCardItemBean == null) {
        } else {
            if (i == 0) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if (i == i2 - 1) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            cn.damai.uikit.image.a.a().loadinto(liveHeaderCardItemBean.pic, this.c);
            this.d.setVisibility(8);
            int i3 = liveHeaderCardItemBean.themePrize;
            if (i3 == 1) {
                this.d.setVisibility(0);
                this.d.setTagName("有奖");
                this.d.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            } else if (i3 == 2) {
                this.d.setVisibility(8);
            }
            this.e.setText(liveHeaderCardItemBean.name);
            if (!TextUtils.isEmpty(liveHeaderCardItemBean.contentCount)) {
                if (!TextUtils.isEmpty(liveHeaderCardItemBean.ipvuv)) {
                    str = liveHeaderCardItemBean.contentCount + " | " + liveHeaderCardItemBean.ipvuv;
                } else {
                    str = liveHeaderCardItemBean.contentCount;
                }
            } else {
                str = liveHeaderCardItemBean.ipvuv;
            }
            this.f.setText(str);
            this.itemView.setOnClickListener(new a(this, bannerPresenter, i));
        }
    }
}
