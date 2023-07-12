package cn.damai.ticklet.ui.detailholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketExtMapBean;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ticklet.inteface.TickletDetailCallback;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.view.TickletDetailMapTopView;
import cn.damai.ticklet.view.TickletDetailServiceItem;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailSceneVenueItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Context a;
    TextureMapView b;
    ImageView c;
    List<TicketServiceFacility> d;
    TickletDetailMapTopView e;
    LinearLayout f;
    LinearLayout g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketExtMapBean a;

        a(TicketExtMapBean ticketExtMapBean) {
            this.a = ticketExtMapBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-291353599")) {
                ipChange.ipc$dispatch("-291353599", new Object[]{this, view});
                return;
            }
            TickletDetailSceneVenueItemHolder tickletDetailSceneVenueItemHolder = TickletDetailSceneVenueItemHolder.this;
            TicketExtMapBean ticketExtMapBean = this.a;
            tickletDetailSceneVenueItemHolder.c(ticketExtMapBean.lat, ticketExtMapBean.lng, ticketExtMapBean.title, 100);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        b(String str, String str2, String str3, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1819936770")) {
                ipChange.ipc$dispatch("1819936770", new Object[]{this, view});
            } else {
                TickletDetailSceneVenueItemHolder.this.c(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        c(String str, String str2, String str3, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-363740157")) {
                ipChange.ipc$dispatch("-363740157", new Object[]{this, view});
            } else {
                TickletDetailSceneVenueItemHolder.this.c(this.a, this.b, this.c, this.d);
            }
        }
    }

    public TickletDetailSceneVenueItemHolder(View view) {
        super(view);
        d(view.getContext());
    }

    private TickletDetailServiceItem b(String str, int i, int i2, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671719719")) {
            return (TickletDetailServiceItem) ipChange.ipc$dispatch("1671719719", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4});
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        TickletDetailServiceItem tickletDetailServiceItem = new TickletDetailServiceItem(this.a);
        tickletDetailServiceItem.update(str, i, new b(str2, str3, str4, i2));
        tickletDetailServiceItem.setLayoutParams(layoutParams);
        return tickletDetailServiceItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i) {
        int i2 = i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317725543")) {
            ipChange.ipc$dispatch("-317725543", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        Context context = this.a;
        if (((TicketDeatilActivity) context) != null) {
            String performId = ((TicketDeatilActivity) context).getPerformId();
            String projectId = ((TicketDeatilActivity) this.a).getProjectId();
            String productSystemId = ((TicketDeatilActivity) this.a).getProductSystemId();
            if (i2 == 0) {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "mass_transit", un2.k().t(projectId, performId), Boolean.TRUE));
            } else if (i2 == 1) {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "parking_lots", un2.k().t(projectId, performId), Boolean.TRUE));
            } else if (i2 == 2) {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "smallfoods", un2.k().t(projectId, performId), Boolean.TRUE));
            } else if (i2 == 3) {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "wc", un2.k().t(projectId, performId), Boolean.TRUE));
            } else if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 100) {
                        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "venue_map_btn", un2.k().t(projectId, performId), Boolean.TRUE));
                    }
                }
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "mall", un2.k().t(projectId, performId), Boolean.TRUE));
            } else {
                cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "venue_info", "quickshop", un2.k().t(projectId, performId), Boolean.TRUE));
            }
            if (i2 == 100) {
                i2 = 0;
            }
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, performId);
            intent.putExtra("chosenLat", str);
            intent.putExtra("chosenLng", str2);
            intent.putExtra("venueName", str3);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, productSystemId);
            intent.putExtra(PushConstants.CLICK_TYPE, i2);
            intent.putExtra("from", TickletVenueActivity.TICKLET_VENUE_FROM_MAP);
            intent.setClass(this.a, TickletVenueActivity.class);
            ((Activity) this.a).startActivity(intent);
            ((Activity) this.a).overridePendingTransition(0, 0);
        }
    }

    private void d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954341165")) {
            ipChange.ipc$dispatch("1954341165", new Object[]{this, context});
            return;
        }
        this.a = context;
        this.b = (TextureMapView) this.itemView.findViewById(R$id.gd_map);
        this.c = (ImageView) this.itemView.findViewById(R$id.gd_map_default);
        this.e = (TickletDetailMapTopView) this.itemView.findViewById(R$id.ticklet_detail_venue_info);
        this.f = (LinearLayout) this.itemView.findViewById(R$id.ticklet_service_first_line);
        this.g = (LinearLayout) this.itemView.findViewById(R$id.ticklet_service_second_line);
        this.d = TicketServiceFacility.getFixedService();
        try {
            if (Build.VERSION.SDK_INT >= 8) {
                MapsInitializer.sdcardDir = context.getExternalFilesDir("amap").getPath();
            }
        } catch (Exception unused) {
        }
        this.b.onCreate(null);
    }

    private void f(TickletDetailServiceItem tickletDetailServiceItem, String str, int i, int i2, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163090114")) {
            ipChange.ipc$dispatch("1163090114", new Object[]{this, tickletDetailServiceItem, str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4});
        } else {
            tickletDetailServiceItem.update(str, i, new c(str2, str3, str4, i2));
        }
    }

    public void e(Object obj, TickletDetailCallback tickletDetailCallback) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919672743")) {
            ipChange.ipc$dispatch("1919672743", new Object[]{this, obj, tickletDetailCallback});
            return;
        }
        TicketExtMapBean ticketExtMapBean = (TicketExtMapBean) obj;
        if (ticketExtMapBean == null) {
            return;
        }
        if (!"1".equals(ticketExtMapBean.pdfVoucher)) {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            try {
                TextureMapView textureMapView = this.b;
                if (textureMapView != null && textureMapView.getMap() != null && !TextUtils.isEmpty(ticketExtMapBean.lat) && !TextUtils.isEmpty(ticketExtMapBean.lng)) {
                    this.b.getMap().clear();
                    LatLng latLng = new LatLng(Double.parseDouble(ticketExtMapBean.lat), Double.parseDouble(ticketExtMapBean.lng));
                    this.b.getMap().addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R$drawable.ticklet_venue_icon)).anchor(0.5f, 0.5f)).setVisible(true);
                    this.b.getMap().moveCamera(CameraUpdateFactory.changeLatLng(latLng));
                    tickletDetailCallback.initVenueMap(this.b, ticketExtMapBean);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            if (this.f.getChildCount() != 0 && this.g.getChildCount() != 0) {
                for (int i = 0; i < this.d.size(); i++) {
                    if (i < this.d.size() / 2) {
                        childAt = this.f.getChildAt(i);
                    } else {
                        childAt = this.g.getChildAt(i % (this.d.size() / 2));
                    }
                    if (childAt != null) {
                        f(childAt, this.d.get(i).getName(), this.d.get(i).iconFontId, this.d.get(i).type, ticketExtMapBean.lat, ticketExtMapBean.lng, ticketExtMapBean.title);
                    }
                }
            } else {
                this.f.removeAllViews();
                this.g.removeAllViews();
                for (int i2 = 0; i2 < this.d.size(); i2++) {
                    TickletDetailServiceItem b2 = b(this.d.get(i2).getName(), this.d.get(i2).iconFontId, this.d.get(i2).type, ticketExtMapBean.lat, ticketExtMapBean.lng, ticketExtMapBean.title);
                    if (i2 < this.d.size() / 2) {
                        this.f.addView(b2);
                    } else {
                        this.g.addView(b2);
                    }
                }
            }
            this.e.update(ticketExtMapBean, true, true, (View.OnClickListener) new a(ticketExtMapBean));
            return;
        }
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.e.update(ticketExtMapBean, true, true, (View.OnClickListener) null);
    }

    public TickletDetailSceneVenueItemHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.ticklet_detail_sence_venue_item_view, (ViewGroup) null));
        d(context);
    }
}
