package com.libray2.libproject.external;

public enum ErrorCodes {
    USER_NOT_FOUND{
        @Override
        public String getErrorMessage(){
            return "User not found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Sorry this User is not registered";
        }
        @Override
        public int getErrorCode(){
            return 1000;
        }
    },    BOOK_NOT_FOUND{
        @Override
        public String getErrorMessage(){
            return "Book not found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Sorry this Book is not Available";
        }
        @Override
        public int getErrorCode(){
            return 1001;
        }
    },
    ISSUE_NOT_FOUND{
        @Override
        public String getErrorMessage(){
            return "Issue not found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Sorry this Issue is Available";
        }
        @Override
        public int getErrorCode(){
            return 1003;
        }
    },
    INVALID_PAGE_REQUEST{
        @Override
        public String getErrorMessage(){
            return "PAGE Access Denied found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Sorry you cant view this page";
        }
        @Override
        public int getErrorCode(){
            return 1004;
        }
    },    MISSING_FIELD_EXCEPTION{
        @Override
        public String getErrorMessage(){
            return "Field not found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Some Required Fields are missing";
        }
        @Override
        public int getErrorCode(){
            return 1005;
        }
    },AUTHOR_NOT_FOUND{
        @Override
        public String getErrorMessage(){
            return "Field not found";
        }
        @Override
        public String getUserErrorMessage(){
            return "Some Required Fields are missing";
        }
        @Override
        public int getErrorCode(){
            return 1006;
        }
    },;




    private static final String ERROR_MESSAGE="Unknown Error Occured";
    private static final int ERROR_CODE=7777;
    private static final String USER_ERROR_MESSAGE="Sorry,Cant process your request";
    public String getErrorMessage(){
        return ERROR_MESSAGE;
    }
    public String getUserErrorMessage(){
        return USER_ERROR_MESSAGE;
    }
    public int getErrorCode(){
        return ERROR_CODE;
    }


}
