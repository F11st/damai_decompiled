package com.youku.live.dago.liveplayback.widget.view.endPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.model.EndPageShortVideoModel;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;
import java.text.DecimalFormat;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class EndShortVideoView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "EndShortVideoView";
    private TextView mCommentTv;
    private Context mContext;
    private ImageView mCoverIv;
    private TextView mDurationTv;
    private EndPageShortVideoModel mModel;
    private ImageView mMoreIv;
    private TextView mPlayCountTv;
    private TextView mPublishTimeTv;
    private TextView mTitleTv;

    public EndShortVideoView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031307354")) {
            ipChange.ipc$dispatch("1031307354", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.dago_end_item_view_short_video, (ViewGroup) this, true);
        this.mCoverIv = (ImageView) findViewById(R.id.end_short_video_cover);
        this.mPlayCountTv = (TextView) findViewById(R.id.end_short_video_num);
        this.mCommentTv = (TextView) findViewById(R.id.end_short_video_num2);
        this.mDurationTv = (TextView) findViewById(R.id.end_short_video_time);
        this.mTitleTv = (TextView) findViewById(R.id.end_short_video_title);
        this.mPublishTimeTv = (TextView) findViewById(R.id.end_short_video_time2);
        this.mMoreIv = (ImageView) findViewById(R.id.end_short_video_more);
        this.mContext = context;
    }

    public static StringBuffer setCreateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2097602040")) {
            return (StringBuffer) ipChange.ipc$dispatch("2097602040", new Object[]{Long.valueOf(j)});
        }
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j / 86400000;
        if (j2 >= 1) {
            stringBuffer.append(((int) j2) + "天前");
        }
        long j3 = j % 86400000;
        long j4 = j3 / DateUtils.MILLIS_PER_HOUR;
        if (j4 >= 1) {
            stringBuffer.append(((int) j4) + "小时前");
        }
        long j5 = j3 % DateUtils.MILLIS_PER_HOUR;
        long j6 = j5 / DateUtils.MILLIS_PER_MINUTE;
        if (j6 >= 1) {
            stringBuffer.append(((int) j6) + "分钟前");
        }
        long j7 = j5 % DateUtils.MILLIS_PER_MINUTE;
        if (j7 / 1000 >= 1) {
            stringBuffer.append("刚刚");
        }
        if ((j7 % 1000) / 1 >= 1) {
            stringBuffer.append("刚刚");
        }
        return stringBuffer;
    }

    private String setDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541872307")) {
            return (String) ipChange.ipc$dispatch("-1541872307", new Object[]{this, Long.valueOf(j)});
        }
        long j2 = j * 1000;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return setMinuteFormat(j2) + ":" + setSecondFormat(decimalFormat, j2);
    }

    private String setMinuteFormat(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1474735082")) {
            return (String) ipChange.ipc$dispatch("-1474735082", new Object[]{this, Long.valueOf(j)});
        }
        double d = j / DateUtils.MILLIS_PER_MINUTE;
        if (((int) Math.floor(d)) > 9) {
            return String.valueOf((int) Math.floor(d));
        }
        return "0" + ((int) Math.floor(d));
    }

    private String setSecondFormat(DecimalFormat decimalFormat, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883679632")) {
            return (String) ipChange.ipc$dispatch("-883679632", new Object[]{this, decimalFormat, Long.valueOf(j)});
        }
        long j2 = (j % DateUtils.MILLIS_PER_MINUTE) / 1000;
        if (Integer.parseInt(decimalFormat.format(j2)) > 9) {
            return decimalFormat.format(j2);
        }
        return String.valueOf(decimalFormat.format(j2)).equals("-1") ? "00" : "0" + decimalFormat.format(j2);
    }

    public void setData(EndPageShortVideoModel endPageShortVideoModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1112833318")) {
            ipChange.ipc$dispatch("1112833318", new Object[]{this, endPageShortVideoModel});
        } else if (endPageShortVideoModel != null) {
            this.mModel = endPageShortVideoModel;
            ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().round(UIUtils.dip2px(7, this.mContext)).loadUrl(endPageShortVideoModel.coverUrl).into(this.mCoverIv);
            TextView textView = this.mPlayCountTv;
            textView.setText(endPageShortVideoModel.playCount + "");
            TextView textView2 = this.mCommentTv;
            textView2.setText(endPageShortVideoModel.commentCount + "");
            this.mDurationTv.setText(setDuration(Long.parseLong(endPageShortVideoModel.duration)));
            this.mTitleTv.setText(endPageShortVideoModel.title);
            this.mPublishTimeTv.setText(setCreateTime(Long.parseLong(endPageShortVideoModel.crateTime)));
        }
    }

    public EndShortVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EndShortVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
