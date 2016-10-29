package tk.zhangh.mybatis.mappers;

import org.apache.ibatis.annotations.Select;
import tk.zhangh.mybatis.domain.Address;

/**
 * Created by ZhangHao on 2016/10/28.
 */
public interface AddressMapper {
    @Select("select addr_id as addrId, street, city, state, zip, country from addresses where addr_id=#{id}")
    Address selectAddressById(int id);
}
