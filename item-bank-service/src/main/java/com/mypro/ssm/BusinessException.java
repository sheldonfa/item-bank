package com.mypro.ssm;

import com.mypro.ssm.common.CodeMsg;

public class BusinessException extends Exception {

    private CodeMsg codeMsg;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(CodeMsg message) {
        super(message.getMessage());
        this.codeMsg = message;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
