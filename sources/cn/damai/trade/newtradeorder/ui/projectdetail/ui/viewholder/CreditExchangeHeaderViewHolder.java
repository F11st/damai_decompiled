package cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.viewholder.CreditExchangeHeaderViewHolder;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d20;
import tb.ea0;
import tb.k50;
import tb.og1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class CreditExchangeHeaderViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final MoImageView a;
    @NotNull
    private final TextView b;
    @NotNull
    private final TextView c;

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
        public final CreditExchangeHeaderViewHolder a(@NotNull ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-337530788")) {
                return (CreditExchangeHeaderViewHolder) ipChange.ipc$dispatch("-337530788", new Object[]{this, viewGroup});
            }
            b41.i(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_credit_exchange_header_view, viewGroup, false);
            b41.h(inflate, "from(parent.context)\n   …ader_view, parent, false)");
            return new CreditExchangeHeaderViewHolder(inflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreditExchangeHeaderViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        View findViewById = view.findViewById(R$id.poster);
        b41.h(findViewById, "itemView.findViewById(R.id.poster)");
        this.a = (MoImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.title);
        b41.h(findViewById2, "itemView.findViewById(R.id.title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.desc);
        b41.h(findViewById3, "itemView.findViewById(R.id.desc)");
        this.c = (TextView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder, DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535110500")) {
            ipChange.ipc$dispatch("1535110500", new Object[]{creditExchangeHeaderViewHolder, eVar});
            return;
        }
        b41.i(creditExchangeHeaderViewHolder, "this$0");
        creditExchangeHeaderViewHolder.g(eVar.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CreditExchangeHeaderViewHolder creditExchangeHeaderViewHolder, DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768469912")) {
            ipChange.ipc$dispatch("768469912", new Object[]{creditExchangeHeaderViewHolder, dVar});
            return;
        }
        b41.i(creditExchangeHeaderViewHolder, "this$0");
        creditExchangeHeaderViewHolder.g(null);
    }

    private final void g(final Bitmap bitmap) {
        og1.a j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350662216")) {
            ipChange.ipc$dispatch("350662216", new Object[]{this, bitmap});
            return;
        }
        final MoImageView moImageView = this.a;
        og1.a roundingParams = moImageView.getRoundingParams();
        if (roundingParams == null || (j = roundingParams.j(ea0.b(6.0f), ea0.b(6.0f), 0.0f, 0.0f)) == null) {
            j = new og1.a().j(ea0.b(6.0f), ea0.b(6.0f), 0.0f, 0.0f);
        }
        moImageView.setRoundingParams(j);
        moImageView.post(new Runnable() { // from class: tb.yp
            @Override // java.lang.Runnable
            public final void run() {
                CreditExchangeHeaderViewHolder.h(bitmap, moImageView);
            }
        });
        moImageView.setLocalImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Bitmap bitmap, MoImageView moImageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783833415")) {
            ipChange.ipc$dispatch("1783833415", new Object[]{bitmap, moImageView});
            return;
        }
        b41.i(moImageView, "$this_apply");
        if (bitmap == null) {
            moImageView.setLocalDrawable(Integer.valueOf(R$drawable.uikit_default_image_bg_gradient));
            ViewGroup.LayoutParams layoutParams = moImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) (ea0.f() - ea0.b(30.0f));
            }
            ViewGroup.LayoutParams layoutParams2 = moImageView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = (moImageView.getWidth() * d20.SCREEN_WIDTH) / 763;
            }
            moImageView.setLayoutParams(moImageView.getLayoutParams());
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = moImageView.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = (int) (ea0.f() - ea0.b(30.0f));
        }
        ViewGroup.LayoutParams layoutParams4 = moImageView.getLayoutParams();
        if (layoutParams4 != null) {
            layoutParams4.height = (moImageView.getWidth() * height) / width;
        }
        moImageView.setLayoutParams(moImageView.getLayoutParams());
    }

    public final void d(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691043426")) {
            ipChange.ipc$dispatch("-691043426", new Object[]{this, str, str2, str3});
            return;
        }
        cn.damai.common.image.a.b().c(str).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.xp
            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.e eVar) {
                CreditExchangeHeaderViewHolder.e(CreditExchangeHeaderViewHolder.this, eVar);
            }
        }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.wp
            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public final void onFail(DMImageCreator.d dVar) {
                CreditExchangeHeaderViewHolder.f(CreditExchangeHeaderViewHolder.this, dVar);
            }
        }).f();
        TextView textView = this.b;
        if (str2 == null) {
            str2 = "";
        }
        textView.setText(str2);
        TextView textView2 = this.c;
        if (str3 == null) {
            str3 = "";
        }
        textView2.setText(str3);
    }
}
