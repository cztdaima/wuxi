package volunteer.constant;

public enum ReturnMsgEnum {
    /**
     * 使用者：框架.
     *
     * 碰到未知异常时，例如数据库异常，未捕获的各种异常时填入.
     */
    UNKNOWN_FAILURE("999999", "系统内部错误"),

    /**
     * 使用者：框架+业务代码.
     *
     * 告诉ESB这次RPC在技术成功了.
     *
     * 框架会将这里变成返回的默认值. 使用者不需要手动设置.
     */
    SUCCESS("000000", "成功"),

    DATABASE_EXCEPTION("999999","数据维护失败"),
    /**
     * RPC.
     * 调用外部接口异常.
     */
    CALL_EXCEPTION("500001","下游服务异常"),
    /**
     * RPC.
     * 调用外部接口业务失败.
     */
    CALL_FAIL("500002","下游服务失败")

    ;

    /**
     * 响应状态，成功或者失败等等.
     */
    private final String code;

    /**
     * 响应信息，给人看，程序不使用.
     */
    private final String message;

    ReturnMsgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    /**
     * @param code 代码值
     * @return 用code查询枚举
     */
    public static ReturnMsgEnum findEnmuByCode(String code){

        for(ReturnMsgEnum one : ReturnMsgEnum.values()){
            if(one.getCode().equals(code)){
                return one;
            }
        }

        return null;

    }
}
