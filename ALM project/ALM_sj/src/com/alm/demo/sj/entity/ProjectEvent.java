package com.alm.demo.sj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="projectevent")
public class ProjectEvent
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int peventid;
	private String title;
	
	public ProjectEvent(int peventid, String title ) {
		super();
		this.peventid = peventid;
		this.title = title;
		
	}
	public ProjectEvent() {
		super();
	}
	public int getPeventid() {
		return peventid;
	}
	public void setPeventid(int peventid) {
		this.peventid = peventid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	@JsonIgnore
	public String toString() {
		return "ProjectEvent [peventid=" + peventid + ", title=" + title
				 + "]";
	}
}