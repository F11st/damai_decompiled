package cn.damai.tetris.component.star.content.base.network;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ContentCommonParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FROM_CHANXIAO = 1;
    public static final int FROM_DAYU = 2;
    private static final int MAX_PAGE_SIZE = 15;
    public String artistId;
    public String pageNum;
    public int pageSize;
    public String type;

    public ContentCommonParams(String str, String str2) {
        this(str, str2, "1", 15);
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "76749303") ? (String) ipChange.ipc$dispatch("76749303", new Object[]{this}) : "dm_artist_main_official_content_list";
    }

    public ContentCommonParams(String str, String str2, String str3) {
        this(str, str2, str3, 15);
    }

    public ContentCommonParams(String str, String str2, String str3, int i) {
        this.pageNum = "1";
        this.pageSize = 15;
        this.artistId = str;
        this.type = str2;
        this.pageNum = str3;
        this.pageSize = i;
    }
}
