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
    public static final String COMMON_STRING_API_RESPONSE_CODE_OK = "200";
    public static final String COMMON_STRING_API_RESPONSE_CODE_CREATED = "201";
    public static final String COMMON_STRING_API_RESPONSE_CODE_NOT_FOUND = "404";
    public static final String COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR = "500";
    public static final String COMMON_STRING_API_RESPONSE_DESCRIPTION_OK = "Successful operation";
    public static final String COMMON_STRING_API_RESPONSE_DESCRIPTION_CREATED = "Entity created";
    public static final String COMMON_STRING_API_RESPONSE_DESCRIPTION_NOT_FOUND = "The requested resource could not be found or an error occurred getting data";
    public static final String COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR = "An error occurred while processing the request";

    public static final String COMMON_STRING_DATE_FORMAT = "yyyy-MM-dd";
    public static final String COMMON_STRING_SLASH = "/";
    public static final String COMMON_STRING_ASTERIC = "*";
    public static final String COMMON_STRING_DOT = ".";
    public static final String COMMON_STRING_RIGHT_BRACKET = "}";
    public static final String COMMON_STRING_LEFT_BRACKET = "{";

    public static final String COMMON_STRING_DATE = "date";
    public static final String COMMON_STRING_TARGET = "target";
    public static final String COMMON_STRING_LOAN_ID = "loanId";
    public static final String COMMON_STRING_DATE_FROM = "dateFrom";
    public static final String COMMON_STRING_DATE_TO = "dateTo";
    public static final String COMMON_STRING_CLIENT = "client";
    public static final String COMMON_STRING_LOAN = "loan";
    public static final String COMMON_STRING_PAYMENT = "payment";
    public static final String COMMON_STRING_TARGET_CONFIG = "target_config";

    public static final String COMMON_STRING_JSONPROPERTY_BALANCE = "balance";
    public static final String COMMON_STRING_JSONPROPERTY_TIMESTAMP = "timestamp";
    public static final String COMMON_STRING_JSONPROPERTY_STATUS = "status";
    public static final String COMMON_STRING_JSONPROPERTY_ERROR = "error";
    public static final String COMMON_STRING_JSONPROPERTY_LOAN_ID = "loan_id";
    public static final String COMMON_STRING_JSONPROPERTY_INSTALLMENT = "installment";
    public static final String COMMON_STRING_JSONPROPERTY_AMOUNT = "amount";
    public static final String COMMON_STRING_JSONPROPERTY_TERM = "term";
    public static final String COMMON_STRING_JSONPROPERTY_USER_ID = "user_id";
    public static final String COMMON_STRING_JSONPROPERTY_DATE = "date";
    public static final String COMMON_STRING_JSONPROPERTY_TARGET = "target";
    public static final String COMMON_STRING_JSONPROPERTY_RATE = "rate";
    public static final String COMMON_STRING_JSONPROPERTY_ID = "id";
    public static final String COMMON_STRING_JSONPROPERTY_DEBT = "debt";

    public static final String SERVICE_STRING_PATH_ROOT = "api";
    public static final String SERVICE_STRING_DEBTS_PATH = COMMON_STRING_SLASH
            + SERVICE_STRING_PATH_ROOT + COMMON_STRING_SLASH + "debts";
    public static final String SERVICE_STRING_LOANS_PATH = COMMON_STRING_SLASH
            + SERVICE_STRING_PATH_ROOT + COMMON_STRING_SLASH + "loans";
    public static final String SERVICE_STRING_PAYMENTS_PATH = COMMON_STRING_SLASH
            + SERVICE_STRING_PATH_ROOT + COMMON_STRING_SLASH + "payments";
    public static final String SERVICE_STRING_PATH_GET_DEBT_BY_LOAN = COMMON_STRING_SLASH
            + COMMON_STRING_LEFT_BRACKET + COMMON_STRING_LOAN_ID
            + COMMON_STRING_RIGHT_BRACKET;
    public static final String SERVICE_STRING_PATH_RECORD_LOAN_PAYMENT = COMMON_STRING_SLASH
            + COMMON_STRING_LEFT_BRACKET + COMMON_STRING_LOAN_ID
            + COMMON_STRING_RIGHT_BRACKET;

    public static final String DOC_STRING_TAG_NAME_DEBT = "Debt";
    public static final String DOC_STRING_TAG_DESCRIPTION_DEBT = "Obtain the pending debt of loans";
    public static final String DOC_STRING_OPERATION_SUMMARY_GET_DEBT_BY_LOAN = "Get debt of loan";
    public static final String DOC_STRING_OPERATION_DESCRIPTION_GET_DEBT_BY_LOAN = "Returns pending balance of loan until a specified date";
    public static final String DOC_STRING_OPERATION_SUMMARY_GET_TOTAL_DEBT = "Get total debt of loans";
    public static final String DOC_STRING_OPERATION_DESCRIPTION_GET_TOTAL_DEBT = "Returns pending balance of loans until a specified date or target";

    public static final String DOC_STRING_TAG_NAME_LOAN = "Loan";
    public static final String DOC_STRING_TAG_DESCRIPTION_LOAN = "Create a loan request and get the list of loans";
    public static final String DOC_STRING_OPERATION_SUMMARY_CREATE_LOAN = "Create a loan";
    public static final String DOC_STRING_OPERATION_DESCRIPTION_CREATE_LOAN = "Create a loan request";
    public static final String DOC_STRING_OPERATION_SUMMARY_GET_LOANS_BY_DATE_RANGE = "Get all loans by date range";
    public static final String DOC_STRING_OPERATION_DESCRIPTION_GET_LOANS_BY_DATE_RANGE = "Returns all loans with date range filter";

    public static final String DOC_STRING_TAG_NAME_PAYMENT = "Payment";
    public static final String DOC_STRING_TAG_DESCRIPTION_PAYMENT = "Record a loan payment";
    public static final String DOC_STRING_OPERATION_SUMMARY_RECORD_LOAN_PAYMENT = "Record a payment";
    public static final String DOC_STRING_OPERATION_DESCRIPTION_RECORD_LOAN_PAYMENT = "Apply a loan payment";

    public static final String LOAN_CONDITION_STRING_RATE = "rate";

    public static final String ERROR_STRING_ENTITY_NOT_FOUND = "Entity %s with id %s not found";
    public static final String ERROR_STRING_NOT_DATA_FOUND = "No data found in entity %s";
    public static final String ERROR_STRING_ERROR_GETTING_LOAN_DEBT = "An error has occurred getting the loan debt";
    public static final String ERROR_STRING_PAYMENT_AMOUNT_EXCEEDS_LOAN_DEBT = "Payment amount exceeds the loan debt";
    public static final String ERROR_STRING_LOAN_RATE_NOT_FOUND = "Loan rate not found";
    public static final String ERROR_STRING_ERROR_GETTING_LOAN_INSTALLMENT = "An error has occurred getting the loan installment";
    public static final String ERROR_STRING_INVALID_PATTERN_OR_DATE_CANNOT_BE_PARSE = "Pattern is invalid or date cannot be parsed";

    public static final String REPOSITORY_STRING_CLIENT = "clientRepository";
    public static final String REPOSITORY_STRING_LOAN = "loanRepository";
    public static final String REPOSITORY_STRING_PAYMENT = "paymentRepository";
    public static final String REPOSITORY_STRING_TARGET_CONFIG = "targetConfigRepository";

    public static final String SERVICE_STRING_CLIENT = "clientService";
    public static final String SERVICE_STRING_LOAN = "loanService";
    public static final String SERVICE_STRING_PAYMENT = "paymentService";

    public static final String MAPPER_STRING_COMPONENT_MODEL = "spring";
    public static final String MAPPER_STRING_CLIENT = "client";
    public static final String MAPPER_STRING_ID = "id";
    public static final String MAPPER_STRING_USER_ID = "userId";
    public static final String MAPPER_STRING_CREATION_DATE = "creationDate";
    public static final String MAPPER_STRING_DATE = "date";
    public static final String MAPPER_STRING_TARGET = "target";
    public static final String MAPPER_STRING_LOAN_ID = "loanId";
    public static final String MAPPER_STRING_LOAN = "loan";
    public static final String MAPPER_STRING_DESCRIPTION = "description";
    public static final String MAPPER_STRING_CLIENT_DOT_ID = MAPPER_STRING_CLIENT
            + COMMON_STRING_DOT + MAPPER_STRING_ID;
    public static final String MAPPER_STRING_LOAN_DOT_ID = MAPPER_STRING_LOAN
            + COMMON_STRING_DOT + MAPPER_STRING_ID;
    public static final String MAPPER_STRING_CLIENT_DOT_TARGET_DOT_DESCRIPTION = MAPPER_STRING_CLIENT
            + COMMON_STRING_DOT + MAPPER_STRING_TARGET + COMMON_STRING_DOT
            + MAPPER_STRING_DESCRIPTION;

    public static final String TABLE_STRING_NAME_LOAN = "LOAN";
    public static final String TABLE_STRING_COMMENT_LOAN = "Stores money loans by user with the respective credit conditions";
    public static final String COLUMN_STRING_NAME_ID_LOAN = "ID_LOAN";
    public static final String COLUMN_STRING_NAME_DESCRIPTION_LOAN = "DESCRIPTION";
    public static final String COLUMN_STRING_NAME_INSTALLMENT_LOAN = "INSTALLMENT";
    public static final String COLUMN_STRING_NAME_AMOUNT_LOAN = "AMOUNT";
    public static final String COLUMN_STRING_NAME_RATE_LOAN = "RATE";
    public static final String COLUMN_STRING_NAME_TERM_LOAN = "TERM";
    public static final String COLUMN_STRING_NAME_STATUS_LOAN = "STATUS";
    public static final String COLUMN_STRING_NAME_CREATION_USER_LOAN = "CREATION_USER";
    public static final String COLUMN_STRING_NAME_CREATION_DATE_LOAN = "CREATION_DATE";
    public static final String COLUMN_STRING_NAME_MODIFICATION_USER_LOAN = "MODIFICATION_USER";
    public static final String COLUMN_STRING_NAME_MODIFICATION_DATE_LOAN = "MODIFICATION_DATE";
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

    public static final String TABLE_STRING_NAME_PAYMENT = "PAYMENT";
    public static final String TABLE_STRING_COMMENT_PAYMENT = "Stores records of payments made on a loan";
    public static final String COLUMN_STRING_NAME_ID_PAYMENT = "ID_PAYMENT";
    public static final String COLUMN_STRING_NAME_AMOUNT_PAYMENT = "AMOUNT";
    public static final String COLUMN_STRING_NAME_CREATION_DATE_PAYMENT = "CREATION_DATE";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_PAYMENT = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_AMOUNT_PAYMENT = "double not null comment 'Payment amount'";

    public static final String TABLE_STRING_NAME_CLIENT = "CLIENT";
    public static final String TABLE_STRING_COMMENT_CLIENT = "Stores the different users with their personal information";
    public static final String COLUMN_STRING_NAME_ID_CLIENT = "ID_CLIENT";
    public static final String COLUMN_STRING_NAME_FIRST_NAME_CLIENT = "FIRST_NAME";
    public static final String COLUMN_STRING_NAME_LAST_NAME_CLIENT = "LAST_NAME";
    public static final String COLUMN_STRING_NAME_NATIONAL_ID_CLIENT = "NATIONAL_ID";
    public static final String COLUMN_STRING_NAME_TYPE_NATIONAL_ID_CLIENT = "TYPE_NATIONAL_ID";
    public static final String COLUMN_STRING_NAME_STATUS_CLIENT = "STATUS";
    public static final String COLUMN_STRING_NAME_CREATION_USER_CLIENT = "CREATION_USER";
    public static final String COLUMN_STRING_NAME_CREATION_DATE_CLIENT = "CREATION_DATE";
    public static final String COLUMN_STRING_NAME_MODIFICATION_USER_CLIENT = "MODIFICATION_USER";
    public static final String COLUMN_STRING_NAME_MODIFICATION_DATE_CLIENT = "MODIFICATION_DATE";
    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_CLIENT = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_CLIENT = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_CLIENT = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_CLIENT = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_CLIENT = "integer not null comment 'Client status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_TYPE_NATIONAL_ID_CLIENT = "varchar(5) not null comment 'User identity document'";
    public static final String COLUMN_DEFINITION_STRING_NATIONAL_ID_CLIENT = "varchar(30) unique not null comment 'User national id'";
    public static final String COLUMN_DEFINITION_STRING_FIRST_NAME_CLIENT = "varchar(100) comment 'User first name'";
    public static final String COLUMN_DEFINITION_STRING_LAST_NAME_CLIENT = "varchar(100) comment 'User last name'";

    public static final String TABLE_STRING_NAME_TARGET = "TARGET";
    public static final String TABLE_STRING_COMMENT_TARGET = "Stores the different user targets";
    public static final String COLUMN_STRING_NAME_ID_TARGET = "ID_TARGET";
    public static final String COLUMN_STRING_NAME_DESCRIPTION_TARGET = "DESCRIPTION";
    public static final String COLUMN_STRING_NAME_STATUS_TARGET = "STATUS";
    public static final String COLUMN_STRING_NAME_CREATION_USER_TARGET = "CREATION_USER";
    public static final String COLUMN_STRING_NAME_CREATION_DATE_TARGET = "CREATION_DATE";
    public static final String COLUMN_STRING_NAME_MODIFICATION_USER_TARGET = "MODIFICATION_USER";
    public static final String COLUMN_STRING_NAME_MODIFICATION_DATE_TARGET = "MODIFICATION_DATE";
    public static final String COLUMN_DEFINITION_STRING_CREATION_USER_TARGET = "varchar(100) not null comment 'Audit for record creation user'";
    public static final String COLUMN_DEFINITION_STRING_CREATION_DATE_TARGET = "timestamp not null comment 'Audit for record creation date'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_USER_TARGET = "varchar(100) comment 'Audit for record modification user'";
    public static final String COLUMN_DEFINITION_STRING_MODIFICATION_DATE_TARGET = "timestamp on update current_timestamp comment 'Audit for record modification date'";
    public static final String COLUMN_DEFINITION_STRING_STATUS_TARGET = "integer not null comment 'Target status. Active=1, Inactive=0'";
    public static final String COLUMN_DEFINITION_STRING_DESCRIPTION_TARGET = "varchar(20) comment 'Target name'";

    public static final String TABLE_STRING_NAME_TARGET_CONFIG = "TARGET_CONFIG";
    public static final String TABLE_STRING_COMMENT_TARGET_CONFIG = "Stores user target settings";
    public static final String COLUMN_STRING_NAME_ID_TARGET_CONFIG = "ID_TARGET_CONFIG";
    public static final String COLUMN_STRING_NAME_DESCRIPTION_TARGET_CONFIG = "DESCRIPTION";
    public static final String COLUMN_STRING_NAME_TYPE_CONFIG_TARGET_CONFIG = "TYPE_CONFIG";
    public static final String COLUMN_STRING_NAME_FIXED_VALUE_TARGET_CONFIG = "FIXED_VALUE";
    public static final String COLUMN_STRING_NAME_MIN_VALUE_TARGET_CONFIG = "MIN_VALUE";
    public static final String COLUMN_STRING_NAME_MAX_VALUE_TARGET_CONFIG = "MAX_VALUE";
    public static final String COLUMN_STRING_NAME_STATUS_TARGET_CONFIG = "STATUS";
    public static final String COLUMN_STRING_NAME_CREATION_USER_TARGET_CONFIG = "CREATION_USER";
    public static final String COLUMN_STRING_NAME_CREATION_DATE_TARGET_CONFIG = "CREATION_DATE";
    public static final String COLUMN_STRING_NAME_MODIFICATION_USER_TARGET_CONFIG = "MODIFICATION_USER";
    public static final String COLUMN_STRING_NAME_MODIFICATION_DATE_TARGET_CONFIG = "MODIFICATION_DATE";
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

    public static final String DATABASE_STRING_SCHEMA = "CREDITDB";
}
