package cn.damai.uikit.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.util.TDialog;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.q60;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DialogUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface MemberDialogAction extends TDialog.OnDialogShowTimeListener {
        View.OnClickListener getCloseClick();

        View.OnClickListener getContentClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface MemberDialogActionV2 extends MemberDialogAction {
        void loadGifImg(ImageView imageView, String str, View view, View view2);

        void loadHeadImg(DMAvatar dMAvatar, String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.util.DialogUtil$a */
    /* loaded from: classes8.dex */
    public static final class View$OnClickListenerC2560a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TDialog a;

        View$OnClickListenerC2560a(TDialog tDialog) {
            this.a = tDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1370054270")) {
                ipChange.ipc$dispatch("-1370054270", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.util.DialogUtil$b */
    /* loaded from: classes8.dex */
    public static class View$OnClickListenerC2561b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Dialog a;
        private View.OnClickListener b;

        public View$OnClickListenerC2561b(Dialog dialog, View.OnClickListener onClickListener) {
            this.a = dialog;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1351041237")) {
                ipChange.ipc$dispatch("1351041237", new Object[]{this, view});
            } else if (this.a != null) {
                View.OnClickListener onClickListener = this.b;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                this.a.dismiss();
            }
        }
    }

    public static Dialog a(Activity activity, Bitmap bitmap, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, TDialog.OnDialogShowTimeListener onDialogShowTimeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727366665")) {
            return (Dialog) ipChange.ipc$dispatch("-727366665", new Object[]{activity, bitmap, onClickListener, onClickListener2, onDialogShowTimeListener});
        }
        if (activity == null) {
            return null;
        }
        View inflate = activity.getLayoutInflater().inflate(R$layout.ad_popup_window, (ViewGroup) null);
        TDialog tDialog = new TDialog(activity, R$style.translucent_dialog_style);
        tDialog.setContentView(inflate);
        tDialog.setCanceledOnTouchOutside(true);
        int b = yr2.b(activity, bitmap.getHeight(), bitmap.getWidth());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b, (bitmap.getHeight() * b) / bitmap.getWidth());
        ImageView imageView = (ImageView) inflate.findViewById(R$id.homepage_popup_window_image);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(bitmap);
        imageView.setOnClickListener(onClickListener);
        if (onDialogShowTimeListener != null) {
            tDialog.g(onDialogShowTimeListener);
        }
        ((FrameLayout) inflate.findViewById(R$id.homepage_popup_window_close_btn)).setOnClickListener(new View$OnClickListenerC2561b(tDialog, onClickListener2));
        return tDialog;
    }

    public static Dialog b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850426766")) {
            return (Dialog) ipChange.ipc$dispatch("-850426766", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.dna_popup_window, (ViewGroup) null);
        TDialog tDialog = new TDialog(context, R$style.transparent_dialog_style);
        tDialog.setContentView(inflate);
        tDialog.setCanceledOnTouchOutside(false);
        tDialog.h(4);
        int c = yr2.c(context, Double.valueOf(yr2.d(context) * 0.75d).intValue(), 62, 105, 250);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, (c * 251) / SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.homepage_popup_window_dna);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View$OnClickListenerC2560a(tDialog));
        return tDialog;
    }

    public static Dialog c(Activity activity, Bitmap bitmap, String str, String str2, String str3, String str4, MemberDialogActionV2 memberDialogActionV2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061220410")) {
            return (Dialog) ipChange.ipc$dispatch("1061220410", new Object[]{activity, bitmap, str, str2, str3, str4, memberDialogActionV2});
        }
        if (activity == null || activity.isFinishing() || bitmap == null || bitmap.isRecycled() || memberDialogActionV2 == null) {
            return null;
        }
        View inflate = activity.getLayoutInflater().inflate(R$layout.dialog_member_guide_pop, (ViewGroup) null);
        TDialog tDialog = new TDialog(activity, R$style.translucent_dialog_style);
        tDialog.setContentView(inflate);
        tDialog.setCanceledOnTouchOutside(false);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R$id.dmg_img_ui);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.dmg_img);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.dmg_close);
        DMAvatar dMAvatar = (DMAvatar) inflate.findViewById(R$id.dmg_header_ui);
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_60x60);
        dMAvatar.setAvatarCrownVisibility(8);
        dMAvatar.setAvatarBorderVisibility(8);
        dMAvatar.setYYMemberTagView(false, str3);
        TextView textView = (TextView) inflate.findViewById(R$id.dmg_user_name);
        textView.setText(str2);
        if ("10".equals(str3)) {
            textView.setTextColor(Color.parseColor("#FFD0B5"));
        }
        memberDialogActionV2.loadHeadImg(dMAvatar, str);
        imageView.setImageBitmap(bitmap);
        int a = DisplayMetrics.getwidthPixels(l62.c(activity)) - q60.a(activity, 100.0f);
        int a2 = l62.a(activity, 30.0f);
        int width = bitmap.getWidth();
        if (width > 0) {
            a2 += (bitmap.getHeight() * a) / width;
        }
        viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(a, a2));
        imageView.setOnClickListener(new View$OnClickListenerC2561b(tDialog, memberDialogActionV2.getContentClick()));
        frameLayout.setOnClickListener(new View$OnClickListenerC2561b(tDialog, memberDialogActionV2.getCloseClick()));
        tDialog.g(memberDialogActionV2);
        if (!TextUtils.isEmpty(str4)) {
            ImageView imageView2 = (ImageView) inflate.findViewById(R$id.dmg_img_gif);
            imageView2.setVisibility(0);
            memberDialogActionV2.loadGifImg(imageView2, str4, viewGroup, frameLayout);
        }
        return tDialog;
    }

    public static Dialog d(Activity activity, Bitmap bitmap, MemberDialogAction memberDialogAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163651051")) {
            return (Dialog) ipChange.ipc$dispatch("-163651051", new Object[]{activity, bitmap, memberDialogAction});
        }
        if (bitmap == null || bitmap.isRecycled() || activity == null || activity.isFinishing() || memberDialogAction == null) {
            return null;
        }
        View inflate = activity.getLayoutInflater().inflate(R$layout.dialog_member_pop, (ViewGroup) null);
        TDialog tDialog = new TDialog(activity, R$style.translucent_dialog_style);
        tDialog.setContentView(inflate);
        tDialog.setCanceledOnTouchOutside(false);
        int a = DisplayMetrics.getwidthPixels(l62.c(activity)) - q60.a(activity, 100.0f);
        int width = bitmap.getWidth();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, width > 0 ? (bitmap.getHeight() * a) / width : 0);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.dmp_img);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(bitmap);
        imageView.setOnClickListener(new View$OnClickListenerC2561b(tDialog, memberDialogAction.getContentClick()));
        ((FrameLayout) inflate.findViewById(R$id.dmp_close)).setOnClickListener(new View$OnClickListenerC2561b(tDialog, memberDialogAction.getCloseClick()));
        tDialog.g(memberDialogAction);
        return tDialog;
    }
}
