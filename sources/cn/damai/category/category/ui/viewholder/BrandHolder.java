package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.ui.adapter.HorizontalBrandAdapter;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import cn.damai.user.view.SpaceItemDecoration;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.o91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BrandHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private HorizontalRecyclerView b;
    private HorizontalBrandAdapter c;

    public BrandHolder(LayoutInflater layoutInflater, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(layoutInflater.inflate(R$layout.category_brand_list, (ViewGroup) null));
        Context context = layoutInflater.getContext();
        this.a = context;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        HorizontalRecyclerView horizontalRecyclerView = (HorizontalRecyclerView) this.itemView.findViewById(R$id.hrv_video);
        this.b = horizontalRecyclerView;
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);
        HorizontalBrandAdapter horizontalBrandAdapter = new HorizontalBrandAdapter(this.a, onClickListener, onClickListener2);
        this.c = horizontalBrandAdapter;
        this.b.setAdapter(horizontalBrandAdapter);
        this.b.addItemDecoration(new SpaceItemDecoration(ScreenUtil.dip2px(this.a, 3.5f)));
    }

    public void a(StarAndBrandItem starAndBrandItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348028857")) {
            ipChange.ipc$dispatch("-348028857", new Object[]{this, starAndBrandItem});
        } else if (starAndBrandItem == null || o91.a(starAndBrandItem.brandList)) {
        } else {
            this.c.d(starAndBrandItem);
        }
    }
}
