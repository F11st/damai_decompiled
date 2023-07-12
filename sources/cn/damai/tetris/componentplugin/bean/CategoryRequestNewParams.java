package cn.damai.tetris.componentplugin.bean;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CategoryRequestNewParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 912092;
    public String apiVersion;
    public String categoryId;
    public String channel;
    public String cityId;
    public String cityName;
    public int cityOption;
    public String comboDamaiCityId;
    public String currentCityId;
    public int dateType;
    public String dmChannel;
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String latitude;
    public String longitude;
    public String optionParam;
    public int pageIndex;
    public String pageSize;
    public List<String> projectIdList;
    public String returnItemOption;
    public String secondLevelSelection;
    public int sortType;
    public String startDate;
    public String subcategoryId;

    public CategoryRequestNewParams() {
        this.currentCityId = z20.c();
        this.cityId = z20.c();
        this.comboDamaiCityId = z20.c();
        this.channel = "10001";
        this.dmChannel = AppConfig.p();
        this.returnItemOption = "4";
        this.sortType = 3;
        this.pageIndex = 1;
        this.pageSize = "15";
        this.projectIdList = new ArrayList();
        this.apiVersion = "1.2";
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "989575822") ? (String) ipChange.ipc$dispatch("989575822", new Object[]{this}) : "category_drama_new";
    }

    public CategoryRequestNewParams(int i, int i2, String str, String str2, int i3, String str3, int i4) {
        double[] dMCoordinates;
        this.currentCityId = z20.c();
        this.cityId = z20.c();
        this.comboDamaiCityId = z20.c();
        this.channel = "10001";
        this.dmChannel = AppConfig.p();
        this.returnItemOption = "4";
        this.sortType = 3;
        this.pageIndex = 1;
        this.pageSize = "15";
        this.projectIdList = new ArrayList();
        this.apiVersion = "1.2";
        this.cityOption = i;
        this.dateType = i2;
        this.startDate = str;
        this.endDate = str2;
        this.sortType = i3;
        this.pageIndex = i4;
        this.groupId = str3;
        if (i3 != 4 || (dMCoordinates = Util.getDMCoordinates()) == null) {
            return;
        }
        this.longitude = String.valueOf(dMCoordinates[0]);
        this.latitude = String.valueOf(dMCoordinates[1]);
    }
}
