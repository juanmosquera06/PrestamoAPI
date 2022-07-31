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
 * @author juan.mosquera
 *
 */
public class CommonUtil {

    private CommonUtil() {
    }

    public static Double calculateMonthlyRate(Double rate) {
        return rate / Constant.COMMON_INTEGER_NUMBER_OF_MONTHS;
    }

    public static Double calculateLoanInstallment(Double rate, Integer term, Double amount) {
        return (rate + (rate / (Math.pow((1 + rate), term) - 1))) * amount;
    }

    public static LocalDateTime parseStringToEndOfDayDate(String date,
            String format)
            throws IllegalArgumentException, DateTimeParseException {
        return parseStringToStartOfDayDate(date, format).plusHours(23)
                .plusMinutes(59).plusSeconds(59);
    }

    public static LocalDateTime parseStringToStartOfDayDate(String date,
            String format)
            throws IllegalArgumentException, DateTimeParseException {
        return parseStringToDate(date, format).atStartOfDay();
    }

    public static LocalDate parseStringToDate(String date, String format)
            throws IllegalArgumentException, DateTimeParseException
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);

        return LocalDate.parse(date, dateFormat);
    }

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

        return estimatedDebt - (sumEstimatedPayments - sumLoanPayments);
    }

    public static Double calculateLoanDebt(Loan loan, List<Payment> payments) {
        Double sumLoanPayments = null;
        Double totalLoanDebt = null;

        totalLoanDebt = loan.getInstallment() * loan.getTerm();

        sumLoanPayments = payments.stream().mapToDouble(Payment::getAmount)
                .sum();

        return totalLoanDebt - sumLoanPayments;
    }
}
