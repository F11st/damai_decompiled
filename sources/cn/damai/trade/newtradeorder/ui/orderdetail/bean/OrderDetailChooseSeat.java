package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionTopListModel;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailChooseSeat implements Serializable {
    public boolean flage = false;
    public RegionDataNew regionData;
    public List<RegionTopListModel> regionTopListModelList;
    public RegionDataQuYu seatQuYu;
}
