package com.plc.util;

/**
 * Created by robin on 11/26/16.
 */
public class ErrMsg {
    public static final int    SUCCESS = 0;
    public static final String SUCCESS_STRING = "";
    public static final int    USER_NOT_EXIST = 1;
    public static final String USER_NOT_EXIST_STRING = "用户不存在";
    public static final int    USER_ALREADY_EXIST = 2;
    public static final String USER_ALREADY_EXIST_STRING = "用户已存在";
    public static final int    PASSWD_INCORRECT = 3;
    public static final String PASSWD_INCORRECT_STRING = "密码输入错误";
    public static final int    VERIFY_TOKEN_INCORRECT = 4;
    public static final String VERIFY_TOKEN_INCORRECT_STRING = "验证码输入错误";
    public static final int    USER_NOT_LOGIN = 5;
    public static final String USER_NOT_LOGIN_STRING = "用户未登录";
    public static final int    PERMISSION_DENIED = 6;
    public static final String PERMISSION_DENIED_STRING = "没有操作权限";
    public static final int    RECORD_NOT_EXIST = 7;
    public static final String RECORD_NOT_EXIST_STRING = "记录不存在";
    public static final int    INPUT_DATA_FORMAT_EXCEPTION = 8;
    public static final String INPUT_DATA_FORMAT_EXCEPTION_STRING = "url参数错误";
    public static final int    POST_DATA_FORMAT_EXCEPTION = 100;
    public static final String POST_DATA_FORMAT_EXCEPTION_STRING = "上传数据格式错误";
    public static final int    SERVER_SEND_VERIFY_TOKEN_EXCEPTION = 101;
    public static final String SERVER_SEND_VERIFY_TOKEN_EXCEPTION_STRING = "服务器发送验证码失败";
    public static final int    SERVER_EXCEPTION = 102;
    public static final String SERVER_EXCEPTION_STRING = "服务器异常";
    public static final int    DB_SELECT_EXCEPTION = 103;
    public static final String DB_SELECT_EXCEPTION_STRING = "数据库查询失败";
    public static final int    DB_INSERT_EXCEPTION = 104;
    public static final String DB_INSERT_EXCEPTION_STRING = "数据库插入失败";
    public static final int    DB_UPDATE_EXCEPTION = 105;
    public static final String DB_UPDATE_EXCEPTION_STRING = "数据库更新失败";
    public static final int    DB_DELETE_EXCEPTION = 106;
    public static final String DB_DELETE_EXCEPTION_STRING = "数据库删除失败";
    public static final int    UNKNOWN_SERVER_EXCEPTION = 201;
    public static final String UNKNOWN_SERVER_EXCEPTION_STRING = "未知服务器异常";
    public static final int    ABNORMAL_OPERATION = 301;
    public static final String ABNORMAL_OPERATION_STRING = "异常操作";
    public static final int    DISABLE_OPTION = 402;
    public static final String DISABLE_OPTION_STRING = "无效的选项信息";
    public static final int    OUTPURCHASE_OPTION = 403;
    public static final String OUTPURCHASE_OPTION_STRING = "购买上限";
    public static final int   PUSH_FAILURE = 601;
    public static final String PUSH_FAILURE_STRING = "消息推送失败";
    public static final int   PUSH_DELETE = 602;
    public static final String PUSH_DELETE_STRING = "推送消息删除失败";
    public static final int   PUSH_UPDATE = 603;
    public static final String PUSH_UPDATE_STRING = "推送消息更新失败";

    private int errCode;
    private boolean ok;
    private String message;
    private Object data;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ErrMsg() {
        new ErrMsg(SUCCESS);
    }

    public ErrMsg(int errCode) {
        switch (errCode) {
            case SUCCESS:
                this.NewErrMsg(SUCCESS, true, SUCCESS_STRING); break;
            case USER_NOT_EXIST:
                this.NewErrMsg(USER_NOT_EXIST, false, USER_NOT_EXIST_STRING); break;
            case USER_ALREADY_EXIST:
                this.NewErrMsg(USER_ALREADY_EXIST, false, USER_ALREADY_EXIST_STRING); break;
            case PASSWD_INCORRECT:
                this.NewErrMsg(PASSWD_INCORRECT, false, PASSWD_INCORRECT_STRING); break;
            case VERIFY_TOKEN_INCORRECT:
                this.NewErrMsg(VERIFY_TOKEN_INCORRECT, false, VERIFY_TOKEN_INCORRECT_STRING); break;
            case USER_NOT_LOGIN:
                this.NewErrMsg(USER_NOT_LOGIN, false, USER_NOT_LOGIN_STRING); break;
            case PERMISSION_DENIED:
                this.NewErrMsg(PERMISSION_DENIED, false, PERMISSION_DENIED_STRING); break;
            case RECORD_NOT_EXIST:
                this.NewErrMsg(RECORD_NOT_EXIST, false, RECORD_NOT_EXIST_STRING); break;
            case POST_DATA_FORMAT_EXCEPTION:
                this.NewErrMsg(POST_DATA_FORMAT_EXCEPTION, false, POST_DATA_FORMAT_EXCEPTION_STRING); break;
            case INPUT_DATA_FORMAT_EXCEPTION:
                this.NewErrMsg(INPUT_DATA_FORMAT_EXCEPTION, false, INPUT_DATA_FORMAT_EXCEPTION_STRING); break;
            case SERVER_SEND_VERIFY_TOKEN_EXCEPTION:
                this.NewErrMsg(SERVER_SEND_VERIFY_TOKEN_EXCEPTION, false, SERVER_SEND_VERIFY_TOKEN_EXCEPTION_STRING); break;
            case SERVER_EXCEPTION:
                this.NewErrMsg(SERVER_EXCEPTION, false, SERVER_EXCEPTION_STRING); break;
            case DB_SELECT_EXCEPTION:
                this.NewErrMsg(DB_SELECT_EXCEPTION, false, DB_SELECT_EXCEPTION_STRING); break;
            case DB_INSERT_EXCEPTION:
                this.NewErrMsg(DB_INSERT_EXCEPTION, false, DB_INSERT_EXCEPTION_STRING); break;
            case DB_UPDATE_EXCEPTION:
                this.NewErrMsg(DB_UPDATE_EXCEPTION, false, DB_UPDATE_EXCEPTION_STRING); break;
            case DB_DELETE_EXCEPTION:
                this.NewErrMsg(DB_DELETE_EXCEPTION, false, DB_DELETE_EXCEPTION_STRING); break;
            case ABNORMAL_OPERATION:
                this.NewErrMsg(ABNORMAL_OPERATION, false, ABNORMAL_OPERATION_STRING); break;
            case OUTPURCHASE_OPTION:
                this.NewErrMsg(OUTPURCHASE_OPTION, false, OUTPURCHASE_OPTION_STRING); break;
            case DISABLE_OPTION:
                this.NewErrMsg(DISABLE_OPTION, false, DISABLE_OPTION_STRING); break;
            case PUSH_FAILURE:
                this.NewErrMsg(PUSH_FAILURE, false, PUSH_FAILURE_STRING); break;
           case PUSH_DELETE:
                this.NewErrMsg(PUSH_DELETE, false, PUSH_DELETE_STRING); break;
            case PUSH_UPDATE:
                this.NewErrMsg(PUSH_UPDATE, false, PUSH_UPDATE_STRING); break;
            default:
                this.NewErrMsg(UNKNOWN_SERVER_EXCEPTION, false, UNKNOWN_SERVER_EXCEPTION_STRING); break;
        }
    }

    public ErrMsg(int errCode, boolean ok, String message) {
        this.errCode = errCode;
        this.ok = ok;
        this.message = message;
    }

    private void NewErrMsg(int errCode, boolean ok, String message) {
        this.errCode = errCode;
        this.ok = ok;
        this.message = message;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
