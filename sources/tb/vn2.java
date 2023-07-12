package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.services.core.PoiItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class vn2 extends zs1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CHOOSE_BACKGROUND = 1;
    public static final int NORMAL_BACKGROUND = 0;
    private int d;
    private Context e;
    private List<PoiItem> f;

    public vn2(AMap aMap, List<PoiItem> list, Context context) {
        super(aMap, list);
        this.d = -1;
        this.f = list;
        this.e = context;
    }

    @Override // tb.zs1
    protected BitmapDescriptor b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061141581")) {
            return (BitmapDescriptor) ipChange.ipc$dispatch("1061141581", new Object[]{this, Integer.valueOf(i)});
        }
        List<PoiItem> list = this.f;
        if (list == null || list.size() == 0) {
            return null;
        }
        PoiItem poiItem = this.f.get(i);
        if (i != this.d) {
            return BitmapDescriptorFactory.fromView(i(poiItem, 0));
        }
        return BitmapDescriptorFactory.fromView(i(poiItem, 1));
    }

    public View i(PoiItem poiItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139814700")) {
            return (View) ipChange.ipc$dispatch("-139814700", new Object[]{this, poiItem, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.e).inflate(R$layout.ticklet_venue_map_mark_center, (ViewGroup) null);
        cb1.b("TickletVenuePoiOverlay:", "Center Point");
        TextView textView = (TextView) inflate.findViewById(R$id.ticklet_venue_exchange_site);
        if (i == 1) {
            textView.setBackgroundDrawable(this.e.getResources().getDrawable(R$drawable.ticklet_venue_map_mark_choose));
        } else {
            textView.setBackgroundDrawable(this.e.getResources().getDrawable(R$drawable.ticklet_venue_map_mark_default));
        }
        textView.setText(poiItem.getTitle());
        return inflate;
    }
}
