package com.youku.live.dago.widgetlib.doodle.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.HumanPainter;
import com.youku.live.dago.widgetlib.doodle.RobotPainter;
import com.youku.live.dago.widgetlib.doodle.SketchBoard;
import com.youku.live.dago.widgetlib.doodle.SplashItemParser;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LaifengSplashScheduler implements SplashScheduler<String, String> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private HumanPainter mHumanPainter;
    private SplashItemParser<String, String> mParser;
    private RobotPainter mRobotPainter;
    private SketchBoard mSketchBoard;
    private int mDrawLimit = Integer.MAX_VALUE;
    private int mDrawCount = 0;
    private boolean mEnableTouch = true;
    private Map<Integer, SplashScheduler.IconItem> mIconMaps = new HashMap();
    private List<SplashScheduler.OnSplashUpdateListener> mOnSplashUpdateListeners = new ArrayList();

    public LaifengSplashScheduler(Context context) {
        this.mContext = context;
        SoftwareSketchBoard softwareSketchBoard = new SoftwareSketchBoard(this.mContext);
        this.mSketchBoard = softwareSketchBoard;
        this.mRobotPainter = new RobotPainter(softwareSketchBoard);
        HumanPainter humanPainter = new HumanPainter(this.mContext);
        this.mHumanPainter = humanPainter;
        humanPainter.setSketchBoard(this.mSketchBoard);
        this.mHumanPainter.addView(softwareSketchBoard, new ViewGroup.LayoutParams(-1, -1));
        this.mSketchBoard.setOnDrawListener(new SketchBoard.OnDrawListener() { // from class: com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard.OnDrawListener
            public void onDraw(int i, int i2, int i3, int i4) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1312455031")) {
                    ipChange.ipc$dispatch("-1312455031", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                    return;
                }
                LaifengSplashScheduler.this.mDrawCount = i4;
                if (LaifengSplashScheduler.this.mEnableTouch) {
                    for (SplashScheduler.OnSplashUpdateListener onSplashUpdateListener : LaifengSplashScheduler.this.mOnSplashUpdateListeners) {
                        onSplashUpdateListener.onSplashUpdate(i2, i3, i, i4);
                    }
                }
            }
        });
        this.mRobotPainter.setOnPaintListener(new RobotPainter.OnPaintListener() { // from class: com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.doodle.RobotPainter.OnPaintListener
            public void onPaintingEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1677430117")) {
                    ipChange.ipc$dispatch("1677430117", new Object[]{this});
                    return;
                }
                for (SplashScheduler.OnSplashUpdateListener onSplashUpdateListener : LaifengSplashScheduler.this.mOnSplashUpdateListeners) {
                    onSplashUpdateListener.onPaintingEnd();
                }
            }

            @Override // com.youku.live.dago.widgetlib.doodle.RobotPainter.OnPaintListener
            public void onPaintingStart() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1041846718")) {
                    ipChange.ipc$dispatch("1041846718", new Object[]{this});
                    return;
                }
                for (SplashScheduler.OnSplashUpdateListener onSplashUpdateListener : LaifengSplashScheduler.this.mOnSplashUpdateListeners) {
                    onSplashUpdateListener.onPaintingStart();
                }
            }
        });
        this.mHumanPainter.setOnTouchListener(new View.OnTouchListener() { // from class: com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1314523537")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1314523537", new Object[]{this, view, motionEvent})).booleanValue();
                }
                if (motionEvent.getAction() == 1 && LaifengSplashScheduler.this.mDrawCount >= LaifengSplashScheduler.this.mDrawLimit) {
                    Context context2 = view.getContext();
                    Toast.makeText(context2, "做多送" + LaifengSplashScheduler.this.mDrawLimit + "个涂鸦礼物", 1).show();
                }
                return false;
            }
        });
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void addOnSplashUpdateListener(@NonNull SplashScheduler.OnSplashUpdateListener onSplashUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790746906")) {
            ipChange.ipc$dispatch("790746906", new Object[]{this, onSplashUpdateListener});
        } else {
            this.mOnSplashUpdateListeners.add(onSplashUpdateListener);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void enableTouch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084046363")) {
            ipChange.ipc$dispatch("-2084046363", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mEnableTouch = z;
        this.mSketchBoard.clear();
        this.mHumanPainter.setEnabled(z);
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    @NonNull
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1854182745") ? (View) ipChange.ipc$dispatch("1854182745", new Object[]{this}) : this.mHumanPainter;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    @Nullable
    public SplashScheduler.IconItem getIconItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38877666")) {
            return (SplashScheduler.IconItem) ipChange.ipc$dispatch("38877666", new Object[]{this, Integer.valueOf(i)});
        }
        if (this.mIconMaps.containsKey(Integer.valueOf(i))) {
            return this.mIconMaps.get(Integer.valueOf(i));
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    @NonNull
    public SketchBoard getSketchBoard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1558849757") ? (SketchBoard) ipChange.ipc$dispatch("1558849757", new Object[]{this}) : this.mSketchBoard;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public boolean isTouchEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2131886743") ? ((Boolean) ipChange.ipc$dispatch("2131886743", new Object[]{this})).booleanValue() : this.mEnableTouch;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void removeOnSplashUpdateListener(@NonNull SplashScheduler.OnSplashUpdateListener onSplashUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518739625")) {
            ipChange.ipc$dispatch("1518739625", new Object[]{this, onSplashUpdateListener});
        } else {
            this.mOnSplashUpdateListeners.remove(onSplashUpdateListener);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void selectIcon(int i) {
        SplashScheduler.IconItem iconItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733806183")) {
            ipChange.ipc$dispatch("-1733806183", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mIconMaps.containsKey(Integer.valueOf(i)) && (iconItem = this.mIconMaps.get(Integer.valueOf(i))) != null) {
            this.mHumanPainter.setDrawable(i, iconItem.icon);
        } else {
            throw new RuntimeException("selectIcon call with invalid icon identity:" + i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void setDrawLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "639237401")) {
            ipChange.ipc$dispatch("639237401", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDrawLimit = i;
        this.mSketchBoard.setDrawLimit(i);
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void setIcons(@NonNull SplashScheduler.IconItem... iconItemArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "214429834")) {
            ipChange.ipc$dispatch("214429834", new Object[]{this, iconItemArr});
            return;
        }
        this.mIconMaps.clear();
        for (SplashScheduler.IconItem iconItem : iconItemArr) {
            if (Rect.width(iconItem.icon.getBounds()) == 0 || Rect.height(iconItem.icon.getBounds()) == 0) {
                Drawable drawable = iconItem.icon;
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), iconItem.icon.getIntrinsicHeight());
            }
            this.mIconMaps.put(Integer.valueOf(iconItem.iconIdentity), iconItem);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void setParser(@NonNull SplashItemParser<String, String> splashItemParser) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866716113")) {
            ipChange.ipc$dispatch("1866716113", new Object[]{this, splashItemParser});
        } else {
            this.mParser = splashItemParser;
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void setRenderScaleType(RobotPainter.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648198144")) {
            ipChange.ipc$dispatch("-648198144", new Object[]{this, scaleType});
        } else {
            this.mRobotPainter.setScaleType(scaleType);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void switchTouchable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733977190")) {
            ipChange.ipc$dispatch("733977190", new Object[]{this});
        } else {
            enableTouch(!this.mEnableTouch);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void updateCanvasSize(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-459517177")) {
            ipChange.ipc$dispatch("-459517177", new Object[]{this, str});
            return;
        }
        int[] parseCanvasSize = this.mParser.parseCanvasSize(str);
        if (parseCanvasSize != null) {
            this.mRobotPainter.updateCanvasSize(parseCanvasSize[0], parseCanvasSize[1]);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void render(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625549203")) {
            ipChange.ipc$dispatch("1625549203", new Object[]{this, str});
        } else {
            render(str, -1L);
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler
    public void render(@NonNull String str, long j) {
        List<SplashScheduler.SplashItem> parse;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147551855")) {
            ipChange.ipc$dispatch("-1147551855", new Object[]{this, str, Long.valueOf(j)});
        } else if (!this.mEnableTouch && (parse = this.mParser.parse(str)) != null) {
            for (SplashScheduler.SplashItem splashItem : parse) {
                int i = splashItem.iconItem.iconIdentity;
                if (this.mIconMaps.containsKey(Integer.valueOf(i))) {
                    splashItem.iconItem.icon = this.mIconMaps.get(Integer.valueOf(i)).icon;
                } else {
                    throw new RuntimeException("gift list contains invalid icon identity:" + i);
                }
            }
            if (j != -1) {
                this.mRobotPainter.setDrawInterval(j);
            }
            this.mRobotPainter.paint(parse);
        }
    }
}
