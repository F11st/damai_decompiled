package com.alibaba.pictures.bricks.component.home.grabhotrecommend;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$dimen;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.HomeGrabHotBean;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotContract;
import com.alibaba.pictures.bricks.view.DMCountDownView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alient.onearch.adapter.view.AbsView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.s60;
import tb.ss;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HomeCardGrabView extends AbsView<GenericItem<ItemValue>, HomeGrabHotModel, HomeGrabHotPresent> implements HomeGrabHotContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final RoundImageView artistImage;
    private final TextView artistName;
    private final View artistPicView;
    @NotNull
    private final String fontName;
    private final int gap;
    @NotNull
    private final View itemView;
    private int pointSize;
    private final DMDigitTextView price;
    private final TextView priceLabel;
    private final TextView priceUnit;
    private final RoundImageView projectImage;
    private final RoundImageView projectImageCover;
    private final LinearLayout rightBottomView;
    private final ViewGroup rightView;
    private final ViewGroup rlGrabView;
    private final TextView rlGrabViewTv;
    private final FrameLayout rlLabelTags;
    @NotNull
    private final String separatorText;
    private final int smallTextBgWidth;
    private final TextView subtitle;
    private final int textBgCornerRadius;
    @NotNull
    private String textColor;
    private final int textMarginBottom;
    private int textMarginLeft;
    private int textMarginRight;
    private final int textMarginTop;
    private final TextView title;
    private final TextView wanneSeetitle;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView$a */
    /* loaded from: classes7.dex */
    public static final class View$OnAttachStateChangeListenerC3475a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;
        final /* synthetic */ DMCountDownView b;

        View$OnAttachStateChangeListenerC3475a(long j, DMCountDownView dMCountDownView) {
            this.a = j;
            this.b = dMCountDownView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1826793972")) {
                ipChange.ipc$dispatch("1826793972", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            long j = this.a;
            TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
            long g = (j - timeSyncer.g()) / 1000;
            if (g <= 0) {
                this.b.stopCountDown();
            } else {
                this.b.setCountTime(g).startCountDown();
            }
            Log.e("subTitleView", this.b.getId() + " onViewAttachedToWindow newTime : " + g + " , server: " + timeSyncer + ".currentServerTime/1000");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-969113231")) {
                ipChange.ipc$dispatch("-969113231", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            this.b.pauseCountDown();
            Log.e("subTitleView", this.b.getId() + " onViewDetachedFromWindow , countDownView.timeStamp");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCardGrabView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.projectImage = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image);
        this.projectImageCover = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image_cover);
        this.artistImage = (RoundImageView) view.findViewById(R$id.bricks_grab_hot_image_artistpic);
        this.artistName = (TextView) view.findViewById(R$id.bricks_grab_hot_image_name);
        this.artistPicView = view.findViewById(R$id.bricks_grab_hot_image_artist);
        this.title = (TextView) view.findViewById(R$id.bricks_grab_hot_title);
        this.subtitle = (TextView) view.findViewById(R$id.bricks_grab_hot_subtitle);
        this.wanneSeetitle = (TextView) view.findViewById(R$id.bricks_grab_hot_title_subtitle);
        this.priceUnit = (TextView) view.findViewById(R$id.bricks_grab_hot_title_price_flag);
        this.price = (DMDigitTextView) view.findViewById(R$id.bricks_grab_hot_title_item_price);
        this.priceLabel = (TextView) view.findViewById(R$id.bricks_grab_hot_title_price_label);
        this.rlGrabView = (ViewGroup) view.findViewById(R$id.bricks_grab_hot_title_grab_view);
        this.rlGrabViewTv = (TextView) view.findViewById(R$id.bricks_grab_hot_title_grab_tv);
        this.rlLabelTags = (FrameLayout) view.findViewById(R$id.bricks_grab_hot_title_tags);
        this.rightView = (ViewGroup) view.findViewById(R$id.bricks_grab_hot_right);
        this.rightBottomView = (LinearLayout) view.findViewById(R$id.bricks_grab_hot_price_layout);
        this.fontName = "URWDIN-Medium";
        this.gap = 1;
        this.pointSize = 20;
        this.separatorText = ":";
        this.smallTextBgWidth = 12;
        this.textColor = "#FFFFFFFF";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m138bindView$lambda0(HomeGrabHotBean homeGrabHotBean, HomeCardGrabView homeCardGrabView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115772020")) {
            ipChange.ipc$dispatch("115772020", new Object[]{homeGrabHotBean, homeCardGrabView, successEvent});
            return;
        }
        b41.i(homeGrabHotBean, "$bean");
        b41.i(homeCardGrabView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            if (homeGrabHotBean.isArtist()) {
                homeCardGrabView.artistImage.setImageDrawable(successEvent.drawable);
                homeCardGrabView.artistImage.setBorder(1.0f, Color.parseColor("#FFffff"));
                homeCardGrabView.artistPicView.setVisibility(0);
                homeCardGrabView.projectImage.setVisibility(8);
                homeCardGrabView.projectImageCover.setVisibility(8);
                return;
            }
            homeCardGrabView.projectImage.setImageDrawable(successEvent.drawable);
            homeCardGrabView.projectImage.setVisibility(0);
            homeCardGrabView.projectImageCover.setVisibility(0);
            homeCardGrabView.artistPicView.setVisibility(8);
            return;
        }
        homeCardGrabView.projectImage.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient_radius3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m139bindView$lambda1(HomeCardGrabView homeCardGrabView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310205118")) {
            ipChange.ipc$dispatch("-310205118", new Object[]{homeCardGrabView, failEvent});
            return;
        }
        b41.i(homeCardGrabView, "this$0");
        homeCardGrabView.projectImage.setImageResource(R$drawable.bricks_uikit_default_image_bg_gradient_radius3);
    }

    private final void countdownfinish(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "554057655")) {
            ipChange.ipc$dispatch("554057655", new Object[]{this, textView, str});
            return;
        }
        this.wanneSeetitle.setVisibility(4);
        textView.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText("火爆热抢中");
        }
    }

    private final SpannableString getBoldSpanString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1946208631")) {
            return (SpannableString) ipChange.ipc$dispatch("-1946208631", new Object[]{this, str});
        }
        String valueOf = String.valueOf(str);
        SpannableString spannableString = new SpannableString(valueOf);
        spannableString.setSpan(new StyleSpan(1), 0, valueOf.length(), 33);
        return spannableString;
    }

    private final SpannableString getSpanString(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-692640550")) {
            return (SpannableString) ipChange.ipc$dispatch("-692640550", new Object[]{this, str, str2});
        }
        String str3 = str + str2;
        SpannableString spannableString = new SpannableString(str3);
        s60 s60Var = s60.INSTANCE;
        Context context = this.itemView.getContext();
        b41.h(context, "itemView.context");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(s60Var.b(context, 10));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#2e333e"));
        StyleSpan styleSpan = new StyleSpan(1);
        Context context2 = this.itemView.getContext();
        b41.h(context2, "itemView.context");
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(s60Var.b(context2, 8));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Color.parseColor("#1A2e333e"));
        spannableString.setSpan(styleSpan, 0, str3.length() - str2.length(), 33);
        spannableString.setSpan(absoluteSizeSpan, str3.length() - str2.length(), str3.length(), 33);
        spannableString.setSpan(foregroundColorSpan, str3.length() - str2.length(), str3.length(), 33);
        spannableString.setSpan(absoluteSizeSpan2, str3.length() - str2.length(), (str3.length() - str2.length()) + 2, 33);
        spannableString.setSpan(foregroundColorSpan2, str3.length() - str2.length(), (str3.length() - str2.length()) + 2, 33);
        return spannableString;
    }

    private final boolean onCountDownView(String str, Context context, final ViewGroup viewGroup, final TextView textView, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444233831")) {
            return ((Boolean) ipChange.ipc$dispatch("-444233831", new Object[]{this, str, context, viewGroup, textView, str2})).booleanValue();
        }
        this.pointSize = context.getResources().getDimensionPixelSize(R$dimen.font_Footnote2_M);
        DMCountDownView dMCountDownView = new DMCountDownView(context);
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 1) {
                viewGroup.removeViewAt(0);
            } else {
                viewGroup.addView(dMCountDownView, 0);
            }
        }
        long b = ss.b(str);
        TimeSyncer timeSyncer = TimeSyncer.INSTANCE;
        if (timeSyncer.g() <= b && timeSyncer.g() > 0) {
            long g = (b - timeSyncer.g()) / 1000;
            Log.e("countdown", " start: " + b + ", server: " + timeSyncer + ".currentServerTime/1000, counttime " + g + ' ');
            if (g == dMCountDownView.getCountTime() || g <= 0) {
                return true;
            }
            s60 s60Var = s60.INSTANCE;
            int b2 = s60Var.b(context, this.smallTextBgWidth);
            int b3 = this.pointSize + this.textMarginTop + this.textMarginBottom + s60Var.b(context, 6);
            this.textMarginLeft = 0;
            this.textMarginRight = 0;
            dMCountDownView.setCountDownEndListener(new DMCountDownView.CountDownEndListener() { // from class: tb.cx0
                @Override // com.alibaba.pictures.bricks.view.DMCountDownView.CountDownEndListener
                public final void onCountDownEnd() {
                    HomeCardGrabView.m140onCountDownView$lambda6(viewGroup, this, textView, str2);
                }
            });
            Log.e("subTitleView", "countTime init : " + g);
            DMCountDownView hourTvTextColor = dMCountDownView.setCountTime(g).showDayTv(true).setHourTvBackgroundColorWithRadius(0, this.textBgCornerRadius).setHourTvTextColor(this.textColor);
            DMCountDownView.CountDownViewGravity countDownViewGravity = DMCountDownView.CountDownViewGravity.GRAVITY_CENTER;
            DMCountDownView hourTvSize = hourTvTextColor.setHourTvGravity(countDownViewGravity).setHourTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setHourTvTextSize((float) s60Var.h(context, this.pointSize)).setHourTvSize(0, b3);
            int i = this.gap;
            DMCountDownView minuteTvSize = hourTvSize.setHourColonTvPadding(i, 0, i, i * 2).setHourColonTvTextColor(this.textColor).setHourColonTvGravity(countDownViewGravity).setHourColonTvText(this.separatorText).setHourColonTvTextSize(s60Var.h(context, this.pointSize)).setMinuteTvBackgroundColorWidthRadius(0, this.textBgCornerRadius).setMinuteTvTextColor(this.textColor).setMinuteTvGravity(countDownViewGravity).setMinuteTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setMinuteTvTextSize(s60Var.h(context, this.pointSize)).setMinuteTvSize(b2, b3);
            int i2 = this.gap;
            minuteTvSize.setMinuteColonTvPadding(i2, 0, i2, i2 * 2).setMinuteColonTvTextColor(this.textColor).setMinuteColonTvGravity(countDownViewGravity).setMinuteColonTvTextSize(s60Var.h(context, this.pointSize)).setSecondTvBackgroundColorWidthRadius(0, this.textBgCornerRadius).setSecondTvTextColor(this.textColor).setSecondTvGravity(countDownViewGravity).setSecondTvPadding(this.textMarginLeft, this.textMarginTop, this.textMarginRight, this.textMarginBottom).setSecondTvTextSize(s60Var.h(context, this.pointSize)).setSecondTvSize(b2, b3).setTimeTvFontName(this.fontName).startCountDown();
            if (viewGroup != null) {
                viewGroup.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC3475a(b, dMCountDownView));
                return true;
            }
            return true;
        }
        dMCountDownView.setVisibility(8);
        countdownfinish(textView, str2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCountDownView$lambda-6  reason: not valid java name */
    public static final void m140onCountDownView$lambda6(ViewGroup viewGroup, HomeCardGrabView homeCardGrabView, TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361498136")) {
            ipChange.ipc$dispatch("-1361498136", new Object[]{viewGroup, homeCardGrabView, textView, str});
            return;
        }
        b41.i(homeCardGrabView, "this$0");
        b41.i(textView, "$tvDesc");
        Integer valueOf = viewGroup != null ? Integer.valueOf(viewGroup.getChildCount()) : null;
        b41.f(valueOf);
        if (valueOf.intValue() > 1) {
            viewGroup.removeViewAt(0);
        }
        homeCardGrabView.countdownfinish(textView, str);
    }

    private final int testTextWidth(String str, TextView textView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668060176")) {
            return ((Integer) ipChange.ipc$dispatch("-1668060176", new Object[]{this, str, textView, Integer.valueOf(i)})).intValue();
        }
        int measureText = (int) textView.getPaint().measureText(str);
        return (measureText / i) + (measureText % i <= 0 ? 0 : 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0237  */
    @Override // com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeGrabHotContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindView(@org.jetbrains.annotations.NotNull final com.alibaba.pictures.bricks.bean.HomeGrabHotBean r22, int r23) {
        /*
            Method dump skipped, instructions count: 1069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView.bindView(com.alibaba.pictures.bricks.bean.HomeGrabHotBean, int):void");
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-616037137") ? (View) ipChange.ipc$dispatch("-616037137", new Object[]{this}) : this.itemView;
    }

    public boolean isGrabHotProject() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1931874383")) {
            return ((Boolean) ipChange.ipc$dispatch("-1931874383", new Object[]{this})).booleanValue();
        }
        return true;
    }
}
