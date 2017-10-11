package com.plc.util;

import org.springframework.data.domain.Page;

/**
 * Created by robin on 11/26/16.
 */
public class Util {
    public static ErrMsg gageToErrMsg(Page page){
        ErrMsg errMsg = null;
        if(page.getTotalElements() == 0){
            errMsg = new ErrMsg(ErrMsg.RECORD_NOT_EXIST);
        }else{
            errMsg = new ErrMsg(ErrMsg.SUCCESS);
        }
        errMsg.setData(page.getContent());
        errMsg.setCount((int)page.getTotalElements());
        return errMsg;
    }
}
