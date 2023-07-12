package cn.damai.seat.bean.biz;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderAfterChooseSeatInfo implements Serializable {
    private List<ChooseSeatDetail> chooseSeatDetailList;
    public String distributionId;
    public String orderId;
    public String toast;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    static class ChooseSeatDetail implements Serializable {
        private String floor;
        private String num;
        private String orderId;
        private String row;
        private String seatDesc;
        private String seatId;
        private String skuId;
        private String stand;
        private String subDistributionId;

        ChooseSeatDetail() {
        }
    }
}
