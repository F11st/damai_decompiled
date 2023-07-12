package com.youku.live.dago.widgetlib.interactive.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.tx0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftUTUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int CLICK_EVENT = 2101;
    public static int EXPOSE_EVENT = 2201;
    public static String PAGENAME = "page_youkulive";

    public static void allSendCount(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312497920")) {
            ipChange.ipc$dispatch("-312497920", new Object[]{map});
        } else if (map != null) {
            ((ILog) Dsl.getService(ILog.class)).i("UT_REPORT", " all send count " + map.toString());
            map.putAll(GiftDataManager.getInstance().getSpm());
            String valueOf = String.valueOf(map.get(tx0.VALUE_MODEL_DEFAULT));
            map.put("spm", valueOf + ".liwu.lianji");
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, 19999, "liwu-lianji", "", "", map);
        }
    }

    public static void comboClick(String str, GiftInfoBean giftInfoBean, GiftTargetInfoBean giftTargetInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744033504")) {
            ipChange.ipc$dispatch("-1744033504", new Object[]{str, giftInfoBean, giftTargetInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board COMBO click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".liwu.lianji");
        hashMap.put("liwuzuid", str);
        if (giftInfoBean != null) {
            hashMap.put("title", giftInfoBean.name);
            hashMap.put("liwuid", giftInfoBean.id);
        } else {
            hashMap.put("title", "");
            hashMap.put("liwuid", "");
        }
        if (giftTargetInfoBean != null) {
            hashMap.put("mubiaotitle", giftTargetInfoBean.name);
            hashMap.put("mubiaoid", giftTargetInfoBean.id);
        } else {
            hashMap.put("mubiaotitle", "");
            hashMap.put("mubiaoid", "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "liwu-lianji", hashMap);
    }

    public static void comboClickMultiTarget(String str, GiftInfoBean giftInfoBean, List<GiftTargetInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513074037")) {
            ipChange.ipc$dispatch("1513074037", new Object[]{str, giftInfoBean, list});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board COMBO click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".liwu.lianji");
        hashMap.put("liwuzuid", str);
        if (giftInfoBean != null) {
            hashMap.put("title", giftInfoBean.name);
            hashMap.put("liwuid", giftInfoBean.id);
        } else {
            hashMap.put("title", "");
            hashMap.put("liwuid", "");
        }
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                GiftTargetInfoBean giftTargetInfoBean = list.get(i);
                if (giftTargetInfoBean != null) {
                    sb.append(giftTargetInfoBean.name);
                    if (i != list.size() - 1) {
                        sb.append(",");
                    }
                    sb2.append(giftTargetInfoBean.id);
                    if (i != list.size() - 1) {
                        sb2.append(",");
                    }
                }
            }
            hashMap.put("mubiaotitle", sb.toString());
            hashMap.put("mubiaoid", sb2.toString());
        } else {
            hashMap.put("mubiaotitle", "");
            hashMap.put("mubiaoid", "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "liwu-lianji", hashMap);
    }

    public static void comboExpose(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613861624")) {
            ipChange.ipc$dispatch("613861624", new Object[]{giftInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board COMBO click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".liwu.lianji");
        if (giftInfoBean != null) {
            hashMap.put("title", giftInfoBean.name);
            hashMap.put("liwuid", giftInfoBean.id);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "liwu-lianji", "", "", hashMap);
    }

    public static void doTaskClick(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169499293")) {
            ipChange.ipc$dispatch("1169499293", new Object[]{giftPropBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "doTaskClick click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String str = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT)) + ".renwu1.liebiao1";
        if (giftPropBean != null) {
            hashMap.put("id", giftPropBean.id);
        } else {
            hashMap.put("id", "");
            hashMap.put(TLogConstant.PERSIST_TASK_ID, "");
        }
        hashMap.put("spm", str);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "renwu1.liebiao1", hashMap);
    }

    public static void giftBoardItemClick(String str, String str2, String str3, String str4, String str5, GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307698583")) {
            ipChange.ipc$dispatch("-307698583", new Object[]{str, str2, str3, str4, str5, giftInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board page giftBoardItemClick");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.board");
        hashMap.put("tab_name", str2);
        hashMap.put("tab_id", str);
        hashMap.put("tab_num", str3);
        hashMap.put("count_num", str5);
        hashMap.put("page_num", str4);
        if (giftInfoBean != null) {
            hashMap.put("gift_name", giftInfoBean.name);
            hashMap.put("gift_id", giftInfoBean.id);
            hashMap.put("gift_price", giftInfoBean.coins + "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "gift_board", hashMap);
    }

    public static void giftBoardPageChange(String str, String str2, int i, List<GiftInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996904362")) {
            ipChange.ipc$dispatch("-996904362", new Object[]{str, str2, Integer.valueOf(i), list});
        } else if (list != null) {
            ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board page change expose");
            HashMap hashMap = new HashMap();
            hashMap.putAll(GiftDataManager.getInstance().getSpm());
            String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
            hashMap.put("spm", valueOf + ".gift.page");
            hashMap.put("tab", str);
            hashMap.put("tab_name", str2);
            hashMap.put("tab_num", i + "");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                GiftInfoBean giftInfoBean = list.get(i2);
                if (giftInfoBean != null && !giftInfoBean.hasExposed) {
                    giftInfoBean.hasExposed = true;
                    if (i2 != list.size() - 1) {
                        sb.append(giftInfoBean.id + ",");
                        sb2.append(giftInfoBean.name + ",");
                        sb3.append(giftInfoBean.coins + ",");
                    } else {
                        sb.append(giftInfoBean.id);
                        sb2.append(giftInfoBean.name);
                        sb3.append(giftInfoBean.coins);
                    }
                }
            }
            String sb4 = sb2.toString();
            String sb5 = sb.toString();
            String sb6 = sb3.toString();
            if (sb5.length() == 0 || sb4.length() == 0 || sb6.length() == 0) {
                return;
            }
            hashMap.put("gift_name", sb2.toString());
            hashMap.put("gift_id", sb.toString());
            hashMap.put("gift_price", sb3.toString());
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "gift_page", "", "", hashMap);
        }
    }

    public static void giftBoardTabClick(String str, String str2, int i, List<GiftInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611345622")) {
            ipChange.ipc$dispatch("-1611345622", new Object[]{str, str2, Integer.valueOf(i), list});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board tab click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.tab");
        hashMap.put("tab", str);
        hashMap.put("tab_name", str2);
        hashMap.put("tab_num", i + "");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                GiftInfoBean giftInfoBean = list.get(i2);
                if (giftInfoBean != null) {
                    if (i2 != list.size() - 1) {
                        sb.append(giftInfoBean.id + ",");
                        sb2.append(giftInfoBean.name + ",");
                    } else {
                        sb.append(giftInfoBean.id);
                        sb2.append(giftInfoBean.name);
                    }
                }
            }
        }
        hashMap.put("gift_name", sb2.toString());
        hashMap.put("gift_id", sb.toString());
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "gift_tab", hashMap);
    }

    public static void propItemClick(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-180989181")) {
            ipChange.ipc$dispatch("-180989181", new Object[]{giftPropBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board page giftBoardItemClick");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".daoju.mianban");
        if (giftPropBean != null) {
            hashMap.put(TLogEventConst.PARAM_UPLOAD_STAGE, giftPropBean.id);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "daoju-mianban", hashMap);
    }

    public static void propPageChange(List<GiftPropBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549965126")) {
            ipChange.ipc$dispatch("-549965126", new Object[]{list});
        } else if (list != null) {
            ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board prop page change expose");
            HashMap hashMap = new HashMap();
            hashMap.putAll(GiftDataManager.getInstance().getSpm());
            String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
            hashMap.put("spm", valueOf + ".daoju.mianban");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                GiftPropBean giftPropBean = list.get(i);
                if (giftPropBean != null && !giftPropBean.hasExposed) {
                    giftPropBean.hasExposed = true;
                    if (i != list.size() - 1) {
                        sb.append(giftPropBean.id + ",");
                    } else {
                        sb.append(giftPropBean.id);
                    }
                }
            }
            if (sb.toString().length() == 0) {
                return;
            }
            hashMap.put("list", sb.toString());
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "daoju-mianban", "", "", hashMap);
        }
    }

    public static void propTabClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790994997")) {
            ipChange.ipc$dispatch("790994997", new Object[0]);
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "propTabClick click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.bagentrybutton");
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "gift_bagentrybutton", hashMap);
    }

    public static void rechargeClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588030594")) {
            ipChange.ipc$dispatch("-1588030594", new Object[0]);
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board RECHARGE click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.giftpanelcharge");
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "gift_giftpanelcharge", hashMap);
    }

    public static void sendClick(String str, GiftInfoBean giftInfoBean, GiftTargetInfoBean giftTargetInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186964590")) {
            ipChange.ipc$dispatch("186964590", new Object[]{str, giftInfoBean, giftTargetInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board SEND click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".liwu.zengsong");
        hashMap.put("liwuzuid", str);
        if (giftInfoBean != null) {
            hashMap.put("title", giftInfoBean.name);
            hashMap.put("liwuid", giftInfoBean.id);
        } else {
            hashMap.put("title", "");
            hashMap.put("liwuid", "");
        }
        if (giftTargetInfoBean != null) {
            hashMap.put("mubiaotitle", giftTargetInfoBean.name);
            hashMap.put("mubiaoid", giftTargetInfoBean.id);
        } else {
            hashMap.put("mubiaotitle", "");
            hashMap.put("mubiaoid", "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "liwu-zengsong", hashMap);
    }

    public static void sendPropClick(GiftPropBean giftPropBean, GiftTargetInfoBean giftTargetInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "20941650")) {
            ipChange.ipc$dispatch("20941650", new Object[]{giftPropBean, giftTargetInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board PROP SEND click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".daoju.song");
        if (giftPropBean != null) {
            hashMap.put("list", giftPropBean.id);
        } else {
            hashMap.put("list", "");
        }
        if (giftTargetInfoBean != null) {
            hashMap.put("mubiaotitle", giftTargetInfoBean.name);
            hashMap.put("mubiaoid", giftTargetInfoBean.id);
        } else {
            hashMap.put("mubiaotitle", "");
            hashMap.put("mubiaoid", "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "daoju-song", hashMap);
    }

    public static void sendPropClickMulti(GiftPropBean giftPropBean, List<GiftTargetInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1959713290")) {
            ipChange.ipc$dispatch("-1959713290", new Object[]{giftPropBean, list});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "board PROP SEND click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".daoju.song");
        if (giftPropBean != null) {
            hashMap.put("list", giftPropBean.id);
        } else {
            hashMap.put("list", "");
        }
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                GiftTargetInfoBean giftTargetInfoBean = list.get(i);
                if (giftTargetInfoBean != null) {
                    sb.append(giftTargetInfoBean.name);
                    if (i != list.size() - 1) {
                        sb.append(",");
                    }
                    sb2.append(giftTargetInfoBean.id);
                    if (i != list.size() - 1) {
                        sb2.append(",");
                    }
                }
            }
            hashMap.put("mubiaotitle", sb.toString());
            hashMap.put("mubiaoid", sb2.toString());
        } else {
            hashMap.put("mubiaotitle", "");
            hashMap.put("mubiaoid", "");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "daoju-song", hashMap);
    }

    public static void targetClick(GiftTargetInfoBean giftTargetInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751233662")) {
            ipChange.ipc$dispatch("-1751233662", new Object[]{giftTargetInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "target click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.mubiao");
        if (giftTargetInfoBean != null) {
            hashMap.put("mubiaotitle", giftTargetInfoBean.name);
            hashMap.put("mubiaoid", giftTargetInfoBean.id);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "gift_mubiao", hashMap);
    }

    public static void targetExpose(GiftTargetInfoBean giftTargetInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340733136")) {
            ipChange.ipc$dispatch("-1340733136", new Object[]{giftTargetInfoBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "target Expose");
        if (giftTargetInfoBean.hasExposed) {
            return;
        }
        giftTargetInfoBean.hasExposed = true;
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".gift.mubiao");
        hashMap.put("mubiaotitle", giftTargetInfoBean.name);
        hashMap.put("mubiaoid", giftTargetInfoBean.id);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGENAME, EXPOSE_EVENT, "gift_mubiao", "", "", hashMap);
    }

    public static void taskBoardClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69104924")) {
            ipChange.ipc$dispatch("-69104924", new Object[0]);
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("UT_REPORT", "propBoardClick click");
        HashMap hashMap = new HashMap();
        hashMap.putAll(GiftDataManager.getInstance().getSpm());
        String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
        hashMap.put("spm", valueOf + ".renwu.button");
        ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(PAGENAME, "renwu-button", hashMap);
    }
}
