package cn.damai.user.star.second;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarSecondParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_PAGE_SIZE = 15;
    public String artistId;
    public String pageNum;
    public int pageSize;
    public String type;

    public StarSecondParams(String str, String str2) {
        this(str, str2, "1", 15);
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "154574045") ? (String) ipChange.ipc$dispatch("154574045", new Object[]{this}) : "dm_artist_main_official_content_list";
    }

    public StarSecondParams(String str, String str2, String str3) {
        this(str, str2, str3, 15);
    }

    public StarSecondParams(String str, String str2, String str3, int i) {
        this.pageNum = "1";
        this.pageSize = 15;
        this.artistId = str;
        this.type = str2;
        this.pageNum = str3;
        this.pageSize = i;
    }
}
