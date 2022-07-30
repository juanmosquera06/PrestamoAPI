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
    public static final Integer COMMON_INTEGER_ACTIVE_STATUS = 1;
    public static final Integer COMMON_INTEGER_NUMBER_OF_MONTHS = 12;
    public static final String COMMON_STRING_DATE_FORMAT = "yyyy-MM-dd";
    public static final String COMMON_STRING_END_DATE_FORMAT = "yyyy-MM-dd 23:59:59";

    public static final String LOAN_CONDITION_STRING_RATE = "rate";

    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_LOAN = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_LOAN = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_LOAN = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_LOAN = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_LOAN = "integer not null comment 'Loan status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_TERM_LOAN = "integer not null comment 'Loan terms'";
    public static final String COLUMN_DEFINITION_STRING_RATE_LOAN = "double not null comment 'Loan monthly interest rate'";
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
    public static final String COLUMN_DEFINITION_STRING_TYPE_NATIONAL_ID_CLIENT = "varchar(5) not null comment 'User identity document'";
    public static final String COLUMN_DEFINITION_STRING_NATIONAL_ID_CLIENT = "varchar(30) unique not null comment 'User national id'";
    public static final String COLUMN_DEFINITION_STRING_FIRST_NAME_CLIENT = "varchar(100) comment 'User first name'";
    public static final String COLUMN_DEFINITION_STRING_LAST_NAME_CLIENT = "varchar(100) comment 'User last name'";

    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_TARGET = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_TARGET = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_TARGET = "integer not null comment 'Target status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET = "varchar(20) comment 'Target name'";

    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_TARGET_CONFIG = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET_CONFIG = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET_CONFIG = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_TARGET_CONFIG = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_TARGET_CONFIG = "integer not null comment 'Target config status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_MAX_VALUE_TARGET_CONFIG = "double comment 'Defines the maximum value'";
    public static final String COLUMN_DEFINITION_STRING_MIN_VALUE_TARGET_CONFIG = "double comment 'Defines the minimum value'";
    public static final String COLUMN_DEFINITION_STRING_FIXED_VALUE_TARGET_CONFIG = "double comment 'Defines the fixed value of the target configuration'";
    public static final String COLUMN_DEFINITION_STRING_TYPE_CONFIG_TARGET_CONFIG = "integer not null comment 'Target config type. Fixed Value=1, Range Value=2'";
    public static final String COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET_CONFIG = "varchar(50) not null comment 'Configuration name'";

}
