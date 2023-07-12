package com.youku.live.dago.widgetlib.interactive.gift.view.Particle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ParticleField extends View {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<C7945Particle> mParticles;

    public ParticleField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856016039")) {
            ipChange.ipc$dispatch("1856016039", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        synchronized (this.mParticles) {
            for (int i = 0; i < this.mParticles.size(); i++) {
                this.mParticles.get(i).draw(canvas);
            }
        }
    }

    public void setParticles(ArrayList<C7945Particle> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597921900")) {
            ipChange.ipc$dispatch("-1597921900", new Object[]{this, arrayList});
        } else {
            this.mParticles = arrayList;
        }
    }

    public ParticleField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParticleField(Context context) {
        super(context);
    }
}
