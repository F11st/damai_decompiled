package cn.damai.ticklet.manager;

import cn.damai.ticklet.bean.PerformExtAttr;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.QueryPerformListResultEntryData;
import cn.damai.ticklet.bean.TicketAlipayCardBean;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.UserProjectBean;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.bean.UserVenueBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cn2;
import tb.er1;
import tb.fu1;
import tb.m61;
import tb.mu0;
import tb.x30;
import tb.xh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class DataHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static DataHelper instance = null;
    private static final int pagePerformSize = 50;
    private static final int pageTicektSize = 100;
    private long currentTime = 0;
    private int startPage = 0;
    private int firstSize = 0;

    private DataHelper() {
    }

    public static DataHelper getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811802343")) {
            return (DataHelper) ipChange.ipc$dispatch("811802343", new Object[0]);
        }
        if (instance == null) {
            synchronized (DataHelper.class) {
                if (instance == null) {
                    instance = new DataHelper();
                }
            }
        }
        return instance;
    }

    private List<PerformTable> getPerformNoUserList(int i, int i2, int i3, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-770677736")) {
            return (List) ipChange.ipc$dispatch("-770677736", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)});
        }
        if (xh2.c(fu1.c())) {
            return new ArrayList();
        }
        return er1.c().e(i, i2, i3, j);
    }

    public void deletHistoryPerformList(List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615653011")) {
            ipChange.ipc$dispatch("615653011", new Object[]{this, list});
        } else if (xh2.c(fu1.c())) {
        } else {
            er1.c().a(list);
        }
    }

    public UserTicketTable getAboutToBeginFirstTicket(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209372661")) {
            return (UserTicketTable) ipChange.ipc$dispatch("209372661", new Object[]{this, str});
        }
        if (xh2.c(fu1.c())) {
            return null;
        }
        return cn2.f().c(str);
    }

    public TicketDeatilResult getDeatilList(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "329872215")) {
            return (TicketDeatilResult) ipChange.ipc$dispatch("329872215", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        if (this.currentTime == 0) {
            this.currentTime = x30.a();
        }
        TicketDeatilResult ticketDeatilResult = new TicketDeatilResult();
        ticketDeatilResult.isLocalData = Boolean.TRUE;
        if (!xh2.c(fu1.c())) {
            long currentTimeMillis = System.currentTimeMillis();
            PerformTable d = er1.c().d(str, str2);
            if (d == null) {
                ticketDeatilResult.setLoadTime(System.currentTimeMillis() - currentTimeMillis);
                return ticketDeatilResult;
            }
            ticketDeatilResult.setLoadTime(System.currentTimeMillis() - currentTimeMillis);
            d.setUserProjectVO((UserProjectBean) m61.a(xh2.a(mu0.a(), d.getLocalUserProjectVO()), UserProjectBean.class));
            d.setUserVenueVO((UserVenueBean) m61.a(d.getLocalUserVenueVO(), UserVenueBean.class));
            d.setUserTicketVOList(cn2.f().e(str, i, 100));
            d.setEcertTipsInfo((TicketAlipayCardBean) m61.a(d.getEcertTipsInfodb(), TicketAlipayCardBean.class));
            d.setExtAttr((PerformExtAttr) m61.a(d.getLocalExtAttr(), PerformExtAttr.class));
            ticketDeatilResult.setUserPerformVO(d);
        }
        return ticketDeatilResult;
    }

    public QueryPerformListResultEntryData getList(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134042604")) {
            return (QueryPerformListResultEntryData) ipChange.ipc$dispatch("2134042604", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 1) {
            this.firstSize = 0;
            this.startPage = 0;
            this.currentTime = x30.a();
        }
        List<PerformTable> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        if (!xh2.c(fu1.c())) {
            arrayList = getPerformNoUserList((i - this.startPage) + 1, 50, this.firstSize, this.currentTime);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        QueryPerformListResultEntryData queryPerformListResultEntryData = new QueryPerformListResultEntryData();
        queryPerformListResultEntryData.setLocationData(Boolean.TRUE);
        queryPerformListResultEntryData.setLoadTime(currentTimeMillis2 - currentTimeMillis);
        queryPerformListResultEntryData.setUserPerformVOList(arrayList);
        return queryPerformListResultEntryData;
    }

    public List<PerformTable> getPerformNoStartListFilterByEndTime(int i, int i2, int i3, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337984552")) {
            return (List) ipChange.ipc$dispatch("1337984552", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)});
        }
        if (xh2.c(fu1.c())) {
            return new ArrayList();
        }
        return er1.c().f(i, i2, i3, j);
    }

    public void saveOrUpdatePerformTables(List<PerformTable> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812339621")) {
            ipChange.ipc$dispatch("1812339621", new Object[]{this, list, str});
        } else if (xh2.c(fu1.c())) {
        } else {
            er1.c().i(list, str);
        }
    }

    public void saveOrUpdateTicketDetailResult(TicketDeatilResult ticketDeatilResult, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891237094")) {
            ipChange.ipc$dispatch("891237094", new Object[]{this, ticketDeatilResult, str});
        } else if (xh2.c(fu1.c()) || ticketDeatilResult.getUserPerformVO() == null || xh2.c(ticketDeatilResult.getPerformId())) {
        } else {
            er1.c().h(ticketDeatilResult.getUserPerformVO(), str);
        }
    }

    public void saveOrUpdateTicketTables(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556820410")) {
            ipChange.ipc$dispatch("556820410", new Object[]{this, list});
        } else if (xh2.c(fu1.c())) {
        } else {
            cn2.f().h(list);
        }
    }

    public void updataTicketState(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068792886")) {
            ipChange.ipc$dispatch("1068792886", new Object[]{this, userTicketTable});
        } else if (userTicketTable == null) {
        } else {
            cn2.f().i(userTicketTable);
        }
    }
}
