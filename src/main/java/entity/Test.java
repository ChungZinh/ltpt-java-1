/*
 * @ (#) $NAME.java         2/26/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package entity;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 2/26/2024
 */
public class Test {
    private Date date;
    private String result;
    private int testId;
    private String testType;
    private Double cost;

    public Test() {
    }

    public Test(Date date, String result, int testId, String testType, Double cost) {
        this.date = date;
        this.result = result;
        this.testId = testId;
        this.testType = testType;
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Test{" +
                "date=" + date +
                ", result='" + result + '\'' +
                ", testId=" + testId +
                ", testType='" + testType + '\'' +
                ", cost=" + cost +
                '}';
    }
}
