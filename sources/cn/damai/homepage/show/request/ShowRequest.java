package cn.damai.homepage.show.request;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ShowRequest extends TetrisParams implements Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4326435736917912092L;
    public String categoryId;
    public String cityName;
    public int cityOption;
    public String dmChannel;
    public String endDate;
    public String latitude;
    public String longitude;
    public String startDate;
    public String subcategoryId;
    public String currentCityId = z20.c();
    public String cityId = z20.c();
    public String channel = "10001";
    public String returnItemOption = "4";
    public int dateType = 0;
    public int sortType = 3;
    public int pageIndex = 1;
    public String pageSize = "15";
    public List<String> projectIdList = new ArrayList();
    public String apiVersion = "1.2";

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1105415030") ? (String) ipChange.ipc$dispatch("-1105415030", new Object[]{this}) : "category";
    }
}
