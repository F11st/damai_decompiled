package tb;

import android.text.TextUtils;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class yk {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_COMMENT_EMPTY = 4;
    public static final int TYPE_COMMENT_MAIN = 0;
    public static final int TYPE_COMMENT_MAIN_COMMENT = 2;
    public static final int TYPE_COMMENT_SUBCOMMENT = 3;
    public static final int TYPE_COMMENT_TITLE = 1;
    public static final int TYPE_VCOMMENT_MAIN = 5;

    public static List<al> a(CommentsResultBean commentsResultBean) {
        List<CommentsItemBean> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435743703")) {
            return (List) ipChange.ipc$dispatch("-435743703", new Object[]{commentsResultBean});
        }
        ArrayList arrayList = new ArrayList();
        if (commentsResultBean != null && (data = commentsResultBean.getData()) != null && data.size() > 0) {
            b(data, arrayList);
        }
        return arrayList;
    }

    private static void b(List<CommentsItemBean> list, List<al> list2) {
        al alVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-248509504")) {
            ipChange.ipc$dispatch("-248509504", new Object[]{list, list2});
            return;
        }
        for (CommentsItemBean commentsItemBean : list) {
            if (!TextUtils.isEmpty(commentsItemBean.getHasAppend()) && "true".equals(commentsItemBean.getHasAppend())) {
                alVar = new al(3);
                alVar.A(2);
            } else {
                alVar = new al(2);
                alVar.A(1);
            }
            alVar.z(false);
            alVar.q(commentsItemBean);
            list2.add(alVar);
        }
    }

    public static List<al> c(CommentsResultBean commentsResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486330902")) {
            return (List) ipChange.ipc$dispatch("-486330902", new Object[]{commentsResultBean});
        }
        ArrayList arrayList = new ArrayList();
        if (commentsResultBean != null) {
            List<CommentsItemBean> data = commentsResultBean.getData();
            if (data != null && data.size() > 0) {
                al alVar = new al(1);
                alVar.r("大家说(" + commentsResultBean.getTotal() + jn1.BRACKET_END_STR);
                arrayList.add(alVar);
                b(data, arrayList);
            } else {
                arrayList.add(new al(4));
            }
        }
        return arrayList;
    }
}
