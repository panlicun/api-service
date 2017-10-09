package com.plc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SysButton implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id; // ID
	@Column(nullable = false)
	private String buttonName; // 按钮名
    @Column(nullable = false)
    private long menuId; // 菜单ID
    @Column(nullable = false)
    private String menuName; // 菜单名称
    @Column(nullable = true)
    private long sort; // 排序


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }
}
