package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.cuser.adapter.CommonFollowAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.kv2;
import tb.lu2;
import tb.t60;
import tb.vr;
import tb.wh2;
import tb.yq;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FollowUserListHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FollowFeedData a;
        final /* synthetic */ FeedMergeDataDO b;

        a(FollowFeedData followFeedData, FeedMergeDataDO feedMergeDataDO) {
            this.a = followFeedData;
            this.b = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-293185712")) {
                ipChange.ipc$dispatch("-293185712", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            FollowFeedData followFeedData = this.a;
            long j = followFeedData.havanaId;
            if (j != 0) {
                FollowUserListHolder followUserListHolder = FollowUserListHolder.this;
                String valueOf = String.valueOf(j);
                FollowFeedData followFeedData2 = this.a;
                followUserListHolder.o(bundle, valueOf, followFeedData2.subBizType, followFeedData2.viewStatus, followFeedData2.schema);
            } else {
                FollowUserListHolder.this.o(bundle, followFeedData.bizId, followFeedData.subBizType, followFeedData.viewStatus, followFeedData.schema);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("content_id", this.a.bizId);
            hashMap.put("content_type", this.b.bizType);
            FollowUserListHolder followUserListHolder2 = FollowUserListHolder.this;
            Activity activity = followUserListHolder2.w;
            String str = followUserListHolder2.q;
            kv2.f(activity, str, lu2.DYNAMIC, "dynamic_" + FollowUserListHolder.this.itemView.getTag(), true, FollowUserListHolder.this.t, hashMap);
        }
    }

    public FollowUserListHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847700860")) {
            ipChange.ipc$dispatch("-847700860", new Object[]{this, feedMergeDataDO});
            return;
        }
        List<FollowFeedData> list = feedMergeDataDO.followData;
        if (list == null) {
            return;
        }
        ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).removeAllViews();
        for (int size = list.size() - 1; size >= 0; size--) {
            CommonFollowAdapter.ViewHolder onCreateViewHolder = new CommonFollowAdapter(this.w, null).onCreateViewHolder((ViewGroup) this.itemView, 0);
            ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).addView(onCreateViewHolder.itemView);
            View view = this.itemView;
            int i = R$id.item_scrollview;
            ViewGroup.LayoutParams layoutParams = view.findViewById(i).getLayoutParams();
            if (this.t) {
                layoutParams.height = t60.a(this.w, 112.0f);
            } else {
                layoutParams.height = t60.a(this.w, 154.0f);
            }
            this.itemView.findViewById(i).setLayoutParams(layoutParams);
            FollowFeedData followFeedData = list.get(size);
            if (onCreateViewHolder.a.getTag() instanceof vr) {
                ((vr) onCreateViewHolder.a.getTag()).cancel();
            }
            new yq(t60.a(this.w, 2.0f), this.w.getResources().getColor(R$color.color_6black));
            onCreateViewHolder.a.setAvatar(followFeedData.img + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
            onCreateViewHolder.a.setOnClickListener(new a(followFeedData, feedMergeDataDO));
            onCreateViewHolder.b.setText(followFeedData.name);
            if (followFeedData.vtag != 0) {
                onCreateViewHolder.a.setAvatarVTagVisibility(0);
            } else {
                onCreateViewHolder.a.setAvatarVTagVisibility(8);
            }
            if (followFeedData.vip) {
                onCreateViewHolder.a.setAvatarCrownVisibility(0);
                onCreateViewHolder.a.setAvatarBorderVisibility(0);
            } else {
                onCreateViewHolder.a.setAvatarCrownVisibility(8);
                onCreateViewHolder.a.setAvatarBorderVisibility(8);
            }
            if (!this.t && !wh2.j(followFeedData.bizId) && !followFeedData.bizId.equals(z20.E())) {
                onCreateViewHolder.c.setVisibility(0);
                onCreateViewHolder.c.setState(followFeedData.followStatus);
                Log.d("usertag", " type : " + followFeedData.subBizType + " , id : " + followFeedData.bizId);
                long j = followFeedData.havanaId;
                if (j != 0) {
                    onCreateViewHolder.c.setInitParams(String.valueOf(j), followFeedData.subBizType + "");
                } else {
                    onCreateViewHolder.c.setInitParams(followFeedData.bizId, followFeedData.subBizType + "");
                }
            } else {
                onCreateViewHolder.c.setVisibility(8);
            }
        }
    }
}
