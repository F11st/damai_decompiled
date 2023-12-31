package cn.damai.common.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.alixplayer.opensdk.statistics.StaticsUtil;
import tb.b23;
import tb.nh0;
import tb.ui2;
import tb.vr;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMImageCreator {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object a;
    private wr1 b;
    private DMImageSuccListener c;
    private DMImageFailListener d;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface DMImageFailListener {
        void onFail(d dVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface DMImageMemCacheMissListener {
        void onCacheMiss(c cVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface DMImageSuccListener {
        void onSuccess(e eVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements IPhenixListener<ui2> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1409254332")) {
                return ((Boolean) ipChange.ipc$dispatch("-1409254332", new Object[]{this, ui2Var})).booleanValue();
            }
            e eVar = new e(DMImageCreator.this);
            eVar.a = ui2Var.f();
            eVar.b = ui2Var.f().getBitmap();
            DMImageCreator.this.c.onSuccess(eVar);
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements IPhenixListener<nh0> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(nh0 nh0Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1880475487")) {
                return ((Boolean) ipChange.ipc$dispatch("-1880475487", new Object[]{this, nh0Var})).booleanValue();
            }
            d dVar = new d(DMImageCreator.this);
            dVar.a = nh0Var.f();
            DMImageCreator.this.d.onFail(dVar);
            if (!TextUtils.isEmpty(nh0Var.b())) {
                try {
                    b23.g("DMImageCreator:jsondata={appVersion:" + AppConfig.q() + ",resultCode:" + dVar.a + ",url:" + nh0Var.b() + ",message:" + nh0Var.e() + "}", StaticsUtil.PLAY_CODE_101, "图片加载失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class c {
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class d {
        public int a;

        public d(DMImageCreator dMImageCreator) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class e {
        public Drawable a;
        public Bitmap b;

        public e(DMImageCreator dMImageCreator) {
        }
    }

    public DMImageCreator c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753634047")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-753634047", new Object[]{this, Integer.valueOf(i)});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.k(i);
        }
        return this;
    }

    public DMImageCreator d(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-623869036")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-623869036", new Object[]{this, drawable});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.l(drawable);
        }
        return this;
    }

    public DMImageCreator e(DMImageFailListener dMImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333772380")) {
            return (DMImageCreator) ipChange.ipc$dispatch("333772380", new Object[]{this, dMImageFailListener});
        }
        this.d = dMImageFailListener;
        wr1 wr1Var = this.b;
        if (wr1Var != null && dMImageFailListener != null) {
            wr1Var.m(new b());
        }
        return this;
    }

    public vr f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840819468")) {
            return (vr) ipChange.ipc$dispatch("-840819468", new Object[]{this});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            return new vr(wr1Var.n());
        }
        return null;
    }

    public vr g(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487877674")) {
            return (vr) ipChange.ipc$dispatch("-487877674", new Object[]{this, imageView});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            return new vr(wr1Var.y(imageView));
        }
        return null;
    }

    public DMImageCreator h(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609428642")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-1609428642", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.B(view, i, i2);
        }
        return this;
    }

    public DMImageCreator i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238035766")) {
            return (DMImageCreator) ipChange.ipc$dispatch("238035766", new Object[]{this, Integer.valueOf(i)});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.H(i);
        }
        return this;
    }

    public DMImageCreator j(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153646273")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-1153646273", new Object[]{this, drawable});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.I(drawable);
        }
        return this;
    }

    public DMImageCreator k(BitmapProcessor... bitmapProcessorArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045381593")) {
            return (DMImageCreator) ipChange.ipc$dispatch("1045381593", new Object[]{this, bitmapProcessorArr});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.h(bitmapProcessorArr);
        }
        return this;
    }

    public DMImageCreator l(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816801232")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-816801232", new Object[]{this, obj});
        }
        this.a = obj;
        if (obj instanceof wr1) {
            this.b = (wr1) obj;
        }
        return this;
    }

    public DMImageCreator m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803307021")) {
            return (DMImageCreator) ipChange.ipc$dispatch("-803307021", new Object[]{this});
        }
        wr1 wr1Var = this.b;
        if (wr1Var != null) {
            wr1Var.P();
        }
        return this;
    }

    public DMImageCreator n(DMImageSuccListener dMImageSuccListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58308516")) {
            return (DMImageCreator) ipChange.ipc$dispatch("58308516", new Object[]{this, dMImageSuccListener});
        }
        this.c = dMImageSuccListener;
        wr1 wr1Var = this.b;
        if (wr1Var != null && dMImageSuccListener != null) {
            wr1Var.Q(new a());
        }
        return this;
    }
}
