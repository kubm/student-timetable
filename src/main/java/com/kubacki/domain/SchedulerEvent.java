package com.kubacki.domain;

public interface SchedulerEvent extends DomainObject{
    public String getText();
    public void setText(String text);
    public String getStart_date();
    public void setStart_date(String start_date);
    public String getEnd_date();
    public void setEnd_date(String end_date);
    public boolean getAllDay();
    public void setAllDay(boolean allDay);
    public String getDetails();
    public void setDetails(String details);
    public String getType();
    public void setType(String type);
}
