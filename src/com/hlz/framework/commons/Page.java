package com.hlz.framework.commons;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Henryhlz
 */
public class Page implements Serializable {
    private int currentPageNum;//当前页
    private int totalRecords;//总数
    private int firstResult;//开始行数
    private int maxResults = 5;//要查询的数量,默认为5条
    private int totalPageNum;//总页数
    private int upPageNum;//上一页
    private int nextPageNum;//下一页
    private List records;//查询结果集
    //用于显示页码的属性。我们的需求就是页面上最多只显示9个页码。当前页在允许的情况下永远居中
    private int beginPageNum;//开始页数
    private int endPageNum;//结束页数

    /**
     * 该构造器要查询结果集的数量,默认为5条
     *
     * @param currentPageNum 当前页
     * @param totalRecords   总数
     */
    public Page(int currentPageNum, int totalRecords) {
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;
        //初始化数据
        this.init();

    }

    /**
     * 该构造器可以手动输入要查询结果集的数量
     *
     * @param currentPageNum 当前页
     * @param totalRecords   总数
     * @param maxResults     要查询结果集的数量
     */
    public Page(int currentPageNum, int totalRecords, int maxResults) {
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;
        this.maxResults = maxResults;

        //初始化数据
        this.init();
    }

    private void init() {
        //计算总页数
        totalPageNum = totalRecords % maxResults == 0 ? totalRecords / maxResults : totalRecords / maxResults + 1;
        //计算开始行数
        firstResult = (currentPageNum - 1) * maxResults;
        //用于显示页码的属性。我们的需求就是页面上最多只显示9个页码。当前页在允许的情况下永远居中
        if (totalPageNum < 9) {
            beginPageNum = 1;
            endPageNum = totalPageNum;
        } else {
            beginPageNum = currentPageNum - 4;
            endPageNum = currentPageNum + 4;
            if (beginPageNum < 1) {
                beginPageNum = 1;
                endPageNum = beginPageNum + 8;
            }
            if (endPageNum > totalPageNum) {
                endPageNum = totalPageNum;
                beginPageNum = endPageNum - 8;
            }
        }
    }

    public int getUpPageNum() {
        upPageNum = currentPageNum - 1;
        if (upPageNum < 1)
            upPageNum = 1;
        return upPageNum;
    }

    public int getNextPageNum() {
        nextPageNum = currentPageNum + 1;
        if (nextPageNum > totalPageNum)
            nextPageNum = totalPageNum;
        return nextPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }


    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public void setUpPageNum(int upPageNum) {
        this.upPageNum = upPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getBeginPageNum() {
        return beginPageNum;
    }

    public void setBeginPageNum(int beginPageNum) {
        this.beginPageNum = beginPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
