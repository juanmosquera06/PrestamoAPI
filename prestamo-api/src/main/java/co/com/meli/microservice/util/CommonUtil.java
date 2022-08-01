/**
 * 
 */
package co.com.meli.microservice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;

import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;

/**
 * Common Utilities Class.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public class CommonUtil {

    /**
     * Class constructor.
     */
    private CommonUtil() {
    }

    /**
     * Calculates monthly rate of loan.
     * 
     * @param rate
     *            loan rate.
     * @return value of rate calculated.
     */
    public static Double calculateMonthlyRate(Double rate) {
        return rate / Constant.COMMON_INTEGER_NUMBER_OF_MONTHS;
    }

    /**
     * Calculates loan installment.
     * 
     * @param rate
     *            loan rate.
     * @param term
     *            loan term.
     * @param amount
     *            loan amount.
     * @return value of installment calculated.
     */
    public static Double calculateLoanInstallment(Double rate, Integer term, Double amount) {
        return (rate + (rate / (Math.pow((1 + rate), term) - 1))) * amount;
    }

    /**
     * Converts a text string to a date with end time of day.
     * 
     * @param date
     *            text string.
     * @param format
     *            pattern.
     * @return a date
     * @throws IllegalArgumentException
     *             if text to convert is invalid or incomplete.
     * @throws DateTimeParseException
     *             if an error occurred parsing text string.
     */
    public static LocalDateTime parseStringToEndOfDayDate(String date,
            String format)
            throws IllegalArgumentException, DateTimeParseException {
        return parseStringToStartOfDayDate(date, format).plusHours(23)
                .plusMinutes(59).plusSeconds(59);
    }

    /**
     * Converts a text string to a date with start time of day.
     * 
     * @param date
     *            text string.
     * @param format
     *            pattern.
     * @return a date
     * @throws IllegalArgumentException
     *             if text to convert is invalid or incomplete.
     * @throws DateTimeParseException
     *             if an error occurred parsing text string.
     */
    public static LocalDateTime parseStringToStartOfDayDate(String date,
            String format)
            throws IllegalArgumentException, DateTimeParseException {
        return parseStringToDate(date, format).atStartOfDay();
    }

    /**
     * Converts a text string to a date.
     * 
     * @param date
     *            text string.
     * @param format
     *            pattern.
     * @return a date
     * @throws IllegalArgumentException
     *             if text to convert is invalid or incomplete.
     * @throws DateTimeParseException
     *             if an error occurred parsing text string.
     */
    public static LocalDate parseStringToDate(String date, String format)
            throws IllegalArgumentException, DateTimeParseException
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);

        return LocalDate.parse(date, dateFormat);
    }

    /**
     * Calculates loan debt with a date filter.
     * 
     * @param loan
     *            loan.
     * @param payments
     *            loan payments.
     * @param dateFilter
     *            date filter.
     * @return the value of debt.
     */
    public static Double calculateLoanDebt(Loan loan, List<Payment> payments,
            LocalDateTime dateFilter) {
        Double sumLoanPayments = null;
        Double totalLoanDebt = null;
        Double sumEstimatedPayments = null;
        Double estimatedDebt = null;
        Long diffBetweenDates = null;

        diffBetweenDates = ChronoUnit.MONTHS.between(loan.getCreationDate(),
                dateFilter);
        if (diffBetweenDates > loan.getTerm()) {
            diffBetweenDates = Long.valueOf(loan.getTerm().longValue());
        }

        sumEstimatedPayments = loan.getInstallment()
                * diffBetweenDates;

        totalLoanDebt = loan.getInstallment() * loan.getTerm();

        estimatedDebt = totalLoanDebt - sumEstimatedPayments;

        sumLoanPayments = payments.stream()
                .mapToDouble(Payment::getAmount).sum();

        return estimatedDebt - sumLoanPayments;
    }

    /**
     * Calculates loan debt.
     * 
     * @param loan
     *            loan.
     * @param payments
     *            loan payments.
     * @return the value of debt.
     */
    public static Double calculateLoanDebt(Loan loan, List<Payment> payments) {
        Double sumLoanPayments = null;
        Double totalLoanDebt = null;

        totalLoanDebt = loan.getInstallment() * loan.getTerm();

        sumLoanPayments = payments.stream().mapToDouble(Payment::getAmount)
                .sum();

        return totalLoanDebt - sumLoanPayments;
    }

    /**
     * Checks if a value of type Double is a valid number.
     * 
     * @param numberValue
     *            number value.
     * @return true if the value is a valid number or false if the value is not
     *         a valid number.
     */
    public static boolean isValidNumberValue(Double numberValue) {
        return !numberValue.isNaN() && numberValue >= 0D;
    }

    /**
     * Checks if a value of type Integer is a valid number.
     * 
     * @param numberValue
     *            number value.
     * @return true if the value is a valid number or false if the value is not
     *         a valid number.
     */
    public static boolean isValidNumberValue(Integer numberValue) {
        return numberValue >= 0D;
    }
}
