package com.plc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
public class Vedio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id; // ID
	@Column(nullable = false)
	private String vedioName; // 电影名
	@Column(nullable = false)
	private Long vedioTypeId; // 电影类型
	@Column(nullable = false)
	private String vedioTypeName; // 电影类型
	@Column(nullable = true)
	private String mainActor; // 主演
	@Column(nullable = false, columnDefinition = "int default 0")
	private int playTimes; // 播放次数
	@Column(nullable = true)
	private String imgUrl; // 图片路径
	@Column(nullable = true)
	private String vedioUrl; // 电影路径

	public Vedio() {
		super();
	}

	public Vedio(Long id, String vedioName, Long vedioTypeId, String vedioTypeName, String mainActor, int playTimes,
			String imgUrl, String vedioUrl) {
		super();
		this.id = id;
		this.vedioName = vedioName;
		this.vedioTypeId = vedioTypeId;
		this.vedioTypeName = vedioTypeName;
		this.mainActor = mainActor;
		this.playTimes = playTimes;
		this.imgUrl = imgUrl;
		this.vedioUrl = vedioUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVedioName() {
		return vedioName;
	}

	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}

	public Long getVedioTypeId() {
		return vedioTypeId;
	}

	public void setVedioTypeId(Long vedioTypeId) {
		this.vedioTypeId = vedioTypeId;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	public int getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(int playTimes) {
		this.playTimes = playTimes;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getVedioUrl() {
		return vedioUrl;
	}

	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	public String getVedioTypeName() {
		return vedioTypeName;
	}

	public void setVedioTypeName(String vedioTypeName) {
		this.vedioTypeName = vedioTypeName;
	}

}
