//package com.dwms.common.component.swagger;
//
//import com.dwms.base.dao.IAdvertDAO;
//import com.dwms.base.model.form.AdvertForm;
//import com.dwms.base.model.vo.AdvertVO;
//import com.dwms.common.model.ResultBean;
//import com.github.pagehelper.PageHelper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author ChenZhiPing 2017年9月26日 上午11:14:38
// */
//@RestController
//@RequestMapping("demo")
//@Api(value = "DemoController", tags = {"10.ResultBean响应结果"}, hidden = true)
//@SuppressWarnings("unchecked")
//public class DemoController {
//
//    @Resource
//    private IAdvertDAO advertDAO;
//
//    //	@ApiOperation(value = "ResultBean«List«T»»", notes = "List类型")
//    //	@RequestMapping(value = "list", method = RequestMethod.GET)
//    //	public ResultBean<List<Advert>> list() {
//    //		try {
//    //
//    //			Object data = userDAO.selectAll();
//    //			return success(data);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//    //
//    //	@ApiOperation(value = "ResultBean«Map«B, B»»", notes = "Map类型")
//    //	@RequestMapping(value = "mapOnly", method = RequestMethod.GET)
//    //	public ResultBean<Map<String, Integer>> mapOnly() {
//    //		try {
//    //			List<Advert> data = (List<Advert>) customerService.findAll();
//    //			Map<String, Integer> map = new HashMap<String, Integer>();
//    //			if (data.size() > 0) {
//    //				for (Advert c : data) {
//    //					map.put(c.getName(), c.getId());
//    //				}
//    //			}
//    //			return success(map);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//
//    @ApiOperation(value = "ResultBean«Map«B, T»»", notes = "Map类型")
//    @RequestMapping(value = "map", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultBean<Map<String, Object>> map() {
//        PageHelper.startPage(1, 10);
//        List<AdvertVO> data = (List<AdvertVO>) advertDAO.selectSelective(new AdvertForm());
//        return ResultUtils.successBean(data);
//    }
//
//    //	@ApiOperation(value = "ResultBean«Set«T»»", notes = "Set类型")
//    //	@RequestMapping(value = "set", method = RequestMethod.GET)
//    //	public ResultBean<Set<Advert>> set() {
//    //		try {
//    //			List<Advert> data = (List<Advert>) customerService.findAll();
//    //			Set<Advert> set = new TreeSet<>();
//    //			if (data.size() > 0) {
//    //				for (Advert c : data) {
//    //					set.add(c);
//    //				}
//    //			}
//    //			return success(set);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//    //
//    //	@ApiOperation(value = "ResultBean«DBResult«T»»", notes = "DBResult类型")
//    //	@RequestMapping(value = "query", method = RequestMethod.GET)
//    //	public ResultBean<DBResult<Advert>> query() {
//    //		try {
//    //			Object data = customerService.query(new AdvertDBParam());
//    //			return success(data);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//
//    //	@ApiOperation(value = "ResultBean«B»", notes = "只有基础类型")
//    //	@RequestMapping(value = "deleteByPk", method = RequestMethod.GET)
//    //	public ResultBean<Boolean> deleteByPk() {
//    //		try {
//    //			Object data = customerService.deleteByPk(0);
//    //			return success(data);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//
//    //	@ApiOperation(value = "复杂T", notes = "复杂类型")
//    //	@RequestMapping(value = "complex", method = RequestMethod.GET)
//    //	public ResultBean<Map<Map<Long, Operator>, List<Map<String, Advert>>>> complex() {
//    //		try {
//    //			Map<Long, Operator> m1 = new HashMap<Long, Operator>();
//    //			Operator o = new Operator();
//    //			o.setOwnerIdentityId((long) 20087);
//    //			o.setDisplayName("很漂亮的操作员");
//    //			o.setLastUpdateDate(new Date());
//    //			o.setOperatorType(OperatorType.SP_OPERATOR);
//    //			o.setRemark("测试复杂的Swagger泛型展示");
//    //			m1.put(o.getOwnerIdentityId(), o);
//    //
//    //			Map<String, Advert> m2 = (Map<String, Advert>) this.map().getData();
//    //			List<Object> list = new ArrayList<Object>();
//    //			list.add(m2);
//    //
//    //			@SuppressWarnings("rawtypes")
//    //			Map map = new HashMap();
//    //			map.put(m1, list);
//    //			return success(map);
//    //		} catch (Exception e) {
//    //			return exception(e);
//    //		}
//    //	}
//}
