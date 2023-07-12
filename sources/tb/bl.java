package tb;

import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class bl {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(CommentsItemBean commentsItemBean, List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1584201078")) {
            return ((Integer) ipChange.ipc$dispatch("1584201078", new Object[]{commentsItemBean, list})).intValue();
        }
        if (commentsItemBean != null && list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (commentsItemBean.getCommentId().equals(list.get(i).getCommentId())) {
                    return i;
                }
            }
        }
        return 0;
    }
}
