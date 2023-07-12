package com.youku.live.dago.widgetlib.ailproom.adapter.likeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.favor.FavorLayout;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import tb.nh0;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPLikeViewYoukuAdapter extends FrameLayout implements AILPLikeViewProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private int DEFAULT_COUNT;
    private FavorLayout mFavorLayout;
    private int mLikeTotalCount;
    private View view;

    public AILPLikeViewYoukuAdapter(Context context) {
        super(context);
        this.DEFAULT_COUNT = 3;
        this.mLikeTotalCount = 0;
        initView(context);
    }

    public static Bitmap getBitmap(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301162646")) {
            return (Bitmap) ipChange.ipc$dispatch("1301162646", new Object[]{str});
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            return BitmapFactory.decodeStream(openConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "550985350")) {
            ipChange.ipc$dispatch("550985350", new Object[]{this, context});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ailp_like_view, this);
        this.view = inflate;
        FavorLayout favorLayout = (FavorLayout) inflate.findViewById(R.id.ailp_like_favor);
        this.mFavorLayout = favorLayout;
        favorLayout.setScaleFactor(1.5d);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635897607")) {
            ipChange.ipc$dispatch("-635897607", new Object[]{this});
            return;
        }
        FavorLayout favorLayout = this.mFavorLayout;
        if (favorLayout != null) {
            favorLayout.destroy();
            this.mFavorLayout = null;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-845377414") ? (View) ipChange.ipc$dispatch("-845377414", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol
    public void setFlow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-826679584")) {
            ipChange.ipc$dispatch("-826679584", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.mLikeTotalCount;
        if (i > i2) {
            this.mLikeTotalCount = i;
            this.mFavorLayout.addFavor(i - i2);
            return;
        }
        this.mLikeTotalCount = i;
    }

    public void setImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907033952")) {
            ipChange.ipc$dispatch("-1907033952", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            ur1.o().s(str).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.AILPLikeViewYoukuAdapter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(ui2 ui2Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1608269968")) {
                        return ((Boolean) ipChange2.ipc$dispatch("1608269968", new Object[]{this, ui2Var})).booleanValue();
                    }
                    if (ui2Var.f() != null && !ui2Var.i()) {
                        BitmapDrawable f = ui2Var.f();
                        if (AILPLikeViewYoukuAdapter.this.mFavorLayout != null && f != null) {
                            AILPLikeViewYoukuAdapter.this.mFavorLayout.setDrawables(AILPLikeViewYoukuAdapter.this.split(f.getBitmap(), AILPLikeViewYoukuAdapter.this.DEFAULT_COUNT));
                        }
                    }
                    return true;
                }
            }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.likeview.AILPLikeViewYoukuAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.phenix.intf.event.IPhenixListener
                public boolean onHappen(nh0 nh0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-824525845")) {
                        return ((Boolean) ipChange2.ipc$dispatch("-824525845", new Object[]{this, nh0Var})).booleanValue();
                    }
                    return false;
                }
            }).n();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPLikeViewProtocol
    public void setlikeViewSrc(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641251060")) {
            ipChange.ipc$dispatch("641251060", new Object[]{this, map});
            return;
        }
        if (map.containsKey("width")) {
            this.DEFAULT_COUNT = ((Integer) map.get("width")).intValue();
        }
        if (map.containsKey("url")) {
            setImg((String) map.get("url"));
        }
    }

    public ArrayList<Drawable> split(Bitmap bitmap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974006664")) {
            return (ArrayList) ipChange.ipc$dispatch("1974006664", new Object[]{this, bitmap, Integer.valueOf(i)});
        }
        ArrayList<Drawable> arrayList = new ArrayList<>();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width / i;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new BitmapDrawable(Bitmap.createBitmap(bitmap, i3 * i, 0, i, height)));
        }
        return arrayList;
    }

    public AILPLikeViewYoukuAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_COUNT = 3;
        this.mLikeTotalCount = 0;
        initView(context);
    }

    public AILPLikeViewYoukuAdapter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFAULT_COUNT = 3;
        this.mLikeTotalCount = 0;
        initView(context);
    }
}
