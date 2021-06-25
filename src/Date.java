import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Nadil on 01.07.2021
 * This Class is responsible for keeping track of
 * the date.
 */
public class Date implements Serializable, Comparable<Date> {
    private int day;
    private int month;
    private int year;
    private boolean isLeapYear = false;


    /**
     * Constructor of the class without any parameters
     */
    public Date() { }

    /**
     * Creates a new Date Object with the
     * following parameters.
     * @param day day of the date
     * @param month month of the date
     * @param year year of the date
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Checks if two objects are equal to one another.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year &&
                isLeapYear == date.isLeapYear;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }


    @Override
    public int hashCode() {
        return Objects.hash(day, month, year,isLeapYear);
    }

    @Override
    public int compareTo(Date date) {
        int result = this.getYear() - date.getYear();
        if (result == 0) {
            result = this.getMonth() - date.getMonth();
            if (result == 0) {
                result = this.getDay() - date.getDay();
                return result;
            }
            return result;
        }
        return result;
    }


    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if (getMonth() == 1 || getMonth() == 3 || getMonth() == 5 || getMonth() == 7 ||getMonth() == 8 ||getMonth() == 10 ||getMonth() == 12) {
            if (1 <= day && day <= 31) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Day should be an integer between 1 and 31.");
            }
        } else if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11) {
            if (1 <= day && day <= 30) {
                this.day = day;
            } else {
                throw new IllegalArgumentException("Day should be an integer between 1 and 31.");
            }
        } else if (getMonth() == 2) {
            if (isLeapYear) {
                if (1 <= day && day <= 29) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Day should be an integer between 1 and 29.");
                }
            } else {
                if (1 <= day && day <= 28) {
                    this.day = day;
                } else {
                    throw new IllegalArgumentException("Day should be an integer between 1 and 28.");
                }
            }
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if (month <= 12 && month >= 1) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Month should be an integer between 1 and 12.");
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if (year % 4 == 0 && year >= 0) {
            this.isLeapYear = true;
            this.year = year;
        } else if (year >= 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Year should be 0 or a positive integer.");
        }
    }
}
