package cn.damai.tetris.core;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.message.observer.Action;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.IModel;
import cn.damai.tetris.core.IView;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.ja;
import tb.jb1;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class BasePresenter<M extends IModel, V extends IView, N extends BaseNode> implements IPresenter<M, V, N>, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String className;
    protected ja mContext;
    xr mDMMessage;
    protected M mModel;
    private ISection mSection;
    protected V mView;
    protected int postion;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Point.values().length];
            a = iArr;
            try {
                iArr[Point.TRACK_B.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Point.TRACK_C.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BasePresenter(V v, String str, ja jaVar) {
        this.mView = v;
        this.className = str;
        this.mContext = jaVar;
        v.setPresenter(this);
        xr xrVar = new xr();
        this.mDMMessage = xrVar;
        xrVar.b(this.mContext.a(), new Action() { // from class: tb.wa
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$0((Message) obj);
            }
        });
        xr xrVar2 = this.mDMMessage;
        xrVar2.b(this.mContext.a() + 11001, new Action() { // from class: tb.xa
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$1((Message) obj);
            }
        });
        xr xrVar3 = this.mDMMessage;
        xrVar3.b(this.mContext.a() + 11002, new Action() { // from class: tb.ya
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$2((Message) obj);
            }
        });
        xr xrVar4 = this.mDMMessage;
        xrVar4.b(this.mContext.a() + 11003, new Action() { // from class: tb.ua
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$3((Message) obj);
            }
        });
        xr xrVar5 = this.mDMMessage;
        xrVar5.b(this.mContext.a() + 11004, new Action() { // from class: tb.va
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$4((Message) obj);
            }
        });
        xr xrVar6 = this.mDMMessage;
        xrVar6.b(this.mContext.a() + 11005, new Action() { // from class: tb.za
            @Override // cn.damai.message.observer.Action
            public final void call(Object obj) {
                BasePresenter.this.lambda$new$5((Message) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069164493")) {
            ipChange.ipc$dispatch("-1069164493", new Object[]{this, message});
        } else {
            onMessage(message.what, message.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "563639506")) {
            ipChange.ipc$dispatch("563639506", new Object[]{this, message});
        } else {
            onInnerMessage(message.what, message.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098523791")) {
            ipChange.ipc$dispatch("-2098523791", new Object[]{this, message});
        } else {
            onInnerMessage(message.what, message.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-465719792")) {
            ipChange.ipc$dispatch("-465719792", new Object[]{this, message});
        } else {
            onInnerMessage(message.what, message.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167084207")) {
            ipChange.ipc$dispatch("1167084207", new Object[]{this, message});
        } else {
            onInnerMessage(message.what, message.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495079090")) {
            ipChange.ipc$dispatch("-1495079090", new Object[]{this, message});
        } else {
            onInnerMessage(message.what, message.value);
        }
    }

    private void onInnerMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257579976")) {
            ipChange.ipc$dispatch("-257579976", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        onMessage(i, obj);
        if (i == 11004) {
            this.mDMMessage.a();
            this.mDMMessage = null;
        }
    }

    @Override // cn.damai.tetris.core.IPresenter
    public M createModel(N n) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056565391")) {
            return (M) ipChange.ipc$dispatch("2056565391", new Object[]{this, n});
        }
        this.mModel = null;
        try {
            M m = (M) Class.forName(this.className).newInstance();
            this.mModel = m;
            m.parseModelData(n);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        return this.mModel;
    }

    @Override // cn.damai.tetris.core.IPresenter
    public ja getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "459278302") ? (ja) ipChange.ipc$dispatch("459278302", new Object[]{this}) : this.mContext;
    }

    @Override // cn.damai.tetris.core.IPresenter
    public M getModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1822112544") ? (M) ipChange.ipc$dispatch("1822112544", new Object[]{this}) : this.mModel;
    }

    @Override // cn.damai.tetris.core.IPresenter
    public ISection getSection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1376167999") ? (ISection) ipChange.ipc$dispatch("1376167999", new Object[]{this}) : this.mSection;
    }

    @Nullable
    public String getTrackPointFromModel(Point point) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922699449")) {
            return (String) ipChange.ipc$dispatch("1922699449", new Object[]{this, point});
        }
        M m = this.mModel;
        if (m == null || (trackInfo = m.getTrackInfo()) == null) {
            return null;
        }
        int i = a.a[point.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return trackInfo.trackC;
        }
        return trackInfo.trackB;
    }

    public V getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-782989388") ? (V) ipChange.ipc$dispatch("-782989388", new Object[]{this}) : this.mView;
    }

    @Override // cn.damai.tetris.core.IPresenter
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121974343")) {
            ipChange.ipc$dispatch("121974343", new Object[]{this});
            return;
        }
        try {
            init(this.mModel);
        } catch (Exception e) {
            jb1.b("BasePresenter", e.getMessage());
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("componentId", getSection().getComponentId());
            hashMap.put(PushClientConstants.TAG_CLASS_NAME, this.className);
            hashMap.put("exception", e.getMessage());
            TrackProxy.c("-508", "组件Presenter初始化异常", hashMap);
        }
        if (TextUtils.isEmpty(getModel().getStyleValue("bgColor")) || getView().getRootView() == null) {
            return;
        }
        try {
            getView().getRootView().setBackgroundColor(Color.parseColor(getModel().getStyleValue("bgColor")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void init(M m);

    @Override // cn.damai.tetris.core.msg.IMessage
    public abstract void onMessage(int i, Object obj);

    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671938865")) {
            return ((Boolean) ipChange.ipc$dispatch("671938865", new Object[]{this})).booleanValue();
        }
        return false;
    }

    public void rebindData(M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598692783")) {
            ipChange.ipc$dispatch("1598692783", new Object[]{this, m});
        } else {
            init(m);
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage
    public void sendMsg(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "510826149")) {
            ipChange.ipc$dispatch("510826149", new Object[]{this, message});
        } else {
            xr.c(this.mContext.a(), message);
        }
    }

    public void setModel(M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541018020")) {
            ipChange.ipc$dispatch("-541018020", new Object[]{this, m});
        } else {
            this.mModel = m;
        }
    }

    @Override // cn.damai.tetris.core.IPresenter
    public void setSection(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130043661")) {
            ipChange.ipc$dispatch("-2130043661", new Object[]{this, iSection});
        } else {
            this.mSection = iSection;
        }
    }

    @Override // cn.damai.tetris.core.IPresenter
    public void setView(V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874661694")) {
            ipChange.ipc$dispatch("-1874661694", new Object[]{this, v});
        } else {
            this.mView = v;
        }
    }

    public void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850596859")) {
            ipChange.ipc$dispatch("1850596859", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
        } else if (TrackProxy.a() != null) {
            JSONObject aBBucket = getModel().getABBucket();
            if (aBBucket != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                if (trackType == TrackType.click) {
                    map.put("PreABTrackInfo", aBBucket.toJSONString());
                }
                map.put("ABTrackInfo", aBBucket.toJSONString());
            }
            if (!TextUtils.isEmpty(str2) && str2.endsWith(JSMethod.NOT_SET)) {
                str2 = str2 + getModel().getOffset();
            }
            String str4 = str2;
            if (map == null) {
                map = new HashMap<>();
            }
            Map<String, String> map2 = map;
            if (TextUtils.isEmpty(map2.get("titlelabel")) && getSection() != null && getSection().getStyleInfo() != null && !TextUtils.isEmpty(getSection().getStyleInfo().getString("title"))) {
                map2.put("titlelabel", getSection().getStyleInfo().getString("title"));
            }
            TrackProxy.a().userTrack(trackType, view, str, str4, str3, map2, z);
        }
    }

    public void userTrackClick(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069723845")) {
            ipChange.ipc$dispatch("-2069723845", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        M m = this.mModel;
        if (m != null && m.getTrackInfo() != null) {
            userTrackClick(str, this.mModel.getTrackInfo().getArgsMap(), z);
        } else {
            Log.e("Tetris", "userTrackClick error. ");
        }
    }

    public void userTrackExpose(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363364301")) {
            ipChange.ipc$dispatch("1363364301", new Object[]{this, view, str});
            return;
        }
        M m = this.mModel;
        if (m != null && m.getTrackInfo() != null) {
            userTrackExpose(view, str, this.mModel.getTrackInfo().getArgsMap(), false);
        } else {
            Log.e("Tetris", "userTrackClick error. ");
        }
    }

    public void userTrackClick(String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059423576")) {
            ipChange.ipc$dispatch("-1059423576", new Object[]{this, str, map, Boolean.valueOf(z)});
            return;
        }
        M m = this.mModel;
        if (m != null && m.getTrackInfo() != null) {
            userTrack(TrackType.click, null, this.mModel.getTrackInfo().trackB, this.mModel.getTrackInfo().trackC, str, map, z);
        } else {
            Log.e("Tetris", "userTrackClick error. ");
        }
    }

    public void userTrackExpose(View view, String str, Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166170044")) {
            ipChange.ipc$dispatch("1166170044", new Object[]{this, view, str, map, Boolean.valueOf(z)});
            return;
        }
        M m = this.mModel;
        if (m != null && m.getTrackInfo() != null) {
            userTrack(TrackType.expose, view, this.mModel.getTrackInfo().trackB, this.mModel.getTrackInfo().trackC, str, map, z);
        } else {
            Log.e("Tetris", "userTrackClick error. ");
        }
    }
}
