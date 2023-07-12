package tb;

import android.database.Cursor;
import android.util.Base64;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import cn.damai.ticklet.bean.PerformOpModule;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.UserProjectBean;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.bean.UserVenueBean;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.utils.C2088a;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class er1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static er1 b;
    public Boolean a = Boolean.FALSE;

    private er1() {
    }

    private synchronized DbManager b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109243169")) {
            return (DbManager) ipChange.ipc$dispatch("-109243169", new Object[]{this});
        }
        return e40.e().c();
    }

    public static er1 c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635007873")) {
            return (er1) ipChange.ipc$dispatch("-635007873", new Object[0]);
        }
        if (b == null) {
            synchronized (er1.class) {
                if (b == null) {
                    b = new er1();
                }
            }
        }
        return b;
    }

    public synchronized void a(List<PerformTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1316495457")) {
            ipChange.ipc$dispatch("-1316495457", new Object[]{this, list});
            return;
        }
        if (list != null && list.size() > 0) {
            for (PerformTable performTable : list) {
                try {
                    cn2.f().a(performTable.getUserTicketVOList());
                    b().delete(PerformTable.class, q13.c(TicketDetailExtFragment.PERFORM_ID, "=", performTable.getPerformId()));
                } catch (DbException e) {
                    e.printStackTrace();
                    xn2.g(xn2.TICKLET_DB_PERFORM_DELETE_READ_ERROR_CODE, xn2.TICKLET_DB_PERFORM_DELETE_READ_ERROR_MSG, e.getMessage());
                }
            }
        }
    }

    public synchronized PerformTable d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913652472")) {
            return (PerformTable) ipChange.ipc$dispatch("913652472", new Object[]{this, str, str2});
        }
        try {
            return (PerformTable) b().selector(PerformTable.class).o(TicketDetailExtFragment.PERFORM_ID, "=", str).a(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, "=", str2).a("userCode", "=", fu1.c()).d();
        } catch (DbException e) {
            e.printStackTrace();
            xn2.g(xn2.TICKLET_DB_DETAIL_PERFORM_INFO_ERROR_CODE, xn2.TICKLET_DB_DETAIL_PERFORM_INFO_ERROR_MSG, e.getMessage());
            return new PerformTable();
        }
    }

    public List<PerformTable> e(int i, int i2, int i3, long j) {
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1967669593")) {
            return (List) ipChange.ipc$dispatch("-1967669593", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)});
        }
        ArrayList arrayList = new ArrayList();
        try {
            j();
            if (i == 1) {
                i2 = i3;
            } else {
                i4 = i3 + ((i - 2) * i2);
            }
            nf2 nf2Var = new nf2();
            nf2Var.f("select distinct perform.startTimeByLong,perform.timeTitle,perform.endTime,perform.expireTime,perform.createTime,perform.performId,perform.userCode,perform.color,perform.localUserProjectVO,perform.ticketQuantity,perform.localUserVenueVO,perform.isMoreEnter,perform.performType,perform.isLongtermProject,perform.performOpListLocal,perform.productSystemId,perform.performStatus,perform.isCertPerform,perform.isLive,perform.liveType,perform.liveH5Url from perform left outer join ticket on perform.performId = ticket.performId and perform.productSystemId = ticket.productSystemId  where (ticket.voucherState is null or ticket.voucherState != '106' ) and perform.userCode = ? and (ticket.userCode is null or ticket.userCode = ?) and perform.expireTime > ? order by perform.startTimeByLong,perform.createTime  limit ? offset ?");
            nf2Var.a(new t71("userCode", fu1.c()));
            nf2Var.a(new t71("userCode", fu1.c()));
            nf2Var.a(new t71("expireTime", Long.valueOf(j)));
            nf2Var.a(new t71("limit", Integer.valueOf(i2)));
            nf2Var.a(new t71("offset", Integer.valueOf(i4)));
            Cursor execQuery = b().execQuery(nf2Var);
            if (execQuery != null) {
                while (execQuery.moveToNext()) {
                    PerformTable performTable = new PerformTable();
                    performTable.setStartTimeByLong(execQuery.getLong(execQuery.getColumnIndex("startTimeByLong")));
                    performTable.setEndTime(execQuery.getLong(execQuery.getColumnIndex("endTime")));
                    performTable.setCreateTime(execQuery.getLong(execQuery.getColumnIndex("createTime")));
                    performTable.setTimeTitle(execQuery.getString(execQuery.getColumnIndex("timeTitle")));
                    performTable.setExpireTime(execQuery.getLong(execQuery.getColumnIndex("expireTime")));
                    performTable.setPerformId(execQuery.getString(execQuery.getColumnIndex(TicketDetailExtFragment.PERFORM_ID)));
                    performTable.setIsLongtermProject(execQuery.getString(execQuery.getColumnIndex("isLongtermProject")));
                    performTable.setUserCode(execQuery.getString(execQuery.getColumnIndex("userCode")));
                    performTable.setUserProjectVO((UserProjectBean) m61.a(xh2.a(mu0.a(), execQuery.getString(execQuery.getColumnIndex("localUserProjectVO"))), UserProjectBean.class));
                    performTable.setColor(execQuery.getString(execQuery.getColumnIndex("color")));
                    performTable.setTicketQuantity(execQuery.getInt(execQuery.getColumnIndex("ticketQuantity")));
                    performTable.setUserVenueVO((UserVenueBean) m61.a(execQuery.getString(execQuery.getColumnIndex("localUserVenueVO")), UserVenueBean.class));
                    performTable.setIsMoreEnter(execQuery.getString(execQuery.getColumnIndex("isMoreEnter")));
                    performTable.setPerformOpList(j61.a(execQuery.getString(execQuery.getColumnIndex("performOpListLocal")), PerformOpModule.class));
                    performTable.setPerformStatus(execQuery.getString(execQuery.getColumnIndex("performStatus")));
                    performTable.setIsCertPerform(execQuery.getString(execQuery.getColumnIndex("isCertPerform")));
                    performTable.setIsLive(execQuery.getString(execQuery.getColumnIndex("isLive")));
                    performTable.setLiveType(execQuery.getString(execQuery.getColumnIndex("liveType")));
                    performTable.setLiveH5Url(execQuery.getString(execQuery.getColumnIndex("liveH5Url")));
                    performTable.setProductSystemId(execQuery.getString(execQuery.getColumnIndex(TicketDetailExtFragment.PRODUCT_SYSTEM_ID)));
                    performTable.setPerformType(execQuery.getString(execQuery.getColumnIndex("performType")));
                    arrayList.add(performTable);
                }
                execQuery.close();
            }
        } catch (DbException e) {
            e.printStackTrace();
            xn2.g(xn2.TICKLET_DB_PERFORM_NO_START_ERROR_CODE, xn2.TICKLET_DB_PERFORM_NO_START_ERROR_MSG, e.getMessage());
        }
        return arrayList;
    }

    public List<PerformTable> f(int i, int i2, int i3, long j) {
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1793732404")) {
            return (List) ipChange.ipc$dispatch("1793732404", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)});
        }
        ArrayList arrayList = new ArrayList();
        try {
            j();
            if (i == 1) {
                i2 = i3;
            } else {
                i4 = i3 + ((i - 2) * i2);
            }
            nf2 nf2Var = new nf2();
            nf2Var.f("select distinct perform.startTimeByLong,perform.timeTitle,perform.endTime,perform.expireTime,perform.createTime,perform.performId,perform.userCode,perform.localUserProjectVO,perform.productSystemId,perform.performStatus from perform left outer join ticket on perform.performId = ticket.performId and perform.productSystemId = ticket.productSystemId  where ticket.voucherState = '1' and perform.isLongtermProject != '1'  and perform.userCode = ? and ticket.userCode = ? and perform.endTime > ? and perform.startTimeByLong < ? and perform.performStatus <> ? order by perform.startTimeByLong,perform.createTime  limit ? offset ?");
            nf2Var.a(new t71("userCode", fu1.c()));
            nf2Var.a(new t71("userCode", fu1.c()));
            nf2Var.a(new t71("endTime", Long.valueOf(j)));
            nf2Var.a(new t71("startTimeByLong", Long.valueOf(j + 7200000)));
            nf2Var.a(new t71("performStatus", Integer.valueOf(in2.PERFORM_CANCEL)));
            nf2Var.a(new t71("limit", Integer.valueOf(i2)));
            nf2Var.a(new t71("offset", Integer.valueOf(i4)));
            Cursor execQuery = b().execQuery(nf2Var);
            if (execQuery != null) {
                while (execQuery.moveToNext()) {
                    PerformTable performTable = new PerformTable();
                    performTable.setStartTimeByLong(execQuery.getLong(execQuery.getColumnIndex("startTimeByLong")));
                    performTable.setTimeTitle(execQuery.getString(execQuery.getColumnIndex("timeTitle")));
                    performTable.setPerformId(execQuery.getString(execQuery.getColumnIndex(TicketDetailExtFragment.PERFORM_ID)));
                    performTable.setUserCode(execQuery.getString(execQuery.getColumnIndex("userCode")));
                    performTable.setProductSystemId(execQuery.getString(execQuery.getColumnIndex(TicketDetailExtFragment.PRODUCT_SYSTEM_ID)));
                    performTable.setUserProjectVO((UserProjectBean) m61.a(xh2.a(mu0.a(), execQuery.getString(execQuery.getColumnIndex("localUserProjectVO"))), UserProjectBean.class));
                    arrayList.add(performTable);
                }
                execQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            xn2.g(xn2.TICKLET_DB_HOME_HINT_ERROR_CODE, xn2.TICKLET_DB_HOME_HINT_ERROR_MSG, e.getMessage());
        }
        return arrayList;
    }

    public synchronized long g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787920537")) {
            return ((Long) ipChange.ipc$dispatch("787920537", new Object[]{this, str})).longValue();
        }
        long j = 0;
        try {
            j = b().selector(UserTicketTable.class).o(TicketDetailExtFragment.PERFORM_ID, "=", str).b();
        } catch (Exception unused) {
        }
        return j;
    }

    public synchronized Boolean h(PerformTable performTable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493281316")) {
            return (Boolean) ipChange.ipc$dispatch("493281316", new Object[]{this, performTable, str});
        }
        if (performTable != null) {
            try {
                PerformTable performTable2 = (PerformTable) b().selector(PerformTable.class).o(TicketDetailExtFragment.PERFORM_ID, "=", performTable.getPerformId()).a("userCode", "=", fu1.c()).d();
                performTable.setUserCode(fu1.c());
                if (performTable.getUserProjectVO() != null) {
                    String e = m61.e(performTable.getUserProjectVO());
                    if (!xh2.c(e)) {
                        performTable.setLocalUserProjectVO(new String(Base64.encode(C2088a.b(e.getBytes(), fu1.c(), Base64.decode(C2088a.d(mu0.a()), 2)), 2)));
                    }
                }
                if (performTable.getUserVenueVO() != null) {
                    String e2 = m61.e(performTable.getUserVenueVO());
                    if (!xh2.c(e2)) {
                        performTable.setLocalUserVenueVO(e2);
                    }
                }
                performTable.setEcertTipsInfodb(JSON.toJSONString(performTable.getEcertTipsInfo()));
                performTable.setPerformOpListLocal(j61.b(performTable.getPerformOpList()));
                if (performTable.getExtAttr() != null) {
                    performTable.setLocalExtAttr(m61.e(performTable.getExtAttr()));
                }
                if (performTable2 != null) {
                    performTable.setId(performTable2.getId());
                    b().update(performTable, new String[0]);
                } else {
                    b().save(performTable);
                }
                if (performTable.getUserTicketVOList() != null && performTable.getUserTicketVOList().size() > 0) {
                    for (UserTicketTable userTicketTable : performTable.getUserTicketVOList()) {
                        cn2.f().g(userTicketTable);
                    }
                }
                try {
                    un2.k().g(performTable.getPerformId(), String.valueOf(performTable.getTicketQuantity()), String.valueOf(g(performTable.getPerformId())), str);
                } catch (Exception unused) {
                }
                return Boolean.TRUE;
            } catch (Exception e3) {
                e3.printStackTrace();
                if (!this.a.booleanValue()) {
                    this.a = Boolean.TRUE;
                    xn2.g(xn2.TICKLET_DB_PERFORM_SAVE_UPDATE_ERROR_CODE, xn2.TICKLET_DB_PERFORM_SAVE_UPDATE_ERROR_MSG, e3.getMessage());
                }
            }
        }
        return Boolean.FALSE;
    }

    public synchronized void i(List<PerformTable> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1646847497")) {
            ipChange.ipc$dispatch("1646847497", new Object[]{this, list, str});
            return;
        }
        this.a = Boolean.FALSE;
        if (list != null && list.size() > 0) {
            for (PerformTable performTable : list) {
                h(performTable, str);
            }
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073546184")) {
            ipChange.ipc$dispatch("-2073546184", new Object[]{this});
            return;
        }
        try {
            if (!b().getTable(PerformTable.class).j()) {
                b().save(new PerformTable());
                b().delete(PerformTable.class);
            }
            if (b().getTable(UserTicketTable.class).j()) {
                return;
            }
            b().save(new UserTicketTable());
            b().delete(UserTicketTable.class);
        } catch (DbException e) {
            e.printStackTrace();
            xn2.g(xn2.TICKLET_CREAT_TABLE_ERROR_CODE, xn2.TICKLET_CREAT_TABLE_ERROR_MSG, "创建表失败 " + e.getMessage());
        }
    }
}
