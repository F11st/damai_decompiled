package cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeInfoViewHolder;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ea0;
import tb.k50;
import tb.og1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CreditExchangeInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final TextView a;
    @NotNull
    private final TextView b;
    @NotNull
    private final LinearLayout c;
    @NotNull
    private final LinearLayout d;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final CreditExchangeInfoViewHolder a(@NotNull ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1720217894")) {
                return (CreditExchangeInfoViewHolder) ipChange.ipc$dispatch("-1720217894", new Object[]{this, viewGroup});
            }
            b41.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_credit_exchange_info_view, viewGroup, false);
            b41.h(inflate, "from(parent.context)\n   …info_view, parent, false)");
            return new CreditExchangeInfoViewHolder(inflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreditExchangeInfoViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.title);
        b41.h(findViewById, "itemView.findViewById(R.id.title)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.desc);
        b41.h(findViewById2, "itemView.findViewById(R.id.desc)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.ll_banners);
        b41.h(findViewById3, "itemView.findViewById(R.id.ll_banners)");
        this.c = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.ll_images);
        b41.h(findViewById4, "itemView.findViewById(R.id.ll_images)");
        this.d = (LinearLayout) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MoImageView moImageView, ProjectMemberPrompt.BannerVO bannerVO, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147599134")) {
            ipChange.ipc$dispatch("1147599134", new Object[]{moImageView, bannerVO, view});
            return;
        }
        b41.i(moImageView, "$this_apply");
        b41.i(bannerVO, "$banner");
        DMNav.from(moImageView.getContext()).toUri(bannerVO.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(CreditExchangeInfoViewHolder creditExchangeInfoViewHolder, MoImageView moImageView, boolean z, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "158348285")) {
            ipChange.ipc$dispatch("158348285", new Object[]{creditExchangeInfoViewHolder, moImageView, Boolean.valueOf(z), eVar});
            return;
        }
        b41.i(creditExchangeInfoViewHolder, "this$0");
        b41.i(moImageView, "$imageView");
        creditExchangeInfoViewHolder.i(moImageView, eVar.b, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(CreditExchangeInfoViewHolder creditExchangeInfoViewHolder, MoImageView moImageView, boolean z, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973035327")) {
            ipChange.ipc$dispatch("-1973035327", new Object[]{creditExchangeInfoViewHolder, moImageView, Boolean.valueOf(z), dVar});
            return;
        }
        b41.i(creditExchangeInfoViewHolder, "this$0");
        b41.i(moImageView, "$imageView");
        creditExchangeInfoViewHolder.i(moImageView, null, z);
    }

    private final void i(MoImageView moImageView, Bitmap bitmap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284821301")) {
            ipChange.ipc$dispatch("-1284821301", new Object[]{this, moImageView, bitmap, Boolean.valueOf(z)});
        } else if (bitmap == null) {
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, ea0.c(9.0f), 0, 0);
            int f = (int) (ea0.f() - ea0.b(z ? 30.0f : 54.0f));
            layoutParams.width = f;
            layoutParams.height = (f * bitmap.getHeight()) / bitmap.getWidth();
            moImageView.setLayoutParams(layoutParams);
            moImageView.setLocalImageBitmap(bitmap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(@org.jetbrains.annotations.Nullable cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt.ProfitDetailContent r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeInfoViewHolder.d(cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt$ProfitDetailContent):void");
    }

    @NotNull
    public final MoImageView f(@Nullable String str, final boolean z) {
        og1.a a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737491050")) {
            return (MoImageView) ipChange.ipc$dispatch("737491050", new Object[]{this, str, Boolean.valueOf(z)});
        }
        final MoImageView moImageView = new MoImageView(this.a.getContext(), null, 0, 6, null);
        og1.a roundingParams = moImageView.getRoundingParams();
        if (roundingParams == null || (a2 = roundingParams.k(ea0.b(6.0f))) == null) {
            a2 = og1.a.Companion.a(ea0.c(6.0f));
        }
        moImageView.setRoundingParams(a2);
        moImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        cn.damai.common.image.a.b().c(str).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.bq
            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.e eVar) {
                CreditExchangeInfoViewHolder.g(CreditExchangeInfoViewHolder.this, moImageView, z, eVar);
            }
        }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.aq
            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public final void onFail(DMImageCreator.d dVar) {
                CreditExchangeInfoViewHolder.h(CreditExchangeInfoViewHolder.this, moImageView, z, dVar);
            }
        }).f();
        return moImageView;
    }
}
