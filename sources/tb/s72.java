package tb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.util.Bitmap12ColorHex;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.search.helper.SearchHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class s72 {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private ImageView c;
    private ImageView d;
    private View e;
    private View f;
    private View g;
    private ValueAnimator h;
    private int i = R$drawable.bg_b_card_purple_default_3;
    private View.OnClickListener j = new e(this);

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477415882")) {
                ipChange.ipc$dispatch("-1477415882", new Object[]{this, view});
            } else {
                s72.this.h(true);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1961016115")) {
                ipChange.ipc$dispatch("1961016115", new Object[]{this, view});
            } else {
                s72.this.h(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2067213880")) {
                ipChange.ipc$dispatch("-2067213880", new Object[]{this, valueAnimator});
                return;
            }
            Float f = (Float) valueAnimator.getAnimatedValue();
            float floatValue = f.floatValue();
            if (floatValue > 1.0f) {
                floatValue -= 1.0f;
            }
            if (floatValue > 1.0f) {
                floatValue = 1.0f;
            }
            if (floatValue < 0.0f) {
                floatValue = 0.0f;
            }
            if (f.floatValue() > 1.0f) {
                s72.this.e.setAlpha(1.0f - floatValue);
                s72.this.f.setAlpha(floatValue);
                return;
            }
            s72.this.e.setAlpha(floatValue);
            s72.this.f.setAlpha(0.0f);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-451095436")) {
                ipChange.ipc$dispatch("-451095436", new Object[]{this, dVar});
            } else {
                s72.this.d.setImageResource(s72.this.i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public class a extends cn.damai.commonbusiness.util.c {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.c
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1669212296")) {
                    ipChange.ipc$dispatch("1669212296", new Object[]{this, Integer.valueOf(i)});
                } else {
                    s72.this.d.setImageResource(i);
                }
            }
        }

        d(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1369743113")) {
                ipChange.ipc$dispatch("1369743113", new Object[]{this, eVar});
            } else if (eVar != null) {
                if (eVar.a != null) {
                    s72.this.c.setImageDrawable(eVar.a);
                }
                Bitmap bitmap = eVar.b;
                if (bitmap == null || bitmap.isRecycled()) {
                    s72.this.d.setImageResource(s72.this.i);
                } else {
                    Bitmap12ColorHex.e().f(bitmap, this.a, new a());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e(s72 s72Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2109236804")) {
                ipChange.ipc$dispatch("2109236804", new Object[]{this, view});
            } else if (R$id.b_account_bg == view.getId()) {
                Object tag = view.getTag();
                if (tag instanceof BaccountInfo) {
                    xr.c(SearchHelper.JUMP_ACCOUNT_MAIN_PAGE, tag);
                }
            }
        }
    }

    @RequiresApi(api = 12)
    private void g() {
        boolean isShown;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241791839")) {
            ipChange.ipc$dispatch("-1241791839", new Object[]{this});
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            isShown = this.g.isAttachedToWindow();
        } else {
            isShown = this.g.isShown();
        }
        if (isShown) {
            h(true);
        }
        this.g.addOnAttachStateChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 11)
    public void h(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111259088")) {
            ipChange.ipc$dispatch("-111259088", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
        }
        if (z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
            this.h = ofFloat;
            ofFloat.setDuration(1000L);
            this.h.setInterpolator(new LinearInterpolator());
            this.h.setRepeatMode(1);
            this.h.setRepeatCount(-1);
            this.h.addUpdateListener(new b());
            this.h.start();
        }
    }

    public void i(BaccountInfo baccountInfo, boolean z, boolean z2) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-333285846")) {
            ipChange.ipc$dispatch("-333285846", new Object[]{this, baccountInfo, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        boolean equals = TextUtils.equals(baccountInfo.type, "4");
        boolean equals2 = TextUtils.equals(baccountInfo.type, "3");
        String str2 = TextUtils.isEmpty(baccountInfo.name) ? "" : baccountInfo.name;
        this.b.setText(str2);
        this.b.setTextSize(1, str2.length() <= 8 ? 22 : 18);
        this.a.setText(SearchHelper.d(baccountInfo));
        vr vrVar = null;
        if (equals) {
            str = baccountInfo.backgroundPic;
        } else {
            str = !equals2 ? baccountInfo.headPic : null;
        }
        int a2 = m62.a(mu0.a(), 112.0f);
        Object tag = this.c.getTag();
        if (tag instanceof vr) {
            ((vr) tag).cancel();
        }
        if (TextUtils.isEmpty(str)) {
            this.d.setImageResource(this.i);
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setImageDrawable(null);
            vrVar = cn.damai.common.image.a.b().f(str, a2, a2).n(new d(str)).e(new c()).f();
        }
        this.c.setTag(vrVar);
        this.d.setTag(baccountInfo);
        this.d.setOnClickListener(this.j);
    }

    public void j(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420182057")) {
            ipChange.ipc$dispatch("-420182057", new Object[]{this, context, view});
            return;
        }
        this.g = view;
        this.d = (ImageView) view.findViewById(R$id.b_account_bg);
        this.c = (ImageView) view.findViewById(R$id.b_account_icon);
        this.b = (TextView) view.findViewById(R$id.b_account_name);
        this.a = (TextView) view.findViewById(R$id.b_account_fans_and_show);
        this.e = view.findViewById(R$id.b_account_arrow_1);
        this.f = view.findViewById(R$id.b_account_arrow_2);
        g();
    }
}
