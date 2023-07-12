package cn.damai.tetris.component.online.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.home.utils.DMMarqueeView;
import cn.damai.tetris.component.online.bean.ArtistItemBean;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m62;
import tb.mu0;
import tb.th2;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OnlineStarViewV2 extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private RoundImageView mHeadSingle;
    private DMMarqueeView mMultiUserView;
    private TextView mSingleNameTv;
    private LinearLayout mSingleStarView;
    private int width;

    public OnlineStarViewV2(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174989771")) {
            ipChange.ipc$dispatch("-174989771", new Object[]{this});
            return;
        }
        setOrientation(1);
        removeAllViews();
        this.width = m62.a(mu0.a(), 20.0f);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.online_star_layout_mul, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.mMultiUserView = (DMMarqueeView) inflate.findViewById(R$id.multi_user_layout);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.single_user_layout);
        this.mSingleStarView = linearLayout;
        this.mSingleNameTv = (TextView) linearLayout.findViewById(R$id.user_head_single_name);
        this.mHeadSingle = (RoundImageView) this.mSingleStarView.findViewById(R$id.user_head_single);
        addView(inflate, layoutParams);
    }

    private void loadHead(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402491512")) {
            ipChange.ipc$dispatch("-402491512", new Object[]{this, str, imageView});
            return;
        }
        C0504a h = C0504a.b().h(mu0.a());
        int i = this.width;
        DMImageCreator f = h.f(str, i, i);
        int i2 = R$drawable.uikit_user_default_icon_trans_white;
        f.i(i2).c(i2).k(new yq()).g(imageView);
    }

    public void setPicList(List<ArtistItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-412417643")) {
            ipChange.ipc$dispatch("-412417643", new Object[]{this, list});
            return;
        }
        int b = th2.b(list);
        if (b == 0) {
            this.mSingleStarView.setVisibility(8);
            this.mMultiUserView.setVisibility(8);
        } else if (b == 1) {
            this.mSingleStarView.setVisibility(0);
            this.mMultiUserView.setVisibility(8);
            ArtistItemBean artistItemBean = list.get(0);
            if (artistItemBean != null) {
                this.mSingleNameTv.setText(artistItemBean.artistName);
                loadHead(artistItemBean.artistAvatar, this.mHeadSingle);
            }
        } else {
            this.mSingleStarView.setVisibility(8);
            this.mMultiUserView.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < b; i++) {
                ArtistItemBean artistItemBean2 = list.get(i);
                if (artistItemBean2 != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.homepage_video_item_artist, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R$id.user_head_single_name)).setText(artistItemBean2.artistName);
                    loadHead(artistItemBean2.artistAvatar, (ImageView) inflate.findViewById(R$id.user_head_single));
                    arrayList.add(inflate);
                }
            }
            this.mMultiUserView.setAnimationDuration(500L);
            this.mMultiUserView.setFlipInterval(3000);
            this.mMultiUserView.setItems(arrayList);
        }
    }

    public OnlineStarViewV2(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}
