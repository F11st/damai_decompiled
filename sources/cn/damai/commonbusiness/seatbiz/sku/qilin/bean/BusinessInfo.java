package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.notice.bean.NoticeItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class BusinessInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4050080497733857021L;
    public ArrayList<NoticeItem> announcementList;
    public String performZoneNotice;
    public String serviceFeeAgreementURL;
    public String unpaidNotice;

    public ArrayList<ItemContent> subItemContentList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-407920242")) {
            return (ArrayList) ipChange.ipc$dispatch("-407920242", new Object[]{this});
        }
        ArrayList<ItemContent> arrayList = new ArrayList<>();
        if (!cb2.d(this.announcementList)) {
            Iterator<NoticeItem> it = this.announcementList.iterator();
            while (it.hasNext()) {
                NoticeItem next = it.next();
                if (!cb2.d(next.getContentList())) {
                    Iterator<ItemContent> it2 = next.getContentList().iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        ItemContent next2 = it2.next();
                        if (i == 0) {
                            next2.setRootTitle(next.getTitle());
                        }
                        arrayList.add(next2);
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }
}
