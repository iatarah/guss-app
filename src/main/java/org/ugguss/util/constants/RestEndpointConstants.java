package org.ugguss.util.constants;

public enum RestEndpointConstants {
;
    public static class Constants {
        public static final String BASE_API = "/rest/ugguss/api/v1";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String GET_MEMBER_PROFILE = "profiles/{memberId}";
        public static final String REGISTER_USER = "/registration";
        public static final String ADMIN_ONLY = "/protectedbyadmin";
        public static final String STAFF_ONLY = "/protectedbystaff";
        public static final String MEMBER_CONTRIBUTION = "/member-contribution/{memberId}";
    };
}
