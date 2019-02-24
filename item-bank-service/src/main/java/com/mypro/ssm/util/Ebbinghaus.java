package com.mypro.ssm.util;

import com.mypro.ssm.po.Question;

public class Ebbinghaus {
    private static int forgettingCurve[] = {
            5,            // 5分钟
            30,            // 30分钟
            12 * 60,        // 12小时
            1 * 24 * 60,    // 1天
            2 * 24 * 60,    // 2天
            4 * 24 * 60,    // 4天
            7 * 24 * 60,    // 7天
            15 * 24 * 60    // 15天
    };

    // 返回记忆曲线最大阶
    public static int getMaxForgettingCurve() {
        return forgettingCurve.length;
    }

    // 根据记忆曲线，判断单词是否需要复习
    public static boolean needRecite(Question record) {
        // 记忆曲线完成
        if (record.getStage() >= forgettingCurve.length) {
            return false;
        }
        long currentTime = System.currentTimeMillis();
        int timeDiff = (int) ((currentTime - record.getLastReviewTime().getTime()) / (1000 * 60));

        if (timeDiff > forgettingCurve[record.getStage()]) {
            return true;
        } else {
            return false;
        }
    }
}