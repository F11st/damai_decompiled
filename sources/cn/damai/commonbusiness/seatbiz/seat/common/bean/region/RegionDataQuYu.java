package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionDataQuYu implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    public String areaStatusGroup;
    public String compressMode;
    public List<String> floors;
    public boolean has3dvrImg;
    @Deprecated
    public int intervalTime;
    public long maitixPfId;
    public List<RegionDataQuYuInfo> quyu;
    @Deprecated
    public boolean rainbowSupport;
    public boolean rainbowSupportII;
    public String rainbowSvgImg;
    @Deprecated
    public int renderMode;
    public String resourcesCompressPath;
    public String resourcesCompressPathII;
    public String resourcesPath;
    public String seatEncodeUri;
    public String seatEncodingType;
    public RegionSeatExtInfo seatExtInfo;
    public String seatOssImg;
    public List<RegionDataSeatPrice> seatPriceList;
    public String seatStaticHash;
    public int seatStyle;
    public String seatSvgImg;
    public String seatimg;
    public SvgDecryptBean svgDecrypt;
    public List<RegionTopListModel> taopiaoList;
    public int venueScale;
    public int ver;
    public boolean sameRowNotify = false;
    public boolean seatStaticUseCompress = false;
    public boolean precheck = false;
    @Deprecated
    public boolean seatStatusUseCompress = false;

    public int getSeatStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1177173776")) {
            return ((Integer) ipChange.ipc$dispatch("1177173776", new Object[]{this})).intValue();
        }
        int i = this.seatStyle;
        if (i == 2) {
            return 1;
        }
        return i;
    }
}
