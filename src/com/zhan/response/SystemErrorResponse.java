package com.zhan.response;

import com.zhan.utils.Const;

 

public class SystemErrorResponse extends CommonResponse {

	private static final long serialVersionUID = -7927296760107523634L;

	public SystemErrorResponse() {
		this.setCode(Const.RESPONSE_CODE_SYSTEM_ERROR);
		this.setMsg(Const.RESPONSE_CODE_SYSTEM_ERROR_MESSAGE);
	}

}
