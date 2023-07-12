package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import cn.damai.tetris.component.drama.bean.FilterBean;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.component.drama.mvp.FilterContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cb2;
import tb.d23;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FilterPresenter extends BasePresenter<FilterModel, FilterView, BaseSection> implements FilterContract.Presenter<FilterModel, FilterView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public FilterPresenter(FilterView filterView, String str, ja jaVar) {
        super(filterView, str, jaVar);
    }

    @Override // cn.damai.tetris.component.drama.mvp.FilterContract.Presenter
    public void exposeSortType(View view, List<FilterMainBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128874700")) {
            ipChange.ipc$dispatch("-1128874700", new Object[]{this, view, list, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        String str = null;
        if (!cb2.d(list)) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(list.get(i2).name);
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
            str = sb.toString();
        }
        d23.b(f, str);
        userTrackExpose(view, "sorttype", f, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.FilterContract.Presenter
    public void exposeTagType(View view, List<FilterTagBean> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639131562")) {
            ipChange.ipc$dispatch("639131562", new Object[]{this, view, list, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        String str = null;
        if (!cb2.d(list)) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(list.get(i2).name);
                if (i2 != size - 1) {
                    sb.append(",");
                }
            }
            str = sb.toString();
        }
        d23.b(f, str);
        userTrackExpose(view, "type", f, false);
    }

    @Override // cn.damai.tetris.core.BasePresenter, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331113453")) {
            ipChange.ipc$dispatch("331113453", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public void init(FilterModel filterModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189181741")) {
            ipChange.ipc$dispatch("189181741", new Object[]{this, filterModel});
            return;
        }
        ISection section = getSection();
        if (section == null || !(section.getExtra() instanceof FilterBean)) {
            return;
        }
        getView().setData((FilterBean) section.getExtra(), 0);
    }
}
