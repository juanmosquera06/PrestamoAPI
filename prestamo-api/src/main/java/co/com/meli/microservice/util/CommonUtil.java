/**
 * 
 */
package co.com.meli.microservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public static Date parseStringToDate(String date, String format)
            throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.parse(date);
    }
    
    public static Date parseStringToEndDate(String date, String format)
            throws ParseException {
        Date endDate = null;
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        
        DateFormat dateFormat = new SimpleDateFormat(format);
        endDate = calendar.getTime();

        return dateFormat.parse(dateFormat.format(endDate));
    }

    public static Double calculateLoanDebt(Loan loan, List<Payment> payments) {
        Double sumLoanPayments = null;

        sumLoanPayments = payments.stream()
                .mapToDouble(Payment::getAmount).sum();

        return loan.getAmount() - sumLoanPayments;
    }
}
