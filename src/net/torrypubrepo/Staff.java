package net.torrypubrepo;

import java.util.Objects;

/*
 Created by Toriola
 */
public class Staff
{
    private String fName;
    private String lName;
    private int iD;

    public Staff(String fName, String lName, int iD) {
        this.fName = fName;
        this.lName = lName;
        this.iD = iD;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return iD == staff.iD &&
                fName.equals(staff.fName) &&
                lName.equals(staff.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, iD);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", iD=" + iD +
                '}';
    }
}//End Staff Class
