package leetcode高频题;

import entity.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:menglin
 * @Description:
 * @Date:2021/11/2711:31
 */
@SuppressWarnings("all")
public class ByteDance02 {

    /**
     * 判断会议时间是否冲突
     *
     * @param intervals
     * @return
     */
    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }
        // 如果彼此包含，说明时间冲突
        // 1.按照起点排序比较
        Collections.sort(
                intervals, Comparator.comparingInt(interval -> interval.start)
        );
        // 只有在起止时间冲突的时候返回false
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        // 3.默认返回true
        return true;
    }

}


