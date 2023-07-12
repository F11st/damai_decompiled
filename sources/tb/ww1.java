package tb;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTour;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.adapter.ProjectTourAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ww1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;

    public ww1(Context context, View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            this.a = recyclerView;
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    public void a(Context context, List<ProjectTour> list, long j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "93157801")) {
            ipChange.ipc$dispatch("93157801", new Object[]{this, context, list, Long.valueOf(j)});
            return;
        }
        int e = wh2.e(list);
        if (e <= 1) {
            return;
        }
        this.a.setAdapter(new ProjectTourAdapter(context, list, j, e));
        if (e > 3) {
            int i2 = 0;
            while (true) {
                if (i2 >= e) {
                    break;
                } else if (list.get(i2).isCurrentCityProject(String.valueOf(j))) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i > 1) {
                this.a.scrollToPosition(i);
            }
        }
    }
}
