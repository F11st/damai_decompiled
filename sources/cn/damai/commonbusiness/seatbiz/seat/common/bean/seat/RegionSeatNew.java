package cn.damai.commonbusiness.seatbiz.seat.common.bean.seat;

import android.graphics.Path;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model.orig.OrigRegion;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionSeatNew {
    public Map<String, List<Path>> packageTaoPiaoPoints;
    public LinkedHashMap<String, OrigRegion> regionChairList;
    public List<SeatNew> seatNewList;
    public ArrayMap<String, List<SeatNew>> seatNewMap;
    public int total;
    public boolean useCompress;
}
