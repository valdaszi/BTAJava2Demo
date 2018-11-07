package lt.bta.java2.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class SalaryId implements Serializable {

    @Column(name = "emp_no")
    protected Integer empNo;

    @Column(name = "from_date")
    private LocalDate fromDate;

    public SalaryId() {
    }

    public SalaryId(Integer empNo, LocalDate fromDate) {
        this.empNo = empNo;
        this.fromDate = fromDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryId salaryId = (SalaryId) o;
        return Objects.equals(empNo, salaryId.empNo) &&
                Objects.equals(fromDate, salaryId.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, fromDate);
    }
}
