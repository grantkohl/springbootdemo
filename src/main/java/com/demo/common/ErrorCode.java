package com.demo.common;
/**
 * 错误信息枚举类
 *
 * @author zzb
 * @version 1.1.0 2017/06/20
 */
public enum ErrorCode {
	/**公共错误码**/
	MY_ERROR(9000, ""),//自定义错误
	CONFIG_ERROR(9001, "配置缺失"),
	DB_ERROR(9002, "数据库访问报错"),
	DATA_NOT_EXIST_ERROR(9003, "数据不存在"),
	DATA_CONVERTER_ERROR(9004, "数据转换失败"),
	ACTION_OPERATE_INFO_ERROR(9005, "操作信息缺失"),
	DUPLICATE(9006, "重复"),
	STORE_SERVER_ERROR(9007, "库存server异常"),

	PARAM_ERROR(100001, "参数非法"),
	PARAM_OUT_RANGE_ERROR(100002, "参数的值超出范围"),

	DB_INSERT_ERROR(200003,"数据入库失败"),
	DB_UPDATE_ERROR(200004, "数据更新失败"),
	DB_DELETE_ERROR(200005, "数据删除失败"),

	SYSTEM_ERROR(999999, "接口异常");
	private Integer code;
	private String message;

	private ErrorCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
