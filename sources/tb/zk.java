package tb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.damai.comment.R$drawable;
import cn.damai.common.image.DMImageCreator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class zk {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1728176224")) {
                ipChange.ipc$dispatch("-1728176224", new Object[]{this, dVar});
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1672730933")) {
                ipChange.ipc$dispatch("1672730933", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                this.a.setVisibility(0);
                this.a.setImageBitmap(bitmap);
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    public static int a(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1528936153")) {
            return ((Integer) ipChange.ipc$dispatch("1528936153", new Object[]{Float.valueOf(f)})).intValue();
        }
        int i = R$drawable.comment_evalaute_default_icon;
        if (f == 0.0f) {
            return i;
        }
        if (f <= 2.0f) {
            return R$drawable.comment_evalaute_one_icon;
        }
        if (f <= 4.0f) {
            return R$drawable.comment_evalaute_two_icon;
        }
        if (f <= 6.0f) {
            return R$drawable.comment_evalaute_three_icon;
        }
        if (f <= 8.0f) {
            return R$drawable.comment_evalaute_four_icon;
        }
        return R$drawable.comment_evalaute_five_icon;
    }

    public static void b(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309323735")) {
            ipChange.ipc$dispatch("-1309323735", new Object[]{imageView, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (imageView.getTag() instanceof vr) {
                ((vr) imageView.getTag()).cancel();
            }
            imageView.setTag(cn.damai.common.image.a.b().e(str).n(new b(imageView)).e(new a(imageView)).f());
        }
    }
}
