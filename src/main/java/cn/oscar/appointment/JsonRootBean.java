package cn.oscar.appointment;


import java.util.List;

/**
 * Auto-generated: 2020-12-02 17:41:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String startUserName;
    private List<FormValue> formValue;
    private String templateId;
    private FormInstFuncRelDto formInstFuncRelDto;
    private String templateKey;
    private List<Tasks> tasks;
    public void setStartUserName(String startUserName) {
        this.startUserName = startUserName;
    }
    public String getStartUserName() {
        return startUserName;
    }

    public void setFormValue(List<FormValue> formValue) {
        this.formValue = formValue;
    }
    public List<FormValue> getFormValue() {
        return formValue;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    public String getTemplateId() {
        return templateId;
    }

    public void setFormInstFuncRelDto(FormInstFuncRelDto formInstFuncRelDto) {
        this.formInstFuncRelDto = formInstFuncRelDto;
    }
    public FormInstFuncRelDto getFormInstFuncRelDto() {
        return formInstFuncRelDto;
    }

    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey;
    }
    public String getTemplateKey() {
        return templateKey;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
    public List<Tasks> getTasks() {
        return tasks;
    }

}