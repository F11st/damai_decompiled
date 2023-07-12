package tb;

import android.app.Activity;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class jw0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ViewGroup a;

        a(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1471158371")) {
                ipChange.ipc$dispatch("-1471158371", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
            } else {
                ((ImageView) this.a.findViewById(R$id.user_iv_header)).setImageDrawable(new ui(eVar.b));
            }
        }
    }

    public static void a(Activity activity, ViewGroup viewGroup, StarHeaderData starHeaderData, int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403260171")) {
            ipChange.ipc$dispatch("1403260171", new Object[]{activity, viewGroup, starHeaderData, Integer.valueOf(i)});
        } else if (starHeaderData == null) {
        } else {
            String str2 = starHeaderData.name;
            if (str2 == null) {
                str2 = "";
            }
            TextView textView = (TextView) viewGroup.findViewById(R$id.user_tv_name);
            int i2 = i == 2 ? 140 : 245;
            if (textView != null && textView != null) {
                textView.setText(str2);
                TextPaint paint = textView.getPaint();
                while (paint != null && paint.measureText(str2) > t60.a(activity, i2) && paint.getTextSize() > t60.a(activity, 10.0f)) {
                    paint.setTextSize(paint.getTextSize() - 2.0f);
                }
            }
            if (starHeaderData.fansNum == 0) {
                int i3 = R$id.user_tv_fanscout;
                if (viewGroup.findViewById(i3) != null) {
                    viewGroup.findViewById(i3).setVisibility(4);
                }
                viewGroup.findViewById(R$id.user_tv_fansdesc).setVisibility(4);
            } else {
                int i4 = R$id.user_tv_fanscout;
                if (viewGroup.findViewById(i4) != null) {
                    viewGroup.findViewById(i4).setVisibility(0);
                }
                int i5 = R$id.user_tv_fansdesc;
                viewGroup.findViewById(i5).setVisibility(0);
                String[] b = b(starHeaderData.fansNum);
                c(viewGroup, i4, b[0]);
                c(viewGroup, i5, b[1]);
            }
            if (starHeaderData.projectShowNum == 0) {
                int i6 = R$id.user_tv_showcout;
                if (viewGroup.findViewById(i6) != null) {
                    c(viewGroup, i6, "0");
                }
            } else {
                int i7 = R$id.user_tv_showcout;
                if (viewGroup.findViewById(i7) != null) {
                    c(viewGroup, i7, starHeaderData.projectShowNum + "");
                }
            }
            int i8 = R$drawable.color_60black;
            if (i == 2) {
                viewGroup.findViewById(R$id.user_iv_header).setVisibility(0);
                int i9 = R$id.tv_header_v;
                if (viewGroup.findViewById(i9) != null) {
                    if (starHeaderData.vaccount) {
                        viewGroup.findViewById(i9).setVisibility(0);
                    } else {
                        viewGroup.findViewById(i9).setVisibility(8);
                    }
                }
                String str3 = starHeaderData.headPic;
                if (str3 != null && str3.contains("?")) {
                    str = str3 + "&ran=" + new Random().nextInt();
                } else {
                    str = str3 + "?ran=" + new Random().nextInt();
                }
                cn.damai.common.image.a.b().c(str).c(R$drawable.c_default_bg).i(i8).n(new a(viewGroup)).f();
            }
        }
    }

    public static String[] b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487472498")) {
            return (String[]) ipChange.ipc$dispatch("-487472498", new Object[]{Long.valueOf(j)});
        }
        String[] strArr = new String[2];
        try {
            if (j < 10000) {
                strArr[0] = j + "";
                strArr[1] = "粉丝";
                return strArr;
            }
            strArr[0] = (((float) (j / 1000)) / 10.0f) + "";
            strArr[1] = "万粉丝";
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return new String[2];
        }
    }

    public static void c(ViewGroup viewGroup, @IdRes int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032811048")) {
            ipChange.ipc$dispatch("2032811048", new Object[]{viewGroup, Integer.valueOf(i), str});
        } else if (viewGroup == null || viewGroup.findViewById(i) == null || wh2.j(str)) {
        } else {
            ((TextView) viewGroup.findViewById(i)).setText(str.trim());
        }
    }
}
