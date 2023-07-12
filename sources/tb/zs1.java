package tb;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class zs1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<PoiItem> a;
    private AMap b;
    private ArrayList<Marker> c = new ArrayList<>();

    public zs1(AMap aMap, List<PoiItem> list) {
        this.b = aMap;
        this.a = list;
    }

    private LatLngBounds c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295637249")) {
            return (LatLngBounds) ipChange.ipc$dispatch("1295637249", new Object[]{this});
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (int i = 0; i < this.a.size(); i++) {
            builder.include(new LatLng(this.a.get(i).getLatLonPoint().getLatitude(), this.a.get(i).getLatLonPoint().getLongitude()));
        }
        return builder.build();
    }

    private MarkerOptions d(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1097008910") ? (MarkerOptions) ipChange.ipc$dispatch("1097008910", new Object[]{this, Integer.valueOf(i)}) : new MarkerOptions().position(new LatLng(this.a.get(i).getLatLonPoint().getLatitude(), this.a.get(i).getLatLonPoint().getLongitude())).title(f(i)).snippet(e(i)).icon(b(i));
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152477005")) {
            ipChange.ipc$dispatch("-1152477005", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            try {
                Marker addMarker = this.b.addMarker(d(i));
                addMarker.setObject(Integer.valueOf(i));
                this.c.add(addMarker);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    protected BitmapDescriptor b(int i) {
        throw null;
    }

    protected String e(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1479790423") ? (String) ipChange.ipc$dispatch("-1479790423", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i).getSnippet();
    }

    protected String f(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "213741390") ? (String) ipChange.ipc$dispatch("213741390", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i).getTitle();
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020802231")) {
            ipChange.ipc$dispatch("-2020802231", new Object[]{this});
            return;
        }
        Iterator<Marker> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1238607067")) {
            ipChange.ipc$dispatch("1238607067", new Object[]{this});
            return;
        }
        try {
            List<PoiItem> list = this.a;
            if (list != null && list.size() > 0) {
                if (this.b == null) {
                    return;
                }
                if (this.a.size() == 1) {
                    this.b.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.a.get(0).getLatLonPoint().getLatitude(), this.a.get(0).getLatLonPoint().getLongitude()), 18.0f));
                } else {
                    this.b.moveCamera(CameraUpdateFactory.newLatLngBounds(c(), 5));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
