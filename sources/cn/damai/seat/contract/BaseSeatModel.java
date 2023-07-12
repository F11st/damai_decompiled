package cn.damai.seat.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.seatbiz.utils.Cancelable;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.g92;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface BaseSeatModel extends BaseModel {
    void addBusiness(MtopBusiness mtopBusiness);

    void addCancelable(Cancelable cancelable);

    g92 getIconProvider();

    void onDestroy();
}
