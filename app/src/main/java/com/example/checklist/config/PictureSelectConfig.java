package com.example.checklist.config;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.checklist.Customize.GlideEngine;
import com.example.checklist.R;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectModeConfig;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;

import java.io.File;
import java.util.ArrayList;

import top.zibin.luban.Luban;
import top.zibin.luban.OnNewCompressListener;


public class PictureSelectConfig {
        /**
         * 初始化多图选择的配置
         *
         * @param activity
         * @param maxTotal
         */
        public static void initMultiConfig(Activity activity, int maxTotal) {
            // 进入相册 以下是例子：用不到的api可以不写
            PictureSelector.create(activity)
                    .openGallery(SelectMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .setImageEngine(GlideEngine.createGlideEngine())
                    .setMaxSelectNum(maxTotal)// 最大图片选择数量 int
                    .setMinSelectNum(0)// 最小选择数量 int
                    .setImageSpanCount(3)// 每行显示个数 int
                    .setSelectionMode(SelectModeConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .isPreviewImage(true)// 是否可预览图片 true or false
                    .isPreviewVideo(false)// 是否可预览视频 true or false
                    .isPreviewAudio(false) // 是否可播放音频 true or false
                    .isDisplayCamera(true)// 是否显示拍照按钮 true or false
                    .setCompressEngine(new CompressFileEngine() {
                        @Override
                        public void onStartCompress(Context context, ArrayList<Uri> source, OnKeyValueResultCallbackListener call) {
                            Luban.with(context).load(source).ignoreBy(100)
                                    .setCompressListener(new OnNewCompressListener() {
                                        @Override
                                        public void onStart() {

                                        }

                                        @Override
                                        public void onSuccess(String source, File compressFile) {
                                            if (call != null) {
                                                call.onCallback(source, compressFile.getAbsolutePath());
                                            }
                                        }

                                        @Override
                                        public void onError(String source, Throwable e) {
                                            if (call != null) {
                                                call.onCallback(source, null);
                                            }
                                        }
                                    }).launch();
                        }
                    })
//                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
//                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                   // .compressMode(PictureConfig.LUBAN_COMPRESS_MODE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
                   // .compressGrade(Luban.THIRD_GEAR)// luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
//                .compressMaxKB(1024)//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH() // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
                    // int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls()// 是否显示uCrop工具栏，默认不显示 true or false
                    .isGif(false)// 是否显示gif图片 true or false
//                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
//                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                   // .isPreviewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled(false) // 裁剪是否可旋转图片 true or false
//                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoSecond()// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        }

        /**
         * 初始化单张图片选择的配置
         *
         * @param activity
         */
        public static void initSingleConfig(Activity activity) {
            // 进入相册 以下是例子：用不到的api可以不写
            PictureSelector.create(activity)
                    .openGallery(SelectMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()
                    .setImageEngine(GlideEngine.createGlideEngine())
                    .setMaxSelectNum(1)// 最大图片选择数量 int
                    .setMinSelectNum(0)// 最小选择数量 int
                    .setImageSpanCount(3)// 每行显示个数 int
                    .setSelectionMode(SelectModeConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .isPreviewImage(true)// 是否可预览图片 true or false
                    .isPreviewVideo(false)// 是否可预览视频 true or false
                    .isPreviewAudio(false) // 是否可播放音频 true or false
                    .isDisplayCamera(true)// 是否显示拍照按钮 true or false
                    .setCompressEngine(new CompressFileEngine() {
                        @Override
                        public void onStartCompress(Context context, ArrayList<Uri> source, OnKeyValueResultCallbackListener call) {
                            Luban.with(context).load(source).ignoreBy(100)
                                    .setCompressListener(new OnNewCompressListener() {
                                        @Override
                                        public void onStart() {

                                        }

                                        @Override
                                        public void onSuccess(String source, File compressFile) {
                                            if (call != null) {
                                                call.onCallback(source, compressFile.getAbsolutePath());
                                            }
                                        }

                                        @Override
                                        public void onError(String source, Throwable e) {
                                            if (call != null) {
                                                call.onCallback(source, null);
                                            }
                                        }
                                    }).launch();
                        }
                    })
//                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
//                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                    //.enableCrop(true)// 是否裁剪 true or false
                    //.compress(true)// 是否压缩 true or false
                    //.compressQuality()// luban压缩档次，默认3档 Luban.THIRD_GEAR、Luban.FIRST_GEAR、Luban.CUSTOM_GEAR
                   // .compressMode(PictureConfig.MAX_COMPRESS_SIZE)//系统自带 or 鲁班压缩 PictureConfig.SYSTEM_COMPRESS_MODE or LUBAN_COMPRESS_MODE
//                .compressMaxKB(500)//压缩最大值kb compressGrade()为Luban.CUSTOM_GEAR有效 int
//                .compressWH(7, 10) // 压缩宽高比 compressGrade()为Luban.CUSTOM_GEAR有效  int
                    //.glideOverride(130, 130)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                   // .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                    .isGif(false)// 是否显示gif图片 true or false
                    //.freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                   // .circleDimmedLayer(true)// 是否圆形裁剪 true or false
                   // .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                   // .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                   // .openClickSound(false)// 是否开启点击声音 true or false
//                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                  //  .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                    //.rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                   // .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoSecond()// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        }
}
