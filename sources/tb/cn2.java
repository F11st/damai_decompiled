package tb;

import android.text.TextUtils;
import android.util.Base64;
import cn.damai.common.db.DbManager;
import cn.damai.common.db.ex.DbException;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.utils.C2088a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cn2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static cn2 b;
    public Boolean a = Boolean.FALSE;

    private cn2() {
    }

    public static void b(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593353126")) {
            ipChange.ipc$dispatch("593353126", new Object[]{userTicketTable});
        } else if (userTicketTable != null) {
            try {
                if ("1".equals(userTicketTable.getVoucherType()) && !xh2.c(userTicketTable.getVerifyCode())) {
                    userTicketTable.setVerifyCode(new String(Base64.encode(C2088a.b(userTicketTable.getVerifyCode().getBytes(), fu1.c(), Base64.decode(C2088a.d(mu0.a()), 2)), 2)));
                }
                userTicketTable.setOrderby(qn1.a(userTicketTable));
                userTicketTable.setUserCode(fu1.c());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized DbManager d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121300724")) {
            return (DbManager) ipChange.ipc$dispatch("-1121300724", new Object[]{this});
        }
        return e40.e().c();
    }

    public static cn2 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1755605765")) {
            return (cn2) ipChange.ipc$dispatch("-1755605765", new Object[0]);
        }
        if (b == null) {
            synchronized (cn2.class) {
                if (b == null) {
                    b = new cn2();
                }
            }
        }
        return b;
    }

    public synchronized void a(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670769617")) {
            ipChange.ipc$dispatch("670769617", new Object[]{this, list});
            return;
        }
        if (list != null && list.size() > 0) {
            for (UserTicketTable userTicketTable : list) {
                try {
                    d().delete(UserTicketTable.class, q13.c(TicketDetailExtFragment.PERFORM_ID, "=", userTicketTable.getPerformId()));
                } catch (Exception e) {
                    e.printStackTrace();
                    xn2.g(xn2.TICKLET_DB_TICKET_DELETE_HISTORY_ERROR_CODE, xn2.TICKLET_DB_TICKET_DELETE_HISTORY_ERROR_MSG, e.getMessage());
                }
            }
        }
    }

    public UserTicketTable c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-120807018")) {
            return (UserTicketTable) ipChange.ipc$dispatch("-120807018", new Object[]{this, str});
        }
        try {
            return (UserTicketTable) d().selector(UserTicketTable.class).o(TicketDetailExtFragment.PERFORM_ID, "=", str).a("userCode", "=", fu1.c()).a("voucherState", "=", "1").m("orderby").d();
        } catch (DbException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserTicketTable> e(String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969238544")) {
            return (List) ipChange.ipc$dispatch("1969238544", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        try {
            return d().selector(UserTicketTable.class).o(TicketDetailExtFragment.PERFORM_ID, "=", str).a("userCode", "=", fu1.c()).a("voucherState", jn1.NOT_EQUAL2, "106").k(i2).l((i - 1) * i2).m("orderby").m("exchangeCode").m("voucherCertNo").c();
        } catch (DbException e) {
            e.printStackTrace();
            xn2.g(xn2.TICKLET_DB_DETAIL_TICKETS_INFO_ERROR_CODE, xn2.TICKLET_DB_DETAIL_TICKETS_INFO_ERROR_MSG, e.getMessage());
            return new ArrayList();
        }
    }

    public synchronized Boolean g(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404068321")) {
            return (Boolean) ipChange.ipc$dispatch("-404068321", new Object[]{this, userTicketTable});
        }
        try {
            if ("1".equals(userTicketTable.getVoucherType()) && !xh2.c(userTicketTable.getVerifyCode())) {
                userTicketTable.setVerifyCode(new String(Base64.encode(C2088a.b(userTicketTable.getVerifyCode().getBytes(), fu1.c(), Base64.decode(C2088a.d(mu0.a()), 2)), 2)));
            }
            userTicketTable.setOrderby(qn1.a(userTicketTable));
            userTicketTable.setUserCode(fu1.c());
            userTicketTable.setSubTicketListLocal(j61.b(userTicketTable.getSubTicketList()));
            userTicketTable.setOpTypeListLocal(j61.b(userTicketTable.getOpTypeList()));
            if (userTicketTable.getExtAttr() != null) {
                userTicketTable.setLocalExtAttr(m61.e(userTicketTable.getExtAttr()));
            }
            if (userTicketTable.getStandPortal() != null) {
                userTicketTable.setLocalStandPortal(m61.e(userTicketTable.getStandPortal()));
            }
            UserTicketTable userTicketTable2 = (UserTicketTable) d().selector(UserTicketTable.class).o("voucherUniqueKey", "=", userTicketTable.getVoucherUniqueKey()).d();
            if (userTicketTable2 != null) {
                userTicketTable.setId(userTicketTable2.getId());
                d().update(userTicketTable, new String[0]);
            } else {
                d().save(userTicketTable);
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            if (!this.a.booleanValue()) {
                this.a = Boolean.TRUE;
                xn2.g(xn2.TICKLET_DB_TICKET_SAVE_UPDATE_ERROR_CODE, xn2.TICKLET_DB_TICKET_SAVE_UPDATE_INFO_ERROR_MSG, e.getMessage());
            }
            return Boolean.FALSE;
        }
    }

    public synchronized void h(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693793772")) {
            ipChange.ipc$dispatch("1693793772", new Object[]{this, list});
            return;
        }
        this.a = Boolean.FALSE;
        if (list != null && list.size() > 0) {
            for (UserTicketTable userTicketTable : list) {
                g(userTicketTable);
            }
        }
    }

    public synchronized void i(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-450027753")) {
            ipChange.ipc$dispatch("-450027753", new Object[]{this, userTicketTable});
            return;
        }
        try {
            UserTicketTable userTicketTable2 = (UserTicketTable) d().selector(UserTicketTable.class).o("voucherUniqueKey", "=", userTicketTable.getVoucherUniqueKey()).d();
            if (userTicketTable2 != null) {
                userTicketTable2.setVoucherState(userTicketTable.getVoucherState());
                userTicketTable2.setCheckCountDown(userTicketTable.getCheckCountDown());
                userTicketTable2.setCheckDirection(userTicketTable.getCheckDirection());
                if (!TextUtils.isEmpty(userTicketTable.getVerifyCode())) {
                    userTicketTable2.setVerifyCode(userTicketTable.getVerifyCode());
                }
                if (!xh2.c(userTicketTable.getPerformId())) {
                    userTicketTable2.setPerformId(userTicketTable.getPerformId());
                }
                if (!xh2.c(userTicketTable.getProductSystemId())) {
                    userTicketTable2.setProductSystemId(userTicketTable.getProductSystemId());
                }
                if (!xh2.c(userTicketTable.getTips())) {
                    userTicketTable2.setTips(userTicketTable.getTips());
                }
                if (wh2.e(userTicketTable.getSubTicketList()) > 0) {
                    userTicketTable2.setSubTicketListLocal(j61.b(userTicketTable.getSubTicketList()));
                }
                d().update(userTicketTable2, new String[0]);
            }
        } catch (DbException e) {
            e.printStackTrace();
            xn2.e(xn2.TICKLET_DB_VERSION_ACCS_ERROR_CODE, xn2.TICKLET_DB_VERSION_ACCS_ERROR_MSG + userTicketTable.voucherUniqueKey, e.getMessage());
        }
    }
}
