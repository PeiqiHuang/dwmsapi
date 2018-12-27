package com.dwms.album.dao;

import com.dwms.album.model.bean.Album;
import com.dwms.album.model.vo.AlbumVO;
import com.dwms.album.model.vo.CountVO;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 党建相册DAO接口
 * @author windy
 * @date 2018-12-17
 */
public interface IAlbumDAO extends BaseMapper<Album> {

    /**
     * 相册列表
     * @author windy
     * @date 2018-12-17
     */
    List<AlbumVO> selectByPartyId(@Param("partyId") Integer partyId);

    /**
     * 相册照片数量
     * @author windy
     * @date 2018-12-17
     */
    List<CountVO> countNums(@Param("albumIds") List<Integer> albumIds);

}
