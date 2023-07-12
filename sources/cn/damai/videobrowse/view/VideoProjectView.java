package cn.damai.videobrowse.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pl;
import tb.tx2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class VideoProjectView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View partent;
    DMPosterView projectImg;
    TextView tvProjectAddress;
    TextView tvProjectName;
    TextView tvProjectTime;
    TextView tvSeeProject;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.videobrowse.view.VideoProjectView$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2789a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        View$OnClickListenerC2789a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2003507387")) {
                ipChange.ipc$dispatch("2003507387", new Object[]{this, view});
            } else {
                VideoProjectView.this.gotoProjectDetail(this.a, this.b, this.c);
            }
        }
    }

    public VideoProjectView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoProjectDetail(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1970189956")) {
            ipChange.ipc$dispatch("1970189956", new Object[]{this, str, str2, str3});
        } else if (this.context != null) {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str);
            bundle.putString("projectName", str2);
            bundle.putString("projectImage", str3);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
            tx2.g().i("bottom", TypedValues.Custom.S_FLOAT, true, str, "", z20.E());
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325594440")) {
            ipChange.ipc$dispatch("325594440", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.video_project_layer_layout, this);
        this.partent = inflate;
        this.projectImg = (DMPosterView) inflate.findViewById(R$id.video_project_img);
        this.tvProjectName = (TextView) this.partent.findViewById(R$id.video_project_name);
        this.tvProjectTime = (TextView) this.partent.findViewById(R$id.video_project_time);
        this.tvProjectAddress = (TextView) this.partent.findViewById(R$id.video_project_address);
        this.tvSeeProject = (TextView) this.partent.findViewById(R$id.video_project_see_project);
    }

    public void update(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181999930")) {
            ipChange.ipc$dispatch("-1181999930", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        this.projectImg.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
        this.projectImg.setImageUrl(str5);
        this.tvProjectTime.setText(str3);
        this.tvProjectName.setText(str2);
        this.tvProjectAddress.setText(str4);
        this.tvSeeProject.setOnClickListener(new View$OnClickListenerC2789a(str, str2, str5));
    }

    public VideoProjectView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoProjectView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
