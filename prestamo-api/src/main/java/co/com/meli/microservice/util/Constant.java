/**
 * 
 */
package co.com.meli.microservice.util;

/**
 * @author juan.mosquera
 *
 */
public class Constant {

    private Constant() {
    }

    public static final String COMMON_STRING_CREATION_USER = "ADMIN";
    public static final Integer COMMON_INTEGER_STATUS = 1;

    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_LOAN = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_LOAN = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_LOAN = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_LOAN = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_LOAN = "integer not null comment 'Loan status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_TERM_LOAN = "integer not null comment 'Loan terms'";
    public static final String COLUMN_DEFINITION_STRING_RATE_LOAN = "double not null comment 'Loan interest rate'";
    public static final String COLUMN_DEFINITION_STRING_AMOUNT_LOAN = "double not null comment 'Loan amount'";
    public static final String COLUMN_DEFINITION_STRING_INSTALLMENT_LOAN = "double not null comment 'Monthly loan installment'";
    public static final String COLUMN_DEFINITION_STRING_DESCRIPTION_LOAN = "varchar(200) comment 'Offer campaign name'";

    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_PAYMENT = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_AMOUNT_PAYMENT = "double not null comment 'Payment amount'";

    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_CLIENT = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_CLIENT = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_CLIENT = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_CLIENT = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_CLIENT = "integer not null comment 'Client status. Active=1, Inactive=0'";

}
