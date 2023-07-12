package cn.damai.tetris.core.mtop;

import android.os.SystemClock;
import cn.damai.tetris.core.BaseLayer;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BaseResponse implements Serializable {
    public String args;
    public String comboDegrade;
    public GlobalConfig globalConfig;
    public boolean isShowJuli;
    public ArrayList<BaseLayer> layers;
    public long serverTime;
    public long requestFinishTime = SystemClock.elapsedRealtime();
    public int nearByCityListSize = 0;
}
