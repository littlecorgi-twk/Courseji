package com.littlecorgi.middle.logic.dao;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设置时间的工具类
 */
public class SetTimeHelp {

    /**
     * 获取时间列表
     *
     * @return 时间列表
     */
    public static List<String> getTimeList() {
        List<String> list = new ArrayList<>();
        list.add("现在");
        list.add("一分钟后");
        list.add("两分钟后");
        list.add("五分钟后");
        list.add("三十分钟后");
        list.add("一小时后");
        list.add("三小时后");
        list.add("一天后");
        list.add("三天后");
        return list;
    }

    /**
     * 与getTimeList()方法相对应，得到对应的毫秒值
     */
    public static long getTimeMillisecondList(int position) {
        List<Long> list = new ArrayList<>();
        long nowTime = new Date().getTime(); // 当前时间毫秒值
        list.add(nowTime);
        list.add(nowTime + 1000 * 60);
        list.add(nowTime + 1000 * 60 * 2);
        list.add(nowTime + 1000 * 60 * 5);
        list.add(nowTime + 1000 * 60 * 30);
        list.add(nowTime + 1000 * 60 * 60);
        list.add(nowTime + 1000 * 60 * 60 * 3);
        list.add(nowTime + 1000 * 60 * 60 * 24);
        list.add(nowTime + 1000 * 60 * 60 * 24 * 3);
        return list.get(position);
    }

    /**
     * 获取到长度列表
     *
     * @return 时间长度列表
     */
    public static List<String> getDurationList() {
        List<String> list = new ArrayList<>();
        list.add("两分钟");
        list.add("五分钟");
        list.add("十分钟");
        list.add("三十分钟");
        list.add("一小时");
        list.add("三小时");
        list.add("一天");
        list.add("两天");
        list.add("七天");
        return list;
    }

    /**
     * 对应的持续时间
     */
    public static long getDurationMillisecondList(int position) {
        List<Long> list = new ArrayList<>();
        list.add(1000 * 60 * 2L);
        list.add(1000 * 60 * 5L);
        list.add(1000 * 60 * 10L);
        list.add(1000 * 60 * 30L);
        list.add(1000 * 60 * 60L);
        list.add(1000 * 60 * 60 * 3L);
        list.add(1000 * 60 * 60 * 24L);
        list.add(1000 * 60 * 60 * 24 * 2L);
        list.add(1000 * 60 * 60 * 24 * 7L);
        return list.get(position);
    }

    /**
     * 获取日期
     *
     * @return 日期集合
     */
    public static List<String> getTimeDay() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("0" + i);
        }
        for (int i = 10; i <= 30; i++) {
            list.add(i + "");
        }
        return list;
    }

    /**
     * 获取小时
     *
     * @return 小时集合
     */
    public static List<String> getTimeHour() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("0" + i);
        }
        for (int i = 10; i <= 23; i++) {
            list.add(i + "");
        }
        return list;
    }

    /**
     * 获取半小时集合
     *
     * @return 半小时集合
     */
    public static List<String> getTimeHalfHour() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add("0" + i);
        }
        for (int i = 10; i <= 12; i++) {
            list.add(i + "");
        }
        return list;
    }

    /**
     * 获取上午下午集合
     *
     * @return 上午下午集合
     */
    public static List<String> getTimePM() {
        List<String> list = new ArrayList<>();
        list.add("上午");
        list.add("下午");
        return list;
    }

    /**
     * 获取分钟集合
     *
     * @return 分钟集合
     */
    public static List<String> getTimeMinutes() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("0" + i);
        }
        for (int i = 10; i <= 59; i++) {
            list.add(i + "");
        }
        return list;
    }

    /**
     * 为滚轮设置初值为当前时间
     */
    public static int getMinutesIndex() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
        String time = simpleDateFormat.format(new Date());
        return Integer.parseInt(time);
    }

    /**
     * 返回半小时对应的index
     */
    public static int getHalfHourIndex() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
        String time = simpleDateFormat.format(new Date());
        return Integer.parseInt(time);
    }

    /**
     * 获取上午下午的index
     */
    public static int getTimePMIndex() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("a");
        String time = simpleDateFormat.format(new Date());
        if (time.equals("上午")) {
            return 0;
        } else {
            return 1;
        }
    }
}
