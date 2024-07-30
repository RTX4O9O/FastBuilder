package com.njdge.fastbuilder.utils;

import com.njdge.fastbuilder.arena.ArenaType;

import static com.njdge.fastbuilder.utils.TimeUtil.formatTime;

public class Util {
    public static String renderPreviousBest(Long pb, Long time) {
        if (pb == null) {
            return CC.RED + formatTime(time);
        }

        String pbStr = formatTime(pb);
        String timeStr = formatTime(time);

        String[] pbParts = pbStr.split("\\.");
        String[] timeParts = timeStr.split("\\.");

        int pbSeconds = Integer.parseInt(pbParts[0]);
        int timeSeconds = Integer.parseInt(timeParts[0]);

        StringBuilder result = new StringBuilder();

        if (timeSeconds > pbSeconds) {
            result.append(CC.GREEN).append(pbParts[0]).append(".").append(pbParts[1]);
        } else if (timeSeconds < pbSeconds) {
            result.append(CC.RED).append(pbParts[0]).append(".").append(pbParts[1]);
        } else {
            result.append(CC.YELLOW).append(pbSeconds).append(".");

            String pbMillis = pbParts[1];
            String timeMillis = timeParts[1];

            boolean colorSet = false;
            for (int i = 0; i < pbMillis.length(); i++) {
                char pbChar = pbMillis.charAt(i);
                char timeChar = timeMillis.charAt(i);

                if (timeChar > pbChar && !colorSet) {
                    result.append(CC.GREEN);
                    colorSet = true;
                } else if (timeChar < pbChar && !colorSet) {
                    result.append(CC.RED);
                    colorSet = true;
                }
                result.append(pbChar);
            }
        }

        return result.toString();
    }


    public static String renderTimeTaken(Long previousTime, Long time) {
        if (previousTime == null) {
            return CC.GREEN + formatTime(time);
        } else {
            long timeTaken = time - previousTime;
            String timeTakenStr;
            if (timeTaken < 0) {
                timeTakenStr = CC.RED + "-" + formatTime(-timeTaken);
            } else {
                timeTakenStr = CC.GREEN + "+" + formatTime(timeTaken);
            }

            return renderPreviousBest(time, previousTime) + " " + CC.GRAY + CC.translate("&l|| ") + timeTakenStr;

        }
    }



}
