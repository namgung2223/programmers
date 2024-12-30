import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        LocalTime videoEnd = getTime(video_len.split(":"));
        LocalTime current = getTime(pos.split(":"));
        LocalTime opStart = getTime(op_start.split(":"));
        LocalTime opEnd = getTime(op_end.split(":"));

        for (String command : commands) {
            switch (command) {
                case "next" -> {
                    current = clickNext(current, opStart, opEnd, videoEnd);
                }
                case "prev" -> {
                    current = clickPrev(current,  opStart, opEnd);
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");
        return current.format(formatter);
    }

    private LocalTime clickPrev(LocalTime current, LocalTime onStart, LocalTime onEnd) {
        LocalTime tenSecondsStart = LocalTime.of(0,0, 10);
        if (current.isBefore(tenSecondsStart)) {
            current = LocalTime.of(0,0, 0);
            if (current.isAfter(onStart) && current.isBefore(onEnd)) {
                current = onEnd;
            }
        } else {
            current = current.minusSeconds(10);
            if (current.isAfter(onStart) && current.isBefore(onEnd)) {
                current = onEnd;
            }
        }
        return current;
    }

    private LocalTime clickNext(LocalTime current, LocalTime onStart, LocalTime onEnd, LocalTime videoLen) {
        LocalTime tenSecondsLeft = videoLen.minusSeconds(10);
        if (current.isAfter(tenSecondsLeft)) {
            current = videoLen;
        } else if (!current.isBefore(onStart) && !current.isAfter(onEnd)) {
            current = onEnd;
            current = current.plusSeconds(10);
        } else {
            current = current.plusSeconds(10);
            if (!current.isBefore(onStart) && !current.isAfter(onEnd)) {
                current = onEnd;
            }
        }
        return current;
    }

    private LocalTime getTime(String[] split) {
        return LocalTime.of(0,Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
