package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.ticklet.view.TickletSouvenirClassicsView;
import cn.damai.ticklet.view.TickletSouvenirHolderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SounenirViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CONTENT_TYPR = "content_type";
    public static final String IMAVE_TYPR = "image_type";
    private Context a;
    private List<TicketSouvenirBean> b = new ArrayList();
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private View f;

    public SounenirViewPagerAdapter(Context context) {
        this.a = context;
    }

    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1047337635") ? ((Integer) ipChange.ipc$dispatch("1047337635", new Object[]{this})).intValue() : this.e;
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1162765856") ? ((Integer) ipChange.ipc$dispatch("-1162765856", new Object[]{this})).intValue() : this.d;
    }

    public View c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1521459967") ? (View) ipChange.ipc$dispatch("1521459967", new Object[]{this}) : this.f;
    }

    public void d(List<TicketSouvenirBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841565619")) {
            ipChange.ipc$dispatch("1841565619", new Object[]{this, list});
        } else {
            this.b = list;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859279553")) {
            ipChange.ipc$dispatch("-859279553", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972208185")) {
            ipChange.ipc$dispatch("-972208185", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.e = i;
        }
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668841154")) {
            ipChange.ipc$dispatch("1668841154", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1410190998") ? ((Integer) ipChange.ipc$dispatch("1410190998", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129621035")) {
            return ((Integer) ipChange.ipc$dispatch("129621035", new Object[]{this, obj})).intValue();
        }
        if (this.c > 0) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        TickletSouvenirHolderView tickletSouvenirHolderView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840436225")) {
            return ipChange.ipc$dispatch("-840436225", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        TicketSouvenirBean ticketSouvenirBean = this.b.get(i);
        if (i == 0) {
            TickletSouvenirClassicsView tickletSouvenirClassicsView = new TickletSouvenirClassicsView(this.a);
            tickletSouvenirClassicsView.update(ticketSouvenirBean, b(), a(), i);
            tickletSouvenirHolderView = tickletSouvenirClassicsView;
        } else {
            TickletSouvenirHolderView tickletSouvenirHolderView2 = new TickletSouvenirHolderView(this.a);
            tickletSouvenirHolderView2.update(ticketSouvenirBean, b(), a(), i);
            tickletSouvenirHolderView = tickletSouvenirHolderView2;
        }
        tickletSouvenirHolderView.setId(i);
        viewGroup.addView(tickletSouvenirHolderView);
        return tickletSouvenirHolderView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-13718546") ? ((Boolean) ipChange.ipc$dispatch("-13718546", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073999127")) {
            ipChange.ipc$dispatch("1073999127", new Object[]{this});
            return;
        }
        this.c = getCount();
        super.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874429481")) {
            ipChange.ipc$dispatch("-1874429481", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            this.f = (View) obj;
        }
    }
}
