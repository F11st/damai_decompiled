package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.util.QrcodeUtil;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.share.inf.OnFinishListener;
import cn.damai.uikit.view.HoleCardView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.net.URLEncoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class mi1 extends g1<DMShareMessage> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final View b;
    @NotNull
    private final ScrollView c;
    @NotNull
    private final HoleCardView d;
    @NotNull
    private final ImageView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final ImageView g;
    @NotNull
    private final TextView h;
    @NotNull
    private final TextView i;
    @NotNull
    private final ImageView j;

    public mi1(@NotNull Context context) {
        b41.i(context, "mContext");
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_generate_nft_card_image, (ViewGroup) null);
        b41.h(inflate, "from(mContext).inflate(R…ate_nft_card_image, null)");
        this.b = inflate;
        View findViewById = inflate.findViewById(R$id.share_page);
        b41.h(findViewById, "rootView.findViewById(R.id.share_page)");
        this.c = (ScrollView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.hv_container);
        b41.h(findViewById2, "rootView.findViewById(R.id.hv_container)");
        HoleCardView holeCardView = (HoleCardView) findViewById2;
        this.d = holeCardView;
        View findViewById3 = inflate.findViewById(R$id.iv_cover);
        b41.h(findViewById3, "rootView.findViewById(R.id.iv_cover)");
        this.e = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R$id.tv_title);
        b41.h(findViewById4, "rootView.findViewById(R.id.tv_title)");
        this.f = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R$id.iv_nft_back_rim);
        b41.h(findViewById5, "rootView.findViewById(R.id.iv_nft_back_rim)");
        this.g = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R$id.tv_user_name);
        b41.h(findViewById6, "rootView.findViewById(R.id.tv_user_name)");
        this.h = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R$id.tv_yc_code);
        b41.h(findViewById7, "rootView.findViewById(R.id.tv_yc_code)");
        this.i = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R$id.iv_qrcode_img);
        b41.h(findViewById8, "rootView.findViewById(R.id.iv_qrcode_img)");
        this.j = (ImageView) findViewById8;
        holeCardView.setmScallopPositionPx(q60.a(context, 175.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(OnFinishListener onFinishListener, mi1 mi1Var, DMImageCreator.C0502e c0502e) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1407685058")) {
            ipChange.ipc$dispatch("-1407685058", new Object[]{onFinishListener, mi1Var, c0502e});
            return;
        }
        b41.i(mi1Var, "this$0");
        Bitmap bitmap = c0502e.b;
        if (bitmap != null) {
            mi1Var.e.setImageBitmap(bitmap);
        }
        if (onFinishListener != null) {
            onFinishListener.onViewUpdateSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(mi1 mi1Var, OnFinishListener onFinishListener, DMImageCreator.C0501d c0501d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631378174")) {
            ipChange.ipc$dispatch("1631378174", new Object[]{mi1Var, onFinishListener, c0501d});
            return;
        }
        b41.i(mi1Var, "this$0");
        ToastUtil.a().e(mi1Var.a, "图片生成失败");
        if (onFinishListener != null) {
            onFinishListener.onViewUpdateSuccess();
        }
    }

    @NotNull
    public final View c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2024288634") ? (View) ipChange.ipc$dispatch("-2024288634", new Object[]{this}) : this.b;
    }

    @NotNull
    public final ScrollView d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-565194878") ? (ScrollView) ipChange.ipc$dispatch("-565194878", new Object[]{this}) : this.c;
    }

    public void e(@Nullable DMShareMessage dMShareMessage, @Nullable final OnFinishListener onFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818136830")) {
            ipChange.ipc$dispatch("1818136830", new Object[]{this, dMShareMessage, onFinishListener});
        } else if (dMShareMessage != null) {
            this.h.setText(dMShareMessage.userNick);
            this.f.setText(dMShareMessage.shareTitle);
            this.i.setText(dMShareMessage.ycCode);
            if (dMShareMessage.vip) {
                this.g.setImageResource(R$drawable.ticket_nft_back_rim_vip);
            } else {
                this.g.setImageResource(R$drawable.ticket_nft_back_rim);
            }
            int a = q60.a(this.a, 70.0f);
            this.j.setImageBitmap(QrcodeUtil.a(a, GenerateImageUtil.SHARE_URL + URLEncoder.encode(dMShareMessage.shareLink)));
            C0504a.b().h(this.a).c(dMShareMessage.sharePictureUrl).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.li1
                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public final void onSuccess(DMImageCreator.C0502e c0502e) {
                    mi1.f(OnFinishListener.this, this, c0502e);
                }
            }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.ki1
                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public final void onFail(DMImageCreator.C0501d c0501d) {
                    mi1.g(mi1.this, onFinishListener, c0501d);
                }
            }).f();
        }
    }
}
