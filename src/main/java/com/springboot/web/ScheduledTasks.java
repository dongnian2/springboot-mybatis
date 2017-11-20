package com.springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.entity.JXCkxx;
import com.springboot.entity.goods.DbConfigParam;
import com.springboot.entity.goods.DbGoods;
import com.springboot.entity.goods.DbGoodsType;
import com.springboot.mapper.mysql.goods.DbConfigParamDao;
import com.springboot.mapper.mysql.goods.DbGdsBatchDao;
import com.springboot.mapper.mysql.goods.DbGdsIndetailDao;
import com.springboot.mapper.mysql.goods.DbGdsInputDao;
import com.springboot.mapper.mysql.goods.DbGdsPropDao;
import com.springboot.mapper.mysql.goods.DbGoodsDao;
import com.springboot.mapper.mysql.goods.DbGoodsTypeDao;
import com.springboot.mapper.mysql.goods.DbWarehouseDao;
import com.springboot.mapper.sqlserver.SqlserverMapper;
import com.springboot.utils.IdGen;



/**
 * quartz 任务
 *  
*/

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks{
    @Autowired
    private SqlserverMapper sqlserverMapper;

	@Autowired
	private DbGdsBatchDao dbGdsBatchDao;
	@Autowired
	private DbGdsIndetailDao dbGdsIndetailDao;
	@Autowired
	private DbGdsInputDao dbGdsInputDao;
	@Autowired
	private DbGdsPropDao dbGdsPropDao;
	@Autowired
	private DbGoodsDao dbGoodsDao;
	@Autowired
	private DbGoodsTypeDao dbGoodsTypeDao;
	@Autowired
	private DbWarehouseDao dbWarehouseDao;
	@Autowired
	private DbConfigParamDao dbConfigParamDao;
	
    /*@Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
    }*/

    @Scheduled(cron = "0/15 * * * * ?")
    //@Scheduled(cron = "0 0 0 1/1 * ?")//每1天
    //0 0 0 1/3 * ?  每3天
    public void reportCurrentByCron(){
    	//接口数据库视图信息
    	List<JXCkxx> viewList = sqlserverMapper.findView();
    	String sysInterfaceGuid = getConfigParam("sys_interface_guid");
    	Long sysInterfaceGuidL = Long.valueOf(sysInterfaceGuid);
    	
    	/**
    	 * 清洗数据
    	 */
    	/*
    	 * 判断本地数据库最后一次同步数据的id,如果接口数据库的GUID > 本数据库的最后同步id 则插入 此条
    	 */
    	List<JXCkxx> insterList = new ArrayList<JXCkxx>();
    	try {
    		for (JXCkxx jxCkxx : viewList) {
        		Long guid = Long.valueOf(jxCkxx.getGuid());
    			if(guid > sysInterfaceGuidL){
    				//insterList.add(jxCkxx);
    				//物料信息
    				DbGoods dbGoods  = new DbGoods();
    				dbGoods.setId(IdGen.uuid());
    				dbGoods.setGoodsType(new DbGoodsType(jxCkxx.getFldm()));//物料类型 --本地数据 物料类型是否存在 不存在是否自动添加物料类型 ..添加时其他字段如何补充 ?
    				dbGoods.setGdsName(jxCkxx.getWpmc());//物料名称
    				dbGoods.setGdsCode(jxCkxx.getWpdm());//物料编号
    				dbGoods.setGdsSpec(jxCkxx.getGg());//规格型号
    				dbGoods.setGdsUnit(jxCkxx.getDw());//单位
    				dbGoods.setGdsDesc(null);//备注无
    				try {
	    				DbGoods isGoods = dbGoodsDao.findDbGoodsByGdsName(dbGoods);
	    				//根据物料料名称判断此物料是否已存在,如果存在则更新批次,如果不存在则添加该物料并且添加为第一批次
    					if(isGoods != null){
    						//直接插入,添加批次为第一批次 ,库存
    						//dbGoodsDao.insert(dbGoods);
        				}else{
        					//更新批次
        					//dbGoodsDao.update(dbGoods);
        					
        				}
    				}catch (org.mybatis.spring.MyBatisSystemException e) {
    					System.out.println("org.mybatis.spring.MyBatisSystemException 异常");
					}catch (TooManyResultsException e){
    					System.out.println("返回多条");
    					e.printStackTrace();
    				}
    				
    			}
    		}
        	
    		
        	
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    
    /**
     * 获取参数设置里面的值。
     */
    public String getConfigParam(String paramName){
    	List<DbConfigParam> list = dbConfigParamDao.findList(new DbConfigParam());
    		
    	for(DbConfigParam retParam : list){
    		if(paramName.equals(retParam.getParamName())){
    			return retParam.getParamValue();
    		}
    	}
    	return "";
    }
    
}