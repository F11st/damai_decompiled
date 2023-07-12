package com.alibaba.aliweex.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.aliweex.R$anim;
import com.alibaba.aliweex.R$drawable;
import com.alibaba.aliweex.R$id;
import com.alibaba.aliweex.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.taobao.weex.ui.view.WXHorizontalScrollView;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.List;
import tb.ud0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class Elevator {
    private Context a;
    private LinearLayout b;
    private LinearLayout c;
    private FrameLayout d;
    private int e;
    private WXHorizontalScrollView f;
    private GridView g;
    private ElevatorAdapter h;
    private ViewGroup i;
    private ImageView j;
    private TextView k;
    private ElevatorOnClicklistener l;
    private PopupWindow m;
    private int r;
    private IWATabHeaderChanged s;
    private Animation v;
    private Animation w;
    private ViewGroup x;
    int p = 0;
    int q = 0;
    private List<ElevatorText> t = new ArrayList();
    private List<ud0> u = new ArrayList();
    private String n = "#EE0A3B";
    private String o = "#333333";

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface ElevatorOnClicklistener {
        void OnClick(ud0 ud0Var);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface IWATabHeaderChanged {
        void changed();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Elevator.this.m.setFocusable(false);
            Elevator.this.l();
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
                return true;
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class d implements WXHorizontalScrollView.ScrollViewListener {
        d() {
        }

        @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
        public void onScrollChanged(WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4) {
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Elevator.this.l();
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class f implements View.OnClickListener {
        final /* synthetic */ int[] a;

        f(int[] iArr) {
            this.a = iArr;
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            Elevator.this.m.setFocusable(true);
            view.getLocationOnScreen(this.a);
            if (Elevator.this.m.isShowing()) {
                Elevator.this.l();
            } else {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                view.getWindowVisibleDisplayFrame(new Rect());
                int dip2px = (iArr[1] - (Elevator.this.r / 2)) - WXViewUtils.dip2px(46.5f);
                if (Build.VERSION.SDK_INT < 24) {
                    Elevator.this.m.showAsDropDown(view, 0, 0);
                } else {
                    int[] iArr2 = new int[2];
                    view.getLocationInWindow(iArr2);
                    Elevator.this.m.showAtLocation(view, 0, 0, dip2px < 0 ? (-dip2px) + iArr2[1] + view.getHeight() : iArr2[1] + view.getHeight());
                }
                Elevator.this.w();
            }
            if (Elevator.this.s != null) {
                Elevator.this.s.changed();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ud0 ud0Var = (ud0) view.getTag();
            if (Elevator.this.l != null) {
                Elevator.this.l.OnClick(ud0Var);
            }
        }
    }

    public Elevator(Context context) {
        this.a = context;
        this.v = AnimationUtils.loadAnimation(context, R$anim.huichang_elevator_first_rotate);
        this.w = AnimationUtils.loadAnimation(context, R$anim.huichang_elevator_back_rotate);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.v.setInterpolator(linearInterpolator);
        this.w.setInterpolator(linearInterpolator);
        this.v.setFillAfter(true);
        this.w.setFillAfter(true);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.huichang_elevator_layout, (ViewGroup) null);
        this.x = viewGroup;
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R$id.linear);
        this.b = linearLayout;
        linearLayout.setGravity(16);
        this.c = (LinearLayout) this.x.findViewById(R$id.linear_bg);
        this.d = (FrameLayout) this.x.findViewById(R$id.itembar);
        this.f = (WXHorizontalScrollView) this.x.findViewById(R$id.horizontalscroll);
        ViewGroup viewGroup2 = this.x;
        int i = R$id.gridView;
        this.g = (GridView) viewGroup2.findViewById(i);
        ViewGroup viewGroup3 = (ViewGroup) this.x.findViewById(R$id.pullButton);
        this.i = viewGroup3;
        viewGroup3.setVisibility(4);
        this.j = (ImageView) this.x.findViewById(R$id.pullImage);
        this.k = (TextView) this.x.findViewById(R$id.downText);
        this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.d.getMeasuredWidth();
        this.h = new ElevatorAdapter(context, R$layout.huichang_tbelevatortext_layout, this.u);
        View inflate = LayoutInflater.from(context).inflate(R$layout.downpop_window, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        this.m = popupWindow;
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.alibaba.aliweex.adapter.view.Elevator.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                Elevator.this.k.setVisibility(4);
                Elevator.this.b.setVisibility(0);
                Elevator.this.i.startAnimation(Elevator.this.w);
            }
        });
        this.m.setTouchable(true);
        this.m.setFocusable(true);
        this.v.setAnimationListener(new a());
        this.w.setAnimationListener(new b());
        this.m.getContentView().setOnTouchListener(new c());
        this.f.setScrollViewListener(new d());
        ((LinearLayout) inflate.findViewById(R$id.downMongolia)).setOnClickListener(new e());
        GridView gridView = (GridView) inflate.findViewById(i);
        this.g = gridView;
        gridView.setAdapter((ListAdapter) this.h);
        this.g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.alibaba.aliweex.adapter.view.Elevator.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (Elevator.this.l != null) {
                    Elevator.this.l.OnClick((ud0) Elevator.this.u.get(i2));
                }
                Elevator.this.l();
            }
        });
        this.i.setOnClickListener(new f(new int[2]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.m.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.k.setVisibility(0);
        this.b.setVisibility(4);
        this.i.startAnimation(this.v);
    }

    public ViewGroup m() {
        return this.x;
    }

    public void n() {
        this.j.setImageResource(R$drawable.huichang_elevator_pulldown);
    }

    public void o(String str) {
        this.c.setBackgroundColor(Color.parseColor(str));
        if (this.m.getContentView() != null) {
            this.g.setBackgroundColor(Color.parseColor(str));
        }
    }

    public void p(ElevatorOnClicklistener elevatorOnClicklistener) {
        this.l = elevatorOnClicklistener;
    }

    public void q(IWATabHeaderChanged iWATabHeaderChanged) {
        this.s = iWATabHeaderChanged;
    }

    public void r(List<ud0> list) {
        boolean z;
        this.u.clear();
        this.u.addAll(list);
        this.b.removeAllViews();
        this.t.clear();
        this.h.notifyDataSetChanged();
        int size = this.u.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ud0 ud0Var = this.u.get(i2);
            ElevatorText elevatorText = new ElevatorText(this.a);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            elevatorText.setText(ud0Var.d());
            elevatorText.setSelectedColor(this.n);
            elevatorText.setNormalColor(this.o);
            elevatorText.measure(makeMeasureSpec, makeMeasureSpec2);
            ud0Var.i(elevatorText.getMeasuredWidth());
            ud0Var.f(i);
            int i3 = this.r;
            if (i3 <= 0) {
                i3 = -1;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i3);
            layoutParams.setMargins(WXViewUtils.dip2px(6.0f), 0, 0, 0);
            elevatorText.setLayoutParams(layoutParams);
            this.t.add(elevatorText);
            elevatorText.setTag(ud0Var);
            elevatorText.setOnClickListener(new g());
            this.b.addView(elevatorText);
            i++;
        }
        int size2 = this.t.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.t.get(i4).hide();
        }
        this.t.get(0).show();
        this.e = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ud0 ud0Var2 = this.u.get(i5);
            ud0Var2.g(false);
            ud0Var2.h(false);
            this.e += ud0Var2.e();
        }
        int i6 = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics());
        if (this.e + (WXViewUtils.dip2px(6.0f) * this.t.size()) <= i6 - ((int) TypedValue.applyDimension(1, 24.0f, this.a.getResources().getDisplayMetrics()))) {
            int dip2px = (i6 - (WXViewUtils.dip2px(6.0f) * this.t.size())) / this.t.size();
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            for (int i8 = 0; i8 < this.u.size(); i8++) {
                ud0 ud0Var3 = this.u.get(i8);
                if (ud0Var3.e() > dip2px) {
                    i7 += ud0Var3.e();
                    arrayList.add(Integer.valueOf(i8));
                }
            }
            if (this.t.size() > arrayList.size()) {
                int dip2px2 = ((i6 - (WXViewUtils.dip2px(6.0f) * this.t.size())) - i7) / (this.t.size() - arrayList.size());
                for (int i9 = 0; i9 < this.u.size(); i9++) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= arrayList.size()) {
                            z = false;
                            break;
                        } else if (((Integer) arrayList.get(i10)).intValue() == i9) {
                            z = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                    if (!z) {
                        this.u.get(i9).i(dip2px2);
                    }
                }
            }
            for (int i11 = 0; i11 < this.t.size(); i11++) {
                ElevatorText elevatorText2 = this.t.get(i11);
                ViewGroup.LayoutParams layoutParams2 = elevatorText2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.u.get(i11).e();
                    elevatorText2.setLayoutParams(layoutParams2);
                }
            }
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        this.u.get(0).g(true);
        this.u.get(0).h(true);
        this.h.notifyDataSetChanged();
    }

    public void s(int i) {
        int size = this.t.size();
        if (i < 0 || i >= size) {
            return;
        }
        for (ElevatorText elevatorText : this.t) {
            elevatorText.hide();
        }
        this.t.get(i).show();
        for (ud0 ud0Var : this.u) {
            ud0Var.g(false);
            ud0Var.h(false);
        }
        this.u.get(i).g(true);
        this.u.get(i).h(true);
        this.p = 0;
        this.q = 0;
        for (int i2 = i; i2 < this.u.size(); i2++) {
            this.p += this.u.get(i).e();
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.q += this.u.get(i3).e() + WXViewUtils.dip2px(6.0f);
        }
        this.f.smoothScrollTo(this.q - (i > 0 ? (DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) / 2) - (this.u.get(i - 1).e() / 2) : 0), 0);
        IWATabHeaderChanged iWATabHeaderChanged = this.s;
        if (iWATabHeaderChanged != null) {
            iWATabHeaderChanged.changed();
        }
        this.h.notifyDataSetChanged();
    }

    public void t(String str) {
        this.o = str;
        if (this.t != null) {
            for (int i = 0; i < this.t.size(); i++) {
                ElevatorText elevatorText = this.t.get(i);
                elevatorText.setNormalColor(this.n);
                if (i < this.u.size()) {
                    if (this.u.get(i).b()) {
                        elevatorText.show();
                    } else {
                        elevatorText.hide();
                    }
                }
            }
        }
        this.h.setNormalColor(str);
    }

    public void u(String str) {
        this.n = str;
        if (this.t != null) {
            for (int i = 0; i < this.t.size(); i++) {
                ElevatorText elevatorText = this.t.get(i);
                elevatorText.setSelectedColor(str);
                if (i < this.u.size()) {
                    if (this.u.get(i).b()) {
                        elevatorText.show();
                    } else {
                        elevatorText.hide();
                    }
                }
            }
        }
        this.h.setSelectedColor(str);
    }

    public void v(int i) {
        this.r = i;
    }
}
