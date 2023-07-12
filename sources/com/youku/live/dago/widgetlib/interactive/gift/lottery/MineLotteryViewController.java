package com.youku.live.dago.widgetlib.interactive.gift.lottery;

import android.content.Context;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MineLotteryViewController implements MineLotteryView.OnAnimationStateListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup mContainer;
    private Context mContext;
    private MineLotteryView mineLotteryView;
    private boolean isRunning = false;
    private Queue<List<MineLotteryData>> mQueue = new LinkedList();

    public MineLotteryViewController(Context context, ViewGroup viewGroup) {
        this.mContainer = viewGroup;
        this.mContext = context;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
    public void onEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701426127")) {
            ipChange.ipc$dispatch("-701426127", new Object[]{this});
        } else {
            this.isRunning = false;
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116402294")) {
            ipChange.ipc$dispatch("-116402294", new Object[]{this});
        } else {
            this.isRunning = true;
        }
    }
}
