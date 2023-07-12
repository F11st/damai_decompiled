package cn.damai.homepage.v2;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.home.bean.BannerItem;
import cn.damai.uikit.view.RoundImageView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.util.DisplayUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BannerViewHolder extends BaseViewHolder<BannerItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView imageView;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.BannerViewHolder$a */
    /* loaded from: classes5.dex */
    public class C1249a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1249a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "419514891")) {
                ipChange.ipc$dispatch("419514891", new Object[]{this, c0502e});
            } else {
                BannerViewHolder.this.imageView.setImageDrawable(c0502e.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.v2.BannerViewHolder$b */
    /* loaded from: classes5.dex */
    public class C1250b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1250b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1660529144")) {
                ipChange.ipc$dispatch("1660529144", new Object[]{this, c0501d});
            } else {
                BannerViewHolder.this.imageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    public BannerViewHolder(@NonNull View view) {
        super(view);
        this.imageView = (RoundImageView) view.findViewById(R$id.image);
        view.setLayoutParams(new RecyclerView.LayoutParams(-1, ((DisplayUtils.getWidthPixels() - DisplayUtils.dp2px(42)) * 100) / 333));
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006112046")) {
            ipChange.ipc$dispatch("-1006112046", new Object[]{this, iItem});
        } else {
            C0504a.b().c(getValue().pic).e(new C1250b()).n(new C1249a()).f();
        }
    }
}
