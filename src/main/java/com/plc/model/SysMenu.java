package com.plc.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id; // ID
	@Column(nullable = false)
	private String menuName; // 菜单名
    @Column(nullable = false)
    private long parentId; // 父ID
    @Column(nullable = false)
    private String parentName; // 父ID
    @Column(nullable = true)
    private long url; // url地址
    @Column(nullable = true)
    private long sort; // 排序
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=SysButton.class)
    @JoinColumns(@JoinColumn(name = "menuId", referencedColumnName = "id"))
    private List<SysButton> buttons = new ArrayList<SysButton>();

	public SysMenu() {
		super();
	}


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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getUrl() {
        return url;
    }

    public void setUrl(long url) {
        this.url = url;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }


    public List<SysButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<SysButton> buttons) {
        this.buttons = buttons;
    }
}
