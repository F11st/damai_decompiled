package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FollowFeedData;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.kv2;
import tb.lu2;
import tb.t60;
import tb.vr;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FollowViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    TextView A;
    TextView B;
    View C;
    View D;
    ImageView E;
    Activity w;
    TextView x;
    ImageView y;
    DMAvatar z;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        Bundle a = new Bundle();
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ FollowFeedData e;

        a(String str, int i, int i2, FollowFeedData followFeedData) {
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = followFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1577399060")) {
                ipChange.ipc$dispatch("-1577399060", new Object[]{this, view});
                return;
            }
            FollowViewHolder.this.o(this.a, this.b, this.c, this.d, this.e.schema);
            HashMap hashMap = new HashMap();
            hashMap.put("content_id", this.b);
            hashMap.put("content_type", this.c + "");
            FollowViewHolder followViewHolder = FollowViewHolder.this;
            Activity activity = followViewHolder.w;
            String str = followViewHolder.q;
            kv2.f(activity, str, lu2.DYNAMIC, "dynamic_" + FollowViewHolder.this.itemView.getTag(), true, FollowViewHolder.this.t, hashMap);
        }
    }

    public FollowViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        this.x = (TextView) view.findViewById(R$id.tv_comment);
        this.y = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        this.z = (DMAvatar) view.findViewById(R$id.feeds_item_avatar);
        TextView textView = (TextView) view.findViewById(R$id.feeds_item_date);
        this.A = (TextView) view.findViewById(R$id.feeds_item_playtitle);
        this.B = (TextView) view.findViewById(R$id.feeds_item_subtitle);
        this.C = view.findViewById(R$id.ll_itemcell);
        this.D = view.findViewById(R$id.feed_unclick_tag);
        this.E = (ImageView) view.findViewById(R$id.user_vip_level);
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525130016")) {
            ipChange.ipc$dispatch("525130016", new Object[]{this, feedMergeDataDO});
            return;
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FollowFeedData followFeedData = feedMergeDataDO.followData.get(0);
        String str2 = followFeedData.name;
        String str3 = followFeedData.place;
        String str4 = followFeedData.img;
        int i = followFeedData.subBizType;
        int i2 = followFeedData.viewStatus;
        long j = followFeedData.havanaId;
        if (j != 0) {
            str = String.valueOf(j);
        } else {
            str = followFeedData.bizId;
        }
        String str5 = str;
        if (str2 != null) {
            this.A.setText(str2);
            if (!wh2.j(str3)) {
                this.B.setVisibility(0);
                this.B.setText(str3);
            } else {
                this.B.setVisibility(8);
            }
            if (1 != i && 2 != i) {
                if (this.y.getTag() instanceof vr) {
                    ((vr) this.y.getTag()).cancel();
                }
                DMImageCreator k = cn.damai.common.image.a.b().c(str4).k(new DMRoundedCornersBitmapProcessor(t60.a(this.w, 3.0f), 0));
                int i3 = R$drawable.uikit_default_image_bg_gradient;
                vr g = k.i(i3).c(i3).g(this.y);
                this.y.setVisibility(0);
                DMAvatar dMAvatar = this.z;
                if (dMAvatar != null) {
                    dMAvatar.setVisibility(8);
                }
                this.y.setTag(g);
                View view = this.D;
                if (view != null) {
                    if (i2 == 0 && 6 == followFeedData.subBizType) {
                        view.setVisibility(0);
                    } else {
                        view.setVisibility(8);
                    }
                }
            } else {
                if (this.y.getTag() instanceof vr) {
                    ((vr) this.y.getTag()).cancel();
                }
                this.y.setVisibility(4);
                this.z.setAvatar(str4);
                this.z.setVisibility(0);
                this.z.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_60x60);
                if (followFeedData.vtag != 0) {
                    this.z.setAvatarVTagVisibility(0);
                } else {
                    this.z.setAvatarVTagVisibility(8);
                }
                if (followFeedData.vip) {
                    this.z.setAvatarCrownVisibility(0);
                    this.z.setAvatarBorderVisibility(0);
                } else {
                    this.z.setAvatarCrownVisibility(8);
                    this.z.setAvatarBorderVisibility(8);
                }
                if (this.E != null) {
                    if (!wh2.j(followFeedData.vipLevelIcon)) {
                        this.E.setVisibility(0);
                        cn.damai.common.image.a.b().c(followFeedData.vipLevelIcon).g(this.E);
                    } else {
                        this.E.setVisibility(8);
                    }
                }
            }
        }
        this.C.setOnClickListener(new a(str5, i, i2, followFeedData));
    }
}
