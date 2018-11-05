/**
 * 
 */
package com.ahstu.web.pojo;

import java.util.Date;

/**
 * 商品实体对象
 * 
 * @author wss
 *
 */

public class Priduct {
	private Integer pid;
	private String pname;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String pdesc;
	private Integer is_hot;
	private Date pdate;

	public Integer getPid() {
		return pid;
	}

	/**
	 * @param pid
	 *            the pid to set
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname
	 *            the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the market_price
	 */
	public Double getMarket_price() {
		return market_price;
	}

	/**
	 * @param market_price
	 *            the market_price to set
	 */
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	/**
	 * @return the shop_price
	 */
	public Double getShop_price() {
		return shop_price;
	}

	/**
	 * @param shop_price
	 *            the shop_price to set
	 */
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the pdesc
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * @param pdesc
	 *            the pdesc to set
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * @return the is_hot
	 */
	public Integer getIs_hot() {
		return is_hot;
	}

	/**
	 * @param is_hot
	 *            the is_hot to set
	 */
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	/**
	 * @return the pdate
	 */
	public Date getPdate() {
		return pdate;
	}

	/**
	 * @param pdate
	 *            the pdate to set
	 */
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}


}
