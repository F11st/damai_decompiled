package tb;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.view.ShareExtendView;
import cn.damai.uikit.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class nb2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-323870418")) {
                ipChange.ipc$dispatch("-323870418", new Object[]{this, view});
                return;
            }
            try {
                try {
                    nb2.a(this.a, this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                ShareManager.E().C();
            }
        }
    }

    public static void a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875378707")) {
            ipChange.ipc$dispatch("-1875378707", new Object[]{context, str});
        } else {
            b(context, str, "复制成功");
        }
    }

    public static void b(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594254217")) {
            ipChange.ipc$dispatch("-594254217", new Object[]{context, str, str2});
            return;
        }
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            ToastUtil.a().e(context, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ShareExtendView c(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489519562")) {
            return (ShareExtendView) ipChange.ipc$dispatch("-489519562", new Object[]{context, str});
        }
        ShareExtendView shareExtendView = new ShareExtendView(context);
        shareExtendView.setExtendViewImage(R$drawable.share_board_copy_link_icon);
        shareExtendView.setExtendViewText("复制链接");
        shareExtendView.setOnClickListener(new a(context, str));
        return shareExtendView;
    }

    public static ShareExtendView d(Context context, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408792781")) {
            return (ShareExtendView) ipChange.ipc$dispatch("-408792781", new Object[]{context, onClickListener});
        }
        ShareExtendView shareExtendView = new ShareExtendView(context);
        shareExtendView.setOnClickListener(onClickListener);
        return shareExtendView;
    }

    public static ShareExtendView e(Context context, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899734674")) {
            return (ShareExtendView) ipChange.ipc$dispatch("899734674", new Object[]{context, onClickListener});
        }
        ShareExtendView shareExtendView = new ShareExtendView(context);
        shareExtendView.setExtendViewImage(R$drawable.share_edit_icon);
        shareExtendView.setExtendViewText(BottomActionDialog.EDIT);
        shareExtendView.setOnClickListener(onClickListener);
        return shareExtendView;
    }

    public static ShareExtendView f(Context context, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618867116")) {
            return (ShareExtendView) ipChange.ipc$dispatch("1618867116", new Object[]{context, onClickListener});
        }
        ShareExtendView shareExtendView = new ShareExtendView(context);
        shareExtendView.setExtendViewImage(R$drawable.share_board_generate_image_icon);
        shareExtendView.setExtendViewText("生成图片");
        shareExtendView.setOnClickListener(onClickListener);
        return shareExtendView;
    }

    public static ShareExtendView g(Context context, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331200508")) {
            return (ShareExtendView) ipChange.ipc$dispatch("331200508", new Object[]{context, onClickListener});
        }
        ShareExtendView shareExtendView = new ShareExtendView(context);
        shareExtendView.setExtendViewImage(R$drawable.share_report_icon);
        shareExtendView.setExtendViewText(BottomActionDialog.REPORT);
        shareExtendView.setOnClickListener(onClickListener);
        return shareExtendView;
    }
}
