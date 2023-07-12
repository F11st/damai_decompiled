package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.discover.main.bean.FollowRecommendBean;
import cn.damai.discover.main.bean.FollowUserInfoBean;
import cn.damai.discover.main.ui.viewholder.PeopleItemHolder;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.z91;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class FollowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int RECOMMEND_PEOPLE = 1;
    private Context a;
    private View.OnClickListener b;
    private View.OnClickListener c;
    private List<FollowRecommendBean> d = new ArrayList();

    public FollowAdapter(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.a = context;
        this.b = onClickListener;
        this.c = onClickListener2;
    }

    public void a(List<FollowRecommendBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652719685")) {
            ipChange.ipc$dispatch("652719685", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.d.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(int i, boolean z) {
        FollowRecommendBean followRecommendBean;
        FollowUserInfoBean followUserInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362851298")) {
            ipChange.ipc$dispatch("362851298", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (this.d != null) {
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                if (i2 == i && (followRecommendBean = this.d.get(i2)) != null && (followUserInfoBean = followRecommendBean.userInfo) != null) {
                    followUserInfoBean.focus = z;
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "403488568") ? ((Integer) ipChange.ipc$dispatch("403488568", new Object[]{this})).intValue() : wh2.e(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87597601")) {
            return ((Integer) ipChange.ipc$dispatch("-87597601", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        FollowRecommendBean followRecommendBean;
        FollowUserInfoBean followUserInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112946881")) {
            ipChange.ipc$dispatch("2112946881", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder == null || (followRecommendBean = this.d.get(i)) == null || (followUserInfoBean = followRecommendBean.userInfo) == null) {
        } else {
            followUserInfoBean.index = i;
            PeopleItemHolder peopleItemHolder = (PeopleItemHolder) viewHolder;
            peopleItemHolder.itemView.setTag(followUserInfoBean);
            peopleItemHolder.a(followRecommendBean, i, this.b);
            peopleItemHolder.itemView.setOnClickListener(this.c);
            z91.m(peopleItemHolder.itemView, i, followRecommendBean.userInfo.id);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200467541")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("200467541", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 1) {
            return null;
        }
        return new PeopleItemHolder(LayoutInflater.from(this.a).inflate(R$layout.live_people_item_layout, viewGroup, false));
    }

    public void setData(List<FollowRecommendBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938241180")) {
            ipChange.ipc$dispatch("-1938241180", new Object[]{this, list});
        } else if (wh2.e(list) > 0) {
            this.d.clear();
            a(list);
        } else {
            this.d.clear();
            notifyDataSetChanged();
        }
    }
}
