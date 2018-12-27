package com.dwms.examine.model.vo;

import com.dwms.examine.model.bean.ExamineUser;
import lombok.Data;

/**
 * 考试成绩
 * @author windy
 * @date 2018-12-14
 */
@Data
public class ScoreVO extends ExamineUser {

    private Integer passScore;//及格分
    private Integer useTimeLength;//考试用时（秒）

}
