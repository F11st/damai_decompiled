package cn.damai.commonbusiness.wannasee.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeeRecommendViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final WantSeeRecommendView a;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final WantSeeRecommendViewHolder a(@NotNull Context context, @NotNull ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "626764479")) {
                return (WantSeeRecommendViewHolder) ipChange.ipc$dispatch("626764479", new Object[]{this, context, viewGroup});
            }
            b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
            b41.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(R$layout.common_business_want_see_recommend_vh_layout, viewGroup, false);
            b41.h(inflate, "from(context)\n          …vh_layout, parent, false)");
            return new WantSeeRecommendViewHolder(inflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantSeeRecommendViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.want_see);
        b41.h(findViewById, "itemView.findViewById(R.id.want_see)");
        this.a = (WantSeeRecommendView) findViewById;
    }

    public final void a(@Nullable RecommendProjects recommendProjects, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913096340")) {
            ipChange.ipc$dispatch("913096340", new Object[]{this, recommendProjects, Integer.valueOf(i)});
        } else {
            this.a.bindData(recommendProjects);
        }
    }

    @NotNull
    public final WantSeeRecommendView b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1034754881") ? (WantSeeRecommendView) ipChange.ipc$dispatch("-1034754881", new Object[]{this}) : this.a;
    }
}
