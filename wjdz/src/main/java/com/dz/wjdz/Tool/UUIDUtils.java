package com.dz.wjdz.Tool;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

    public static final String VERIFY_CODE = "0123456789";

    public static final String INVITATION_CODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String getOrderNumber() {
        return getOrderNum(null);
    }

    public static String getOrderNum(String str) {
        if (StringUtils.isEmpty(str)){
            str = UUIDUtils.VerifyCode(3);
        }

        try {
            String format = "yyyyMMddHHmmssSSS";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            String datetime = simpleDateFormat.format(new Date());
            return datetime + str;
        } catch (Exception e) {
            return "";
        }
    }


    public static String getRandomUUID() {
        String uuid = getUUID().substring(0, 32);
        return uuid;
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 使用指定源生成码
     *
     * @param verifySize 长度
     * @param sources    字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources) {
        if (sources == null || sources.length() == 0) {
            sources = VERIFY_CODE;
        }
        int codesLength = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(sources.charAt(rand.nextInt(codesLength - 1)));
        }
        return verifyCode.toString();
    }

    public static String VerifyCode(int verifySize) {
        return generateVerifyCode(verifySize, VERIFY_CODE);
    }

    public static String InvitationCode(int verifySize) {
        return generateVerifyCode(verifySize, INVITATION_CODE);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(getOrderNumber());
        }

    }
}
