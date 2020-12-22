package cn.oscar.appointment;


import java.util.List;

/**
 * Auto-generated: 2020-12-02 17:41:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Tasks {

    private String templateNodeId;
    private String taskType;
    private List<Candidate> candidate;
    public void setTemplateNodeId(String templateNodeId) {
        this.templateNodeId = templateNodeId;
    }
    public String getTemplateNodeId() {
        return templateNodeId;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
    public String getTaskType() {
        return taskType;
    }

    public void setCandidate(List<Candidate> candidate) {
        this.candidate = candidate;
    }
    public List<Candidate> getCandidate() {
        return candidate;
    }

}