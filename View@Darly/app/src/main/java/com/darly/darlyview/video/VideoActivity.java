package com.darly.darlyview.video;

import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.darly.common.ToastApp;
import com.darly.darlyview.R;
import com.darly.darlyview.base.BaseActivity;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.github.faucamp.simplertmp.RtmpHandler;
import com.seu.magicfilter.utils.MagicFilterType;

import net.ossrs.yasea.SrsCameraView;
import net.ossrs.yasea.SrsEncodeHandler;
import net.ossrs.yasea.SrsPublisher;
import net.ossrs.yasea.SrsRecordHandler;

import java.io.IOException;
import java.net.SocketException;

/** 视频帧录制，压缩传递主要功能类
 * @author Darly/张宇辉/2018/3/22 10:33
 * @version 1.0/com.darly.darlyview.video
 */
@ContentBinder(R.layout.activity_video)
public class VideoActivity extends BaseActivity implements SrsEncodeHandler.SrsEncodeListener, RtmpHandler.RtmpListener, SrsRecordHandler.SrsRecordListener, OnClickListener {

    @Override
    protected void initParamer() {
        super.initParamer();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @ViewsBinder(R.id.glsurfaceview_camera)
    private SrsCameraView glsurfaceview_camera;
    @ViewsBinder(R.id.publish)
    private Button mPublishBtn;
    @ViewsBinder(R.id.swCam)
    private Button mCameraSwitchBtn;

    private SrsPublisher mPublisher;
    private String rtmpUrl = "rtmp://193.169.100.110/live/tes";
//    private String rtmpUrl = "rtmp://193.169.100.110:1755/srstest/tes";

    @Override
    protected void initView(Bundle savedInstanceState) {
        mPublisher = new SrsPublisher(glsurfaceview_camera);
    }

    @Override
    protected void loadData() {
        //编码状态回调
        mPublisher.setEncodeHandler(new SrsEncodeHandler(this));
        mPublisher.setRecordHandler(new SrsRecordHandler(this));
        //rtmp推流状态回调
        mPublisher.setRtmpHandler(new RtmpHandler(this));
        //预览分辨率
        mPublisher.setPreviewResolution(800, 800);
        //推流分辨率
        mPublisher.setOutputResolution(800, 800);
        mPublisher.switchToSoftEncoder();
        //传输率
        mPublisher.setVideoHDMode();
        //开启美颜（其他滤镜效果在MagicFilterType中查看）
        mPublisher.switchCameraFilter(MagicFilterType.BEAUTY);
        //打开摄像头，开始预览（未推流）
        mPublisher.startCamera();
    }

    @Override
    protected void initListener() {
        mPublishBtn.setOnClickListener(this);
        mCameraSwitchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //开始/停止推流
            case R.id.publish:
                if (mPublishBtn.getText().toString().contentEquals("开始")) {
                    mPublisher.startPublish(rtmpUrl);
                    mPublisher.startCamera();
                    mPublishBtn.setText("暂停");
                } else if (mPublishBtn.getText().toString().contentEquals("暂停")) {
                    mPublisher.pauseRecord();
                    mPublishBtn.setText("继续");
                }else if (mPublishBtn.getText().toString().contentEquals("继续")){
                    mPublisher.resumeRecord();
                    mPublishBtn.setText("暂停");
                }
                break;
            //切换摄像头
            case R.id.swCam:
                mPublisher.switchCameraFace((mPublisher.getCamraId() + 1) % Camera.getNumberOfCameras());
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPublisher.resumeRecord();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPublisher.pauseRecord();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPublisher.stopPublish();
        mPublisher.stopRecord();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPublisher.stopEncode();
        mPublisher.stopRecord();
        mPublisher.setScreenOrientation(newConfig.orientation);
        if (mPublishBtn.getText().toString().contentEquals("停止")) {
            mPublisher.startEncode();
        }
        mPublisher.startCamera();
    }

    @Override
    public void onNetworkWeak() {
        ToastApp.showToast("网络信号弱！");
    }

    @Override
    public void onNetworkResume() {

    }

    @Override
    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {
        handleException(e);
    }

    private void handleException(Exception e) {
        try {
            ToastApp.showToast(e.getMessage());
            mPublisher.stopPublish();
            mPublisher.stopRecord();
            mPublishBtn.setText("开始");
        } catch (Exception e1) {
            //
        }
    }

    @Override
    public void onRecordPause() {
        ToastApp.showToast("停止录制");
    }

    @Override
    public void onRecordResume() {
        ToastApp.showToast("录制重启");
    }

    @Override
    public void onRecordStarted(String msg) {
        ToastApp.showToast(msg);
    }

    @Override
    public void onRecordFinished(String msg) {
        ToastApp.showToast(msg);
    }

    @Override
    public void onRecordIllegalArgumentException(IllegalArgumentException e) {
        handleException(e);
    }

    @Override
    public void onRecordIOException(IOException e) {
        handleException(e);
    }

    @Override
    public void onRtmpConnecting(String msg) {
        ToastApp.showToast(msg);
    }

    @Override
    public void onRtmpConnected(String msg) {
        ToastApp.showToast(msg);
    }

    @Override
    public void onRtmpVideoStreaming() {

    }

    @Override
    public void onRtmpAudioStreaming() {

    }

    @Override
    public void onRtmpStopped() {
        ToastApp.showToast("停止");
    }

    @Override
    public void onRtmpDisconnected() {
        ToastApp.showToast("未连接服务器");
        mPublisher.startCamera();
    }

    @Override
    public void onRtmpVideoFpsChanged(double fps) {

    }

    @Override
    public void onRtmpVideoBitrateChanged(double bitrate) {

    }

    @Override
    public void onRtmpAudioBitrateChanged(double bitrate) {

    }

    @Override
    public void onRtmpSocketException(SocketException e) {
        handleException(e);
    }

    @Override
    public void onRtmpIOException(IOException e) {
        handleException(e);
    }

    @Override
    public void onRtmpIllegalArgumentException(IllegalArgumentException e) {
        handleException(e);
    }

    @Override
    public void onRtmpIllegalStateException(IllegalStateException e) {
        handleException(e);
    }
}
