package com.littlecorgi.leave.student;

/**
 * 历史数据类
 */
public class History {

    private String leaveTypeText;
    private String leavePeopleText;
    private String leaveTimeText;
    private String leaveReasonText;
    private String leaveBackText;

    /**
     * 构造方法
     */
    public History(
            String leaveTypeText,
            String leavePeopleText,
            String leaveTimeText,
            String leaveReasonText,
            String leaveBackText) {
        this.leaveTypeText = leaveTypeText;
        this.leavePeopleText = leavePeopleText;
        this.leaveTimeText = leaveTimeText;
        this.leaveReasonText = leaveReasonText;
        this.leaveBackText = leaveBackText;
    }

    public String getLeaveTypeText() {
        return leaveTypeText;
    }

    public void setLeaveTypeText(String leaveTypeText) {
        this.leaveTypeText = leaveTypeText;
    }

    public String getLeaveTimeText() {
        return leaveTimeText;
    }

    public void setLeaveTimeText(String leaveTimeText) {
        this.leaveTimeText = leaveTimeText;
    }

    public String getLeaveReasonText() {
        return leaveReasonText;
    }

    public void setLeaveReasonText(String leaveReasonText) {
        this.leaveReasonText = leaveReasonText;
    }

    public String getLeavePeopleText() {
        return leavePeopleText;
    }

    public void setLeavePeopleText(String leavePeopleText) {
        this.leavePeopleText = leavePeopleText;
    }

    public String getLeaveBackText() {
        return leaveBackText;
    }

    public void setLeaveBackText(String leaveBackText) {
        this.leaveBackText = leaveBackText;
    }
}
