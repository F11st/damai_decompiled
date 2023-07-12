package cn.damai.commonbusiness.share.evaluate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.share.evaluate.EvaluateScriptMurderShopView;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb1;
import tb.k50;
import tb.t60;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class EvaluateScriptMurderShopView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView shopNameTv;
    private final DMPosterView shopPoster;
    private final TextView shopSubTitleTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EvaluateScriptMurderShopView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ EvaluateScriptMurderShopView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m22bindData$lambda0(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1, DMImageCreator.C0502e c0502e) {
        int parseColor;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660549692")) {
            ipChange.ipc$dispatch("1660549692", new Object[]{evaluateScriptMurderShopView, function1, c0502e});
            return;
        }
        b41.i(evaluateScriptMurderShopView, "this$0");
        b41.i(function1, "$callback");
        Bitmap bitmap = c0502e.b;
        if (bitmap == null) {
            cb1.a("bitmap is null");
            ToastUtil.a().e(evaluateScriptMurderShopView.getContext(), "图片生成失败");
            function1.invoke(null);
            return;
        }
        evaluateScriptMurderShopView.shopPoster.setImageBitmap(bitmap);
        try {
            parseColor = DMRGBUtil.f(bitmap);
        } catch (Exception unused) {
            parseColor = Color.parseColor(Bitmap12ColorHex.C_HEX_7176D4);
        }
        function1.invoke(new ColorDrawable(parseColor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m23bindData$lambda1(EvaluateScriptMurderShopView evaluateScriptMurderShopView, Function1 function1, DMImageCreator.C0501d c0501d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122872606")) {
            ipChange.ipc$dispatch("-122872606", new Object[]{evaluateScriptMurderShopView, function1, c0501d});
            return;
        }
        b41.i(evaluateScriptMurderShopView, "this$0");
        b41.i(function1, "$callback");
        evaluateScriptMurderShopView.shopPoster.setImageDrawable(evaluateScriptMurderShopView.getContext().getResources().getDrawable(R$drawable.store_defult_img));
        ToastUtil.a().e(evaluateScriptMurderShopView.getContext(), "图片生成失败");
        function1.invoke(null);
    }

    public final void bindData(@Nullable StoreInfo storeInfo, @NotNull final Function1<? super Drawable, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566248301")) {
            ipChange.ipc$dispatch("-1566248301", new Object[]{this, storeInfo, function1});
            return;
        }
        b41.i(function1, WXBridgeManager.METHOD_CALLBACK);
        if (storeInfo == null) {
            function1.invoke(null);
            return;
        }
        this.shopNameTv.setText(storeInfo.getStoreName());
        this.shopSubTitleTv.setText(storeInfo.getDes());
        C0504a.b().h(getContext()).c(storeInfo.getStoreImgUrl()).k(new DMRoundedCornersBitmapProcessor(t60.a(getContext(), 6.0f), 0)).n(new DMImageCreator.DMImageSuccListener() { // from class: tb.nf0
            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public final void onSuccess(DMImageCreator.C0502e c0502e) {
                EvaluateScriptMurderShopView.m22bindData$lambda0(EvaluateScriptMurderShopView.this, function1, c0502e);
            }
        }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.mf0
            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public final void onFail(DMImageCreator.C0501d c0501d) {
                EvaluateScriptMurderShopView.m23bindData$lambda1(EvaluateScriptMurderShopView.this, function1, c0501d);
            }
        }).f();
    }

    public final TextView getShopNameTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2080237819") ? (TextView) ipChange.ipc$dispatch("-2080237819", new Object[]{this}) : this.shopNameTv;
    }

    public final DMPosterView getShopPoster() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1934051081") ? (DMPosterView) ipChange.ipc$dispatch("-1934051081", new Object[]{this}) : this.shopPoster;
    }

    public final TextView getShopSubTitleTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1049793480") ? (TextView) ipChange.ipc$dispatch("-1049793480", new Object[]{this}) : this.shopSubTitleTv;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EvaluateScriptMurderShopView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        LayoutInflater.from(context).inflate(R$layout.view_generate_evaluate_script_kill_shop_info, (ViewGroup) this, true);
        this.shopNameTv = (TextView) findViewById(R$id.script_share_page_title);
        this.shopPoster = (DMPosterView) findViewById(R$id.script_share_page_poster);
        this.shopSubTitleTv = (TextView) findViewById(R$id.script_share_page_subtitle);
    }
}
