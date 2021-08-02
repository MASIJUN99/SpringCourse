package com.Sample.domain;

public class Sale {
    private Integer id;
    private Integer gid;
    private Integer nums;

    public Sale() {
    }

    public Sale(Integer id, Integer gid, Integer nums) {
        this.id = id;
        this.gid = gid;
        this.nums = nums;
    }

    public Integer getId() {
        return id;
    }

    public Integer getGid() {
        return gid;
    }

    public Integer getNums() {
        return nums;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
