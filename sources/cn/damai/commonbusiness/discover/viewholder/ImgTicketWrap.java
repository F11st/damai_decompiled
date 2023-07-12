package cn.damai.commonbusiness.discover.viewholder;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImgTicketWrap implements IImageLoader.ImageTicket {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IImageLoader.ImageTicket a;
    private final String b;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnPicRatioListener {
        void onRatio(String str, float f);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.discover.viewholder.ImgTicketWrap$a */
    /* loaded from: classes4.dex */
    public class C0645a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnPicRatioListener a;
        final /* synthetic */ String b;
        final /* synthetic */ ImageView c;

        C0645a(OnPicRatioListener onPicRatioListener, String str, ImageView imageView) {
            this.a = onPicRatioListener;
            this.b = str;
            this.c = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.C2496b c2496b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1890923591")) {
                ipChange.ipc$dispatch("-1890923591", new Object[]{this, c2496b});
                return;
            }
            Drawable drawable = c2496b.a;
            if (drawable != null) {
                if (this.a != null) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    this.a.onRatio(this.b, (intrinsicHeight <= 0 || intrinsicWidth <= 0) ? -1.0f : intrinsicWidth / intrinsicHeight);
                }
                this.c.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.discover.viewholder.ImgTicketWrap$b */
    /* loaded from: classes4.dex */
    public class C0646b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        C0646b(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.C2495a c2495a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1262155038")) {
                ipChange.ipc$dispatch("-1262155038", new Object[]{this, c2495a});
                return;
            }
            int i = this.a;
            if (i > 0) {
                this.b.setImageResource(i);
            }
        }
    }

    public ImgTicketWrap(IImageLoader.ImageTicket imageTicket, String str) {
        this.a = imageTicket;
        this.b = str;
    }

    public static void b(ImageView imageView, String str, int i, int i2, @Nullable OnPicRatioListener onPicRatioListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "462679275")) {
            ipChange.ipc$dispatch("462679275", new Object[]{imageView, str, Integer.valueOf(i), Integer.valueOf(i2), onPicRatioListener});
            return;
        }
        if (i > 0) {
            imageView.setImageResource(i);
        }
        int a = (int) (((int) (((DisplayMetrics.getwidthPixels(m62.b(mu0.a())) - (m62.a(mu0.a(), 21.0f) * 2)) - m62.a(mu0.a(), 12.0f)) / 2.0f)) * 1.3333334f);
        int i3 = a > 800 ? 800 : a;
        imageView.setTag(new ImgTicketWrap(C2497a.a().load(str, i3, i3, new C0645a(onPicRatioListener, str, imageView), new C0646b(i2, imageView)), str));
    }

    public static void c(ImageView imageView, String str, int i, @Nullable OnPicRatioListener onPicRatioListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151079787")) {
            ipChange.ipc$dispatch("-151079787", new Object[]{imageView, str, Integer.valueOf(i), onPicRatioListener});
        } else if (imageView == null) {
        } else {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i);
                return;
            }
            Object tag = imageView.getTag();
            if (tag instanceof ImgTicketWrap) {
                ImgTicketWrap imgTicketWrap = (ImgTicketWrap) tag;
                if (imgTicketWrap.a(str)) {
                    return;
                }
                imgTicketWrap.cancel();
                b(imageView, str, i, i, onPicRatioListener);
                return;
            }
            b(imageView, str, i, i, onPicRatioListener);
        }
    }

    public boolean a(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "218811047") ? ((Boolean) ipChange.ipc$dispatch("218811047", new Object[]{this, str})).booleanValue() : TextUtils.equals(this.b, str);
    }

    @Override // cn.damai.uikit.image.IImageLoader.ImageTicket
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031705947")) {
            ipChange.ipc$dispatch("1031705947", new Object[]{this});
            return;
        }
        try {
            IImageLoader.ImageTicket imageTicket = this.a;
            if (imageTicket != null) {
                imageTicket.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
