package tb;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.alibaba.pictures.bricks.bean.FollowBox;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequestKt;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.bricks.view.FollowView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class h8 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9206a Companion = new C9206a(null);
    @NotNull
    private static final h8 c = new h8();
    @NotNull
    private final HashMap<String, FollowBox> a = new HashMap<>();
    @NotNull
    private final HashMap<String, ActionRelation<FollowStateBean>> b = new HashMap<>();

    /* compiled from: Taobao */
    /* renamed from: tb.h8$a */
    /* loaded from: classes7.dex */
    public static final class C9206a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9206a() {
        }

        public /* synthetic */ C9206a(k50 k50Var) {
            this();
        }

        @NotNull
        public final h8 a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2000313315") ? (h8) ipChange.ipc$dispatch("-2000313315", new Object[]{this}) : h8.c;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.h8$b */
    /* loaded from: classes7.dex */
    public static final class C9207b implements ActionRelation<FollowStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$ObjectRef<FollowBox> b;
        final /* synthetic */ FollowBox c;

        C9207b(Ref$ObjectRef<FollowBox> ref$ObjectRef, FollowBox followBox) {
            this.b = ref$ObjectRef;
            this.c = followBox;
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void action(@NotNull x2<FollowStateBean> x2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1765926430")) {
                ipChange.ipc$dispatch("1765926430", new Object[]{this, x2Var});
                return;
            }
            b41.i(x2Var, "result");
            ActionRelation actionRelation = (ActionRelation) h8.this.b.get(this.b.element.key);
            if (actionRelation != null) {
                actionRelation.action(x2Var);
            }
            if (x2Var.b()) {
                FollowBox followBox = this.c;
                FollowStateBean a = x2Var.a();
                followBox.isFollowed = a != null ? a.isFollowed() : false;
                h8 h8Var = h8.this;
                String str = this.b.element.key;
                b41.h(str, "box.key");
                h8Var.j(str, this.c.isFollowed);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void end() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1466889471")) {
                ipChange.ipc$dispatch("-1466889471", new Object[]{this});
                return;
            }
            ActionRelation actionRelation = (ActionRelation) h8.this.b.get(this.b.element.key);
            if (actionRelation != null) {
                actionRelation.end();
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void start() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1287268262")) {
                ipChange.ipc$dispatch("-1287268262", new Object[]{this});
                return;
            }
            ActionRelation actionRelation = (ActionRelation) h8.this.b.get(this.b.element.key);
            if (actionRelation != null) {
                actionRelation.start();
            }
        }
    }

    private h8() {
    }

    private final String e(Fragment fragment, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244277433")) {
            return (String) ipChange.ipc$dispatch("-244277433", new Object[]{this, fragment, str});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fragment != null ? fragment.hashCode() : 0);
        sb.append('_');
        sb.append(str);
        sb.append("_key");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FollowView followView, Function1 function1, FollowBox followBox, String str, h8 h8Var, Ref$ObjectRef ref$ObjectRef, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815380489")) {
            ipChange.ipc$dispatch("815380489", new Object[]{followView, function1, followBox, str, h8Var, ref$ObjectRef, view});
            return;
        }
        b41.i(followView, "$followView");
        b41.i(function1, "$clickUtListener");
        b41.i(str, "$finalArtistId");
        b41.i(h8Var, "this$0");
        b41.i(ref$ObjectRef, "$box");
        if (followView.getAlpha() < 0.9d) {
            return;
        }
        function1.invoke(Boolean.valueOf(followBox.isFollowed));
        CityWantRequestKt.b(!followBox.isFollowed, str, new C9207b(ref$ObjectRef, followBox), null, 8, null);
    }

    public final void d(@Nullable Fragment fragment, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047909785")) {
            ipChange.ipc$dispatch("2047909785", new Object[]{this, fragment, str});
            return;
        }
        String e = e(fragment, str);
        this.a.remove(e);
        this.b.remove(e);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.alibaba.pictures.bricks.bean.FollowBox, T, java.lang.Object] */
    public final void f(@Nullable Fragment fragment, @Nullable String str, @NotNull final FollowView followView, @NotNull final Function1<? super Boolean, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591055558")) {
            ipChange.ipc$dispatch("591055558", new Object[]{this, fragment, str, followView, function1});
            return;
        }
        b41.i(followView, "followView");
        b41.i(function1, "clickUtListener");
        String e = e(fragment, str);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r0 = this.a.get(e);
        ref$ObjectRef.element = r0;
        if (r0 == 0) {
            ?? followBox = new FollowBox(e, str);
            ref$ObjectRef.element = followBox;
            this.a.put(e, followBox);
        }
        FollowBox followBox2 = (FollowBox) ref$ObjectRef.element;
        if (!followBox2.mFollowViews.contains(followView)) {
            followBox2.mFollowViews.add(followView);
        }
        final FollowBox followBox3 = (FollowBox) ref$ObjectRef.element;
        if (str == null) {
            str = "";
        }
        final String str2 = str;
        followView.setOnClickListener(new View.OnClickListener() { // from class: tb.g8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h8.g(FollowView.this, function1, followBox3, str2, this, ref$ObjectRef, view);
            }
        });
    }

    public final void h(@Nullable Fragment fragment, @Nullable String str, @NotNull ActionRelation<FollowStateBean> actionRelation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583473613")) {
            ipChange.ipc$dispatch("-583473613", new Object[]{this, fragment, str, actionRelation});
            return;
        }
        b41.i(actionRelation, "action");
        this.b.put(e(fragment, str), actionRelation);
    }

    public final void i(@Nullable Fragment fragment, @Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059751893")) {
            ipChange.ipc$dispatch("1059751893", new Object[]{this, fragment, str, Boolean.valueOf(z)});
        } else {
            j(e(fragment, str), z);
        }
    }

    public final void j(@NotNull String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "930894797")) {
            ipChange.ipc$dispatch("930894797", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "key");
        FollowBox followBox = this.a.get(str);
        if (followBox != null) {
            followBox.isFollowed = z;
            List<FollowView> list = followBox.mFollowViews;
            b41.h(list, "mFollowViews");
            for (FollowView followView : list) {
                followView.updateFollow(followBox.isFollowed);
            }
        }
    }
}
