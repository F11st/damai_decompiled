package cn.damai.commonbusiness.dynamicx.customwidget.colorlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import cn.damai.commonbusiness.util.DMRGBUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import tb.ns;
import tb.qk;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMDXColorFrameLayout extends DXNativeFrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float[] a;
        final /* synthetic */ float[] b;

        a(float[] fArr, float[] fArr2) {
            this.a = fArr;
            this.b = fArr2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2040347675")) {
                ipChange.ipc$dispatch("-2040347675", new Object[]{this, dVar});
            } else {
                DMDXColorFrameLayout.this.resolveColor(this.a, this.b, Color.parseColor(Bitmap12ColorHex.C_HEX_DE3F64));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ float[] b;
        final /* synthetic */ float[] c;

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1525117829")) {
                    ipChange.ipc$dispatch("-1525117829", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                b bVar = b.this;
                DMDXColorFrameLayout.this.resolveColor(bVar.b, bVar.c, i);
            }
        }

        b(String str, float[] fArr, float[] fArr2) {
            this.a = str;
            this.b = fArr;
            this.c = fArr2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1981511098")) {
                ipChange.ipc$dispatch("1981511098", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null) {
            } else {
                DMRGBUtil.h(bitmap, this.a, new a());
            }
        }
    }

    public DMDXColorFrameLayout(@NonNull Context context) {
        super(context);
    }

    public void resolveColor(float[] fArr, float[] fArr2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306141649")) {
            ipChange.ipc$dispatch("-306141649", new Object[]{this, fArr, fArr2, Integer.valueOf(i)});
            return;
        }
        int[] iArr = {qk.a(1.0f, i), qk.a(1.0f, i)};
        if (fArr2 != null && fArr2.length >= 2) {
            iArr = new int[fArr2.length];
            for (int i2 = 0; i2 < fArr2.length; i2++) {
                iArr[i2] = qk.a(fArr2[i2], i);
            }
        }
        setGradientParams(fArr, iArr);
    }

    public void setGradientParams(float[] fArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784883190")) {
            ipChange.ipc$dispatch("784883190", new Object[]{this, fArr, iArr});
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadii(fArr);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }

    public void setImageUrl(String str, float[] fArr, float[] fArr2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275844927")) {
            ipChange.ipc$dispatch("1275844927", new Object[]{this, str, fArr, fArr2});
        } else {
            cn.damai.common.image.a.b().c(str).n(new b(str, fArr2, fArr)).e(new a(fArr2, fArr)).f();
        }
    }

    public void setShadow(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817066416")) {
            ipChange.ipc$dispatch("-1817066416", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else {
            ns.a(this, i, i2, i3, i4, i5);
        }
    }

    public DMDXColorFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setShadow(int i, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494454605")) {
            ipChange.ipc$dispatch("-494454605", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
        } else {
            ns.b(this, i, i2, i3, i4, i5, i6);
        }
    }

    public DMDXColorFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setShadow(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617603390")) {
            ipChange.ipc$dispatch("-617603390", new Object[]{this, iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else {
            ns.d(this, iArr, i, i2, i3, i4, i5);
        }
    }
}
