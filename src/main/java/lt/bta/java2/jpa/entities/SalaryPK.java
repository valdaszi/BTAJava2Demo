package lt.bta.java2.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SalaryPK implements Serializable {

    @Id
    @Column(name = "emp_no", nullable = false)
    private int empNo;

    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
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
        SalaryPK salaryPK = (SalaryPK) o;
        return empNo == salaryPK.empNo &&
                Objects.equals(fromDate, salaryPK.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, fromDate);
    }
}
