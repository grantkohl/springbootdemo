package com.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品(SPU)的扣点信息-带缓存
 */
public class ProductKickbackInfoCacheDto implements Serializable {


	private static final long serialVersionUID = -5892279789165614781L;

	/**
	 * 商品的Id(SPU)
	 */
	private Long pid;

	/**
	 * 这一条扣点记录的到期时间
	 */
	private Date kickbackEndTime;
	/**
	 * 技术服务费,例如10表示10%
	 */
	private BigDecimal technicalCost;
	/**
	 * 运营服务费,例如10表示10%
	 */
	private BigDecimal operationCost;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Date getKickbackEndTime() {
		return kickbackEndTime;
	}

	public void setKickbackEndTime(Date kickbackEndTime) {
		this.kickbackEndTime = kickbackEndTime;
	}

	public BigDecimal getTechnicalCost() {
		return technicalCost;
	}

	public void setTechnicalCost(BigDecimal technicalCost) {
		this.technicalCost = technicalCost;
	}

	public BigDecimal getOperationCost() {
		return operationCost;
	}

	public void setOperationCost(BigDecimal operationCost) {
		this.operationCost = operationCost;
	}
}
