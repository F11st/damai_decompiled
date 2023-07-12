package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VenuePresenter extends VenueContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenueContract.Presenter
    public void retrieveVenueDetailInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702924191")) {
            ipChange.ipc$dispatch("1702924191", new Object[]{this, str});
            return;
        }
        VenueMapRequest venueMapRequest = new VenueMapRequest();
        venueMapRequest.venueId = str;
        venueMapRequest.request(new DMMtopRequestListener<Venue>(Venue.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.venuemap.VenuePresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1155764519")) {
                    ipChange2.ipc$dispatch("1155764519", new Object[]{this, str2, str3});
                } else {
                    ((VenueContract.View) VenuePresenter.this.mView).onRetrieveVenueInfoError(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(Venue venue) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "643934915")) {
                    ipChange2.ipc$dispatch("643934915", new Object[]{this, venue});
                } else if (venue != null) {
                    ((VenueContract.View) VenuePresenter.this.mView).onRetrieveVenueInfoSuccess(venue);
                }
            }
        });
    }
}
