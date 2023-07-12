package tb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.SortBean;
import cn.damai.projectfilter.bean.Type;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class te2 extends cn.damai.projectfilter.floatview.a<SortBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ViewGroup d;
    private TextView e;
    private long f;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SortBean a;
        final /* synthetic */ Activity b;

        /* compiled from: Taobao */
        /* renamed from: tb.te2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0463a implements CityLocationUtil.LocaltionListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0463a(a aVar) {
            }

            @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
            public void onGetLocalFinsih() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1008137578")) {
                    ipChange.ipc$dispatch("-1008137578", new Object[]{this});
                }
            }

            @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
            public void onGetLocalSuccess(SitesBean sitesBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1101511138")) {
                    ipChange.ipc$dispatch("-1101511138", new Object[]{this, sitesBean});
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2032464916")) {
                    ipChange.ipc$dispatch("-2032464916", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(a.this.b);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public class c implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            c(a aVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1062883893")) {
                    ipChange.ipc$dispatch("-1062883893", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        a(SortBean sortBean, Activity activity) {
            this.a = sortBean;
            this.b = activity;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-472196412")) {
                ipChange.ipc$dispatch("-472196412", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1999307385")) {
                ipChange.ipc$dispatch("1999307385", new Object[]{this});
                return;
            }
            CityLocationUtil cityLocationUtil = new CityLocationUtil(mu0.a(), new C0463a(this));
            cityLocationUtil.p(true);
            cityLocationUtil.n();
            te2.this.getListener().onFloatCall(te2.this.getType(), new FilterData(this.a));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-363705324")) {
                ipChange.ipc$dispatch("-363705324", new Object[]{this, strArr});
            } else {
                gr1.a(this.b, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new b(), new c(this));
            }
        }
    }

    public te2(Context context, List<SortBean> list) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R$layout.item_filter_sort_float, (ViewGroup) null);
        this.d = viewGroup;
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int a2 = m62.a(context, 46.0f);
        if (cb2.d(list)) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            SortBean sortBean = list.get(i);
            sortBean.index = i;
            TextView textView = new TextView(context);
            textView.setLines(1);
            textView.setTextColor(kh0.C_333333);
            textView.setGravity(16);
            textView.setTag(sortBean);
            textView.setText(sortBean.name);
            textView.setOnClickListener(this);
            if (sortBean.isLocationSort()) {
                this.e = textView;
            }
            this.d.addView(textView, -1, a2);
        }
    }

    private void a(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330604015")) {
            ipChange.ipc$dispatch("-1330604015", new Object[]{this, sortBean});
            return;
        }
        Context context = this.a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            activity = k3.b().c();
        }
        if (activity == null || activity.isFinishing()) {
            return;
        }
        new Permission(activity, new PermissionModel(mr1.LOCATION, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new a(sortBean, activity)).b();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251844611")) {
            ipChange.ipc$dispatch("1251844611", new Object[]{this});
            return;
        }
        TextView textView = this.e;
        if (textView == null || !(textView.getTag() instanceof SortBean)) {
            return;
        }
        SortBean sortBean = (SortBean) this.e.getTag();
        boolean i = ir1.i(mr1.LOCATION);
        if (sortBean.isLocationSort()) {
            if (i) {
                this.e.setText(sortBean.name);
                return;
            }
            this.e.setText(sortBean.name + "(定位失败)");
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    /* renamed from: b */
    public void show(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345798229")) {
            ipChange.ipc$dispatch("345798229", new Object[]{this, sortBean});
            return;
        }
        this.f = System.currentTimeMillis();
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView textView = (TextView) this.d.getChildAt(i);
            Object tag = textView.getTag();
            textView.setTextColor((!(tag instanceof SortBean) || sortBean == null) ? false : TextUtils.equals(sortBean.value, ((SortBean) tag).value) ? kh0.C_FF2869 : kh0.C_333333);
        }
        c();
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1798348126") ? (Type) ipChange.ipc$dispatch("-1798348126", new Object[]{this}) : Type.SORT;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1052253670") ? (View) ipChange.ipc$dispatch("-1052253670", new Object[]{this}) : this.d;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263409749")) {
            ipChange.ipc$dispatch("1263409749", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt != null && (childAt.getTag() instanceof SortBean)) {
                getFilterUt().x(childAt, (SortBean) childAt.getTag(), i, currentTimeMillis);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774826312")) {
            ipChange.ipc$dispatch("1774826312", new Object[]{this, view});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof SortBean) {
            SortBean sortBean = (SortBean) tag;
            getFilterUt().q(sortBean);
            if (sortBean.isLocationSort()) {
                if (ir1.i(mr1.LOCATION)) {
                    getListener().onFloatCall(getType(), new FilterData(sortBean));
                    return;
                } else {
                    a(sortBean);
                    return;
                }
            }
            getListener().onFloatCall(getType(), new FilterData(sortBean));
        }
    }
}
